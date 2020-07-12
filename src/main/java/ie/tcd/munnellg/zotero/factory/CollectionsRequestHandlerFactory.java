package ie.tcd.munnellg.zotero.factory;

import ie.tcd.munnellg.zotero.interfaces.RestEndpoint;
import ie.tcd.munnellg.zotero.interfaces.CollectionsRequestHandler;

import ie.tcd.munnellg.zotero.impl.RestEndpointImpl;
import ie.tcd.munnellg.zotero.impl.CollectionsRequestHandlerImpl;

import ie.tcd.munnellg.zotero.enums.Mode;

public class CollectionsRequestHandlerFactory
{
	public static CollectionsRequestHandler assemble(Mode mode)
	{
		return CollectionsRequestHandlerFactory.assemble(mode, RestEndpointImpl.builder().build());
	}

	public static CollectionsRequestHandler assemble(Mode mode, RestEndpoint endpoint)
	{
		return CollectionsRequestHandlerImpl.builder()
					.setPrefixAssembler(PrefixAssemblerFactory.assemble(mode))
					.setRestEndpoint(endpoint)
					.build();
	}
}