

package bitoflife.chatterbean;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

import bitoflife.chatterbean.parser.AliceBotParser;
import bitoflife.chatterbean.util.Searcher;

public class AliceBotMother
{
  /*
  Attribute Section
  */
  
  private ByteArrayOutputStream gossip;
  
  /*
  Event Section
  */
  
  public void setUp()
  {
    gossip = new ByteArrayOutputStream();
  }
  
  /*
  Method Section
  */
  
  public String gossip()
  {
    return gossip.toString();
  }

  public AliceBot newInstance() throws Exception
  {
    Searcher searcher = new Searcher();
    AliceBotParser parser = new AliceBotParser();
    AliceBot bot = parser.parse(new FileInputStream("context.xml"),
                                new FileInputStream("./Bots/splitters.xml"),
                                new FileInputStream("./Bots/substitutions.xml"),
                                searcher.search("Bots/Alice", ".*\\.aiml"));

    Context context = bot.getContext(); 
    context.outputStream(gossip);
    return bot;
  }
}
