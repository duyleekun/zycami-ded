/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzdq;
import com.google.android.gms.internal.vision.zzeb;
import com.google.android.gms.internal.vision.zzec;
import com.google.android.gms.internal.vision.zzef;
import com.google.android.gms.internal.vision.zzej;
import com.google.android.gms.internal.vision.zzer;
import com.google.android.gms.internal.vision.zzet;
import com.google.android.gms.internal.vision.zzew;
import java.util.Arrays;

public final class zzes
extends zzef {
    public static final zzef zznn;
    private final transient int size;
    private final transient Object[] zznd;
    private final transient Object zzno;

    static {
        Object[] objectArray = new Object[]{};
        zzes zzes2 = new zzes(null, objectArray, 0);
        zznn = zzes2;
    }

    private zzes(Object object, Object[] objectArray, int n10) {
        this.zzno = object;
        this.zznd = objectArray;
        this.size = n10;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static zzes zza(int var0, Object[] var1_1) {
        block13: {
            block15: {
                block14: {
                    if (var0 == 0) {
                        return (zzes)zzes.zznn;
                    }
                    var2_2 = 0;
                    var3_3 /* !! */  = null;
                    var5_5 = null;
                    var6_6 = 1;
                    if (var0 == var6_6) {
                        var7_7 = var1_1[0];
                        var5_5 = var1_1[var6_6];
                        zzdq.zza(var7_7, var5_5);
                        var7_7 = new zzes(null, var1_1, var6_6);
                        return var7_7;
                    }
                    var8_8 = var1_1.length >> var6_6;
                    zzde.zze(var0, var8_8);
                    var8_8 = zzej.zzy(var0);
                    if (var0 != var6_6) break block14;
                    var5_5 = var1_1[0];
                    var9_9 = var1_1[var6_6];
                    zzdq.zza(var5_5, var9_9);
                    break block13;
                }
                var2_2 = var8_8 + -1;
                var6_6 = 128;
                var10_11 = -1;
                if (var8_8 <= var6_6) {
                    var9_10 /* !! */  = new byte[var8_8];
                    Arrays.fill(var9_10 /* !! */ , var10_11);
                    block0: for (var4_4 = 0; var4_4 < var0; ++var4_4) {
                        var8_8 = var4_4 * 2;
                        var11_12 = var1_1[var8_8];
                        var12_14 = var8_8 ^ 1;
                        var13_16 = var1_1[var12_14];
                        zzdq.zza(var11_12, var13_16);
                        var14_19 = zzec.zzx(var11_12.hashCode());
                        while (true) {
                            var15_22 = var9_10 /* !! */ [var14_19 &= var2_2];
                            var16_25 = 255;
                            if ((var15_22 &= var16_25) == var16_25) {
                                var9_10 /* !! */ [var14_19] = var8_8 = (int)((byte)var8_8);
                                continue block0;
                            }
                            var17_28 = var1_1[var15_22];
                            var16_25 = (int)var17_28.equals(var11_12);
                            if (var16_25 != 0) break;
                            ++var14_19;
                        }
                        throw zzes.zza(var11_12, var13_16, var1_1, var15_22);
                    }
lbl48:
                    // 3 sources

                    while (true) {
                        var3_3 /* !! */  = var9_10 /* !! */ ;
                        break block13;
                        break;
                    }
                }
                var6_6 = 32768;
                if (var8_8 > var6_6) break block15;
                var9_10 /* !! */  = (byte[])new short[var8_8];
                Arrays.fill((short[])var9_10 /* !! */ , (short)var10_11);
                block3: while (true) {
                    if (var4_4 >= var0) ** GOTO lbl48
                    var8_8 = var4_4 * 2;
                    var11_13 = var1_1[var8_8];
                    var12_15 = var8_8 ^ 1;
                    var13_17 = var1_1[var12_15];
                    zzdq.zza(var11_13, var13_17);
                    var14_20 = zzec.zzx(var11_13.hashCode());
                    while (true) {
                        var15_23 = var9_10 /* !! */ [var14_20 &= var2_2];
                        var16_26 = (char)-1;
                        if ((var15_23 &= var16_26) == var16_26) {
                            var9_10 /* !! */ [var14_20] = var8_8 = (int)((short)var8_8);
                            ++var4_4;
                            continue block3;
                        }
                        var17_29 = var1_1[var15_23];
                        var16_26 = (char)var17_29.equals(var11_13);
                        if (var16_26 != '\u0000') break block3;
                        ++var14_20;
                    }
                    break;
                }
                throw zzes.zza(var11_13, var13_17, var1_1, var15_23);
            }
            var9_10 /* !! */  = (byte[])new int[var8_8];
            Arrays.fill((int[])var9_10 /* !! */ , (int)var10_11);
            block5: while (true) lbl-1000:
            // 2 sources

            {
                if (var4_4 >= var0) ** continue;
                var8_8 = var4_4 * 2;
                var13_18 = var1_1[var8_8];
                var14_21 = var8_8 ^ 1;
                var18_30 = var1_1[var14_21];
                zzdq.zza(var13_18, var18_30);
                var15_24 = zzec.zzx(var13_18.hashCode());
                while (true) {
                    if ((var16_27 = var9_10 /* !! */ [var15_24 &= var2_2]) == var10_11) {
                        var9_10 /* !! */ [var15_24] = var8_8;
                        ++var4_4;
                        ** continue;
                    }
                    var19_31 = var1_1[var16_27];
                    var20_32 = var19_31.equals(var13_18);
                    if (var20_32) break block5;
                    ++var15_24;
                }
                break;
            }
            throw zzes.zza(var13_18, var18_30, var1_1, var16_27);
        }
        var5_5 = new zzes(var3_3 /* !! */ , var1_1, var0);
        return var5_5;
    }

    private static IllegalArgumentException zza(Object object, Object object2, Object[] object3, int n10) {
        object = String.valueOf(object);
        object2 = String.valueOf(object2);
        String string2 = String.valueOf(object3[n10]);
        object3 = String.valueOf(object3[n10 ^= 1]);
        n10 = String.valueOf(object).length() + 39;
        int n11 = String.valueOf(object2).length();
        n10 += n11;
        n11 = String.valueOf(string2).length();
        n10 += n11;
        n11 = String.valueOf(object3).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append("Multiple entries with same key: ");
        stringBuilder.append((String)object);
        object = "=";
        stringBuilder.append((String)object);
        stringBuilder.append((String)object2);
        stringBuilder.append(" and ");
        stringBuilder.append(string2);
        stringBuilder.append((String)object);
        stringBuilder.append((String)object3);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        return illegalArgumentException;
    }

    public final Object get(Object object) {
        Object object2 = this.zzno;
        Object[] objectArray = this.zznd;
        int n10 = this.size;
        if (object == null) {
            return null;
        }
        int n11 = 1;
        if (n10 == n11) {
            boolean bl2 = false;
            object2 = objectArray[0];
            boolean bl3 = object2.equals(object);
            if (bl3) {
                return objectArray[n11];
            }
            return null;
        }
        if (object2 == null) {
            return null;
        }
        n10 = object2 instanceof byte[];
        if (n10 != 0) {
            Object object3 = object2;
            object3 = (byte[])object2;
            int n12 = ((Object)object3).length + -1;
            int n13 = zzec.zzx(object.hashCode());
            while (true) {
                Object object4 = object3[n13 &= n12];
                int n14 = 255;
                if ((object4 = (Object)(object4 & n14)) == n14) {
                    return null;
                }
                Object object5 = objectArray[object4];
                n14 = (int)(object5.equals(object) ? 1 : 0);
                if (n14 != 0) {
                    int n15 = object4 ^ 1;
                    return objectArray[n15];
                }
                ++n13;
            }
        }
        n10 = object2 instanceof short[];
        if (n10 != 0) {
            Object object6 = object2;
            object6 = (short[])object2;
            int n16 = ((Object)object6).length + -1;
            int n17 = zzec.zzx(object.hashCode());
            while (true) {
                Object object7 = object6[n17 &= n16];
                char c10 = (char)-1;
                if ((object7 = (Object)(object7 & c10)) == c10) {
                    return null;
                }
                Object object8 = objectArray[object7];
                c10 = (char)(object8.equals(object) ? 1 : 0);
                if (c10 != '\u0000') {
                    int n18 = object7 ^ 1;
                    return objectArray[n18];
                }
                ++n17;
            }
        }
        object2 = (int[])object2;
        n10 = ((Object)object2).length - n11;
        int n19 = zzec.zzx(object.hashCode());
        int n20;
        Object object9;
        while ((object9 = object2[n19 &= n10]) != (n20 = -1)) {
            Object object10 = objectArray[object9];
            n20 = (int)(object10.equals(object) ? 1 : 0);
            if (n20 != 0) {
                int n21 = object9 ^ 1;
                return objectArray[n21];
            }
            ++n19;
        }
        return null;
    }

    public final int size() {
        return this.size;
    }

    public final zzej zzcw() {
        Object[] objectArray = this.zznd;
        int n10 = this.size;
        zzer zzer2 = new zzer(this, objectArray, 0, n10);
        return zzer2;
    }

    public final zzej zzcx() {
        Object object = this.zznd;
        int n10 = this.size;
        zzew zzew2 = new zzew((Object[])object, 0, n10);
        object = new zzet(this, zzew2);
        return object;
    }

    public final zzeb zzcy() {
        Object[] objectArray = this.zznd;
        int n10 = this.size;
        zzew zzew2 = new zzew(objectArray, 1, n10);
        return zzew2;
    }
}

