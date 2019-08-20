package com.gplbj.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClasses3 {
    public void teacher1(){
        System.out.println("GroupsOnClasses3中的teacher1运行");
    }
    public void teacher2(){
        System.out.println("GroupsOnClasses3中的teacher2运行");
    }
}
