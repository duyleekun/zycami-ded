/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.l2.g;
import f.l2.i;
import f.l2.k$a;

public final class k
extends i
implements g {
    private static final k e;
    public static final k$a f;

    static {
        Object object = new k$a(null);
        f = object;
        e = object = new k(1, 0);
    }

    public k(int n10, int n11) {
        super(n10, n11, 1);
    }

    public static final /* synthetic */ k i() {
        return e;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        int n10;
        int n11;
        int n12 = object instanceof k;
        if (n12 == 0) return 0 != 0;
        n12 = this.isEmpty();
        if (n12 != 0) {
            Object object2 = object;
            object2 = (k)object;
            n12 = (int)(((k)object2).isEmpty() ? 1 : 0);
            if (n12 != 0) return 1 != 0;
        }
        if ((n12 = this.e()) != (n11 = ((i)(object = (k)object)).e())) return 0 != 0;
        n12 = this.f();
        if (n12 != (n10 = ((i)object).f())) return 0 != 0;
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

    public boolean isEmpty() {
        int n10;
        int n11 = this.e();
        n11 = n11 > (n10 = this.f()) ? 1 : 0;
        return n11 != 0;
    }

    public boolean j(int n10) {
        int n11 = this.e();
        n10 = n11 <= n10 && n10 <= (n11 = this.f()) ? 1 : 0;
        return n10 != 0;
    }

    public Integer k() {
        return this.f();
    }

    public Integer l() {
        return this.e();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = this.e();
        stringBuilder.append(n10);
        stringBuilder.append("..");
        n10 = this.f();
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }
}

