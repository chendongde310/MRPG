

package bitoflife.chatterbean.script;

public interface Interpreter
{
  public Object evaluate(String script) throws InterpretingException;
  
  public Object variable(String name) throws InterpretingException;
  
  public void variable(String name, Object value) throws InterpretingException;
}
