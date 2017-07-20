

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Aiml implements AIMLElement
{
  /*
  Attributes
  */

  private final Topic defaultTopic = new Topic("*");  
  private final List<Topic> topics = new LinkedList<Topic>(Arrays.asList(new Topic[] {defaultTopic}));

  private final List<Category> categories = new LinkedList<Category>();
  
  private String version;

  /*
  Constructors
  */
  
  public Aiml(Attributes attributes)
  {
    version = attributes.getValue(0);
  }
  
  public Aiml(Category... categories)
  {
    this.categories.addAll(Arrays.asList(categories));
  }
  
  /*
  Method Section
  */
  
  public void appendChild(AIMLElement child)
  {
    if (child instanceof Category)
    {
      Category category = (Category) child;
      category.setTopic(defaultTopic);
      defaultTopic.appendChild(category);
      categories.add(category);
    }
    else
    {
      Topic topic = (Topic) child;
      topics.add(topic);
      categories.addAll(topic.categories());
    }
  }
  
  public void appendChildren(List<AIMLElement> children)
  {
    for (AIMLElement child : children)
      appendChild(child);
  }
  
  public List<Category> children()
  {
    return categories;
  }
  
  public boolean equals(Object obj)
  {
    if (obj == null || !(obj instanceof Aiml))
      return false;
    else
      return categories.equals(((Aiml) obj).categories);
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
  Properties
  */
  
  public String getVersion()
  {
    return version;
  }
}
