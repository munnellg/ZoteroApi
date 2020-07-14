package ie.tcd.munnellg.zotero.util;

import java.net.URL;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.MalformedURLException;

import java.util.List;
import java.util.ArrayList;

import java.net.HttpURLConnection;

import java.lang.StringBuilder;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import ie.tcd.munnellg.zotero.enums.Mode;
import ie.tcd.munnellg.zotero.interfaces.RequestParams;
import ie.tcd.munnellg.zotero.interfaces.PrefixAssembler;
import ie.tcd.munnellg.zotero.factory.PrefixAssemblerFactory;

public class ZoteroRequest
{
	private static final String DEFAULT_API_ROOT       = "https://api.zotero.org/";
	private static final String DEFAULT_REQUEST_METHOD = "GET";

	private String apiKey;

	private String apiRoot;

	private String ownerId;

	private String path;

	private String requestMethod;

	private Integer retryAfter;

	private Integer backoff;

	private Integer totalResults;

	private PrefixAssembler prefixAssembler;

	private List<RequestParams> requestParams;

	public ZoteroRequest()
	{
		this(ZoteroRequest.builder());
	}

	private ZoteroRequest(ZoteroRequestBuilder builder)
	{
		this.apiKey          = builder.apiKey;
		this.apiRoot         = builder.apiRoot;
		this.ownerId         = builder.ownerId;
		this.path            = builder.path;
		this.requestMethod   = builder.requestMethod;
		this.prefixAssembler = builder.prefixAssembler;
		this.requestParams   = builder.requestParams;
	}

	public void setPrefixAssembler(PrefixAssembler prefixAssembler)
	{
		this.prefixAssembler = prefixAssembler;
	}

	public void setPrefixAssembler(Mode mode)
	{
		this.setPrefixAssembler(PrefixAssemblerFactory.assemble(mode));
	}

	public Integer getRetryAfter()
	{
		return this.retryAfter;
	}

	public void setRetryAfter(Integer retryAfter)
	{
		this.retryAfter = retryAfter;
	}

	public Integer getBackoff()
	{
		return this.backoff;
	}

	public void setBackoff(Integer backoff)
	{
		this.backoff = backoff;
	}

	public Integer getTotalResults()
	{
		return this.totalResults;
	}

	public void setTotalResults(Integer totalResults)
	{
		this.totalResults = totalResults;
	}

	private Integer getHeaderInt(HttpURLConnection con, String header)
	{
		String headerStr = con.getHeaderField(header);

		return (headerStr == null)? null : Integer.valueOf(headerStr);
	}

	private String read(HttpURLConnection con) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

		String inputLine;

		StringBuilder builder = new StringBuilder();

		while ((inputLine = in.readLine()) != null)
		{
			builder.append(inputLine);
		}

		in.close();

		switch (con.getResponseCode())
		{
		case 429:                               /* too many requests */
		case HttpURLConnection.HTTP_UNAVAILABLE:
			this.retryAfter   = getHeaderInt(con, "Retry-After");
			break;

		case HttpURLConnection.HTTP_OK:
		default:
			this.backoff      = getHeaderInt(con, "Backoff");
			this.totalResults = getHeaderInt(con, "Total-Results");
		}

		return builder.toString();
	}

	private String buildQueryString()
	{
		String queryString = "?";

		for (RequestParams param : this.requestParams)
		{
			List<String> args = param.paramsToQueryString();
			
			System.out.println(args.size());

			String argsStr = String.join("&", args);

			if (queryString.length() > 1 && argsStr.length() > 1)
			{
				queryString += "&";
			}

			if (argsStr.length() > 1)
			{
				queryString += argsStr;
			}
		}

		return (queryString.length() > 1) ? queryString : "";
	}

	public String execute() throws IOException, MalformedURLException, ProtocolException
	{
		final String prefix = this.prefixAssembler.assemble(this.ownerId);
		
		final String queryString = buildQueryString();

		final URL url = new URL(this.apiRoot + prefix + this.path + queryString);

		System.out.println(url);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod(this.requestMethod);

		con.setRequestProperty("accept", "application/json");

		con.setRequestProperty("Zotero-API-Key", this.apiKey);

		con.setRequestProperty("Zotero-API-Version", "3");
		
		return read(con);
	}

	public static ZoteroRequestBuilder builder()
	{
		return new ZoteroRequestBuilder();
	}

	public static class ZoteroRequestBuilder
	{
		private String apiKey;

		private String apiRoot;

		private String ownerId;

		private String path;

		private String requestMethod;

		private PrefixAssembler prefixAssembler;

		private List<RequestParams> requestParams;

		public ZoteroRequestBuilder()
		{
			this.apiRoot         = DEFAULT_API_ROOT;
			this.apiKey          = null;
			this.ownerId         = null;
			this.requestMethod   = DEFAULT_REQUEST_METHOD;
			this.prefixAssembler = PrefixAssemblerFactory.assemble(Mode.NONE);
			this.requestParams   = new ArrayList<RequestParams>();
		}

		public ZoteroRequestBuilder setApiRoot(String apiRoot)
		{
			this.apiRoot = apiRoot;
			return this;
		}

		public ZoteroRequestBuilder setApiKey(String apiKey)
		{
			this.apiKey = apiKey;
			return this;
		}

		public ZoteroRequestBuilder setOwnerId(String ownerId)
		{
			this.ownerId = ownerId;
			return this;
		}

		public ZoteroRequestBuilder setPath(String path)
		{
			this.path = path;
			return this;
		}

		public ZoteroRequestBuilder setPrefixAssembler(PrefixAssembler prefixAssembler)
		{
			this.prefixAssembler = prefixAssembler;
			return this;
		}

		public ZoteroRequestBuilder setPrefixAssembler(Mode mode)
		{
			return this.setPrefixAssembler(PrefixAssemblerFactory.assemble(mode));
		}

		public ZoteroRequestBuilder setRequestMethod(String requestMethod)
		{
			this.requestMethod = requestMethod;
			return this;
		}

		public ZoteroRequestBuilder setRequestParams(List<RequestParams> requestParams)
		{
			this.requestParams = requestParams;
			return this;
		}

		public ZoteroRequest build()
		{
			return new ZoteroRequest(this);
		}
	}
}