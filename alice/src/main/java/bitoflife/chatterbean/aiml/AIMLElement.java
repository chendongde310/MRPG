

package bitoflife.chatterbean.aiml;

import java.util.List;

public interface AIMLElement
{
  /*
  Method Section
  */

  public void appendChild(AIMLElement child);

  public void appendChildren(List<AIMLElement> children);
}
