/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package com.huawei.hms.hatool;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.hatool.b;
import com.huawei.hms.hatool.c0;
import com.huawei.hms.hatool.d;
import com.huawei.hms.hatool.g0;
import com.huawei.hms.hatool.y;

public class d0 {
    public static d0 c;
    public String a;
    public String b;

    public static d0 f() {
        d0 d02 = c;
        if (d02 == null) {
            d0.g();
        }
        return c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void g() {
        Class<d0> clazz = d0.class;
        synchronized (clazz) {
            d0 d02 = c;
            if (d02 == null) {
                c = d02 = new d0();
            }
            return;
        }
    }

    public String a() {
        String string2 = this.a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            this.a = string2 = this.c();
        }
        return this.a;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final String a(String string2) {
        boolean bl2 = this.e();
        String string3 = bl2 ? d.j.f.a.a.h.d.a.b.a("analytics_keystore", string2) : "";
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl3) return string3;
        String string4 = "deCrypt work key first";
        y.c("hmsSdk", string4);
        string3 = this.d();
        string3 = d.a(string2, string3);
        boolean bl4 = TextUtils.isEmpty((CharSequence)string3);
        if (bl4) {
            string3 = d.j.f.a.a.h.f.b.f(16);
            string2 = this.b(string3);
            this.c(string2);
            bl4 = this.e();
            if (!bl4) return string3;
        } else {
            bl4 = this.e();
            if (!bl4) return string3;
            string2 = this.b(string3);
            this.c(string2);
        }
        c0.d();
        return string3;
    }

    public final String b(String string2) {
        boolean bl2 = this.e();
        if (bl2) {
            return d.j.f.a.a.h.d.a.b.d("analytics_keystore", string2);
        }
        String string3 = this.d();
        return d.b(string2, string3);
    }

    public void b() {
        int n10 = 16;
        String string2 = d.j.f.a.a.h.f.b.f(n10);
        String string3 = this.b(string2);
        boolean bl2 = this.c(string3);
        if (bl2) {
            this.a = string2;
        }
    }

    public final String c() {
        Object object = com.huawei.hms.hatool.b.f();
        String string2 = "Privacy_MY";
        String string3 = "PrivacyData";
        String string4 = "";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = g0.a(object, string2, string3, string4)));
        if (bl2) {
            object = d.j.f.a.a.h.f.b.f(16);
            string2 = this.b((String)object);
            this.c(string2);
            return object;
        }
        return this.a((String)object);
    }

    public final boolean c(String string2) {
        String string3 = "hmsSdk";
        String string4 = "refresh sp aes key";
        y.c(string3, string4);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            y.c(string3, "refreshLocalKey(): encrypted key is empty");
            return false;
        }
        string3 = com.huawei.hms.hatool.b.f();
        string4 = "Privacy_MY";
        g0.b((Context)string3, string4, "PrivacyData", string2);
        string2 = com.huawei.hms.hatool.b.f();
        long l10 = System.currentTimeMillis();
        g0.b((Context)string2, string4, "flashKeyTime", l10);
        return true;
    }

    public final String d() {
        Object object = this.b;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = new c0();
            this.b = object = ((c0)object).a();
        }
        return this.b;
    }

    public final boolean e() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }
}

