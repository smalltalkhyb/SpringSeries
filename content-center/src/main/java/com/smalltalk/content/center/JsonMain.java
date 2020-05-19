package com.smalltalk.content.center;

import java.util.Map;

/**
 * @author: ybhu
 * @create: 2020/05/18 20:24
 */
public class JsonMain {


    private static String str="{\"u_name\":\"小可爱\uD83D\uDE3D\",\"u_avatar\":\"http://wx.qlogo.cn/mmhead/Q3auHgzwzM4e9tXQBrNLmicicYEkRWl7hAbsygmEeB8ab6Qw3cRLg0jw/0\",\"u_type\":1,\"u_gender\":2,\"u_unionid\":\"oBB9psxjIoIQCAcqf7eCAgVDOEmw\",\"u_position\":null,\"u_corp_name\":null,\"u_corp_full_name\":null,\"u_external_profile\":null,\"u_follow_user\":[{\"userId\":\"DaYueBanYueQian\",\"remark\":\"\",\"description\":\"\",\"createTime\":1589787881,\"state\":null,\"remarkCompany\":null,\"remarkMobiles\":[],\"tags\":[]},{\"userId\":\"ShaoYuFeng\",\"remark\":\"\",\"description\":\"\",\"createTime\":1589795262,\"state\":null,\"remarkCompany\":null,\"remarkMobiles\":[],\"tags\":[]}],\"s_userid\":\"ShaoYuFeng\",\"s_name\":\"邵宇峰\",\"s_mobile\":\"17701085282\",\"s_department\":[1],\"s_order\":[0],\"s_position\":\"\",\"s_gender\":\"MALE\",\"s_email\":\"\",\"s_is_leader_in_dept\":[0],\"s_avatar\":\"https://wework.qpic.cn/bizmail/7938JJKPYvwRm26xqCltuJEiagjOsMuJWs2YFQwSlo27EKEIsvgUVtg/0\",\"s_thumb_avatar\":\"https://wework.qpic.cn/bizmail/7938JJKPYvwRm26xqCltuJEiagjOsMuJWs2YFQwSlo27EKEIsvgUVtg/100\",\"s_telephone\":\"\",\"s_alias\":\"\",\"s_extattr\":[],\"s_status\":1,\"s_qr_code\":\"https://open.work.weixin.qq.com/wwopen/userQRCode?vcode=vc9dbd7723bcf06077\",\"s_external_profile\":[],\"s_external_position\":\"\",\"s_address\":\"https://wework.qpic.cn/bizmail/7938JJKPYvwRm26xqCltuJEiagjOsMuJWs2YFQwSlo27EKEIsvgUVtg/0\",\"s_open_userid\":\"ShaoYuFeng\",\"s_main_department\":[1]}";



    public static void main(String[] args) {
        Map<String, Object> json = JsonUtils.fromJson(str, Map.class);

        System.out.println(json);
    }
}
