

package bitoflife.chatterbean.script;

/**
Base class for script-interpreting exceptions.
*/
public class InterpretingException extends Exception
{
  /** Version class identifier for the serialization engine. Matches the number of the last revision where the class was created / modified. */
  private static final long serialVersionUID = 8L;
  
  public InterpretingException(Exception cause)
  {
    super(cause);
  }
}
