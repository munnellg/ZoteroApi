package ie.tcd.munnellg.zotero.impl;

import java.io.IOException;

import java.net.URL;
import java.net.MalformedURLException;

import java.util.List;

import ie.tcd.munnellg.zotero.util.ZoteroRequest;

import ie.tcd.munnellg.zotero.interfaces.RestEndpoint;
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

	public <T> List<T> getList(String id, String path, PrefixAssembler prefixAssembler, TypeReference<List<T>> valueTypeRef) throws JsonProcessingException, IOException
	{
		ZoteroRequest request = createRequest(id, path, prefixAssembler);

		return new ObjectMapper().readValue(request.execute(), valueTypeRef);
	}

	public <T> T getOne(String id, String path, PrefixAssembler prefixAssembler, Class<T> clazz) throws JsonProcessingException, IOException
	{
		ZoteroRequest request = createRequest(id, path, prefixAssembler);
		
		return new ObjectMapper().readValue(request.execute(), clazz);
	}

	private ZoteroRequest createRequest(String id, String path, PrefixAssembler prefixAssembler)
	{
		return ZoteroRequest.builder()
						.setPrefixAssembler(prefixAssembler)
						.setApiKey(this.apiKey)
						.setApiRoot(this.apiRoot)
						.setOwnerId(id)
						.setPath(path)
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