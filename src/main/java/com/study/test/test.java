package com.study.test;

import com.study.common.UserEnum;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @ClassName test
 * @Description 测试
 * @Author jieyu
 * @Date 2018/12/20 16:40
 * @Version 1.0
 **/
public class test {
    public static void main(String[] args) {
        Object obj = new SimpleHash(UserEnum.ENCRYPTION.getKey(), "123456", "1", UserEnum.ENCRYPTION_TIMES.getCode());
        System.out.println(obj.toString());
    }
}
