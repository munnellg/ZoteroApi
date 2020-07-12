package ie.tcd.munnellg.zotero.impl;

import java.io.IOException;

import java.util.List;

import ie.tcd.munnellg.zotero.model.SearchesResponse;

import ie.tcd.munnellg.zotero.interfaces.RestEndpoint;
import ie.tcd.munnellg.zotero.interfaces.PrefixAssembler;
import ie.tcd.munnellg.zotero.interfaces.SearchesRequestHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;

public class SearchesRequestHandlerImpl implements SearchesRequestHandler
{
	private static final String URL_SEARCHES_ALL = "searches";
	private static final String URL_SEARCHES_ONE = "searches/%s";

	private RestEndpoint restEndpoint;
	
	private PrefixAssembler prefixAssembler;

	public SearchesRequestHandlerImpl()
	{
		this(SearchesRequestHandlerImpl.builder());
	}

	private SearchesRequestHandlerImpl(SearchesRequestHandlerImplBuilder builder)
	{
		this.restEndpoint    = builder.restEndpoint;
		this.prefixAssembler = builder.prefixAssembler;
	}

	// All saved searches in the library
	public List<SearchesResponse> getAllSearches(String id) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_SEARCHES_ALL, this.prefixAssembler, new TypeReference<List<SearchesResponse>>(){});
	}
	
	// A specific saved search in the library
	public SearchesResponse getSearch(String id, String searchId) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_SEARCHES_ONE, searchId);

		return this.restEndpoint.getOne(id, path, this.prefixAssembler, SearchesResponse.class);
	}

	public static SearchesRequestHandlerImplBuilder builder()
	{
		return new SearchesRequestHandlerImplBuilder();
	}

	public static class SearchesRequestHandlerImplBuilder
	{
		private RestEndpoint restEndpoint;
		private PrefixAssembler prefixAssembler;

		private SearchesRequestHandlerImplBuilder()
		{
			this.restEndpoint    = null;
			this.prefixAssembler = null;
		}
  
		public SearchesRequestHandlerImplBuilder setRestEndpoint(RestEndpoint restEndpoint)
		{
			this.restEndpoint = restEndpoint;
			return this;
		}

		public SearchesRequestHandlerImplBuilder setPrefixAssembler(PrefixAssembler prefixAssembler)
		{
			this.prefixAssembler = prefixAssembler;
			return this;
		}

		public SearchesRequestHandlerImpl build()
		{
			return new SearchesRequestHandlerImpl(this);
		}
	}
}