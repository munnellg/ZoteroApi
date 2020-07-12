package ie.tcd.munnellg.zotero.interfaces;

import java.io.IOException;

import java.util.List;

import ie.tcd.munnellg.zotero.model.ItemsResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ItemsRequestHandler
{
	// All items in the library, excluding trashed items
	public List<ItemsResponse> getAllItems(String id) throws JsonProcessingException, IOException;
	
	// Top-level items in the library, excluding trashed items
	public List<ItemsResponse> getTopLevelItems(String id) throws JsonProcessingException, IOException;

	// Items in the trash
	public List<ItemsResponse> getTrashedItems(String id) throws JsonProcessingException, IOException;

	// A specific item in the library
	public ItemsResponse getItem(String id, String itemId) throws JsonProcessingException, IOException;

	// Child items under a specific item
	public List<ItemsResponse> getChildren(String id, String itemId) throws JsonProcessingException, IOException;

	// Items in My Publications
	public List<ItemsResponse> getMyPublications(String id) throws JsonProcessingException, IOException;

	// Items within a specific collection in the library
	public List<ItemsResponse> getCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException;

	// Top-level items within a specific collection in the library
	public List<ItemsResponse> getTopCollectionItems(String id, String collectionId) throws JsonProcessingException, IOException;
}