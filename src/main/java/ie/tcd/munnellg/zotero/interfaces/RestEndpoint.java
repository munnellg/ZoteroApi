package ie.tcd.munnellg.zotero.interfaces;

import java.util.List;

import java.io.IOException;

import ie.tcd.munnellg.zotero.interfaces.PrefixAssembler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface RestEndpoint
{
	void setApiKey(String apiKey);

	void setApiRoot(String apiRoot);

	<T> List<T> getList(String id, String path, PrefixAssembler prefixAssembler, TypeReference<List<T>> typeRef) throws JsonProcessingException, IOException;

	<T> T getOne(String id, String path, PrefixAssembler prefixAssembler, Class<T> clazz) throws JsonProcessingException, IOException;
}