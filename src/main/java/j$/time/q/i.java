/*
 * Decompiled with CFR 0.151.
 */
package j$.time.q;

import j$.time.Duration;
import j$.time.q.r;
import j$.time.q.x;

public final class i
extends Enum
implements x {
    public static final /* enum */ i b;
    public static final /* enum */ i c;
    public static final /* enum */ i d;
    public static final /* enum */ i e;
    public static final /* enum */ i f;
    public static final /* enum */ i g;
    public static final /* enum */ i h;
    public static final /* enum */ i i;
    public static final /* enum */ i j;
    public static final /* enum */ i k;
    public static final /* enum */ i l;
    public static final /* enum */ i m;
    public static final /* enum */ i n;
    public static final /* enum */ i o;
    public static final /* enum */ i p;
    public static final /* enum */ i q;
    private static final /* synthetic */ i[] r;
    private final String a;

    static {
        i i10;
        i i11;
        i i12;
        i i13;
        i i14;
        long l10 = 1L;
        Object object = Duration.n(l10);
        b = i14 = new i("NANOS", 0, "Nanos", (Duration)object);
        Object object2 = Duration.n(1000L);
        c = object = new i("MICROS", 1, "Micros", (Duration)object2);
        Object object3 = Duration.n(1000000L);
        d = object2 = new i("MILLIS", 2, "Millis", (Duration)object3);
        Object object4 = Duration.o(l10);
        e = object3 = new i("SECONDS", 3, "Seconds", (Duration)object4);
        Object object5 = Duration.o(60);
        f = object4 = new i("MINUTES", 4, "Minutes", (Duration)object5);
        Object object6 = Duration.o(3600L);
        g = object5 = new i("HOURS", 5, "Hours", (Duration)object6);
        Object object7 = Duration.o(43200L);
        h = object6 = new i("HALF_DAYS", 6, "HalfDays", (Duration)object7);
        Duration duration = Duration.o(86400L);
        i = object7 = new i("DAYS", 7, "Days", duration);
        duration = Duration.o(604800L);
        j = i13 = new i("WEEKS", 8, "Weeks", duration);
        duration = Duration.o(2629746L);
        i[] iArray = new i("MONTHS", 9, "Months", duration);
        k = iArray;
        duration = Duration.o(31556952L);
        l = i12 = new i("YEARS", 10, "Years", duration);
        duration = Duration.o(315569520L);
        m = i11 = new i("DECADES", 11, "Decades", duration);
        duration = Duration.o(3155695200L);
        i i15 = i11;
        n = i10 = new i("CENTURIES", 12, "Centuries", duration);
        duration = Duration.o(31556952000L);
        i i16 = i10;
        o = i11 = new i("MILLENNIA", 13, "Millennia", duration);
        duration = Duration.o(31556952000000000L);
        int n10 = 14;
        i i17 = i11;
        p = i10 = new i("ERAS", n10, "Eras", duration);
        i i18 = iArray;
        iArray = Duration.ofSeconds(Long.MAX_VALUE, 999999999L);
        int n11 = 15;
        q = i11 = new i("FOREVER", n11, "Forever", (Duration)iArray);
        iArray = new i[16];
        iArray[0] = i14;
        iArray[1] = object;
        iArray[2] = object2;
        iArray[3] = object3;
        iArray[4] = object4;
        iArray[5] = object5;
        iArray[6] = object6;
        iArray[7] = object7;
        iArray[8] = i13;
        iArray[9] = i18;
        iArray[10] = i12;
        iArray[11] = i15;
        iArray[12] = i16;
        iArray[13] = i17;
        iArray[n10] = i10;
        iArray[n11] = i11;
        r = iArray;
    }

    /*
     * WARNING - void declaration
     */
    private i() {
        void var3_2;
        void var1_-1;
        this.a = var3_2;
    }

    public static i valueOf(String string2) {
        return Enum.valueOf(i.class, string2);
    }

    public static i[] values() {
        return (i[])r.clone();
    }

    public boolean m() {
        i i10 = i;
        int n10 = this.compareTo(i10);
        if (n10 >= 0 && this != (i10 = q)) {
            n10 = 1;
        } else {
            n10 = 0;
            i10 = null;
        }
        return n10 != 0;
    }

    public r n(r r10, long l10) {
        return r10.a(l10, this);
    }

    public String toString() {
        return this.a;
    }
}

