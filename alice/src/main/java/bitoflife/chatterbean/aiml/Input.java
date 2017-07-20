
package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;
import bitoflife.chatterbean.text.Request;
import bitoflife.chatterbean.Match;

public class Input extends TemplateElement
{
  /*
  Attributes
  */

  private int requestIndex = 1, sentenceIndex = 1;

  /*
  Constructors
  */

  public Input(Attributes attributes)
  {
    String value = attributes.getValue(0);
    if (value == null) return;
    
    String[] indexes = value.split(",");
    requestIndex = Integer.parseInt(indexes[0].trim());
    if (indexes.length > 1) sentenceIndex = Integer.parseInt(indexes[1].trim());
  }
  
  public Input(int requestIndex, int sentenceIndex)
  {
    this.requestIndex = requestIndex;
    this.sentenceIndex = sentenceIndex;
  }
  
  /*
  Methods
  */
  
  public boolean equals(Object obj)
  {
    if (!super.equals(obj)) return false;

    Input compared = (Input) obj;
    return (requestIndex == compared.requestIndex &&
            sentenceIndex == compared.sentenceIndex);
  }
  
  public String toString()
  {
    return "<input index=\"" + requestIndex + ", " + sentenceIndex + "\"/>";
  }
  
  public String process(Match match)
  {
    if (match == null) return "";
    Request request = match.getCallback().getContext().getRequests(requestIndex - 1);
    return request.lastSentence(sentenceIndex - 1).trimOriginal();
  }
}
