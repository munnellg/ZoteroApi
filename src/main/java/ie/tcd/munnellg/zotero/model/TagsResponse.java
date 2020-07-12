package ie.tcd.munnellg.zotero.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TagsResponse extends AbstractLinkable
{
	private String tag;

	private Meta meta;

	public TagsResponse()
	{
		this(TagsResponse.builder());
	}

	private TagsResponse(TagsResponseBuilder builder)
	{
		this.tag   = builder.tag;
		this.meta  = builder.meta;
	}

	public String getTag()
	{
		return this.tag;
	}

	public void setTag(String tag)
	{
		this.tag = tag;
	}

	public Meta getMeta()
	{
		return this.meta;
	}

	public void setMeta(Meta meta)
	{
		this.meta = meta;
	}

	public static TagsResponseBuilder builder()
	{
		return new TagsResponseBuilder();
	}

	public static class TagsResponseBuilder
	{
		private String tag;
		private Meta meta;

		public TagsResponseBuilder()
		{
			this.tag  = null;
			this.meta = null;
		}

		public TagsResponseBuilder setTag(String tag)
		{
			this.tag = tag;
			return this;
		}
		
		public TagsResponseBuilder setMeta(Meta meta)
		{
			this.meta = meta;
			return this;
		}

		public TagsResponse build()
		{
			return new TagsResponse(this);
		}
	}
}
