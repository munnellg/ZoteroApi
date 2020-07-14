package ie.tcd.munnellg.zotero.interfaces;

import java.io.IOException;

import ie.tcd.munnellg.zotero.util.ZoteroList;

import ie.tcd.munnellg.zotero.model.SearchesResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface SearchesRequestHandler
{
	// All saved searches in the library
	public ZoteroList<SearchesResponse> getAllSearches(String id) throws JsonProcessingException, IOException;
	
	// A specific saved search in the library
	public SearchesResponse getSearch(String id, String searchId) throws JsonProcessingException, IOException;
}