package ie.tcd.munnellg.zotero.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AbstractLinkable
{
	@JsonProperty
    protected Map<String, Link> links;

    public Map<String, Link> getLinks()
	{
		return links;
	}

	public void setLinks(Map<String, Link> links)
	{
		this.links = links;
	}
}
