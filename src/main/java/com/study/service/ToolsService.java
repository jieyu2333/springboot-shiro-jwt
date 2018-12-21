package com.study.service;

import com.study.common.ResultData;

/**
 * @InterfaceName ToolsService
 * @Description 小工具
 * @Author jieyu
 * @Date 2018/12/21 15:23
 * @Version 1.0
 **/
public interface ToolsService {

    ResultData getKdInfoById(String type,String id);

}
