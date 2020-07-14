package ie.tcd.munnellg.zotero.util;

import java.util.ArrayList;

public class ZoteroList<T> extends ArrayList<T>
{
	private Integer totalResults;

	public Integer getTotalResults()
	{
		return this.totalResults;
	}

	public void setTotalResults(Integer totalResults)
	{
		this.totalResults = totalResults;
	}
}