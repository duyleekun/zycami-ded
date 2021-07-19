/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.json;

import cn.leancloud.core.AppConfiguration;
import cn.leancloud.json.JSONArray;
import java.util.List;

public class JSONArray$Builder {
    public static JSONArray create(List list) {
        return AppConfiguration.getJsonParser().toJSONArray(list);
    }
}

