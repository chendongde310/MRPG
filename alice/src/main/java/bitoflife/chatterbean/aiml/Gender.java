
package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.Match;
import bitoflife.chatterbean.text.Transformations;

public class Gender extends TemplateElement
{
  /*
  Constructor Section
  */

  public Gender(Attributes attributes)
  {
  }

  public Gender(Object... children)
  {
    super(children);
  }
  
  /*
  Method Section
  */
  
  public String process(Match match)
  {
    String input = super.process(match);
    AliceBot bot = match.getCallback();
    Transformations transformations = bot.transformations();
    return transformations.gender(input);
  }
}
