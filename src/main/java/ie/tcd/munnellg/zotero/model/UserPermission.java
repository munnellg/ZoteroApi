package ie.tcd.munnellg.zotero.model;

public class UserPermission
{
	private Boolean library;

	private Boolean files;

	public UserPermission()
	{
		this(null);
	}

	public UserPermission(Boolean library)
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

	public Boolean getFiles()
	{
		return this.files;
	}

	public void setFiles(Boolean files)
	{
		this.files = files;
	}
}
