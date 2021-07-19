/*
 * Decompiled with CFR 0.151.
 */
package j$.time;

import j$.time.c;
import j$.time.q.e;
import j$.time.q.h;
import j$.time.q.i;
import j$.time.q.r;
import j$.time.q.s;
import j$.time.q.t;
import j$.time.q.u;
import j$.time.q.w;
import j$.time.q.y;
import j$.time.q.z;

public final class d
extends Enum
implements s,
t {
    public static final /* enum */ d a;
    public static final /* enum */ d b;
    public static final /* enum */ d c;
    public static final /* enum */ d d;
    private static final d[] e;
    private static final /* synthetic */ d[] f;

    static {
        d d10;
        d d11;
        d d12;
        d d13;
        a = d13 = new d("MONDAY", 0);
        int n10 = 1;
        d d14 = new d("TUESDAY", n10);
        int n11 = 2;
        b = d12 = new d("WEDNESDAY", n11);
        int n12 = 3;
        c = d11 = new d("THURSDAY", n12);
        int n13 = 4;
        d d15 = new d("FRIDAY", n13);
        int n14 = 5;
        d d16 = new d("SATURDAY", n14);
        int n15 = 6;
        d = d10 = new d("SUNDAY", n15);
        d[] dArray = new d[7];
        dArray[0] = d13;
        dArray[n10] = d14;
        dArray[n11] = d12;
        dArray[n12] = d11;
        dArray[n13] = d15;
        dArray[n14] = d16;
        dArray[n15] = d10;
        f = dArray;
        e = j$.time.d.values();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private d() {
        void var2_-1;
        void var1_-1;
    }

    public static d n(int n10) {
        int n11;
        int n12 = 1;
        if (n10 >= n12 && n10 <= (n11 = 7)) {
            d[] dArray = e;
            return dArray[n10 -= n12];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid value for DayOfWeek: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        c c10 = new c(string2);
        throw c10;
    }

    public static d valueOf(String string2) {
        return Enum.valueOf(d.class, string2);
    }

    public static d[] values() {
        return (d[])f.clone();
    }

    public Object d(w w10) {
        e e10 = j$.time.q.e.a;
        if (w10 == e10) {
            return i.i;
        }
        return s.super.d(w10);
    }

    public r e(r r10) {
        h h10 = h.t;
        long l10 = this.m();
        return r10.c(h10, l10);
    }

    public boolean g(u u10) {
        boolean bl2;
        boolean bl3 = u10 instanceof h;
        boolean bl4 = true;
        if (bl3) {
            h h10 = h.t;
            if (u10 != h10) {
                bl4 = false;
            }
            return bl4;
        }
        if (u10 == null || !(bl2 = u10.L(this))) {
            bl4 = false;
        }
        return bl4;
    }

    public long h(u object) {
        Object object2 = h.t;
        if (object == object2) {
            return this.m();
        }
        boolean bl2 = object instanceof h;
        if (!bl2) {
            return object.o(this);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new y((String)object);
        throw object2;
    }

    public z i(u u10) {
        h h10 = h.t;
        if (u10 == h10) {
            return u10.x();
        }
        return s.super.i(u10);
    }

    public int k(u u10) {
        h h10 = h.t;
        if (u10 == h10) {
            return this.m();
        }
        return s.super.k(u10);
    }

    public int m() {
        return this.ordinal() + 1;
    }

    public d o(long l10) {
        int n10 = (int)(l10 % (long)7);
        d[] dArray = e;
        int n11 = this.ordinal();
        n10 = (n10 + 7 + n11) % 7;
        return dArray[n10];
    }
}

