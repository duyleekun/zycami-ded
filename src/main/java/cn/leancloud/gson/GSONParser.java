/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.gson;

import cn.leancloud.gson.GsonArray;
import cn.leancloud.gson.GsonObject;
import cn.leancloud.gson.GsonWrapper;
import cn.leancloud.json.JSONArray;
import cn.leancloud.json.JSONObject;
import cn.leancloud.json.JSONParser;
import cn.leancloud.json.TypeReference;
import com.google.gson.JsonArray;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GSONParser
implements JSONParser {
    public Object parse(String string2) {
        return GsonWrapper.parseObject(string2);
    }

    public JSONArray parseArray(String object) {
        object = (JsonArray)GsonWrapper.parseObject((String)object, JsonArray.class);
        GsonArray gsonArray = new GsonArray((JsonArray)object);
        return gsonArray;
    }

    public List parseArray(String object, Class clazz) {
        int n10;
        object = (JsonArray)GsonWrapper.parseObject((String)object, JsonArray.class);
        int n11 = ((JsonArray)object).size();
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        for (n11 = 0; n11 < (n10 = ((JsonArray)object).size()); ++n11) {
            Object object2 = GsonWrapper.toJavaObject(((JsonArray)object).get(n11), clazz);
            arrayList.add(object2);
        }
        return arrayList;
    }

    public JSONObject parseObject(String object) {
        object = (Map)GsonWrapper.parseObject((String)object, Map.class);
        GsonObject gsonObject = new GsonObject((Map)object);
        return gsonObject;
    }

    public Object parseObject(String string2, TypeReference object) {
        object = ((TypeReference)object).getType();
        return GsonWrapper.parseObject(string2, (Type)object);
    }

    public Object parseObject(String string2, Class clazz) {
        return GsonWrapper.parseObject(string2, clazz);
    }

    public JSONArray toJSONArray(List list) {
        if (list == null) {
            list = new GsonArray();
            return list;
        }
        GsonArray gsonArray = new GsonArray(list);
        return gsonArray;
    }

    public JSONObject toJSONObject(Map map) {
        if (map == null) {
            map = new GsonObject();
            return map;
        }
        GsonObject gsonObject = new GsonObject(map);
        return gsonObject;
    }

    public String toJSONString(Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        return GsonWrapper.getGsonInstance().toJson(object);
    }

    public Object toJavaObject(JSONObject jSONObject, Class clazz) {
        return GsonWrapper.toJavaObject(((GsonObject)jSONObject).getRawObject(), clazz);
    }
}

