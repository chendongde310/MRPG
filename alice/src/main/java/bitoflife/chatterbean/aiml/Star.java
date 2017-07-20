

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;
import bitoflife.chatterbean.Match;

import static bitoflife.chatterbean.Match.Section.PATTERN;

public class Star extends TemplateElement
{
  /*
  Attributes
  */

  private int index;

  /*
  Constructor
  */
  
  public Star(Attributes attributes)
  {
    String value = attributes.getValue(0);
    index = (value != null ? Integer.parseInt(value) : 1);
  }
  
  public Star(int index)
  {
    this.index = index;
  }
  
  /*
  Methods
  */

  public boolean equals(Object obj)
  {
    if (obj == null || !(obj instanceof Star))
      return false;
    else
    {
      Star star = (Star) obj;
      return (index == star.index);
    }
  }

  public int hashCode()
  {
    return index;
  }
  
  public String toString()
  {
    return "<star index=\"" + index + "\"/>";
  }

  public String process(Match match)
  {
    String wildcard = match.wildcard(PATTERN, index);
    return (wildcard != null ? wildcard.trim() : "");
  }
}
