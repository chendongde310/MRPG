

package bitoflife.chatterbean.parser;

import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import bitoflife.chatterbean.Context;

public class ContextParserTest extends TestCase
{
  /*
  Attributes
  */
  
  private static final String xml =
    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
    "<context>" +
      "<bot name=\"output\" value=\"Logs/\"/>" +
      "<bot name=\"me\" value=\"Alice\"/>" +
      "<set name=\"dateFormat\" value=\"yyyy-MM-dd HH:mm:ss\"/>" +
      "<set name=\"user\" value=\"Unknown Person\"/>" +
      "<set name=\"engine\" value=\"ChatterBean\"/>" +
    "</context>";

  private InputStream source;
  
  private ContextParser parser;
  
  /*
  Events
  */
  
  public void setUp() throws Exception
  {
    source = new ByteArrayInputStream(xml.getBytes("UTF-8"));
    parser = new ContextParser();
  }
    
  /*
  Methods
  */
  
  public void testParse() throws Exception
  {
    Context context = parser.parse(source);
    assertEquals("Unknown Person", context.property("predicate.user"));
    assertEquals("ChatterBean", context.property("predicate.engine"));
    assertEquals("yyyy-MM-dd HH:mm:ss", context.property("predicate.dateFormat"));
    assertEquals("Alice", context.property("bot.me"));
    assertEquals("Logs/", context.property("bot.output"));
  }
}
