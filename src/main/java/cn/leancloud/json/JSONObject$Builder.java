/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.json;

import cn.leancloud.core.AppConfiguration;
import cn.leancloud.json.JSONObject;
import java.util.Map;

public class JSONObject$Builder {
    public static JSONObject create(Map map) {
        return AppConfiguration.getJsonParser().toJSONObject(map);
    }
}

