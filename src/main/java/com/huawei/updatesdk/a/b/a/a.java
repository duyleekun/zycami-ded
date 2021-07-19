/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.updatesdk.a.b.a;

import android.content.Context;

public class a {
    private static final Object b;
    private static a c;
    private Context a;

    static {
        Object object;
        b = object = new Object();
    }

    public a(Context context) {
        this.a = context = context.getApplicationContext();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context context) {
        Object object = b;
        synchronized (object) {
            a a10 = c;
            if (a10 == null) {
                c = a10 = new a(context);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a c() {
        Object object = b;
        synchronized (object) {
            return c;
        }
    }

    public Context a() {
        return this.a;
    }

    public String b() {
        Object object = this.a;
        if (object != null && (object = object.getFilesDir()) != null) {
            return this.a.getFilesDir().getAbsolutePath();
        }
        return "";
    }
}

