

package bitoflife.chatterbean.util;

import junit.framework.TestCase;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SequenceTest extends TestCase
{
  /*
  Attributes
  */

  private static final SequenceMother mother = new SequenceMother();
  
  private Sequence sequence1, sequence2;

  /* 
  Events
  */

  protected void setUp() throws Exception
  {
    mother.reset();

    sequence1 = mother.newInstance();
    sequence2 = mother.newInstance();
  }

  protected void tearDown()
  {
    sequence1 = sequence2 = null;
  }

  /*
  Methods
  */

  public void testGetNext() throws IOException
  {
    for (int i = 0; i < 100; i++)
    {
      long a = sequence1.getNext();
      long b = sequence2.getNext();
    
      assertTrue("sequence1 = " + a + ", sequence2 = " + b, a != b);
    }
    
  }
  
  public void testPersistence() throws IOException
  {
    long count = sequence1.getNext();

    // Simulates a system crash at the moment the persistent file is open.    
    PrintWriter writer = new PrintWriter(new FileWriter(mother.file, false), true);
    writer.println("");
    writer.close();
    
    sequence1 = mother.newInstance();
    
    assertEquals(count + 1, sequence1.getNext());
  }
}
