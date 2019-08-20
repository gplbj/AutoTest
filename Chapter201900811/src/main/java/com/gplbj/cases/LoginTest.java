package com.gplbj.cases;

import com.gplbj.config.TestConfig;
import com.gplbj.model.InterfaceName;
import com.gplbj.model.LoginCase;
import com.gplbj.utils.ConfigFile;
import com.gplbj.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.CookieStore;

public class LoginTest {
    @BeforeTest(groups = "loginTrue", description = "测试准备工作中,获取HttpClient")
    public void beforeTest() {
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test(groups = "loginTrue", description = "用户成功登陆接口")
    public void loginTrue() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase", 1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
        //下边的代码为写完接口的测试代码  第一步发送请求
        String result = getResult(loginCase);
        //处理结果 就是判断返回结果是否符合预期
        Assert.assertEquals(loginCase.getExpected(), result);
    }

    @Test(groups = "loginFalse", description = "用户登陆失败接口")
    public void loginFalse() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase", 2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
    }

    private String getResult(LoginCase loginCase) throws IOException {
        //下边的代码为写完接口的测试代码
        HttpPost post = new HttpPost(TestConfig.loginUrl);
        JSONObject param = new JSONObject();
        //声明一个对象来进行响应结果的存储
        String result = "";
        param.put("userName", loginCase.getUserName());
        param.put("password", loginCase.getPassword());
        //设置 请求头信息 设置 header
        post.setHeader("content-type", "application/json");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);
        //执行post方法
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        //执行响应结果
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        TestConfig.store = (CookieStore) TestConfig.defaultHttpClient.getCookieStore();
        return result;
    }
}
