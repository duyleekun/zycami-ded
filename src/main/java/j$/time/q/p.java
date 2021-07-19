/*
 * Decompiled with CFR 0.151.
 */
package j$.time.q;

import j$.time.Duration;
import j$.time.q.i;
import j$.time.q.j;
import j$.time.q.o;
import j$.time.q.q;
import j$.time.q.r;
import j$.time.q.u;
import j$.time.q.x;

final class p
extends Enum
implements x {
    public static final /* enum */ p b;
    public static final /* enum */ p c;
    private static final /* synthetic */ p[] d;
    private final String a;

    static {
        p p10;
        Object object = Duration.o(31556952L);
        b = p10 = new p("WEEK_BASED_YEARS", 0, "WeekBasedYears", (Duration)object);
        p[] pArray = Duration.o(7889238L);
        int n10 = 1;
        c = object = new p("QUARTER_YEARS", n10, "QuarterYears", (Duration)pArray);
        pArray = new p[2];
        pArray[0] = p10;
        pArray[n10] = object;
        d = pArray;
    }

    /*
     * WARNING - void declaration
     */
    private p() {
        void var3_2;
        void var1_-1;
        this.a = var3_2;
    }

    public static p valueOf(String string2) {
        return Enum.valueOf(p.class, string2);
    }

    public static p[] values() {
        return (p[])d.clone();
    }

    public boolean m() {
        return true;
    }

    public r n(r object, long l10) {
        Object object2 = j.a;
        int n10 = this.ordinal();
        int n11 = object2[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 == n10) {
                long l11 = 256L;
                long l12 = l10 / l11;
                i i10 = i.l;
                object = object.a(l12, i10);
                l10 = l10 % l11 * (long)3;
                object2 = i.k;
                return object.a(l10, (x)object2);
            }
            object = new IllegalStateException("Unreachable");
            throw object;
        }
        object2 = q.a;
        object2 = o.d;
        l10 = Math.addExact((long)object.k((u)object2), l10);
        return object.c((u)object2, l10);
    }

    public String toString() {
        return this.a;
    }
}

