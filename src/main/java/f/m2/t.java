/*
 * Decompiled with CFR 0.151.
 */
package f.m2;

import f.h2.t.f0;
import f.m2.r;
import f.m2.t$a;
import f.m2.u;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.KVariance;

public final class t {
    public static final t c;
    public static final t$a d;
    private final KVariance a;
    private final r b;

    static {
        Object object = new t$a(null);
        d = object;
        c = object = new t(null, null);
    }

    public t(KVariance object, r object2) {
        String string2;
        boolean bl2;
        this.a = object;
        this.b = object2;
        boolean bl3 = true;
        boolean bl4 = object == null ? bl3 : false;
        if (object2 == null) {
            bl2 = bl3;
        } else {
            bl2 = false;
            object2 = null;
        }
        if (bl4 != bl2) {
            bl3 = false;
            string2 = null;
        }
        if (!bl3) {
            if (object == null) {
                object = "Star projection must have no type specified.";
            } else {
                object2 = new StringBuilder();
                string2 = "The projection variance ";
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(" requires type to be specified.");
                object = ((StringBuilder)object2).toString();
            }
            object = object.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
    }

    public static final t c(r r10) {
        return d.a(r10);
    }

    public static /* synthetic */ t e(t t10, KVariance kVariance, r r10, int n10, Object object) {
        int n11 = n10 & 1;
        if (n11 != 0) {
            kVariance = t10.a;
        }
        if ((n10 &= 2) != 0) {
            r10 = t10.b;
        }
        return t10.d(kVariance, r10);
    }

    public static final t f(r r10) {
        return d.b(r10);
    }

    public static final t i(r r10) {
        return d.e(r10);
    }

    public final KVariance a() {
        return this.a;
    }

    public final r b() {
        return this.b;
    }

    public final t d(KVariance kVariance, r r10) {
        t t10 = new t(kVariance, r10);
        return t10;
    }

    public boolean equals(Object object) {
        block2: {
            block3: {
                boolean bl2;
                if (this == object) break block2;
                boolean bl3 = object instanceof t;
                if (!bl3) break block3;
                object = (t)object;
                Object object2 = this.a;
                KVariance kVariance = ((t)object).a;
                bl3 = f0.g(object2, (Object)kVariance);
                if (bl3 && (bl2 = f0.g(object2 = this.b, object = ((t)object).b))) break block2;
            }
            return false;
        }
        return true;
    }

    public final r g() {
        return this.b;
    }

    public final KVariance h() {
        return this.a;
    }

    public int hashCode() {
        int n10;
        KVariance kVariance = this.a;
        int n11 = 0;
        if (kVariance != null) {
            n10 = ((Object)((Object)kVariance)).hashCode();
        } else {
            n10 = 0;
            kVariance = null;
        }
        n10 *= 31;
        r r10 = this.b;
        if (r10 != null) {
            n11 = r10.hashCode();
        }
        return n10 + n11;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public String toString() {
        void var1_9;
        KVariance kVariance = this.a;
        if (kVariance == null) {
            return var1_9;
        }
        int[] nArray = u.a;
        int n10 = kVariance.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) == n11) {
            String string2 = String.valueOf(this.b);
            return var1_9;
        }
        n11 = 2;
        if (n10 == n11) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("in ");
            r r10 = this.b;
            stringBuilder.append(r10);
            String string3 = stringBuilder.toString();
            return var1_9;
        }
        n11 = 3;
        if (n10 == n11) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("out ");
            r r11 = this.b;
            stringBuilder.append(r11);
            String string4 = stringBuilder.toString();
            return var1_9;
        }
        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
        throw noWhenBranchMatchedException;
    }
}

