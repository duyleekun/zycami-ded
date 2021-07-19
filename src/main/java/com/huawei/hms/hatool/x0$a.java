/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.a;
import com.huawei.hms.hatool.y0;
import d.j.f.a.a.h.c.d;

public class x0$a
extends y0 {
    public String a;
    public String b;

    public x0$a(String string2, String string3) {
        this.a = string2;
        this.b = string3;
    }

    public String a() {
        String string2 = this.a;
        String string3 = this.b;
        return com.huawei.hms.hatool.a.d(string2, string3);
    }

    public String a(String string2) {
        return d.b(string2);
    }

    public String b() {
        String string2 = this.a;
        String string3 = this.b;
        return com.huawei.hms.hatool.a.g(string2, string3);
    }

    public String c() {
        String string2 = this.a;
        String string3 = this.b;
        return com.huawei.hms.hatool.a.j(string2, string3);
    }

    public int d() {
        String string2 = this.a;
        String string3 = this.b;
        int n10 = com.huawei.hms.hatool.a.k(string2, string3);
        int n11 = 0;
        string3 = null;
        if (n10 != 0) {
            n10 = 4;
        } else {
            n10 = 0;
            string2 = null;
        }
        n10 |= 0;
        String string4 = this.a;
        String string5 = this.b;
        boolean bl2 = com.huawei.hms.hatool.a.e(string4, string5);
        if (bl2) {
            n11 = 2;
        }
        n10 |= n11;
        string3 = this.a;
        string4 = this.b;
        n11 = (int)(com.huawei.hms.hatool.a.h(string3, string4) ? 1 : 0);
        return n10 | n11;
    }
}

