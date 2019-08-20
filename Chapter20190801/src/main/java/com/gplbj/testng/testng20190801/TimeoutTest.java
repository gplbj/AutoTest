package com.gplbj.testng.testng20190801;

import org.testng.annotations.Test;

/**
 * 超时测试
 */
public class TimeoutTest {
    @Test(timeOut = 3000)
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }
    @Test(timeOut = 2000)
    public void testFalse() throws InterruptedException {
        Thread.sleep(3000);
    }
}
