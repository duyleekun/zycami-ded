/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.sina.weibo.sdk.openapi;

import android.content.Context;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.a;

public class WBAPIFactory {
    public static IWBAPI createWBAPI(Context context) {
        a a10 = new a(context);
        return a10;
    }
}

