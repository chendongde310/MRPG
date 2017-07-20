

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;
import bitoflife.chatterbean.Match;

public class Think extends TemplateElement
{
  /*
  Constructors
  */

  public Think(Attributes attributes)
  {
  }
  
  public Think(Object... children)
  {
    super(children);
  }
  
  /*
  Methods
  */
  
  public String process(Match match)
  {
    super.process(match);
    return "";
  }
}
