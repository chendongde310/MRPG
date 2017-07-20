

package bitoflife.chatterbean.text;

import junit.framework.TestCase;

public class SentenceTest extends TestCase
{
  /*
  Mehods
  */
  
  public void testEquals()
  {
    Sentence expected = new Sentence(" What's going on? ", new Integer[] {0, -1, 7, 13, 17}, " WHAT IS GOING ON ");
    Sentence actual = new Sentence(" What's going on? ", new Integer[0], " WHAT IS GOING ON ");
    assertFalse(expected.equals(actual));
    
    actual = new Sentence(" What's going on? ", new Integer[] {0, -1, 7, 13, 17}, " WHAT IS GOING ON ");
    assertEquals(expected, actual);
  }
  
  public void testOriginal()
  {
    Sentence sentence = new Sentence(" What's going on? ", new Integer[] {0, null, 7, 13, 17}, " WHAT IS GOING ON ");
    assertEquals(" What's ", sentence.original(0, 2));
    assertEquals(" What's ", sentence.original(0, 1));
    assertEquals(" What's ", sentence.original(1, 2));
  }
}
