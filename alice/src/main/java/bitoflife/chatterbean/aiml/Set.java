

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.Context;
import bitoflife.chatterbean.Match;

public class Set extends TemplateElement
{
  /*
  Attributes
  */
  
  private String name;
  
  /*
  Constructors
  */

  public Set(Attributes attributes)
  {
    name = attributes.getValue(0);
  }
  
  public Set(String name, Object... children)
  {
    super(children);
    this.name = name;
  }
  
  /*
  Methods
  */
  
  public boolean equals(Object obj)
  {
    if (obj == null) return false;
    Set compared = (Set) obj;
    if (!name.equals(compared.name)) return false;
    return super.equals(compared);
  }
    
  public String process(Match match)
  {
    String output = super.process(match);
    if (match == null)
      output = "<set name=\"" + name + "\">" + output + "</set>";
    else
    {
      AliceBot bot = match.getCallback();
      Context context = (bot != null ? bot.getContext() : null);
      if (context != null) context.property("predicate." + name, output);
    }
    
    return output;
  }
}
