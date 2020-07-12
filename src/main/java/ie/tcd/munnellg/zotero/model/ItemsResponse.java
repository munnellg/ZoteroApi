package ie.tcd.munnellg.zotero.model;

import java.net.URL;

import java.util.Map;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemsResponse extends AbstractLinkable
{
	@JsonProperty
	private String key;

	@JsonProperty
	private Integer version;

	@JsonProperty
	private Library library;

	@JsonProperty
	private Meta meta;

	@JsonProperty
	private Item data;

	public ItemsResponse()
	{
		this(ItemsResponse.builder());
	}

	private ItemsResponse(ItemsResponseBuilder builder)
	{
		this.key     = builder.key;
		this.version = builder.version;
		this.library = builder.library;
		this.meta    = builder.meta;
		this.data    = builder.data;
	}
	
	public String getKey()
	{
		return this.key = key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public Integer getVersion()
	{
		return this.version = version;
	}

	public void setVersion(Integer version)
	{
		this.version = version;
	}

	public Library getLibrary()
	{
		return this.library = library;
	}

	public void setLibrary(Library library)
	{
		this.library = library;
	}

	public Meta getMeta()
	{
		return this.meta = meta;
	}

	public void setMeta(Meta meta)
	{
		this.meta = meta;
	}

	public Item getData()
	{
		return this.data = data;
	}

	public void setData(Item data)
	{
		this.data = data;
	}

	public static ItemsResponseBuilder builder()
	{
		return new ItemsResponseBuilder();
	}

	public static class ItemsResponseBuilder
	{
		private String key;
		private Integer version;
		private Library library;
		private Meta meta;
		private Item data;

		public ItemsResponseBuilder()
		{
			this.key = null;
			this.version = null;
			this.library = null;
			this.meta = null;
			this.data = null;
		}

		public ItemsResponseBuilder setKey(String key)
		{
			this.key = key;
			return this;
		}

		public ItemsResponseBuilder setVersion(Integer version)
		{
			this.version = version;
			return this;
		}

		public ItemsResponseBuilder setLibrary(Library library)
		{
			this.library = library;
			return this;
		}

		public ItemsResponseBuilder setMeta(Meta meta)
		{
			this.meta = meta;
			return this;
		}

		public ItemsResponseBuilder setData(Item data)
		{
			this.data = data;
			return this;
		}

		public ItemsResponse build()
		{
			return new ItemsResponse(this);
		}
	}
}
