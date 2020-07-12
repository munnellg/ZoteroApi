package ie.tcd.munnellg.zotero.model;

import java.net.URL;

import java.util.Map;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Creator extends AbstractLinkable
{
	private String creatorType;

	private String firstName;

	private String lastName;

    public Creator()
    {
    	this(Creator.builder());
    }

    public Creator(CreatorBuilder builder)
    {
    	this.creatorType = builder.creatorType;
		this.firstName   = builder.firstName;
		this.lastName    = builder.lastName;
    }

	public String getCreatorType()
	{
		return this.creatorType = creatorType;
	}

	public void setCreatorType(String creatorType)
	{
		this.creatorType = creatorType;
	}

	public String getFirstName()
	{
		return this.firstName = firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return this.lastName = lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

    public static CreatorBuilder builder()
    {
    	return new CreatorBuilder();
    }

    public static class CreatorBuilder
    {
    	private String creatorType;
		private String firstName;
		private String lastName;

		public CreatorBuilder()
		{
			this.creatorType = null;
			this.firstName   = null;
			this.lastName    = null;
		}

		public CreatorBuilder setCreatorType(String creatorType)
		{
			this.creatorType = creatorType;
			return this;
		}

		public CreatorBuilder setFirstName(String firstName)
		{
			this.firstName = firstName;
			return this;
		}

		public CreatorBuilder setLastName(String lastName)
		{
			this.lastName = lastName;
			return this;
		}

		public Creator build()
		{
			return new Creator(this);
		}
    }
}
