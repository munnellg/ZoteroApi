package ie.tcd.munnellg.zotero.interfaces;

import java.io.IOException;

import java.util.List;

import ie.tcd.munnellg.zotero.model.CollectionsResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface CollectionsRequestHandler
{
	// Collections in the library
	public List<CollectionsResponse> getAllCollections(String id) throws JsonProcessingException, IOException;
	
	// Top-level collections in the library
	public List<CollectionsResponse> getTopLevelCollections(String id) throws JsonProcessingException, IOException;

	// A specific collection in the library
	public CollectionsResponse getCollection(String id, String collectionId) throws JsonProcessingException, IOException;

	// Subcollections within a specific collection in the library
	public List<CollectionsResponse> getSubCollection(String id, String collectionId) throws JsonProcessingException, IOException;
}