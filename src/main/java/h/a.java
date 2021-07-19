/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.i;
import java.util.Arrays;
import okio.ByteString;
import okio.ByteString$a;

public final class a {
    private static final byte[] a;
    private static final byte[] b;

    static {
        ByteString$a byteString$a = ByteString.Companion;
        a = byteString$a.l("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        b = byteString$a.l("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final byte[] a(String object) {
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        String string2 = "$this$decodeBase64ToArray";
        f0.p(object, string2);
        int n15 = ((String)object).length();
        while (true) {
            int n16;
            n14 = 9;
            n13 = 32;
            n12 = 13;
            n11 = 10;
            if (n15 <= 0) break;
            n10 = n15 + -1;
            if ((n10 = (int)((String)object).charAt(n10)) != (n16 = 61) && n10 != n11 && n10 != n12 && n10 != n13 && n10 != n14) break;
            n15 += -1;
        }
        long l10 = (long)n15 * (long)6;
        long l11 = 8;
        n10 = (int)(l10 /= l11);
        byte[] byArray = new byte[n10];
        int n17 = 0;
        int n18 = 0;
        int n19 = 0;
        int n20 = 0;
        while (true) {
            block15: {
                int n21;
                int n22;
                block10: {
                    block13: {
                        block14: {
                            int n23;
                            block12: {
                                int n24;
                                block11: {
                                    block9: {
                                        n22 = 0;
                                        if (n17 >= n15) break;
                                        n21 = ((String)object).charAt(n17);
                                        n23 = 90;
                                        n24 = 65;
                                        if (n24 > n21 || n23 < n21) break block9;
                                        n21 += -65;
                                        break block10;
                                    }
                                    n23 = 122;
                                    n24 = 97;
                                    if (n24 > n21 || n23 < n21) break block11;
                                    n21 += -71;
                                    break block10;
                                }
                                n23 = 57;
                                n24 = 48;
                                if (n24 > n21 || n23 < n21) break block12;
                                n21 += 4;
                                break block10;
                            }
                            n23 = 43;
                            if (n21 == n23 || n21 == (n23 = 45)) break block13;
                            n23 = 47;
                            if (n21 == n23 || n21 == (n23 = 95)) break block14;
                            if (n21 != n11 && n21 != n12 && n21 != n13 && n21 != n14) {
                                return null;
                            }
                            break block15;
                        }
                        n21 = 63;
                        break block10;
                    }
                    n21 = 62;
                }
                n19 = n19 << 6 | n21;
                n22 = ++n18 % 4;
                if (n22 == 0) {
                    n22 = n20 + 1;
                    byArray[n20] = n21 = (int)((byte)(n19 >> 16));
                    n20 = n22 + 1;
                    byArray[n22] = n21 = (int)((byte)(n19 >> 8));
                    n22 = n20 + 1;
                    byArray[n20] = n21 = (int)((byte)n19);
                    n20 = n22;
                }
            }
            ++n17;
        }
        int n25 = 1;
        if ((n18 %= 4) != n25) {
            n25 = 2;
            if (n18 != n25) {
                n25 = 3;
                if (n18 == n25) {
                    n25 = n19 << 6;
                    n15 = n20 + 1;
                    byArray[n20] = n14 = (int)((byte)(n25 >> 16));
                    n20 = n15 + 1;
                    byArray[n15] = n25 = (int)((byte)(n25 >> 8));
                }
            } else {
                n25 = n19 << 12;
                n15 = n20 + 1;
                byArray[n20] = n25 = (int)((byte)(n25 >> 16));
                n20 = n15;
            }
            if (n20 == n10) {
                return byArray;
            }
            object = Arrays.copyOf(byArray, n20);
            f0.o(object, "java.util.Arrays.copyOf(this, newSize)");
            return object;
        }
        return null;
    }

    public static final String b(byte[] byArray, byte[] byArray2) {
        int n10;
        int n11;
        f0.p(byArray, "$this$encodeBase64");
        f0.p(byArray2, "map");
        int n12 = byArray.length;
        int n13 = 2;
        n12 = (n12 + n13) / 3 * 4;
        byte[] byArray3 = new byte[n12];
        int n14 = byArray.length;
        int n15 = byArray.length % 3;
        n14 -= n15;
        n15 = 0;
        int n16 = 0;
        while (n15 < n14) {
            n11 = n15 + 1;
            n15 = byArray[n15];
            n10 = n11 + 1;
            n11 = byArray[n11];
            int n17 = n10 + 1;
            n10 = byArray[n10];
            int n18 = n16 + 1;
            int n19 = (n15 & 0xFF) >> n13;
            byArray3[n16] = n19 = byArray2[n19];
            n16 = n18 + 1;
            n15 = (n15 & 3) << 4;
            n19 = (n11 & 0xFF) >> 4;
            n15 |= n19;
            byArray3[n18] = n15 = byArray2[n15];
            n15 = n16 + 1;
            n11 = (n11 & 0xF) << n13;
            n18 = (n10 & 0xFF) >> 6;
            n11 |= n18;
            byArray3[n16] = n11 = byArray2[n11];
            n16 = n15 + 1;
            n11 = n10 & 0x3F;
            byArray3[n15] = n11 = byArray2[n11];
            n15 = n17;
        }
        n11 = byArray.length - n14;
        n14 = 61;
        n10 = 1;
        if (n11 != n10) {
            if (n11 == n13) {
                n11 = n15 + 1;
                n15 = byArray[n15];
                int n20 = byArray[n11];
                n11 = n16 + 1;
                n10 = (n15 & 0xFF) >> n13;
                byArray3[n16] = n10 = byArray2[n10];
                n16 = n11 + 1;
                n15 = (n15 & 3) << 4;
                n10 = (n20 & 0xFF) >> 4;
                n15 |= n10;
                byArray3[n11] = n15 = byArray2[n15];
                n15 = n16 + 1;
                n20 = (n20 & 0xF) << n13;
                byArray3[n16] = n20 = byArray2[n20];
                byArray3[n15] = n20 = (int)((byte)n14);
            }
        } else {
            byte by2;
            int n21 = byArray[n15];
            n15 = n16 + 1;
            n11 = n21 & 0xFF;
            n13 = n11 >> 2;
            byArray3[n16] = n13 = byArray2[n13];
            n13 = n15 + 1;
            n21 = (n21 & 3) << 4;
            byArray3[n15] = n21 = byArray2[n21];
            n21 = n13 + 1;
            byArray3[n13] = by2 = (byte)n14;
            byArray3[n21] = by2;
        }
        return i.c(byArray3);
    }

    public static /* synthetic */ String c(byte[] byArray, byte[] byArray2, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            byArray2 = a;
        }
        return h.a.b(byArray, byArray2);
    }

    public static final byte[] d() {
        return a;
    }

    public static final byte[] e() {
        return b;
    }
}

