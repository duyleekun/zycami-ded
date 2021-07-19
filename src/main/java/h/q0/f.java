/*
 * Decompiled with CFR 0.151.
 */
package h.q0;

import f.h2.t.f0;
import java.util.Arrays;

public final class f {
    /*
     * Enabled aggressive block sorting
     */
    public static final byte[] a(String object) {
        int n10;
        int n11;
        int n12;
        String string2;
        f0.p(object, "$this$commonAsUtf8ToByteArray");
        int n13 = ((String)object).length() * 4;
        byte[] byArray = new byte[n13];
        int n14 = ((String)object).length();
        int n15 = 0;
        while (true) {
            byte by2;
            string2 = "java.util.Arrays.copyOf(this, newSize)";
            if (n15 >= n14) {
                int n16 = ((String)object).length();
                object = Arrays.copyOf(byArray, n16);
                f0.o(object, string2);
                return object;
            }
            n12 = ((String)object).charAt(n15);
            n10 = f0.t(n12, n11 = 128);
            if (n10 >= 0) break;
            byArray[n15] = by2 = (byte)n12;
            ++n15;
        }
        n14 = ((String)object).length();
        n12 = n15;
        while (true) {
            block10: {
                block7: {
                    int n17;
                    int n18;
                    int n19;
                    block8: {
                        block9: {
                            char c10;
                            char c11;
                            block6: {
                                if (n15 >= n14) {
                                    object = Arrays.copyOf(byArray, n12);
                                    f0.o(object, string2);
                                    return object;
                                }
                                n10 = ((String)object).charAt(n15);
                                n19 = f0.t(n10, n11);
                                if (n19 < 0) {
                                    n10 = (byte)n10;
                                    n19 = n12 + 1;
                                    byArray[n12] = n10;
                                    ++n15;
                                    while (n15 < n14 && (n12 = f0.t(((String)object).charAt(n15), n11)) < 0) {
                                        n12 = n15 + 1;
                                        n15 = (byte)((String)object).charAt(n15);
                                        n10 = n19 + 1;
                                        byArray[n19] = n15;
                                        n15 = n12;
                                        n19 = n10;
                                    }
                                    n12 = n19;
                                    continue;
                                }
                                n19 = f0.t(n10, 2048);
                                if (n19 >= 0) break block6;
                                n19 = (byte)(n10 >> 6 | 0xC0);
                                n18 = n12 + 1;
                                byArray[n12] = n19;
                                n12 = (byte)(n10 & 0x3F | n11);
                                n10 = n18 + 1;
                                byArray[n18] = n12;
                                break block7;
                            }
                            n19 = 55296;
                            n18 = 63;
                            if (n19 > n10 || (n19 = 57343) < n10) break block8;
                            n17 = f0.t(n10, 56319);
                            if (n17 > 0 || n14 <= (n17 = n15 + 1) || (c11 = '\udc00') > (c10 = ((String)object).charAt(n17)) || n19 < c10) break block9;
                            n10 <<= 10;
                            n19 = ((String)object).charAt(n17);
                            n10 = n10 + n19 + -56613888;
                            n19 = (byte)(n10 >> 18 | 0xF0);
                            n17 = n12 + 1;
                            byArray[n12] = n19;
                            n12 = (byte)(n10 >> 12 & n18 | n11);
                            n19 = n17 + 1;
                            byArray[n17] = n12;
                            n12 = (byte)(n10 >> 6 & n18 | n11);
                            n17 = n19 + 1;
                            byArray[n19] = n12;
                            n12 = (byte)(n10 & 0x3F | n11);
                            n10 = n17 + 1;
                            byArray[n17] = n12;
                            n15 += 2;
                            break block10;
                        }
                        n10 = n12 + 1;
                        byArray[n12] = n18;
                        break block7;
                    }
                    n19 = (byte)(n10 >> 12 | 0xE0);
                    n17 = n12 + 1;
                    byArray[n12] = n19;
                    n12 = (byte)(n10 >> 6 & n18 | n11);
                    n19 = n17 + 1;
                    byArray[n17] = n12;
                    n12 = (byte)(n10 & 0x3F | n11);
                    n10 = n19 + 1;
                    byArray[n19] = n12;
                }
                ++n15;
            }
            n12 = n10;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    public static final String b(byte[] var0, int var1_1, int var2_2) {
        var3_3 /* !! */  = var0;
        var4_4 = var1_1;
        var5_5 = var2_2;
        var6_6 = "$this$commonToUtf8String";
        f0.p(var0, (String)var6_6);
        if (var1_1 < 0 || var2_2 > (var7_7 = var0.length) || var1_1 > var2_2) {
            var8_9 = new StringBuilder();
            var8_9.append("size=");
            var20_21 = var3_3 /* !! */ .length;
            var8_9.append(var20_21);
            var8_9.append(" beginIndex=");
            var8_9.append(var4_4);
            var8_9.append(" endIndex=");
            var8_9.append(var5_5);
            var3_3 /* !! */  = (byte[])var8_9.toString();
            var6_6 = new ArrayIndexOutOfBoundsException((String)var3_3 /* !! */ );
            throw var6_6;
        }
        var7_7 = var2_2 - var1_1;
        var6_6 = new char[var7_7];
        var8_8 = null;
        var9_10 = 0;
        while (true) {
            block37: {
                block35: {
                    block36: {
                        block33: {
                            block29: {
                                block34: {
                                    block30: {
                                        block32: {
                                            block31: {
                                                block28: {
                                                    if (var4_4 >= var5_5) {
                                                        var3_3 /* !! */  = (byte[])new String;
                                                        var3_3 /* !! */ ((char[])var6_6, 0, var9_10);
                                                        return var3_3 /* !! */ ;
                                                    }
                                                    var10_11 = var3_3 /* !! */ [var4_4];
                                                    if (var10_11 < 0) break block28;
                                                    var10_11 = var10_11;
                                                    var11_12 = var9_10 + 1;
                                                    var6_6[var9_10] = var10_11;
                                                    ++var4_4;
                                                    while (var4_4 < var5_5 && (var9_10 = var3_3 /* !! */ [var4_4]) >= 0) {
                                                        var9_10 = var4_4 + 1;
                                                        var4_4 = (char)var3_3 /* !! */ [var4_4];
                                                        var10_11 = var11_12 + '\u0001';
                                                        var6_6[var11_12] = var4_4;
                                                        var4_4 = var9_10;
                                                        var11_12 = var10_11;
                                                    }
                                                    break block29;
                                                }
                                                var11_12 = var10_11 >> 5;
                                                var12_13 = -2;
                                                var13_14 = 128;
                                                var14_15 = (char)-3;
                                                if (var11_12 != var12_13) break block30;
                                                var10_11 = var4_4 + 1;
                                                if (var5_5 > var10_11) break block31;
                                                var10_11 = var14_15;
                                                var11_12 = var9_10 + 1;
                                                var6_6[var9_10] = var10_11;
                                                ** GOTO lbl107
                                            }
                                            var11_12 = var3_3 /* !! */ [var4_4];
                                            var12_13 = (var10_11 = var3_3 /* !! */ [var10_11]) & 192;
                                            var12_13 = var12_13 == var13_14 ? 1 : 0;
                                            if (var12_13 != 0) break block32;
                                            var10_11 = var14_15;
                                            var11_12 = var9_10 + 1;
                                            var6_6[var9_10] = var10_11;
                                            ** GOTO lbl107
                                        }
                                        var10_11 ^= 3968;
                                        if ((var10_11 ^= (var11_12 <<= 6)) < var13_14) {
                                            var10_11 = var14_15;
                                            var11_12 = var9_10 + 1;
                                            var6_6[var9_10] = var10_11;
                                        } else {
                                            var10_11 = (char)var10_11;
                                            var11_12 = var9_10 + 1;
                                            var6_6[var9_10] = var10_11;
                                        }
                                        ** GOTO lbl116
                                    }
                                    var11_12 = var10_11 >> 4;
                                    var16_17 = 55296;
                                    var17_18 = 57343;
                                    var18_19 = 3;
                                    if (var11_12 != var12_13) break block33;
                                    var10_11 = var4_4 + 2;
                                    if (var5_5 > var10_11) break block34;
                                    var10_11 = var14_15;
                                    var11_12 = var9_10 + '\u0001';
                                    var6_6[var9_10] = var10_11;
                                    var9_10 = var4_4 + 1;
                                    if (var5_5 > var9_10 && (var9_10 = (var9_10 = var3_3 /* !! */ [var9_10] & 192) == var13_14 ? 1 : 0) != 0) ** GOTO lbl116
                                    ** GOTO lbl107
                                }
                                var11_12 = var3_3 /* !! */ [var4_4];
                                var12_13 = var4_4 + 1;
                                var15_16 = (var12_13 = var3_3 /* !! */ [var12_13]) & 192;
                                var15_16 = var15_16 == var13_14 ? 1 : 0;
                                if (var15_16 == 0) {
                                    var10_11 = var14_15;
                                    var11_12 = var9_10 + 1;
                                    var6_6[var9_10] = var10_11;
lbl107:
                                    // 4 sources

                                    var15_16 = 1;
                                } else {
                                    var15_16 = (var10_11 = var3_3 /* !! */ [var10_11]) & 192;
                                    var19_20 = var15_16 == var13_14 ? 1 : 0;
                                    if (var19_20 == 0) {
                                        var10_11 = var14_15;
                                        var11_12 = var9_10 + 1;
                                        var6_6[var9_10] = var10_11;
lbl116:
                                        // 4 sources

                                        var15_16 = 2;
                                    } else {
                                        var15_16 = -123008;
                                        var10_11 ^= var15_16;
                                        var10_11 ^= (var12_13 <<= 6);
                                        var11_12 <<= 12;
                                        if ((var10_11 ^= var11_12) < (var11_12 = 2048)) {
                                            var10_11 = var14_15;
                                            var11_12 = var9_10 + 1;
                                            var6_6[var9_10] = var10_11;
                                        } else if (var16_17 <= var10_11 && var17_18 >= var10_11) {
                                            var10_11 = var14_15;
                                            var11_12 = var9_10 + 1;
                                            var6_6[var9_10] = var10_11;
                                        } else {
                                            var10_11 = (char)var10_11;
                                            var11_12 = var9_10 + 1;
                                            var6_6[var9_10] = var10_11;
                                        }
                                        var15_16 = var18_19;
                                    }
                                }
                                var4_4 += var15_16;
                            }
                            var9_10 = var11_12;
                            continue;
                        }
                        if ((var10_11 = (int)(var10_11 >> 3)) != var12_13) break block35;
                        var10_11 = var4_4 + 3;
                        if (var5_5 > var10_11) break block36;
                        var10_11 = var9_10 + 1;
                        var6_6[var9_10] = var14_15;
                        var9_10 = var4_4 + 1;
                        if (var5_5 <= var9_10 || (var9_10 = (var9_10 = var3_3 /* !! */ [var9_10] & 192) == var13_14 ? 1 : 0) == 0) ** GOTO lbl162
                        var9_10 = var4_4 + 2;
                        if (var5_5 > var9_10 && (var19_20 = (var9_10 = var3_3 /* !! */ [var9_10] & 192) == var13_14 ? 1 : 0) != 0) ** GOTO lbl179
                        ** GOTO lbl171
                    }
                    var11_12 = var3_3 /* !! */ [var4_4];
                    var12_13 = var4_4 + 1;
                    var15_16 = (var12_13 = var3_3 /* !! */ [var12_13]) & 192;
                    var15_16 = var15_16 == var13_14 ? 1 : 0;
                    if (var15_16 == 0) {
                        var10_11 = var9_10 + 1;
                        var6_6[var9_10] = var14_15;
lbl162:
                        // 2 sources

                        var15_16 = 1;
                    } else {
                        var15_16 = var4_4 + 2;
                        var19_20 = (var15_16 = var3_3 /* !! */ [var15_16]) & 192;
                        var19_20 = var19_20 == var13_14 ? 1 : 0;
                        if (var19_20 == 0) {
                            var10_11 = var9_10 + 1;
                            var6_6[var9_10] = var14_15;
lbl171:
                            // 2 sources

                            var15_16 = 2;
                        } else {
                            var19_20 = (var10_11 = var3_3 /* !! */ [var10_11]) & 192;
                            var19_20 = var19_20 == var13_14 ? 1 : 0;
                            if (var19_20 == 0) {
                                var10_11 = var9_10 + 1;
                                var6_6[var9_10] = var14_15;
lbl179:
                                // 2 sources

                                var15_16 = var18_19;
                            } else {
                                var13_14 = 3678080;
                                var10_11 ^= var13_14;
                                var10_11 ^= (var15_16 <<= 6);
                                var10_11 ^= (var12_13 <<= 12);
                                var11_12 <<= 18;
                                if ((var10_11 ^= var11_12) > (var11_12 = 0x10FFFF)) {
                                    var10_11 = var9_10 + 1;
                                    var6_6[var9_10] = var14_15;
                                } else if (var16_17 <= var10_11 && var17_18 >= var10_11) {
                                    var10_11 = var9_10 + 1;
                                    var6_6[var9_10] = var14_15;
                                } else {
                                    var11_12 = 65536;
                                    if (var10_11 < var11_12) {
                                        var10_11 = var9_10 + 1;
                                        var6_6[var9_10] = var14_15;
                                    } else if (var10_11 != var14_15) {
                                        var11_12 = (char)((var10_11 >>> 10) + 55232);
                                        var12_13 = var9_10 + 1;
                                        var6_6[var9_10] = var11_12;
                                        var9_10 = (char)((var10_11 & 1023) + 56320);
                                        var10_11 = var12_13 + 1;
                                        var6_6[var12_13] = var9_10;
                                    } else {
                                        var10_11 = var9_10 + 1;
                                        var6_6[var9_10] = var14_15;
                                    }
                                }
                                var15_16 = 4;
                            }
                        }
                    }
                    var4_4 += var15_16;
                    break block37;
                }
                var10_11 = var9_10 + '\u0001';
                var6_6[var9_10] = var14_15;
                ++var4_4;
            }
            var9_10 = var10_11;
        }
    }

    public static /* synthetic */ String c(byte[] byArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = byArray.length;
        }
        return f.b(byArray, n10, n11);
    }
}

