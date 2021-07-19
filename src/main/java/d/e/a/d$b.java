/*
 * Decompiled with CFR 0.151.
 */
package d.e.a;

import d.e.a.d;

public final class d$b {
    public String a;
    public String b;
    public long c = 0xA00000L;
    public long d = 604800000L;
    public byte[] e;
    public byte[] f;
    public long g = 0x3200000L;

    public d a() {
        d d10 = new d(null);
        Object object = this.a;
        d.e.a.d.a(d10, (String)object);
        object = this.b;
        d.e.a.d.b(d10, (String)object);
        long l10 = this.c;
        d.e.a.d.c(d10, l10);
        l10 = this.g;
        d.e.a.d.d(d10, l10);
        l10 = this.d;
        d.e.a.d.e(d10, l10);
        object = this.e;
        d.e.a.d.f(d10, (byte[])object);
        object = this.f;
        d.e.a.d.g(d10, (byte[])object);
        return d10;
    }

    public d$b b(String string2) {
        this.a = string2;
        return this;
    }

    public d$b c(long l10) {
        this.d = l10 *= 86400000L;
        return this;
    }

    public d$b d(byte[] byArray) {
        this.f = byArray;
        return this;
    }

    public d$b e(byte[] byArray) {
        this.e = byArray;
        return this;
    }

    public d$b f(long l10) {
        this.c = l10 *= 0x100000L;
        return this;
    }

    public d$b g(long l10) {
        this.g = l10;
        return this;
    }

    public d$b h(String string2) {
        this.b = string2;
        return this;
    }
}

