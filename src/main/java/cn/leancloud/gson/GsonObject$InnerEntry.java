/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.gson;

import cn.leancloud.gson.GsonWrapper;
import com.google.gson.JsonElement;
import java.util.Map;

public class GsonObject$InnerEntry
implements Map.Entry {
    private String key;
    private Object value;

    public GsonObject$InnerEntry(String object, JsonElement jsonElement) {
        this.key = object;
        this.value = object = GsonWrapper.toJavaObject(jsonElement);
    }

    public String getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public Object setValue(Object object) {
        this.value = object;
        return object;
    }
}

