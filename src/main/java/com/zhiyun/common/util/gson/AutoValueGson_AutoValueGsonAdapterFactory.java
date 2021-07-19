/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.common.util.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.zhiyun.common.util.gson.AutoValueGsonAdapterFactory;
import d.v.e.l.q2.b;

public final class AutoValueGson_AutoValueGsonAdapterFactory
extends AutoValueGsonAdapterFactory {
    public TypeAdapter create(Gson gson, TypeToken object) {
        Class<b> clazz = b.class;
        boolean bl2 = clazz.isAssignableFrom((Class<?>)(object = ((TypeToken)object).getRawType()));
        if (bl2) {
            return b.a(gson);
        }
        return null;
    }
}

