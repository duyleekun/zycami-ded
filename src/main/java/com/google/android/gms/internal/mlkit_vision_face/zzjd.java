/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzjc;
import com.google.android.gms.internal.mlkit_vision_face.zzje;
import com.google.android.gms.internal.mlkit_vision_face.zzjg;

public final class zzjd
extends zzje {
    public final int zza(int n10, byte[] byArray, int n11, int n12) {
        while (n11 < n12 && (n10 = byArray[n11]) >= 0) {
            ++n11;
        }
        n10 = 0;
        if (n11 >= n12) {
            return 0;
        }
        while (true) {
            int n13;
            block15: {
                int n14;
                block16: {
                    if (n11 >= n12) {
                        return 0;
                    }
                    n13 = n11 + 1;
                    if ((n11 = byArray[n11]) >= 0) break block15;
                    int n15 = -32;
                    n14 = -1;
                    int n16 = -65;
                    if (n11 < n15) {
                        if (n13 >= n12) {
                            return n11;
                        }
                        n15 = -62;
                        if (n11 >= n15) {
                            n11 = n13 + 1;
                            if ((n13 = byArray[n13]) <= n16) continue;
                        }
                        return n14;
                    }
                    int n17 = -16;
                    if (n11 < n17) {
                        n17 = n12 + -1;
                        if (n13 >= n17) {
                            return zzjc.zzb(byArray, n13, n12);
                        }
                        n17 = n13 + 1;
                        if ((n13 = byArray[n13]) <= n16) {
                            int n18 = -96;
                            if (!(n11 == n15 && n13 < n18 || n11 == (n15 = -19) && n13 >= n18)) {
                                n11 = n17 + 1;
                                n13 = byArray[n17];
                                if (n13 <= n16) continue;
                            }
                        }
                        return n14;
                    }
                    n15 = n12 + -2;
                    if (n13 >= n15) {
                        return zzjc.zzb(byArray, n13, n12);
                    }
                    n15 = n13 + 1;
                    if ((n13 = byArray[n13]) > n16) break block16;
                    n11 <<= 28;
                    if ((n11 = n11 + (n13 += 112) >> 30) != 0) break block16;
                    n11 = n15 + 1;
                    n13 = byArray[n15];
                    if (n13 > n16) break block16;
                    n13 = n11 + 1;
                    if ((n11 = byArray[n11]) <= n16) break block15;
                }
                return n14;
            }
            n11 = n13;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final int zza(CharSequence var1_1, byte[] var2_2, int var3_3, int var4_4) {
        var5_5 = var1_1.length();
        var6_6 = 0;
        while (true) {
            var7_7 = 128;
            if (var6_6 >= var5_5 || (var8_8 = var6_6 + var3_3) >= (var4_4 += var3_3) || (var9_9 = var1_1.charAt(var6_6)) >= var7_7) break;
            var2_2 /* !! */ [var8_8] = var7_7 = (int)((byte)var9_9);
            ++var6_6;
        }
        if (var6_6 == var5_5) {
            return var3_3 + var5_5;
        }
        var3_3 += var6_6;
        while (var6_6 < var5_5) {
            block19: {
                block20: {
                    block16: {
                        block17: {
                            block18: {
                                block14: {
                                    block15: {
                                        var8_8 = var1_1.charAt(var6_6);
                                        if (var8_8 < var7_7 && var3_3 < var4_4) {
                                            var9_9 = var3_3 + 1;
                                            var2_2 /* !! */ [var3_3] = var8_8 = (int)((byte)var8_8);
lbl17:
                                            // 2 sources

                                            while (true) {
                                                var3_3 = var9_9;
                                                break block14;
                                                break;
                                            }
                                        }
                                        var9_9 = 2048;
                                        if (var8_8 >= var9_9 || var3_3 > (var9_9 = var4_4 + -2)) break block15;
                                        var9_9 = var3_3 + 1;
                                        var2_2 /* !! */ [var3_3] = var10_10 = (int)((byte)(var8_8 >>> 6 | 960));
                                        var3_3 = var9_9 + 1;
                                        var2_2 /* !! */ [var9_9] = var8_8 = (int)((byte)(var8_8 & 63 | var7_7));
                                        break block14;
                                    }
                                    var9_9 = 57343;
                                    var10_10 = 55296;
                                    if ((var8_8 < var10_10 || var9_9 < var8_8) && var3_3 <= (var11_11 = var4_4 + -3)) {
                                        var9_9 = var3_3 + 1;
                                        var2_2 /* !! */ [var3_3] = var10_10 = (int)((byte)(var8_8 >>> 12 | 480));
                                        var3_3 = var9_9 + 1;
                                        var2_2 /* !! */ [var9_9] = var10_10 = (int)((byte)(var8_8 >>> 6 & 63 | var7_7));
                                        var9_9 = var3_3 + 1;
                                        var2_2 /* !! */ [var3_3] = var8_8 = (int)((byte)(var8_8 & 63 | var7_7));
                                        ** continue;
                                    }
                                    var11_11 = var4_4 + -4;
                                    if (var3_3 > var11_11) break block16;
                                    var9_9 = var6_6 + 1;
                                    var10_10 = var1_1.length();
                                    if (var9_9 == var10_10) break block17;
                                    var6_6 = var1_1.charAt(var9_9);
                                    var10_10 = (int)Character.isSurrogatePair((char)var8_8, (char)var6_6);
                                    if (var10_10 == 0) break block18;
                                    var6_6 = Character.toCodePoint((char)var8_8, (char)var6_6);
                                    var8_8 = var3_3 + 1;
                                    var2_2 /* !! */ [var3_3] = var10_10 = (int)((byte)(var6_6 >>> 18 | 240));
                                    var3_3 = var8_8 + 1;
                                    var2_2 /* !! */ [var8_8] = var10_10 = (int)((byte)(var6_6 >>> 12 & 63 | var7_7));
                                    var8_8 = var3_3 + 1;
                                    var2_2 /* !! */ [var3_3] = var10_10 = (int)((byte)(var6_6 >>> 6 & 63 | var7_7));
                                    var3_3 = var8_8 + 1;
                                    var2_2 /* !! */ [var8_8] = var6_6 = (int)((byte)(var6_6 & 63 | var7_7));
                                    var6_6 = var9_9;
                                }
                                ++var6_6;
                                continue;
                            }
                            var6_6 = var9_9;
                        }
                        var1_1 = new zzjg(var6_6 += -1, var5_5);
                        throw var1_1;
                    }
                    if (var10_10 > var8_8 || var8_8 > var9_9) break block19;
                    var12_12 = var6_6 + 1;
                    var4_4 = var1_1.length();
                    if (var12_12 == var4_4) break block20;
                    var13_13 = var1_1.charAt(var12_12);
                    if ((var13_13 = (char)Character.isSurrogatePair((char)var8_8, var13_13)) != '\u0000') break block19;
                }
                var1_1 = new zzjg(var6_6, var5_5);
                throw var1_1;
            }
            var14_14 = new StringBuilder(37);
            var14_14.append("Failed writing ");
            var14_14.append((char)var8_8);
            var14_14.append(" at index ");
            var14_14.append(var3_3);
            var2_2 /* !! */  = (byte[])var14_14.toString();
            var1_1 = new ArrayIndexOutOfBoundsException((String)var2_2 /* !! */ );
            throw var1_1;
        }
        return var3_3;
    }
}

