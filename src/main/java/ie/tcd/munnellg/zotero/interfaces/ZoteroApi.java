package ie.tcd.munnellg.zotero.interfaces;

import java.io.IOException;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ZoteroApi extends ItemsRequestHandler, CollectionsRequestHandler, TagsRequestHandler, SearchesRequestHandler, MiscRequestHandler
{
}