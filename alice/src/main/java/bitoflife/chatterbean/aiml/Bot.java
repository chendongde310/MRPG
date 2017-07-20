

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;

import bitoflife.chatterbean.Match;

public class Bot extends TemplateElement
{
  /*
  Attributes
  */

  private String name;

  /*
  Constructors
  */

  public Bot(Attributes attributes)
  {
    name = attributes.getValue(0);
  }

  public Bot(String name)
  {
    this.name = name;
  }

  /*
  Methods
  */

  public boolean equals(Object obj)
  {
    return (super.equals(obj) && name.equals(((Bot) obj).name));
  }

  public int hashCode()
  {
    return name.hashCode();
  }

  public String process(Match match)
  {
    try
    {
      String value = (String) match.getCallback().getContext().property("bot." + name);
      return (value != null ? value : "");
    }
    catch (NullPointerException e)
    {
      return "";
    }
  }
}
