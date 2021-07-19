/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.f0;

public final class i0 {
    private final int a;
    private final Object b;

    public i0(int n10, Object object) {
        this.a = n10;
        this.b = object;
    }

    public static /* synthetic */ i0 d(i0 i02, int n10, Object object, int n11, Object object2) {
        int n12 = n11 & 1;
        if (n12 != 0) {
            n10 = i02.a;
        }
        if ((n11 &= 2) != 0) {
            object = i02.b;
        }
        return i02.c(n10, object);
    }

    public final int a() {
        return this.a;
    }

    public final Object b() {
        return this.b;
    }

    public final i0 c(int n10, Object object) {
        i0 i02 = new i0(n10, object);
        return i02;
    }

    public final int e() {
        return this.a;
    }

    public boolean equals(Object object) {
        block2: {
            block3: {
                Object object2;
                boolean bl2;
                if (this == object) break block2;
                int n10 = object instanceof i0;
                if (n10 == 0) break block3;
                object = (i0)object;
                n10 = this.a;
                int n11 = ((i0)object).a;
                if (n10 == n11 && (bl2 = f0.g(object2 = this.b, object = ((i0)object).b))) break block2;
            }
            return false;
        }
        return true;
    }

    public final Object f() {
        return this.b;
    }

    public int hashCode() {
        int n10;
        int n11 = this.a * 31;
        Object object = this.b;
        if (object != null) {
            n10 = object.hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        return n11 + n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IndexedValue(index=");
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(", value=");
        Object object = this.b;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

