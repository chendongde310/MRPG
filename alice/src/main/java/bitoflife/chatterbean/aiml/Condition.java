

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;
import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.Context;
import bitoflife.chatterbean.Match;
import bitoflife.chatterbean.text.Transformations;

public class Condition extends TemplateElement
{
  /*
  Attributes
  */

  private String name;
  private String value;


  /*
  Constructors
  */

  public Condition()
  {
  }

  public Condition(Attributes attributes)
  {
    name = attributes.getValue("name");
    value = attributes.getValue("value");
  }

  public Condition(String name, String value, Object... children)
  {
    super(children);
    this.name = name;
    this.value = value;
  }

  /*
  Methods
  */

  private Li find(Context context, Transformations transformations)
  {
    for (AIMLElement child : getChildren())
    {
      Li li = (Li) child;
      String comparing = li.getValue();
      if (comparing == null)
        return li;

      String compared = (String) context.property("predicate." + li.getName());
      if ("".equals(compared))
        continue;

      comparing = transformations.normalization(comparing);
      compared = transformations.normalization(compared);
      if (comparing.equals(compared))
        return li;
    }

    return null;
  }

  private Li find(String compared, Transformations transformations)
  {
    for (TemplateElement child : getChildren())
    {
      Li li = (Li) child;
      String comparing = li.getValue();
      if (comparing == null)
        return li;

      comparing = transformations.normalization(comparing);
      if (comparing.equals(compared))
        return li;
    }

    return null;
  }

  public String process(Match match)
  {
    AliceBot bot = match.getCallback();
    Context context = bot.getContext();
    Transformations transformations = context.getTransformations();

    String compared = (String) context.property("predicate." + name);
    compared = transformations.normalization(compared);
    if (value != null)
    {
      String comparing = transformations.normalization(value);
      return (comparing.equals(compared) ? super.process(match) : "");
    }
    else if (name != null)
    {
      Li li = find(compared, transformations);
      return (li != null ? li.process(match) : "");
    }
    else
    {
      Li li = find(context, transformations);
      return (li != null ? li.process(match) : "");
    }
  }

  /*
  Properties
  */

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getValue()
  {
    return value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }
}
