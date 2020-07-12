package ie.tcd.munnellg.zotero.model;

import java.net.URL;

import java.util.Map;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GroupResponse extends AbstractLinkable
{
	private Integer id;

	private Integer version;

	private Meta meta;

	private Group data;

    public GroupResponse()
    {
    	this(GroupResponse.builder());
    }

    public GroupResponse(GroupResponseBuilder builder)
    {
    	this.id      = builder.id;
		this.version = builder.version;
		this.meta    = builder.meta;
		this.data    = builder.data;
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

	public Meta getMeta()
	{
		return this.meta;
	}

	public void setMeta(Meta meta)
	{
		this.meta = meta;
	}

	public Group getData()
	{
		return this.data;
	}

	public void setData(Group data)
	{
		this.data = data;
	}

    public static GroupResponseBuilder builder()
    {
    	return new GroupResponseBuilder();
    }

    public static class GroupResponseBuilder
    {
    	private Integer id;
		private Integer version;
		private Meta meta;
		private Group data;

		public GroupResponseBuilder()
		{
			this.id = null;
			this.version = null;
			this.meta = null;
			this.data = null;
		}
		
		public GroupResponseBuilder setId(Integer id)
		{
			this.id = id;
			return this;
		}

		public GroupResponseBuilder setVersion(Integer version)
		{
			this.version = version;
			return this;
		}

		public GroupResponseBuilder setMeta(Meta meta)
		{
			this.meta = meta;
			return this;
		}

		public GroupResponseBuilder setData(Group data)
		{
			this.data = data;
			return this;
		}

		public GroupResponse build()
		{
			return new GroupResponse(this);
		}
    }
}
