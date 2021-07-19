/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.s.l;
import f.h2.t.f0;
import f.q1;

public final class p0 {
    public static final byte a = 63;
    public static final char b = '\ufffd';
    public static final int c = 65533;
    public static final int d = 55232;
    public static final int e = 56320;
    public static final int f = 3968;
    public static final int g = 16654208;
    public static final int h = 3678080;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean a(int n10) {
        int n11;
        if (n10 >= 0) {
            n11 = 31;
            if (n11 >= n10) return 1 != 0;
        }
        n11 = 159;
        int n12 = 127;
        if (n12 > n10) return 0 != 0;
        if (n11 < n10) return 0 != 0;
        return 1 != 0;
    }

    public static final boolean b(byte by2) {
        byte by3 = 128;
        by2 = (by2 = (byte)(by2 & 0xC0)) == by3 ? (byte)1 : 0;
        return by2 != 0;
    }

    public static final int c(byte[] object, int n10, int n11, l l10) {
        f0.p(object, "$this$process2Utf8Bytes");
        String string2 = "yield";
        f0.p(l10, string2);
        int n12 = n10 + 1;
        char c10 = (char)-3;
        Integer n13 = c10;
        int n14 = 1;
        if (n11 <= n12) {
            l10.invoke(n13);
            return n14;
        }
        n10 = object[n10];
        int n15 = object[n12];
        n11 = n15 & 0xC0;
        n11 = n11 == (n12 = 128) ? n14 : 0;
        if (n11 == 0) {
            l10.invoke(n13);
            return n14;
        }
        n15 ^= 0xF80;
        if ((n15 ^= (n10 <<= 6)) < n12) {
            l10.invoke(n13);
        } else {
            object = n15;
            l10.invoke(object);
        }
        return 2;
    }

    public static final int d(byte[] object, int n10, int n11, l l10) {
        f0.p(object, "$this$process3Utf8Bytes");
        String string2 = "yield";
        f0.p(l10, string2);
        int n12 = n10 + 2;
        int n13 = 0;
        int n14 = 128;
        int n15 = 2;
        char c10 = (char)-3;
        Integer n16 = c10;
        int n17 = 1;
        if (n11 <= n12) {
            l10.invoke(n16);
            if (n11 > (n10 += n17)) {
                int n18 = object[n10] & 0xC0;
                if (n18 == n14) {
                    n13 = n17;
                }
                if (n13 != 0) {
                    return n15;
                }
            }
            return n17;
        }
        n11 = object[n10];
        n10 += n17;
        int n19 = (n10 = object[n10]) & 0xC0;
        n19 = n19 == n14 ? n17 : 0;
        if (n19 == 0) {
            l10.invoke(n16);
            return n17;
        }
        int n20 = object[n12];
        if ((n12 = n20 & 0xC0) == n14) {
            n13 = n17;
        }
        if (n13 == 0) {
            l10.invoke(n16);
            return n15;
        }
        n12 = -123008;
        n20 ^= n12;
        n20 ^= (n10 <<= 6);
        n10 = n11 << 12;
        if ((n20 ^= n10) < (n10 = 2048)) {
            l10.invoke(n16);
        } else {
            n10 = 57343;
            n11 = 55296;
            if (n11 <= n20 && n10 >= n20) {
                l10.invoke(n16);
            } else {
                object = n20;
                l10.invoke(object);
            }
        }
        return 3;
    }

    public static final int e(byte[] object, int n10, int n11, l l10) {
        f0.p(object, "$this$process4Utf8Bytes");
        String string2 = "yield";
        f0.p(l10, string2);
        int n12 = n10 + 3;
        int n13 = 3;
        int n14 = 2;
        int n15 = 0;
        int n16 = 128;
        char c10 = (char)-3;
        Integer n17 = c10;
        int n18 = 1;
        if (n11 <= n12) {
            l10.invoke(n17);
            int n19 = n10 + 1;
            if (n11 > n19) {
                if ((n19 = object[n19] & 0xC0) == n16) {
                    n19 = n18;
                } else {
                    n19 = 0;
                    l10 = null;
                }
                if (n19 != 0) {
                    if (n11 > (n10 += n14)) {
                        int n20 = object[n10] & 0xC0;
                        if (n20 == n16) {
                            n15 = n18;
                        }
                        if (n15 != 0) {
                            return n13;
                        }
                    }
                    return n14;
                }
            }
            return n18;
        }
        n11 = object[n10];
        int n21 = n10 + 1;
        int n22 = (n21 = object[n21]) & 0xC0;
        n22 = n22 == n16 ? n18 : 0;
        if (n22 == 0) {
            l10.invoke(n17);
            return n18;
        }
        n10 += n14;
        n22 = (n10 = object[n10]) & 0xC0;
        n22 = n22 == n16 ? n18 : 0;
        if (n22 == 0) {
            l10.invoke(n17);
            return n14;
        }
        int n23 = object[n12];
        if ((n12 = n23 & 0xC0) == n16) {
            n15 = n18;
        }
        if (n15 == 0) {
            l10.invoke(n17);
            return n13;
        }
        n12 = 3678080;
        n23 ^= n12;
        n23 ^= (n10 <<= 6);
        n10 = n21 << 12;
        n23 ^= n10;
        n10 = n11 << 18;
        if ((n23 ^= n10) > (n10 = 0x10FFFF)) {
            l10.invoke(n17);
        } else {
            n10 = 57343;
            n11 = 55296;
            if (n11 <= n23 && n10 >= n23) {
                l10.invoke(n17);
            } else {
                n10 = 65536;
                if (n23 < n10) {
                    l10.invoke(n17);
                } else {
                    object = n23;
                    l10.invoke(object);
                }
            }
        }
        return 4;
    }

    /*
     * Unable to fully structure code
     */
    public static final void f(byte[] var0, int var1_1, int var2_2, l var3_3) {
        var4_4 = var0;
        var5_5 = var2_2;
        var6_6 = var3_3;
        f0.p(var0, "$this$processUtf16Chars");
        var7_7 = "yield";
        f0.p(var3_3, (String)var7_7);
        var8_8 = var1_1;
        block0: while (var8_8 < var5_5) {
            block31: {
                block32: {
                    block27: {
                        block30: {
                            block29: {
                                block28: {
                                    block25: {
                                        block26: {
                                            var9_9 = var4_4[var8_8];
                                            if (var9_9 >= '\u0000') {
                                                var9_9 = var9_9;
                                                var10_10 = Character.valueOf(var9_9);
                                                var6_6.invoke(var10_10);
                                                ++var8_8;
                                                while (var8_8 < var5_5 && (var9_9 = var4_4[var8_8]) >= '\u0000') {
                                                    var9_9 = (char)(var8_8 + 1);
                                                    var7_7 = Character.valueOf((char)var4_4[var8_8]);
                                                    var6_6.invoke(var7_7);
                                                    var8_8 = var9_9;
                                                }
                                                continue;
                                            }
                                            var11_11 = var9_9 >> 5;
                                            var12_12 = -2;
                                            var13_13 = 0;
                                            var14_14 = 128;
                                            var15_15 = (char)-3;
                                            var16_16 = 1;
                                            if (var11_11 != var12_12) break block25;
                                            var9_9 = (char)(var8_8 + 1);
                                            if (var5_5 > var9_9) break block26;
                                            while (true) {
                                                var9_9 = var15_15;
                                                var10_10 = Character.valueOf(var9_9);
                                                var6_6.invoke(var10_10);
                                                var10_10 = q1.a;
lbl39:
                                                // 7 sources

                                                while (true) {
                                                    var17_17 = var16_16;
                                                    ** GOTO lbl56
                                                    break;
                                                }
                                                break;
                                            }
                                        }
                                        var11_11 = var4_4[var8_8];
                                        var12_12 = (var9_9 = var4_4[var9_9]) & 192;
                                        if (var12_12 == var14_14) {
                                            var13_13 = var16_16;
                                        }
                                        if (var13_13 == 0) ** continue;
                                        var9_9 = (char)(var9_9 ^ 3968);
                                        var9_9 = (var9_9 = (char)(var9_9 ^ (var11_11 <<= 6))) < var14_14 ? (char)var15_15 : (char)var9_9;
                                        var10_10 = Character.valueOf(var9_9);
                                        var6_6.invoke(var10_10);
                                        var10_10 = q1.a;
lbl54:
                                        // 6 sources

                                        while (true) {
                                            var17_17 = 2;
lbl56:
                                            // 4 sources

                                            while (true) {
                                                var8_8 += var17_17;
                                                continue block0;
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                    var11_11 = var9_9 >> 4;
                                    var18_18 = '\ud800';
                                    var19_19 = '\udfff';
                                    var20_20 = 3;
                                    if (var11_11 != var12_12) break block27;
                                    var9_9 = (char)(var8_8 + 2);
                                    if (var5_5 > var9_9) break block28;
                                    var10_10 = Character.valueOf(var15_15);
                                    var6_6.invoke(var10_10);
                                    var10_10 = q1.a;
                                    var9_9 = (char)(var8_8 + 1);
                                    if (var5_5 <= var9_9) ** GOTO lbl39
                                    if ((var9_9 = (char)(var4_4[var9_9] & 192)) == var14_14) {
                                        var13_13 = var16_16;
                                    }
                                    if (var13_13 != 0) ** GOTO lbl54
                                    ** GOTO lbl39
                                }
                                var11_11 = var4_4[var8_8];
                                var12_12 = var8_8 + 1;
                                var21_21 = (var12_12 = var4_4[var12_12]) & 192;
                                var21_21 = var21_21 == var14_14 ? var16_16 : 0;
                                if (var21_21 != 0) break block29;
                                var9_9 = var15_15;
                                var10_10 = Character.valueOf(var9_9);
                                var6_6.invoke(var10_10);
                                var10_10 = q1.a;
                                ** GOTO lbl39
                            }
                            var21_21 = (var9_9 = var4_4[var9_9]) & 192;
                            if (var21_21 == var14_14) {
                                var13_13 = var16_16;
                            }
                            if (var13_13 != 0) break block30;
                            var9_9 = var15_15;
                            var10_10 = Character.valueOf(var9_9);
                            var6_6.invoke(var10_10);
                            var10_10 = q1.a;
                            ** GOTO lbl54
                        }
                        var17_17 = -123008;
                        var9_9 = (char)(var9_9 ^ var17_17);
                        var9_9 = (char)(var9_9 ^ (var12_12 <<= 6));
                        var11_11 <<= 12;
                        if ((var9_9 = (char)(var9_9 ^ var11_11)) < (var11_11 = 2048)) {
                            while (true) {
                                var9_9 = var15_15;
lbl108:
                                // 2 sources

                                while (true) {
                                    var10_10 = Character.valueOf(var9_9);
                                    var6_6.invoke(var10_10);
                                    var10_10 = q1.a;
                                    ** GOTO lbl117
                                    break;
                                }
                                break;
                            }
                        } else {
                            if (var18_18 <= var9_9 && var19_19 >= var9_9) ** continue;
                            var9_9 = var9_9;
                            ** continue;
                        }
lbl117:
                        // 3 sources

                        while (true) {
                            var17_17 = var20_20;
                            ** GOTO lbl56
                            break;
                        }
                    }
                    if ((var9_9 = (char)(var9_9 >> 3)) != var12_12) break block31;
                    var9_9 = (char)(var8_8 + 3);
                    if (var5_5 > var9_9) break block32;
                    var10_10 = Character.valueOf(var15_15);
                    var6_6.invoke(var10_10);
                    var10_10 = q1.a;
                    var9_9 = (char)(var8_8 + 1);
                    if (var5_5 <= var9_9) ** GOTO lbl39
                    if ((var9_9 = (char)(var4_4[var9_9] & 192)) == var14_14) {
                        var9_9 = (char)var16_16;
                    } else {
                        var9_9 = '\u0000';
                        var10_10 = null;
                    }
                    if (var9_9 == '\u0000') ** GOTO lbl39
                    var9_9 = (char)(var8_8 + 2);
                    if (var5_5 <= var9_9) ** GOTO lbl54
                    if ((var9_9 = (char)(var4_4[var9_9] & 192)) == var14_14) {
                        var13_13 = var16_16;
                    }
                    if (var13_13 != 0) ** GOTO lbl117
                    ** GOTO lbl54
                }
                var11_11 = var4_4[var8_8];
                var12_12 = var8_8 + 1;
                var21_21 = (var12_12 = var4_4[var12_12]) & 192;
                var21_21 = var21_21 == var14_14 ? var16_16 : 0;
                if (var21_21 == 0) {
                    var10_10 = Character.valueOf(var15_15);
                    var6_6.invoke(var10_10);
                    var10_10 = q1.a;
                    ** continue;
                }
                var21_21 = var8_8 + 2;
                var17_17 = (var21_21 = var4_4[var21_21]) & 192;
                var17_17 = var17_17 == var14_14 ? var16_16 : 0;
                if (var17_17 == 0) {
                    var10_10 = Character.valueOf(var15_15);
                    var6_6.invoke(var10_10);
                    var10_10 = q1.a;
                    ** continue;
                }
                var17_17 = (var9_9 = var4_4[var9_9]) & 192;
                if (var17_17 == var14_14) {
                    var13_13 = var16_16;
                }
                if (var13_13 == 0) {
                    var10_10 = Character.valueOf(var15_15);
                    var6_6.invoke(var10_10);
                    var10_10 = q1.a;
                    ** continue;
                }
                var9_9 = (char)(var9_9 ^ 3678080);
                var17_17 = var21_21 << 6;
                var9_9 = (char)(var9_9 ^ var17_17);
                var9_9 = (char)(var9_9 ^ (var12_12 <<= 12));
                var11_11 <<= 18;
                if ((var9_9 = (char)(var9_9 ^ var11_11)) > (var11_11 = 0x10FFFF)) {
                    while (true) {
                        var10_10 = Character.valueOf(var15_15);
                        var6_6.invoke(var10_10);
lbl181:
                        // 2 sources

                        while (true) {
                            continue;
                            break;
                        }
                        break;
                    }
                }
                if (var18_18 <= var9_9 && var19_19 >= var9_9 || var9_9 < (var11_11 = 65536) || var9_9 == var15_15) ** continue;
                var11_11 = var9_9 >>> 10;
                var12_12 = 55232;
                var22_22 = Character.valueOf((char)(var11_11 + var12_12));
                var6_6.invoke(var22_22);
                var9_9 = (char)(var9_9 & 1023);
                var11_11 = 56320;
                var9_9 = (char)(var9_9 + var11_11);
                var10_10 = Character.valueOf(var9_9);
                var6_6.invoke(var10_10);
                ** continue;
                var10_10 = q1.a;
                var17_17 = 4;
                ** continue;
            }
            var10_10 = Character.valueOf(var15_15);
            var6_6.invoke(var10_10);
            ++var8_8;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final void g(String string2, int n10, int n11, l l10) {
        f0.p(string2, "$this$processUtf8Bytes");
        Object object = "yield";
        f0.p(l10, (String)object);
        block0: while (n10 < n11) {
            Byte by2;
            int n12;
            char c10 = string2.charAt(n10);
            int n13 = f0.t(c10, n12 = 128);
            if (n13 < 0) {
                c10 = c10;
                object = (byte)c10;
                l10.invoke(object);
                ++n10;
                while (true) {
                    if (n10 >= n11 || (c10 = f0.t(string2.charAt(n10), n12)) >= 0) continue block0;
                    c10 = n10 + 1;
                    Byte by3 = (byte)string2.charAt(n10);
                    l10.invoke(by3);
                    n10 = c10;
                }
            }
            n13 = f0.t(c10, 2048);
            if (n13 < 0) {
                n13 = (byte)(c10 >> 6 | 0xC0);
                by2 = (byte)n13;
                l10.invoke(by2);
                c10 = (char)(c10 & 0x3F | n12);
                object = (byte)c10;
                l10.invoke(object);
            } else {
                n13 = 55296;
                byte by4 = 63;
                if (n13 <= c10 && (n13 = 57343) >= c10) {
                    char c11;
                    char c12;
                    int n14 = f0.t(c10, 56319);
                    if (n14 <= 0 && n11 > (n14 = n10 + 1) && (c12 = '\udc00') <= (c11 = string2.charAt(n14)) && n13 >= c11) {
                        c10 <<= 10;
                        n13 = string2.charAt(n14);
                        c10 = c10 + n13 + -56613888;
                        by2 = (byte)(c10 >> 18 | 0xF0);
                        l10.invoke(by2);
                        by2 = (byte)(c10 >> 12 & by4 | n12);
                        l10.invoke(by2);
                        n13 = (byte)(c10 >> 6 & by4 | n12);
                        by2 = (byte)n13;
                        l10.invoke(by2);
                        c10 = (char)(c10 & by4 | n12);
                        object = (byte)c10;
                        l10.invoke(object);
                        n10 += 2;
                        continue;
                    }
                    object = by4;
                    l10.invoke(object);
                } else {
                    by2 = (byte)(c10 >> 12 | 0xE0);
                    l10.invoke(by2);
                    n13 = (byte)(c10 >> 6 & by4 | n12);
                    by2 = (byte)n13;
                    l10.invoke(by2);
                    c10 = (char)(c10 & 0x3F | n12);
                    object = (byte)c10;
                    l10.invoke(object);
                }
            }
            ++n10;
        }
        return;
    }

    /*
     * Unable to fully structure code
     */
    public static final void h(byte[] var0, int var1_1, int var2_2, l var3_3) {
        var4_4 = var0;
        var5_5 = var2_2;
        var6_6 = var3_3;
        f0.p(var0, "$this$processUtf8CodePoints");
        var7_7 = "yield";
        f0.p(var3_3, (String)var7_7);
        var8_8 = var1_1;
        block0: while (var8_8 < var5_5) {
            block31: {
                block32: {
                    block27: {
                        block30: {
                            block29: {
                                block28: {
                                    block25: {
                                        block26: {
                                            var9_9 = var4_4[var8_8];
                                            if (var9_9 >= 0) {
                                                var10_10 = var9_9;
                                                var6_6.invoke(var10_10);
                                                ++var8_8;
                                                while (var8_8 < var5_5 && (var9_9 = var4_4[var8_8]) >= 0) {
                                                    var9_9 = var8_8 + 1;
                                                    var7_7 = (int)var4_4[var8_8];
                                                    var6_6.invoke(var7_7);
                                                    var8_8 = var9_9;
                                                }
                                                continue;
                                            }
                                            var11_11 = var9_9 >> 5;
                                            var12_12 = -2;
                                            var13_13 = 0;
                                            var14_14 = 128;
                                            var15_15 = (char)-3;
                                            var16_16 = 1;
                                            if (var11_11 != var12_12) break block25;
                                            var9_9 = var8_8 + 1;
                                            if (var5_5 > var9_9) break block26;
                                            while (true) {
                                                var10_10 = (int)var15_15;
                                                var6_6.invoke(var10_10);
                                                var10_10 = q1.a;
lbl37:
                                                // 7 sources

                                                while (true) {
                                                    var17_17 = var16_16;
                                                    ** GOTO lbl53
                                                    break;
                                                }
                                                break;
                                            }
                                        }
                                        var11_11 = var4_4[var8_8];
                                        var12_12 = (var9_9 = var4_4[var9_9]) & 192;
                                        if (var12_12 == var14_14) {
                                            var13_13 = var16_16;
                                        }
                                        if (var13_13 == 0) ** continue;
                                        var9_9 ^= 3968;
                                        var10_10 = (var9_9 ^= (var11_11 <<= 6)) < var14_14 ? Integer.valueOf(var15_15) : Integer.valueOf(var9_9);
                                        var6_6.invoke(var10_10);
                                        var10_10 = q1.a;
lbl51:
                                        // 6 sources

                                        while (true) {
                                            var17_17 = 2;
lbl53:
                                            // 4 sources

                                            while (true) {
                                                var8_8 += var17_17;
                                                continue block0;
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                    var11_11 = var9_9 >> 4;
                                    var18_18 = 55296;
                                    var19_19 = 57343;
                                    var20_20 = 3;
                                    if (var11_11 != var12_12) break block27;
                                    var9_9 = var8_8 + 2;
                                    if (var5_5 > var9_9) break block28;
                                    var10_10 = (int)var15_15;
                                    var6_6.invoke(var10_10);
                                    var10_10 = q1.a;
                                    var9_9 = var8_8 + 1;
                                    if (var5_5 <= var9_9) ** GOTO lbl37
                                    if ((var9_9 = var4_4[var9_9] & 192) == var14_14) {
                                        var13_13 = var16_16;
                                    }
                                    if (var13_13 != 0) ** GOTO lbl51
                                    ** GOTO lbl37
                                }
                                var11_11 = var4_4[var8_8];
                                var12_12 = var8_8 + 1;
                                var21_21 = (var12_12 = var4_4[var12_12]) & 192;
                                var21_21 = var21_21 == var14_14 ? var16_16 : 0;
                                if (var21_21 != 0) break block29;
                                var10_10 = (int)var15_15;
                                var6_6.invoke(var10_10);
                                var10_10 = q1.a;
                                ** GOTO lbl37
                            }
                            var21_21 = (var9_9 = var4_4[var9_9]) & 192;
                            if (var21_21 == var14_14) {
                                var13_13 = var16_16;
                            }
                            if (var13_13 != 0) break block30;
                            var10_10 = (int)var15_15;
                            var6_6.invoke(var10_10);
                            var10_10 = q1.a;
                            ** GOTO lbl51
                        }
                        var17_17 = -123008;
                        var9_9 ^= var17_17;
                        var9_9 ^= (var12_12 <<= 6);
                        var11_11 <<= 12;
                        if ((var9_9 ^= var11_11) < (var11_11 = 2048)) {
                            while (true) {
                                var10_10 = (int)var15_15;
lbl103:
                                // 2 sources

                                while (true) {
                                    var6_6.invoke(var10_10);
                                    var10_10 = q1.a;
                                    ** GOTO lbl111
                                    break;
                                }
                                break;
                            }
                        } else {
                            if (var18_18 <= var9_9 && var19_19 >= var9_9) ** continue;
                            var10_10 = var9_9;
                            ** continue;
                        }
lbl111:
                        // 3 sources

                        while (true) {
                            var17_17 = var20_20;
                            ** GOTO lbl53
                            break;
                        }
                    }
                    if ((var9_9 >>= 3) != var12_12) break block31;
                    var9_9 = var8_8 + 3;
                    if (var5_5 > var9_9) break block32;
                    var10_10 = (int)var15_15;
                    var6_6.invoke(var10_10);
                    var10_10 = q1.a;
                    var9_9 = var8_8 + 1;
                    if (var5_5 <= var9_9) ** GOTO lbl37
                    if ((var9_9 = var4_4[var9_9] & 192) == var14_14) {
                        var9_9 = var16_16;
                    } else {
                        var9_9 = 0;
                        var10_10 = null;
                    }
                    if (var9_9 == 0) ** GOTO lbl37
                    var9_9 = var8_8 + 2;
                    if (var5_5 <= var9_9) ** GOTO lbl51
                    if ((var9_9 = var4_4[var9_9] & 192) == var14_14) {
                        var13_13 = var16_16;
                    }
                    if (var13_13 != 0) ** GOTO lbl111
                    ** GOTO lbl51
                }
                var11_11 = var4_4[var8_8];
                var12_12 = var8_8 + 1;
                var21_21 = (var12_12 = var4_4[var12_12]) & 192;
                var21_21 = var21_21 == var14_14 ? var16_16 : 0;
                if (var21_21 == 0) {
                    var10_10 = (int)var15_15;
                    var6_6.invoke(var10_10);
                    var10_10 = q1.a;
                    ** continue;
                }
                var21_21 = var8_8 + 2;
                var17_17 = (var21_21 = var4_4[var21_21]) & 192;
                var17_17 = var17_17 == var14_14 ? var16_16 : 0;
                if (var17_17 == 0) {
                    var10_10 = (int)var15_15;
                    var6_6.invoke(var10_10);
                    var10_10 = q1.a;
                    ** continue;
                }
                var17_17 = (var9_9 = var4_4[var9_9]) & 192;
                if (var17_17 == var14_14) {
                    var13_13 = var16_16;
                }
                if (var13_13 == 0) {
                    var10_10 = (int)var15_15;
                    var6_6.invoke(var10_10);
                    var10_10 = q1.a;
                    ** continue;
                }
                var9_9 ^= 3678080;
                var17_17 = var21_21 << 6;
                var9_9 ^= var17_17;
                var9_9 ^= (var12_12 <<= 12);
                var11_11 <<= 18;
                if ((var9_9 ^= var11_11) > (var11_11 = 0x10FFFF)) {
                    while (true) {
                        var10_10 = (int)var15_15;
lbl173:
                        // 2 sources

                        while (true) {
                            continue;
                            break;
                        }
                        break;
                    }
                }
                if (var18_18 <= var9_9 && var19_19 >= var9_9 || var9_9 < (var11_11 = 65536)) ** continue;
                var10_10 = var9_9;
                ** continue;
                var6_6.invoke(var10_10);
                var10_10 = q1.a;
                var17_17 = 4;
                ** continue;
            }
            var10_10 = (int)var15_15;
            var6_6.invoke(var10_10);
            ++var8_8;
        }
    }

    public static final long i(String string2) {
        return p0.l(string2, 0, 0, 3, null);
    }

    public static final long j(String string2, int n10) {
        return p0.l(string2, n10, 0, 2, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final long k(String charSequence, int n10, int n11) {
        f0.p(charSequence, "$this$utf8Size");
        int n12 = 1;
        int n13 = n10 >= 0 ? n12 : 0;
        if (n13 == 0) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("beginIndex < 0: ");
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            charSequence = charSequence.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
            throw illegalArgumentException;
        }
        n13 = n11 >= n10 ? n12 : 0;
        if (n13 == 0) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("endIndex < beginIndex: ");
            ((StringBuilder)charSequence).append(n11);
            ((StringBuilder)charSequence).append(" < ");
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            charSequence = charSequence.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
            throw illegalArgumentException;
        }
        n13 = ((String)charSequence).length();
        if (n11 > n13) {
            n12 = 0;
        }
        if (n12 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("endIndex > string.length: ");
            stringBuilder.append(n11);
            stringBuilder.append(" > ");
            int n14 = ((String)charSequence).length();
            stringBuilder.append(n14);
            charSequence = stringBuilder.toString();
            charSequence = charSequence.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
            throw illegalArgumentException;
        }
        long l10 = 0L;
        while (n10 < n11) {
            int n15 = ((String)charSequence).charAt(n10);
            int n16 = 128;
            long l11 = 1L;
            if (n15 < n16) {
                l10 += l11;
            } else {
                long l12;
                n16 = 2048;
                if (n15 < n16) {
                    n15 = 2;
                } else {
                    n16 = 55296;
                    if (n15 >= n16 && n15 <= (n16 = 57343)) {
                        int n17 = n10 + 1;
                        int n18 = n17 < n11 ? ((String)charSequence).charAt(n17) : 0;
                        int n19 = 56319;
                        if (n15 <= n19 && n18 >= (n15 = 56320) && n18 <= n16) {
                            n15 = 4;
                            l12 = n15;
                            l10 += l12;
                            n10 += 2;
                            continue;
                        }
                        l10 += l11;
                        n10 = n17;
                        continue;
                    }
                    n15 = 3;
                }
                l12 = n15;
                l10 += l12;
            }
            ++n10;
        }
        return l10;
    }

    public static /* synthetic */ long l(String string2, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = string2.length();
        }
        return p0.k(string2, n10, n11);
    }
}

