/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.c1;
import f.h2.t.u;
import f.l2.g;
import f.l2.r;
import f.l2.t$a;
import f.s1;

public final class t
extends r
implements g {
    private static final t e;
    public static final t$a f;

    static {
        Object object = new t$a(null);
        f = object;
        e = object = new t(-1, 0, null);
    }

    private t(int n10, int n11) {
        super(n10, n11, 1, null);
    }

    public /* synthetic */ t(int n10, int n11, u u10) {
        this(n10, n11);
    }

    public static final /* synthetic */ t i() {
        return e;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        int n10;
        int n11;
        int n12 = object instanceof t;
        if (n12 == 0) return 0 != 0;
        n12 = this.isEmpty();
        if (n12 != 0) {
            Object object2 = object;
            object2 = (t)object;
            n12 = (int)(((t)object2).isEmpty() ? 1 : 0);
            if (n12 != 0) return 1 != 0;
        }
        if ((n12 = this.e()) != (n11 = ((r)(object = (t)object)).e())) return 0 != 0;
        n12 = this.f();
        if (n12 != (n10 = ((r)object).f())) return 0 != 0;
        return 1 != 0;
    }

    public int hashCode() {
        int n10 = this.isEmpty();
        if (n10 != 0) {
            n10 = -1;
        } else {
            n10 = this.e() * 31;
            int n11 = this.f();
            n10 += n11;
        }
        return n10;
    }

    /*
     * WARNING - void declaration
     */
    public boolean isEmpty() {
        void var1_5;
        int n10;
        int n11 = this.e();
        n11 = s1.c(n11, n10 = this.f());
        if (n11 > 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public boolean j(int n10) {
        int n11 = s1.c(this.e(), n10);
        n10 = n11 <= 0 && (n10 = s1.c(n10, n11 = this.f())) <= 0 ? 1 : 0;
        return n10 != 0;
    }

    public int k() {
        return this.f();
    }

    public int l() {
        return this.e();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = c1.V(this.e());
        stringBuilder.append(string2);
        stringBuilder.append("..");
        string2 = c1.V(this.f());
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

