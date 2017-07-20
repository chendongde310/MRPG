

package bitoflife.chatterbean.aiml;

import bitoflife.chatterbean.Match;

public class Text extends TemplateElement
{
  /*
  Attributes
  */

  private final String value;
  
  /*
  Constructor
  */

  public Text(String value)
  {
    this.value = value;
  }
  
  /*
  Methods
  */

  public boolean equals(Object obj)
  {
    if (obj == null) return false;
    String text = obj.toString();
    return (text != null ? text.equals(value) : value == null);
  }

  public int hashCode()
  {
    return (value == null ? 0 : value.hashCode());
  }

  public String toString()
  {
    return value;
  }

  public String process(Match match)
  {
    return value;
  }
}
