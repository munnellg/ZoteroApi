package ie.tcd.munnellg.zotero.impl;

import java.io.IOException;

import java.util.List;

import ie.tcd.munnellg.zotero.model.GroupResponse;
import ie.tcd.munnellg.zotero.model.KeyPermissions;

import ie.tcd.munnellg.zotero.impl.NoopPrefixAssembler;

import ie.tcd.munnellg.zotero.interfaces.RestEndpoint;
import ie.tcd.munnellg.zotero.interfaces.PrefixAssembler;
import ie.tcd.munnellg.zotero.interfaces.MiscRequestHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;

public class MiscRequestHandlerImpl implements MiscRequestHandler
{
	protected static final String URL_KEY_PERMISSIONS = "keys/%s";
	protected static final String URL_USER_GROUPS     = "users/%s/groups";

	private RestEndpoint restEndpoint;
	
	private PrefixAssembler prefixAssembler;

	public MiscRequestHandlerImpl()
	{
		this(MiscRequestHandlerImpl.builder());
	}

	private MiscRequestHandlerImpl(MiscRequestHandlerImplBuilder builder)
	{
		this.restEndpoint    = builder.restEndpoint;
		this.prefixAssembler = builder.prefixAssembler;
	}

	// All items in the library, excluding trashed items
	public KeyPermissions getKeyPermissions(String key) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_KEY_PERMISSIONS, key);

		return this.restEndpoint.getOne(null, path, this.prefixAssembler, KeyPermissions.class);
	}
	
	// Top-level items in the library, excluding trashed items
	public List<GroupResponse> getUserGroups(String userId) throws JsonProcessingException, IOException
	{
		final String path = String.format(URL_USER_GROUPS, userId);

		return this.restEndpoint.getList(null, path, this.prefixAssembler, new TypeReference<List<GroupResponse>>(){});
	}

	public static MiscRequestHandlerImplBuilder builder()
	{
		return new MiscRequestHandlerImplBuilder();
	}

	public static class MiscRequestHandlerImplBuilder
	{
		private RestEndpoint restEndpoint;
		private PrefixAssembler prefixAssembler;

		private MiscRequestHandlerImplBuilder()
		{
			this.restEndpoint    = null;
			this.prefixAssembler = new NoopPrefixAssembler();
		}
  
		public MiscRequestHandlerImplBuilder setRestEndpoint(RestEndpoint restEndpoint)
		{
			this.restEndpoint = restEndpoint;
			return this;
		}

		public MiscRequestHandlerImpl build()
		{
			return new MiscRequestHandlerImpl(this);
		}
	}
}