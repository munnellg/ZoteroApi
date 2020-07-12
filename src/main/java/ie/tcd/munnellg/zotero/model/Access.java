package ie.tcd.munnellg.zotero.model;

import java.net.URL;

import java.util.Map;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Access
{
	private UserPermission user;

	private Map<String, GroupPermission> groups;

	public Access()
	{
		this(Access.builder());
	}

	private Access(AccessBuilder builder)
	{
		this.user   = builder.user;
		this.groups = builder.groups;
	}

	public UserPermission getUser()
	{
		return this.user;
	}

	public void setUser(UserPermission user)
	{
		this.user = user;
	}

	public Map<String, GroupPermission> getGroups()
	{
		return this.groups;
	}

	public void setGroups(Map<String, GroupPermission> groups)
	{
		this.groups = groups;
	}

	public static AccessBuilder builder()
	{
		return new AccessBuilder();
	}

	public static class AccessBuilder
	{
		private UserPermission user;

		private Map<String, GroupPermission> groups;

		public AccessBuilder()
		{
			this.user   = null;
			this.groups = new HashMap<String, GroupPermission>();
		}

		public AccessBuilder setUser(UserPermission user)
		{
			this.user = user;
			return this;
		}

		public AccessBuilder setGroups(Map<String, GroupPermission> groups)
		{
			this.groups = groups;
			return this;
		}

		public Access build()
		{
			return new Access(this);
		}
	}
}
