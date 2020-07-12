package ie.tcd.munnellg.zotero.model;

import java.net.URL;

import java.util.Map;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Collection
{
	private String key;

	private String version;

	private String parentCollection;

	private String name;

	private Map<String, String> relations;

	public Collection()
	{
		this(Collection.builder());
	}

	private Collection(CollectionBuilder builder)
	{
		this.key              = builder.key;
		this.version          = builder.version;
		this.parentCollection = builder.parentCollection;
		this.name             = builder.name;
		this.relations        = builder.relations;
	}

	public String getKey()
	{
		return this.key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getVersion()
	{
		return this.version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public String getParentCollection()
	{
		return this.parentCollection;
	}

	public void setParentCollection(String parentCollection)
	{
		this.parentCollection = parentCollection;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Map<String, String> getRelations()
	{
		return this.relations;
	}

	public void setRelations(Map<String, String> relations)
	{
		this.relations = relations;
	}

	public static CollectionBuilder builder()
	{
		return new CollectionBuilder();
	}

	public static class CollectionBuilder
	{
		private String key;
		private String version;
		private String parentCollection;
		private String name;
		private Map<String, String> relations;

		public CollectionBuilder()
		{
			this.key              = null;
			this.version          = null;
			this.parentCollection = null;
			this.name             = null;
			this.relations        = new HashMap<String, String>();
		}

		public CollectionBuilder setKey(String key)
		{
			this.key = key;
			return this;
		}

		public CollectionBuilder setVersion(String version)
		{
			this.version = version;
			return this;
		}

		public CollectionBuilder setParentCollection(String parentCollection)
		{
			this.parentCollection = parentCollection;
			return this;
		}

		public CollectionBuilder setName(String name)
		{
			this.name = name;
			return this;
		}

		public CollectionBuilder setRelations(Map<String, String> relations)
		{
			this.relations = relations;
			return this;
		}

		public Collection build()
		{
			return new Collection(this);
		}
	}
}
