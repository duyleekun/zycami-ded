/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

import cn.sharesdk.framework.utils.QRCodeUtil.n;

public final class i
extends Enum {
    public static final /* enum */ i a;
    public static final /* enum */ i b;
    public static final /* enum */ i c;
    public static final /* enum */ i d;
    public static final /* enum */ i e;
    public static final /* enum */ i f;
    public static final /* enum */ i g;
    public static final /* enum */ i h;
    public static final /* enum */ i i;
    public static final /* enum */ i j;
    private static final /* synthetic */ i[] m;
    private final int[] k;
    private final int l;

    static {
        i i10;
        i i11;
        int[] nArray;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        i i12;
        Object object7;
        int n10 = 3;
        int[] nArray2 = object7 = new int[n10];
        object7[0] = 0;
        nArray2[1] = 0;
        nArray2[2] = 0;
        a = i12 = new i("TERMINATOR", 0, object7, 0);
        object7 = (Object)new i;
        int[] nArray3 = object6 = new int[n10];
        object6[0] = 10;
        nArray3[1] = 12;
        nArray3[2] = 14;
        int n11 = 1;
        object7("NUMERIC", n11, object6, n11);
        b = (i)((Object)object7);
        object6 = (Object)new i;
        int[] nArray4 = object5 = new int[n10];
        object5[0] = 9;
        nArray4[1] = 11;
        nArray4[2] = 13;
        int n12 = 2;
        object6("ALPHANUMERIC", n12, object5, n12);
        c = (i)((Object)object6);
        object5 = (Object)new i;
        int[] nArray5 = object4 = new int[n10];
        object4[0] = 0;
        nArray5[1] = 0;
        nArray5[2] = 0;
        object5("STRUCTURED_APPEND", n10, object4, n10);
        d = (i)((Object)object5);
        object4 = (Object)new i;
        int[] nArray6 = object3 = new int[n10];
        object3[0] = 8;
        nArray6[1] = 16;
        nArray6[2] = 16;
        int n13 = 4;
        object4("BYTE", n13, object3, n13);
        e = (i)((Object)object4);
        object3 = (Object)new i;
        int[] nArray7 = object2 = new int[n10];
        object2[0] = 0;
        nArray7[1] = 0;
        nArray7[2] = 0;
        int n14 = 5;
        int n15 = 7;
        object3("ECI", n14, object2, n15);
        f = (i)((Object)object3);
        object2 = (Object)new i;
        int[] nArray8 = object = new int[n10];
        object[0] = 8;
        nArray8[1] = 10;
        nArray8[2] = 12;
        n12 = 8;
        object2("KANJI", 6, object, n12);
        g = (i)((Object)object2);
        object = (Object)new i;
        int[] nArray9 = nArray = new int[n10];
        nArray[0] = 0;
        nArray9[1] = 0;
        nArray9[2] = 0;
        object("FNC1_FIRST_POSITION", n15, nArray, n14);
        h = (i)((Object)object);
        int[] nArray10 = nArray = new int[n10];
        nArray[0] = 0;
        nArray10[1] = 0;
        nArray10[2] = 0;
        n14 = 9;
        i = i11 = new i("FNC1_SECOND_POSITION", n12, nArray, n14);
        int[] nArray11 = nArray = new int[n10];
        nArray[0] = 8;
        nArray11[1] = 10;
        nArray11[2] = 12;
        j = i10 = new i("HANZI", n14, nArray, 13);
        i[] iArray = new i[10];
        iArray[0] = i12;
        iArray[n11] = (i)((Object)object7);
        iArray[2] = (i)((Object)object6);
        iArray[3] = (i)((Object)object5);
        iArray[4] = (i)((Object)object4);
        iArray[5] = (i)((Object)object3);
        iArray[6] = (i)((Object)object2);
        iArray[7] = (i)((Object)object);
        iArray[8] = i11;
        iArray[n14] = i10;
        m = iArray;
    }

    /*
     * WARNING - void declaration
     */
    private i() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.k = var3_1;
        this.l = var4_2;
    }

    public static i valueOf(String string2) {
        return Enum.valueOf(i.class, string2);
    }

    public static i[] values() {
        return (i[])m.clone();
    }

    public int a() {
        return this.l;
    }

    public int a(n n10) {
        int n11;
        int n12 = n10.a();
        if (n12 <= (n11 = 9)) {
            n12 = 0;
            n10 = null;
        } else {
            n11 = 26;
            n12 = n12 <= n11 ? 1 : 2;
        }
        return this.k[n12];
    }
}

