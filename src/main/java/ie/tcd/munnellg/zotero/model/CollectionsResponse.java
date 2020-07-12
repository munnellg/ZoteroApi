package ie.tcd.munnellg.zotero.model;

import java.net.URL;

import java.util.Map;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CollectionsResponse extends AbstractLinkable
{
    private String key;

    private Integer version;

    private Library library;

    private Meta meta;

    private Collection data;

    public CollectionsResponse()
    {
    	this(CollectionsResponse.builder());
    }

    public CollectionsResponse(CollectionsResponseBuilder builder)
    {
        this.key     = builder.key;
        this.version = builder.version;
        this.library = builder.library;
        this.meta    = builder.meta;
        this.data    = builder.data;
    }

    public String getKey()
    {
        return this.key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public Integer getVersion()
    {
        return this.version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    public Library getLibrary()
    {
        return this.library;
    }

    public void setLibrary(Library library)
    {
        this.library = library;
    }

    public Meta getMeta()
    {
        return this.meta;
    }

    public void setMeta(Meta meta)
    {
        this.meta = meta;
    }

    public Collection getData()
    {
        return this.data;
    }

    public void setData(Collection data)
    {
        this.data = data;
    }

    public static CollectionsResponseBuilder builder()
    {
    	return new CollectionsResponseBuilder();
    }

    public static class CollectionsResponseBuilder
    {
        private String key;
        private Integer version;
        private Library library;
        private Meta meta;
        private Collection data;

		public CollectionsResponseBuilder()
		{
            this.key            = null;
            this.version        = null;
            this.library        = null;
            this.meta           = null;
            this.data           = null;
		}

        public CollectionsResponseBuilder setKey(String key)
        {
            this.key = key;
            return this;
        }

        public CollectionsResponseBuilder setVersion(Integer version)
        {
            this.version = version;
            return this;
        }

        public CollectionsResponseBuilder setLibrary(Library library)
        {
            this.library = library;
            return this;
        }

        public CollectionsResponseBuilder setMeta(Meta meta)
        {
            this.meta = meta;
            return this;
        }

        public CollectionsResponseBuilder setData(Collection data)
        {
            this.data = data;
            return this;
        }

		public CollectionsResponse build()
		{
			return new CollectionsResponse(this);
		}
    }
}
