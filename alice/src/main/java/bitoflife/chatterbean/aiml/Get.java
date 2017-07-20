

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;

import bitoflife.chatterbean.Match;

public class Get extends TemplateElement
{
  /*
  Attributes
  */
  
  private String name;
  
  /*
  Constructors
  */

  public Get(Attributes attributes)
  {
    name = attributes.getValue(0);
  }

  public Get(String name)
  {
    this.name = name;
  }
  
  /*
  Methods
  */
  
  public boolean equals(Object compared)
  {
    if (compared == null || !(compared instanceof Get))
      return false;
    else
      return name.equals(((Get) compared).name);
  }
  
  public int hashCode()
  {
    return name.hashCode();
  }

  public String process(Match match)
  {
    try
    {
      String value = (String) match.getCallback().getContext().property("predicate." + name);
      return (value != null ? value : "");
    }
    catch (NullPointerException e)
    {
      return "";
    }
  }
}
