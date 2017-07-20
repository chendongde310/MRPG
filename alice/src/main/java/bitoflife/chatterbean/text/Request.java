

package bitoflife.chatterbean.text;

import java.util.Arrays;

public class Request
{
  /*
  Attributes
  */
  
  private Sentence[] sentences;
  private String original;
  
  /*
  Constructor
  */
  
  public Request()
  {
  }
  
  public Request(String original)
  {
    this.original = original;
  }
  
  public Request(String original, Sentence... sentences)
  {
    this.original = original;
    this.sentences = sentences;
  }
  
  /*
  Methods
  */
  
  public boolean empty()
  {
    return (sentences == null || sentences.length == 0);
  }
  
  public boolean equals(Object obj)
  {
    if (obj == null || !(obj instanceof Request)) return false;
    
    Request compared = (Request) obj;
    return original.equals(compared.original) &&
           Arrays.equals(sentences, compared.sentences);
  }
  
  public Sentence lastSentence(int index)
  {
    return sentences[sentences.length - (1 + index)];
  }
  
  public String toString()
  {
    return original;
  }
  
  public String trimOriginal()
  {
    return original.trim();
  }
  
  /*
  Properties
  */
  
  public String getOriginal()
  {
    return original;
  }
  
  public void setOriginal(String original)
  {
    this.original = original;
  }
  
  public Sentence[] getSentences()
  {
    return sentences;
  }
  
  public Sentence getSentences(int index)
  {
    return sentences[index];
  }
  
  public void setSentences(Sentence[] sentences)
  {
    this.sentences = sentences;
  }
}