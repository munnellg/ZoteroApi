package ie.tcd.munnellg.zotero.model;

import java.net.URL;

import java.util.Date;
import java.util.Map;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Meta
{
    private User createdByUser;

    /* ======================================================================
     * Fields returned by User Items All
     * ====================================================================== */
    private String creatorSummary;
    private String parsedDate;
    private Integer numChildren;

    /* ======================================================================
     * Fields returned by Group Items All
     * ====================================================================== */
    private User lastModifiedByUser;

    /* ======================================================================
     * Fields returned by User Groups
     * ====================================================================== */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd'T'hh:mm:ss'Z'")
    private Date created;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd'T'hh:mm:ss'Z'")
    private Date lastModified;

    private Integer numItems;

    /* ======================================================================
     * Fields returned by User Collections
     * ====================================================================== */
    private Integer numCollections;

    /* ======================================================================
     * Fields returned by User Tags
     * ====================================================================== */
    private Integer type;

    // "numItems": 1

    public Meta()
    {
    	this(Meta.builder());
    }

    private Meta(MetaBuilder builder)
    {
    	this.createdByUser      = builder.createdByUser;

        this.creatorSummary     = builder.creatorSummary;
        this.parsedDate         = builder.parsedDate;
        this.numChildren        = builder.numChildren;

        this.lastModifiedByUser = builder.lastModifiedByUser;

        this.created            = builder.created;
        this.lastModified       = builder.lastModified;
        this.numItems           = builder.numItems;

        this.numCollections           = builder.numCollections;
    }

    public User getCreatedByUser()
    {
    	return this.createdByUser;
    }

    public void setCreatedByUser(User createdByUser)
    {
    	this.createdByUser = createdByUser;
    }

    public String getCreatorSummary()
    {
        return this.creatorSummary;
    }

    public void setCreatorSummary(String creatorSummary)
    {
        this.creatorSummary = creatorSummary;
    }

    public String getParsedDate()
    {
        return this.parsedDate;
    }

    public void setParsedDate(String parsedDate)
    {
        this.parsedDate = parsedDate;
    }

    public Integer getNumChildren()
    {
        return this.numChildren;
    }

    public void setNumChildren(Integer numChildren)
    {
        this.numChildren = numChildren;
    }

    public User getLastModifiedByUser()
    {
        return this.lastModifiedByUser;
    }

    public void setLastModifiedByUser(User lastModifiedByUser)
    {
        this.lastModifiedByUser = lastModifiedByUser;
    }

    public Date getCreated()
    {
        return this.created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public Date getLastModified()
    {
        return this.lastModified;
    }

    public void setLastModified(Date lastModified)
    {
        this.lastModified = lastModified;
    }

    public Integer getNumItems()
    {
        return this.numItems;
    }

    public void setNumItems(Integer numItems)
    {
        this.numItems = numItems;
    }

    public Integer getNumCollections()
    {
        return this.numCollections;
    }

    public void setNumCollections(Integer numCollections)
    {
        this.numCollections = numCollections;
    }

    public Integer getType()
    {
        return this.type;
    }

    public void setType(Integer numCollections)
    {
        this.type = type;
    }

    public static MetaBuilder builder()
    {
    	return new MetaBuilder();
    }

    public static class MetaBuilder
    {
    	private User createdByUser;

        private String creatorSummary;
        private String parsedDate;
        private Integer numChildren;

        private User lastModifiedByUser;

        private Date created;
        private Date lastModified;

        private Integer numItems;

        private Integer numCollections;

        private Integer type;

    	public MetaBuilder()
    	{
    		this.createdByUser = null;

            this.creatorSummary = null;
            this.parsedDate     = null;
            this.numChildren    = null;

            this.created        = null;
            this.lastModified   = null;
            this.numItems       = null;

            this.numCollections = null;

            this.type           = null;
    	}

    	public MetaBuilder setCreatedByUser(User createdByUser)
    	{
    		this.createdByUser = createdByUser;
    		return this;
    	}

        public MetaBuilder setCreatorSummary(String creatorSummary)
        {
            this.creatorSummary = creatorSummary;
            return this;
        }

        public MetaBuilder setParsedDate(String parsedDate)
        {
            this.parsedDate = parsedDate;
            return this;
        }

        public MetaBuilder setNumChildren(Integer numChildren)
        {
            this.numChildren = numChildren;
            return this;
        }

        public MetaBuilder setLastModifiedByUser(User lastModifiedByUser)
        {
            this.lastModifiedByUser = lastModifiedByUser;
            return this;
        }

        public MetaBuilder setCreated(Date created)
        {
            this.created = created;
            return this;
        }

        public MetaBuilder setNumItems(Integer numItems)
        {
            this.numItems = numItems;
            return this;
        }

        public MetaBuilder setNumCollections(Integer numCollections)
        {
            this.numCollections = numCollections;
            return this;
        }

        public MetaBuilder setType(Integer type)
        {
            this.type = type;
            return this;
        }

    	public Meta build()
    	{
    		return new Meta(this);
    	}
    }
}
