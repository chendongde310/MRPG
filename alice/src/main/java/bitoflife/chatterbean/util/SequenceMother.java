

package bitoflife.chatterbean.util;

import java.io.File;

public class SequenceMother
{
  /*
  Attributes
  */

  public static final File file = new File("Logs/sequence.txt");

  /*
  Methods
  */

  public Sequence newInstance()
  {
      return new Sequence(file);
  }

  public void reset()
  {
    (new File(file.getPath() + ".backup")).delete();
    file.delete();
  }
}
