
package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;

import java.net.URL;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.Graphmaster;
import bitoflife.chatterbean.Match;

public class Learn extends TemplateElement
{
  /*
  Constructors
  */

  public Learn(Attributes attributes)
  {
  }

  public Learn(Object... children)
  {
    super(children);
  }

  /*
  Methods
  */

  public String process(Match match)
  {
    AliceBot bot = null;
    try
    {
      bot = match.getCallback();
      Graphmaster graphmaster = bot.getGraphmaster();

      String address = super.process(match);
      URL url = new URL(address);

      AIMLParser parser = new AIMLParser();
      parser.parse(graphmaster, url.openStream());
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }

    return "";
  }
}