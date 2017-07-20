

package bitoflife.chatterbean.text;

import java.io.FileInputStream;
import bitoflife.chatterbean.config.TokenizerConfig;
import bitoflife.chatterbean.config.TokenizerConfigStream;

public class TokenizerMother
{
  /*
  Method Section
  */
  
  public static Tokenizer newInstance() throws Exception
  {
    TokenizerConfig config = new TokenizerConfigStream(new FileInputStream("Bots/splitters.xml"));
    return new Tokenizer(config);
  }
}
