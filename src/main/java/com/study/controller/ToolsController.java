package com.study.controller;

import com.study.common.ResultData;
import com.study.service.ToolsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ToolsController
 * @Description 小工具
 * @Author jieyu
 * @Date 2018/12/21 15:23
 * @Version 1.0
 **/
@Api(tags = "小工具")
@RestController
@RequestMapping("/tools")
public class ToolsController {

    @Autowired
    private ToolsService toolsService;

    @ApiOperation(value = "快递单号查询",notes = "快递单号查询")
    @RequestMapping(value = "getKdInfoById",method = RequestMethod.GET)
    public ResultData getKdInfoById(String type,String id){
        return toolsService.getKdInfoById(type,id);
    }

}
