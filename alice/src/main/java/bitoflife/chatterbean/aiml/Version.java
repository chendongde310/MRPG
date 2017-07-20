

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;
import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.Context;
import bitoflife.chatterbean.Match;

public class Version extends TemplateElement
{
  /*
  Constructors
  */

  public Version()
  {
  }

  public Version(Attributes attributes)
  {
  }

  /*
  Methods
  */

  public String process(Match match)
  {
    AliceBot bot = match.getCallback();
    Context context = bot.getContext();
    return (String) context.property("bot.version");
  }
}
