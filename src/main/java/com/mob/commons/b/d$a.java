/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.b;

import com.mob.commons.k;

public final class d$a
extends Enum {
    public static final /* enum */ d$a a;
    public static final /* enum */ d$a b;
    public static final /* enum */ d$a c;
    public static final /* enum */ d$a d;
    public static final /* enum */ d$a e;
    public static final /* enum */ d$a f;
    public static final /* enum */ d$a g;
    public static final /* enum */ d$a h;
    public static final /* enum */ d$a i;
    public static final /* enum */ d$a j;
    public static final /* enum */ d$a k;
    public static final /* enum */ d$a l;
    public static final /* enum */ d$a m;
    public static final /* enum */ d$a n;
    public static final /* enum */ d$a o;
    public static final /* enum */ d$a p;
    public static final /* enum */ d$a q;
    private static final /* synthetic */ d$a[] t;
    private int r;
    private String s;

    static {
        d$a d$a;
        d$a d$a2;
        d$a d$a3;
        d$a d$a4;
        d$a d$a5;
        d$a d$a6;
        Object object = com.mob.commons.k.a(103);
        a = d$a6 = new d$a("UNSUPPORT", 0, -1, object);
        Object object2 = com.mob.commons.k.a(104);
        int n10 = 1;
        object = new d$a("HUA_WEI", n10, 0, object2);
        b = object;
        Object object3 = com.mob.commons.k.a(105);
        int n11 = 2;
        object2 = new d$a("XIAOMI", n11, n10, object3);
        c = object2;
        Object object4 = com.mob.commons.k.a(106);
        int n12 = 3;
        object3 = new d$a("VIVO", n12, n11, object4);
        d = object3;
        Object object5 = com.mob.commons.k.a(107);
        int n13 = 4;
        object4 = new d$a("OPPO", n13, n12, object5);
        e = object4;
        Object object6 = com.mob.commons.k.a(108);
        int n14 = 5;
        object5 = new d$a("MOTO", n14, n13, object6);
        f = object5;
        Object object7 = com.mob.commons.k.a(109);
        int n15 = 6;
        object6 = new d$a("LENOVO", n15, n14, object7);
        g = object6;
        Object object8 = com.mob.commons.k.a(110);
        n13 = 7;
        object7 = new d$a("ASUS", n13, n15, object8);
        h = object7;
        object8 = com.mob.commons.k.a(111);
        n12 = 8;
        i = d$a5 = new d$a("SAMSUNG", n12, n13, object8);
        String string2 = com.mob.commons.k.a(112);
        n11 = 9;
        object8 = new d$a("MEIZU", n11, n12, string2);
        j = object8;
        string2 = com.mob.commons.k.a(113);
        n10 = 10;
        k = d$a4 = new d$a("ALPS", n10, n11, string2);
        string2 = com.mob.commons.k.a(114);
        int n16 = 11;
        l = d$a3 = new d$a("NUBIA", n16, n10, string2);
        string2 = com.mob.commons.k.a(133);
        d$a d$a7 = d$a3;
        n12 = 12;
        m = d$a2 = new d$a("ONEPLUS", n12, n16, string2);
        string2 = com.mob.commons.k.a(134);
        d$a d$a8 = d$a2;
        n11 = 13;
        d$a[] d$aArray = new d$a("BLACKSHARK", n11, n12, string2);
        n = d$aArray;
        string2 = com.mob.commons.k.a(135);
        d$a[] d$aArray2 = d$aArray;
        n10 = 14;
        o = d$a = new d$a("ZTE", n10, n11, string2);
        string2 = com.mob.commons.k.a(136);
        n16 = 15;
        p = d$a3 = new d$a("FERRMEOS", n16, n10, string2);
        string2 = com.mob.commons.k.a(137);
        n12 = 16;
        q = d$a2 = new d$a("SSUI", n12, n16, string2);
        d$aArray = new d$a[17];
        d$aArray[0] = d$a6;
        d$aArray[1] = object;
        d$aArray[2] = object2;
        d$aArray[3] = object3;
        d$aArray[4] = object4;
        d$aArray[5] = object5;
        d$aArray[6] = object6;
        d$aArray[7] = object7;
        d$aArray[8] = d$a5;
        d$aArray[9] = object8;
        d$aArray[10] = d$a4;
        d$aArray[11] = d$a7;
        d$aArray[12] = d$a8;
        d$aArray[13] = d$aArray2;
        d$aArray[14] = d$a;
        d$aArray[n16] = d$a3;
        d$aArray[n12] = d$a2;
        t = d$aArray;
    }

    /*
     * WARNING - void declaration
     */
    private d$a() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.r = var3_1;
        this.s = var4_2;
    }

    public static /* synthetic */ String a(d$a d$a) {
        return d$a.s;
    }

    public static d$a valueOf(String string2) {
        return Enum.valueOf(d$a.class, string2);
    }

    public static d$a[] values() {
        return (d$a[])t.clone();
    }
}

