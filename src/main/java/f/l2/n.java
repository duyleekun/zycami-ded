/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.l2.g;
import f.l2.l;
import f.l2.n$a;

public final class n
extends l
implements g {
    private static final n e;
    public static final n$a f;

    static {
        Object object = new n$a(null);
        f = object;
        e = object = new n(1L, 0L);
    }

    public n(long l10, long l11) {
        super(l10, l11, 1L);
    }

    public static final /* synthetic */ n i() {
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
        boolean bl2 = object instanceof n;
        if (!bl2) return false;
        bl2 = this.isEmpty();
        if (bl2) {
            Object object2 = object;
            object2 = (n)object;
            bl2 = ((n)object2).isEmpty();
            if (bl2) return true;
        }
        if (bl2 = (l12 = (l11 = this.e()) - (l10 = ((l)(object = (n)object)).e())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) return false;
        l11 = this.f();
        long l13 = l11 - (l10 = ((l)object).f());
        Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object3) return false;
        return true;
    }

    public int hashCode() {
        int n10 = this.isEmpty();
        if (n10 != 0) {
            n10 = -1;
        } else {
            long l10 = 31;
            long l11 = this.e();
            long l12 = this.e();
            int n11 = 32;
            l10 *= (l11 ^= (l12 >>>= n11));
            l11 = this.f();
            l12 = this.f() >>> n11;
            n10 = (int)(l10 += (l11 ^= l12));
        }
        return n10;
    }

    public boolean isEmpty() {
        long l10;
        long l11 = this.e();
        long l12 = l11 - (l10 = this.f());
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public boolean j(long l10) {
        long l11;
        int n10;
        long l12 = this.e();
        long l13 = l12 - l10;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        n10 = object <= 0 && (n10 = (l11 = l10 - (l12 = this.f())) == 0L ? 0 : (l11 < 0L ? -1 : 1)) <= 0 ? 1 : 0;
        return n10 != 0;
    }

    public Long k() {
        return this.f();
    }

    public Long l() {
        return this.e();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        long l10 = this.e();
        stringBuilder.append(l10);
        stringBuilder.append("..");
        l10 = this.f();
        stringBuilder.append(l10);
        return stringBuilder.toString();
    }
}

