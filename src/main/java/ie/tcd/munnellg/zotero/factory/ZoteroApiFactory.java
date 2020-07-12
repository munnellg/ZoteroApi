package ie.tcd.munnellg.zotero.factory;

import ie.tcd.munnellg.zotero.interfaces.RestEndpoint;
import ie.tcd.munnellg.zotero.interfaces.ZoteroApi;

import ie.tcd.munnellg.zotero.impl.RestEndpointImpl;
import ie.tcd.munnellg.zotero.impl.ZoteroApiImpl;

import ie.tcd.munnellg.zotero.enums.Mode;

public class ZoteroApiFactory
{
	public static ZoteroApi assemble(Mode mode)
	{
		return ZoteroApiFactory.assemble(mode, RestEndpointImpl.builder().build());
	}

	public static ZoteroApi assemble(Mode mode, String apiRoot, String apiKey)
	{
		RestEndpoint restEndpoint = RestEndpointImpl.builder().setApiRoot(apiRoot).setApiKey(apiKey).build();
		return ZoteroApiFactory.assemble(mode, restEndpoint);
	}

	public static ZoteroApi assemble(Mode mode, RestEndpoint endpoint)
	{
		return ZoteroApiImpl.builder()
					.setItemsRequestHandler(ItemsRequestHandlerFactory.assemble(mode, endpoint))
					.setCollectionsRequestHandler(CollectionsRequestHandlerFactory.assemble(mode, endpoint))
					.setTagsRequestHandler(TagsRequestHandlerFactory.assemble(mode, endpoint))
					.setSearchesRequestHandler(SearchesRequestHandlerFactory.assemble(mode, endpoint))
					.setMiscRequestHandler(MiscRequestHandlerFactory.assemble(endpoint))
					.build();
	}
}