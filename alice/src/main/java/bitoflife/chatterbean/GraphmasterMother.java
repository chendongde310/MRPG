
package bitoflife.chatterbean;

import bitoflife.chatterbean.aiml.Category;
import bitoflife.chatterbean.aiml.Star;

public class GraphmasterMother
{
  /*
  Methods
  */

  public Graphmaster newInstance()
  {
    Graphmaster root = new Graphmaster();

    root.append(new Category(" SAY _ AGAIN ", "What, again? \"", new Star(1), "\"."));
    root.append(new Category(" SAY IT NOW ", "Whatever you want..."));
    root.append(new Category(" SAY * ", new Star(1), "!"));
    root.append(new Category(" DO YOU SEE THE * IN MY EYES ", "Yes, I see the ", new Star(1), " in your eyes."));

    return root;
  }
}
