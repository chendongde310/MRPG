

package bitoflife.chatterbean;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.textui.TestRunner;

public class TestSuite extends junit.framework.TestSuite
{
  /*
  Attributes
  */
  
  /** Names of the test classes to include in the test. */
  private static String[] testNames;

  /*
  Methods
  */
  
  /**
  Adds all the known unit tests to the suite.
  
  @param suite The test suite to which the known unit tests must be added. 
  */
  private static void addAllTests(TestSuite suite)
  {
    suite.addTestSuite(bitoflife.chatterbean.AliceBotTest.class);
    suite.addTestSuite(bitoflife.chatterbean.GraphmasterTest.class);
    suite.addTestSuite(bitoflife.chatterbean.LoggerTest.class);
    suite.addTestSuite(bitoflife.chatterbean.MatchTest.class);
    suite.addTestSuite(bitoflife.chatterbean.aiml.AIMLHandlerTest.class);
    suite.addTestSuite(bitoflife.chatterbean.aiml.AIMLParserTest.class);
    suite.addTestSuite(bitoflife.chatterbean.aiml.CategoryTest.class);
    suite.addTestSuite(bitoflife.chatterbean.aiml.SystemTest.class);
    suite.addTestSuite(bitoflife.chatterbean.aiml.TemplateElementTest.class);
    suite.addTestSuite(bitoflife.chatterbean.parser.ContextParserTest.class);
    suite.addTestSuite(bitoflife.chatterbean.text.SentenceTest.class);
    suite.addTestSuite(bitoflife.chatterbean.text.SentenceSplitterTest.class);
    suite.addTestSuite(bitoflife.chatterbean.text.TransformationsTest.class);
    suite.addTestSuite(bitoflife.chatterbean.text.SubstitutionTest.class);
    suite.addTestSuite(bitoflife.chatterbean.text.TokenizerTest.class);
    suite.addTestSuite(bitoflife.chatterbean.util.SearcherTest.class);
    suite.addTestSuite(bitoflife.chatterbean.util.SequenceTest.class);
  }

  /**
  Main entry point.
  
  @param args The names of test classes that must be included in the test. If ommited, all known tests will be included. 
  */
  public static void main(String args[])
  {
    testNames = args;
    TestRunner.main(new String[] {"-noloading", "bitoflife.chatterbean.TestSuite"});
  }

  /**
  Returns a new test suite.
  
  @return A new test suite.
  */
  public static Test suite()
  {
    TestSuite suite = new TestSuite();
    
    if (testNames == null || testNames.length == 0) /* If no argument was given during the command-line call... */
      addAllTests(suite); /* Add all known tests to the suite. */
    else try // Otherwise...
    {
      // Add only the given tests to the suite.
      for (String name : testNames) 
        suite.addTestSuite((Class<? extends TestCase>) Class.forName(name));
    }
    catch (ClassNotFoundException e)
    {
      throw new RuntimeException(e);
    }

    return suite;
  }
}
