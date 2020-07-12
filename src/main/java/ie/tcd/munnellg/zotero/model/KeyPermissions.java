package ie.tcd.munnellg.zotero.model;

import java.net.URL;

import java.util.Map;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KeyPermissions
{
	@JsonProperty("key")
	private String key;

	@JsonProperty("userID")
	private String userId;

	@JsonProperty("username")
	private String username;

	@JsonProperty("access")
	private Access access;

    public KeyPermissions()
    {
    	this(KeyPermissions.builder());
    }

    public KeyPermissions(KeyPermissionsBuilder builder)
    {
    	this.key      = builder.key;
		this.userId   = builder.userId;
		this.username = builder.username;
		this.access   = builder.access;
    }

	public String getKey()
	{
		return this.key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getUserId()
	{
		return this.userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public Access getAccess()
	{
		return this.access;
	}

	public void setAccess(Access access)
	{
		this.access = access;
	}

    public static KeyPermissionsBuilder builder()
    {
    	return new KeyPermissionsBuilder();
    }

    public static class KeyPermissionsBuilder
    {
    	private String key;
		private String userId;
		private String username;
		private Access access;

		public KeyPermissionsBuilder()
		{
			this.key      = null;
			this.userId   = null;
			this.username = null;
			this.access   = null;
		}

		public KeyPermissionsBuilder setKey(String key)
		{
			this.key = key;
			return this;
		}

		public KeyPermissionsBuilder setUserId(String userId)
		{
			this.userId = userId;
			return this;
		}

		public KeyPermissionsBuilder setUsername(String username)
		{
			this.username = username;
			return this;
		}

		public KeyPermissionsBuilder setAccess(Access access)
		{
			this.access = access;
			return this;
		}

		public KeyPermissions build()
		{
			return new KeyPermissions(this);
		}
    }
}
