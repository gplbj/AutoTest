package com.gplbj.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClasses1 {
    public void stu1(){
        System.out.println("GroupsOnClasses1中的stu1运行");
    }
}
