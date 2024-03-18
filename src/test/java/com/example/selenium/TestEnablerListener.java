package com.example.selenium;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;
import org.testng.internal.annotations.IAnnotationTransformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestEnablerListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod invokedMethod, ITestResult result) {
        Method method = result.getMethod().getConstructorOrMethod().getMethod();
        System.out.println(method.getDeclaringClass().getSimpleName());
        String suiteName = result.getTestContext().getSuite().getName();
        String className = result.getTestClass().getRealClass().getSimpleName();
        if (method == null) {
            return;
        }
        System.out.println(Arrays.toString(method.getAnnotations()));
        System.out.println("Suite Name: " + suiteName);
        System.out.println("Class Name: " + className);
            if (method.isAnnotationPresent(Deprecated.class)) {
            throw new SkipException("These Tests shouldn't be run in Production");
        }
    }
}
