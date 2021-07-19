/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import f.h2.t.f0;
import f.l2.k;

public final class h {
    private final String a;
    private final k b;

    public h(String string2, k k10) {
        f0.p(string2, "value");
        f0.p(k10, "range");
        this.a = string2;
        this.b = k10;
    }

    public static /* synthetic */ h d(h h10, String string2, k k10, int n10, Object object) {
        int n11 = n10 & 1;
        if (n11 != 0) {
            string2 = h10.a;
        }
        if ((n10 &= 2) != 0) {
            k10 = h10.b;
        }
        return h10.c(string2, k10);
    }

    public final String a() {
        return this.a;
    }

    public final k b() {
        return this.b;
    }

    public final h c(String string2, k k10) {
        f0.p(string2, "value");
        f0.p(k10, "range");
        h h10 = new h(string2, k10);
        return h10;
    }

    public final k e() {
        return this.b;
    }

    public boolean equals(Object object) {
        block2: {
            block3: {
                boolean bl2;
                if (this == object) break block2;
                boolean bl3 = object instanceof h;
                if (!bl3) break block3;
                object = (h)object;
                Object object2 = this.a;
                String string2 = ((h)object).a;
                bl3 = f0.g(object2, string2);
                if (bl3 && (bl2 = f0.g(object2 = this.b, object = ((h)object).b))) break block2;
            }
            return false;
        }
        return true;
    }

    public final String f() {
        return this.a;
    }

    public int hashCode() {
        int n10;
        String string2 = this.a;
        int n11 = 0;
        if (string2 != null) {
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        n10 *= 31;
        k k10 = this.b;
        if (k10 != null) {
            n11 = ((Object)k10).hashCode();
        }
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MatchGroup(value=");
        Object object = this.a;
        stringBuilder.append((String)object);
        stringBuilder.append(", range=");
        object = this.b;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

