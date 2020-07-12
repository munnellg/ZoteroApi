package ie.tcd.munnellg.zotero.model;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

public class Tag
{
	private String tag;

	private Integer type;

	public Tag()
	{
		this(null);
	}

	public Tag(String tag)
	{
		this.tag = tag;
	}

	public String getTag()
	{
		return this.tag;
	}

	public void setTag(String tag)
	{
		this.tag = tag;
	}

	public Integer getType()
	{
		return this.type;
	}

	public void setType(Integer type)
	{
		this.type = type;
	}
}
