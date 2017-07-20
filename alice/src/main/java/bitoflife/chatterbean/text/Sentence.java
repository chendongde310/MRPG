

package bitoflife.chatterbean.text;

import java.util.Arrays;

/**

*/
public class Sentence
{
  /*
  Attributes
  */

  private String original;
  private Integer[] mappings; // The index mappings of normalized elements to original elements.
  private String normalized;
  private String[] splitted; // The normalized entry, splitted in an array of words.

  public static final Sentence ASTERISK = new Sentence(" * ", new Integer[] {0, 2}, " * ");

  /*
  Constructors
  */

  public Sentence(String original, Integer[] mappings, String normalized)
  {
    setOriginal(original);
    setMappings(mappings);
    setNormalized(normalized);
  }

  /**
  Constructs a Sentence out of a non-normalized input string.
  */
  public Sentence(String original)
  {
    this(original, null, null);
  }

  /*
  Methods
  */

  public boolean equals(Object obj)
  {
    if (obj == null || !(obj instanceof Sentence)) return false;
    Sentence compared = (Sentence) obj;
    return (original.equals(compared.original) &&
            Arrays.equals(mappings, compared.mappings) &&
            normalized.equals(compared.normalized));
  }

  /**
  Gets the number of individual words contained by the Sentence.
  */
  public int length()
  {
    return splitted.length;
  }

  /**
  Returns the normalized as an array of String words.
  */
  public String[] normalized()
  {
    return splitted;
  }

  /**
  Gets the (index)th word of the Sentence, in its normalized form.
  */
  public String normalized(int index)
  {
    return splitted[index];
  }

  public String original(int beginIndex, int endIndex)
  {
    if (beginIndex < 0)
      throw new ArrayIndexOutOfBoundsException(beginIndex);
    
    while (beginIndex >= 0 && mappings[beginIndex] == null)
      beginIndex--;

    int n = mappings.length;
    while (endIndex < n && mappings[endIndex] == null)
      endIndex++;

    if (endIndex >= n)
      endIndex = n - 1;

    String value = original.substring(mappings[beginIndex], mappings[endIndex] + 1);
    
    value = value.replaceAll("^[^A-Za-z0-9]+|[^A-Za-z0-9]+$", " ");
    return value;
  }

  /**
  Returns a string representation of the Sentence. This is useful for printing the state of Sentence objects during tests.
  
  @return A string formed of three bracket-separated sections: the original sentence string, the normalized-to-original word mapping array, and the normalized string.
  */
  public String toString()
  {
    return "[" + original + "]" + Arrays.toString(mappings) + "[" + normalized + "]";
  }
  
  /**
  Returns a trimmed version of the original Sentence string.
  
  @return A trimmed version of the original Sentence string.
  */
  public String trimOriginal()
  {
    return original.trim();
  }

  /*
  Properties
  */

  public Integer[] getMappings()
  {
    return mappings;
  }

  public void setMappings(Integer[] mappings)
  {
    this.mappings = mappings;
  }

  /**
  Gets the Sentence in its normalized form.
  */
  public String getNormalized()
  {
    return normalized;
  }

  public void setNormalized(String normalized)
  {
    this.normalized = normalized;
    if (normalized != null)
      splitted = normalized.trim().split(" ");
  }

  /**
  Gets the Sentence, in its original, unformatted form.
  */
  public String getOriginal()
  {
    return original;
  }

  public void setOriginal(String original)
  {
    this.original = original;
  }
}
