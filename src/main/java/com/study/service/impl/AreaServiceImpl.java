package com.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.study.common.GlobalEnum;
import com.study.common.ResultData;
import com.study.dao.base.SysAreaMapper;
import com.study.model.base.SysArea;
import com.study.model.base.SysAreaExample;
import com.study.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AreaServiceImpl
 * @Description 地区相关实现类
 * @Author jieyu
 * @Date 2018/12/21 10:44
 * @Version 1.0
 **/
@Service
@Slf4j
public class AreaServiceImpl implements AreaService {

    @Autowired
    private SysAreaMapper sysAreaMapper;

    @Override
    public ResultData<SysArea> listAreas(Integer pid) {
        log.info("查询区域信息开始，入参={}",pid);
        ResultData<SysArea> resultData = null;
        SysAreaExample sysAreaExample = new SysAreaExample();
        sysAreaExample.createCriteria().andPidEqualTo(pid);
        sysAreaExample.setOrderByClause("id ASC");
        List<SysArea> list = sysAreaMapper.selectByExample(sysAreaExample);
        if (list!=null&&list.size()>0){
            resultData = new ResultData<>(GlobalEnum.SELECT_SUCCESS.getCode(),GlobalEnum.SELECT_SUCCESS.getMsg(),list);
        }else {
            resultData = new ResultData<>(GlobalEnum.SELECT_ERROR_NO_DATA.getCode(),GlobalEnum.SELECT_ERROR_NO_DATA.getMsg());
        }
        log.info("查询区域信息结束，出参={}", JSON.toJSONString(resultData));
        return resultData;
    }

}
