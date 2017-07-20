

package bitoflife.chatterbean.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Searcher implements FilenameFilter
{
  /*
  Attribute Section
  */
  
  private static final String[] STRING_ARRAY = {};
  
  private String expression;

  /*
  Method Section
  */
  
  protected String[] dir(String path, String expression)
  {
    this.expression = expression;

    if (path.charAt(path.length() - 1) != '/') path += "/";
    File dir = new File(path);
    String[] names = dir.list(this);
    Arrays.sort(names);
    
    for (int i = 0, n = names.length; i < n; i++)
      names[i] = path + names[i];

    return names;
  }
  
  protected String[] dir(URL base, String path, String expression) throws IOException
  {
    if (path.charAt(path.length() - 1) != '/')
      path += "/";

    URL url = new URL(base, path);
    BufferedReader dir = new BufferedReader(
        new InputStreamReader(url.openStream())
    );
    
    List<String> files = new LinkedList<String>();
    for (String file = ""; (file = dir.readLine()) != null;)
      if (file.matches(expression))
        files.add(path + file);
    
    return files.toArray(STRING_ARRAY);
  }

  public boolean accept(File dir, String name)
  {
    return name.matches(expression);
  }

  public InputStream[] search(String path, String expression) throws IOException
  {
    String[] names = dir(path, expression);
    InputStream[] files = new InputStream[names.length];
    for (int i = 0, n = names.length; i < n; i++)
      files[i] = new FileInputStream(names[i]);

    return files;
  }
  
  public InputStream[] search(URL base, String path, String expression) throws IOException
  {
    String[] files = dir(base, path, expression);
    InputStream[] streams = new InputStream[files.length];
    for (int i = 0, n = files.length; i < n; i++)
    {
      URL aiml = new URL(base, files[i]);
      streams[i] = aiml.openStream();
    }

    return streams;
  }
}
