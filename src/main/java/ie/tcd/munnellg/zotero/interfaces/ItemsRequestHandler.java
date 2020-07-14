package ie.tcd.munnellg.zotero.interfaces;

import java.io.IOException;

import ie.tcd.munnellg.zotero.util.ZoteroList;

import ie.tcd.munnellg.zotero.model.ItemsResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ItemsRequestHandler
{
	// All items in the library, excluding trashed items
	public ZoteroList<ItemsResponse> getAllItems(String id) throws JsonProcessingException, IOException;
	public ZoteroList<ItemsResponse> getAllItems(String id, RequestParams params) throws JsonProcessingException, IOException;
	
	// Top-level items in the library, excluding trashed items
	public ZoteroList<ItemsResponse> getTopLevelItems(String id) throws JsonProcessingException, IOException;
	public ZoteroList<ItemsResponse> getTopLevelItems(String id, RequestParams params) throws JsonProcessingException, IOException;

	// Items in the trash
	public ZoteroList<ItemsResponse> getTrashedItems(String id) throws JsonProcessingException, IOException;
	public ZoteroList<ItemsResponse> getTrashedItems(String id, RequestParams params) throws JsonProcessingException, IOException;

	// A specific item in the library
	public ItemsResponse getItem(String id, String itemId) throws JsonProcessingException, IOException;

	// Child items under a specific item
	public ZoteroList<ItemsResponse> getChildren(String id, String itemId) throws JsonProcessingException, IOException;
	public ZoteroList<ItemsResponse> getChildren(String id, String itemId, RequestParams params) throws JsonProcessingException, IOException;

	// Items in My Publications
	public ZoteroList<ItemsResponse> getMyPublications(String id) throws JsonProcessingException, IOException;
	public ZoteroList<ItemsResponse> getMyPublications(String id, RequestParams params) throws JsonProcessingException, IOException;

	// Items within a specific collection in the library
	public ZoteroList<ItemsResponse> getCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException;
	public ZoteroList<ItemsResponse> getCollectionItems(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException;

	// Top-level items within a specific collection in the library
	public ZoteroList<ItemsResponse> getTopCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException;
	public ZoteroList<ItemsResponse> getTopCollectionItems(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException;
}