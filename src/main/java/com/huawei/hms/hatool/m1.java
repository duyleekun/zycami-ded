/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.h1;

public class m1 {
    public static m1 b;
    public h1 a = null;

    static {
        m1 m12;
        b = m12 = new m1();
    }

    public static m1 c() {
        return b;
    }

    public void a(h1 h12) {
        this.a = h12;
    }

    public boolean a() {
        boolean bl2;
        h1 h12 = this.a;
        if (h12 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            h12 = null;
        }
        return bl2;
    }

    public h1 b() {
        return this.a;
    }
}

