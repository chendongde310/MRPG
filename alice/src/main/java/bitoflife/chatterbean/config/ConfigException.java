

package bitoflife.chatterbean.config;

public class ConfigException extends Exception
{
  /*
  Attribute Section
  */
  
  private static final long serialVersionUID = 7L;

  /*
  Constructor Section
  */
  
  /**
  Constructs a new exception with <code>null</code> as its detail message. The cause is not initialized, and may subsequently be initialized by a call to <code>initCause()</code>.
  */  
  public ConfigException()
  {
    super("Configuration failed");
  }

  /**
  Constructs a new exception with the specified detail message. The cause is not initialized, and may subsequently be initialized by a call to <code>initCause()</code>.
  
  @param message The detail message. The detail message is saved for later retrieval by the <code>getMessage()</code> method.
  */
  public ConfigException(String message)
  {
    super(message);
  }
  
  /**
  Constructs a new exception with the specified detail message and cause. Note that the detail message associated with cause is <u>not</u> automatically incorporated in this exception's detail message.

  @param message The detail message, which is saved for later retrieval by the <code>getMessage()</code> method.
  @param cause The cause, which is saved for later retrieval by the <code>getCause()</code> method. A <code>null</code> value is permitted, and indicates that the cause is nonexistent or unknown.
  */
  public ConfigException(String message, Throwable cause)
  {
    super(message, cause);
  }
  
  /**
  Constructs a new exception with the specified cause and a detail message of <code>(cause == null ? null : cause.toString())</code>.

  @param cause The cause, which is saved for later retrieval by the <code>getCause()</code> method. A <code>null</code> value is permitted, and indicates that the cause is nonexistent or unknown.
  */
  public ConfigException(Throwable cause)
  {
    super(cause);
  }
  
  /**
  Constructs a new exception with the specified object as its cause. If the object is a <code>Throwable</code>, it will be incorporated as this exception's cause; otherwise, the result of calling th method <code>toString()</code> on it will be incorporated as the exception's message.
  
  @param cause The cause of the exception.
  */
  public ConfigException(Object cause)
  {
    this();
    if (cause instanceof Throwable)
      initCause((Throwable) cause);
    else
      initCause(new Exception(cause.toString()));
  }
}
