package ie.tcd.munnellg.zotero.util;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class QueryStringEncoder
{
	private static List<Pair<String, String>> urlEncodings;
	static
	{
		urlEncodings = new ArrayList<Pair<String, String>>();

		urlEncodings.add(new Pair<String, String>(Pattern.quote("%"), "%25"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote(" "), "%20"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("!"), "%21"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("#"), "%23"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("$"), "%24"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("&"), "%26"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("'"), "%27"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("("), "%28"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote(")"), "%29"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("*"), "%2A"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("+"), "%2B"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote(","), "%2C"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("-"), "%2D"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("."), "%2E"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("/"), "%2F"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote(":"), "%3A"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote(";"), "%3B"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("<"), "%3C"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("="), "%3D"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote(">"), "%3E"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("?"), "%3F"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("@"), "%40"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("["), "%5B"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("\\"), "%5C"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("\""), "%22"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("\n"), "%0A"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("\r"), "%0D"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("]"), "%5D"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("^"), "%5E"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("_"), "%5F"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("`"), "%60"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("{"), "%7B"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("|"), "%7C"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("}"), "%7D"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("~"), "%7E"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("£"), "%C2%A3"));
		urlEncodings.add(new Pair<String, String>(Pattern.quote("円"), "%E5%86%86"));
	}

	public static <T> String encode(String fieldName, T value)
	{
		return encode(fieldName, value.toString());
	}

	public static String encode(String fieldName, String fieldValue)
	{
		return String.format("%s=%s", fieldName, escape(fieldValue));
	}

	public static String escape(String value)
	{
		for (Pair<String, String> item : urlEncodings)
		{
			value = value.replaceAll(item.getKey(), item.getValue());
		}

		return value;
	}
}