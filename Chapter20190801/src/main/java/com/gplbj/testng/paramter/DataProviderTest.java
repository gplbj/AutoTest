package com.gplbj.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvider(String name,int age){
        System.out.println("name = "+name +"; age="+ age);
    }
    @DataProvider(name = "data")
    public Object[][] providerData(){
        Object[][] objects = new Object[][]{
                {"张三",10},
                {"历史",20},
                {"王五",30}
        };
        return objects;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test1方法 name = "+name +"; age="+ age);
    }
    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test2方法 name = "+name +"; age="+ age);
    }
    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result = null;
        if (method.getName().equals("test1")){
            result = new Object[][]{
                    {"张三哥",20},
                    {"李四哥",25}
            };
        }else if (method.getName().equals("test2")){
            result = new Object[][]{
                    {"王五哥",50},
                    {"赵柳哥",45}
            };
        }
        return result;
    }
}
