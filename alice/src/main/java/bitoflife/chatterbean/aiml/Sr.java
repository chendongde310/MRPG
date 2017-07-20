

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;

public class Sr extends Srai
{
  /*
  Constructors
  */

  public Sr(Attributes attributes)
  {
    super(attributes);
    setChildren(new TemplateElement[] {new Star(attributes)});
  }  
}
