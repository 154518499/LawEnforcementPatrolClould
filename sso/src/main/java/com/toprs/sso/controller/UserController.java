package com.toprs.sso.controller;

import com.toprs.common.pojo.User;
import com.toprs.common.response.Result;
import com.toprs.sso.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: scp
 * @Date: 2018/12/4 16:35
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "登陆", nickname = "login", notes = "用户登陆", response = Result.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "登录成功"),
            @ApiResponse(code = 201, message = "密码错误"),
            @ApiResponse(code = 202, message = "权限不足"),
            @ApiResponse(code = 500, message = "内部服务器错误")})
    @RequestMapping(value="/login",produces = {"application/json"},method = RequestMethod.GET)
    //String userName, String password
    public Result login(){
        return new Result(200,"登陆成功",null);
    }


    @RequestMapping(value="/getUser",produces = {"application/json"},method = RequestMethod.GET)
    public User getUser(){
        User user=new User();
        user.setUserName("scp");
        user.setDeptId(1);
        return user;
    }

}
