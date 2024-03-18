package com.example.selenium;

import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;

@Listeners(TestEnablerListener.class)
public class ExampleTest {


    @Test
    @Deprecated
    public void exampleTestMethod() {
//        System.out.println(Arrays.toString(method.getAnnotations()));
        System.out.println("Test method executed.");
    }

    @Test
    public void exampleTestMethod2() {
        // Your test logic here
        System.out.println("Test method 2 executed.");
    }
}
