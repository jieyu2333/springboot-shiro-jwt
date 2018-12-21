package com.study.service;

import com.study.common.ResultData;
import com.study.model.base.SysArea;

import java.util.List;

/**
 * @InterfaceName AreaService
 * @Description 地区相关接口
 * @Author jieyu
 * @Date 2018/12/21 10:39
 * @Version 1.0
 **/
public interface AreaService {

    ResultData<SysArea> listAreas(Integer pid);
}
