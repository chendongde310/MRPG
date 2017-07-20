

package bitoflife.chatterbean.parser;

import java.io.InputStream;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.Context;
import bitoflife.chatterbean.Graphmaster;
import bitoflife.chatterbean.aiml.AIMLParser;
import bitoflife.chatterbean.text.Transformations;

public class AliceBotParser
{
  /*
  Attributes
  */
  
  private Class<? extends Context> contextClass = Context.class;
  
  private Class<? extends Graphmaster> graphmasterClass = Graphmaster.class;

  private AIMLParser aimlParser;

  private ContextParser contParser;

  private TransformationsParser normParser;
  
  /*
  Constructor
  */
  
  public AliceBotParser() throws AliceBotParserConfigurationException
  {
    try
    {
      aimlParser = new AIMLParser();
      contParser = new ContextParser();
      normParser = new TransformationsParser();
    }
    catch (Exception e)
    {
      throw new AliceBotParserConfigurationException(e);
    }
  }
  
  /*
  Methods
  */
  
  private Context newContext(InputStream defaults, InputStream splitters, InputStream substitutions) throws Exception 
  {
    Context context = (Context) contextClass.newInstance();
    contParser.parse(context, defaults);
    Transformations transformations = normParser.parse(splitters, substitutions);
    context.setTransformations(transformations);
    return context;
  }

  private Graphmaster newGraphmaster(InputStream... aiml) throws Exception 
  {
    Graphmaster graphmaster = (Graphmaster) graphmasterClass.newInstance();
    aimlParser.parse(graphmaster, aiml);
    return graphmaster;
  }
  
  public void parse(AliceBot bot, InputStream defaults, InputStream splitters, InputStream substitutions, InputStream... aiml)
    throws AliceBotParserException
  {
    try
    {
      Context context = newContext(defaults, splitters, substitutions);
      Graphmaster graphmaster = newGraphmaster(aiml);

      bot.setContext(context);      
      bot.setGraphmaster(graphmaster);
    }
    catch (Exception e)
    {
      throw new AliceBotParserException(e);
    }
  }

  public AliceBot parse(InputStream defaults, InputStream splitters, InputStream substitutions, InputStream... aiml)
    throws AliceBotParserException
  {
    try
    {
      AliceBot bot = new AliceBot();
      parse(bot, defaults, splitters, substitutions, aiml);
      return bot;
    }
    catch (AliceBotParserException e)
    {
      throw e;
    }
    catch (Exception e)
    {
      throw new AliceBotParserException(e);
    }
  }
  
  /*
  Accessor Section
  */
  
  public <C extends Context> void contextClass(Class<C> contextClass)
  {
    this.contextClass = contextClass;
  }
  
  public <M extends Graphmaster> void graphmasterClass(Class<M> graphmasterClass)
  {
    this.graphmasterClass = graphmasterClass;
  }
}
