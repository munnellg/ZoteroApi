package ie.tcd.munnellg.zotero.impl;

import java.util.Arrays;

import java.io.IOException;

import java.net.URL;
import java.net.MalformedURLException;

import ie.tcd.munnellg.zotero.util.ZoteroList;
import ie.tcd.munnellg.zotero.util.ZoteroRequest;

import ie.tcd.munnellg.zotero.interfaces.RestEndpoint;
import ie.tcd.munnellg.zotero.interfaces.RequestParams;
import ie.tcd.munnellg.zotero.interfaces.PrefixAssembler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;

public class RestEndpointImpl implements RestEndpoint
{
	private String apiKey;
	
	private String apiRoot;

	private RestEndpointImpl(RestEndpointImplBuilder builder)
	{
		this.apiKey          = builder.apiKey;
		this.apiRoot         = builder.apiRoot;
	}

	public String getApiKey()
	{
		return apiKey;
	}

	public void setApiKey(String apiKey)
	{
		this.apiKey = apiKey;
	}

	public String getApiRoot()
	{
		return this.apiRoot;
	}

	public void setApiRoot(String apiRoot)
	{
		this.apiRoot = apiRoot;
	}

	public <T> ZoteroList<T> getList(String id, String path, PrefixAssembler prefixAssembler, TypeReference<ZoteroList<T>> valueTypeRef, RequestParams... params) throws JsonProcessingException, IOException
	{
		ZoteroRequest request = createRequest(id, path, prefixAssembler, params);

		ZoteroList response = new ObjectMapper().readValue(request.execute(), valueTypeRef);

		response.setTotalResults(request.getTotalResults());

		return response;
	}

	public <T> T getOne(String id, String path, PrefixAssembler prefixAssembler, Class<T> clazz, RequestParams... params) throws JsonProcessingException, IOException
	{
		ZoteroRequest request = createRequest(id, path, prefixAssembler, params);
		
		return new ObjectMapper().readValue(request.execute(), clazz);
	}

	private ZoteroRequest createRequest(String id, String path, PrefixAssembler prefixAssembler, RequestParams... params)
	{
		return ZoteroRequest.builder()
						.setPrefixAssembler(prefixAssembler)
						.setApiKey(this.apiKey)
						.setApiRoot(this.apiRoot)
						.setOwnerId(id)
						.setPath(path)
						.setRequestParams(Arrays.asList(params))
						.build();
	}

	public static RestEndpointImplBuilder builder()
	{
		return new RestEndpointImplBuilder();
	}

	public static class RestEndpointImplBuilder
	{
		private String apiKey;
		private String apiRoot;

		private RestEndpointImplBuilder()
		{
			this.apiKey          = null;
			this.apiRoot         = "https://api.zotero.org/";
		}
  
		public RestEndpointImplBuilder setApiKey(String apiKey)
		{
			this.apiKey = apiKey;
			return this;
		}

		public RestEndpointImplBuilder setApiRoot(String apiRoot)
		{
			this.apiRoot = apiRoot;
			return this;
		}

		public RestEndpointImpl build()
		{
			return new RestEndpointImpl(this);
		}
	}
}