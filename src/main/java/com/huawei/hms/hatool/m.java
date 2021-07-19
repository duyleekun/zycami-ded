/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.k;
import com.huawei.hms.hatool.y;

public class m {
    public k a;
    public k b;
    public k c;
    public k d;

    public m(String string2) {
    }

    public k a() {
        return this.c;
    }

    public k a(String string2) {
        CharSequence charSequence = "oper";
        boolean bl2 = string2.equals(charSequence);
        if (bl2) {
            return this.c();
        }
        charSequence = "maint";
        bl2 = string2.equals(charSequence);
        if (bl2) {
            return this.b();
        }
        charSequence = "diffprivacy";
        bl2 = string2.equals(charSequence);
        if (bl2) {
            return this.a();
        }
        charSequence = "preins";
        bl2 = string2.equals(charSequence);
        if (bl2) {
            return this.d();
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("HiAnalyticsInstData.getConfig(type): wrong type: ");
        ((StringBuilder)charSequence).append(string2);
        string2 = ((StringBuilder)charSequence).toString();
        y.f("hmsSdk", string2);
        return null;
    }

    public void a(k k10) {
        this.a = k10;
    }

    public k b() {
        return this.a;
    }

    public void b(k k10) {
        this.b = k10;
    }

    public k c() {
        return this.b;
    }

    public k d() {
        return this.d;
    }
}

