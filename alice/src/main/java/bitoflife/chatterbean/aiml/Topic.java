

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Topic implements AIMLElement
{
  /*
  Attribute Section
  */
  
  private List<Category> categories = new LinkedList<Category>();
  
  private String name;
  
  /*
  Constructor Section
  */
  
  public Topic(Attributes attributes)
  {
    name(attributes.getValue(0));
  }
  
  public Topic(String name, Category... children)
  {
    name(name);
    categories.addAll(Arrays.asList(children));
  }

  /*
  Method Section
  */
  
  public void appendChild(AIMLElement child)
  {
    Category category = (Category) child;
    category.setTopic(this);
    categories.add(category);
  }
  
  public void appendChildren(List<AIMLElement> children)
  {
    for (AIMLElement child : children)
      appendChild(child);
  }
  
  public List<Category> categories()
  {
    return categories;
  }
  
  public String[] elements()
  {
    return name.split(" ");
  }
  
  public boolean equals(Object obj)
  {
    if (obj == null || !(obj instanceof Topic))
      return false;
    else
    {
      Topic compared = (Topic) obj;
      return (name.equals(compared.name) && categories.equals(compared.categories));
    }
  }
  
  public String toString()
  {
    StringBuilder result = new StringBuilder();
    for (Category i : categories)
    {
      result.append(i);
      result.append('\n');
    }
    
    return result.toString();
  }
  
  /*
  Acessor Section
  */
  
  private void name(String name)
  {
    this.name = name.trim();
  }
  
  /*
  Property Section
  */
  
  public String getName()
  {
    return name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
}
