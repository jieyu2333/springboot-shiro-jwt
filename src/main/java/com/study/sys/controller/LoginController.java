package com.study.sys.controller;

import com.study.common.ResultData;
import com.study.sys.entity.User;
import com.study.sys.service.IUserService;
import com.study.config.jwt.JwtUtils;
import com.study.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private IUserService userService;


    @PostMapping("login")
    public ResultData login(@RequestBody Map<String,String> map){

        String userName = map.get("userName");
        String password = map.get("password");
        ResultData<User> result = userService.checkUser(userName,password);
        if (result.getCode()==0){
            User user = result.getData();
            String token = JwtUtils.createToken(user.getId(),user.getUserName());
            if(StringUtils.isNotBlank(token)){
                return new ResultData(0,"login success",token);
            }
            return new ResultData(1,"login fail");
        }
        return result;

    }
}
