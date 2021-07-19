/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.sina.weibo.sdk.a;

import android.content.Context;
import com.sina.weibo.sdk.a.a$1;
import com.sina.weibo.sdk.a.a$2;
import com.sina.weibo.sdk.a.a$a;
import com.weibo.ssosdk.WeiboSsoSdk;
import d.s.a.d;
import d.s.a.e;

public final class a {
    public String c = "";

    public static void a(Context context, String string2) {
        e e10 = new e();
        context = context.getApplicationContext();
        e10.m(context);
        e10.l(string2);
        e10.n("1478195010");
        e10.s("1000_0001");
        WeiboSsoSdk.o(e10);
    }

    public static a b() {
        Class<a> clazz = a.class;
        synchronized (clazz) {
            a a10 = a$a.c();
            return a10;
        }
    }

    public final void b(Context object, String object2) {
        synchronized (this) {
            a.a((Context)object, (String)object2);
            try {
                object = WeiboSsoSdk.n();
                object2 = new a$1(this);
                ((WeiboSsoSdk)object).v((d)object2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return;
            }
            return;
        }
    }

    public final String c(Context object, String object2) {
        a.a((Context)object, (String)object2);
        object = WeiboSsoSdk.n();
        object2 = new a$2(this);
        try {
            ((WeiboSsoSdk)object).v((d)object2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return this.c;
    }
}

