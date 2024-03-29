package ie.tcd.munnellg.zotero.util;

/**
 * Taken from StackOverflow https://stackoverflow.com/a/42567051/4261231
 */

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class MultiDateDeserializer extends StdDeserializer<Date>
{
    private static final long serialVersionUID = 1L;

    private static final String[] DATE_FORMATS = new String[]
    {
        "yyyy-mm-dd'T'hh:mm:ss'Z'",
        "yyyy-mm-dd"
    };

    public MultiDateDeserializer()
    {
        this(null);
    }

    public MultiDateDeserializer(Class<?> vc)
    {
        super(vc);
    }

    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException
    {
        final JsonNode node = jp.getCodec().readTree(jp);

        final String date = node.textValue().trim();

        if (date.isEmpty())
        {
            return null;
        }

        for (String DATE_FORMAT : DATE_FORMATS)
        {
            try
            {
                return new SimpleDateFormat(DATE_FORMAT).parse(date);
            }
            catch (ParseException e)
            {
            }
        }

        throw new JsonParseException(jp, "Unparseable date: \"" + date + "\". Supported formats: " + Arrays.toString(DATE_FORMATS));
    }
}