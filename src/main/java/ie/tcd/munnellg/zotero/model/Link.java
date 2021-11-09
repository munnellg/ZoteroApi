package ie.tcd.munnellg.zotero.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Link
{
	@JsonProperty
	private String href;

	@JsonProperty
	private String type;

	@JsonProperty
	private String attachmentType;

	@JsonProperty
	private Integer attachmentSize;

	@JsonProperty
	private String title;

	@JsonProperty
	private Integer length;

	public Link()
	{
		this(null, null);
	}

	public Link(String href, String type)
	{
		this.href = href;
		this.type = type;
	}

	public String getHref()
	{
		return this.href;
	}

	public void setHref(String href)
	{
		this.href = href;
	}

	public String getType()
	{
		return this.type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getAttachmentType()
	{
		return this.attachmentType;
	}

	public void setAttachmentType(String attachmentType)
	{
		this.attachmentType = attachmentType;
	}

	public Integer getAttachmentSize()
	{
		return this.attachmentSize;
	}

	public void setAttachmentSize(Integer attachmentSize)
	{
		this.attachmentSize = attachmentSize;
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Integer getLength()
	{
		return this.length;
	}

	public void setLength(Integer length)
	{
		this.length = length;
	}
}
