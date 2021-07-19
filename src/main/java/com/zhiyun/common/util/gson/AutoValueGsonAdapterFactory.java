/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.common.util.gson;

import com.google.gson.TypeAdapterFactory;
import com.zhiyun.common.util.gson.AutoValueGson_AutoValueGsonAdapterFactory;

public abstract class AutoValueGsonAdapterFactory
implements TypeAdapterFactory {
    public static TypeAdapterFactory a() {
        AutoValueGson_AutoValueGsonAdapterFactory autoValueGson_AutoValueGsonAdapterFactory = new AutoValueGson_AutoValueGsonAdapterFactory();
        return autoValueGson_AutoValueGsonAdapterFactory;
    }
}

