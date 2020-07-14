package ie.tcd.munnellg.zotero.impl;

import java.io.IOException;
import java.net.MalformedURLException;

import ie.tcd.munnellg.zotero.util.ZoteroList;

import ie.tcd.munnellg.zotero.model.TagsResponse;

import ie.tcd.munnellg.zotero.interfaces.RestEndpoint;
import ie.tcd.munnellg.zotero.interfaces.RequestParams;
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
	private static final String URL_TAGS_FILTER_BY_ITEMS      = "items/tags";
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
	public ZoteroList<TagsResponse> getAllTags(String id) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_TAGS_ALL, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){});
	}
	
	public ZoteroList<TagsResponse> getAllTags(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_TAGS_ALL, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){}, params);
	}

	// Tags of all types matching a specific name
	public ZoteroList<TagsResponse> getAllTags(String id, String urlEncodedTag) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_TAGS_FILTERED, urlEncodedTag);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){});
	}

	public ZoteroList<TagsResponse> getAllTags(String id, String urlEncodedTag, RequestParams params) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_TAGS_FILTERED, urlEncodedTag);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){}, params);
	}

	// Tags associated with a specific item
	public ZoteroList<TagsResponse> getAllItemTags(String id, String itemId) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_TAGS_ITEMS, itemId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){});
	}

	public ZoteroList<TagsResponse> getAllItemTags(String id, String itemId, RequestParams params) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_TAGS_ITEMS, itemId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){}, params);
	}
	
	// Tags within a specific collection in the library
	public ZoteroList<TagsResponse> getAllCollectionTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_TAGS_COLLECTIONS, collectionId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){});
	}

	public ZoteroList<TagsResponse> getAllCollectionTags(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_TAGS_COLLECTIONS, collectionId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){}, params);
	}

	// All tags in the library, with the ability to filter based on the items
	public ZoteroList<TagsResponse> getAllTagsFilterByItems(String id) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_TAGS_ALL, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){});
	}

	public ZoteroList<TagsResponse> getAllTagsFilterByItems(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_TAGS_ALL, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){}, params);
	}

	// Tags assigned to top-level items
	public ZoteroList<TagsResponse> getTopLevelTags(String id) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_TAGS_TOP_LEVEL, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){});
	}

	public ZoteroList<TagsResponse> getTopLevelTags(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_TAGS_TOP_LEVEL, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){}, params);
	}

	// Tags assigned to items in the trash
	public ZoteroList<TagsResponse> getTrashTags(String id) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_TAGS_TRASH, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){});
	}

	public ZoteroList<TagsResponse> getTrashTags(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_TAGS_TRASH, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){}, params);
	}

	// Tags assigned to items in a given collection
	public ZoteroList<TagsResponse> getCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_TAGS_COLLECTION_ITEMS, collectionId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){});
	}

	public ZoteroList<TagsResponse> getCollectionItemTags(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_TAGS_COLLECTION_ITEMS, collectionId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){}, params);
	}
	
	// Tags assigned to top-level items in a given collection
	public ZoteroList<TagsResponse> getTopLevelCollectionItemTags(String id, String collectionId) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_TAGS_COLLECTION_ITEMS_TOP, collectionId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){});
	}
	
	public ZoteroList<TagsResponse> getTopLevelCollectionItemTags(String id, String collectionId, RequestParams params) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_TAGS_COLLECTION_ITEMS_TOP, collectionId);

		return this.restEndpoint.getList(id, path, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){}, params);
	}

	// Tags assigned to items in My Publications
	public ZoteroList<TagsResponse> getMyPublicationTags(String id) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_TAGS_PUBLICATIONS, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){});
	}

	public ZoteroList<TagsResponse> getMyPublicationTags(String id, RequestParams params) throws JsonProcessingException, IOException
	{
		return this.restEndpoint.getList(id, URL_TAGS_PUBLICATIONS, this.prefixAssembler, new TypeReference<ZoteroList<TagsResponse>>(){}, params);
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