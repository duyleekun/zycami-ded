/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bc;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ay {
    private static int a = 8;
    private byte[] a;
    private int b;
    private int c;
    private int d = -666;

    public ay() {
        byte[] byArray = new byte[256];
        this.a = byArray;
        this.c = 0;
        this.b = 0;
    }

    public static int a(byte by2) {
        if (by2 >= 0) {
            return by2;
        }
        return by2 + 256;
    }

    private void a() {
        this.c = 0;
        this.b = 0;
    }

    private void a(int n10, byte[] object, boolean bl2) {
        int n11;
        byte by2;
        byte[] byArray;
        int n12;
        int n13;
        int n14 = ((Object)object).length;
        int n15 = 0;
        String string2 = null;
        Object object2 = null;
        for (n13 = 0; n13 < (n12 = 256); ++n13) {
            byArray = this.a;
            byArray[n13] = by2 = (byte)n13;
        }
        this.c = 0;
        this.b = 0;
        while (true) {
            n13 = this.b;
            by2 = 1;
            if (n13 >= n10) break;
            n11 = this.c;
            byte[] byArray2 = this.a;
            n13 = ay.a(byArray2[n13]);
            n11 += n13;
            n13 = this.b % n14;
            n13 = ay.a((byte)object[n13]);
            this.c = n11 = (n11 + n13) % n12;
            object2 = this.a;
            int n16 = this.b;
            ay.a(object2, n16, n11);
            this.b = n13 = this.b + by2;
        }
        if (n10 != n12) {
            n13 = this.c;
            byte[] byArray3 = this.a;
            n11 = ay.a(byArray3[n10]);
            n13 += n11;
            n14 = n10 % n14;
            int n17 = ay.a((byte)object[n14]);
            this.d = n13 = (n13 + n17) % n12;
        }
        if (bl2) {
            object = new StringBuilder();
            String string3 = "S_";
            ((StringBuilder)object).append(string3);
            int n18 = n10 + -1;
            ((StringBuilder)object).append(n18);
            Object object3 = ":";
            ((StringBuilder)object).append((String)object3);
            while (n15 <= n10) {
                ((StringBuilder)object).append(" ");
                object3 = this.a;
                n14 = ay.a((byte)object3[n15]);
                ((StringBuilder)object).append(n14);
                ++n15;
            }
            object3 = "   j_";
            ((StringBuilder)object).append((String)object3);
            ((StringBuilder)object).append(n18);
            string2 = "=";
            ((StringBuilder)object).append(string2);
            n13 = this.c;
            ((StringBuilder)object).append(n13);
            ((StringBuilder)object).append((String)object3);
            ((StringBuilder)object).append(n10);
            ((StringBuilder)object).append(string2);
            n14 = this.d;
            ((StringBuilder)object).append(n14);
            object3 = "   S_";
            ((StringBuilder)object).append((String)object3);
            ((StringBuilder)object).append(n18);
            string2 = "[j_";
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(n18);
            object2 = "]=";
            ((StringBuilder)object).append((String)object2);
            byArray = this.a;
            n11 = this.c;
            n12 = ay.a(byArray[n11]);
            ((StringBuilder)object).append(n12);
            ((StringBuilder)object).append((String)object3);
            ((StringBuilder)object).append(n18);
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(n10);
            ((StringBuilder)object).append((String)object2);
            Object object4 = this.a;
            int n19 = this.d;
            n10 = ay.a(object4[n19]);
            ((StringBuilder)object).append(n10);
            object4 = this.a;
            n10 = object4[by2];
            if (n10 != 0) {
                object4 = "   S[1]!=0";
                ((StringBuilder)object).append((String)object4);
            }
            object4 = ((StringBuilder)object).toString();
            com.xiaomi.channel.commonutils.logger.b.a((String)object4);
        }
    }

    private void a(byte[] byArray) {
        this.a(256, byArray, false);
    }

    private static void a(byte[] byArray, int n10, int n11) {
        byte by2;
        byte by3 = byArray[n10];
        byArray[n10] = by2 = byArray[n11];
        byArray[n11] = by3;
    }

    public static byte[] a(String object, String object2) {
        Object object3;
        int n10;
        object = bc.a((String)object);
        object2 = ((String)object2).getBytes();
        int n11 = ((Object)object).length + 1;
        int n12 = ((Object)object2).length;
        byte[] byArray = new byte[n11 += n12];
        n12 = 0;
        for (n10 = 0; n10 < (object3 = ((Object)object).length); ++n10) {
            byArray[n10] = object3 = (Object)object[n10];
        }
        n10 = ((Object)object).length;
        byArray[n10] = object3 = 95;
        while (n12 < (n10 = ((Object)object2).length)) {
            n10 = ((Object)object).length + 1 + n12;
            byArray[n10] = object3 = (Object)object2[n12];
            ++n12;
        }
        return byArray;
    }

    public static byte[] a(byte[] byArray, String object) {
        object = bc.a((String)object);
        return ay.a(byArray, (byte[])object);
    }

    public static byte[] a(byte[] byArray, byte[] byArray2) {
        int n10;
        int n11 = byArray2.length;
        byte[] byArray3 = new byte[n11];
        ay ay2 = new ay();
        ay2.a(byArray);
        ay2.a();
        byArray = null;
        for (int i10 = 0; i10 < (n10 = byArray2.length); ++i10) {
            n10 = byArray2[i10];
            byte by2 = ay2.a();
            byArray3[i10] = n10 = (int)((byte)(n10 ^ by2));
        }
        return byArray3;
    }

    public static byte[] a(byte[] object, byte[] object2, boolean bl2, int n10, int n11) {
        int n12;
        int n13;
        if (n10 >= 0 && n10 <= (n13 = ((byte[])object2).length) && (n13 = n10 + n11) <= (n12 = ((Object)object2).length)) {
            Object object3;
            n13 = 0;
            if (!bl2) {
                object3 = new byte[n11];
                n12 = 0;
            } else {
                object3 = object2;
                n12 = n10;
            }
            ay ay2 = new ay();
            ay2.a((byte[])object);
            ay2.a();
            while (n13 < n11) {
                int n14 = n12 + n13;
                Object object4 = n10 + n13;
                object4 = object2[object4];
                byte by2 = ay2.a();
                object4 = (byte)(object4 ^ by2);
                object3[n14] = object4;
                ++n13;
            }
            return object3;
        }
        object = new IllegalArgumentException;
        object2 = new StringBuilder;
        ((StringBuilder)object2)();
        ((StringBuilder)object2).append("start = ");
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append(" len = ");
        ((StringBuilder)object2).append(n11);
        object2 = ((StringBuilder)object2).toString();
        object((String)object2);
        throw object;
    }

    public byte a() {
        int n10;
        this.b = n10 = (this.b + 1) % 256;
        int n11 = this.c;
        n10 = ay.a(this.a[n10]);
        this.c = n11 = (n11 + n10) % 256;
        byte[] byArray = this.a;
        int n12 = this.b;
        ay.a(byArray, n12, n11);
        byArray = this.a;
        n11 = this.b;
        n11 = ay.a(byArray[n11]);
        byte[] byArray2 = this.a;
        int n13 = this.c;
        n12 = ay.a(byArray2[n13]);
        n11 = (n11 + n12) % 256;
        return byArray[n11];
    }
}

