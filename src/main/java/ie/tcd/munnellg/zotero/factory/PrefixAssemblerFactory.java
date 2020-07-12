package ie.tcd.munnellg.zotero.factory;

import ie.tcd.munnellg.zotero.interfaces.PrefixAssembler;

import ie.tcd.munnellg.zotero.impl.NoopPrefixAssembler;
import ie.tcd.munnellg.zotero.impl.UsersPrefixAssembler;
import ie.tcd.munnellg.zotero.impl.GroupsPrefixAssembler;

import ie.tcd.munnellg.zotero.enums.Mode;

public class PrefixAssemblerFactory
{
	public static PrefixAssembler assemble(Mode mode)
	{
		switch(mode)
		{
		case NONE:  return new NoopPrefixAssembler();
		case USER:  return new UsersPrefixAssembler();
		case GROUP: return new GroupsPrefixAssembler();
		}

		return null; // TODO: throw exception
	}
}