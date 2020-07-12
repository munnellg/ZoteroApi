package ie.tcd.munnellg.zotero.model;

import java.net.URL;

import java.util.Map;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Get some test data so we can build this

public class SearchesResponse extends AbstractLinkable
{
	public SearchesResponse()
	{
		this(SearchesResponse.builder());
	}

	private SearchesResponse(SearchesResponseBuilder builder)
	{
	}

	public static SearchesResponseBuilder builder()
	{
		return new SearchesResponseBuilder();
	}

	public static class SearchesResponseBuilder
	{
		public SearchesResponseBuilder()
		{
		}

		public SearchesResponse build()
		{
			return new SearchesResponse(this);
		}
	}
}
