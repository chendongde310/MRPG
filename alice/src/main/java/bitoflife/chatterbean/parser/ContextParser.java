

package bitoflife.chatterbean.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import bitoflife.chatterbean.Context;

public class ContextParser
{
  /*
  Inner Classes
  */
  
  private class ContextHandler extends DefaultHandler
  {
    public void startElement(String namespace, String name, String qname, Attributes attributes) throws SAXException
    {
      if (qname.equals("set"))
        context.property("predicate." + attributes.getValue("name"), attributes.getValue("value"));
      else if (qname.equals("bot"))
        context.property("bot." + attributes.getValue("name"), attributes.getValue("value"));
    }
  }
  
  /*
  Attributes
  */
  
  private final ContextHandler handler = new ContextHandler();
  private SAXParser parser;

  private Context context;
  
  /*
  Constructor
  */

  public ContextParser() throws ParserConfigurationException, SAXException
  {
    parser = SAXParserFactory.newInstance().newSAXParser();
  }

  /*
  Methods
  */

  public Context parse(InputStream input) throws IOException, SAXException
  {
    parse(new Context(), input);
    return context;
  }
  
  public void parse(Context context, InputStream input) throws IOException, SAXException
  {
    this.context = context;
    parser.parse(input, handler);
  }
}
