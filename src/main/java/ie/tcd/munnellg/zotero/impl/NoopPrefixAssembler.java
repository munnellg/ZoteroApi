package ie.tcd.munnellg.zotero.impl;

import ie.tcd.munnellg.zotero.interfaces.PrefixAssembler;

public class NoopPrefixAssembler implements PrefixAssembler
{
	public String assemble(String id)
	{
		return "";
	}
}