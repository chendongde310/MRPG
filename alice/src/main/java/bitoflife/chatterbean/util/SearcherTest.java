
package bitoflife.chatterbean.util;

import junit.framework.TestCase;

import java.net.URL;

public class SearcherTest extends TestCase
{
  /*
  Attribute Section
  */

  private Searcher searcher;

  /* 
  Event Section
  */

  protected void setUp()
  {
    searcher = new Searcher();
  }

  protected void tearDown()
  {
    searcher = null;
  }

  /*
  Method Section
  */
  
  public void testDirFilesystem()
  {
    String[] paths = searcher.dir("Bots/Alice", ".+\\.aiml");
    
    assertEquals("Bots/Alice/Again.aiml", paths[0]);
    assertEquals("Bots/Alice/Alice.aiml", paths[1]);
    assertEquals("Bots/Alice/Astrology.aiml", paths[2]);
  }
  
  public void testDirURL() throws Exception
  {
    String[] paths = searcher.dir(new URL("file", "localhost", "./"), "Bots/Alice", ".+\\.aiml");
    
    assertEquals("Bots/Alice/Again.aiml", paths[0]);
    assertEquals("Bots/Alice/Alice.aiml", paths[1]);
    assertEquals("Bots/Alice/Astrology.aiml", paths[2]);
  }
}
