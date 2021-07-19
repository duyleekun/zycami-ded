/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.json;

import cn.leancloud.json.JSONArray;
import cn.leancloud.json.JSONObject;
import cn.leancloud.json.TypeReference;
import java.util.List;
import java.util.Map;

public interface JSONParser {
    public Object parse(String var1);

    public JSONArray parseArray(String var1);

    public List parseArray(String var1, Class var2);

    public JSONObject parseObject(String var1);

    public Object parseObject(String var1, TypeReference var2);

    public Object parseObject(String var1, Class var2);

    public JSONArray toJSONArray(List var1);

    public JSONObject toJSONObject(Map var1);

    public String toJSONString(Object var1);

    public Object toJavaObject(JSONObject var1, Class var2);
}

