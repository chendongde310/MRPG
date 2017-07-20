

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;

import java.lang.System;
import java.util.Arrays;
import java.util.List;

public class Pattern implements AIMLElement
{
  /*
  Attribute Section
  */

  private String[] pattern;

  private int hashCode;
  
  /*
  Constructor Section
  */
  
  public Pattern()
  {
  }
  
  public Pattern(String pattern)
  {
    this.pattern = pattern.trim().split(" ");
    hashCode = Arrays.hashCode(this.pattern);
  }
  
  public Pattern(Attributes attributes)
  {
  }
  
  /*
  Method Section
  */
  
  public void appendChild(AIMLElement child)
  {
    String text = child.toString();
    if (pattern == null)
      pattern = new String[] {text};
    else
    {
      int length = pattern.length;
      String[] larger = new String[length + 1];
      System.arraycopy(pattern, 0, larger, 0, length);
      larger[length] = text;
      pattern = larger;
    }
  }
  
  public void appendChildren(List<AIMLElement> children)
  {
    StringBuilder builder = new StringBuilder();
    for (AIMLElement child : children)
      builder.append(child);
    
    String text = builder.toString().trim();
    pattern = text.split(" ");
    hashCode = Arrays.hashCode(pattern);
  }

  public boolean equals(Object obj)
  {
    if (obj == null || !(obj instanceof Pattern)) return false;
    Pattern compared = (Pattern) obj;
    return Arrays.equals(pattern, compared.pattern);
  }

  public int hashCode()
  {
    return hashCode;
  }

  public String toString()
  {
    StringBuilder buffer = new StringBuilder();
    for (int i = 0, n = pattern.length;;)
    {
      buffer.append(pattern[i]);
      if (++i >= n) break;
      buffer.append(" ");
    }
    
    return buffer.toString();
  }
  
  /*
  Property Section
  */

  public String[] getElements()
  {
    return pattern;
  }

  public void setElements(String[] pattern)
  {
    this.pattern = pattern;
    hashCode = Arrays.hashCode(pattern);
  }
}
