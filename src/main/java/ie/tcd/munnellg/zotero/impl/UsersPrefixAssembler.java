package ie.tcd.munnellg.zotero.impl;

import ie.tcd.munnellg.zotero.interfaces.PrefixAssembler;

public class UsersPrefixAssembler implements PrefixAssembler
{
	private static final String PREFIX_FORMAT = "users/%s/";

	public String assemble(String id)
	{
		return String.format(PREFIX_FORMAT, id);
	}
}