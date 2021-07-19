/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

public final class a
extends Enum {
    public static final /* enum */ a a;
    public static final /* enum */ a b;
    public static final /* enum */ a c;
    public static final /* enum */ a d;
    public static final /* enum */ a e;
    public static final /* enum */ a f;
    public static final /* enum */ a g;
    public static final /* enum */ a h;
    public static final /* enum */ a i;
    public static final /* enum */ a j;
    public static final /* enum */ a k;
    public static final /* enum */ a l;
    public static final /* enum */ a m;
    public static final /* enum */ a n;
    public static final /* enum */ a o;
    public static final /* enum */ a p;
    public static final /* enum */ a q;
    private static final /* synthetic */ a[] r;

    static {
        a a10;
        a a11;
        a a12;
        a a13;
        a a14;
        a a15;
        a a16;
        a a17;
        a a18;
        a a19;
        a a20;
        a a21;
        a a22;
        a a23;
        a a24;
        a = a24 = new a("AZTEC", 0);
        b = a23 = new a("CODABAR", 1);
        c = a22 = new a("CODE_39", 2);
        d = a21 = new a("CODE_93", 3);
        e = a20 = new a("CODE_128", 4);
        f = a19 = new a("DATA_MATRIX", 5);
        g = a18 = new a("EAN_8", 6);
        h = a17 = new a("EAN_13", 7);
        i = a16 = new a("ITF", 8);
        j = a15 = new a("MAXICODE", 9);
        k = a14 = new a("PDF_417", 10);
        l = a13 = new a("QR_CODE", 11);
        m = a12 = new a("RSS_14", 12);
        n = a11 = new a("RSS_EXPANDED", 13);
        a a25 = a11;
        a[] aArray = new a("UPC_A", 14);
        o = aArray;
        a[] aArray2 = aArray;
        p = a10 = new a("UPC_E", 15);
        int n10 = 16;
        q = a11 = new a("UPC_EAN_EXTENSION", n10);
        aArray = new a[17];
        aArray[0] = a24;
        aArray[1] = a23;
        aArray[2] = a22;
        aArray[3] = a21;
        aArray[4] = a20;
        aArray[5] = a19;
        aArray[6] = a18;
        aArray[7] = a17;
        aArray[8] = a16;
        aArray[9] = a15;
        aArray[10] = a14;
        aArray[11] = a13;
        aArray[12] = a12;
        aArray[13] = a25;
        aArray[14] = aArray2;
        aArray[15] = a10;
        aArray[n10] = a11;
        r = aArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private a() {
        void var2_-1;
        void var1_-1;
    }

    public static a valueOf(String string2) {
        return Enum.valueOf(a.class, string2);
    }

    public static a[] values() {
        return (a[])r.clone();
    }
}

