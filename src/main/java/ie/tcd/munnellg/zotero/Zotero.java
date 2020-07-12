package ie.tcd.munnellg.zotero;

import java.net.URL;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.MalformedURLException;

import java.util.List;

import java.io.IOException;

import ie.tcd.munnellg.zotero.enums.Mode;

import ie.tcd.munnellg.zotero.model.TagsResponse;
import ie.tcd.munnellg.zotero.model.ItemsResponse;
import ie.tcd.munnellg.zotero.model.GroupResponse;
import ie.tcd.munnellg.zotero.model.KeyPermissions;
import ie.tcd.munnellg.zotero.model.SearchesResponse;
import ie.tcd.munnellg.zotero.model.CollectionsResponse;

import ie.tcd.munnellg.zotero.interfaces.ZoteroApi;
import ie.tcd.munnellg.zotero.interfaces.MiscRequestHandler;

import ie.tcd.munnellg.zotero.factory.ZoteroApiFactory;
import ie.tcd.munnellg.zotero.factory.MiscRequestHandlerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;

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
		this.setDefaultMode(this.defaultId, mode);
	}

	public void setDefaultMode(String defaultId, Mode mode)
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

	public List<ItemsResponse> getAllItems() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllItems(this.defaultId);
	}

	public List<ItemsResponse> getTopLevelItems() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTopLevelItems(this.defaultId);
	}

	public List<ItemsResponse> getTrashedItems() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTrashedItems(this.defaultId);
	}

	public ItemsResponse getItem(String itemId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getItem(this.defaultId, itemId);
	}

	public List<ItemsResponse> getChildren(String itemId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getChildren(this.defaultId, itemId);
	}

	public List<ItemsResponse> getMyPublications() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getMyPublications(this.defaultId);
	}

	public List<ItemsResponse> getCollectionItems(String collectionId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getCollectionItems(this.defaultId, collectionId);
	}

	public List<ItemsResponse> getTopCollectionItems(String collectionId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTopCollectionItems(this.defaultId, collectionId);
	}

	public List<ItemsResponse> getUsersAllItems(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllItems(id);
	}

	public List<ItemsResponse> getUsersTopLevelItems(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTopLevelItems(id);
	}

	public List<ItemsResponse> getUsersTrashedItems(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTrashedItems(id);
	}
	
	public ItemsResponse getUsersItem(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getItem(id, itemId);
	}

	public List<ItemsResponse> getUsersChildren(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getChildren(id, itemId);
	}

	public List<ItemsResponse> getUsersMyPublications(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getMyPublications(id);
	}

	public List<ItemsResponse> getUsersCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getCollectionItems(id, collectionId);
	}

	public List<ItemsResponse> getUsersTopCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTopCollectionItems(id, collectionId);
	}

	public List<ItemsResponse> getGroupsAllItems(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllItems(id);
	}

	public List<ItemsResponse> getGroupsTopLevelItems(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTopLevelItems(id);
	}

	public List<ItemsResponse> getGroupsTrashedItems(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTrashedItems(id);
	}
	
	public ItemsResponse getGroupsItem(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getItem(id, itemId);
	}

	public List<ItemsResponse> getGroupsChildren(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getChildren(id, itemId);
	}

	public List<ItemsResponse> getGroupsMyPublications(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getMyPublications(id);
	}

	public List<ItemsResponse> getGroupsCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getCollectionItems(id, collectionId);
	}

	public List<ItemsResponse> getGroupsTopCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTopCollectionItems(id, collectionId);
	}

	/* ======================================================================
	 * Collections Requests
	 * ====================================================================== */

	// Collections in the library
	public List<CollectionsResponse> getAllCollections() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllCollections(this.defaultId);
	}
	
	// Top-level collections in the library
	public List<CollectionsResponse> getTopLevelCollections() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTopLevelCollections(this.defaultId);
	}

	// A specific collection in the library
	public CollectionsResponse getCollection(String collectionId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getCollection(this.defaultId, collectionId);
	}

	// Subcollections within a specific collection in the library
	public List<CollectionsResponse> getSubCollection(String collectionId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getSubCollection(this.defaultId, collectionId);
	}

	public List<CollectionsResponse> getUsersAllCollections(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllCollections(id);
	}
	
	public List<CollectionsResponse> getUsersTopLevelCollections(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTopLevelCollections(id);
	}

	public CollectionsResponse getUsersCollection(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getCollection(id, collectionId);
	}

	public List<CollectionsResponse> getUsersSubCollection(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getSubCollection(id, collectionId);
	}

	public List<CollectionsResponse> getGroupsAllCollections(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllCollections(id);
	}
	
	public List<CollectionsResponse> getGroupsTopLevelCollections(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTopLevelCollections(id);
	}

	public CollectionsResponse getGroupsCollection(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getCollection(id, collectionId);
	}

	public List<CollectionsResponse> getGroupsSubCollection(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getSubCollection(id, collectionId);
	}

	/* ======================================================================
	 * Tags Requests
	 * ====================================================================== */

	// All tags in the library
	public List<TagsResponse> getAllTags() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllTags(this.defaultId);
	}
	
	// Tags of all types matching a specific name
	public List<TagsResponse> getAllTags(String urlEncodedTag) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllTags(this.defaultId, urlEncodedTag);
	}

	// Tags associated with a specific item
	public List<TagsResponse> getAllItemTags(String itemId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllItemTags(this.defaultId, itemId);
	}
	
	// Tags within a specific collection in the library
	public List<TagsResponse> getAllCollectionTags(String collectionId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllCollectionTags(this.defaultId, collectionId);
	}

	// All tags in the library, with the ability to filter based on the items
	// public List<ItemsResponse> getAllTags(String id, TagsQueryParams) throws JsonProcessingException, IOException;

	// Tags assigned to top-level items
	public List<TagsResponse> getTopLevelTags() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTopLevelTags(this.defaultId);
	}

	// Tags assigned to items in the trash
	public List<TagsResponse> getTrashTags() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTrashTags(this.defaultId);
	}

	// Tags assigned to items in a given collection
	public List<TagsResponse> getCollectionItemTags(String collectionId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getCollectionItemTags(this.defaultId, collectionId);
	}
	
	// Tags assigned to top-level items in a given collection
	public List<TagsResponse> getTopLevelCollectionItemTags(String collectionId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getTopLevelCollectionItemTags(this.defaultId, collectionId);
	}
	
	// Tags assigned to items in My Publications
	public List<TagsResponse> getMyPublicationTags() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getMyPublicationTags(this.defaultId);
	}

	// All tags in the library
	public List<TagsResponse> getUsersAllTags(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllTags(id);
	}
	
	// Tags of all types matching a specific name
	public List<TagsResponse> getUsersAllTags(String id, String urlEncodedTag) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllTags(id, urlEncodedTag);
	}

	// Tags associated with a specific item
	public List<TagsResponse> getUsersAllItemTags(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllItemTags(id, itemId);
	}
	
	// Tags within a specific collection in the library
	public List<TagsResponse> getUsersAllCollectionTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllCollectionTags(id, collectionId);
	}

	// All tags in the library, with the ability to filter based on the items
	// public List<ItemsResponse> getUsersAllTags(String id, TagsQueryParams) throws JsonProcessingException, IOException;

	// Tags assigned to top-level items
	public List<TagsResponse> getUsersTopLevelTags(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTopLevelTags(id);
	}

	// Tags assigned to items in the trash
	public List<TagsResponse> getUsersTrashTags(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTrashTags(id);
	}

	// Tags assigned to items in a given collection
	public List<TagsResponse> getUsersCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getCollectionItemTags(id, collectionId);
	}
	
	// Tags assigned to top-level items in a given collection
	public List<TagsResponse> getUsersTopLevelCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getTopLevelCollectionItemTags(id, collectionId);
	}
	
	// Tags assigned to items in My Publications
	public List<TagsResponse> getUsersMyPublicationTags(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getMyPublicationTags(id);
	}

	// All tags in the library
	public List<TagsResponse> getGroupsAllTags(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllTags(id);
	}
	
	// Tags of all types matching a specific name
	public List<TagsResponse> getGroupsAllTags(String id, String urlEncodedTag) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllTags(id, urlEncodedTag);
	}

	// Tags associated with a specific item
	public List<TagsResponse> getGroupsAllItemTags(String id, String itemId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllItemTags(id, itemId);
	}
	
	// Tags within a specific collection in the library
	public List<TagsResponse> getGroupsAllCollectionTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getAllCollectionTags(id, collectionId);
	}

	// All tags in the library, with the ability to filter based on the items
	// public List<ItemsResponse> getGroupsAllTags(String id, TagsQueryParams) throws JsonProcessingException, IOException;

	// Tags assigned to top-level items
	public List<TagsResponse> getGroupsTopLevelTags(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTopLevelTags(id);
	}

	// Tags assigned to items in the trash
	public List<TagsResponse> getGroupsTrashTags(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTrashTags(id);
	}

	// Tags assigned to items in a given collection
	public List<TagsResponse> getGroupsCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getCollectionItemTags(id, collectionId);
	}
	
	// Tags assigned to top-level items in a given collection
	public List<TagsResponse> getGroupsTopLevelCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getTopLevelCollectionItemTags(id, collectionId);
	}
	
	// Tags assigned to items in My Publications
	public List<TagsResponse> getGroupsMyPublicationTags(String id) throws JsonProcessingException, IOException
	{
		return this.groupsApi.getMyPublicationTags(id);
	}

	// All saved searches in the library
	public List<SearchesResponse> getAllSearches() throws JsonProcessingException, IOException
	{
		return this.defaultApi.getAllSearches(this.defaultId);
	}
	
	// A specific saved search in the library
	public SearchesResponse getSearch(String searchId) throws JsonProcessingException, IOException
	{
		return this.defaultApi.getSearch(this.defaultId, searchId);
	}

	// All saved searches in the library
	public List<SearchesResponse> getUsersAllSearches(String id) throws JsonProcessingException, IOException
	{
		return this.usersApi.getAllSearches(id);
	}
	
	// A specific saved search in the library
	public SearchesResponse getUsersSearch(String id, String searchId) throws JsonProcessingException, IOException
	{
		return this.usersApi.getSearch(id, searchId);
	}

	// All saved searches in the library
	public List<SearchesResponse> getGroupsAllSearches(String id) throws JsonProcessingException, IOException
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
	public List<GroupResponse> getUserGroups(String userId) throws JsonProcessingException, IOException
	{
		return this.miscRequestHandler.getUserGroups(userId);
	}

	public static void main(String[] args) throws JsonProcessingException, MalformedURLException, IOException, ProtocolException
	{
		Zotero zotero = new Zotero(TEST_API_KEY);

		zotero.setDefaultMode(TEST_USER_ID, Mode.USER);
		// zotero.setDefaultMode(TEST_GROUP_ID, Mode.GROUP);

		zotero.getAllSearches();

		// List<TagsResponse> tags = zotero.getAllTags();

		// for (TagsResponse tag : tags)
		// {
		// 	System.out.println(tag.getTag());
		// 	// System.out.println(String.format("%s | %14s | %14s | %s", item.getData().getKey(), item.getData().getParentItem(), item.getData().getItemType(), item.getData().getTitle()));
		// }
	}
}