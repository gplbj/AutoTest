package com.gplbj.controller;

import com.gplbj.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(value = "v1", description = "这是我的第一个版本的demo")
@RequestMapping("v1")
public class Demo {
    //首先获取一个执行SQL语句的对象
    @Autowired
    private SqlSessionTemplate template;

    /**
     * 查询方法
     *
     * @return
     */
    @RequestMapping(value = "/getUserCount", method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数", httpMethod = "GET")
    public int getUserCount() {
        return template.selectOne("getUserCount");// statement 是 mysql.xml里面的 id

    }

    /**
     * 添加方法
     *
     * @param user User实体类
     * @return
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public int addUser(@RequestBody User user) {
        return template.insert("addUser", user);
    }

    /**
     * 修改方法
     * @param user
     * @return
     */
    @RequestMapping(value = "updateUser", method = RequestMethod.GET)
    public int updateUser(@RequestBody User user){
        return template.update("updateUser",user);
    }
    @RequestMapping(value = "deleteUser",method = RequestMethod.POST)
    public int deleteUser(@RequestParam int id){
        return template.delete("deleteUser",id);
    }
}
