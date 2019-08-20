package com.gplbj.testng.multThread;

import org.testng.annotations.Test;

/**
 * 通过xml进行多线程测试
 */
public class MultithreadOnXml {
    @Test
    public void test1(){
        System.out.printf("Thread Id: %s%n",Thread.currentThread());
    }
    @Test
    public void test2(){
        System.out.printf("Thread Id: %s%n",Thread.currentThread());
    }
    @Test
    public void test3(){
        System.out.printf("Thread Id: %s%n",Thread.currentThread());
    }
}
