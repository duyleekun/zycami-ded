/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.h2.t.u;
import g.d$a;
import g.d$b;
import g.s;
import java.util.concurrent.TimeUnit;

public final class d {
    public static final d n;
    public static final d o;
    public static final d$b p;
    private final boolean a;
    private final boolean b;
    private final int c;
    private final int d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final int h;
    private final int i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private String m;

    static {
        Object object = new d$b(null);
        p = object;
        object = new d$a();
        n = ((d$a)object).g().a();
        object = new d$a();
        object = ((d$a)object).j();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        o = ((d$a)object).e(-1 >>> 1, timeUnit).a();
    }

    private d(boolean bl2, boolean bl3, int n10, int n11, boolean bl4, boolean bl5, boolean bl6, int n12, int n13, boolean bl7, boolean bl8, boolean bl9, String string2) {
        this.a = bl2;
        this.b = bl3;
        this.c = n10;
        this.d = n11;
        this.e = bl4;
        this.f = bl5;
        this.g = bl6;
        this.h = n12;
        this.i = n13;
        this.j = bl7;
        this.k = bl8;
        this.l = bl9;
        this.m = string2;
    }

    public /* synthetic */ d(boolean bl2, boolean bl3, int n10, int n11, boolean bl4, boolean bl5, boolean bl6, int n12, int n13, boolean bl7, boolean bl8, boolean bl9, String string2, u u10) {
        this(bl2, bl3, n10, n11, bl4, bl5, bl6, n12, n13, bl7, bl8, bl9, string2);
    }

    public static final d v(s s10) {
        return p.c(s10);
    }

    public final boolean a() {
        return this.l;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.h;
    }

    public final int d() {
        return this.i;
    }

    public final boolean e() {
        return this.g;
    }

    public final boolean f() {
        return this.a;
    }

    public final boolean g() {
        return this.b;
    }

    public final boolean h() {
        return this.k;
    }

    public final boolean i() {
        return this.j;
    }

    public final int j() {
        return this.d;
    }

    public final boolean k() {
        return this.l;
    }

    public final boolean l() {
        return this.e;
    }

    public final boolean m() {
        return this.f;
    }

    public final int n() {
        return this.c;
    }

    public final int o() {
        return this.h;
    }

    public final int p() {
        return this.i;
    }

    public final boolean q() {
        return this.g;
    }

    public final boolean r() {
        return this.a;
    }

    public final boolean s() {
        return this.b;
    }

    public final boolean t() {
        return this.k;
    }

    public String toString() {
        CharSequence charSequence = this.m;
        if (charSequence == null) {
            String string2;
            charSequence = new StringBuilder();
            int n10 = this.a;
            if (n10 != 0) {
                string2 = "no-cache, ";
                ((StringBuilder)charSequence).append(string2);
            }
            if ((n10 = this.b) != 0) {
                string2 = "no-store, ";
                ((StringBuilder)charSequence).append(string2);
            }
            n10 = this.c;
            String string3 = ", ";
            int n11 = -1;
            if (n10 != n11) {
                string2 = "max-age=";
                ((StringBuilder)charSequence).append(string2);
                n10 = this.c;
                ((StringBuilder)charSequence).append(n10);
                ((StringBuilder)charSequence).append(string3);
            }
            if ((n10 = this.d) != n11) {
                string2 = "s-maxage=";
                ((StringBuilder)charSequence).append(string2);
                n10 = this.d;
                ((StringBuilder)charSequence).append(n10);
                ((StringBuilder)charSequence).append(string3);
            }
            if ((n10 = (int)(this.e ? 1 : 0)) != 0) {
                string2 = "private, ";
                ((StringBuilder)charSequence).append(string2);
            }
            if ((n10 = (int)(this.f ? 1 : 0)) != 0) {
                string2 = "public, ";
                ((StringBuilder)charSequence).append(string2);
            }
            if ((n10 = (int)(this.g ? 1 : 0)) != 0) {
                string2 = "must-revalidate, ";
                ((StringBuilder)charSequence).append(string2);
            }
            if ((n10 = this.h) != n11) {
                string2 = "max-stale=";
                ((StringBuilder)charSequence).append(string2);
                n10 = this.h;
                ((StringBuilder)charSequence).append(n10);
                ((StringBuilder)charSequence).append(string3);
            }
            if ((n10 = this.i) != n11) {
                string2 = "min-fresh=";
                ((StringBuilder)charSequence).append(string2);
                n10 = this.i;
                ((StringBuilder)charSequence).append(n10);
                ((StringBuilder)charSequence).append(string3);
            }
            if ((n10 = (int)(this.j ? 1 : 0)) != 0) {
                string2 = "only-if-cached, ";
                ((StringBuilder)charSequence).append(string2);
            }
            if ((n10 = (int)(this.k ? 1 : 0)) != 0) {
                string2 = "no-transform, ";
                ((StringBuilder)charSequence).append(string2);
            }
            if ((n10 = (int)(this.l ? 1 : 0)) != 0) {
                string2 = "immutable, ";
                ((StringBuilder)charSequence).append(string2);
            }
            if ((n10 = charSequence.length()) == 0) {
                n10 = 1;
            } else {
                n10 = 0;
                string2 = null;
            }
            if (n10 != 0) {
                return "";
            }
            n10 = ((StringBuilder)charSequence).length() + -2;
            int n12 = ((StringBuilder)charSequence).length();
            ((StringBuilder)charSequence).delete(n10, n12);
            charSequence = ((StringBuilder)charSequence).toString();
            string2 = "StringBuilder().apply(builderAction).toString()";
            f0.o(charSequence, string2);
            this.m = charSequence;
        }
        return charSequence;
    }

    public final boolean u() {
        return this.j;
    }

    public final int w() {
        return this.d;
    }
}

