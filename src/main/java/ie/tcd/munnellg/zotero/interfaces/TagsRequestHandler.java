package ie.tcd.munnellg.zotero.interfaces;

import java.io.IOException;

import java.util.List;

import ie.tcd.munnellg.zotero.model.TagsResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface TagsRequestHandler
{
	// All tags in the library
	public List<TagsResponse> getAllTags(String id) throws JsonProcessingException, IOException;
	
	// Tags of all types matching a specific name
	public List<TagsResponse> getAllTags(String id, String urlEncodedTag) throws JsonProcessingException, IOException;

	// Tags associated with a specific item
	public List<TagsResponse> getAllItemTags(String id, String itemId) throws JsonProcessingException, IOException;
	
	// Tags within a specific collection in the library
	public List<TagsResponse> getAllCollectionTags(String id, String collectionId) throws JsonProcessingException, IOException;

	// All tags in the library, with the ability to filter based on the items
	// public List<Item> getAllTags(String id, TagsQueryParams) throws JsonProcessingException, IOException;

	// Tags assigned to top-level items
	public List<TagsResponse> getTopLevelTags(String id) throws JsonProcessingException, IOException;

	// Tags assigned to items in the trash
	public List<TagsResponse> getTrashTags(String id) throws JsonProcessingException, IOException;

	// Tags assigned to items in a given collection
	public List<TagsResponse> getCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException;
	
	// Tags assigned to top-level items in a given collection
	public List<TagsResponse> getTopLevelCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException;
	
	// Tags assigned to items in My Publications
	public List<TagsResponse> getMyPublicationTags(String id) throws JsonProcessingException, IOException;
}