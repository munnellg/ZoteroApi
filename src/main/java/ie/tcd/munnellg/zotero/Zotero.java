package ie.tcd.munnellg.zotero;

import java.net.URL;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.MalformedURLException;

import java.util.List;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

import ie.tcd.munnellg.zotero.enums.Mode;

import ie.tcd.munnellg.zotero.util.ZoteroList;

import ie.tcd.munnellg.zotero.impl.SearchParams;
import ie.tcd.munnellg.zotero.impl.SortAndPaginationParams;

import ie.tcd.munnellg.zotero.model.TagsResponse;
import ie.tcd.munnellg.zotero.model.ItemsResponse;
import ie.tcd.munnellg.zotero.model.GroupResponse;
import ie.tcd.munnellg.zotero.model.KeyPermissions;
import ie.tcd.munnellg.zotero.model.SearchesResponse;
import ie.tcd.munnellg.zotero.model.CollectionsResponse;

import ie.tcd.munnellg.zotero.interfaces.RequestParams;
import ie.tcd.munnellg.zotero.interfaces.ZoteroApi;
import ie.tcd.munnellg.zotero.interfaces.MiscRequestHandler;

import ie.tcd.munnellg.zotero.factory.ZoteroApiFactory;
import ie.tcd.munnellg.zotero.factory.MiscRequestHandlerFactory;

import ie.tcd.munnellg.zotero.util.QueryStringEncoder;

public class Zotero
{
	private static final String DEFAULT_API_ROOT = "https://api.zotero.org/";

	private ZoteroApi defaultApi;

	private ZoteroApi usersApi;
	
	private ZoteroApi groupsApi;

	private MiscRequestHandler miscRequestHandler;

	private String defaultId;

	public Zotero(String apiKey)
	{
		this(DEFAULT_API_ROOT, apiKey);
	}

	public Zotero(String apiRoot, String apiKey)
	{
		this.defaultId          = null;

		this.defaultApi         = null;
		this.usersApi           = ZoteroApiFactory.assemble(Mode.USER, apiRoot, apiKey);
		this.groupsApi          = ZoteroApiFactory.assemble(Mode.GROUP, apiRoot, apiKey);
		this.miscRequestHandler = MiscRequestHandlerFactory.assemble(apiRoot, apiKey);
	}

	public void setDefaultMode(Mode mode)
	{
		this.setDefaultMode(mode, this.defaultId);
	}

	public void setDefaultMode(Mode mode, String defaultId)
	{
		switch (mode)
		{
			case NONE:
				this.defaultApi = null;
				break;
			case USER:
				this.defaultApi = this.usersApi;
				break;
			case GROUP:
				this.defaultApi = this.groupsApi;
				break;
			default:
				return; /* TODO: Throw exception */
		}

		this.setDefaultId(defaultId);
	}

	public String getDefaultId()
	{
		return this.defaultId;
	}

	public void setDefaultId(String defaultId)
	{
		this.defaultId = defaultId;
	}

	/* ======================================================================
	 * Items Requests
	 * ====================================================================== */

	public ZoteroList<ItemsResponse> getAllItems() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllItems(this.defaultId);
	}

	public ZoteroList<ItemsResponse> getAllItems(RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllItems(this.defaultId, params);
	}

	public ZoteroList<ItemsResponse> getTopLevelItems() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTopLevelItems(this.defaultId);
	}

	public ZoteroList<ItemsResponse> getTopLevelItems(RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTopLevelItems(this.defaultId, params);
	}

	public ZoteroList<ItemsResponse> getTrashedItems() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTrashedItems(this.defaultId);
	}

	public ZoteroList<ItemsResponse> getTrashedItems(RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTrashedItems(this.defaultId, params);
	}

	public ItemsResponse getItem(String itemId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getItem(this.defaultId, itemId);
	}

	public ZoteroList<ItemsResponse> getChildren(String itemId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getChildren(this.defaultId, itemId);
	}

	public ZoteroList<ItemsResponse> getChildren(String itemId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getChildren(this.defaultId, itemId, params);
	}

	public ZoteroList<ItemsResponse> getMyPublications() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getMyPublications(this.defaultId);
	}

	public ZoteroList<ItemsResponse> getMyPublications(RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getMyPublications(this.defaultId, params);
	}

	public ZoteroList<ItemsResponse> getCollectionItems(String collectionId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getCollectionItems(this.defaultId, collectionId);
	}

	public ZoteroList<ItemsResponse> getCollectionItems(String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getCollectionItems(this.defaultId, collectionId, params);
	}

	public ZoteroList<ItemsResponse> getTopCollectionItems(String collectionId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTopCollectionItems(this.defaultId, collectionId);
	}

	public ZoteroList<ItemsResponse> getTopCollectionItems(String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTopCollectionItems(this.defaultId, collectionId, params);
	}

	public ZoteroList<ItemsResponse> getUsersAllItems(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllItems(id);
	}

	public ZoteroList<ItemsResponse> getUsersAllItems(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllItems(id, params);
	}

	public ZoteroList<ItemsResponse> getUsersTopLevelItems(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTopLevelItems(id);
	}

	public ZoteroList<ItemsResponse> getUsersTopLevelItems(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTopLevelItems(id, params);
	}

	public ZoteroList<ItemsResponse> getUsersTrashedItems(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTrashedItems(id);
	}

	public ZoteroList<ItemsResponse> getUsersTrashedItems(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTrashedItems(id, params);
	}
	
	public ItemsResponse getUsersItem(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getItem(id, itemId);
	}

	public ZoteroList<ItemsResponse> getUsersChildren(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getChildren(id, itemId);
	}

	public ZoteroList<ItemsResponse> getUsersChildren(String id, String itemId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getChildren(id, itemId, params);
	}

	public ZoteroList<ItemsResponse> getUsersMyPublications(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getMyPublications(id);
	}

	public ZoteroList<ItemsResponse> getUsersMyPublications(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getMyPublications(id, params);
	}

	public ZoteroList<ItemsResponse> getUsersCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getCollectionItems(id, collectionId);
	}

	public ZoteroList<ItemsResponse> getUsersCollectionItems(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getCollectionItems(id, collectionId, params);
	}

	public ZoteroList<ItemsResponse> getUsersTopCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTopCollectionItems(id, collectionId);
	}

	public ZoteroList<ItemsResponse> getUsersTopCollectionItems(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTopCollectionItems(id, collectionId, params);
	}

	public ZoteroList<ItemsResponse> getGroupsAllItems(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllItems(id);
	}

	public ZoteroList<ItemsResponse> getGroupsAllItems(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllItems(id, params);
	}

	public ZoteroList<ItemsResponse> getGroupsTopLevelItems(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTopLevelItems(id);
	}

	public ZoteroList<ItemsResponse> getGroupsTopLevelItems(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTopLevelItems(id, params);
	}

	public ZoteroList<ItemsResponse> getGroupsTrashedItems(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTrashedItems(id);
	}

	public ZoteroList<ItemsResponse> getGroupsTrashedItems(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTrashedItems(id, params);
	}
	
	public ItemsResponse getGroupsItem(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getItem(id, itemId);
	}

	public ZoteroList<ItemsResponse> getGroupsChildren(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getChildren(id, itemId);
	}

	public ZoteroList<ItemsResponse> getGroupsChildren(String id, String itemId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getChildren(id, itemId, params);
	}

	public ZoteroList<ItemsResponse> getGroupsMyPublications(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getMyPublications(id);
	}

	public ZoteroList<ItemsResponse> getGroupsMyPublications(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getMyPublications(id, params);
	}

	public ZoteroList<ItemsResponse> getGroupsCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getCollectionItems(id, collectionId);
	}

	public ZoteroList<ItemsResponse> getGroupsCollectionItems(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getCollectionItems(id, collectionId, params);
	}

	public ZoteroList<ItemsResponse> getGroupsTopCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTopCollectionItems(id, collectionId);
	}

	public ZoteroList<ItemsResponse> getGroupsTopCollectionItems(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTopCollectionItems(id, collectionId, params);
	}

	/* ======================================================================
	 * Collections Requests
	 * ====================================================================== */

	// Collections in the library
	public ZoteroList<CollectionsResponse> getAllCollections() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllCollections(this.defaultId);
	}

	public ZoteroList<CollectionsResponse> getAllCollections(RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllCollections(this.defaultId, params);
	}
	
	// Top-level collections in the library
	public ZoteroList<CollectionsResponse> getTopLevelCollections() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTopLevelCollections(this.defaultId);
	}

	public ZoteroList<CollectionsResponse> getTopLevelCollections(RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTopLevelCollections(this.defaultId, params);
	}

	// A specific collection in the library
	public CollectionsResponse getCollection(String collectionId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getCollection(this.defaultId, collectionId);
	}

	// Subcollections within a specific collection in the library
	public ZoteroList<CollectionsResponse> getSubCollection(String collectionId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getSubCollection(this.defaultId, collectionId);
	}

	public ZoteroList<CollectionsResponse> getSubCollection(String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getSubCollection(this.defaultId, collectionId, params);
	}

	public ZoteroList<CollectionsResponse> getUsersAllCollections(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllCollections(id);
	}

	public ZoteroList<CollectionsResponse> getUsersAllCollections(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllCollections(id, params);
	}
	
	public ZoteroList<CollectionsResponse> getUsersTopLevelCollections(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTopLevelCollections(id);
	}

	public ZoteroList<CollectionsResponse> getUsersTopLevelCollections(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTopLevelCollections(id, params);
	}

	public CollectionsResponse getUsersCollection(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getCollection(id, collectionId);
	}

	public ZoteroList<CollectionsResponse> getUsersSubCollection(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getSubCollection(id, collectionId);
	}

	public ZoteroList<CollectionsResponse> getUsersSubCollection(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getSubCollection(id, collectionId, params);
	}

	public ZoteroList<CollectionsResponse> getGroupsAllCollections(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllCollections(id);
	}

	public ZoteroList<CollectionsResponse> getGroupsAllCollections(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllCollections(id, params);
	}
	
	public ZoteroList<CollectionsResponse> getGroupsTopLevelCollections(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTopLevelCollections(id);
	}

	public ZoteroList<CollectionsResponse> getGroupsTopLevelCollections(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTopLevelCollections(id, params);
	}

	public CollectionsResponse getGroupsCollection(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getCollection(id, collectionId);
	}

	public ZoteroList<CollectionsResponse> getGroupsSubCollection(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getSubCollection(id, collectionId);
	}

	public ZoteroList<CollectionsResponse> getGroupsSubCollection(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getSubCollection(id, collectionId, params);
	}

	/* ======================================================================
	 * Tags Requests
	 * ====================================================================== */

	// All tags in the library
	public ZoteroList<TagsResponse> getAllTags() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllTags(this.defaultId);
	}

	public ZoteroList<TagsResponse> getAllTags(RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllTags(this.defaultId, params);
	}
	
	// Tags of all types matching a specific name
	public ZoteroList<TagsResponse> getAllTags(String urlEncodedTag) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllTags(this.defaultId, urlEncodedTag);
	}

	public ZoteroList<TagsResponse> getAllTags(String urlEncodedTag, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllTags(this.defaultId, urlEncodedTag, params);
	}

	// Tags associated with a specific item
	public ZoteroList<TagsResponse> getAllItemTags(String itemId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllItemTags(this.defaultId, itemId);
	}

	public ZoteroList<TagsResponse> getAllItemTags(String itemId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllItemTags(this.defaultId, itemId, params);
	}
	
	// Tags within a specific collection in the library
	public ZoteroList<TagsResponse> getAllCollectionTags(String collectionId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllCollectionTags(this.defaultId, collectionId);
	}

	public ZoteroList<TagsResponse> getAllCollectionTags(String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllCollectionTags(this.defaultId, collectionId, params);
	}

	// All tags in the library, with the ability to filter based on the items
	public ZoteroList<TagsResponse> getAllTagsFilterByItems(String id) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllTagsFilterByItems(this.defaultId);
	}

	public ZoteroList<TagsResponse> getAllTagsFilterByItems(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllTagsFilterByItems(this.defaultId, params);
	}

	// Tags assigned to top-level items
	public ZoteroList<TagsResponse> getTopLevelTags() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTopLevelTags(this.defaultId);
	}

	public ZoteroList<TagsResponse> getTopLevelTags(RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTopLevelTags(this.defaultId, params);
	}

	// Tags assigned to items in the trash
	public ZoteroList<TagsResponse> getTrashTags() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTrashTags(this.defaultId);
	}

	public ZoteroList<TagsResponse> getTrashTags(RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTrashTags(this.defaultId, params);
	}

	// Tags assigned to items in a given collection
	public ZoteroList<TagsResponse> getCollectionItemTags(String collectionId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getCollectionItemTags(this.defaultId, collectionId);
	}

	public ZoteroList<TagsResponse> getCollectionItemTags(String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getCollectionItemTags(this.defaultId, collectionId, params);
	}
	
	// Tags assigned to top-level items in a given collection
	public ZoteroList<TagsResponse> getTopLevelCollectionItemTags(String collectionId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTopLevelCollectionItemTags(this.defaultId, collectionId);
	}

	public ZoteroList<TagsResponse> getTopLevelCollectionItemTags(String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTopLevelCollectionItemTags(this.defaultId, collectionId, params);
	}
	
	// Tags assigned to items in My Publications
	public ZoteroList<TagsResponse> getMyPublicationTags() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getMyPublicationTags(this.defaultId);
	}

	public ZoteroList<TagsResponse> getMyPublicationTags(RequestParams params) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getMyPublicationTags(this.defaultId, params);
	}

	// All tags in the library
	public ZoteroList<TagsResponse> getUsersAllTags(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllTags(id);
	}

	public ZoteroList<TagsResponse> getUsersAllTags(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllTags(id, params);
	}
	
	// Tags of all types matching a specific name
	public ZoteroList<TagsResponse> getUsersAllTags(String id, String urlEncodedTag) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllTags(id, urlEncodedTag);
	}

	public ZoteroList<TagsResponse> getUsersAllTags(String id, String urlEncodedTag, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllTags(id, urlEncodedTag, params);
	}

	// Tags associated with a specific item
	public ZoteroList<TagsResponse> getUsersAllItemTags(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllItemTags(id, itemId);
	}

	public ZoteroList<TagsResponse> getUsersAllItemTags(String id, String itemId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllItemTags(id, itemId, params);
	}
	
	// Tags within a specific collection in the library
	public ZoteroList<TagsResponse> getUsersAllCollectionTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllCollectionTags(id, collectionId);
	}

	public ZoteroList<TagsResponse> getUsersAllCollectionTags(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllCollectionTags(id, collectionId, params);
	}

	// All tags in the library, with the ability to filter based on the items
	public ZoteroList<TagsResponse> getUsersAllTagsFilterByItems(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllTagsFilterByItems(id);
	}

	public ZoteroList<TagsResponse> getUsersAllTagsFilterByItems(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllTagsFilterByItems(id, params);
	}

	// Tags assigned to top-level items
	public ZoteroList<TagsResponse> getUsersTopLevelTags(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTopLevelTags(id);
	}

	public ZoteroList<TagsResponse> getUsersTopLevelTags(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTopLevelTags(id, params);
	}

	// Tags assigned to items in the trash
	public ZoteroList<TagsResponse> getUsersTrashTags(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTrashTags(id);
	}

	public ZoteroList<TagsResponse> getUsersTrashTags(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTrashTags(id, params);
	}

	// Tags assigned to items in a given collection
	public ZoteroList<TagsResponse> getUsersCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getCollectionItemTags(id, collectionId);
	}

	public ZoteroList<TagsResponse> getUsersCollectionItemTags(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getCollectionItemTags(id, collectionId, params);
	}
	
	// Tags assigned to top-level items in a given collection
	public ZoteroList<TagsResponse> getUsersTopLevelCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTopLevelCollectionItemTags(id, collectionId);
	}

	public ZoteroList<TagsResponse> getUsersTopLevelCollectionItemTags(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTopLevelCollectionItemTags(id, collectionId, params);
	}
	
	// Tags assigned to items in My Publications
	public ZoteroList<TagsResponse> getUsersMyPublicationTags(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getMyPublicationTags(id);
	}

	public ZoteroList<TagsResponse> getUsersMyPublicationTags(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.usersApi.getMyPublicationTags(id, params);
	}

	// All tags in the library
	public ZoteroList<TagsResponse> getGroupsAllTags(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllTags(id);
	}

	public ZoteroList<TagsResponse> getGroupsAllTags(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllTags(id, params);
	}
	
	// Tags of all types matching a specific name
	public ZoteroList<TagsResponse> getGroupsAllTags(String id, String urlEncodedTag) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllTags(id, urlEncodedTag);
	}

	public ZoteroList<TagsResponse> getGroupsAllTags(String id, String urlEncodedTag, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllTags(id, urlEncodedTag, params);
	}

	// Tags associated with a specific item
	public ZoteroList<TagsResponse> getGroupsAllItemTags(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllItemTags(id, itemId);
	}

	public ZoteroList<TagsResponse> getGroupsAllItemTags(String id, String itemId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllItemTags(id, itemId, params);
	}
	
	// Tags within a specific collection in the library
	public ZoteroList<TagsResponse> getGroupsAllCollectionTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllCollectionTags(id, collectionId);
	}

	public ZoteroList<TagsResponse> getGroupsAllCollectionTags(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllCollectionTags(id, collectionId, params);
	}

	// All tags in the library, with the ability to filter based on the items
	public ZoteroList<TagsResponse> getGroupsAllTagsFilterByItems(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllTagsFilterByItems(id);
	}

	public ZoteroList<TagsResponse> getGroupsAllTagsFilterByItems(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllTagsFilterByItems(id, params);
	}

	// Tags assigned to top-level items
	public ZoteroList<TagsResponse> getGroupsTopLevelTags(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTopLevelTags(id);
	}

	public ZoteroList<TagsResponse> getGroupsTopLevelTags(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTopLevelTags(id, params);
	}

	// Tags assigned to items in the trash
	public ZoteroList<TagsResponse> getGroupsTrashTags(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTrashTags(id);
	}

	public ZoteroList<TagsResponse> getGroupsTrashTags(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTrashTags(id, params);
	}

	// Tags assigned to items in a given collection
	public ZoteroList<TagsResponse> getGroupsCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getCollectionItemTags(id, collectionId);
	}

	public ZoteroList<TagsResponse> getGroupsCollectionItemTags(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getCollectionItemTags(id, collectionId, params);
	}
	
	// Tags assigned to top-level items in a given collection
	public ZoteroList<TagsResponse> getGroupsTopLevelCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTopLevelCollectionItemTags(id, collectionId);
	}
	
	public ZoteroList<TagsResponse> getGroupsTopLevelCollectionItemTags(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTopLevelCollectionItemTags(id, collectionId, params);
	}

	// Tags assigned to items in My Publications
	public ZoteroList<TagsResponse> getGroupsMyPublicationTags(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getMyPublicationTags(id);
	}

	public ZoteroList<TagsResponse> getGroupsMyPublicationTags(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getMyPublicationTags(id, params);
	}

	// All saved searches in the library
	public ZoteroList<SearchesResponse> getAllSearches() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllSearches(this.defaultId);
	}
	
	// A specific saved search in the library
	public SearchesResponse getSearch(String searchId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getSearch(this.defaultId, searchId);
	}

	// All saved searches in the library
	public ZoteroList<SearchesResponse> getUsersAllSearches(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllSearches(id);
	}
	
	// A specific saved search in the library
	public SearchesResponse getUsersSearch(String id, String searchId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getSearch(id, searchId);
	}

	// All saved searches in the library
	public ZoteroList<SearchesResponse> getGroupsAllSearches(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllSearches(id);
	}
	
	// A specific saved search in the library
	public SearchesResponse getGroupsSearch(String id, String searchId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getSearch(id, searchId);
	}

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
}
