

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;
import bitoflife.chatterbean.Match;

public class Size extends TemplateElement
{
  /*
  Constructors
  */

  public Size()
  {
  }

  public Size(Attributes attributes)
  {
  }

  /*
  Methods
  */

  public String process(Match match)
  {
    try
    {
      return Integer.toString(match.getCallback().getGraphmaster().size());
    }
    catch (NullPointerException e)
    {
      return "0";
    }
  }
}
