package bitoflife.chatterbean.config;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import bitoflife.chatterbean.text.Tokenizer;




public class TokenizerConfigStream extends DefaultHandler implements TokenizerConfig
{
  /*
  Attribute Section
  */
  
  private static final String[] STRING_ARRAY = new String[0];

  private final SAXParser parser;

  private final List<String> splitters = new ArrayList<String>(6);
  
  private boolean ignoreWhitespace;

  /*
  Constructor Section
  */
  
  public TokenizerConfigStream() throws ConfigException
  {
    try
    {
      SAXParserFactory factory = SAXParserFactory.newInstance();
      parser = factory.newSAXParser();
    }
    catch (Exception e)
    {
      throw new ConfigException(e);
    }
  }

  public TokenizerConfigStream(InputStream input) throws ConfigException
  {
    try
    {
      SAXParserFactory factory = SAXParserFactory.newInstance();
      parser = factory.newSAXParser();
      parse(input);
    }
    catch (ConfigException e)
    {
      throw e;
    }
    catch (Exception e)
    {
      throw new ConfigException(e);
    }
  }

  /*
  Event Section
  */

  public void startElement(String namespace, String name, String qname, Attributes attributes) throws SAXException
  {
    if ("splitter".equals(qname))
      splitters.add(attributes.getValue(0));
  }

  /*
  Method Section
  */
  
  public Tokenizer newInstance()
  {
    return new Tokenizer(splitters());
  }
  
  public void parse(InputStream input) throws ConfigException
  {
    try
    {
      splitters.clear();
      ignoreWhitespace = true;
      parser.parse(input, this);
    }
    catch (Exception e)
    {
      throw new ConfigException(e);
    }
  }

  /*
  Accessor Section
  */
  
  public String[] splitters()
  {
    return splitters.toArray(STRING_ARRAY);
  }
}
