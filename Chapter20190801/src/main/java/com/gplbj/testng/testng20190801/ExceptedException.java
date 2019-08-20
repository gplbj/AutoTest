package com.gplbj.testng.testng20190801;

import org.testng.annotations.Test;

public class ExceptedException {
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是我的异常测试");
        throw new RuntimeException();
    }
}
