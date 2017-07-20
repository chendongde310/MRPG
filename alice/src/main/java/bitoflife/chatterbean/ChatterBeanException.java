

package bitoflife.chatterbean;

/**
Basic exception class for exceptions thrown from ChatterBean's main class.
*/
public class ChatterBeanException extends RuntimeException
{  
  /** Version class identifier for the serialization engine. Matches the number of the last revision where the class was created / modified. */
  private static final long serialVersionUID = 8L;
  
  public ChatterBeanException(String message)
  {
    super(message);
  }
  
  public ChatterBeanException(Exception cause)
  {
    super(cause);
  }
}
