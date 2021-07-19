/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.h2.t.f0;
import f.l2.a;
import f.l2.c$a;
import f.l2.g;

public final class c
extends a
implements g {
    private static final c e;
    public static final c$a f;

    static {
        Object object = new c$a(null);
        f = object;
        char c10 = (char)1;
        char c11 = (char)0;
        e = object = new c(c10, c11);
    }

    public c(char c10, char c11) {
        super(c10, c11, 1);
    }

    public static final /* synthetic */ c i() {
        return e;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        char c10;
        char c11;
        char c12 = object instanceof c;
        if (c12 == '\u0000') return '\u0000' != 0;
        c12 = this.isEmpty();
        if (c12 != '\u0000') {
            Object object2 = object;
            object2 = (c)object;
            c12 = (char)(((c)object2).isEmpty() ? 1 : 0);
            if (c12 != '\u0000') return '\u0001' != 0;
        }
        if ((c12 = this.e()) != (c11 = ((a)(object = (c)object)).e())) return '\u0000' != 0;
        c12 = this.f();
        if (c12 != (c10 = ((a)object).f())) return '\u0000' != 0;
        return '\u0001' != 0;
    }

    public int hashCode() {
        int n10 = this.isEmpty();
        if (n10 != 0) {
            n10 = -1;
        } else {
            n10 = this.e() * 31;
            char c10 = this.f();
            n10 += c10;
        }
        return n10;
    }

    public boolean isEmpty() {
        boolean bl2 = this.e();
        char c10 = this.f();
        bl2 = (bl2 = f0.t((int)(bl2 ? 1 : 0), c10)) > false;
        return bl2;
    }

    public boolean j(char c10) {
        int n10 = f0.t(this.e(), c10);
        c10 = n10 <= 0 && (c10 = (char)f0.t(c10, n10 = (int)this.f())) <= '\u0000' ? (char)'\u0001' : '\u0000';
        return c10 != 0;
    }

    public Character k() {
        return Character.valueOf(this.f());
    }

    public Character l() {
        return Character.valueOf(this.e());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        char c10 = this.e();
        stringBuilder.append(c10);
        stringBuilder.append("..");
        c10 = this.f();
        stringBuilder.append(c10);
        return stringBuilder.toString();
    }
}

