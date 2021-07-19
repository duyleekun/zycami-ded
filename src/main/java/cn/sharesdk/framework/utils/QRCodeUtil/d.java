/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

import java.util.HashMap;
import java.util.Map;

public final class d
extends Enum {
    public static final /* enum */ d A;
    private static final Map B;
    private static final Map C;
    private static final /* synthetic */ d[] F;
    public static final /* enum */ d a;
    public static final /* enum */ d b;
    public static final /* enum */ d c;
    public static final /* enum */ d d;
    public static final /* enum */ d e;
    public static final /* enum */ d f;
    public static final /* enum */ d g;
    public static final /* enum */ d h;
    public static final /* enum */ d i;
    public static final /* enum */ d j;
    public static final /* enum */ d k;
    public static final /* enum */ d l;
    public static final /* enum */ d m;
    public static final /* enum */ d n;
    public static final /* enum */ d o;
    public static final /* enum */ d p;
    public static final /* enum */ d q;
    public static final /* enum */ d r;
    public static final /* enum */ d s;
    public static final /* enum */ d t;
    public static final /* enum */ d u;
    public static final /* enum */ d v;
    public static final /* enum */ d w;
    public static final /* enum */ d x;
    public static final /* enum */ d y;
    public static final /* enum */ d z;
    private final int[] D;
    private final String[] E;

    static {
        d d10;
        d d11;
        d d12;
        d d13;
        int n10 = 2;
        Object object = new int[n10];
        object[0] = 0;
        object[1] = 2;
        Object object2 = new String[]{};
        d[] dArray = new d("Cp437", 0, object, (String[])object2);
        a = dArray;
        object = (Object)new d;
        object2 = new int[n10];
        object2[0] = (String)true;
        object2[1] = (String)3;
        Object object3 = new String[]{"ISO-8859-1"};
        object("ISO8859_1", 1, (int[])object2, object3);
        b = (d)((Object)object);
        object3 = new String[]{"ISO-8859-2"};
        Object object4 = 4;
        object2 = new d("ISO8859_2", n10, object4, object3);
        c = object2;
        Object object5 = new String[]{"ISO-8859-3"};
        int n11 = 3;
        int n12 = 5;
        d = object3 = new d("ISO8859_3", n11, n12, object5);
        Object object6 = new String[]{"ISO-8859-4"};
        int n13 = 6;
        e = object5 = new d("ISO8859_4", object4, n13, (String[])object6);
        Object object7 = new String[]{"ISO-8859-5"};
        int n14 = 7;
        object6 = new d("ISO8859_5", n12, n14, object7);
        f = object6;
        Object object8 = new String[]{"ISO-8859-6"};
        n12 = 8;
        g = object7 = new d("ISO8859_6", n13, n12, object8);
        Object object9 = new String[]{"ISO-8859-7"};
        object4 = 9;
        h = object8 = new d("ISO8859_7", n14, object4, object9);
        object9 = new String[]{"ISO-8859-8"};
        int n15 = 10;
        i = d13 = new d("ISO8859_8", n12, n15, object9);
        object9 = new String[]{"ISO-8859-9"};
        int n16 = 11;
        j = d12 = new d("ISO8859_9", object4, n16, object9);
        object9 = new String[]{"ISO-8859-10"};
        k = d11 = new d("ISO8859_10", n15, 12, object9);
        object9 = new String[]{"ISO-8859-11"};
        Object object10 = new d("ISO8859_11", n16, 13, object9);
        l = object10;
        object9 = new String[]{"ISO-8859-13"};
        String[] stringArray = object10;
        Object object11 = new d("ISO8859_13", 12, 15, object9);
        m = object11;
        object10 = new String[]{"ISO-8859-14"};
        String[] stringArray2 = object11;
        Object object12 = new d("ISO8859_14", 13, 16, object10);
        n = object12;
        object10 = new String[]{"ISO-8859-15"};
        String[] stringArray3 = object12;
        object11 = new d("ISO8859_15", 14, 17, object10);
        o = object11;
        object10 = new String[]{"ISO-8859-16"};
        String[] stringArray4 = object11;
        p = d10 = new d("ISO8859_16", 15, 18, object10);
        object10 = new String[]{"Shift_JIS"};
        d d14 = d10;
        object11 = new d("SJIS", 16, 20, object10);
        q = object11;
        object10 = new String[]{"windows-1250"};
        String[] stringArray5 = object11;
        r = d10 = new d("Cp1250", 17, 21, object10);
        object10 = new String[]{"windows-1251"};
        d d15 = d10;
        object11 = new d("Cp1251", 18, 22, object10);
        s = object11;
        object10 = new String[]{"windows-1252"};
        String[] stringArray6 = object11;
        t = d10 = new d("Cp1252", 19, 23, object10);
        object10 = new String[]{"windows-1256"};
        d d16 = d10;
        object12 = new d("Cp1256", 20, 24, object10);
        u = object12;
        object10 = new String[]{"UTF-16BE", "UnicodeBig"};
        String[] stringArray7 = object12;
        v = d10 = new d("UnicodeBigUnmarked", 21, 25, object10);
        object11 = new String[]{"UTF-8"};
        d d17 = d10;
        object12 = new d("UTF8", 22, 26, object11);
        w = object12;
        object10 = new int[2];
        object10[0] = (String)27;
        object10[1] = (String)170;
        object11 = new String[]{"US-ASCII"};
        String[] stringArray8 = object12;
        x = d10 = new d("ASCII", 23, (int[])object10, object11);
        object4 = 28;
        object12 = new d("Big5", 24, object4);
        y = object12;
        object9 = "EUC_CN";
        String[] stringArray9 = object12;
        object12 = new String[]{"GB2312", object9, "GBK"};
        d d18 = d10;
        z = object11 = new d("GB18030", 25, 29, (String[])object12);
        object12 = new String[]{"EUC-KR"};
        object10 = "EUC_KR";
        int n17 = 26;
        Object object13 = object11;
        A = d10 = new d((String)object10, n17, 30, (String[])object12);
        n16 = 27;
        object12 = new d[n16];
        n15 = 0;
        object11 = null;
        object12[0] = dArray;
        object12[1] = (String)object;
        object12[2] = object2;
        object12[3] = object3;
        object12[4] = object5;
        object12[5] = object6;
        object12[6] = object7;
        object12[7] = object8;
        object12[8] = d13;
        object12[9] = d12;
        object12[10] = d11;
        object12[11] = stringArray;
        object12[12] = stringArray2;
        object12[13] = stringArray3;
        object12[14] = stringArray4;
        object12[15] = d14;
        object12[16] = stringArray5;
        object12[17] = d15;
        object12[18] = stringArray6;
        object12[19] = d16;
        object12[20] = stringArray7;
        object12[21] = d17;
        object12[22] = stringArray8;
        object12[23] = d18;
        object12[24] = stringArray9;
        object12[25] = object13;
        int n18 = 26;
        object12[n18] = d10;
        F = object12;
        dArray = new HashMap();
        B = dArray;
        dArray = new HashMap();
        C = dArray;
        dArray = cn.sharesdk.framework.utils.QRCodeUtil.d.values();
        n10 = dArray.length;
        object = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n19;
            object12 = dArray[i10];
            object2 = ((d)object12).D;
            int n20 = ((String[])object2).length;
            object5 = null;
            for (n19 = 0; n19 < n20; ++n19) {
                object4 = object2[n19];
                object6 = B;
                object10 = object4;
                object6.put(object10, object12);
            }
            object2 = C;
            object3 = ((Enum)object12).name();
            object2.put(object3, object12);
            object2 = ((d)object12).E;
            n20 = ((Object)object2).length;
            object5 = null;
            for (n19 = 0; n19 < n20; ++n19) {
                object10 = object2[n19];
                object6 = C;
                object6.put(object10, object12);
            }
        }
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private d() {
        void var2_-1;
        void var1_-1;
        void var3_1;
        int[] nArray = new int[]{var3_1};
        String[] stringArray = new String[]{};
        this((String)var1_-1, (int)var2_-1, nArray, stringArray);
    }

    /*
     * WARNING - void declaration
     */
    private d() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        int[] nArray = new int[]{var3_1};
        this.D = nArray;
        this.E = var4_2;
    }

    /*
     * WARNING - void declaration
     */
    private d() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.D = var3_1;
        this.E = var4_2;
    }

    public static d a(String string2) {
        return (d)((Object)C.get(string2));
    }

    public static d valueOf(String string2) {
        return Enum.valueOf(d.class, string2);
    }

    public static d[] values() {
        return (d[])F.clone();
    }

    public int a() {
        return this.D[0];
    }
}

