package ie.tcd.munnellg.zotero.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User extends AbstractLinkable
{
	@JsonProperty
	private Integer id;

	@JsonProperty
	private String username;

	@JsonProperty
	private String name;

	public User()
	{
		this(User.builder());
	}

	private User(UserBuilder builder)
	{
		this.username = builder.username;
		this.name     = builder.name;
	}

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public static UserBuilder builder()
	{
		return new UserBuilder();
	}

	public static class UserBuilder
	{
		private String username;
		private String name;

		public UserBuilder()
		{
			this.username = null;
			this.name     = null;
		}

		public UserBuilder setUsername(String username)
		{
			this.username = username;
			return this;
		}
		
		public UserBuilder setName(String name)
		{
			this.name = name;
			return this;
		}

		public User build()
		{
			return new User(this);
		}
	}
}
