package com.study.utils;

import java.util.UUID;

public class UUIDUtils {

    public static String createUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static void main(String[] args) {
        System.out.println("UUID值："+UUIDUtils.createUUID());
    }
}
