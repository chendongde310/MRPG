

package bitoflife.chatterbean.parser;

import org.xml.sax.Attributes;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static bitoflife.chatterbean.util.Escaper.escapeRegex;

public class SubstitutionBuilder implements ReflectionBuilder
{
  /*
  Attributes
  */
  
  private Map<String, Map<String, String>> substitutions;
  
  private Map<String, String> section;
  
  /*
  Constructor
  */
  
  public SubstitutionBuilder()
  {
    substitutions = new HashMap<String, Map<String, String>>();
  }
  
  public SubstitutionBuilder(Map<String, Map<String, String>> substitutions)
  {
    this.substitutions = substitutions;
  }
  
  /*
  Event Handlers
  */
  
  public void characters(char[] chars, int start, int length)
  {
  }
  
  public void startAccentuation(Attributes attributes)
  {
    section = substitutions.get("accentuation");
  }
  
  public void startCorrection(Attributes attributes)
  {
    section = substitutions.get("correction");
  }
  
  public void startPerson(Attributes attributes)
  {
    section = substitutions.get("person");
  }
  
  public void startPerson2(Attributes attributes)
  {
    section = substitutions.get("person2");
  }
  
  public void startGender(Attributes attributes)
  {
    section = substitutions.get("gender");
  }
  
  public void startProtection(Attributes attributes)
  {
    section = substitutions.get("protection");
  }
  
  public void startPunctuation(Attributes attributes)
  {
    section = substitutions.get("punctuation");
  }
  
  public void startSubstitute(Attributes attributes)
  {
    String find = escapeRegex(attributes.getValue(0));
    String replace = attributes.getValue(1);
    section.put(find, replace);
  }

  /*
  Method Section
  */
  
  public void clear()
  {
    substitutions.clear();
    substitutions.put("correction", new LinkedHashMap<String, String>());
    substitutions.put("protection", new LinkedHashMap<String, String>());
    substitutions.put("accentuation", new LinkedHashMap<String, String>());
    substitutions.put("punctuation", new LinkedHashMap<String, String>());
    substitutions.put("person", new LinkedHashMap<String, String>());
    substitutions.put("person2", new LinkedHashMap<String, String>());
    substitutions.put("gender", new LinkedHashMap<String, String>());
  }
  
  public Map<String, Map<String, String>> parsed()
  {
    return new HashMap<String, Map<String, String>>(substitutions);
  }
}
