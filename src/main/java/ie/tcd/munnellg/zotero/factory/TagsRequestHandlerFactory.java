package ie.tcd.munnellg.zotero.factory;

import ie.tcd.munnellg.zotero.interfaces.RestEndpoint;
import ie.tcd.munnellg.zotero.interfaces.TagsRequestHandler;

import ie.tcd.munnellg.zotero.impl.RestEndpointImpl;
import ie.tcd.munnellg.zotero.impl.TagsRequestHandlerImpl;

import ie.tcd.munnellg.zotero.enums.Mode;

public class TagsRequestHandlerFactory
{
	public static TagsRequestHandler assemble(Mode mode)
	{
		return TagsRequestHandlerFactory.assemble(mode, RestEndpointImpl.builder().build());
	}

	public static TagsRequestHandler assemble(Mode mode, RestEndpoint endpoint)
	{
		return TagsRequestHandlerImpl.builder()
					.setPrefixAssembler(PrefixAssemblerFactory.assemble(mode))
					.setRestEndpoint(endpoint)
					.build();
	}
}