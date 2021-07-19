/*
 * Decompiled with CFR 0.151.
 */
package f.r2;

import f.h2.t.f0;
import f.h2.t.u;
import f.r2.d;

public final class s {
    private final Object a;
    private final double b;

    private s(Object object, double d10) {
        this.a = object;
        this.b = d10;
    }

    public /* synthetic */ s(Object object, double d10, u u10) {
        this(object, d10);
    }

    public static /* synthetic */ s d(s s10, Object object, double d10, int n10, Object object2) {
        int n11 = n10 & 1;
        if (n11 != 0) {
            object = s10.a;
        }
        if ((n10 &= 2) != 0) {
            d10 = s10.b;
        }
        return s10.c(object, d10);
    }

    public final Object a() {
        return this.a;
    }

    public final double b() {
        return this.b;
    }

    public final s c(Object object, double d10) {
        s s10 = new s(object, d10);
        return s10;
    }

    public final double e() {
        return this.b;
    }

    public boolean equals(Object object) {
        block2: {
            block3: {
                double d10;
                double d11;
                int n10;
                if (this == object) break block2;
                boolean bl2 = object instanceof s;
                if (!bl2) break block3;
                object = (s)object;
                Object object2 = this.a;
                Object object3 = ((s)object).a;
                bl2 = f0.g(object2, object3);
                if (bl2 && (n10 = Double.compare(d11 = this.b, d10 = ((s)object).b)) == 0) break block2;
            }
            return false;
        }
        return true;
    }

    public final Object f() {
        return this.a;
    }

    public int hashCode() {
        int n10;
        Object object = this.a;
        if (object != null) {
            n10 = object.hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        long l10 = Double.doubleToLongBits(this.b);
        long l11 = l10 >>> 32;
        int n11 = (int)(l10 ^ l11);
        return (n10 *= 31) + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TimedValue(value=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(", duration=");
        object = d.X(this.b);
        stringBuilder.append((String)object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

