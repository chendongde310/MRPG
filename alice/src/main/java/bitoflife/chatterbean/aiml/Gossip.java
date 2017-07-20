

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;
import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.Context;
import bitoflife.chatterbean.Match;

public class Gossip extends TemplateElement
{
  /*
  Constructors
  */

  public Gossip(Attributes attributes)
  {
  }

  public Gossip(Object... children)
  {
    super(children);
  }
  
  /*
  Methods
  */
  
  public String process(Match match)
  {
    AliceBot bot = null;
    Context context = null;
    if (match != null) try
    {
      bot = match.getCallback();
      context = bot.getContext();
      context.print(super.process(match));
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
    
    return "";
  }
}
