/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhiyun.cama.data.database.MapTypeConverters$1;
import java.lang.reflect.Type;
import java.util.HashMap;

public class MapTypeConverters {
    public static String fromHashMap(HashMap hashMap) {
        Gson gson = new Gson();
        return gson.toJson(hashMap);
    }

    public static HashMap fromString(String string2) {
        Gson gson = new Gson();
        Object object = new MapTypeConverters$1();
        object = ((TypeToken)object).getType();
        return (HashMap)gson.fromJson(string2, (Type)object);
    }
}

