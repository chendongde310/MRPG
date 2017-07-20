

package bitoflife.chatterbean.config;

import bitoflife.chatterbean.text.Tokenizer;

public interface TokenizerConfig
{
  public Tokenizer newInstance();

  public String[] splitters();
}
