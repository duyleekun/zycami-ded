/*
 * Decompiled with CFR 0.151.
 */
package j$.time.q;

import j$.time.q.i;
import j$.time.q.r;
import j$.time.q.s;
import j$.time.q.u;
import j$.time.q.x;
import j$.time.q.z;

public final class h
extends Enum
implements u {
    public static final /* enum */ h A;
    public static final /* enum */ h B;
    public static final /* enum */ h C;
    public static final /* enum */ h D;
    public static final /* enum */ h E;
    public static final /* enum */ h F;
    public static final /* enum */ h G;
    public static final /* enum */ h H;
    private static final /* synthetic */ h[] I;
    public static final /* enum */ h e;
    public static final /* enum */ h f;
    public static final /* enum */ h g;
    public static final /* enum */ h h;
    public static final /* enum */ h i;
    public static final /* enum */ h j;
    public static final /* enum */ h k;
    public static final /* enum */ h l;
    public static final /* enum */ h m;
    public static final /* enum */ h n;
    public static final /* enum */ h o;
    public static final /* enum */ h p;
    public static final /* enum */ h q;
    public static final /* enum */ h r;
    public static final /* enum */ h s;
    public static final /* enum */ h t;
    public static final /* enum */ h u;
    public static final /* enum */ h v;
    public static final /* enum */ h w;
    public static final /* enum */ h x;
    public static final /* enum */ h y;
    public static final /* enum */ h z;
    private final String a;
    private final x b;
    private final x c;
    private final z d;

    static {
        h h10;
        h h11;
        h h12;
        h h13;
        h h14;
        h h15;
        h h16;
        h h17;
        h h18;
        h h19;
        h h20;
        h h21;
        h h22;
        h h23;
        h h24;
        h h25;
        h h26;
        h h27;
        Enum enum_ = j$.time.q.i.b;
        i i10 = j$.time.q.i.e;
        long l10 = 0L;
        long l11 = 999999999L;
        Object object = j$.time.q.z.i(l10, l11);
        h[] hArray = h27;
        e = h27 = new h("NANO_OF_SECOND", 0, "NanoOfSecond", (x)((Object)enum_), (x)i10, (z)object);
        Enum enum_2 = j$.time.q.i.i;
        object = j$.time.q.z.i(l10, 86399999999999L);
        hArray = h26;
        f = h26 = new h("NANO_OF_DAY", 1, "NanoOfDay", (x)((Object)enum_), (x)((Object)enum_2), (z)object);
        Enum enum_3 = j$.time.q.i.c;
        object = j$.time.q.z.i(l10, 999999L);
        hArray = enum_;
        enum_ = new h("MICRO_OF_SECOND", 2, "MicroOfSecond", (x)((Object)enum_3), (x)i10, (z)object);
        g = enum_;
        object = j$.time.q.z.i(l10, 86399999999L);
        hArray = h25;
        h = h25 = new h("MICRO_OF_DAY", 3, "MicroOfDay", (x)((Object)enum_3), (x)((Object)enum_2), (z)object);
        enum_3 = j$.time.q.i.d;
        object = j$.time.q.z.i(l10, 999L);
        hArray = h24;
        i = h24 = new h("MILLI_OF_SECOND", 4, "MilliOfSecond", (x)((Object)enum_3), (x)i10, (z)object);
        object = j$.time.q.z.i(l10, 86399999L);
        hArray = h23;
        j = h23 = new h("MILLI_OF_DAY", 5, "MilliOfDay", (x)((Object)enum_3), (x)((Object)enum_2), (z)object);
        Enum enum_4 = j$.time.q.i.f;
        long l12 = 59;
        hArray = j$.time.q.z.i(l10, l12);
        enum_3 = h22;
        Object object2 = "SecondOfMinute";
        Enum enum_5 = i10;
        Enum enum_6 = enum_4;
        h[] hArray2 = hArray;
        k = h22 = new h("SECOND_OF_MINUTE", 6, (String)object2, (x)i10, (x)((Object)enum_4), (z)hArray, "second");
        Object object3 = j$.time.q.z.i(l10, 86399L);
        hArray = enum_3;
        String string2 = "SECOND_OF_DAY";
        int n10 = 7;
        String string3 = "SecondOfDay";
        object = object3;
        enum_3 = new h(string2, n10, string3, (x)i10, (x)((Object)enum_2), (z)object3);
        l = enum_3;
        enum_5 = j$.time.q.i.g;
        z z10 = j$.time.q.z.i(l10, l12);
        Object object4 = object3;
        Object object5 = enum_4;
        m = object3 = new h("MINUTE_OF_HOUR", 8, "MinuteOfHour", (x)((Object)enum_4), (x)((Object)enum_5), z10, "minute");
        object = j$.time.q.z.i(l10, 1439L);
        hArray = h21;
        n = h21 = new h("MINUTE_OF_DAY", 9, "MinuteOfDay", (x)((Object)enum_4), (x)((Object)enum_2), (z)object);
        Enum enum_7 = j$.time.q.i.h;
        object = j$.time.q.z.i(l10, 11);
        hArray = object2;
        o = object2 = new h("HOUR_OF_AMPM", 10, "HourOfAmPm", (x)((Object)enum_5), (x)((Object)enum_7), (z)object);
        object4 = j$.time.q.z.i(1L, 12);
        hArray = enum_4;
        string3 = "ClockHourOfAmPm";
        object = object4;
        enum_4 = new h("CLOCK_HOUR_OF_AMPM", 11, string3, (x)((Object)enum_5), (x)((Object)enum_7), (z)object4);
        p = enum_4;
        z10 = j$.time.q.z.i(l10, 23);
        object4 = h20;
        object5 = enum_5;
        q = h20 = new h("HOUR_OF_DAY", 12, "HourOfDay", (x)((Object)enum_5), (x)((Object)enum_2), z10, "hour");
        l12 = 1L;
        object4 = j$.time.q.z.i(l12, 24);
        hArray = h19;
        l10 = l12;
        object = object4;
        r = h19 = new h("CLOCK_HOUR_OF_DAY", 13, "ClockHourOfDay", (x)((Object)enum_5), (x)((Object)enum_2), (z)object4);
        z10 = j$.time.q.z.i(0L, l12);
        object4 = enum_5;
        object5 = enum_7;
        enum_5 = new h("AMPM_OF_DAY", 14, "AmPmOfDay", (x)((Object)enum_7), (x)((Object)enum_2), z10, "dayperiod");
        s = enum_5;
        Enum enum_8 = j$.time.q.i.j;
        l12 = 7;
        z10 = j$.time.q.z.i(l10, l12);
        object4 = enum_7;
        object5 = enum_2;
        enum_7 = new h("DAY_OF_WEEK", 15, "DayOfWeek", (x)((Object)enum_2), (x)((Object)enum_8), z10, "weekday");
        t = enum_7;
        object4 = j$.time.q.z.i(l10, l12);
        hArray = h18;
        l10 = l12;
        object = object4;
        u = h18 = new h("ALIGNED_DAY_OF_WEEK_IN_MONTH", 16, "AlignedDayOfWeekInMonth", (x)((Object)enum_2), (x)((Object)enum_8), (z)object4);
        object = j$.time.q.z.i(1L, l12);
        hArray = h17;
        v = h17 = new h("ALIGNED_DAY_OF_WEEK_IN_YEAR", 17, "AlignedDayOfWeekInYear", (x)((Object)enum_2), (x)((Object)enum_8), (z)object);
        hArray2 = j$.time.q.i.k;
        long l13 = 1L;
        z10 = j$.time.q.z.j(l13, 28, 31);
        object4 = enum_6;
        enum_6 = new h("DAY_OF_MONTH", 18, "DayOfMonth", (x)((Object)enum_2), (x)hArray2, z10, "day");
        w = enum_6;
        i i11 = j$.time.q.i.l;
        object = j$.time.q.z.j(l13, 365L, 366L);
        hArray = h16;
        x = h16 = new h("DAY_OF_YEAR", 19, "DayOfYear", (x)((Object)enum_2), (x)i11, (z)object);
        i i12 = j$.time.q.i.q;
        object = j$.time.q.z.i(-365249999634L, 365249999634L);
        hArray = h15;
        y = h15 = new h("EPOCH_DAY", 20, "EpochDay", (x)((Object)enum_2), (x)i12, (z)object);
        object = j$.time.q.z.j(1L, 4, 5);
        hArray = enum_2;
        enum_2 = new h("ALIGNED_WEEK_OF_MONTH", 21, "AlignedWeekOfMonth", (x)((Object)enum_8), (x)hArray2, (z)object);
        z = enum_2;
        object = j$.time.q.z.i(1L, 53);
        hArray = h14;
        A = h14 = new h("ALIGNED_WEEK_OF_YEAR", 22, "AlignedWeekOfYear", (x)((Object)enum_8), (x)i11, (z)object);
        z10 = j$.time.q.z.i(1L, 12);
        object4 = enum_8;
        object5 = hArray2;
        enum_8 = new h("MONTH_OF_YEAR", 23, "MonthOfYear", (x)hArray2, (x)i11, z10, "month");
        B = enum_8;
        object = j$.time.q.z.i(-11999999988L, 11999999999L);
        hArray = h13;
        C = h13 = new h("PROLEPTIC_MONTH", 24, "ProlepticMonth", (x)hArray2, (x)i12, (z)object);
        object = j$.time.q.z.j(1L, 999999999L, 1000000000L);
        hArray = hArray2;
        hArray2 = new h("YEAR_OF_ERA", 25, "YearOfEra", (x)i11, (x)i12, (z)object);
        D = hArray2;
        z10 = j$.time.q.z.i(3294967297L, 999999999L);
        object4 = h12;
        object5 = i11;
        E = h12 = new h("YEAR", 26, "Year", (x)i11, (x)i12, z10, "year");
        object5 = j$.time.q.i.p;
        z10 = j$.time.q.z.i(0L, 1L);
        object4 = h11;
        F = h11 = new h("ERA", 27, "Era", (x)object5, (x)i12, z10, "era");
        object = j$.time.q.z.i(Long.MIN_VALUE, Long.MAX_VALUE);
        hArray = object4;
        G = object4 = new h("INSTANT_SECONDS", 28, "InstantSeconds", (x)i10, (x)i12, (z)object);
        object = j$.time.q.z.i(4294902496L, 64800L);
        hArray = h10;
        H = h10 = new h("OFFSET_SECONDS", 29, "OffsetSeconds", (x)i10, (x)i12, (z)object);
        hArray = new h[]{h27, h26, enum_, h25, h24, h23, h22, enum_3, object3, h21, object2, enum_4, h20, h19, enum_5, enum_7, h18, h17, enum_6, h16, h15, enum_2, h14, enum_8, h13, hArray2, h12, h11, object4, h10};
        I = hArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private h(x x10, z z10) {
        void var6_4;
        void var5_3;
        void var2_-1;
        void var1_-1;
        this.a = x10;
        this.b = z10;
        this.c = var5_3;
        this.d = var6_4;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private h(x x11, z z10, String string3) {
        void var6_5;
        void var1_-1;
        this.a = x11;
        this.b = z10;
        this.c = string3;
        this.d = var6_5;
    }

    public static h valueOf(String string2) {
        return Enum.valueOf(h.class, string2);
    }

    public static h[] values() {
        return (h[])I.clone();
    }

    public boolean C() {
        int n10;
        int n11 = this.ordinal();
        n11 = n11 < (n10 = 15) ? 1 : 0;
        return n11 != 0;
    }

    public z D(s s10) {
        return s10.i(this);
    }

    public boolean L(s s10) {
        return s10.g(this);
    }

    public int O(long l10) {
        return this.d.a(l10, this);
    }

    public long P(long l10) {
        this.d.b(l10, this);
        return l10;
    }

    public boolean m() {
        int n10;
        int n11 = this.ordinal();
        n11 = n11 >= (n10 = 15) && (n11 = this.ordinal()) <= (n10 = 27) ? 1 : 0;
        return n11 != 0;
    }

    public r n(r r10, long l10) {
        return r10.c(this, l10);
    }

    public long o(s s10) {
        return s10.h(this);
    }

    public String toString() {
        return this.a;
    }

    public z x() {
        return this.d;
    }
}

