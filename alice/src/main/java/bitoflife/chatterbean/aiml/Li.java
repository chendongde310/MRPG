
package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;

public class Li extends TemplateElement
{
  /*
  Attributes
  */
  
  private String name;
  private String value;
  
  
  /*
  Constructors
  */

  public Li()
  {
  }

  public Li(Attributes attributes)
  {
    name = attributes.getValue("name");
    value = attributes.getValue("value");
  }

  public Li(String name, String value, Object... children)
  {
    super(children);
    this.name = name;
    this.value = value;
  }
  
  /*
  Methods
  */
  
  private boolean isEquals(Object comparing, Object compared)
  {
    return (comparing == null ? compared == null : comparing.equals(compared));
  }
  
  public boolean equals(Object obj)
  {
    if (!super.equals(obj)) return false;
    Li compared = (Li) obj;
    return (isEquals(name, compared.name) && isEquals(value, compared.value));
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
