

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;

public class Template extends TemplateElement
{
  /*
  Constructor Section
  */

  public Template(Attributes attributes)
  {
    super();
  }

  public Template(Object... children)
  {
    super(children);
  }
  
  /*
  Method Section
  */
  
  public String toString()
  {
    StringBuilder value = new StringBuilder();
    value.append("<template>");
    for (TemplateElement i : children())
      value.append(i.toString());
    value.append("</template>");
    
    return value.toString();
  }
}
