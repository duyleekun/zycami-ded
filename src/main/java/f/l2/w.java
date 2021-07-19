/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.g1;
import f.l2.g;
import f.l2.u;
import f.l2.w$a;
import f.s1;

public final class w
extends u
implements g {
    private static final w e;
    public static final w$a f;

    static {
        Object object = new w$a(null);
        f = object;
        e = object = new w(-1, 0L, null);
    }

    private w(long l10, long l11) {
        super(l10, l11, 1L, null);
    }

    public /* synthetic */ w(long l10, long l11, f.h2.t.u u10) {
        this(l10, l11);
    }

    public static final /* synthetic */ w i() {
        return e;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        long l10;
        long l11;
        long l12;
        boolean bl2 = object instanceof w;
        if (!bl2) return false;
        bl2 = this.isEmpty();
        if (bl2) {
            Object object2 = object;
            object2 = (w)object;
            bl2 = ((w)object2).isEmpty();
            if (bl2) return true;
        }
        if (bl2 = (l12 = (l11 = this.e()) - (l10 = ((u)(object = (w)object)).e())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) return false;
        l11 = this.f();
        long l13 = l11 - (l10 = ((u)object).f());
        Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object3) return false;
        return true;
    }

    public int hashCode() {
        int n10 = this.isEmpty();
        if (n10 != 0) {
            n10 = -1;
        } else {
            long l10 = this.e();
            long l11 = this.e();
            int n11 = 32;
            l11 = g1.h(l11 >>> n11);
            l10 = g1.h(l10 ^ l11);
            n10 = (int)l10 * 31;
            long l12 = this.f();
            long l13 = this.f();
            long l14 = g1.h(l13 >>> n11);
            l12 = g1.h(l12 ^ l14);
            int n12 = (int)l12;
            n10 += n12;
        }
        return n10;
    }

    public boolean isEmpty() {
        long l10;
        long l11 = this.e();
        int n10 = s1.g(l11, l10 = this.f());
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean j(long l10) {
        int n10;
        long l11 = this.e();
        int n11 = s1.g(l11, l10);
        n10 = n11 <= 0 && (n10 = s1.g(l10, l11 = this.f())) <= 0 ? 1 : 0;
        return n10 != 0;
    }

    public long k() {
        return this.f();
    }

    public long l() {
        return this.e();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = g1.V(this.e());
        stringBuilder.append(string2);
        stringBuilder.append("..");
        string2 = g1.V(this.f());
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

