

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;
import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.Context;
import bitoflife.chatterbean.Match;
import bitoflife.chatterbean.script.Interpreter;

public class Javascript extends TemplateElement
{
  /*
  Constructor Section
  */

  public Javascript(Attributes attributes)
  {
  }

  public Javascript(Object... children)
  {
    super(children);
  }

  /*
  Method Section
  */

  public String process(Match match)
  {
    try
    {
      AliceBot bot = match.getCallback();
      Context context = bot.getContext();
      Interpreter interpreter = (Interpreter) context.property("javascript.interpreter");
      if (interpreter == null)
        return "";

      String script = super.process(match);
      interpreter.variable("result", null);
      Object evaluated = interpreter.evaluate(script);
      Object result = interpreter.variable("result");
      if (result == null) result = evaluated;
      
      return (result != null ? result.toString() : "");
    }
    catch (Exception e)
    {
      throw new RuntimeException("Evaluation error on <javascript> tag", e);
    }
  }
}
