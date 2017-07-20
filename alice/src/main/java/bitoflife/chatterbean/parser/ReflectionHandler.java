

package bitoflife.chatterbean.parser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.reflect.Method;

public class ReflectionHandler extends DefaultHandler
{
  /*
  Attributes
  */
  
  private ReflectionBuilder builder = null;
  
  /*
  Constructor
  */
  
  public ReflectionHandler()
  {
  }
  
  public ReflectionHandler(ReflectionBuilder builder)
  {
    this.builder = builder;
  }
  
  /*
  Methods
  */

  public void characters(char[] chars, int start, int length)
  {
    builder.characters(chars, start, length);
  }
  
  public void endElement(String namespace, String name, String qname)
  {
    try
    {
      String methodName = "end" + qname.substring(0, 1).toUpperCase() + qname.substring(1); 
      Method event = builder.getClass().getMethod(methodName);
      event.invoke(builder);
    }
    catch (NoSuchMethodException e)
    {
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void startElement(String namespace, String name, String qname, Attributes attributes)
  {
    try
    {
      String methodName = "start" + qname.substring(0, 1).toUpperCase() + qname.substring(1); 
      Method event = builder.getClass().getMethod(methodName, Attributes.class);
      event.invoke(builder, attributes);
    }
    catch (NoSuchMethodException e)
    {
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  /*
  Properties
  */
  
  public ReflectionBuilder getReflectionBuilder()
  {
    return builder;
  }
  
  public void setReflectionBuilder(ReflectionBuilder builder)
  {
    this.builder = builder;
  }
}
