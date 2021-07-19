/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzgy;
import com.google.android.gms.internal.measurement.zzgz;
import com.google.android.gms.internal.measurement.zzkh;
import com.google.android.gms.internal.measurement.zzkl;
import com.google.android.gms.internal.measurement.zzkn;

public final class zzgx
extends zzgz {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    public zzgx(byte[] object, int n10, int n11) {
        Object object2 = null;
        super(null);
        n10 = ((byte[])object).length;
        int n12 = n10 - n11 | n11;
        Integer n13 = null;
        if (n12 >= 0) {
            this.zzb = object;
            this.zzd = 0;
            this.zzc = n11;
            return;
        }
        object = new IllegalArgumentException;
        Object[] objectArray = new Object[3];
        objectArray[0] = object2 = Integer.valueOf(n10);
        n13 = 0;
        objectArray[1] = n13;
        Integer n14 = n11;
        objectArray[2] = n14;
        object2 = String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", objectArray);
        super((String)object2);
        throw object;
    }

    public final void zza(int n10, int n11) {
        n10 = n10 << 3 | n11;
        this.zzl(n10);
    }

    public final void zzb(int n10, int n11) {
        this.zzl(n10 <<= 3);
        this.zzk(n11);
    }

    public final void zzc(int n10, int n11) {
        this.zzl(n10 <<= 3);
        this.zzl(n11);
    }

    public final void zzd(int n10, int n11) {
        n10 = n10 << 3 | 5;
        this.zzl(n10);
        this.zzm(n11);
    }

    public final void zze(int n10, long l10) {
        this.zzl(n10 <<= 3);
        this.zzn(l10);
    }

    public final void zzf(int n10, long l10) {
        n10 = n10 << 3 | 1;
        this.zzl(n10);
        this.zzo(l10);
    }

    public final void zzg(int n10, boolean bl2) {
        this.zzl(n10 <<= 3);
        this.zzj((byte)(bl2 ? 1 : 0));
    }

    public final void zzh(int n10, String string2) {
        n10 = n10 << 3 | 2;
        this.zzl(n10);
        this.zzr(string2);
    }

    public final void zzi(int n10, zzgs zzgs2) {
        n10 = n10 << 3 | 2;
        this.zzl(n10);
        n10 = zzgs2.zzc();
        this.zzl(n10);
        zzgs2.zzf(this);
    }

    public final void zzj(byte by2) {
        Object object;
        try {
            object = this.zzb;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object = new zzgy;
            Object object2 = new Object[3];
            Integer n10 = this.zzd;
            object2[0] = n10;
            Integer n11 = this.zzc;
            int n12 = 1;
            object2[n12] = n11;
            n10 = n12;
            object2[2] = n10;
            object2 = String.format("Pos: %d, limit: %d, len: %d", object2);
            object((String)object2, indexOutOfBoundsException);
            throw object;
        }
        int n13 = this.zzd;
        int n14 = n13 + 1;
        this.zzd = n14;
        object[n13] = by2;
    }

    public final void zzk(int n10) {
        if (n10 >= 0) {
            this.zzl(n10);
            return;
        }
        long l10 = n10;
        this.zzn(l10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzl(int var1_1) {
        var2_2 = zzgz.zzF();
        if (var2_2 != 0 && (var2_2 = zzgd.zza()) == 0) {
            var2_2 = this.zzc;
            var3_3 = this.zzd;
            var4_4 = 5;
            if ((var2_2 -= var3_3) >= var4_4) {
                var2_2 = var1_1 & -128;
                if (var2_2 == 0) {
                    var5_5 = this.zzb;
                    this.zzd = var4_4 = var3_3 + 1;
                    var6_8 = var3_3;
                    var1_1 = (byte)var1_1;
                    zzkh.zzq(var5_5, var6_8, (byte)var1_1);
                    return;
                }
                var5_6 = this.zzb;
                this.zzd = var4_4 = var3_3 + 1;
                var6_9 = var3_3;
                var8_10 = (byte)(var1_1 | 128);
                zzkh.zzq(var5_6, var6_9, var8_10);
                var2_2 = (var1_1 >>>= 7) & -128;
                if (var2_2 == 0) {
                    var5_6 = this.zzb;
                    var3_3 = this.zzd;
                    this.zzd = var4_4 = var3_3 + 1;
                    var6_9 = var3_3;
                    var1_1 = (byte)var1_1;
                    zzkh.zzq(var5_6, var6_9, (byte)var1_1);
                    return;
                }
                var5_6 = this.zzb;
                var3_3 = this.zzd;
                this.zzd = var4_4 = var3_3 + 1;
                var6_9 = var3_3;
                var8_10 = (byte)(var1_1 | 128);
                zzkh.zzq(var5_6, var6_9, var8_10);
                var2_2 = (var1_1 >>>= 7) & -128;
                if (var2_2 == 0) {
                    var5_6 = this.zzb;
                    var3_3 = this.zzd;
                    this.zzd = var4_4 = var3_3 + 1;
                    var6_9 = var3_3;
                    var1_1 = (byte)var1_1;
                    zzkh.zzq(var5_6, var6_9, (byte)var1_1);
                    return;
                }
                var5_6 = this.zzb;
                var3_3 = this.zzd;
                this.zzd = var4_4 = var3_3 + 1;
                var6_9 = var3_3;
                var8_10 = (byte)(var1_1 | 128);
                zzkh.zzq(var5_6, var6_9, var8_10);
                var2_2 = (var1_1 >>>= 7) & -128;
                if (var2_2 == 0) {
                    var5_6 = this.zzb;
                    var3_3 = this.zzd;
                    this.zzd = var4_4 = var3_3 + 1;
                    var6_9 = var3_3;
                    var1_1 = (byte)var1_1;
                    zzkh.zzq(var5_6, var6_9, (byte)var1_1);
                    return;
                }
                var5_6 = this.zzb;
                var3_3 = this.zzd;
                this.zzd = var4_4 = var3_3 + 1;
                var6_9 = var3_3;
                var8_10 = (byte)(var1_1 | 128);
                zzkh.zzq(var5_6, var6_9, var8_10);
                var5_6 = this.zzb;
                var3_3 = this.zzd;
                this.zzd = var4_4 = var3_3 + 1;
                var6_9 = var3_3;
                var1_1 = (byte)(var1_1 >>> 7);
                zzkh.zzq(var5_6, var6_9, (byte)var1_1);
                return;
            }
        }
        while (true) {
            if ((var2_2 = var1_1 & -128) != 0) ** GOTO lbl98
            var5_7 /* !! */  = this.zzb;
            break;
        }
        catch (IndexOutOfBoundsException var9_12) {
            var5_7 /* !! */  = (byte[])new zzgy;
            var10_13 /* !! */  = new Object[3];
            var11_14 = this.zzd;
            var10_13 /* !! */ [0] = var11_14;
            var12_15 = this.zzc;
            var8_11 = 1;
            var10_13 /* !! */ [var8_11] = var12_15;
            var11_14 = var8_11;
            var10_13 /* !! */ [2] = var11_14;
            var10_13 /* !! */  = String.format("Pos: %d, limit: %d, len: %d", var10_13 /* !! */ );
            var5_7 /* !! */ ((String)var10_13 /* !! */ , var9_12);
            throw var5_7 /* !! */ ;
        }
        {
            var3_3 = this.zzd;
            var4_4 = var3_3 + 1;
            this.zzd = var4_4;
            var1_1 = (byte)var1_1;
            var5_7 /* !! */ [var3_3] = var1_1;
            return;
lbl98:
            // 1 sources

            var5_7 /* !! */  = this.zzb;
            var3_3 = this.zzd;
            var4_4 = var3_3 + 1;
            this.zzd = var4_4;
            var4_4 = (byte)(var1_1 & 127 | 128);
            var5_7 /* !! */ [var3_3] = var4_4;
            var1_1 >>>= 7;
            continue;
        }
    }

    public final void zzm(int n10) {
        byte by2;
        Object object;
        try {
            object = this.zzb;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object = new zzgy;
            Object object2 = new Object[3];
            Integer n11 = this.zzd;
            object2[0] = n11;
            Integer n12 = this.zzc;
            by2 = 1;
            object2[by2] = n12;
            n11 = by2;
            object2[2] = n11;
            object2 = String.format("Pos: %d, limit: %d, len: %d", object2);
            object((String)object2, indexOutOfBoundsException);
            throw object;
        }
        int n13 = this.zzd;
        int n14 = n13 + 1;
        this.zzd = n14;
        by2 = (byte)(n10 & 0xFF);
        object[n13] = by2;
        n13 = n14 + 1;
        this.zzd = n13;
        by2 = (byte)(n10 >> 8 & 0xFF);
        object[n14] = by2;
        n14 = n13 + 1;
        this.zzd = n14;
        by2 = (byte)(n10 >> 16 & 0xFF);
        object[n13] = by2;
        n13 = n14 + 1;
        this.zzd = n13;
        n10 = (byte)(n10 >> 24 & 0xFF);
        object[n14] = n10;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzn(long var1_1) {
        var3_2 = zzgz.zzF();
        var4_3 = 7;
        var5_4 = 0L;
        var7_5 = -128;
        if (var3_2 != 0) {
            var3_2 = this.zzc;
            var9_6 = this.zzd;
            if ((var3_2 -= var9_6) >= (var9_6 = 10)) {
                while (true) {
                    if ((var3_2 = (int)((cfr_temp_0 = (var10_10 = var1_1 & var7_5) - var5_4) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) == 0) {
                        var12_12 = this.zzb;
                        var4_3 = this.zzd;
                        this.zzd = var13_14 = var4_3 + 1;
                        var14_16 = var4_3;
                        var16_17 = (byte)var1_1;
                        zzkh.zzq(var12_12, var14_16, var16_17);
                        return;
                    }
                    var12_12 = this.zzb;
                    var9_6 = this.zzd;
                    this.zzd = var17_7 = var9_6 + 1;
                    var10_10 = var9_6;
                    var18_9 = (byte)((int)var1_1 & 127 | 128);
                    zzkh.zzq(var12_12, var10_10, var18_9);
                    var1_1 >>>= var4_3;
                }
            }
        }
        while (true) {
            if ((var3_2 = (int)((cfr_temp_1 = (var10_11 = var1_1 & var7_5) - var5_4) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) != 0) ** GOTO lbl51
            var12_13 /* !! */  = this.zzb;
            break;
        }
        catch (IndexOutOfBoundsException var19_19) {
            var12_13 /* !! */  = (byte[])new Object[3];
            var21_21 = this.zzd;
            var12_13 /* !! */ [0] = (byte)var21_21;
            var22_22 = this.zzc;
            var13_15 = 1;
            var12_13 /* !! */ [var13_15] = (byte)var22_22;
            var21_21 = var13_15;
            var12_13 /* !! */ [2] = (byte)var21_21;
            var12_13 /* !! */  = (byte[])String.format("Pos: %d, limit: %d, len: %d", var12_13 /* !! */ );
            var20_20 = new zzgy((String)var12_13 /* !! */ , var19_19);
            throw var20_20;
        }
        {
            var4_3 = this.zzd;
            var13_15 = var4_3 + 1;
            this.zzd = var13_15;
            var16_18 = (byte)var1_1;
            var12_13 /* !! */ [var4_3] = var16_18;
            return;
lbl51:
            // 1 sources

            var12_13 /* !! */  = this.zzb;
            var9_6 = this.zzd;
            var17_8 = var9_6 + 1;
            this.zzd = var17_8;
            var17_8 = (byte)((int)var1_1 & 127 | 128);
            var12_13 /* !! */ [var9_6] = var17_8;
            var1_1 >>>= var4_3;
            continue;
        }
    }

    public final void zzo(long l10) {
        int n10;
        Object object;
        try {
            object = this.zzb;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object = new Object[3];
            Integer n11 = this.zzd;
            object[0] = (byte)n11;
            Integer n12 = this.zzc;
            n10 = 1;
            object[n10] = (byte)n12;
            n11 = n10;
            object[2] = (byte)n11;
            object = String.format("Pos: %d, limit: %d, len: %d", object);
            zzgy zzgy2 = new zzgy((String)object, indexOutOfBoundsException);
            throw zzgy2;
        }
        int n13 = this.zzd;
        n10 = n13 + 1;
        this.zzd = n10;
        byte by2 = (byte)((int)l10 & 0xFF);
        object[n13] = by2;
        n13 = n10 + 1;
        this.zzd = n13;
        long l11 = l10 >> 8;
        by2 = (byte)((int)l11 & 0xFF);
        object[n10] = by2;
        n10 = n13 + 1;
        this.zzd = n10;
        l11 = l10 >> 16;
        by2 = (byte)((int)l11 & 0xFF);
        object[n13] = by2;
        n13 = n10 + 1;
        this.zzd = n13;
        l11 = l10 >> 24;
        by2 = (byte)((int)l11 & 0xFF);
        object[n10] = by2;
        n10 = n13 + 1;
        this.zzd = n10;
        l11 = l10 >> 32;
        by2 = (byte)((int)l11 & 0xFF);
        object[n13] = by2;
        n13 = n10 + 1;
        this.zzd = n13;
        l11 = l10 >> 40;
        by2 = (byte)((int)l11 & 0xFF);
        object[n10] = by2;
        n10 = n13 + 1;
        this.zzd = n10;
        l11 = l10 >> 48;
        by2 = (byte)((int)l11 & 0xFF);
        object[n13] = by2;
        n13 = n10 + 1;
        this.zzd = n13;
        n13 = 56;
        byte by3 = (byte)((int)(l10 >>= n13) & 0xFF);
        object[n10] = by3;
    }

    public final void zzp(byte[] byArray, int n10, int n11) {
        Object object;
        String string2 = null;
        try {
            object = this.zzb;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object = new zzgy;
            Object[] objectArray = new Object[3];
            Integer n12 = this.zzd;
            objectArray[0] = n12;
            n12 = this.zzc;
            objectArray[1] = n12;
            Integer n13 = n11;
            objectArray[2] = n13;
            string2 = String.format("Pos: %d, limit: %d, len: %d", objectArray);
            object(string2, indexOutOfBoundsException);
            throw object;
        }
        int n14 = this.zzd;
        System.arraycopy(byArray, 0, object, n14, n11);
        int n15 = this.zzd + n11;
        this.zzd = n15;
    }

    public final void zzq(byte[] byArray, int n10, int n11) {
        this.zzp(byArray, 0, n11);
    }

    /*
     * Unable to fully structure code
     */
    public final void zzr(String var1_1) {
        var2_3 = this.zzd;
        var3_4 = var1_1.length() * 3;
        var3_4 = zzgz.zzw(var3_4);
        var4_5 = var1_1.length();
        var4_5 = zzgz.zzw(var4_5);
        if (var4_5 != var3_4) ** GOTO lbl27
        var3_4 = var2_3 + var4_5;
        this.zzd = var3_4;
        var5_6 = this.zzb;
        var6_7 = this.zzc - var3_4;
        var3_4 = zzkn.zzd(var1_1, var5_6, var3_4, var6_7);
        this.zzd = var2_3;
        var7_8 = var3_4 - var2_3 - var4_5;
        this.zzl(var7_8);
        this.zzd = var3_4;
        return;
lbl27:
        // 1 sources

        var3_4 = zzkn.zzc(var1_1);
        this.zzl(var3_4);
        var8_10 = this.zzb;
        var4_5 = this.zzd;
        var7_9 = this.zzc - var4_5;
        var3_4 = zzkn.zzd(var1_1, var8_10, var4_5, var7_9);
        try {
            this.zzd = var3_4;
            return;
        }
        catch (IndexOutOfBoundsException var1_2) {
            var9_12 = new zzgy(var1_2);
            throw var9_12;
        }
        catch (zzkl var8_11) {
            this.zzd = var2_3;
            this.zzD(var1_1, var8_11);
            return;
        }
    }

    public final int zzs() {
        int n10 = this.zzc;
        int n11 = this.zzd;
        return n10 - n11;
    }
}

