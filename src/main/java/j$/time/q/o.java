/*
 * Decompiled with CFR 0.151.
 */
package j$.time.q;

import j$.time.LocalDate;
import j$.time.d;
import j$.time.q.k;
import j$.time.q.l;
import j$.time.q.m;
import j$.time.q.n;
import j$.time.q.s;
import j$.time.q.u;
import j$.time.q.z;

abstract class o
extends Enum
implements u {
    public static final /* enum */ o a;
    public static final /* enum */ o b;
    public static final /* enum */ o c;
    public static final /* enum */ o d;
    private static final int[] e;
    private static final /* synthetic */ o[] f;

    static {
        Object object = new k();
        a = object;
        int n10 = 1;
        l l10 = new l();
        b = l10;
        int n11 = 2;
        m m10 = new m();
        c = m10;
        int n12 = 3;
        n n13 = new n();
        d = n13;
        o[] oArray = new o[4];
        oArray[0] = object;
        oArray[n10] = l10;
        oArray[n11] = m10;
        oArray[n12] = n13;
        f = oArray;
        Object object2 = object = (Object)new int[8];
        object2[0] = false;
        object2[1] = 90;
        object2[2] = 181;
        object2[3] = 273;
        object2[4] = false;
        object2[5] = 91;
        object2[6] = 182;
        object2[7] = 274;
        e = (int[])object;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    o() {
        void var2_1;
        void var1_-1;
    }

    static /* synthetic */ int[] O() {
        return e;
    }

    static z P(LocalDate localDate) {
        long l10 = o.U(o.T(localDate));
        return z.i(1L, l10);
    }

    static int Q(LocalDate serializable) {
        int n10;
        block7: {
            int n11;
            block9: {
                int n12;
                block8: {
                    int n13;
                    int n14;
                    block6: {
                        d d10 = ((LocalDate)serializable).x();
                        n14 = d10.ordinal();
                        n12 = ((LocalDate)serializable).getDayOfYear();
                        n11 = 1;
                        n14 = 3 - n14 + (n12 -= n11);
                        n13 = n14 / 7 * 7;
                        n14 -= n13;
                        n13 = -3;
                        if ((n14 += n13) < n13) {
                            n14 += 7;
                        }
                        if (n12 >= n14) break block6;
                        n14 = 180;
                        long l10 = o.U(o.T(((LocalDate)serializable).W(n14).T(-1)));
                        long l11 = 1L;
                        serializable = z.i(l11, l10);
                        l10 = ((z)serializable).d();
                        n10 = (int)l10;
                        break block7;
                    }
                    int n15 = 53;
                    if ((n12 = (n12 - n14) / 7 + n11) != n15) break block8;
                    if (n14 != n13 && (n14 != (n13 = -2) || (n10 = (int)(((LocalDate)serializable).G() ? 1 : 0)) == 0)) {
                        n10 = 0;
                        serializable = null;
                    } else {
                        n10 = n11;
                    }
                    if (n10 == 0) break block9;
                }
                n11 = n12;
            }
            n10 = n11;
        }
        return n10;
    }

    static /* synthetic */ int R(LocalDate localDate) {
        return o.T(localDate);
    }

    static /* synthetic */ int S(int n10) {
        return o.U(n10);
    }

    private static int T(LocalDate s10) {
        int n10;
        int n11 = ((LocalDate)s10).getYear();
        int n12 = ((LocalDate)s10).getDayOfYear();
        if (n12 <= (n10 = 3)) {
            s10 = ((LocalDate)s10).x();
            int n13 = ((Enum)((Object)s10)).ordinal();
            if ((n12 -= n13) < (n13 = -2)) {
                n11 += -1;
            }
        } else {
            n10 = 363;
            if (n12 >= n10) {
                d d10 = ((LocalDate)s10).x();
                int n14 = d10.ordinal();
                n12 -= n10;
                int n15 = (int)(((LocalDate)s10).G() ? 1 : 0);
                if ((n12 = n12 - n15 - n14) >= 0) {
                    ++n11;
                }
            }
        }
        return n11;
    }

    private static int U(int n10) {
        d d10;
        int n11 = 1;
        LocalDate localDate = LocalDate.D(n10, n11, n11);
        d d11 = localDate.x();
        if (d11 != (d10 = j$.time.d.c) && ((d11 = localDate.x()) != (d10 = j$.time.d.b) || (n10 = (int)(localDate.G() ? 1 : 0)) == 0)) {
            return 52;
        }
        return 53;
    }

    public static o valueOf(String string2) {
        return Enum.valueOf(o.class, string2);
    }

    public static o[] values() {
        return (o[])f.clone();
    }

    public boolean C() {
        return false;
    }

    public z D(s s10) {
        return this.x();
    }

    public boolean m() {
        return true;
    }
}

