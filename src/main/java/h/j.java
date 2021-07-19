/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.q0.b;

public final class j {
    public static final int a(byte by2, int n10) {
        return by2 & n10;
    }

    public static final long b(byte by2, long l10) {
        return (long)by2 & l10;
    }

    public static final long c(int n10, long l10) {
        return (long)n10 & l10;
    }

    public static final boolean d(byte[] byArray, int n10, byte[] byArray2, int n11, int n12) {
        f0.p(byArray, "a");
        f0.p(byArray2, "b");
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13 = i10 + n10;
            n13 = byArray[n13];
            int n14 = i10 + n11;
            if (n13 == (n14 = byArray2[n14])) continue;
            return false;
        }
        return true;
    }

    public static final void e(long l10, long l11, long l12) {
        long l13;
        long l14 = l11 | l12;
        long l15 = 0L;
        long l16 = l14 - l15;
        Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object >= 0 && (object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1)) <= 0 && (object = (l13 = (l14 = l10 - l11) - l12) == 0L ? 0 : (l13 < 0L ? -1 : 1)) >= 0) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=");
        stringBuilder.append(l10);
        stringBuilder.append(" offset=");
        stringBuilder.append(l11);
        stringBuilder.append(" byteCount=");
        stringBuilder.append(l12);
        String string2 = stringBuilder.toString();
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(string2);
        throw arrayIndexOutOfBoundsException;
    }

    public static final long f(int n10, long l10) {
        return Math.min((long)n10, l10);
    }

    public static final long g(long l10, int n10) {
        long l11 = n10;
        return Math.min(l10, l11);
    }

    public static final int h(int n10) {
        int n11 = (0xFF000000 & n10) >>> 24;
        int n12 = (0xFF0000 & n10) >>> 8;
        n11 |= n12;
        n12 = (0xFF00 & n10) << 8;
        return (n10 & 0xFF) << 24 | (n11 |= n12);
    }

    public static final long i(long l10) {
        long l11 = 0xFF00000000000000L & l10;
        int n10 = 56;
        l11 >>>= n10;
        long l12 = 0xFF000000000000L & l10;
        int n11 = 40;
        l11 |= (l12 >>>= n11);
        l12 = 0xFF0000000000L & l10;
        int n12 = 24;
        l11 |= (l12 >>>= n12);
        l12 = 0xFF00000000L & l10;
        int n13 = 8;
        l11 |= (l12 >>>= n13);
        l12 = (0xFF000000L & l10) << n13;
        l11 |= l12;
        l12 = (0xFF0000L & l10) << n12;
        l11 |= l12;
        l12 = (0xFF00L & l10) << n11;
        return (l10 & 0xFFL) << n10 | (l11 |= l12);
    }

    public static final short j(short s10) {
        s10 = (short)(s10 & (char)-1);
        int n10 = (0xFF00 & s10) >>> 8;
        return (short)((s10 & 0xFF) << 8 | n10);
    }

    public static final int k(byte by2, int n10) {
        return by2 << n10;
    }

    public static final int l(byte by2, int n10) {
        return by2 >> n10;
    }

    public static final String m(byte by2) {
        char c10;
        char[] cArray = new char[2];
        char[] cArray2 = b.I();
        int n10 = by2 >> 4 & 0xF;
        cArray[0] = c10 = cArray2[n10];
        cArray2 = b.I();
        by2 = (byte)(by2 & 0xF);
        by2 = (byte)cArray2[by2];
        cArray[1] = (char)by2;
        String string2 = new String(cArray);
        return string2;
    }

    public static final String n(int n10) {
        if (n10 == 0) {
            return "0";
        }
        int n11 = 8;
        char[] cArray = new char[n11];
        char[] cArray2 = b.I();
        int n12 = n10 >> 28 & 0xF;
        int n13 = cArray2[n12];
        cArray[0] = n13;
        cArray2 = b.I();
        int n14 = n10 >> 24 & 0xF;
        cArray[1] = n13 = cArray2[n14];
        char[] cArray3 = b.I();
        int n15 = n10 >> 20 & 0xF;
        cArray[2] = n14 = cArray3[n15];
        cArray3 = b.I();
        n15 = n10 >> 16 & 0xF;
        cArray[3] = n14 = cArray3[n15];
        cArray2 = b.I();
        n14 = n10 >> 12 & 0xF;
        cArray[4] = n13 = cArray2[n14];
        cArray3 = b.I();
        n15 = n10 >> 8 & 0xF;
        cArray[5] = n14 = cArray3[n15];
        cArray3 = b.I();
        n15 = n10 >> 4 & 0xF;
        cArray[6] = n14 = cArray3[n15];
        n13 = 7;
        cArray3 = b.I();
        n10 &= 0xF;
        cArray[n13] = n10 = cArray3[n10];
        for (n12 = 0; n12 < n11 && (n10 = cArray[n12]) == (n13 = 48); ++n12) {
        }
        n10 = 8 - n12;
        String string2 = new String(cArray, n12, n10);
        return string2;
    }

    public static final String o(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return "0";
        }
        object = 16;
        char[] cArray = new char[object];
        char[] cArray2 = b.I();
        long l13 = l10 >> 60;
        long l14 = 15;
        int n10 = (int)(l13 &= l14);
        int n11 = cArray2[n10];
        cArray[0] = n11;
        cArray2 = b.I();
        int n12 = (int)(l10 >> 56 & l14);
        cArray[1] = n11 = cArray2[n12];
        char[] cArray3 = b.I();
        long l15 = l10 >> 52 & l14;
        int n13 = (int)l15;
        cArray[2] = n12 = cArray3[n13];
        cArray3 = b.I();
        n13 = 48;
        int n14 = (int)(l10 >> n13 & l14);
        cArray[3] = n12 = cArray3[n14];
        cArray2 = b.I();
        n12 = (int)(l10 >> 44 & l14);
        n11 = cArray2[n12];
        n12 = 4;
        cArray[n12] = n11;
        char[] cArray4 = b.I();
        int n15 = (int)(l10 >> 40 & l14);
        cArray[5] = n14 = cArray4[n15];
        cArray4 = b.I();
        n15 = (int)(l10 >> 36 & l14);
        cArray[6] = n14 = cArray4[n15];
        cArray4 = b.I();
        n15 = (int)(l10 >> 32 & l14);
        cArray[7] = n14 = cArray4[n15];
        cArray2 = b.I();
        long l16 = l10 >> 28 & l14;
        n14 = (int)l16;
        n11 = cArray2[n14];
        n14 = 8;
        cArray[n14] = n11;
        char[] cArray5 = b.I();
        int n16 = (int)(l10 >> 24 & l14);
        cArray[9] = n15 = cArray5[n16];
        cArray5 = b.I();
        n16 = (int)(l10 >> 20 & l14);
        cArray[10] = n15 = cArray5[n16];
        cArray5 = b.I();
        n16 = (int)(l10 >> object & l14);
        cArray[11] = n15 = cArray5[n16];
        cArray2 = b.I();
        n15 = 12;
        n16 = (int)(l10 >> n15 & l14);
        cArray[n15] = n11 = cArray2[n16];
        cArray5 = b.I();
        long l17 = l10 >> n14 & l14;
        n14 = (int)l17;
        cArray[13] = n14 = cArray5[n14];
        cArray4 = b.I();
        long l18 = l10 >> n12 & l14;
        n12 = (int)l18;
        cArray[14] = n12 = cArray4[n12];
        n11 = 15;
        cArray3 = b.I();
        int n17 = (int)(l10 &= l14);
        cArray[n11] = n17 = cArray3[n17];
        for (n10 = 0; n10 < object && (n17 = cArray[n10]) == n13; ++n10) {
        }
        n17 = 16 - n10;
        String string2 = new String(cArray, n10, n17);
        return string2;
    }
}

