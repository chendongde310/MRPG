

package bitoflife.chatterbean.text;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class TokenizerTest extends TestCase
{
  /*
  Attribute Section
  */

  private Tokenizer tokenizer;

  /*
  Event Section
  */

  protected void setUp() throws Exception
  {
    tokenizer = TokenizerMother.newInstance();
  }

  protected void tearDown()
  {
    tokenizer = null;
  }

  /*
  Test Section
  */

  public void testTokenize()
  {
    String input = " You shut your mouth,how   can you say I go about things the wrong way?  ";
    List<String> expected = Arrays.asList(
      new String[] {"You", "shut", "your", "mouth", ",", "how", "can", "you", "say",
                    "I", "go", "about", "things", "the", "wrong", "way", "?"});
    List<String> actual = tokenizer.tokenize(input);

    assertEquals(expected, actual);
  }
}
