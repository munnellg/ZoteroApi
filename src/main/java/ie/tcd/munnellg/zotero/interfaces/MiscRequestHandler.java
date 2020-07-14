package ie.tcd.munnellg.zotero.interfaces;

import java.io.IOException;

import ie.tcd.munnellg.zotero.util.ZoteroList;

import ie.tcd.munnellg.zotero.model.GroupResponse;
import ie.tcd.munnellg.zotero.model.KeyPermissions;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface MiscRequestHandler
{
	// The user id and privileges of the given API key.
	public KeyPermissions getKeyPermissions(String key) throws JsonProcessingException, IOException;
	
	// The set of groups the current API key has access to, including public groups the key owner belongs to even if the key doesn't have explicit permissions for them.
	public ZoteroList<GroupResponse> getUserGroups(String userId) throws JsonProcessingException, IOException;
}