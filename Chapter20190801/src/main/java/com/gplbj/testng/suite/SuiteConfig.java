package com.gplbj.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("这是 beforeSuite 开始运行啦");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("这是 BeforeTest");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("这是 AfterSuite 开始运行啦");
    }
}
