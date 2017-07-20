

package bitoflife.chatterbean.aiml;

import org.xml.sax.Attributes;

import java.text.SimpleDateFormat;

import bitoflife.chatterbean.Match;

public class Date extends TemplateElement
{	
  /*
  Attributes
  */
  
  private final SimpleDateFormat format = new SimpleDateFormat();

  /**date tag format value, add by lcl**/
  private String formatStr = "";
  /*
  Constructors
  */

  public Date()
  {
  }

  public Date(Attributes attributes)
  {
	  formatStr = attributes.getValue(0);
  }

  /*
  Methods
  */
  
  public int hashCode()
  {
    return 13;
  }

  public String process(Match match)
  {	  
	  java.lang.System.out.println("format:" + this.formatStr);
    try
    {
    	format.applyPattern(formatStr);
    	return format.format(new java.util.Date());
    }
    catch (Exception e)
    {
    	return defaultDate(match);
    }
  }
  
  private String defaultDate(Match match)
  {
	    try
	    {
	      format.applyPattern((String) match.getCallback().getContext().property("predicate.dateFormat"));
	      return format.format(new java.util.Date());
	    }
	    catch (NullPointerException e)
	    {
	      return "";
	    }
  }
  
}
