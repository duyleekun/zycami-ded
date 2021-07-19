/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.sina.weibo.sdk.net;

import android.content.Context;
import android.text.TextUtils;

public class HttpManager {
    static {
        System.loadLibrary("weibosdkcore");
    }

    public static String a(Context context, String string2, String string3, String string4, String string5) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3) {
            stringBuilder.append(string2);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            stringBuilder.append(string3);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)string4))) {
            stringBuilder.append(string4);
        }
        string2 = stringBuilder.toString();
        return HttpManager.calcOauthSignNative(context, string2, string5);
    }

    private static native String calcOauthSignNative(Context var0, String var1, String var2);
}

