/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import d.v.y.d.i;

public class Adapters {
    public static /* synthetic */ JsonArray access$000(JsonElement jsonElement) {
        return Adapters.checkArray(jsonElement);
    }

    public static /* synthetic */ i access$100(JsonElement jsonElement) {
        return Adapters.crateRange(jsonElement);
    }

    private static JsonArray checkArray(JsonElement jsonElement) {
        int n10 = jsonElement.isJsonArray();
        if (n10 == 0) {
            return null;
        }
        n10 = ((JsonArray)(jsonElement = jsonElement.getAsJsonArray())).size();
        if (n10 == 0) {
            return null;
        }
        return jsonElement;
    }

    private static i crateRange(JsonElement object) {
        int n10;
        int n11;
        if ((object = Adapters.checkArray((JsonElement)object)) != null && (n11 = ((JsonArray)object).size()) >= (n10 = 2)) {
            n11 = ((JsonArray)object).get(0).getAsInt();
            int n12 = ((JsonArray)object).get(1).getAsInt();
            Integer n13 = n11;
            object = n12;
            return i.d(n13, (Comparable)object);
        }
        return null;
    }
}

