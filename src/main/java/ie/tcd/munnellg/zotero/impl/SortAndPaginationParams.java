package ie.tcd.munnellg.zotero.impl;

import java.util.List;
import java.util.ArrayList;

import ie.tcd.munnellg.zotero.util.QueryStringEncoder;
import ie.tcd.munnellg.zotero.interfaces.RequestParams;

public class SortAndPaginationParams implements RequestParams
{
	private String sortField;

	private String direction;

	private Integer limit;

	private Integer start;

	public SortAndPaginationParams()
	{
		this(SortAndPaginationParams.builder());
	}

	private SortAndPaginationParams(SortAndPaginationParamsBuilder builder)
	{
		this.sortField = builder.sortField;
		this.direction = builder.direction;
		this.limit     = builder.limit;
		this.start     = builder.start;
	}

	public String getSortField()
	{
		return this.sortField;
	}

	public void setSortField(String sortField)
	{
		this.sortField = sortField;
	}

	public String getDirection()
	{
		return this.direction;
	}

	public void setDirection(String direction)
	{
		this.direction = direction;
	}

	public Integer getLimit()
	{
		return this.limit;
	}

	public void setLimit(Integer limit)
	{
		this.limit = limit;
	}

	public Integer getStart()
	{
		return this.start;
	}

	public void setStart(Integer start)
	{
		this.start = start;
	}

	public List<String> paramsToQueryString()
	{
		List<String> params = new ArrayList<String>();

		if (this.sortField != null) { params.add(QueryStringEncoder.encode("sort", this.sortField)); };
		if (this.direction != null) { params.add(QueryStringEncoder.encode("direction", this.direction)); };
		if (this.limit != null)     { params.add(QueryStringEncoder.encode("limit", this.limit)); };
		if (this.start != null)     { params.add(QueryStringEncoder.encode("start", this.start)); };
		return params;
	}

	public static SortAndPaginationParamsBuilder builder()
	{
		return new SortAndPaginationParamsBuilder();
	}

	public static class SortAndPaginationParamsBuilder
	{
		private String sortField;
		private String direction;
		private Integer limit;
		private Integer start;

		public SortAndPaginationParamsBuilder()
		{
			this.sortField = null;
			this.direction = null;
			this.limit     = null;
			this.start     = null;
		}

		public SortAndPaginationParamsBuilder setSortField(String sortField)
		{
			this.sortField = sortField;
			return this;
		}

		public SortAndPaginationParamsBuilder setDirection(String direction)
		{
			this.direction = direction;
			return this;
		}

		public SortAndPaginationParamsBuilder setLimit(Integer limit)
		{
			this.limit = limit;
			return this;
		}

		public SortAndPaginationParamsBuilder setStart(Integer start)
		{
			this.start = start;
			return this;
		}

		public SortAndPaginationParams build()
		{
			return new SortAndPaginationParams(this);
		}
	}
}