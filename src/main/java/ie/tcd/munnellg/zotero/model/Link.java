package ie.tcd.munnellg.zotero.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Link
{
	@JsonProperty
	private String href;

	@JsonProperty
	private String type;

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
}
