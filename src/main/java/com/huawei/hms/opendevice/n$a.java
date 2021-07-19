/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.opendevice;

public final class n$a
extends Enum {
    public static final /* enum */ n$a a;
    public static final /* enum */ n$a b;
    public static final /* enum */ n$a c;
    public static final /* enum */ n$a d;
    public static final /* enum */ n$a e;
    public static final /* enum */ n$a f;
    public static final /* enum */ n$a g;
    public static final /* enum */ n$a h;
    public static final /* enum */ n$a i;
    public static final /* enum */ n$a j;
    public static final /* enum */ n$a k;
    public static final /* enum */ n$a l;
    public static final /* enum */ n$a m;
    public static final /* synthetic */ n$a[] n;
    public String o;

    static {
        n$a n$a;
        n$a n$a2;
        n$a n$a3;
        n$a n$a4;
        n$a n$a5;
        n$a n$a6;
        n$a n$a7;
        n$a n$a8;
        n$a n$a9;
        n$a n$a10;
        n$a n$a11;
        n$a n$a12;
        n$a n$a13;
        a = n$a13 = new n$a("MOBILE", 0, "1");
        b = n$a12 = new n$a("PC", 1, "2");
        c = n$a11 = new n$a("TABLET", 2, "3");
        d = n$a10 = new n$a("TV", 3, "4");
        e = n$a9 = new n$a("SOUNDBOX", 4, "5");
        f = n$a8 = new n$a("GLASS", 5, "6");
        g = n$a7 = new n$a("WATCH", 6, "7");
        h = n$a6 = new n$a("VEHICLE", 7, "8");
        i = n$a5 = new n$a("OFFICE_DEVICE", 8, "9");
        j = n$a4 = new n$a("IOT_DEVICES", 9, "10");
        k = n$a3 = new n$a("HEALTHY", 10, "11");
        l = n$a2 = new n$a("ENTERTAINMENT", 11, "12");
        int n10 = 12;
        m = n$a = new n$a("TRANSPORT_DEVICES", n10, "13");
        n$a[] n$aArray = new n$a[13];
        n$aArray[0] = n$a13;
        n$aArray[1] = n$a12;
        n$aArray[2] = n$a11;
        n$aArray[3] = n$a10;
        n$aArray[4] = n$a9;
        n$aArray[5] = n$a8;
        n$aArray[6] = n$a7;
        n$aArray[7] = n$a6;
        n$aArray[8] = n$a5;
        n$aArray[9] = n$a4;
        n$aArray[10] = n$a3;
        n$aArray[11] = n$a2;
        n$aArray[n10] = n$a;
        n = n$aArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public n$a() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.o = var3_1;
    }

    public static n$a valueOf(String string2) {
        return Enum.valueOf(n$a.class, string2);
    }

    public static n$a[] values() {
        return (n$a[])n.clone();
    }

    public String a() {
        return this.o;
    }
}

