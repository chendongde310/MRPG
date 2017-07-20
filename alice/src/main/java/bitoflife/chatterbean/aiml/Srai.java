

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;

import bitoflife.chatterbean.Match;

public class Srai extends TemplateElement
{
  /*
  Constructor Section
  */

  public Srai(Attributes attributes)
  {
  }
  
  public Srai(Object... children)
  {
    super(children);
  }

  public Srai(int index)
  {
    super(new Star(index));
  }
  
  /*
  Method Section
  */
  
  public String process(Match match)
  {
//    String request = super.process(match);
//
//    try
//    {
//      AliceBot bot = (match != null ? match.getCallback() : null);
//      return (bot != null ? bot.respond(request) : "");
//    }
//    catch (Exception e)
//    {
//      throw new RuntimeException("While trying to respond \"" + request + "\"", e);
//    }
	  return "";
  }
  
  public String toString()
  {
    return "<srai>" + super.toString() + "</srai>";
  }
}
