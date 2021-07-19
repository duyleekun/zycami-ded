/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.b.c;

import android.os.Build;
import android.text.TextUtils;
import java.util.List;

public abstract class c {
    private String a;
    private String b;

    public abstract String a();

    public abstract int b();

    public abstract String c();

    public abstract String d();

    public String e() {
        String string2 = this.b;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            return this.b;
        }
        this.b = string2 = this.c();
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            this.b = string2 = Build.MANUFACTURER;
        }
        return this.b;
    }

    public String f() {
        String string2 = this.a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            return this.a;
        }
        this.a = string2 = this.d();
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            this.a = string2 = Build.MODEL;
        }
        return this.a;
    }

    public abstract List g();
}

