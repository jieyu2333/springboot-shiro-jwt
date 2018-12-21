package com.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.study.common.GlobalEnum;
import com.study.common.ResultData;
import com.study.service.ToolsService;
import com.study.utils.HttpUtils;
import com.study.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName ToolsServiceImpl
 * @Description 小工具
 * @Author jieyu
 * @Date 2018/12/21 15:29
 * @Version 1.0
 **/
@Service
@Slf4j
public class ToolsServiceImpl implements ToolsService {

    @Override
    public ResultData getKdInfoById(String type, String id) {
        log.info("快递查询开始，入参={}",type,id);
        ResultData resultData = null;
        //快递公司编码:
        // 申通=”shentong”
        // EMS=”ems”
        // 顺丰=”shunfeng”
        // 圆通=”yuantong”
        // 中通=”zhongtong”
        // 韵达=”yunda”
        // 天天=”tiantian”
        // 汇通=”huitongkuaidi”
        // 全峰=”quanfengkuaidi”
        // 德邦=”debangwuliu”
        // 宅急送=”zhaijisong”
        if ("shentong".equals(type) || "ems".equals(type) || "shunfeng".equals(type) || "yuantong".equals(type)
                || "zhongtong".equals(type) || "yunda".equals(type) || "tiantian".equals(type) || "huitongkuaidi".equals(type)
                || "quanfengkuaidi".equals(type) || "debangwuliu".equals(type) || "zhaijisong".equals(type)) {
            String url = "http://www.kuaidi100.com/query?type=" + type + "&postid=" + id + "";
            String data = HttpUtils.doPost(url, "");
            if (StringUtils.isNotBlank(data)) {
                JSONObject dataJson = JSONObject.parseObject(data);
                if ("200".equals(dataJson.getString("status"))) {
                    JSONArray list = dataJson.getJSONArray("data");
                    resultData = new ResultData(GlobalEnum.SELECT_SUCCESS.getCode(), GlobalEnum.SELECT_SUCCESS.getMsg(), list);
                } else {
                    resultData = new ResultData(GlobalEnum.SELECT_ERROR.getCode(), dataJson.getString("message"));
                }
            }

        } else {
            resultData = new ResultData(GlobalEnum.SELECT_ERROR.getCode(), "暂不支持此快递查询！");
        }

        log.info("快递查询结束，出参={}",JSON.toJSONString(resultData));
        return resultData;
    }


}
