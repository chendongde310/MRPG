

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;
import bitoflife.chatterbean.Match;

import static bitoflife.chatterbean.Match.Section.TOPIC;

public class Topicstar extends TemplateElement
{
  /*
  Attributes
  */
  
  private int index;

  /*
  Constructor
  */
  
  public Topicstar(Attributes attributes)
  {
    String value = attributes.getValue(0);
    if (value == null)
      index = 1;
    else
      index = Integer.parseInt(value);
  }
  
  public Topicstar(int index)
  {
    this.index = index;
  }
  
  /*
  Methods
  */
  
  public boolean equals(Object obj)
  {
    if (!super.equals(obj)) return false;
    Topicstar compared = (Topicstar) obj;
    
    return (index == compared.index);
  }
  
  public String toString()
  {
    return "<topicstar index=\"" + index + "\">";
  }
  
  public String process(Match match)
  {
    String wildcard = match.wildcard(TOPIC, index);
    return (wildcard != null ? wildcard.trim() : "");
  }
}
