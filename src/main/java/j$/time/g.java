/*
 * Decompiled with CFR 0.151.
 */
package j$.time;

import j$.time.c;
import j$.time.p.j;
import j$.time.p.k;
import j$.time.q.b_0;
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

public final class g
extends Enum
implements s,
t {
    public static final /* enum */ g a;
    public static final /* enum */ g b;
    public static final /* enum */ g c;
    public static final /* enum */ g d;
    public static final /* enum */ g e;
    public static final /* enum */ g f;
    public static final /* enum */ g g;
    public static final /* enum */ g h;
    public static final /* enum */ g i;
    public static final /* enum */ g j;
    public static final /* enum */ g k;
    public static final /* enum */ g l;
    private static final g[] m;
    private static final /* synthetic */ g[] n;

    static {
        g g10;
        g g11;
        g g12;
        g g13;
        g g14;
        g g15;
        g g16;
        g g17;
        g g18;
        g g19;
        g g20;
        g g21;
        a = g21 = new g("JANUARY", 0);
        int n10 = 1;
        b = g20 = new g("FEBRUARY", n10);
        c = g19 = new g("MARCH", 2);
        d = g18 = new g("APRIL", 3);
        e = g17 = new g("MAY", 4);
        f = g16 = new g("JUNE", 5);
        g = g15 = new g("JULY", 6);
        h = g14 = new g("AUGUST", 7);
        i = g13 = new g("SEPTEMBER", 8);
        j = g12 = new g("OCTOBER", 9);
        k = g11 = new g("NOVEMBER", 10);
        int n11 = 11;
        l = g10 = new g("DECEMBER", n11);
        g[] gArray = new g[12];
        gArray[0] = g21;
        gArray[n10] = g20;
        gArray[2] = g19;
        gArray[3] = g18;
        gArray[4] = g17;
        gArray[5] = g16;
        gArray[6] = g15;
        gArray[7] = g14;
        gArray[8] = g13;
        gArray[9] = g12;
        gArray[10] = g11;
        gArray[n11] = g10;
        n = gArray;
        m = j$.time.g.values();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private g() {
        void var2_-1;
        void var1_-1;
    }

    public static g o(int n10) {
        int n11;
        int n12 = 1;
        if (n10 >= n12 && n10 <= (n11 = 12)) {
            g[] gArray = m;
            return gArray[n10 -= n12];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid value for MonthOfYear: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        c c10 = new c(string2);
        throw c10;
    }

    public static g valueOf(String string2) {
        return Enum.valueOf(g.class, string2);
    }

    public static g[] values() {
        return (g[])n.clone();
    }

    public Object d(w w10) {
        w w11 = b_0.a;
        if (w10 == w11) {
            return j$.time.p.k.a;
        }
        w11 = j$.time.q.e.a;
        if (w10 == w11) {
            return j$.time.q.i.k;
        }
        return s.super.d(w10);
    }

    public r e(r object) {
        k k10;
        Object object2 = j$.time.p.j.A((s)object);
        boolean bl2 = object2.equals(k10 = j$.time.p.k.a);
        if (bl2) {
            object2 = j$.time.q.h.B;
            long l10 = this.n();
            return object.c((u)object2, l10);
        }
        object = new c("Adjustment only supported on ISO date-time");
        throw object;
    }

    public boolean g(u u10) {
        boolean bl2;
        boolean bl3 = u10 instanceof h;
        boolean bl4 = true;
        if (bl3) {
            h h10 = j$.time.q.h.B;
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
        Object object2 = j$.time.q.h.B;
        if (object == object2) {
            return this.n();
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
        h h10 = j$.time.q.h.B;
        if (u10 == h10) {
            return u10.x();
        }
        return s.super.i(u10);
    }

    public int k(u u10) {
        h h10 = j$.time.q.h.B;
        if (u10 == h10) {
            return this.n();
        }
        return s.super.k(u10);
    }

    public int m(boolean bl2) {
        int n10 = this.ordinal();
        switch (n10) {
            default: {
                n10 = 335;
                break;
            }
            case 9: {
                n10 = 274;
                break;
            }
            case 7: {
                n10 = 213;
                break;
            }
            case 6: {
                n10 = 182;
                break;
            }
            case 4: {
                n10 = 121;
                break;
            }
            case 2: {
                n10 = 60;
                break;
            }
            case 0: {
                return 1;
            }
            case 10: {
                n10 = 305;
                break;
            }
            case 8: {
                n10 = 244;
                break;
            }
            case 5: {
                n10 = 152;
                break;
            }
            case 3: {
                n10 = 91;
                break;
            }
            case 1: {
                return 32;
            }
        }
        return bl2 + n10;
    }

    public int n() {
        return this.ordinal() + 1;
    }

    public g x(long l10) {
        int n10 = (int)(l10 % (long)12);
        g[] gArray = m;
        int n11 = this.ordinal();
        n10 = (n10 + 12 + n11) % 12;
        return gArray[n10];
    }
}

