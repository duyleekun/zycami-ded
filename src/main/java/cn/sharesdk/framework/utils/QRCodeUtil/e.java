/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

public final class e
extends Enum {
    public static final /* enum */ e a;
    public static final /* enum */ e b;
    public static final /* enum */ e c;
    public static final /* enum */ e d;
    public static final /* enum */ e e;
    public static final /* enum */ e f;
    public static final /* enum */ e g;
    public static final /* enum */ e h;
    public static final /* enum */ e i;
    public static final /* enum */ e j;
    public static final /* enum */ e k;
    public static final /* enum */ e l;
    private static final /* synthetic */ e[] m;

    static {
        e e10;
        e e11;
        e e12;
        e e13;
        e e14;
        e e15;
        e e16;
        e e17;
        e e18;
        e e19;
        e e20;
        e e21;
        a = e21 = new e("ERROR_CORRECTION", 0);
        int n10 = 1;
        b = e20 = new e("CHARACTER_SET", n10);
        c = e19 = new e("DATA_MATRIX_SHAPE", 2);
        d = e18 = new e("MIN_SIZE", 3);
        e = e17 = new e("MAX_SIZE", 4);
        f = e16 = new e("MARGIN", 5);
        g = e15 = new e("PDF417_COMPACT", 6);
        h = e14 = new e("PDF417_COMPACTION", 7);
        i = e13 = new e("PDF417_DIMENSIONS", 8);
        j = e12 = new e("AZTEC_LAYERS", 9);
        k = e11 = new e("QR_VERSION", 10);
        int n11 = 11;
        l = e10 = new e("GS1_FORMAT", n11);
        e[] eArray = new e[12];
        eArray[0] = e21;
        eArray[n10] = e20;
        eArray[2] = e19;
        eArray[3] = e18;
        eArray[4] = e17;
        eArray[5] = e16;
        eArray[6] = e15;
        eArray[7] = e14;
        eArray[8] = e13;
        eArray[9] = e12;
        eArray[10] = e11;
        eArray[n11] = e10;
        m = eArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private e() {
        void var2_-1;
        void var1_-1;
    }

    public static e valueOf(String string2) {
        return Enum.valueOf(e.class, string2);
    }

    public static e[] values() {
        return (e[])m.clone();
    }
}

