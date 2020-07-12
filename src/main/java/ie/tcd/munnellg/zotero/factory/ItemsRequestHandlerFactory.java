package ie.tcd.munnellg.zotero.factory;

import ie.tcd.munnellg.zotero.interfaces.RestEndpoint;
import ie.tcd.munnellg.zotero.interfaces.ItemsRequestHandler;

import ie.tcd.munnellg.zotero.impl.RestEndpointImpl;
import ie.tcd.munnellg.zotero.impl.ItemsRequestHandlerImpl;

import ie.tcd.munnellg.zotero.enums.Mode;

public class ItemsRequestHandlerFactory
{
	public static ItemsRequestHandler assemble(Mode mode)
	{
		return ItemsRequestHandlerFactory.assemble(mode, RestEndpointImpl.builder().build());
	}

	public static ItemsRequestHandler assemble(Mode mode, RestEndpoint endpoint)
	{
		return ItemsRequestHandlerImpl.builder()
					.setPrefixAssembler(PrefixAssemblerFactory.assemble(mode))
					.setRestEndpoint(endpoint)
					.build();
	}
}