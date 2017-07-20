

package bitoflife.chatterbean.aiml;

import junit.framework.TestCase;
import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.Context;
import bitoflife.chatterbean.Match;

public class SystemTest extends TestCase
{
  /*
  Attributes
  */

  private System tag;
  
  /*
  Events
  */

  protected void setUp()
  {
    
  }

  protected void tearDown()
  {
    tag = null;
  }

  /*
  Methods
  */

  public void testParse()
  {
    tag = new System("result = \"Hello System!\"");
    AliceBot bot = new AliceBot();
    bot.setContext(new Context());
    Match match = new Match();
    match.setCallback(bot);
    
    assertEquals("Hello System!", tag.process(match));
  }

  public void testArithmetics()
  {
    tag = new System("1 + 1");
    AliceBot bot = new AliceBot();
    bot.setContext(new Context());
    Match match = new Match();
    match.setCallback(bot);
    
    assertEquals("2", tag.process(match));
  }
}