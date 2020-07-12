package ie.tcd.munnellg.zotero.interfaces;

import java.io.IOException;

import java.util.List;

import ie.tcd.munnellg.zotero.model.SearchesResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface SearchesRequestHandler
{
	// All saved searches in the library
	public List<SearchesResponse> getAllSearches(String id) throws JsonProcessingException, IOException;
	
	// A specific saved search in the library
	public SearchesResponse getSearch(String id, String searchId) throws JsonProcessingException, IOException;
}