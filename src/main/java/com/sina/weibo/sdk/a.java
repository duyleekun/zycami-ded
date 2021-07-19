/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import com.sina.weibo.sdk.auth.AuthInfo;

public final class a {
    private static boolean a = false;
    private static AuthInfo b;

    public static AuthInfo a() {
        boolean bl2 = a;
        if (bl2) {
            return b;
        }
        RuntimeException runtimeException = new RuntimeException("please init sdk before use it. Wb.install()");
        throw runtimeException;
    }

    public static void a(Context object, AuthInfo object2) {
        boolean bl2 = a;
        if (!bl2) {
            if (object2 != null) {
                boolean bl3;
                b = object2;
                object2 = ((AuthInfo)object2).getAppKey();
                com.sina.weibo.sdk.a.a a10 = com.sina.weibo.sdk.a.a.b();
                a10.b((Context)object, (String)object2);
                a = bl3 = true;
            } else {
                object = new RuntimeException("authInfo must not be null.");
                throw object;
            }
        }
    }

    public static boolean a(Context object) {
        boolean bl2;
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        return object != null && (object = object.getPackageManager().queryIntentServices(intent, 0)) != null && !(bl2 = object.isEmpty());
    }

    public static boolean b(Context object) {
        int n10;
        int n11 = com.sina.weibo.sdk.a.a(object);
        return n11 != 0 && (object = com.sina.weibo.sdk.c.a.c(object)) != null && (n10 = object.am) >= (n11 = 10772);
    }
}

