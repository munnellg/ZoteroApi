package ie.tcd.munnellg.zotero.impl;

import java.io.IOException;

import ie.tcd.munnellg.zotero.util.ZoteroList;

import ie.tcd.munnellg.zotero.model.ItemsResponse;

import ie.tcd.munnellg.zotero.interfaces.RestEndpoint;
import ie.tcd.munnellg.zotero.interfaces.RequestParams;
import ie.tcd.munnellg.zotero.interfaces.PrefixAssembler;
import ie.tcd.munnellg.zotero.interfaces.ItemsRequestHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ItemsRequestHandlerImpl implements ItemsRequestHandler
{
	protected static final String URL_ITEMS_ALL                  = "items";
	protected static final String URL_ITEMS_TOP_LEVEL            = "items/top";
	protected static final String URL_ITEMS_TRASH                = "items/trash";
	protected static final String URL_ITEMS_ONE                  = "items/%s";
	protected static final String URL_ITEMS_CHILDREN             = "items/%s/children";
	protected static final String URL_ITEMS_MY_PUBLICATIONS      = "publications/items";
	protected static final String URL_ITEMS_COLLECTION           = "collections/%s/items";
	protected static final String URL_ITEMS_COLLECTION_TOP_LEVEL = "collections/%s/items/top";

	private RestEndpoint restEndpoint;
	
	private PrefixAssembler prefixAssembler;

	private ItemsRequestHandlerImpl()
	{
		this(ItemsRequestHandlerImpl.builder());
	}

	private ItemsRequestHandlerImpl(ItemsRequestHandlerImplBuilder builder)
	{
		this.restEndpoint    = builder.restEndpoint;
		this.prefixAssembler = builder.prefixAssembler;
	}

	// All items in the library, excluding trashed items
	public ZoteroList<ItemsResponse> getAllItems(String id) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_ITEMS_ALL, this.prefixAssembler, new TypeReference<ZoteroList<ItemsResponse>>(){});
	}

	public ZoteroList<ItemsResponse> getAllItems(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_ITEMS_ALL, this.prefixAssembler, new TypeReference<ZoteroList<ItemsResponse>>(){}, params);
	}
	
	// Top-level items in the library, excluding trashed items
	public ZoteroList<ItemsResponse> getTopLevelItems(String id) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_ITEMS_TOP_LEVEL, this.prefixAssembler, new TypeReference<ZoteroList<ItemsResponse>>(){});
	}

	public ZoteroList<ItemsResponse> getTopLevelItems(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_ITEMS_TOP_LEVEL, this.prefixAssembler, new TypeReference<ZoteroList<ItemsResponse>>(){}, params);
	}

	// Items in the trash
	public ZoteroList<ItemsResponse> getTrashedItems(String id) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_ITEMS_TRASH, this.prefixAssembler, new TypeReference<ZoteroList<ItemsResponse>>(){});
	}

	public ZoteroList<ItemsResponse> getTrashedItems(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_ITEMS_TRASH, this.prefixAssembler, new TypeReference<ZoteroList<ItemsResponse>>(){}, params);
	}

	// A specific item in the library
	public ItemsResponse getItem(String id, String itemId) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_ITEMS_ONE, itemId);

		return this.restEndpoint.getOne(id, path, this.prefixAssembler, ItemsResponse.class);
	}

	public ItemsResponse getItem(String id, String itemId, RequestParams params) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_ITEMS_ONE, itemId);

		return this.restEndpoint.getOne(id, path, this.prefixAssembler, ItemsResponse.class, params);
	}

	// Child items under a specific item
	public ZoteroList<ItemsResponse> getChildren(String id, String itemId) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_ITEMS_CHILDREN, itemId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<ItemsResponse>>(){});
	}

	public ZoteroList<ItemsResponse> getChildren(String id, String itemId, RequestParams params) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_ITEMS_CHILDREN, itemId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<ItemsResponse>>(){}, params);
	}

	// Items in My Publications
	public ZoteroList<ItemsResponse> getMyPublications(String id) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_ITEMS_MY_PUBLICATIONS, this.prefixAssembler, new TypeReference<ZoteroList<ItemsResponse>>(){});
	}

	public ZoteroList<ItemsResponse> getMyPublications(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_ITEMS_MY_PUBLICATIONS, this.prefixAssembler, new TypeReference<ZoteroList<ItemsResponse>>(){}, params);
	}

	// Items within a specific collection in the library
	public ZoteroList<ItemsResponse> getCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_ITEMS_COLLECTION, collectionId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<ItemsResponse>>(){});
	}

	public ZoteroList<ItemsResponse> getCollectionItems(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_ITEMS_COLLECTION, collectionId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<ItemsResponse>>(){}, params);
	}

	// Top-level items within a specific collection in the library
	public ZoteroList<ItemsResponse> getTopCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_ITEMS_COLLECTION_TOP_LEVEL, collectionId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<ItemsResponse>>(){});
	}

	public ZoteroList<ItemsResponse> getTopCollectionItems(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_ITEMS_COLLECTION_TOP_LEVEL, collectionId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<ItemsResponse>>(){}, params);
	}

	public static ItemsRequestHandlerImplBuilder builder()
	{
		return new ItemsRequestHandlerImplBuilder();
	}

	public static class ItemsRequestHandlerImplBuilder
	{
		private RestEndpoint restEndpoint;
		private PrefixAssembler prefixAssembler;

		private ItemsRequestHandlerImplBuilder()
		{
			this.restEndpoint    = null;
			this.prefixAssembler = null;
		}
  
		public ItemsRequestHandlerImplBuilder setRestEndpoint(RestEndpoint restEndpoint)
		{
			this.restEndpoint = restEndpoint;
			return this;
		}

		public ItemsRequestHandlerImplBuilder setPrefixAssembler(PrefixAssembler prefixAssembler)
		{
			this.prefixAssembler = prefixAssembler;
			return this;
		}

		public ItemsRequestHandlerImpl build()
		{
			return new ItemsRequestHandlerImpl(this);
		}
	}
}