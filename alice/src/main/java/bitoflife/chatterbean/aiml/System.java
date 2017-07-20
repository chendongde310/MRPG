

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.Context;
import bitoflife.chatterbean.Match;
import bitoflife.chatterbean.script.Interpreter;

public class System extends TemplateElement
{
  /*
  Constructors
  */

  public System(Attributes attributes)
  {
  }

  public System(Object... children)
  {
    super(children);
  }
  
  /*
  Methods
  */
  
  public String process(Match match)
  {
    try
    {
      AliceBot bot = match.getCallback();
      Context context = bot.getContext();
      Interpreter interpreter = (Interpreter) context.property("beanshell.interpreter");
      if (interpreter == null)
        return "";

      String script = super.process(match);
      interpreter.variable("result", null);
      interpreter.variable("match", match);
      
      Object evaluated = interpreter.evaluate(script);
      Object result = interpreter.variable("result");
      if (result == null) result = evaluated;
      
      interpreter.variable("match", null);

      return (result != null ? result.toString() : "");
    }
    catch (Exception e)
    {
      throw new RuntimeException("Evaluation error on <system> tag", e);
    }
  }
}
