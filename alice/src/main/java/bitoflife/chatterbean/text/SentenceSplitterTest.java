

package bitoflife.chatterbean.text;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentenceSplitterTest extends TestCase
{
  /*
  Attribute Section
  */
  
  private SentenceSplitter splitter;
  
  /*
  Event Section
  */

  protected void setUp() throws Exception
  {
    splitter = newSentenceSplitter();
  }

  protected void tearDown()
  {
    splitter = null;
  }

  /*
  Method Section
  */
  
  private SentenceSplitter newSentenceSplitter()
  {
    Map<String, String> protection = new HashMap<String, String>();
    List<String> splitters = Arrays.asList(new String[] {"...", ".", "!", "?", ";", ",", ":"});
    return new SentenceSplitter(protection, splitters);
  }
  
  /*
  Test Section
  */
  
  public void testSplitString()
  {
    String[] expected = 
      {"Hello Alice.", "How are you?", "You look fine!", "Please forgive my manners;", "I am so happy today..."};

    String input = "Hello Alice. How are you? You look fine! Please forgive my manners; I am so happy today...";
    String[] actual = splitter.split(input);
    
    assertEquals(Arrays.asList(expected), Arrays.asList(actual));
  }
  
  public void testSplitStringEmpty()
  {
    String[] expected = {"thank you."};
    String input = " ...thank you. ";
    String[] actual = splitter.split(input);
    
    assertEquals(Arrays.asList(expected), Arrays.asList(actual));
  }
}
