package ie.tcd.munnellg.zotero.factory;

import ie.tcd.munnellg.zotero.interfaces.RestEndpoint;
import ie.tcd.munnellg.zotero.interfaces.SearchesRequestHandler;

import ie.tcd.munnellg.zotero.impl.RestEndpointImpl;
import ie.tcd.munnellg.zotero.impl.SearchesRequestHandlerImpl;

import ie.tcd.munnellg.zotero.enums.Mode;

public class SearchesRequestHandlerFactory
{
	public static SearchesRequestHandler assemble(Mode mode)
	{
		return SearchesRequestHandlerFactory.assemble(mode, RestEndpointImpl.builder().build());
	}

	public static SearchesRequestHandler assemble(Mode mode, RestEndpoint endpoint)
	{
		return SearchesRequestHandlerImpl.builder()
					.setPrefixAssembler(PrefixAssemblerFactory.assemble(mode))
					.setRestEndpoint(endpoint)
					.build();
	}
}