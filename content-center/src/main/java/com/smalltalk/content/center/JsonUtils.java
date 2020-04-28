package com.smalltalk.content.center;

public class JsonUtils {
    private static final JsonMapper jsonMapper = new JsonMapper();


    public static String toJson(Object obj) {

        return jsonMapper.toJson(obj);
    }
}
