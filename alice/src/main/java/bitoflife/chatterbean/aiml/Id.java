

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;
import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.Context;
import bitoflife.chatterbean.Match;

public class Id extends TemplateElement
{
  /*
  Constructors
  */

  public Id()
  {
  }

  public Id(Attributes attributes)
  {
  }

  /*
  Methods
  */
  
  public boolean equals(Object obj)
  {
    if (!super.equals(obj))
      return false;
    else
      return toString().equals(obj.toString());
  }
  
  public int hashCode()
  {
    return process(null).hashCode();
  }

  public String process(Match match)
  {
    if (match == null) return "unknown";
    AliceBot bot = match.getCallback();
    Context context = bot.getContext();
    return context.id();
  }
}
