/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 */
package com.alibaba.sdk.android.oss.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class OSSSharedPreferences {
    private static OSSSharedPreferences sInstance;
    private SharedPreferences mSp;

    private OSSSharedPreferences(Context context) {
        context = context.getSharedPreferences("oss_android_sdk_sp", 0);
        this.mSp = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static OSSSharedPreferences instance(Context context) {
        Object object = sInstance;
        if (object != null) return sInstance;
        object = OSSSharedPreferences.class;
        synchronized (object) {
            OSSSharedPreferences oSSSharedPreferences = sInstance;
            if (oSSSharedPreferences != null) return sInstance;
            sInstance = oSSSharedPreferences = new OSSSharedPreferences(context);
            return sInstance;
        }
    }

    public boolean contains(String string2) {
        return this.mSp.contains(string2);
    }

    public String getStringValue(String string2) {
        return this.mSp.getString(string2, "");
    }

    public void removeKey(String string2) {
        SharedPreferences.Editor editor = this.mSp.edit();
        editor.remove(string2);
        editor.commit();
    }

    public void setStringValue(String string2, String string3) {
        SharedPreferences.Editor editor = this.mSp.edit();
        editor.putString(string2, string3);
        editor.commit();
    }
}

