/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.service.otaupdate;

import android.text.TextUtils;

public class f {
    private static f e;
    private String a;
    private String b;
    private String c = "com.huawei.appmarket";
    private String d;

    static {
        f f10;
        e = f10 = new f();
    }

    private f() {
    }

    public static f f() {
        return e;
    }

    public String a() {
        String string2 = this.a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            return this.a;
        }
        return this.b;
    }

    public void a(String string2) {
        this.b = string2;
    }

    public String b() {
        return this.a;
    }

    public void b(String string2) {
        this.a = string2;
    }

    public String c() {
        return this.c;
    }

    public void c(String string2) {
        this.d = string2;
    }

    public void d(String string2) {
        this.c = string2;
    }

    public boolean d() {
        String string2 = this.a;
        if (string2 != null) {
            String string3 = this.b;
            return string2.equals(string3);
        }
        return true;
    }

    public boolean e() {
        return TextUtils.equals((CharSequence)this.d, (CharSequence)"AppTouch");
    }
}

