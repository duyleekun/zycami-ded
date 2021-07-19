/*
 * Decompiled with CFR 0.151.
 */
package j$.time.q;

import j$.time.c;
import j$.time.q.u;
import java.io.Serializable;

public final class z
implements Serializable {
    private final long a;
    private final long b;
    private final long c;
    private final long d;

    private z(long l10, long l11, long l12, long l13) {
        this.a = l10;
        this.b = l11;
        this.c = l12;
        this.d = l13;
    }

    private String c(u object, long l10) {
        String string2 = "): ";
        if (object != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid value for ");
            stringBuilder.append(object);
            stringBuilder.append(" (valid values ");
            stringBuilder.append(this);
            stringBuilder.append(string2);
            stringBuilder.append(l10);
            return stringBuilder.toString();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Invalid value (valid values ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(l10);
        return ((StringBuilder)object).toString();
    }

    public static z i(long l10, long l11) {
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object <= 0) {
            z z10 = new z(l10, l10, l11, l11);
            return z10;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Minimum value must be less than maximum value");
        throw illegalArgumentException;
    }

    public static z j(long l10, long l11, long l12) {
        return z.k(l10, l10, l11, l12);
    }

    public static z k(long l10, long l11, long l12, long l13) {
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object <= 0) {
            object = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
            if (object <= 0) {
                object = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
                if (object <= 0) {
                    z z10;
                    z z11 = z10;
                    z10 = new z(l10, l11, l12, l13);
                    return z10;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Minimum value must be less than maximum value");
                throw illegalArgumentException;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        throw illegalArgumentException;
    }

    public int a(long l10, u u10) {
        c c10;
        boolean bl2 = this.g();
        if (bl2 && (bl2 = this.h(l10))) {
            bl2 = true;
        } else {
            bl2 = false;
            c10 = null;
        }
        if (bl2) {
            return (int)l10;
        }
        String string2 = this.c(u10, l10);
        c10 = new c(string2);
        throw c10;
    }

    public long b(long l10, u u10) {
        boolean bl2 = this.h(l10);
        if (bl2) {
            return l10;
        }
        String string2 = this.c(u10, l10);
        c c10 = new c(string2);
        throw c10;
    }

    public long d() {
        return this.d;
    }

    public long e() {
        return this.a;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        Object object2 = object instanceof z;
        if (object2) {
            long l10;
            long l11;
            long l12;
            long l13;
            object = (z)object;
            long l14 = this.a;
            long l15 = ((z)object).a;
            long l16 = l14 - l15;
            object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object2 || (object2 = (l13 = (l14 = this.b) - (l15 = ((z)object).b)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) || (object2 = (l12 = (l14 = this.c) - (l15 = ((z)object).c)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) || (l11 = (l10 = (l14 = this.d) - (l15 = ((z)object).d)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public boolean f() {
        long l10;
        long l11 = this.a;
        long l12 = this.b;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        object = object == false && (object = (l10 = (l11 = this.c) - (l12 = this.d)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public boolean g() {
        long l10;
        long l11 = this.a;
        long l12 = 0x80000000L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        object = object >= 0 && (object = (l10 = (l11 = this.d) - (l12 = Integer.MAX_VALUE)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) <= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public boolean h(long l10) {
        long l11;
        int n10;
        long l12 = this.a;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        n10 = object >= 0 && (n10 = (l11 = l10 - (l12 = this.d)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) <= 0 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        long l10 = this.a;
        long l11 = this.b;
        int n10 = 16;
        long l12 = l11 << n10;
        l10 += l12;
        int n11 = 48;
        l10 += (l11 >>= n11);
        l11 = this.c;
        int n12 = 32;
        long l13 = l11 << n12;
        l10 += l13;
        l10 += (l11 >>= n12);
        l11 = this.d;
        l13 = l11 << n11;
        l10 += l13;
        l11 = (l10 += (l11 >>= n10)) >>> n12;
        return (int)(l10 ^ l11);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        long l10 = this.a;
        stringBuilder.append(l10);
        l10 = this.a;
        long l11 = this.b;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        char c10 = '/';
        if (l12 != false) {
            stringBuilder.append(c10);
            l11 = this.b;
            stringBuilder.append(l11);
        }
        String string2 = " - ";
        stringBuilder.append(string2);
        l11 = this.c;
        stringBuilder.append(l11);
        l11 = this.c;
        long l13 = this.d;
        l12 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
        if (l12 != false) {
            stringBuilder.append(c10);
            l10 = this.d;
            stringBuilder.append(l10);
        }
        return stringBuilder.toString();
    }
}

