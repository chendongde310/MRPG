
package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;
import bitoflife.chatterbean.Match;

import static bitoflife.chatterbean.Match.Section.THAT;

public class Thatstar extends TemplateElement
{
  /*
  Attribute Section
  */
  
  private int index;

  /*
  Constructor Section
  */
  
  public Thatstar(Attributes attributes)
  {
    String value = attributes.getValue(0);
    if (value == null)
      index = 1;
    else
      index = Integer.parseInt(value);
  }
  
  public Thatstar(int index)
  {
    this.index = index;
  }
  
  /*
  Method Section
  */
  
  public boolean equals(Object obj)
  {
    if (!super.equals(obj)) return false;
    Thatstar compared = (Thatstar) obj;
    
    return (index == compared.index);
  }
  
  public String toString()
  {
    return "<thatstar index=\"" + index + "\">";
  }
  
  public String process(Match match)
  {
    String wildcard = match.wildcard(THAT, index);
    return (wildcard != null ? wildcard.trim() : "");
  }
}
