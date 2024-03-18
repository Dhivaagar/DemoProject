package selenium.test;

import lombok.Setter;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.TestNG;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Setter
public class TestSuiteHandle extends BeforeSuiteTest {

    @Test
    public void testMethod1() {
        // Your test logic for method 1
        System.out.println("testMethod1");
    }

    @Test
    public void testMethod2() {
        // Your test logic for method 1
        System.out.println("testMethod1");
    }

    @Test
    public void testMethod3() {
        // Your test logic for method 1
        System.out.println("testMethod1");
    }

    @Test
    public void testMethod4() {
        // Your test logic for method 1
        System.out.println("testMethod1");
    }

    @Test
    public void disabledTestMethod() {
        // Your test logic for the disabled method
        System.out.println("disabledTestMethod");
    }
}
