package ie.tcd.munnellg.zotero.factory;

import ie.tcd.munnellg.zotero.interfaces.RestEndpoint;
import ie.tcd.munnellg.zotero.interfaces.MiscRequestHandler;

import ie.tcd.munnellg.zotero.impl.RestEndpointImpl;
import ie.tcd.munnellg.zotero.impl.MiscRequestHandlerImpl;

import ie.tcd.munnellg.zotero.enums.Mode;

public class MiscRequestHandlerFactory
{
	public static MiscRequestHandler assemble(String apiRoot, String apiKey)
	{
		RestEndpoint restEndpoint = RestEndpointImpl.builder().setApiRoot(apiRoot).setApiKey(apiKey).build();
		return MiscRequestHandlerFactory.assemble(restEndpoint);
	}

	public static MiscRequestHandler assemble(RestEndpoint endpoint)
	{
		return MiscRequestHandlerImpl.builder()
					.setRestEndpoint(endpoint)
					.build();
	}
}