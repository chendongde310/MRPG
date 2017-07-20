

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;
import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.Match;
import bitoflife.chatterbean.text.Transformations;

public class Person2 extends TemplateElement
{
  /*
  Constructor Section
  */

  public Person2(Attributes attributes)
  {
  }

  public Person2(Object... children)
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
    return transformations.person2(input);
  }
}
