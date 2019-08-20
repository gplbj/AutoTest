package com.gplbj.testng.testng20190801;

import org.testng.annotations.Test;

/**
 * 依赖测试
 * 当被依赖的case失败了 运行的case也会被忽略
 * 当被依赖的case成功了 运行的case 也会将 被依赖的带出来
 */
public class DependTest {
    @Test
    public void test1(){
        System.out.println("test1 run");
        throw new RuntimeException();
    }
    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run");
    }
}
