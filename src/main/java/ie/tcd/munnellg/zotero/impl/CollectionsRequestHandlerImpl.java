package ie.tcd.munnellg.zotero.impl;

import java.io.IOException;

import ie.tcd.munnellg.zotero.util.ZoteroList;

import ie.tcd.munnellg.zotero.interfaces.RestEndpoint;
import ie.tcd.munnellg.zotero.interfaces.RequestParams;
import ie.tcd.munnellg.zotero.interfaces.PrefixAssembler;
import ie.tcd.munnellg.zotero.interfaces.CollectionsRequestHandler;

import ie.tcd.munnellg.zotero.model.CollectionsResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;

public class CollectionsRequestHandlerImpl implements CollectionsRequestHandler
{
	private static final String URL_COLLECTIONS_ALL             = "collections";
	private static final String URL_COLLECTIONS_TOP_LEVEL       = "collections/top";
	private static final String URL_COLLECTIONS_ONE             = "collections/%s";
	private static final String URL_COLLECTIONS_SUB_COLLECTIONS = "collections/%s/collections";

	private RestEndpoint restEndpoint;
	
	private PrefixAssembler prefixAssembler;

	private CollectionsRequestHandlerImpl()
	{
		this(CollectionsRequestHandlerImpl.builder());
	}

	private CollectionsRequestHandlerImpl(CollectionsRequestHandlerImplBuilder builder)
	{
		this.restEndpoint    = builder.restEndpoint;
		this.prefixAssembler = builder.prefixAssembler;
	}

	// Collections in the library
	public ZoteroList<CollectionsResponse> getAllCollections(String id) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_COLLECTIONS_ALL, this.prefixAssembler, new TypeReference<ZoteroList<CollectionsResponse>>(){});
	}

	public ZoteroList<CollectionsResponse> getAllCollections(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_COLLECTIONS_ALL, this.prefixAssembler, new TypeReference<ZoteroList<CollectionsResponse>>(){}, params);
	}
	
	// Top-level collections in the library
	public ZoteroList<CollectionsResponse> getTopLevelCollections(String id) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_COLLECTIONS_TOP_LEVEL, this.prefixAssembler, new TypeReference<ZoteroList<CollectionsResponse>>(){});
	}

	public ZoteroList<CollectionsResponse> getTopLevelCollections(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_COLLECTIONS_TOP_LEVEL, this.prefixAssembler, new TypeReference<ZoteroList<CollectionsResponse>>(){}, params);
	}

	// A specific collection in the library
	public CollectionsResponse getCollection(String id, String collectionId) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_COLLECTIONS_ONE, collectionId);

		return this.restEndpoint.getOne(id, path, this.prefixAssembler, CollectionsResponse.class);
	}

	// Subcollections within a specific collection in the library
	public ZoteroList<CollectionsResponse> getSubCollection(String id, String collectionId) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_COLLECTIONS_SUB_COLLECTIONS, collectionId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<CollectionsResponse>>(){});
	}

	public ZoteroList<CollectionsResponse> getSubCollection(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_COLLECTIONS_SUB_COLLECTIONS, collectionId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<CollectionsResponse>>(){}, params);
	}

	public static CollectionsRequestHandlerImplBuilder builder()
	{
		return new CollectionsRequestHandlerImplBuilder();
	}

	public static class CollectionsRequestHandlerImplBuilder
	{
		private RestEndpoint restEndpoint;
		private PrefixAssembler prefixAssembler;

		private CollectionsRequestHandlerImplBuilder()
		{
			this.restEndpoint    = null;
			this.prefixAssembler = null;
		}
  
		public CollectionsRequestHandlerImplBuilder setRestEndpoint(RestEndpoint restEndpoint)
		{
			this.restEndpoint = restEndpoint;
			return this;
		}

		public CollectionsRequestHandlerImplBuilder setPrefixAssembler(PrefixAssembler prefixAssembler)
		{
			this.prefixAssembler = prefixAssembler;
			return this;
		}

		public CollectionsRequestHandlerImpl build()
		{
			return new CollectionsRequestHandlerImpl(this);
		}
	}
}