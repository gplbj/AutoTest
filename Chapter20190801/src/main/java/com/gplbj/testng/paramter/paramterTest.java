package com.gplbj.testng.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 参数化测试
 */
public class paramterTest {
    @Test
    @Parameters({"name","age"})
    public void paraTest1(String name,int age){
        System.out.println("name="+name+"   ;age= "+age);
    }
}
