/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.d2.m;
import f.h2.t.x0.a;
import f.l2.i$a;
import f.l2.j;
import f.x1.l0;

public class i
implements Iterable,
a {
    public static final i$a d;
    private final int a;
    private final int b;
    private final int c;

    static {
        i$a i$a;
        d = i$a = new i$a(null);
    }

    public i(int n10, int n11, int n12) {
        if (n12 != 0) {
            int n13 = -1 << -1;
            if (n12 != n13) {
                this.a = n10;
                this.b = n10 = m.c(n10, n11, n12);
                this.c = n12;
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step must be non-zero.");
        throw illegalArgumentException;
    }

    public final int e() {
        return this.a;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        int n10 = object instanceof i;
        if (n10 == 0) return 0 != 0;
        n10 = this.isEmpty();
        if (n10 != 0) {
            Object object2 = object;
            object2 = (i)object;
            n10 = (int)(((i)object2).isEmpty() ? 1 : 0);
            if (n10 != 0) return 1 != 0;
        }
        n10 = this.a;
        object = (i)object;
        int n11 = ((i)object).a;
        if (n10 != n11) return 0 != 0;
        n10 = this.b;
        n11 = ((i)object).b;
        if (n10 != n11) return 0 != 0;
        n10 = this.c;
        int n12 = ((i)object).c;
        if (n10 != n12) return 0 != 0;
        return 1 != 0;
    }

    public final int f() {
        return this.b;
    }

    public final int g() {
        return this.c;
    }

    public l0 h() {
        int n10 = this.a;
        int n11 = this.b;
        int n12 = this.c;
        j j10 = new j(n10, n11, n12);
        return j10;
    }

    public int hashCode() {
        int n10 = this.isEmpty();
        if (n10 != 0) {
            n10 = -1;
        } else {
            n10 = this.a * 31;
            int n11 = this.b;
            n10 = (n10 + n11) * 31;
            n11 = this.c;
            n10 += n11;
        }
        return n10;
    }

    public boolean isEmpty() {
        int n10;
        int n11;
        int n12 = this.c;
        boolean bl2 = true;
        if (!(n12 > 0 ? (n12 = this.a) > (n11 = this.b) : (n12 = this.a) < (n10 = this.b))) {
            bl2 = false;
        }
        return bl2;
    }

    public String toString() {
        int n10;
        StringBuilder stringBuilder;
        int n11 = this.c;
        String string2 = " step ";
        if (n11 > 0) {
            stringBuilder = new StringBuilder();
            int n12 = this.a;
            stringBuilder.append(n12);
            String string3 = "..";
            stringBuilder.append(string3);
            n12 = this.b;
            stringBuilder.append(n12);
            stringBuilder.append(string2);
            n10 = this.c;
        } else {
            stringBuilder = new StringBuilder();
            int n13 = this.a;
            stringBuilder.append(n13);
            String string4 = " downTo ";
            stringBuilder.append(string4);
            n13 = this.b;
            stringBuilder.append(n13);
            stringBuilder.append(string2);
            n10 = -this.c;
        }
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }
}

