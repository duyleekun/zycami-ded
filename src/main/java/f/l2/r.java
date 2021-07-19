/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.c1;
import f.d2.p;
import f.h2.t.u;
import f.h2.t.x0.a;
import f.l2.r$a;
import f.l2.s;
import f.s1;
import f.x1.l1;

public class r
implements Iterable,
a {
    public static final r$a d;
    private final int a;
    private final int b;
    private final int c;

    static {
        r$a r$a;
        d = r$a = new r$a(null);
    }

    private r(int n10, int n11, int n12) {
        if (n12 != 0) {
            int n13 = -1 << -1;
            if (n12 != n13) {
                this.a = n10;
                this.b = n10 = p.d(n10, n11, n12);
                this.c = n12;
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step must be non-zero.");
        throw illegalArgumentException;
    }

    public /* synthetic */ r(int n10, int n11, int n12, u u10) {
        this(n10, n11, n12);
    }

    public final int e() {
        return this.a;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        int n10 = object instanceof r;
        if (n10 == 0) return 0 != 0;
        n10 = this.isEmpty();
        if (n10 != 0) {
            Object object2 = object;
            object2 = (r)object;
            n10 = (int)(((r)object2).isEmpty() ? 1 : 0);
            if (n10 != 0) return 1 != 0;
        }
        n10 = this.a;
        object = (r)object;
        int n11 = ((r)object).a;
        if (n10 != n11) return 0 != 0;
        n10 = this.b;
        n11 = ((r)object).b;
        if (n10 != n11) return 0 != 0;
        n10 = this.c;
        int n12 = ((r)object).c;
        if (n10 != n12) return 0 != 0;
        return 1 != 0;
    }

    public final int f() {
        return this.b;
    }

    public final int g() {
        return this.c;
    }

    public l1 h() {
        int n10 = this.a;
        int n11 = this.b;
        int n12 = this.c;
        s s10 = new s(n10, n11, n12, null);
        return s10;
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
        boolean bl2;
        block4: {
            block3: {
                int n10;
                block2: {
                    n10 = this.c;
                    bl2 = true;
                    if (n10 <= 0) break block2;
                    n10 = this.a;
                    int n11 = this.b;
                    if ((n10 = s1.c(n10, n11)) <= 0) break block3;
                    break block4;
                }
                n10 = this.a;
                int n12 = this.b;
                if ((n10 = s1.c(n10, n12)) < 0) break block4;
            }
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
            String string3 = c1.V(this.a);
            stringBuilder.append(string3);
            stringBuilder.append("..");
            int n12 = this.b;
            string3 = c1.V(n12);
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            n10 = this.c;
        } else {
            stringBuilder = new StringBuilder();
            String string4 = c1.V(this.a);
            stringBuilder.append(string4);
            stringBuilder.append(" downTo ");
            int n13 = this.b;
            string4 = c1.V(n13);
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            n10 = -this.c;
        }
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }
}

