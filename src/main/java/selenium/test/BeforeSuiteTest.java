package selenium.test;

import org.testng.ITestContext;
import org.testng.TestNG;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BeforeSuiteTest {

    @BeforeSuite
    public void beforeSuite(ITestContext context) {

        TestNG testNG = new TestNG();

        // Create an XmlSuite
        XmlSuite suite = new XmlSuite();
        suite.setName("TestSuiteHandle");

        // Create an XmlTest
        XmlTest test = new XmlTest(suite);
        test.setName("TestSuiteHandle");

        // Specify the class
        XmlClass xmlClass = new XmlClass("selenium.test.TestSuiteHandle");
        // Include methods dynamically
        xmlClass.setExcludedMethods(Collections.singletonList("disabledTestMethod"));

        // Add the class to the test
        test.getClasses().add(xmlClass);

        // Add the suite to the TestNG instance
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        testNG.setXmlSuites(suites);

        // Run the TestNG suite
        testNG.run();
    }
}
