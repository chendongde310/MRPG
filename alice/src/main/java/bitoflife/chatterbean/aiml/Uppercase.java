

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;
import bitoflife.chatterbean.Match;

public class Uppercase extends TemplateElement
{
  /*
  Constructors
  */

  public Uppercase(Attributes attributes)
  {
  }
  
  public Uppercase(Object... children)
  {
    super(children);
  }
  
  /*
  Methods
  */
  
  public String process(Match match)
  {
    String result = super.process(match);
    if (result != null)
      return result.toUpperCase();
    else
      return "";
  }
}
