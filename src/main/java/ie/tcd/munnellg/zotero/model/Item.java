package ie.tcd.munnellg.zotero.model;

import java.net.URL;

import java.util.Map;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item
{
	/* ======================================================================
	 * Common? Fields
	 * ====================================================================== */

	private String key;

	private String version;

	private String parentItem;

	private String itemType;

	private String linkMode;

	private String title;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd'T'hh:mm:ss'Z'")
	private Date accessDate;

	private URL url;

	private String note;

	private String contentType;

	private String charset;

	private String filename;

	private String md5;

	private String mtime;

	private List<Tag> tags;

	private Map<String, String> relations;

	//  "2020-06-09T10:51:21Z",
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd'T'hh:mm:ss'Z'")
	private Date dateAdded;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd'T'hh:mm:ss'Z'")
	private Date dateModified;

	/* ======================================================================
	 * Journal Fields
	 * ====================================================================== */
	private List<Creator> creators;

	private String abstractNote;

	private String publicationTitle;

	private String volume;

	private String issue;

	private String pages;

	private String date;

	private String series;

	private String seriesTitle;

	private String seriesText;

	private String journalAbbreviation;

	private String language;

	@JsonProperty("DOI")
	private String doi;

	@JsonProperty("ISSN")
	private String issn;

	private String shortTitle;

	private String archive;

	private String archiveLocation;

	private String libraryCatalog;

	private String callNumber;

	private String rights;

	private String extra;

	private List<String> collections;

	/* ======================================================================
	 * Website Fields
	 * ====================================================================== */
	private String websiteTitle;

	private String websiteType;

	/* ======================================================================
	 * Book Fields
	 * ====================================================================== */

	private String seriesNumber;

	private String numberOfVolumes;

	private String edition;

	private String place;

	private String publisher;

	private String numPages;

	@JsonProperty("ISBN")
	private String isbn;

	public Item()
	{
		this(Item.builder());
	}

	private Item(ItemBuilder builder)
	{
		this.key                 = builder.key;
		this.version             = builder.version;
		this.parentItem          = builder.parentItem;
		this.itemType            = builder.itemType;
		this.linkMode            = builder.linkMode;
		this.title               = builder.title;
		this.accessDate          = builder.accessDate;
		this.url                 = builder.url;
		this.note                = builder.note;
		this.contentType         = builder.contentType;
		this.charset             = builder.charset;
		this.filename            = builder.filename;
		this.md5                 = builder.md5;
		this.mtime               = builder.mtime;
		this.tags                = builder.tags;
		this.relations           = builder.relations;
		this.creators            = builder.creators;
		this.abstractNote        = builder.abstractNote;
		this.publicationTitle    = builder.publicationTitle;
		this.volume              = builder.volume;
		this.issue               = builder.issue;
		this.pages               = builder.pages;
		this.date                = builder.date;
		this.series              = builder.series;
		this.seriesTitle         = builder.seriesTitle;
		this.seriesText          = builder.seriesText;
		this.journalAbbreviation = builder.journalAbbreviation;
		this.language            = builder.language;
		this.doi                 = builder.doi;
		this.issn                = builder.issn;
		this.shortTitle          = builder.shortTitle;
		this.archive             = builder.archive;
		this.archiveLocation     = builder.archiveLocation;
		this.libraryCatalog      = builder.libraryCatalog;
		this.callNumber          = builder.callNumber;
		this.rights              = builder.rights;
		this.extra               = builder.extra;
		this.collections         = builder.collections;
		this.websiteTitle        = builder.websiteTitle;
		this.websiteType         = builder.websiteType;
		this.seriesNumber        = builder.seriesNumber;
		this.numberOfVolumes     = builder.numberOfVolumes;
		this.edition             = builder.edition;
		this.place               = builder.place;
		this.publisher           = builder.publisher;
		this.numPages            = builder.numPages;
		this.isbn                = builder.isbn;
	}

	public String getKey()
	{
		return this.key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getVersion()
	{
		return this.version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public String getParentItem()
	{
		return this.parentItem;
	}

	public void setParentItem(String parentItem)
	{
		this.parentItem = parentItem;
	}

	public String getItemType()
	{
		return this.itemType;
	}

	public void setItemType(String itemType)
	{
		this.itemType = itemType;
	}

	public String getLinkMode()
	{
		return this.linkMode;
	}

	public void setLinkMode(String linkMode)
	{
		this.linkMode = linkMode;
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Date getAccessDate()
	{
		return this.accessDate;
	}

	public void setAccessDate(Date accessDate)
	{
		this.accessDate = accessDate;
	}

	public URL getUrl()
	{
		return this.url;
	}

	public void setUrl(URL url)
	{
		this.url = url;
	}

	public String getNote()
	{
		return this.note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public String getContentType()
	{
		return this.contentType;
	}

	public void setContentType(String contentType)
	{
		this.contentType = contentType;
	}

	public String getCharset()
	{
		return this.charset;
	}

	public void setCharset(String charset)
	{
		this.charset = charset;
	}

	public String getFilename()
	{
		return this.filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public String getMd5()
	{
		return this.md5;
	}

	public void setMd5(String md5)
	{
		this.md5 = md5;
	}

	public String getMtime()
	{
		return this.mtime;
	}

	public void setMtime(String mtime)
	{
		this.mtime = mtime;
	}

	public List<Tag> getTags()
	{
		return this.tags;
	}

	public void setTags(List<Tag> tags)
	{
		this.tags = tags;
	}

	public Map<String, String> getRelations()
	{
		return this.relations;
	}

	public void setRelations(Map<String, String> relations)
	{
		this.relations = relations;
	}

	public Date getDateAdded()
	{
		return this.dateAdded;
	}

	public void setDateAdded(Date dateAdded)
	{
		this.dateAdded = dateAdded;
	}

	public Date getDateModified()
	{
		return this.dateModified;
	}

	public void setDateModified(Date dateModified)
	{
		this.dateModified = dateModified;
	}

	public List<Creator> getCreators()
	{
		return this.creators;
	}

	public void setCreators(List<Creator> creators)
	{
		this.creators = creators;
	}

	public String getAbstractNote()
	{
		return this.abstractNote;
	}

	public void setAbstractNote(String abstractNote)
	{
		this.abstractNote = abstractNote;
	}

	public String getPublicationTitle()
	{
		return this.publicationTitle;
	}

	public void setPublicationTitle(String publicationTitle)
	{
		this.publicationTitle = publicationTitle;
	}

	public String getVolume()
	{
		return this.volume;
	}

	public void setVolume(String volume)
	{
		this.volume = volume;
	}

	public String getIssue()
	{
		return this.issue;
	}

	public void setIssue(String issue)
	{
		this.issue = issue;
	}

	public String getPages()
	{
		return this.pages;
	}

	public void setPages(String pages)
	{
		this.pages = pages;
	}

	public String getDate()
	{
		return this.date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public String getSeries()
	{
		return this.series;
	}

	public void setSeries(String series)
	{
		this.series = series;
	}

	public String getSeriesTitle()
	{
		return this.seriesTitle;
	}

	public void setSeriesTitle(String seriesTitle)
	{
		this.seriesTitle = seriesTitle;
	}

	public String getSeriesText()
	{
		return this.seriesText;
	}

	public void setSeriesText(String seriesText)
	{
		this.seriesText = seriesText;
	}

	public String getJournalAbbreviation()
	{
		return this.journalAbbreviation;
	}

	public void setJournalAbbreviation(String journalAbbreviation)
	{
		this.journalAbbreviation = journalAbbreviation;
	}

	public String getLanguage()
	{
		return this.language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public String getDoi()
	{
		return this.doi;
	}

	public void setDoi(String doi)
	{
		this.doi = doi;
	}

	public String getIssn()
	{
		return this.issn;
	}

	public void setIssn(String issn)
	{
		this.issn = issn;
	}

	public String getShortTitle()
	{
		return this.shortTitle;
	}

	public void setShortTitle(String shortTitle)
	{
		this.shortTitle = shortTitle;
	}

	public String getArchive()
	{
		return this.archive;
	}

	public void setArchive(String archive)
	{
		this.archive = archive;
	}

	public String getArchiveLocation()
	{
		return this.archiveLocation;
	}

	public void setArchiveLocation(String archiveLocation)
	{
		this.archiveLocation = archiveLocation;
	}

	public String getLibraryCatalog()
	{
		return this.libraryCatalog;
	}

	public void setLibraryCatalog(String libraryCatalog)
	{
		this.libraryCatalog = libraryCatalog;
	}

	public String getCallNumber()
	{
		return this.callNumber;
	}

	public void setCallNumber(String callNumber)
	{
		this.callNumber = callNumber;
	}

	public String getRights()
	{
		return this.rights;
	}

	public void setRights(String rights)
	{
		this.rights = rights;
	}

	public String getExtra()
	{
		return this.extra;
	}

	public void setExtra(String extra)
	{
		this.extra = extra;
	}

	public List<String> getCollections()
	{
		return this.collections;
	}

	public void setCollections(List<String> collections)
	{
		this.collections = collections;
	}

	public String getWebsiteTitle()
	{
		return this.websiteTitle;
	}

	public void setWebsiteTitle(String websiteTitle)
	{
		this.websiteTitle = websiteTitle;
	}

	public String getWebsiteType()
	{
		return this.websiteType;
	}

	public void setWebsiteType(String websiteType)
	{
		this.websiteType = websiteType;
	}

	public String getSeriesNumber()
	{
		return this.seriesNumber;
	}

	public void setSeriesNumber(String seriesNumber)
	{
		this.seriesNumber = seriesNumber;
	}

	public String getNumberOfVolumes()
	{
		return this.numberOfVolumes;
	}

	public void setNumberOfVolumes(String numberOfVolumes)
	{
		this.numberOfVolumes = numberOfVolumes;
	}

	public String getEdition()
	{
		return this.edition;
	}

	public void setEdition(String edition)
	{
		this.edition = edition;
	}

	public String getPlace()
	{
		return this.place;
	}

	public void setPlace(String place)
	{
		this.place = place;
	}

	public String getPublisher()
	{
		return this.publisher;
	}

	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}

	public String getNumPages()
	{
		return this.numPages;
	}

	public void setNumPages(String numPages)
	{
		this.numPages = numPages;
	}

	public String getIsbn()
	{
		return this.isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	public static ItemBuilder builder()
	{
		return new ItemBuilder();
	}

	public static class ItemBuilder
	{
		private String key;
		private String version;
		private String parentItem;
		private String itemType;
		private String linkMode;
		private String title;
		private Date accessDate;
		private URL url;
		private String note;
		private String contentType;
		private String charset;
		private String filename;
		private String md5;
		private String mtime;
		private List<Tag> tags;
		private Map<String, String> relations;
		private List<Creator> creators;
		private String abstractNote;
		private String publicationTitle;
		private String volume;
		private String issue;
		private String pages;
		private String date;
		private String series;
		private String seriesTitle;
		private String seriesText;
		private String journalAbbreviation;
		private String language;
		private String doi;
		private String issn;
		private String shortTitle;
		private String archive;
		private String archiveLocation;
		private String libraryCatalog;
		private String callNumber;
		private String rights;
		private String extra;
		private List<String> collections;
		private String websiteTitle;
		private String websiteType;
		private String seriesNumber;
		private String numberOfVolumes;
		private String edition;
		private String place;
		private String publisher;
		private String numPages;
		private String isbn;

		public ItemBuilder()
		{
			this.key                 = null;
			this.version             = null;
			this.parentItem          = null;
			this.itemType            = null;
			this.linkMode            = null;
			this.title               = null;
			this.accessDate          = null;
			this.url                 = null;
			this.note                = null;
			this.contentType         = null;
			this.charset             = null;
			this.filename            = null;
			this.md5                 = null;
			this.mtime               = null;
			this.tags                = new ArrayList<Tag>();
			this.relations           = new HashMap<String, String>();
			this.creators            = new ArrayList<Creator>();
			this.abstractNote        = null;
			this.publicationTitle    = null;
			this.volume              = null;
			this.issue               = null;
			this.pages               = null;
			this.date                = null;
			this.series              = null;
			this.seriesTitle         = null;
			this.seriesText          = null;
			this.journalAbbreviation = null;
			this.language            = null;
			this.doi                 = null;
			this.issn                = null;
			this.shortTitle          = null;
			this.archive             = null;
			this.archiveLocation     = null;
			this.libraryCatalog      = null;
			this.callNumber          = null;
			this.rights              = null;
			this.extra               = null;
			this.collections         = new ArrayList<String>();
			this.websiteTitle        = null;
			this.websiteType         = null;
			this.seriesNumber        = null;
			this.numberOfVolumes     = null;
			this.edition             = null;
			this.place               = null;
			this.publisher           = null;
			this.numPages            = null;
			this.isbn                = null;
		}

		public ItemBuilder setKey(String key)
		{
			this.key = key;
			return this;
		}

		public ItemBuilder setVersion(String version)
		{
			this.version = version;
			return this;
		}

		public ItemBuilder setParentItem(String parentItem)
		{
			this.parentItem = parentItem;
			return this;
		}

		public ItemBuilder setItemType(String itemType)
		{
			this.itemType = itemType;
			return this;
		}

		public ItemBuilder setLinkMode(String linkMode)
		{
			this.linkMode = linkMode;
			return this;
		}

		public ItemBuilder setTitle(String title)
		{
			this.title = title;
			return this;
		}

		public ItemBuilder setAccessDate(Date accessDate)
		{
			this.accessDate = accessDate;
			return this;
		}

		public ItemBuilder setUrl(URL url)
		{
			this.url = url;
			return this;
		}

		public ItemBuilder setNote(String note)
		{
			this.note = note;
			return this;
		}

		public ItemBuilder setContentType(String contentType)
		{
			this.contentType = contentType;
			return this;
		}

		public ItemBuilder setCharset(String charset)
		{
			this.charset = charset;
			return this;
		}

		public ItemBuilder setFilename(String filename)
		{
			this.filename = filename;
			return this;
		}

		public ItemBuilder setMd5(String md5)
		{
			this.md5 = md5;
			return this;
		}

		public ItemBuilder setMtime(String mtime)
		{
			this.mtime = mtime;
			return this;
		}

		public ItemBuilder setTags(List<Tag> tags)
		{
			this.tags = tags;
			return this;
		}

		public ItemBuilder setRelations(Map<String, String> relations)
		{
			this.relations = relations;
			return this;
		}

		public ItemBuilder setCreators(List<Creator> creators)
		{
			this.creators = creators;
			return this;
		}

		public ItemBuilder setAbstractNote(String abstractNote)
		{
			this.abstractNote = abstractNote;
			return this;
		}

		public ItemBuilder setPublicationTitle(String publicationTitle)
		{
			this.publicationTitle = publicationTitle;
			return this;
		}

		public ItemBuilder setVolume(String volume)
		{
			this.volume = volume;
			return this;
		}

		public ItemBuilder setIssue(String issue)
		{
			this.issue = issue;
			return this;
		}

		public ItemBuilder setPages(String pages)
		{
			this.pages = pages;
			return this;
		}

		public ItemBuilder setDate(String date)
		{
			this.date = date;
			return this;
		}

		public ItemBuilder setSeries(String series)
		{
			this.series = series;
			return this;
		}

		public ItemBuilder setSeriesTitle(String seriesTitle)
		{
			this.seriesTitle = seriesTitle;
			return this;
		}

		public ItemBuilder setSeriesText(String seriesText)
		{
			this.seriesText = seriesText;
			return this;
		}

		public ItemBuilder setJournalAbbreviation(String journalAbbreviation)
		{
			this.journalAbbreviation = journalAbbreviation;
			return this;
		}

		public ItemBuilder setLanguage(String language)
		{
			this.language = language;
			return this;
		}

		public ItemBuilder setDoi(String doi)
		{
			this.doi = doi;
			return this;
		}

		public ItemBuilder setIssn(String issn)
		{
			this.issn = issn;
			return this;
		}

		public ItemBuilder setShortTitle(String shortTitle)
		{
			this.shortTitle = shortTitle;
			return this;
		}

		public ItemBuilder setArchive(String archive)
		{
			this.archive = archive;
			return this;
		}

		public ItemBuilder setArchiveLocation(String archiveLocation)
		{
			this.archiveLocation = archiveLocation;
			return this;
		}

		public ItemBuilder setLibraryCatalog(String libraryCatalog)
		{
			this.libraryCatalog = libraryCatalog;
			return this;
		}

		public ItemBuilder setCallNumber(String callNumber)
		{
			this.callNumber = callNumber;
			return this;
		}

		public ItemBuilder setRights(String rights)
		{
			this.rights = rights;
			return this;
		}

		public ItemBuilder setExtra(String extra)
		{
			this.extra = extra;
			return this;
		}

		public ItemBuilder setCollections(List<String> collections)
		{
			this.collections = collections;
			return this;
		}

		public ItemBuilder setWebsiteTitle(String websiteTitle)
		{
			this.websiteTitle = websiteTitle;
			return this;
		}

		public ItemBuilder setWebsiteType(String websiteType)
		{
			this.websiteType = websiteType;
			return this;
		}

		public ItemBuilder setSeriesNumber(String seriesNumber)
		{
			this.seriesNumber = seriesNumber;
			return this;
		}

		public ItemBuilder setNumberOfVolumes(String numberOfVolumes)
		{
			this.numberOfVolumes = numberOfVolumes;
			return this;
		}

		public ItemBuilder setEdition(String edition)
		{
			this.edition = edition;
			return this;
		}

		public ItemBuilder setPlace(String place)
		{
			this.place = place;
			return this;
		}

		public ItemBuilder setPublisher(String publisher)
		{
			this.publisher = publisher;
			return this;
		}

		public ItemBuilder setNumPages(String numPages)
		{
			this.numPages = numPages;
			return this;
		}

		public ItemBuilder setIsbn(String isbn)
		{
			this.isbn = isbn;
			return this;
		}

		public Item build()
		{
			return new Item(this);
		}
	}
}
