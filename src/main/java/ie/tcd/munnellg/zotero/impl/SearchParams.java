package ie.tcd.munnellg.zotero.impl;

import java.util.List;
import java.util.ArrayList;

import ie.tcd.munnellg.zotero.util.QueryStringEncoder;
import ie.tcd.munnellg.zotero.interfaces.RequestParams;

public class SearchParams implements RequestParams
{
	private String itemKey;

	private String itemType;

	private String q;

	private Integer since;

	private String tag;

	private Integer includeTrashed;

	private String qmode;

	private String itemQ;

	private String itemQMode;

	private String itemTag;

	public SearchParams()
	{
		this(SearchParams.builder());
	}

	private SearchParams(SearchParamsBuilder builder)
	{
		this.itemKey        = builder.itemKey;
		this.itemType       = builder.itemType;
		this.q              = builder.q;
		this.since          = builder.since;
		this.tag            = builder.tag;
		this.includeTrashed = builder.includeTrashed;
		this.qmode          = builder.qmode;
		this.itemQ          = builder.itemQ;
		this.itemQMode      = builder.itemQMode;
		this.itemTag        = builder.itemTag;
	}

	public String getItemKey()
	{
		return this.itemKey;
	}

	public void setItemKey(String itemKey)
	{
		this.itemKey = itemKey;		
	}

	public String getItemType()
	{
		return this.itemType;
	}

	public void setItemType(String itemType)
	{
		this.itemType = itemType;		
	}

	public String getQ()
	{
		return this.q;
	}

	public void setQ(String q)
	{
		this.q = q;		
	}

	public Integer getSince()
	{
		return this.since;
	}

	public void setSince(Integer since)
	{
		this.since = since;		
	}

	public String getTag()
	{
		return this.tag;
	}

	public void setTag(String tag)
	{
		this.tag = tag;		
	}

	public Integer getIncludeTrashed()
	{
		return this.includeTrashed;
	}

	public void setIncludeTrashed(Integer includeTrashed)
	{
		this.includeTrashed = includeTrashed;		
	}

	public String getQmode()
	{
		return this.qmode;
	}

	public void setQmode(String qmode)
	{
		this.qmode = qmode;		
	}

	public String getItemQ()
	{
		return this.itemQ;
	}

	public void setItemQ(String itemQ)
	{
		this.itemQ = itemQ;		
	}

	public String getItemQMode()
	{
		return this.itemQMode;
	}

	public void setItemQMode(String itemQMode)
	{
		this.itemQMode = itemQMode;		
	}

	public String getItemTag()
	{
		return this.itemTag;
	}

	public void setItemTag(String itemTag)
	{
		this.itemTag = itemTag;		
	}

	public List<String> paramsToQueryString()
	{
		List<String> params = new ArrayList<String>();

		if (this.itemKey != null)        { params.add(QueryStringEncoder.encode("itemKey", this.itemKey)); }
		if (this.itemType != null)       { params.add(QueryStringEncoder.encode("itemType", this.itemType)); }
		if (this.q != null)              { params.add(QueryStringEncoder.encode("q", this.q)); }
		if (this.since != null)          { params.add(QueryStringEncoder.encode("since", this.since)); }
		if (this.tag != null)            { params.add(QueryStringEncoder.encode("tag", this.tag)); }
		if (this.includeTrashed != null) { params.add(QueryStringEncoder.encode("includeTrashed", this.includeTrashed)); }
		if (this.qmode != null)          { params.add(QueryStringEncoder.encode("qmode", this.qmode)); }
		if (this.itemQ != null)          { params.add(QueryStringEncoder.encode("itemQ", this.itemQ)); }
		if (this.itemQMode != null)      { params.add(QueryStringEncoder.encode("itemQMode", this.itemQMode)); }
		if (this.itemTag != null)        { params.add(QueryStringEncoder.encode("itemTag", this.itemTag)); }
		
		return params;
	}

	public static SearchParamsBuilder builder()
	{
		return new SearchParamsBuilder();
	}

	public static class SearchParamsBuilder
	{
		private String itemKey;
		private String itemType;
		private String q;
		private Integer since;
		private String tag;
		private Integer includeTrashed;
		private String qmode;
		private String itemQ;
		private String itemQMode;
		private String itemTag;

		public SearchParamsBuilder()
		{
			itemKey        = null;
			itemType       = null;
			q              = null;
			since          = null;
			tag            = null;
			includeTrashed = null;
			qmode          = null;
			itemQ          = null;
			itemQMode      = null;
			itemTag        = null;
		}

		public SearchParamsBuilder setItemKey(String itemKey)
		{
			this.itemKey = itemKey;
			return this;
		}

		public SearchParamsBuilder setItemType(String itemType)
		{
			this.itemType = itemType;
			return this;
		}

		public SearchParamsBuilder setQ(String q)
		{
			this.q = q;
			return this;
		}

		public SearchParamsBuilder setSince(Integer since)
		{
			this.since = since;
			return this;
		}

		public SearchParamsBuilder setTag(String tag)
		{
			this.tag = tag;
			return this;
		}

		public SearchParamsBuilder setIncludeTrashed(Integer includeTrashed)
		{
			this.includeTrashed = includeTrashed;
			return this;
		}

		public SearchParamsBuilder setQmode(String qmode)
		{
			this.qmode = qmode;
			return this;
		}

		public SearchParamsBuilder setItemQ(String itemQ)
		{
			this.itemQ = itemQ;
			return this;
		}

		public SearchParamsBuilder setItemQMode(String itemQMode)
		{
			this.itemQMode = itemQMode;
			return this;
		}

		public SearchParamsBuilder setItemTag(String itemTag)
		{
			this.itemTag = itemTag;
			return this;
		}

		public SearchParams build()
		{
			return new SearchParams(this);
		}
	}
}