

package bitoflife.chatterbean.util;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
Synchronized linear integer generator.
*/
public class Sequence
{
  /*
  Attributes
  */
  
  private File backup, file;
  
  /*
  Constructor
  */
  
  public Sequence(File file)
  {
    this.file = file;
    backup = new File(file.getAbsolutePath() + ".backup");
  }

  public Sequence(String path)
  {
    file = new File(path);
    backup = new File(path + ".backup");
  }
  
  /*
  Methods
  */
  
  private long loadNext(File file) throws IOException
  {
    String line = "";

    try
    {
      BufferedReader reader = new BufferedReader(new FileReader(file));

      line = reader.readLine();

      long next = Long.parseLong(line);

      reader.close();

      return next;
    }
    catch (NumberFormatException e)
    {
      throw new IOException("Illegal value on persistence file: " + line);
    }
    catch (FileNotFoundException e)
    {
      return 0;
    }
  }
  
  private void saveNext(File file, long next) throws IOException
  {
    PrintWriter writer = new PrintWriter(new FileWriter(file, false), true);

    writer.println(Long.toString(next + 1));
    
    writer.close();
  }

  /**
  Return the next number in the sequence.
  */
  public synchronized long getNext() throws IOException
  {
    long next = 0;

    try
    {
      next = loadNext(file.exists() ? file : backup);
    }
    catch (IOException e)
    {
      next = loadNext(backup);
    }

    saveNext(backup, next);
    saveNext(file, next);

    return next;
  }
}
