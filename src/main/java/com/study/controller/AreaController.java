package com.study.controller;

import com.study.common.ResultData;
import com.study.model.base.SysArea;
import com.study.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AreaController
 * @Description 地区相关controller
 * @Author jieyu
 * @Date 2018/12/21 10:56
 * @Version 1.0
 **/
@Api(tags = "地区相关方法")
@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @ApiOperation(value = "地区查询",notes = "地区查询")
    @RequestMapping(value = "/{pid}",method = RequestMethod.GET)
    public ResultData<SysArea> listAreas(@PathVariable(value = "pid") Integer pid){
        return areaService.listAreas(pid);
    }
}
