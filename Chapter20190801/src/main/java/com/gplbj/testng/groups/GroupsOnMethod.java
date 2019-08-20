package com.gplbj.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端组的测试方法1");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端组的测试方法2");
    }
    @Test(groups = "server")
    public void test3(){
        System.out.println("这是服务端组的测试方法3");
    } @Test(groups = "client")
    public void test4(){
        System.out.println("这是客户端组的测试方法4");
    }
    @Test(groups = "client")
    public void test5(){
        System.out.println("这是客户端组的测试方法5");
    }
    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务端组运行之前的运行方法!!!");
    }
    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("这是服务端组运行之后的运行方法!!!");
    }
    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("这是客户端组运行之前的运行方法!!!");
    }
    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("这是客户端组运行之后的运行方法!!!");
    }

}
