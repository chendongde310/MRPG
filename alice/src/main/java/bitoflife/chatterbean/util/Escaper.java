

package bitoflife.chatterbean.util;

public class Escaper
{
  /*
  Attribute Section
  */

  // Escape characters to the regular expression language.
  private static final String[] regex = {"\\.", "\\*", "\\+", "\\[", "\\^", "\\-", "\\]",
                                         "\\(", "\\)", "\\?", "\\|", "\\{", "\\}", "\\$"};

  /*
  Method Section
  */

  /**
  Replaces characters which are special to the regular expression language by their
  escaped versions.
  */
  public static String escapeRegex(String splitter)
  {
    String special = "";
    try
    {
      splitter = splitter.replaceAll("\\\\", "\\\\\\\\");

      for (int i = 0, n = regex.length; i < n; i++)
      {
        special = regex[i];
        splitter = splitter.replaceAll(special, "\\" + special);
      }
    }
    catch (RuntimeException e)
    {
      throw new RuntimeException(e.getMessage() + "\nWhen trying to escape \"" + special + "\" in \"" + splitter + "\"", e);
    }

    return splitter;
  }
}