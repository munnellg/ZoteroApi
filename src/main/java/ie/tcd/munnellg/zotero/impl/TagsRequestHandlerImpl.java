package ie.tcd.munnellg.zotero.impl;

import java.io.IOException;
import java.net.MalformedURLException;

import java.util.List;

import ie.tcd.munnellg.zotero.model.TagsResponse;
import ie.tcd.munnellg.zotero.interfaces.RestEndpoint;
import ie.tcd.munnellg.zotero.interfaces.PrefixAssembler;
import ie.tcd.munnellg.zotero.interfaces.TagsRequestHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;

public class TagsRequestHandlerImpl implements TagsRequestHandler
{
	private static final String URL_TAGS_ALL                  = "tags";
	private static final String URL_TAGS_FILTERED             = "tags/%s";
	private static final String URL_TAGS_ITEMS                = "items/%s/tags";
	private static final String URL_TAGS_COLLECTIONS          = "collections/%s/tags";
	// private static final String URL_TAGS_ALL = "items/tags";
	private static final String URL_TAGS_TOP_LEVEL            = "items/top/tags";
	private static final String URL_TAGS_TRASH                = "items/trash/tags";
	private static final String URL_TAGS_COLLECTION_ITEMS     = "items/%s/items/tags";
	private static final String URL_TAGS_COLLECTION_ITEMS_TOP = "items/%s/items/top/tags";
	private static final String URL_TAGS_PUBLICATIONS         = "publications/items/tags";

	private RestEndpoint restEndpoint;
	
	private PrefixAssembler prefixAssembler;

	private TagsRequestHandlerImpl()
	{
		this(TagsRequestHandlerImpl.builder());
	}

	private TagsRequestHandlerImpl(TagsRequestHandlerImplBuilder builder)
	{
		this.restEndpoint    = builder.restEndpoint;
		this.prefixAssembler = builder.prefixAssembler;
	}

	// All tags in the library
	public List<TagsResponse> getAllTags(String id) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_TAGS_ALL, this.prefixAssembler, new TypeReference<List<TagsResponse>>(){});
	}
	
	// Tags of all types matching a specific name
	public List<TagsResponse> getAllTags(String id, String urlEncodedTag) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_TAGS_FILTERED, urlEncodedTag);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<List<TagsResponse>>(){});
	}

	// Tags associated with a specific item
	public List<TagsResponse> getAllItemTags(String id, String itemId) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_TAGS_ITEMS, itemId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<List<TagsResponse>>(){});
	}
	
	// Tags within a specific collection in the library
	public List<TagsResponse> getAllCollectionTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_TAGS_COLLECTIONS, collectionId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<List<TagsResponse>>(){});
	}

	// All tags in the library, with the ability to filter based on the items
	// public List<Item> getAllTags(String id, TagsQueryParams) throws JsonProcessingException, IOException;

	// Tags assigned to top-level items
	public List<TagsResponse> getTopLevelTags(String id) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_TAGS_TOP_LEVEL, this.prefixAssembler, new TypeReference<List<TagsResponse>>(){});
	}

	// Tags assigned to items in the trash
	public List<TagsResponse> getTrashTags(String id) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_TAGS_TRASH, this.prefixAssembler, new TypeReference<List<TagsResponse>>(){});
	}

	// Tags assigned to items in a given collection
	public List<TagsResponse> getCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_TAGS_COLLECTION_ITEMS, collectionId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<List<TagsResponse>>(){});
	}
	
	// Tags assigned to top-level items in a given collection
	public List<TagsResponse> getTopLevelCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_TAGS_COLLECTION_ITEMS_TOP, collectionId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<List<TagsResponse>>(){});
	}
	
	// Tags assigned to items in My Publications
	public List<TagsResponse> getMyPublicationTags(String id) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_TAGS_PUBLICATIONS, this.prefixAssembler, new TypeReference<List<TagsResponse>>(){});
	}

	public static TagsRequestHandlerImplBuilder builder()
	{
		return new TagsRequestHandlerImplBuilder();
	}

	public static class TagsRequestHandlerImplBuilder
	{
		private RestEndpoint restEndpoint;
		private PrefixAssembler prefixAssembler;

		private TagsRequestHandlerImplBuilder()
		{
			this.restEndpoint    = null;
			this.prefixAssembler = null;
		}
  
		public TagsRequestHandlerImplBuilder setRestEndpoint(RestEndpoint restEndpoint)
		{
			this.restEndpoint = restEndpoint;
			return this;
		}

		public TagsRequestHandlerImplBuilder setPrefixAssembler(PrefixAssembler prefixAssembler)
		{
			this.prefixAssembler = prefixAssembler;
			return this;
		}

		public TagsRequestHandlerImpl build()
		{
			return new TagsRequestHandlerImpl(this);
		}
	}
}