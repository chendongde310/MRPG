

package bitoflife.chatterbean.text;

public class Response extends Request
{
  /*
  Constructor
  */

  public Response()
  {
    super();
  }

  public Response(String original)
  {
    super(original);
  }
  
  public Response(String original, Sentence... sentences)
  {
    super(original, sentences);
  }

  /*
  Methods
  */

  public void append(String output)
  {
    StringBuilder builder = new StringBuilder();
    String original = getOriginal();
    //fixed by lcl for StringIndexOutOfBoundsException.
    if (original != null && original.length() > 1)
    {
      builder.append(original);
      int index = builder.length() - 1;
      if (builder.charAt(index) != ' ')
        builder.append(' ');
    }
    
    builder.append(output);
    setOriginal(builder.toString());
  }
}
