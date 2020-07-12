package ie.tcd.munnellg.zotero.model;

public class GroupPermission
{
	private Boolean library;

	private Boolean write;

	public GroupPermission()
	{
		this(null);
	}

	public GroupPermission(Boolean library)
	{
		this.library = library;
	}

	public Boolean getLibrary()
	{
		return this.library;
	}

	public void setLibrary(Boolean library)
	{
		this.library = library;
	}

	public Boolean getWrite()
	{
		return this.write;
	}

	public void setWrite(Boolean write)
	{
		this.write = write;
	}
}
