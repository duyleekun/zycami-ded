/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.updatesdk.b.b.b;

public final class a {
    private static final Object d;
    private static a e;
    private b a;
    private String b;
    private boolean c = false;

    static {
        Object object;
        d = object = new Object();
    }

    private a(Context object) {
        object = com.huawei.updatesdk.b.b.b.a("DeviceSessionUpdateSDK_V1", object);
        this.a = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a d() {
        Object object = d;
        synchronized (object) {
            a a10 = e;
            if (a10 != null) return e;
            com.huawei.updatesdk.a.b.a.a a11 = com.huawei.updatesdk.a.b.a.a.c();
            a11 = a11.a();
            e = a10 = new a((Context)a11);
            return e;
        }
    }

    public String a() {
        return this.b;
    }

    public String a(String string2) {
        b b10 = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updatesdk.lastAccountZone");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        return b10.a(string2, "");
    }

    public void a(long l10) {
        this.a.b("updatesdk.lastCheckDate", l10);
    }

    public void a(String string2, long l10) {
        b b10 = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updatesdk.lastInitAccountTime");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        b10.b(string2, l10);
    }

    public void a(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        this.a.b(string2, string3);
    }

    public long b() {
        return this.a.a("updatesdk.lastCheckDate", 0L);
    }

    public long b(String string2) {
        b b10 = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updatesdk.lastInitAccountTime");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        return b10.a(string2, 0L);
    }

    public void b(String string2, String string3) {
        b b10 = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updatesdk.lastAccountZone");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        b10.b(string2, string3);
    }

    public String c(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = "";
        if (bl2) {
            return string3;
        }
        return this.a.a(string2, string3);
    }

    public void c() {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.d("updatesdk.sign.param");
        this.d("updatesdk.signkey");
        this.d("updatesdk.signtime");
        this.c = true;
    }

    public void d(String string2) {
        this.a.a(string2);
    }

    public void e(String string2) {
        this.b = string2;
    }
}

