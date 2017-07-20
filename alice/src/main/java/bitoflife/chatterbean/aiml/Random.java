

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.Context;
import bitoflife.chatterbean.Match;

public class Random extends TemplateElement
{
  /*
  Constructor
  */
  
  public Random()
  {
  }
  
  public Random(Attributes attributes)
  {
  }
  
  public Random(Object... children)
  {
    super(children);
  }
  
  /*
  Methods
  */
  
  public String process(Match match)
  {
    AliceBot bot = match.getCallback();
    Context context = bot.getContext();
    java.util.Random random = context.random();

    int n = children().size();    
    TemplateElement child = getChildren(random.nextInt(n));
    return child.process(match);
  }
}
