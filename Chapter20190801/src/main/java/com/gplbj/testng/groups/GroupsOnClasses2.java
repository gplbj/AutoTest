package com.gplbj.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClasses2 {
    public void stu1(){
        System.out.println("GroupsOnClasses2中的stu1运行");
    }
    public void stu2(){
        System.out.println("GroupsOnClasses2中的stu2运行");
    }
}
