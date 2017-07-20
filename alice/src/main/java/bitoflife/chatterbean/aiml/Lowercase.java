
package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;
import bitoflife.chatterbean.Match;

public class Lowercase extends TemplateElement
{
  /*
  Constructors
  */

  public Lowercase(Attributes attributes)
  {
  }
  
  public Lowercase(Object... children)
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
      return result.toLowerCase();
    else
      return "";
  }
}
