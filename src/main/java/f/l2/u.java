/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.d2.p;
import f.g1;
import f.h2.t.x0.a;
import f.l2.u$a;
import f.l2.v;
import f.s1;
import f.x1.m1;

public class u
implements Iterable,
a {
    public static final u$a d;
    private final long a;
    private final long b;
    private final long c;

    static {
        u$a u$a;
        d = u$a = new u$a(null);
    }

    private u(long l10, long l11, long l12) {
        long l13 = 0L;
        Object object = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (object != false) {
            l13 = Long.MIN_VALUE;
            long l14 = l12 - l13;
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object != false) {
                this.a = l10;
                this.b = l10 = p.c(l10, l11, l12);
                this.c = l12;
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step must be non-zero.");
        throw illegalArgumentException;
    }

    public /* synthetic */ u(long l10, long l11, long l12, f.h2.t.u u10) {
        this(l10, l11, l12);
    }

    public final long e() {
        return this.a;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        boolean bl2 = object instanceof u;
        if (!bl2) return false;
        boolean bl3 = this.isEmpty();
        if (bl3) {
            Object object2 = object;
            object2 = (u)object;
            boolean bl4 = ((u)object2).isEmpty();
            if (bl4) return true;
        }
        long l10 = this.a;
        object = (u)object;
        long l11 = ((u)object).a;
        long l12 = l10 - l11;
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 != false) return false;
        l10 = this.b;
        l11 = ((u)object).b;
        long l13 = l10 - l11;
        Object object4 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object4 != false) return false;
        l10 = this.c;
        l11 = ((u)object).c;
        long l14 = l10 - l11;
        Object object5 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object5) return false;
        return true;
    }

    public final long f() {
        return this.b;
    }

    public final long g() {
        return this.c;
    }

    public m1 h() {
        long l10 = this.a;
        long l11 = this.b;
        long l12 = this.c;
        v v10 = new v(l10, l11, l12, null);
        return v10;
    }

    public int hashCode() {
        int n10 = this.isEmpty();
        if (n10 != 0) {
            n10 = -1;
        } else {
            long l10 = this.a;
            int n11 = 32;
            long l11 = g1.h(l10 >>> n11);
            l10 = g1.h(l10 ^ l11);
            n10 = (int)l10 * 31;
            l11 = this.b;
            long l12 = g1.h(l11 >>> n11);
            int n12 = (int)g1.h(l11 ^ l12);
            n10 = (n10 + n12) * 31;
            l11 = this.c;
            long l13 = l11 >>> n11 ^ l11;
            n12 = (int)l13;
            n10 += n12;
        }
        return n10;
    }

    public boolean isEmpty() {
        long l10 = this.c;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        boolean bl2 = true;
        long l13 = this.a;
        long l14 = this.b;
        if (!(l12 > 0 ? (l12 = (long)s1.g(l13, l14)) > 0 : (l12 = (long)s1.g(l13, l14)) < 0)) {
            bl2 = false;
        }
        return bl2;
    }

    public String toString() {
        long l10;
        StringBuilder stringBuilder;
        long l11 = this.c;
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        String string2 = " step ";
        if (l13 > 0) {
            stringBuilder = new StringBuilder();
            String string3 = g1.V(this.a);
            stringBuilder.append(string3);
            stringBuilder.append("..");
            l12 = this.b;
            string3 = g1.V(l12);
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            l10 = this.c;
        } else {
            stringBuilder = new StringBuilder();
            String string4 = g1.V(this.a);
            stringBuilder.append(string4);
            stringBuilder.append(" downTo ");
            l12 = this.b;
            string4 = g1.V(l12);
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            l10 = -this.c;
        }
        stringBuilder.append(l10);
        return stringBuilder.toString();
    }
}

