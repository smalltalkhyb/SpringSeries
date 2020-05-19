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
        //multiValueMap.set("exts", subJson.toJSONString().replace("\\", ""));

//        Map<String, String> ext = new HashMap<>(10);
//        ext.put("add_wechatwork", "是");
//        multiValueMap.set("exts", "{'add_wechatwork':'是'}");
        multiValueMap.set("name", "范志远");


        multiValueMap.set("union_id", "oBB9ps1lkC4v6KwIFfXbHuIkPQX8");
        multiValueMap.set("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        multiValueMap.forEach((k, v) -> {
            if (v == null || StringUtils.isEmpty(v.toString())) {
                multiValueMap.remove(k);
            }
        });

        multiValueMap.set("sign", SignUtil.sign(multiValueMap.toSingleValueMap(), "c62ffacc-f368-4d27-9a2e-7c8f1446f4bf"));

        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(multiValueMap.toSingleValueMap()));

        System.out.println(jsonObject);
    }
}
