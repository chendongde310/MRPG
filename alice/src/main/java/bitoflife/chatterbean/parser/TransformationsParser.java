

package bitoflife.chatterbean.parser;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import bitoflife.chatterbean.config.ConfigException;
import bitoflife.chatterbean.config.TokenizerConfig;
import bitoflife.chatterbean.config.TokenizerConfigStream;
import bitoflife.chatterbean.text.Tokenizer;
import bitoflife.chatterbean.text.Transformations;

public class TransformationsParser
{
  /*
  Attribute Section
  */

  private final SubstitutionBuilder substBuilder = new SubstitutionBuilder();
  private final ReflectionHandler substHandler = new ReflectionHandler(substBuilder);
  private final SplitterHandler splitHandler = new SplitterHandler();
  
  private SAXParser parser;

  /*
  Constructor Section
  */
  
  public TransformationsParser() throws ParserConfigurationException, SAXException
  {
    parser = SAXParserFactory.newInstance().newSAXParser();
  }

  /*
  Method Section
  */

  private List<String> parseSplitters(InputStream splitters) throws IOException, SAXException
  {
    splitHandler.clear();
    parser.parse(splitters, splitHandler);
    return splitHandler.parsed();
  }

  private Map<String, Map<String, String>> parseSubstitutions(InputStream substitutions) throws IOException, SAXException
  {
    substBuilder.clear();
    parser.parse(substitutions, substHandler);
    return substBuilder.parsed();
  }
  
  private byte[] toByteArray(InputStream input) throws IOException
  {
    List<Byte> list = new LinkedList<Byte>();
    for (int i = 0; (i = input.read()) > -1;)
      list.add((byte) i);

    int i = 0;
    byte[] bytes = new byte[list.size()];
    for (byte b : list)
      bytes[i++] = b;
    return bytes;
  }
  
  public Transformations parse(InputStream splitters, InputStream substitutions)
    throws ConfigException, IOException, SAXException
  {
    byte[] bytes = toByteArray(splitters);
    
    TokenizerConfig config = new TokenizerConfigStream(new ByteArrayInputStream(bytes));
    Tokenizer tokenizer = new Tokenizer(config);

    List<String> splitChars = parseSplitters(new ByteArrayInputStream(bytes));

    Map<String, Map<String, String>> maps = parseSubstitutions(substitutions);
    return new Transformations(splitChars, maps, tokenizer);
  }
}
