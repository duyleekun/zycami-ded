/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzki;
import com.google.android.gms.internal.measurement.zzkj;
import com.google.android.gms.internal.measurement.zzkl;
import com.google.android.gms.internal.measurement.zzkn;

public final class zzkk
extends zzkj {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final int zzb(int n10, byte[] byArray, int n11, int n12) {
        while (n11 < n12 && (n10 = byArray[n11]) >= 0) {
            ++n11;
        }
        n10 = 0;
        int n13 = -1;
        if (n11 >= n12) return n10;
        while (n11 < n12) {
            int n14 = n11 + 1;
            if ((n11 = byArray[n11]) < 0) {
                int n15 = -32;
                int n16 = -65;
                if (n11 < n15) {
                    if (n14 >= n12) return n11;
                    n15 = -62;
                    if (n11 < n15) return n13;
                    n11 = n14 + 1;
                    if ((n14 = byArray[n14]) <= n16) continue;
                    return n13;
                }
                int n17 = -16;
                if (n11 < n17) {
                    n17 = n12 + -1;
                    if (n14 >= n17) {
                        return zzkn.zzh(byArray, n14, n12);
                    }
                    n17 = n14 + 1;
                    if ((n14 = byArray[n14]) > n16) return n13;
                    int n18 = -96;
                    if (n11 == n15) {
                        if (n14 < n18) return n13;
                    }
                    if (n11 == (n15 = -19)) {
                        if (n14 >= n18) return n13;
                    }
                    n11 = n17 + 1;
                    n14 = byArray[n17];
                    if (n14 <= n16) continue;
                    return n13;
                }
                n15 = n12 + -2;
                if (n14 >= n15) {
                    return zzkn.zzh(byArray, n14, n12);
                }
                n15 = n14 + 1;
                if ((n14 = byArray[n14]) > n16) return n13;
                n11 <<= 28;
                if ((n11 = n11 + (n14 += 112) >> 30) != 0) return n13;
                n11 = n15 + 1;
                n14 = byArray[n15];
                if (n14 > n16) return n13;
                n14 = n11 + 1;
                if ((n11 = byArray[n11]) > n16) {
                    return n13;
                }
            }
            n11 = n14;
        }
        return n10;
    }

    public final String zzc(byte[] object, int n10, int n11) {
        Object object2;
        int n12 = ((byte[])object).length;
        int n13 = n10 | n11;
        int n14 = n12 - n10 - n11;
        n13 |= n14;
        n14 = 0;
        if (n13 >= 0) {
            char c10;
            int n15;
            n12 = n10 + n11;
            char[] cArray = new char[n11];
            n13 = 0;
            Object var8_8 = null;
            while (n10 < n12 && (n15 = zzki.zza((byte)(c10 = object[n10]))) != 0) {
                ++n10;
                n15 = n13 + 1;
                cArray[n13] = c10 = (char)c10;
                n13 = n15;
            }
            block1: while (n10 < n12) {
                int n16;
                int n17;
                c10 = n10 + 1;
                n15 = zzki.zza((byte)(n10 = object[n10]));
                if (n15 != 0) {
                    n15 = n13 + 1;
                    cArray[n13] = n10 = (int)((char)n10);
                    n10 = c10;
                    while (true) {
                        n13 = n15;
                        if (n10 >= n12 || (n15 = (int)(zzki.zza((byte)(c10 = object[n10])) ? 1 : 0)) == 0) continue block1;
                        ++n10;
                        n15 = n13 + 1;
                        cArray[n13] = c10 = (char)c10;
                    }
                }
                n15 = (int)(zzki.zzb((byte)n10) ? 1 : 0);
                if (n15 != 0) {
                    if (c10 < n12) {
                        n15 = c10 + 1;
                        n17 = n13 + 1;
                        c10 = object[c10];
                        zzki.zzc((byte)n10, (byte)c10, cArray, n13);
                        n10 = n15;
                        n13 = n17;
                        continue;
                    }
                    throw zzic.zzf();
                }
                n15 = (int)(zzki.zzd((byte)n10) ? 1 : 0);
                if (n15 != 0) {
                    n15 = n12 + -1;
                    if (c10 < n15) {
                        n15 = c10 + 1;
                        n17 = n15 + 1;
                        n16 = n13 + 1;
                        c10 = object[c10];
                        n15 = object[n15];
                        zzki.zze((byte)n10, (byte)c10, (byte)n15, cArray, n13);
                        n10 = n17;
                        n13 = n16;
                        continue;
                    }
                    throw zzic.zzf();
                }
                n15 = n12 + -2;
                if (c10 < n15) {
                    n15 = c10 + 1;
                    n17 = n15 + 1;
                    int n18 = n17 + 1;
                    n16 = object[c10];
                    int n19 = object[n15];
                    int n20 = object[n17];
                    c10 = (char)n10;
                    n15 = n16;
                    n17 = n19;
                    n16 = n20;
                    n20 = n13;
                    zzki.zzf((byte)n10, (byte)n15, (byte)n19, (byte)n16, cArray, n13);
                    n13 += 2;
                    n10 = n18;
                    continue;
                }
                throw zzic.zzf();
            }
            object = new String;
            object(cArray, 0, n13);
            return object;
        }
        object = new ArrayIndexOutOfBoundsException;
        Object[] objectArray = new Object[3];
        Integer n21 = n12;
        objectArray[0] = n21;
        objectArray[1] = object2 = Integer.valueOf(n10);
        objectArray[2] = object2 = Integer.valueOf(n11);
        object2 = String.format("buffer length=%d, index=%d, size=%d", objectArray);
        object((String)object2);
        throw object;
    }

    /*
     * Unable to fully structure code
     */
    public final int zzd(CharSequence var1_1, byte[] var2_2, int var3_3, int var4_4) {
        var5_5 = var1_1.length();
        var6_6 = 0;
        while (true) {
            var7_7 = 128;
            if (var6_6 >= var5_5 || (var8_8 = var6_6 + var3_3) >= (var4_4 += var3_3) || (var9_9 = var1_1.charAt(var6_6)) >= var7_7) break;
            var2_2[var8_8] = var7_7 = (int)((byte)var9_9);
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
                                            var2_2[var3_3] = var8_8 = (int)((byte)var8_8);
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
                                        var2_2[var3_3] = var10_10 = (int)((byte)(var8_8 >>> 6 | 960));
                                        var3_3 = var9_9 + 1;
                                        var8_8 = (byte)(var8_8 & 63 | var7_7);
                                        var2_2[var9_9] = var8_8;
                                        break block14;
                                    }
                                    var9_9 = 57343;
                                    var10_10 = 55296;
                                    if ((var8_8 < var10_10 || var8_8 > var9_9) && var3_3 <= (var11_11 = var4_4 + -3)) {
                                        var9_9 = var3_3 + 1;
                                        var2_2[var3_3] = var10_10 = (int)((byte)(var8_8 >>> 12 | 480));
                                        var3_3 = var9_9 + 1;
                                        var10_10 = (byte)(var8_8 >>> 6 & 63 | var7_7);
                                        var2_2[var9_9] = var10_10;
                                        var9_9 = var3_3 + 1;
                                        var8_8 = (byte)(var8_8 & 63 | var7_7);
                                        var2_2[var3_3] = var8_8;
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
                                    var10_10 = (byte)(var6_6 >>> 18 | 240);
                                    var2_2[var3_3] = var10_10;
                                    var3_3 = var8_8 + 1;
                                    var10_10 = (byte)(var6_6 >>> 12 & 63 | var7_7);
                                    var2_2[var8_8] = var10_10;
                                    var8_8 = var3_3 + 1;
                                    var10_10 = (byte)(var6_6 >>> 6 & 63 | var7_7);
                                    var2_2[var3_3] = var10_10;
                                    var3_3 = var8_8 + 1;
                                    var6_6 = (byte)(var6_6 & 63 | var7_7);
                                    var2_2[var8_8] = var6_6;
                                    var6_6 = var9_9;
                                }
                                ++var6_6;
                                continue;
                            }
                            var6_6 = var9_9;
                        }
                        var1_1 = new zzkl(var6_6 += -1, var5_5);
                        throw var1_1;
                    }
                    if (var8_8 < var10_10 || var8_8 > var9_9) break block19;
                    var12_12 = var6_6 + 1;
                    var4_4 = var1_1.length();
                    if (var12_12 == var4_4) break block20;
                    var13_13 = var1_1.charAt(var12_12);
                    if ((var13_13 = (char)Character.isSurrogatePair((char)var8_8, var13_13)) != '\u0000') break block19;
                }
                var1_1 = new zzkl(var6_6, var5_5);
                throw var1_1;
            }
            var2_2 = new StringBuilder;
            var2_2(37);
            var2_2.append("Failed writing ");
            var2_2.append((char)var8_8);
            var2_2.append(" at index ");
            var2_2.append(var3_3);
            var2_2 = var2_2.toString();
            var1_1 = new ArrayIndexOutOfBoundsException((String)var2_2);
            throw var1_1;
        }
        return var3_3;
    }
}

