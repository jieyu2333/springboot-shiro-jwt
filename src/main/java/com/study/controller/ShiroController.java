package com.study.controller;

import com.alibaba.fastjson.JSON;
import com.study.common.ResultData;
import com.study.common.UserEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName ShiroController
 * @Description 自定义shiro某些方法
 * @Author jieyu
 * @Date 2018/12/13 10:20
 * @Version 1.0
 **/
@Api(tags = "自定义shiro某些方法")
@RestController
@Slf4j
public class ShiroController {
    /**
     * 重写shiro自带方法
     *未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @ApiOperation(value = "未登录初始化",notes = "未登录初始化")
    @RequestMapping(value = "/unauth", method = RequestMethod.GET)
    public ResultData unauth() {
        ResultData resultData = new ResultData(UserEnum.TO_LOGIN.getCode(), UserEnum.TO_LOGIN.getMsg());
        log.info("未登录，出参={}",JSON.toJSONString(resultData));
        return resultData;
    }


}
