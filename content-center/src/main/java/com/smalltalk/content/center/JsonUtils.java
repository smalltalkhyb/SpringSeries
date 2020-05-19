package com.smalltalk.content.center;

public class JsonUtils {
    private static final JsonMapper jsonMapper = new JsonMapper();


    public static String toJson(Object obj) {

        return jsonMapper.toJson(obj);
    }


    /**
     * 去掉反斜杠的json
     *
     * @param obj
     * @return
     */
    public static String toJsonNSlash(Object obj) {

        return jsonMapper.toJson(obj).replace("\\", "");
    }


    public  static  <T> T fromJson(String jsonString, Class<T> clazz) {
        return jsonMapper.fromJson(jsonString, clazz);
    }
}
