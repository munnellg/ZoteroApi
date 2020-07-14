package ie.tcd.munnellg.zotero.interfaces;

import java.io.IOException;

import ie.tcd.munnellg.zotero.util.ZoteroList;

import ie.tcd.munnellg.zotero.model.CollectionsResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface CollectionsRequestHandler
{
	// Collections in the library
	public ZoteroList<CollectionsResponse> getAllCollections(String id) throws JsonProcessingException, IOException;
	public ZoteroList<CollectionsResponse> getAllCollections(String id, RequestParams params) throws JsonProcessingException, IOException;
	
	// Top-level collections in the library
	public ZoteroList<CollectionsResponse> getTopLevelCollections(String id) throws JsonProcessingException, IOException;
	public ZoteroList<CollectionsResponse> getTopLevelCollections(String id, RequestParams params) throws JsonProcessingException, IOException;

	// A specific collection in the library
	public CollectionsResponse getCollection(String id, String collectionId) throws JsonProcessingException, IOException;

	// Subcollections within a specific collection in the library
	public ZoteroList<CollectionsResponse> getSubCollection(String id, String collectionId) throws JsonProcessingException, IOException;
	public ZoteroList<CollectionsResponse> getSubCollection(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException;
}