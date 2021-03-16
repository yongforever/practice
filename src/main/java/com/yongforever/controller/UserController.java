package com.yongforever.controller;

import com.yongforever.dao.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api("UserController相关的API")
public class UserController {

    @GetMapping("/select")
    @ApiOperation("查找用户")
    public User select(){
        return new User("张三","男",10);
    }
}
