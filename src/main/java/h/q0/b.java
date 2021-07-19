/*
 * Decompiled with CFR 0.151.
 */
package h.q0;

import f.h2.t.f0;
import f.q2.u;
import f.x1.n;
import h.a;
import h.i;
import h.j;
import h.m;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import okio.ByteString;

public final class b {
    private static final char[] a;

    static {
        char[] cArray;
        char[] cArray2 = cArray = new char[16];
        char[] cArray3 = cArray;
        cArray2[0] = 48;
        cArray3[1] = 49;
        cArray2[2] = 50;
        cArray3[3] = 51;
        cArray2[4] = 52;
        cArray3[5] = 53;
        cArray2[6] = 54;
        cArray3[7] = 55;
        cArray2[8] = 56;
        cArray3[9] = 57;
        cArray2[10] = 97;
        cArray3[11] = 98;
        cArray2[12] = 99;
        cArray3[13] = 100;
        cArray2[14] = 101;
        cArray3[15] = 102;
        a = cArray;
    }

    public static final ByteString A(ByteString object) {
        byte[] byArray;
        int n10;
        f0.p(object, "$this$commonToAsciiLowercase");
        ByteString byteString = null;
        for (Object object2 = 0; object2 < (n10 = (byArray = ((ByteString)object).getData$okio()).length); ++object2) {
            byte by2;
            byte by3;
            byArray = ((ByteString)object).getData$okio();
            n10 = byArray[object2];
            if (n10 < (by3 = (byte)65) || n10 > (by2 = (byte)90)) continue;
            object = ((ByteString)object).getData$okio();
            int n11 = ((Object)object).length;
            object = Arrays.copyOf((byte[])object, n11);
            String string2 = "java.util.Arrays.copyOf(this, size)";
            f0.o(object, string2);
            n10 = (byte)(n10 + 32);
            object[object2] = n10;
            for (n11 = object2 + 1; n11 < (object2 = ((Object)object).length); ++n11) {
                object2 = object[n11];
                if (object2 < by3 || object2 > by2) continue;
                object2 = (byte)(object2 + 32);
                object[n11] = object2;
            }
            byteString = new ByteString((byte[])object);
            return byteString;
        }
        return object;
    }

    public static final ByteString B(ByteString object) {
        byte[] byArray;
        int n10;
        f0.p(object, "$this$commonToAsciiUppercase");
        ByteString byteString = null;
        for (Object object2 = 0; object2 < (n10 = (byArray = ((ByteString)object).getData$okio()).length); ++object2) {
            byte by2;
            byte by3;
            byArray = ((ByteString)object).getData$okio();
            n10 = byArray[object2];
            if (n10 < (by3 = (byte)97) || n10 > (by2 = (byte)122)) continue;
            object = ((ByteString)object).getData$okio();
            int n11 = ((Object)object).length;
            object = Arrays.copyOf((byte[])object, n11);
            String string2 = "java.util.Arrays.copyOf(this, size)";
            f0.o(object, string2);
            n10 = (byte)(n10 + -32);
            object[object2] = n10;
            for (n11 = object2 + 1; n11 < (object2 = ((Object)object).length); ++n11) {
                object2 = object[n11];
                if (object2 < by3 || object2 > by2) continue;
                object2 = (byte)(object2 + -32);
                object[n11] = object2;
            }
            byteString = new ByteString((byte[])object);
            return byteString;
        }
        return object;
    }

    public static final byte[] C(ByteString object) {
        f0.p(object, "$this$commonToByteArray");
        object = ((ByteString)object).getData$okio();
        int n10 = ((Object)object).length;
        object = Arrays.copyOf((byte[])object, n10);
        f0.o(object, "java.util.Arrays.copyOf(this, size)");
        return object;
    }

    public static final ByteString D(byte[] byArray, int n10, int n11) {
        f0.p(byArray, "$this$commonToByteString");
        long l10 = byArray.length;
        long l11 = n10;
        long l12 = n11;
        j.e(l10, l11, l12);
        byArray = n.G1(byArray, n10, n11 += n10);
        ByteString byteString = new ByteString(byArray);
        return byteString;
    }

    public static final String E(ByteString byteString) {
        String string2;
        char c10;
        String string3;
        String string4;
        int n10;
        int n11;
        Object object;
        Object object2;
        block10: {
            block13: {
                block12: {
                    Object object3;
                    int n12;
                    int n13;
                    block11: {
                        object2 = byteString;
                        f0.p(byteString, "$this$commonToString");
                        object = byteString.getData$okio();
                        n11 = ((byte[])object).length;
                        n10 = 1;
                        string4 = null;
                        if (n11 == 0) {
                            n11 = n10;
                        } else {
                            n11 = 0;
                            object = null;
                        }
                        if (n11 != 0) {
                            return "[size=0]";
                        }
                        object = byteString.getData$okio();
                        n13 = 64;
                        n11 = b.c(object, n13);
                        n12 = -1;
                        string3 = "\u2026]";
                        c10 = ']';
                        string2 = "[size=";
                        if (n11 != n12) break block10;
                        object = byteString.getData$okio();
                        n11 = ((byte[])object).length;
                        if (n11 > n13) break block11;
                        object = new StringBuilder;
                        object();
                        String string5 = "[hex=";
                        object.append(string5);
                        object2 = byteString.hex();
                        object.append((String)object2);
                        object.append(c10);
                        object = object.toString();
                        break block12;
                    }
                    object = new StringBuilder;
                    object();
                    object.append(string2);
                    n12 = byteString.getData$okio().length;
                    object.append(n12);
                    object.append(" hex=");
                    byte[] byArray = byteString.getData$okio();
                    n12 = byArray.length;
                    if (n13 > n12) {
                        n10 = 0;
                        object3 = null;
                    }
                    if (n10 == 0) break block13;
                    object3 = byteString.getData$okio();
                    n10 = ((byte[])object3).length;
                    if (n13 != n10) {
                        object3 = new ByteString;
                        object2 = n.G1(byteString.getData$okio(), 0, n13);
                        object3((byte[])object2);
                        object2 = object3;
                    }
                    object2 = ((ByteString)object2).hex();
                    object.append((String)object2);
                    object.append(string3);
                    object = object.toString();
                }
                return object;
            }
            object = new StringBuilder();
            object.append("endIndex > length(");
            int n14 = byteString.getData$okio().length;
            object.append(n14);
            object.append(')');
            object = object.toString();
            object = object.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        String string6 = byteString.utf8();
        String string7 = "null cannot be cast to non-null type java.lang.String";
        Objects.requireNonNull(string6, string7);
        String string8 = string6.substring(0, n11);
        f0.o(string8, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        int n15 = 4;
        String string9 = u.g2(string8, "\\", "\\\\", false, n15, null);
        int n16 = 4;
        String string10 = "\n";
        String string11 = "\\n";
        string8 = u.g2(string9, string10, string11, false, n16, null);
        String string12 = "\r";
        String string13 = "\\r";
        string4 = u.g2(string8, string12, string13, false, n15, null);
        n10 = string6.length();
        if (n11 < n10) {
            object = new StringBuilder();
            object.append(string2);
            int n17 = byteString.getData$okio().length;
            object.append(n17);
            object2 = " text=";
            object.append((String)object2);
            object.append(string4);
            object.append(string3);
            object = object.toString();
        } else {
            object = new StringBuilder();
            object2 = "[text=";
            object.append((String)object2);
            object.append(string4);
            object.append(c10);
            object = object.toString();
        }
        return object;
    }

    public static final String F(ByteString byteString) {
        f0.p(byteString, "$this$commonUtf8");
        String string2 = byteString.getUtf8$okio();
        if (string2 == null) {
            string2 = i.c(byteString.internalArray$okio());
            byteString.setUtf8$okio(string2);
        }
        return string2;
    }

    public static final void G(ByteString object, m m10, int n10, int n11) {
        f0.p(object, "$this$commonWrite");
        f0.p(m10, "buffer");
        object = ((ByteString)object).getData$okio();
        m10.a1((byte[])object, n10, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final int H(char n10) {
        int n11;
        int n12 = 48;
        if (n12 > n10 || (n11 = 57) < n10) {
            n12 = 102;
            n11 = 97;
            if (n11 <= n10 && n12 >= n10) {
                return n10 - n11 + 10;
            }
            n12 = 70;
            n11 = 65;
            if (n11 <= n10 && n12 >= n10) {
                return n10 - n11 + 10;
            }
        } else {
            n10 -= n12;
            return n10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected hex digit: ");
        stringBuilder.append((char)n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static final char[] I() {
        return a;
    }

    /*
     * Unable to fully structure code
     */
    private static final int c(byte[] var0, int var1_1) {
        var2_2 = var0;
        var3_3 = var1_1;
        var4_4 = var0.length;
        var5_5 = 0;
        var6_6 = 0;
        var7_7 = 0;
        block0: while (var5_5 < var4_4) {
            block47: {
                var8_8 = var2_2[var5_5];
                var9_9 = 127;
                var10_10 = 159;
                var11_11 = 31;
                var12_12 = 13;
                var13_13 = -3;
                var14_14 = 10;
                var15_15 = 65536;
                var16_16 = -1;
                var17_17 = 1;
                if (var8_8 >= 0) {
                    var18_18 = var7_7 + 1;
                    if (var7_7 == var3_3) {
                        return var6_6;
                    }
                    if (var8_8 != var14_14 && var8_8 != var12_12 && (var7_7 = var8_8 >= 0 && var11_11 >= var8_8 || var9_9 <= var8_8 && var10_10 >= var8_8 ? var17_17 : 0) != 0 || var8_8 == var13_13) {
                        return var16_16;
                    }
                    var7_7 = var8_8 < var15_15 ? var17_17 : 2;
                    var6_6 += var7_7;
                    ++var5_5;
                    while (true) {
                        var7_7 = var18_18++;
                        if (var5_5 >= var4_4 || (var8_8 = var2_2[var5_5]) < 0) continue block0;
                        var8_8 = var5_5 + 1;
                        var5_5 = var2_2[var5_5];
                        if (var7_7 == var3_3) {
                            return var6_6;
                        }
                        if (var5_5 != var14_14 && var5_5 != var12_12 && (var7_7 = var5_5 >= 0 && var11_11 >= var5_5 || var9_9 <= var5_5 && var10_10 >= var5_5 ? var17_17 : 0) != 0 || var5_5 == var13_13) {
                            return var16_16;
                        }
                        var5_5 = var5_5 < var15_15 ? var17_17 : 2;
                        var6_6 += var5_5;
                        var5_5 = var8_8;
                    }
                }
                var19_19 = var8_8 >> 5;
                var20_20 = -2;
                var15_15 = 128;
                if (var19_19 == var20_20) {
                    var19_19 = var5_5 + 1;
                    if (var4_4 <= var19_19) {
                        if (var7_7 == var3_3) {
                            return var6_6;
                        }
                        return var16_16;
                    }
                    var8_8 = var2_2[var5_5];
                    var20_20 = (var19_19 = var2_2[var19_19]) & 192;
                    var20_20 = var20_20 == var15_15 ? var17_17 : 0;
                    if (var20_20 == 0) {
                        if (var7_7 == var3_3) {
                            return var6_6;
                        }
                        return var16_16;
                    }
                    var19_19 ^= 3968;
                    if ((var19_19 ^= (var8_8 <<= 6)) < var15_15) {
                        if (var7_7 == var3_3) {
                            return var6_6;
                        }
                        return var16_16;
                    }
                    var8_8 = var7_7 + 1;
                    if (var7_7 == var3_3) {
                        return var6_6;
                    }
                    if (var19_19 != var14_14 && var19_19 != var12_12 && (var7_7 = var19_19 >= 0 && var11_11 >= var19_19 || var9_9 <= var19_19 && var10_10 >= var19_19 ? var17_17 : 0) != 0 || var19_19 == var13_13) {
                        return var16_16;
                    }
                    var7_7 = 65536;
                    var20_20 = var19_19 < var7_7 ? var17_17 : 2;
                    var6_6 += var20_20;
                    var5_5 += 2;
lbl71:
                    // 3 sources

                    while (true) {
                        var7_7 = var8_8;
                        continue block0;
                        break;
                    }
                }
                var19_19 = var8_8 >> 4;
                var13_13 = 55296;
                var10_10 = 57343;
                if (var19_19 != var20_20) break block47;
                var19_19 = var5_5 + 2;
                if (var4_4 <= var19_19) {
                    if (var7_7 == var3_3) {
                        return var6_6;
                    }
                    return var16_16;
                }
                var8_8 = var2_2[var5_5];
                var20_20 = var5_5 + 1;
                var9_9 = (var20_20 = var2_2[var20_20]) & 192;
                var9_9 = var9_9 == var15_15 ? var17_17 : 0;
                if (var9_9 == 0) {
                    if (var7_7 == var3_3) {
                        return var6_6;
                    }
                    return var16_16;
                }
                var9_9 = (var19_19 = var2_2[var19_19]) & 192;
                var9_9 = var9_9 == var15_15 ? var17_17 : 0;
                if (var9_9 == 0) {
                    if (var7_7 == var3_3) {
                        return var6_6;
                    }
                    return var16_16;
                }
                var19_19 ^= -123008;
                var9_9 = var20_20 << 6;
                var19_19 ^= var9_9;
                var8_8 <<= 12;
                if ((var19_19 ^= var8_8) < (var8_8 = 2048)) {
                    if (var7_7 == var3_3) {
                        return var6_6;
                    }
                    return var16_16;
                }
                if (var13_13 <= var19_19 && var10_10 >= var19_19) {
                    if (var7_7 == var3_3) {
                        return var6_6;
                    }
                    return var16_16;
                }
                var8_8 = var7_7 + 1;
                if (var7_7 == var3_3) {
                    return var6_6;
                }
                if (var19_19 != var14_14 && var19_19 != var12_12 && (var7_7 = var19_19 >= 0 && var11_11 >= var19_19 || (var7_7 = 127) <= var19_19 && (var7_7 = 159) >= var19_19 ? var17_17 : 0) != 0 || var19_19 == (var7_7 = (int)((char)-3))) {
                    return var16_16;
                }
                var7_7 = 65536;
                var20_20 = var19_19 < var7_7 ? var17_17 : 2;
                var6_6 += var20_20;
                var5_5 += 3;
                ** GOTO lbl71
            }
            var19_19 = var8_8 >> 3;
            if (var19_19 == var20_20) {
                var19_19 = var5_5 + 3;
                if (var4_4 <= var19_19) {
                    if (var7_7 == var3_3) {
                        return var6_6;
                    }
                    return var16_16;
                }
                var8_8 = var2_2[var5_5];
                var9_9 = var5_5 + 1;
                var20_20 = (var9_9 = var2_2[var9_9]) & 192;
                var20_20 = var20_20 == var15_15 ? var17_17 : 0;
                if (var20_20 == 0) {
                    if (var7_7 == var3_3) {
                        return var6_6;
                    }
                    return var16_16;
                }
                var20_20 = var5_5 + 2;
                var11_11 = (var20_20 = var2_2[var20_20]) & 192;
                var11_11 = var11_11 == var15_15 ? var17_17 : 0;
                if (var11_11 == 0) {
                    if (var7_7 == var3_3) {
                        return var6_6;
                    }
                    return var16_16;
                }
                var11_11 = (var19_19 = var2_2[var19_19]) & 192;
                var11_11 = var11_11 == var15_15 ? var17_17 : 0;
                if (var11_11 == 0) {
                    if (var7_7 == var3_3) {
                        return var6_6;
                    }
                    return var16_16;
                }
                var19_19 ^= 3678080;
                var11_11 = var20_20 << 6;
                var19_19 ^= var11_11;
                var19_19 ^= (var9_9 <<= 12);
                var8_8 <<= 18;
                if ((var19_19 ^= var8_8) > (var8_8 = 0x10FFFF)) {
                    if (var7_7 == var3_3) {
                        return var6_6;
                    }
                    return var16_16;
                }
                if (var13_13 <= var19_19 && var10_10 >= var19_19) {
                    if (var7_7 == var3_3) {
                        return var6_6;
                    }
                    return var16_16;
                }
                var8_8 = 65536;
                if (var19_19 < var8_8) {
                    if (var7_7 == var3_3) {
                        return var6_6;
                    }
                    return var16_16;
                }
                var8_8 = var7_7 + 1;
                if (var7_7 == var3_3) {
                    return var6_6;
                }
                if (var19_19 != var14_14 && var19_19 != var12_12 && (var7_7 = var19_19 >= 0 && (var7_7 = 31) >= var19_19 || (var7_7 = 127) <= var19_19 && (var7_7 = 159) >= var19_19 ? var17_17 : 0) != 0 || var19_19 == (var7_7 = (int)((char)-3))) {
                    return var16_16;
                }
                var7_7 = 65536;
                var20_20 = var19_19 < var7_7 ? var17_17 : 2;
                var6_6 += var20_20;
                var5_5 += 4;
                ** continue;
            }
            if (var7_7 == var3_3) {
                return var6_6;
            }
            return var16_16;
        }
        return var6_6;
    }

    public static final String d(ByteString byteString) {
        f0.p(byteString, "$this$commonBase64");
        return h.a.c(byteString.getData$okio(), null, 1, null);
    }

    public static final String e(ByteString object) {
        f0.p(object, "$this$commonBase64Url");
        object = ((ByteString)object).getData$okio();
        byte[] byArray = h.a.e();
        return h.a.b((byte[])object, byArray);
    }

    public static final int f(ByteString byteString, ByteString byteString2) {
        int n10;
        int n11;
        int n12;
        int n13;
        block4: {
            int n14;
            int n15;
            f0.p(byteString, "$this$commonCompareTo");
            String string2 = "other";
            f0.p(byteString2, string2);
            n13 = byteString.size();
            n12 = byteString2.size();
            int n16 = Math.min(n13, n12);
            int n17 = 0;
            while (true) {
                n11 = -1;
                n10 = 1;
                if (n17 >= n16) break block4;
                n15 = byteString.getByte(n17) & 0xFF;
                if (n15 != (n14 = byteString2.getByte(n17) & 0xFF)) break;
                ++n17;
            }
            if (n15 >= n14) {
                n11 = n10;
            }
            return n11;
        }
        if (n13 == n12) {
            return 0;
        }
        if (n13 >= n12) {
            n11 = n10;
        }
        return n11;
    }

    public static final ByteString g(String object) {
        Object object2 = "$this$commonDecodeBase64";
        f0.p(object, (String)object2);
        object = h.a.a((String)object);
        object2 = object != null ? new ByteString((byte[])object) : null;
        return object2;
    }

    public static final ByteString h(String object) {
        Object object2 = "$this$commonDecodeHex";
        f0.p(object, (String)object2);
        int n10 = ((String)object).length() % 2;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 != 0) {
            n10 = ((String)object).length() / 2;
            byte[] byArray = new byte[n10];
            while (n11 < n10) {
                int n13 = n11 * 2;
                int n14 = b.H(((String)object).charAt(n13)) << 4;
                n13 += n12;
                n13 = b.H(((String)object).charAt(n13));
                n14 += n13;
                byArray[n11] = n13 = (int)((byte)n14);
                ++n11;
            }
            object = new ByteString(byArray);
            return object;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Unexpected hex string: ");
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        object = object.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public static final ByteString i(String string2) {
        f0.p(string2, "$this$commonEncodeUtf8");
        byte[] byArray = i.a(string2);
        ByteString byteString = new ByteString(byArray);
        byteString.setUtf8$okio(string2);
        return byteString;
    }

    public static final boolean j(ByteString byteString, ByteString byteString2) {
        f0.p(byteString, "$this$commonEndsWith");
        f0.p(byteString2, "suffix");
        int n10 = byteString.size();
        int n11 = byteString2.size();
        n10 -= n11;
        n11 = byteString2.size();
        return byteString.rangeEquals(n10, byteString2, 0, n11);
    }

    public static final boolean k(ByteString byteString, byte[] byArray) {
        f0.p(byteString, "$this$commonEndsWith");
        f0.p(byArray, "suffix");
        int n10 = byteString.size();
        int n11 = byArray.length;
        n10 -= n11;
        n11 = byArray.length;
        return byteString.rangeEquals(n10, byArray, 0, n11);
    }

    public static final boolean l(ByteString object, Object object2) {
        boolean bl2;
        block2: {
            String string2;
            block3: {
                byte[] byArray;
                int n10;
                string2 = "$this$commonEquals";
                f0.p(object, string2);
                bl2 = true;
                if (object2 == object) break block2;
                int n11 = object2 instanceof ByteString;
                if (n11 == 0 || (n11 = ((ByteString)(object2 = (ByteString)object2)).size()) != (n10 = (byArray = ((ByteString)object).getData$okio()).length)) break block3;
                byte[] byArray2 = ((ByteString)object).getData$okio();
                object = ((ByteString)object).getData$okio();
                int n12 = ((Object)object).length;
                if ((n12 = (int)(((ByteString)object2).rangeEquals(0, byArray2, 0, n12) ? 1 : 0)) != 0) break block2;
            }
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public static final byte m(ByteString byteString, int n10) {
        f0.p(byteString, "$this$commonGetByte");
        return byteString.getData$okio()[n10];
    }

    public static final int n(ByteString byteString) {
        f0.p(byteString, "$this$commonGetSize");
        return byteString.getData$okio().length;
    }

    public static final int o(ByteString byteString) {
        String string2 = "$this$commonHashCode";
        f0.p(byteString, string2);
        int n10 = byteString.getHashCode$okio();
        if (n10 != 0) {
            return n10;
        }
        n10 = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(n10);
        return n10;
    }

    public static final String p(ByteString object) {
        f0.p(object, "$this$commonHex");
        int n10 = ((ByteString)object).getData$okio().length * 2;
        char[] cArray = new char[n10];
        object = ((ByteString)object).getData$okio();
        int n11 = ((Object)object).length;
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            char c10;
            Object object2 = object[i10];
            int n13 = n12 + 1;
            char[] cArray2 = b.I();
            int n14 = object2 >> 4 & 0xF;
            cArray[n12] = c10 = cArray2[n14];
            n12 = n13 + 1;
            cArray2 = b.I();
            object2 = object2 & 0xF;
            object2 = cArray2[object2];
            cArray[n13] = (char)object2;
        }
        object = new String(cArray);
        return object;
    }

    public static final int q(ByteString byteString, byte[] byArray, int n10) {
        f0.p(byteString, "$this$commonIndexOf");
        f0.p(byArray, "other");
        byte[] byArray2 = byteString.getData$okio();
        int n11 = byArray2.length;
        int n12 = byArray.length;
        n11 -= n12;
        n12 = 0;
        n10 = Math.max(n10, 0);
        if (n10 <= n11) {
            while (true) {
                int n13;
                byte[] byArray3;
                boolean bl2;
                if (bl2 = j.d(byArray3 = byteString.getData$okio(), n10, byArray, 0, n13 = byArray.length)) {
                    return n10;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        return -1;
    }

    public static final byte[] r(ByteString byteString) {
        f0.p(byteString, "$this$commonInternalArray");
        return byteString.getData$okio();
    }

    public static final int s(ByteString byteString, ByteString object, int n10) {
        f0.p(byteString, "$this$commonLastIndexOf");
        f0.p(object, "other");
        object = ((ByteString)object).internalArray$okio();
        return byteString.lastIndexOf((byte[])object, n10);
    }

    public static final int t(ByteString byteString, byte[] byArray, int n10) {
        f0.p(byteString, "$this$commonLastIndexOf");
        f0.p(byArray, "other");
        byte[] byArray2 = byteString.getData$okio();
        int n11 = byArray2.length;
        int n12 = byArray.length;
        for (n10 = Math.min(n10, n11 -= n12); n10 >= 0; n10 += -1) {
            byArray2 = byteString.getData$okio();
            n12 = 0;
            int n13 = byArray.length;
            n11 = (int)(j.d(byArray2, n10, byArray, 0, n13) ? 1 : 0);
            if (n11 == 0) continue;
            return n10;
        }
        return -1;
    }

    public static final ByteString u(byte[] byArray) {
        f0.p(byArray, "data");
        int n10 = byArray.length;
        byArray = Arrays.copyOf(byArray, n10);
        f0.o(byArray, "java.util.Arrays.copyOf(this, size)");
        ByteString byteString = new ByteString(byArray);
        return byteString;
    }

    public static final boolean v(ByteString object, int n10, ByteString byteString, int n11, int n12) {
        f0.p(object, "$this$commonRangeEquals");
        f0.p(byteString, "other");
        object = ((ByteString)object).getData$okio();
        return byteString.rangeEquals(n11, (byte[])object, n10, n12);
    }

    public static final boolean w(ByteString object, int n10, byte[] byArray, int n11, int n12) {
        boolean bl2;
        int n13;
        f0.p(object, "$this$commonRangeEquals");
        Object object2 = "other";
        f0.p(byArray, (String)object2);
        if (n10 >= 0 && n10 <= (n13 = ((Object)(object2 = (Object)((ByteString)object).getData$okio())).length - n12) && n11 >= 0 && n11 <= (n13 = byArray.length - n12) && (bl2 = j.d((byte[])(object = (Object)((ByteString)object).getData$okio()), n10, byArray, n11, n12))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static final boolean x(ByteString byteString, ByteString byteString2) {
        f0.p(byteString, "$this$commonStartsWith");
        f0.p(byteString2, "prefix");
        int n10 = byteString2.size();
        return byteString.rangeEquals(0, byteString2, 0, n10);
    }

    public static final boolean y(ByteString byteString, byte[] byArray) {
        f0.p(byteString, "$this$commonStartsWith");
        f0.p(byArray, "prefix");
        int n10 = byArray.length;
        return byteString.rangeEquals(0, byArray, 0, n10);
    }

    public static final ByteString z(ByteString object, int n10, int n11) {
        byte[] byArray;
        int n12;
        Object object2 = "$this$commonSubstring";
        f0.p(object, (String)object2);
        int n13 = 1;
        if (n10 >= 0) {
            n12 = n13;
        } else {
            n12 = 0;
            byArray = null;
        }
        if (n12 != 0) {
            byArray = ((ByteString)object).getData$okio();
            n12 = byArray.length;
            if (n11 <= n12) {
                n12 = n13;
            } else {
                n12 = 0;
                byArray = null;
            }
            if (n12 != 0) {
                n12 = n11 - n10;
                if (n12 < 0) {
                    n13 = 0;
                    object2 = null;
                }
                if (n13 != 0) {
                    if (n10 == 0 && n11 == (n13 = ((Object)(object2 = (Object)((ByteString)object).getData$okio())).length)) {
                        return object;
                    }
                    object = n.G1(((ByteString)object).getData$okio(), n10, n11);
                    object2 = new ByteString((byte[])object);
                    return object2;
                }
                String string2 = "endIndex < beginIndex".toString();
                object = new IllegalArgumentException(string2);
                throw object;
            }
            Serializable serializable = new StringBuilder();
            serializable.append("endIndex > length(");
            int n14 = ((ByteString)object).getData$okio().length;
            serializable.append(n14);
            serializable.append(')');
            object = serializable.toString();
            object = object.toString();
            serializable = new IllegalArgumentException((String)object);
            throw serializable;
        }
        String string3 = "beginIndex < 0".toString();
        object = new IllegalArgumentException(string3);
        throw object;
    }
}

