package com.smalltalk.content.center;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class TestMain {

    public static void main(String[] args) {

        //按字母排序
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        JSONObject subJson = new JSONObject();
        subJson.put("add_wechatwork", "是");
        multiValueMap.set("exts", subJson.toJSONString().replace("\\", ""));

//        Map<String, String> ext = new HashMap<>(10);
//        ext.put("add_wechatwork", "是");
//        multiValueMap.set("exts", "{'add_wechatwork':'是'}");
        multiValueMap.set("name", "滨岩");


        multiValueMap.set("union_id", "oBB9psw-RBixgXmFMtfDJELaFfMI");
        multiValueMap.set("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        multiValueMap.forEach((k, v) -> {
            if (v == null || StringUtils.isEmpty(v.toString())) {
                multiValueMap.remove(k);
            }
        });

        multiValueMap.set("sign", SignUtil.sign(multiValueMap.toSingleValueMap(), "63207064-f6af-430d-898c-d409532966b5"));

        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(multiValueMap.toSingleValueMap()));

        System.out.println(jsonObject);
    }
}
