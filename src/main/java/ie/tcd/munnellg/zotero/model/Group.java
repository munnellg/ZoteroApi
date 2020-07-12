package ie.tcd.munnellg.zotero.model;

import java.net.URL;

import java.util.Map;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Group extends AbstractLinkable
{
	private Integer id;

	private Integer version;

	private String name;

	private Integer owner;

	private String type;

	private String description;

	private String url;

	private String libraryEditing;

	private String libraryReading;

	private String fileEditing;

	private List<Integer> admins;

    public Group()
    {
    	this(Group.builder());
    }

    public Group(GroupBuilder builder)
    {
    }

    public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getVersion()
	{
		return this.version;
	}

	public void setVersion(Integer version)
	{
		this.version = version;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getOwner()
	{
		return this.owner;
	}

	public void setOwner(Integer owner)
	{
		this.owner = owner;
	}

	public String getType()
	{
		return this.type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getUrl()
	{
		return this.url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getLibraryEditing()
	{
		return this.libraryEditing;
	}

	public void setLibraryEditing(String libraryEditing)
	{
		this.libraryEditing = libraryEditing;
	}

	public String getLibraryReading()
	{
		return this.libraryReading;
	}

	public void setLibraryReading(String libraryReading)
	{
		this.libraryReading = libraryReading;
	}

	public String getFileEditing()
	{
		return this.fileEditing;
	}

	public void setFileEditing(String fileEditing)
	{
		this.fileEditing = fileEditing;
	}

	public List<Integer> getAdmins()
	{
		return this.admins;
	}

	public void setAdmins(List<Integer> admins)
	{
		this.admins = admins;
	}


    public static GroupBuilder builder()
    {
    	return new GroupBuilder();
    }

    public static class GroupBuilder
    {
    	private Integer id;
		private Integer version;
		private String name;
		private Integer owner;
		private String type;
		private String description;
		private String url;
		private String libraryEditing;
		private String libraryReading;
		private String fileEditing;
		private List<Integer> admins;

		public GroupBuilder()
		{
			this.id             = null;
			this.version        = null;
			this.name           = null;
			this.owner          = null;
			this.type           = null;
			this.description    = null;
			this.url            = null;
			this.libraryEditing = null;
			this.libraryReading = null;
			this.fileEditing    = null;
			this.admins         = new ArrayList<Integer>();
		}

		public GroupBuilder setId(Integer id)
		{
			this.id = id;
			return this;
		}

		public GroupBuilder setVersion(Integer version)
		{
			this.version = version;
			return this;
		}

		public GroupBuilder setName(String name)
		{
			this.name = name;
			return this;
		}

		public GroupBuilder setOwner(Integer owner)
		{
			this.owner = owner;
			return this;
		}

		public GroupBuilder setType(String type)
		{
			this.type = type;
			return this;
		}

		public GroupBuilder setDescription(String description)
		{
			this.description = description;
			return this;
		}

		public GroupBuilder setUrl(String url)
		{
			this.url = url;
			return this;
		}

		public GroupBuilder setLibraryEditing(String libraryEditing)
		{
			this.libraryEditing = libraryEditing;
			return this;
		}

		public GroupBuilder setLibraryReading(String libraryReading)
		{
			this.libraryReading = libraryReading;
			return this;
		}

		public GroupBuilder setFileEditing(String fileEditing)
		{
			this.fileEditing = fileEditing;
			return this;
		}

		public GroupBuilder setAdmins(List<Integer> admins)
		{
			this.admins = admins;
			return this;
		}

		public Group build()
		{
			return new Group(this);
		}
    }
}
