package com.smalltalk.content.center;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: ybhu
 * @create: 2020/05/18 15:49
 */
public class TestMainBehaviour {


    private static String str = "{\"u_name\":\"SuperMan\",\"u_avatar\":\"http://wx.qlogo.cn/mmhead/B2EfAOZfS1ia3gIsblNEl3FFKticZ6icKlSG10mFC13Bq50pEicul4Bibbg/0\",\"u_type\":1,\"u_gender\":1,\"u_unionid\":\"oBB9ps3D4qECBxmQ_iCNgM_rbq-M\",\"u_position\":null,\"u_corp_name\":null,\"u_corp_full_name\":null,\"u_external_profile\":null,\"u_follow_user\":[{\"userId\":\"lxd-kkb\",\"remark\":\"002\",\"description\":\"\",\"createTime\":1589771102,\"state\":null,\"remarkCompany\":null,\"remarkMobiles\":[],\"tags\":[]},{\"userId\":\"KaiKeBaXiaoMiaoLaoShi\",\"remark\":\"\",\"description\":\"\",\"createTime\":1589706427,\"state\":null,\"remarkCompany\":null,\"remarkMobiles\":[],\"tags\":[]}],\"s_userid\":\"lxd-kkb\",\"s_name\":\"开课吧–马克老师\",\"s_mobile\":\"15601356729\",\"s_department\":[21],\"s_order\":[0],\"s_position\":\"\",\"s_gender\":\"MALE\",\"s_email\":\"\",\"s_is_leader_in_dept\":[0],\"s_avatar\":\"https://wework.qpic.cn/wwhead/duc2TvpEgSTPk74IwG7Bs6PNUbgWwKUuGgI3j6UamqM6yv3tTnFBia2ADvG5z9f8ltwOhVUg8kaE/0\",\"s_thumb_avatar\":\"https://wework.qpic.cn/wwhead/duc2TvpEgSTPk74IwG7Bs6PNUbgWwKUuGgI3j6UamqM6yv3tTnFBia2ADvG5z9f8ltwOhVUg8kaE/100\",\"s_telephone\":\"\",\"s_alias\":\"\",\"s_extattr\":[],\"s_status\":1,\"s_qr_code\":\"https://open.work.weixin.qq.com/wwopen/userQRCode?vcode=vca05f776205870fcc\",\"s_external_profile\":[],\"s_external_position\":\"\",\"s_address\":\"https://wework.qpic.cn/wwhead/duc2TvpEgSTPk74IwG7Bs6PNUbgWwKUuGgI3j6UamqM6yv3tTnFBia2ADvG5z9f8ltwOhVUg8kaE/0\",\"s_open_userid\":\"lxd-kkb\",\"s_main_department\":[21]}";

    public static void main(String[] args) {


        String str2 = str.replace("\\", "").replace("[", "").replace("]", "");
        System.out.println(str2);

        //按字母排序
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        TestMainBehaviour testMainBehaviour = new TestMainBehaviour();
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();

        testMainBehaviour.builderBaseInfo(multiValueMap);


        multiValueMap.set("union_id", "oBB9ps1lkC4v6KwIFfXbHuIkPQX8");

        JSONObject subJson = new JSONObject();
        subJson.put("uname", "SuperMan");
        //multiValueMap.set("content",subJson.toJSONString().replace("\\", "")); //行为内容，自定义行为属性，JSON字符串


        multiValueMap.forEach((k, v) -> {
            if (v == null || StringUtils.isEmpty(v.toString())) {
                multiValueMap.remove(k);
            }
        });


        multiValueMap.set("timestamp", String.valueOf(System.currentTimeMillis() / 1000));


        //multiValueMap.set("sign", SignUtil.sign(multiValueMap.toSingleValueMap(), "c62ffacc-f368-4d27-9a2e-7c8f1446f4bf"));
        multiValueMap.set("sign", SignUtil.sign(multiValueMap.toSingleValueMap(), "207472ab-45a4-4e8b-9f83-49c15dcfb48e"));

        System.out.println(JsonUtils.toJson(multiValueMap.toSingleValueMap()));


        Map<String, Object> json = JsonUtils.fromJson(str.replace("//", ""), Map.class);

        System.out.println(json);
    }


    private void builderBaseInfo(MultiValueMap<String, String> multiValueMap) {

        //multiValueMap.set("when", "2020-05-18 15:32:29");
        multiValueMap.set("action", "Add_WeChat");
        multiValueMap.set("content", str.replace("//", ""));
        multiValueMap.set("description", "外部联系人扫码添加内部人员企业微信");
        multiValueMap.set("name", "外部联系人扫码添加内部人员企业微信");
    }


}
