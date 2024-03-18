package com.example.selenium;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class PipelineTest {

    public static final boolean isEnabled = true;
    @Test
    public void test1() {
        Assert.assertTrue(true);
    }

    @Test
    public void test2() {
        Assert.assertTrue(true);
    }

    @Test
    public void test3() {
        Assert.fail();
    }

    private boolean isEnabled() {
        return isEnabled;
    }
}
