

package bitoflife.chatterbean.aiml;

import junit.framework.TestCase;

public class TemplateElementTest extends TestCase
{
  /*
  Test Section
  */
  
  public void testToString()
  {
    Template template = new Template("Hello ", new Star(1), ", nice to meet you.");
    assertEquals("<template>Hello <star index=\"1\"/>, nice to meet you.</template>", template.toString());
  }
}
