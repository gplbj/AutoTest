package com.gplbj.testng.testng20190801;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseAnnotation {
    @Test
    public void testCase1(){
        System.out.println("这是testcase1");
    }
    @BeforeSuite
    public void beforeSuitTest(){
        System.out.println("这是测试套件BeforeSuite");
    }
    @AfterSuite
    public void afterSuitTest(){
        System.out.println("这是测试套件AfterSuite");
    }
}
