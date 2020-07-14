package ie.tcd.munnellg.zotero.interfaces;

import java.io.IOException;

import ie.tcd.munnellg.zotero.util.ZoteroList;

import ie.tcd.munnellg.zotero.model.TagsResponse;

import ie.tcd.munnellg.zotero.interfaces.RequestParams;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface TagsRequestHandler
{
	// All tags in the library
	public ZoteroList<TagsResponse> getAllTags(String id) throws JsonProcessingException, IOException;
	public ZoteroList<TagsResponse> getAllTags(String id, RequestParams params) throws JsonProcessingException, IOException;
	
	// Tags of all types matching a specific name
	public ZoteroList<TagsResponse> getAllTags(String id, String urlEncodedTag) throws JsonProcessingException, IOException;
	public ZoteroList<TagsResponse> getAllTags(String id, String urlEncodedTag, RequestParams params) throws JsonProcessingException, IOException;

	// Tags associated with a specific item
	public ZoteroList<TagsResponse> getAllItemTags(String id, String itemId) throws JsonProcessingException, IOException;
	public ZoteroList<TagsResponse> getAllItemTags(String id, String itemId, RequestParams params) throws JsonProcessingException, IOException;
	
	// Tags within a specific collection in the library
	public ZoteroList<TagsResponse> getAllCollectionTags(String id, String collectionId) throws JsonProcessingException, IOException;
	public ZoteroList<TagsResponse> getAllCollectionTags(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException;

	// All tags in the library, with the ability to filter based on the items
	public ZoteroList<TagsResponse> getAllTagsFilterByItems(String id) throws JsonProcessingException, IOException;
	public ZoteroList<TagsResponse> getAllTagsFilterByItems(String id, RequestParams params) throws JsonProcessingException, IOException;

	// Tags assigned to top-level items
	public ZoteroList<TagsResponse> getTopLevelTags(String id) throws JsonProcessingException, IOException;
	public ZoteroList<TagsResponse> getTopLevelTags(String id, RequestParams params) throws JsonProcessingException, IOException;

	// Tags assigned to items in the trash
	public ZoteroList<TagsResponse> getTrashTags(String id) throws JsonProcessingException, IOException;
	public ZoteroList<TagsResponse> getTrashTags(String id, RequestParams params) throws JsonProcessingException, IOException;

	// Tags assigned to items in a given collection
	public ZoteroList<TagsResponse> getCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException;
	public ZoteroList<TagsResponse> getCollectionItemTags(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException;
	
	// Tags assigned to top-level items in a given collection
	public ZoteroList<TagsResponse> getTopLevelCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException;
	public ZoteroList<TagsResponse> getTopLevelCollectionItemTags(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException;
	
	// Tags assigned to items in My Publications
	public ZoteroList<TagsResponse> getMyPublicationTags(String id) throws JsonProcessingException, IOException;
	public ZoteroList<TagsResponse> getMyPublicationTags(String id, RequestParams params) throws JsonProcessingException, IOException;
}