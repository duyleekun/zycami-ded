/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.ad;

public final class ad$b {
    public String a;
    public String b;
    public long c = 20480L;
    public long d = 604800000L;
    public byte[] e;
    public byte[] f;
    public long g = 0x3200000L;

    public ad$b a(String string2) {
        this.a = string2;
        return this;
    }

    public ad$b a(byte[] byArray) {
        this.f = byArray;
        return this;
    }

    public ad a() {
        ad ad2 = new ad(null);
        Object object = this.a;
        ad.a(ad2, (String)object);
        object = this.b;
        ad.b(ad2, (String)object);
        long l10 = this.c;
        ad.a(ad2, l10);
        l10 = this.g;
        ad.b(ad2, l10);
        l10 = this.d;
        ad.c(ad2, l10);
        object = this.e;
        ad.a(ad2, (byte[])object);
        object = this.f;
        ad.b(ad2, (byte[])object);
        return ad2;
    }

    public ad$b b(String string2) {
        this.b = string2;
        return this;
    }

    public ad$b b(byte[] byArray) {
        this.e = byArray;
        return this;
    }
}

