package com.example.selenium;

import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import selenium.test.AlertHandling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ExampleTest {

    @Test
    public void exampleTestMethod2() {
        // Your test logic here
        System.out.println("Test method executed.");
        AlertHandling.main(null);
    }
}
