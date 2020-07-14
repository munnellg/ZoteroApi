package ie.tcd.munnellg.zotero.impl;

import java.io.IOException;

import ie.tcd.munnellg.zotero.util.ZoteroList;

import ie.tcd.munnellg.zotero.model.TagsResponse;
import ie.tcd.munnellg.zotero.model.ItemsResponse;
import ie.tcd.munnellg.zotero.model.GroupResponse;
import ie.tcd.munnellg.zotero.model.KeyPermissions;
import ie.tcd.munnellg.zotero.model.SearchesResponse;
import ie.tcd.munnellg.zotero.model.CollectionsResponse;

import ie.tcd.munnellg.zotero.interfaces.ZoteroApi;
import ie.tcd.munnellg.zotero.interfaces.RequestParams;
import ie.tcd.munnellg.zotero.interfaces.TagsRequestHandler;
import ie.tcd.munnellg.zotero.interfaces.MiscRequestHandler;
import ie.tcd.munnellg.zotero.interfaces.ItemsRequestHandler;
import ie.tcd.munnellg.zotero.interfaces.SearchesRequestHandler;
import ie.tcd.munnellg.zotero.interfaces.CollectionsRequestHandler;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ZoteroApiImpl implements ZoteroApi
{
	private ItemsRequestHandler itemsRequestHandler;

	private CollectionsRequestHandler collectionsRequestHandler;

	private TagsRequestHandler tagsRequestHandler;

	private SearchesRequestHandler searchesRequestHandler;

	private MiscRequestHandler miscRequestHandler;

	public ZoteroApiImpl()
	{
		this(ZoteroApiImpl.builder());
	}
	
	private ZoteroApiImpl(ZoteroApiImplBuilder builder)
	{
		this.itemsRequestHandler       = builder.itemsRequestHandler;
		this.collectionsRequestHandler = builder.collectionsRequestHandler;
		this.tagsRequestHandler        = builder.tagsRequestHandler;
		this.searchesRequestHandler    = builder.searchesRequestHandler;		
		this.miscRequestHandler        = builder.miscRequestHandler;
	}

	/* ======================================================================
	 * Items Requests
	 * ====================================================================== */

	public ZoteroList<ItemsResponse> getAllItems(String id) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getAllItems(id);
	}

	public ZoteroList<ItemsResponse> getAllItems(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getAllItems(id, params);
	}

	public ZoteroList<ItemsResponse> getTopLevelItems(String id) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getTopLevelItems(id);
	}

	public ZoteroList<ItemsResponse> getTopLevelItems(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getTopLevelItems(id, params);
	}

	public ZoteroList<ItemsResponse> getTrashedItems(String id) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getTrashedItems(id);
	}
	
	public ZoteroList<ItemsResponse> getTrashedItems(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getTrashedItems(id, params);
	}

	public ItemsResponse getItem(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getItem(id, itemId);
	}

	public ZoteroList<ItemsResponse> getChildren(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getChildren(id, itemId);
	}

	public ZoteroList<ItemsResponse> getChildren(String id, String itemId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getChildren(id, itemId, params);
	}

	public ZoteroList<ItemsResponse> getMyPublications(String id) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getMyPublications(id);
	}

	public ZoteroList<ItemsResponse> getMyPublications(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getMyPublications(id, params);
	}

	public ZoteroList<ItemsResponse> getCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getCollectionItems(id, collectionId);
	}

	public ZoteroList<ItemsResponse> getCollectionItems(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getCollectionItems(id, collectionId, params);
	}

	public ZoteroList<ItemsResponse> getTopCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getTopCollectionItems(id, collectionId);
	}

	public ZoteroList<ItemsResponse> getTopCollectionItems(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getTopCollectionItems(id, collectionId, params);
	}

	/* ======================================================================
	 * Collections Requests
	 * ====================================================================== */

	// Collections in the library
	public ZoteroList<CollectionsResponse> getAllCollections(String id) throws JsonProcessingException, IOException
	{
		return this.collectionsRequestHandler.getAllCollections(id);
	}

	public ZoteroList<CollectionsResponse> getAllCollections(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.collectionsRequestHandler.getAllCollections(id, params);
	}
	
	// Top-level collections in the library
	public ZoteroList<CollectionsResponse> getTopLevelCollections(String id) throws JsonProcessingException, IOException
	{
		return this.collectionsRequestHandler.getTopLevelCollections(id);
	}

	public ZoteroList<CollectionsResponse> getTopLevelCollections(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.collectionsRequestHandler.getTopLevelCollections(id, params);
	}

	// A specific collection in the library
	public CollectionsResponse getCollection(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.collectionsRequestHandler.getCollection(id, collectionId);
	}

	// Subcollections within a specific collection in the library
	public ZoteroList<CollectionsResponse> getSubCollection(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.collectionsRequestHandler.getSubCollection(id, collectionId);
	}

	public ZoteroList<CollectionsResponse> getSubCollection(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.collectionsRequestHandler.getSubCollection(id, collectionId, params);
	}

	/* ======================================================================
	 * Tags Requests
	 * ====================================================================== */

	// All tags in the library
	public ZoteroList<TagsResponse> getAllTags(String id) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getAllTags(id);
	}

	public ZoteroList<TagsResponse> getAllTags(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getAllTags(id, params);
	}
	
	// Tags of all types matching a specific name
	public ZoteroList<TagsResponse> getAllTags(String id, String urlEncodedTag) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getAllTags(id, urlEncodedTag);
	}

	public ZoteroList<TagsResponse> getAllTags(String id, String urlEncodedTag, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getAllTags(id, urlEncodedTag, params);
	}

	// Tags associated with a specific item
	public ZoteroList<TagsResponse> getAllItemTags(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getAllItemTags(id, itemId);
	}

	public ZoteroList<TagsResponse> getAllItemTags(String id, String itemId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getAllItemTags(id, itemId, params);
	}
	
	// Tags within a specific collection in the library
	public ZoteroList<TagsResponse> getAllCollectionTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getAllCollectionTags(id, collectionId);
	}

	public ZoteroList<TagsResponse> getAllCollectionTags(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getAllCollectionTags(id, collectionId, params);
	}

	// All tags in the library, with the ability to filter based on the items
	public ZoteroList<TagsResponse> getAllTagsFilterByItems(String id) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getAllTagsFilterByItems(id);
	}

	public ZoteroList<TagsResponse> getAllTagsFilterByItems(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getAllTagsFilterByItems(id, params);
	}

	// Tags assigned to top-level items
	public ZoteroList<TagsResponse> getTopLevelTags(String id) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getTopLevelTags(id);
	}

	public ZoteroList<TagsResponse> getTopLevelTags(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getTopLevelTags(id, params);
	}

	// Tags assigned to items in the trash
	public ZoteroList<TagsResponse> getTrashTags(String id) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getTrashTags(id);
	}

	public ZoteroList<TagsResponse> getTrashTags(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getTrashTags(id, params);
	}

	// Tags assigned to items in a given collection
	public ZoteroList<TagsResponse> getCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getCollectionItemTags(id, collectionId);
	}
	
	public ZoteroList<TagsResponse> getCollectionItemTags(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getCollectionItemTags(id, collectionId, params);
	}

	// Tags assigned to top-level items in a given collection
	public ZoteroList<TagsResponse> getTopLevelCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getTopLevelCollectionItemTags(id, collectionId);
	}

	public ZoteroList<TagsResponse> getTopLevelCollectionItemTags(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getTopLevelCollectionItemTags(id, collectionId, params);
	}
	
	// Tags assigned to items in My Publications
	public ZoteroList<TagsResponse> getMyPublicationTags(String id) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getMyPublicationTags(id);
	}

	public ZoteroList<TagsResponse> getMyPublicationTags(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getMyPublicationTags(id, params);
	}

	/* ======================================================================
	 * Misc Requests
	 * ====================================================================== */

	// All items in the library, excluding trashed items
	public KeyPermissions getKeyPermissions(String key) throws JsonProcessingException, IOException
	{
		return this.miscRequestHandler.getKeyPermissions(key);
	}
	
	// Top-level items in the library, excluding trashed items
	public ZoteroList<GroupResponse> getUserGroups(String userId) throws JsonProcessingException, IOException
	{
		return this.miscRequestHandler.getUserGroups(userId);
	}

	/* ======================================================================
	 * Searches Requests
	 * ====================================================================== */

	// All saved searches in the library
	public ZoteroList<SearchesResponse> getAllSearches(String id) throws JsonProcessingException, IOException
	{
		return this.searchesRequestHandler.getAllSearches(id);
	}
	
	// A specific saved search in the library
	public SearchesResponse getSearch(String id, String searchId) throws JsonProcessingException, IOException
	{
		return this.searchesRequestHandler.getSearch(id, searchId);
	}

	public static ZoteroApiImplBuilder builder()
	{
		return new ZoteroApiImplBuilder();
	}

	public static class ZoteroApiImplBuilder
	{
		private ItemsRequestHandler itemsRequestHandler;

		private CollectionsRequestHandler collectionsRequestHandler;

		private TagsRequestHandler tagsRequestHandler;

		private SearchesRequestHandler searchesRequestHandler;

		private MiscRequestHandler miscRequestHandler;

		public ZoteroApiImplBuilder()
		{
			this.itemsRequestHandler       = null;
			this.collectionsRequestHandler = null;
			this.tagsRequestHandler        = null;
			this.searchesRequestHandler    = null;
			this.miscRequestHandler        = null;
		}

		public ZoteroApiImplBuilder setItemsRequestHandler(ItemsRequestHandler itemsRequestHandler)
		{
			this.itemsRequestHandler = itemsRequestHandler;
			return this;
		}

		public ZoteroApiImplBuilder setCollectionsRequestHandler(CollectionsRequestHandler collectionsRequestHandler)
		{
			this.collectionsRequestHandler = collectionsRequestHandler;
			return this;
		}

		public ZoteroApiImplBuilder setTagsRequestHandler(TagsRequestHandler tagsRequestHandler)
		{
			this.tagsRequestHandler = tagsRequestHandler;
			return this;
		}

		public ZoteroApiImplBuilder setSearchesRequestHandler(SearchesRequestHandler searchesRequestHandler)
		{
			this.searchesRequestHandler = searchesRequestHandler;
			return this;
		}

		public ZoteroApiImplBuilder setMiscRequestHandler(MiscRequestHandler miscRequestHandler)
		{
			this.miscRequestHandler = miscRequestHandler;
			return this;
		}

		public ZoteroApiImpl build()
		{
			return new ZoteroApiImpl(this);
		}
	}
}