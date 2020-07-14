package ie.tcd.munnellg.zotero.model;

import java.net.URL;

import java.util.Map;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Library extends AbstractLinkable
{
	private String id;
	
	private String type;

	private String name;

	public Library()
	{
		this(Library.builder());
	}

	public Library(LibraryBuilder builder)
	{
		this.id   = builder.id;
		this.type = builder.type;
		this.name = builder.name;
	}

	public String getId()
	{
		return this.id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getType()
	{
		return this.type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public static LibraryBuilder builder()
	{
		return new LibraryBuilder();
	}

	public static class LibraryBuilder
	{
		private String id;
		private String type;
		private String name;

		public LibraryBuilder()
		{
			this.id   = null;
			this.type = null;
			this.name = null;
		}

		public LibraryBuilder setId(String id)
		{
			 this.id =  id;
			 return this;
		}

		public LibraryBuilder setType(String type)
		{
			 this.type =  type;
			 return this;
		}

		public LibraryBuilder setName(String name)
		{
			 this.name =  name;
			 return this;
		}

		public Library build()
		{
			return new Library(this);
		}
	}
}
