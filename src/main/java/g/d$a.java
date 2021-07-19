/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.d;
import java.util.concurrent.TimeUnit;

public final class d$a {
    private boolean a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;

    public d$a() {
        int n10;
        this.c = n10 = -1;
        this.d = n10;
        this.e = n10;
    }

    private final int b(long l10) {
        int n10 = -1 >>> 1;
        long l11 = n10;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            n10 = (int)l10;
        }
        return n10;
    }

    public final d a() {
        boolean bl2 = this.a;
        boolean bl3 = this.b;
        int n10 = this.c;
        int n11 = this.d;
        int n12 = this.e;
        boolean bl4 = this.f;
        boolean bl5 = this.g;
        boolean bl6 = this.h;
        d d10 = new d(bl2, bl3, n10, -1, false, false, false, n11, n12, bl4, bl5, bl6, null, null);
        return d10;
    }

    public final d$a c() {
        this.h = true;
        return this;
    }

    public final d$a d(int n10, TimeUnit object) {
        boolean bl2;
        String string2 = "timeUnit";
        f0.p(object, string2);
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        if (bl2) {
            long l10 = n10;
            long l11 = ((TimeUnit)((Object)object)).toSeconds(l10);
            this.c = n10 = this.b(l11);
            return this;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("maxAge < 0: ");
        ((StringBuilder)object).append(n10);
        String string3 = ((StringBuilder)object).toString();
        string3 = string3.toString();
        object = new IllegalArgumentException(string3);
        throw object;
    }

    public final d$a e(int n10, TimeUnit object) {
        boolean bl2;
        String string2 = "timeUnit";
        f0.p(object, string2);
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        if (bl2) {
            long l10 = n10;
            long l11 = ((TimeUnit)((Object)object)).toSeconds(l10);
            this.d = n10 = this.b(l11);
            return this;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("maxStale < 0: ");
        ((StringBuilder)object).append(n10);
        String string3 = ((StringBuilder)object).toString();
        string3 = string3.toString();
        object = new IllegalArgumentException(string3);
        throw object;
    }

    public final d$a f(int n10, TimeUnit object) {
        boolean bl2;
        String string2 = "timeUnit";
        f0.p(object, string2);
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        if (bl2) {
            long l10 = n10;
            long l11 = ((TimeUnit)((Object)object)).toSeconds(l10);
            this.e = n10 = this.b(l11);
            return this;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("minFresh < 0: ");
        ((StringBuilder)object).append(n10);
        String string3 = ((StringBuilder)object).toString();
        string3 = string3.toString();
        object = new IllegalArgumentException(string3);
        throw object;
    }

    public final d$a g() {
        this.a = true;
        return this;
    }

    public final d$a h() {
        this.b = true;
        return this;
    }

    public final d$a i() {
        this.g = true;
        return this;
    }

    public final d$a j() {
        this.f = true;
        return this;
    }
}

