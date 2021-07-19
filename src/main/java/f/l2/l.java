/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.h2.t.x0.a;
import f.l2.l$a;
import f.l2.m;
import f.x1.m0;

public class l
implements Iterable,
a {
    public static final l$a d;
    private final long a;
    private final long b;
    private final long c;

    static {
        l$a l$a;
        d = l$a = new l$a(null);
    }

    public l(long l10, long l11, long l12) {
        long l13 = 0L;
        Object object = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (object != false) {
            l13 = Long.MIN_VALUE;
            long l14 = l12 - l13;
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object != false) {
                this.a = l10;
                this.b = l10 = f.d2.m.d(l10, l11, l12);
                this.c = l12;
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step must be non-zero.");
        throw illegalArgumentException;
    }

    public final long e() {
        return this.a;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        boolean bl2 = object instanceof l;
        if (!bl2) return false;
        boolean bl3 = this.isEmpty();
        if (bl3) {
            Object object2 = object;
            object2 = (l)object;
            boolean bl4 = ((l)object2).isEmpty();
            if (bl4) return true;
        }
        long l10 = this.a;
        object = (l)object;
        long l11 = ((l)object).a;
        long l12 = l10 - l11;
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 != false) return false;
        l10 = this.b;
        l11 = ((l)object).b;
        long l13 = l10 - l11;
        Object object4 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object4 != false) return false;
        l10 = this.c;
        l11 = ((l)object).c;
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

    public m0 h() {
        long l10 = this.a;
        long l11 = this.b;
        long l12 = this.c;
        m m10 = new m(l10, l11, l12);
        return m10;
    }

    public int hashCode() {
        int n10 = this.isEmpty();
        if (n10 != 0) {
            n10 = -1;
        } else {
            long l10 = 31;
            long l11 = this.a;
            int n11 = 32;
            long l12 = l11 >>> n11;
            l11 = (l11 ^ l12) * l10;
            l12 = this.b;
            long l13 = l12 >>> n11;
            l10 *= (l11 += (l12 ^= l13));
            l11 = this.c;
            long l14 = l11 >>> n11;
            n10 = (int)(l10 += (l11 ^= l14));
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
        if (!(l12 > 0 ? (l12 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1)) > 0 : (l12 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1)) < 0)) {
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
            l12 = this.a;
            stringBuilder.append(l12);
            String string3 = "..";
            stringBuilder.append(string3);
            l12 = this.b;
            stringBuilder.append(l12);
            stringBuilder.append(string2);
            l10 = this.c;
        } else {
            stringBuilder = new StringBuilder();
            l12 = this.a;
            stringBuilder.append(l12);
            String string4 = " downTo ";
            stringBuilder.append(string4);
            l12 = this.b;
            stringBuilder.append(l12);
            stringBuilder.append(string2);
            l10 = -this.c;
        }
        stringBuilder.append(l10);
        return stringBuilder.toString();
    }
}

