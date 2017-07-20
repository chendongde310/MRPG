

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bitoflife.chatterbean.Match;

public class Formal extends TemplateElement
{
  /*
  Constructors
  */

  public Formal(Attributes attributes)
  {
  }

  public Formal(Object... children)
  {
    super(children);
  }

  /*
  Methods
  */
  
  public String process(Match match)
  {
    String result = super.process(match);
    if (result == null || "".equals(result.trim())) return "";

    /* See the description of java.util.regex.Matcher.appendReplacement() in the Javadocs to understand this code. */    
    Pattern p = Pattern.compile("(^\\s*[a-z]|\\s+[a-z])");
    Matcher m = p.matcher(result);
    StringBuffer buffer = new StringBuffer();
    while (m.find())
      m.appendReplacement(buffer, m.group().toUpperCase());
    m.appendTail(buffer);
    return buffer.toString();
  }
}
