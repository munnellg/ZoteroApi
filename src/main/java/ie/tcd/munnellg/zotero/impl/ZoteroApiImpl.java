package ie.tcd.munnellg.zotero.impl;

import java.io.IOException;

import java.util.List;

import ie.tcd.munnellg.zotero.model.TagsResponse;
import ie.tcd.munnellg.zotero.model.ItemsResponse;
import ie.tcd.munnellg.zotero.model.GroupResponse;
import ie.tcd.munnellg.zotero.model.KeyPermissions;
import ie.tcd.munnellg.zotero.model.SearchesResponse;
import ie.tcd.munnellg.zotero.model.CollectionsResponse;

import ie.tcd.munnellg.zotero.interfaces.ZoteroApi;
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

	public List<ItemsResponse> getAllItems(String id) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getAllItems(id);
	}

	public List<ItemsResponse> getTopLevelItems(String id) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getTopLevelItems(id);
	}

	public List<ItemsResponse> getTrashedItems(String id) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getTrashedItems(id);
	}
	
	public ItemsResponse getItem(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getItem(id, itemId);
	}

	public List<ItemsResponse> getChildren(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getChildren(id, itemId);
	}

	public List<ItemsResponse> getMyPublications(String id) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getMyPublications(id);
	}

	public List<ItemsResponse> getCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getCollectionItems(id, collectionId);
	}

	public List<ItemsResponse> getTopCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.itemsRequestHandler.getTopCollectionItems(id, collectionId);
	}

	// Collections in the library
	public List<CollectionsResponse> getAllCollections(String id) throws JsonProcessingException, IOException
	{
		return this.collectionsRequestHandler.getAllCollections(id);
	}
	
	// Top-level collections in the library
	public List<CollectionsResponse> getTopLevelCollections(String id) throws JsonProcessingException, IOException
	{
		return this.collectionsRequestHandler.getTopLevelCollections(id);
	}

	// A specific collection in the library
	public CollectionsResponse getCollection(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.collectionsRequestHandler.getCollection(id, collectionId);
	}

	// Subcollections within a specific collection in the library
	public List<CollectionsResponse> getSubCollection(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.collectionsRequestHandler.getSubCollection(id, collectionId);
	}

	// All tags in the library
	public List<TagsResponse> getAllTags(String id) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getAllTags(id);
	}
	
	// Tags of all types matching a specific name
	public List<TagsResponse> getAllTags(String id, String urlEncodedTag) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getAllTags(id, urlEncodedTag);
	}

	// Tags associated with a specific item
	public List<TagsResponse> getAllItemTags(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getAllItemTags(id, itemId);
	}
	
	// Tags within a specific collection in the library
	public List<TagsResponse> getAllCollectionTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getAllCollectionTags(id, collectionId);
	}

	// All tags in the library, with the ability to filter based on the items
	// public List<ItemsResponse> getAllTags(String id, TagsQueryParams) throws JsonProcessingException, IOException;

	// Tags assigned to top-level items
	public List<TagsResponse> getTopLevelTags(String id) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getTopLevelTags(id);
	}

	// Tags assigned to items in the trash
	public List<TagsResponse> getTrashTags(String id) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getTrashTags(id);
	}

	// Tags assigned to items in a given collection
	public List<TagsResponse> getCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getCollectionItemTags(id, collectionId);
	}
	
	// Tags assigned to top-level items in a given collection
	public List<TagsResponse> getTopLevelCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getTopLevelCollectionItemTags(id, collectionId);
	}
	
	// Tags assigned to items in My Publications
	public List<TagsResponse> getMyPublicationTags(String id) throws JsonProcessingException, IOException
	{
		return this.tagsRequestHandler.getMyPublicationTags(id);
	}

	// All items in the library, excluding trashed items
	public KeyPermissions getKeyPermissions(String key) throws JsonProcessingException, IOException
	{
		return this.miscRequestHandler.getKeyPermissions(key);
	}
	
	// Top-level items in the library, excluding trashed items
	public List<GroupResponse> getUserGroups(String userId) throws JsonProcessingException, IOException
	{
		return this.miscRequestHandler.getUserGroups(userId);
	}

	// All saved searches in the library
	public List<SearchesResponse> getAllSearches(String id) throws JsonProcessingException, IOException
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