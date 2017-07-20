

package bitoflife.chatterbean.text;

import java.io.FileInputStream;
import bitoflife.chatterbean.parser.TransformationsParser;

public class TransformationsMother
{
  /*
  Methods
  */

  public Transformations newInstance() throws Exception
  {
    TransformationsParser parser = new TransformationsParser();
    return parser.parse(new FileInputStream("Bots/splitters.xml"), new FileInputStream("Bots/substitutions.xml"));
  }
}
