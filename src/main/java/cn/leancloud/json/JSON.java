/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.json;

import cn.leancloud.core.AppConfiguration;
import cn.leancloud.json.JSONArray;
import cn.leancloud.json.JSONObject;
import cn.leancloud.json.TypeReference;
import java.util.List;

public class JSON {
    public static Object parse(String string2) {
        return AppConfiguration.getJsonParser().parse(string2);
    }

    public static JSONArray parseArray(String string2) {
        return AppConfiguration.getJsonParser().parseArray(string2);
    }

    public static List parseArray(String string2, Class clazz) {
        return AppConfiguration.getJsonParser().parseArray(string2, clazz);
    }

    public static JSONObject parseObject(String string2) {
        return AppConfiguration.getJsonParser().parseObject(string2);
    }

    public static Object parseObject(String string2, TypeReference typeReference) {
        return AppConfiguration.getJsonParser().parseObject(string2, typeReference);
    }

    public static Object parseObject(String string2, Class clazz) {
        return AppConfiguration.getJsonParser().parseObject(string2, clazz);
    }

    public static String toJSONString(Object object) {
        return AppConfiguration.getJsonParser().toJSONString(object);
    }

    public static Object toJavaObject(JSONObject jSONObject, Class clazz) {
        return AppConfiguration.getJsonParser().toJavaObject(jSONObject, clazz);
    }
}

