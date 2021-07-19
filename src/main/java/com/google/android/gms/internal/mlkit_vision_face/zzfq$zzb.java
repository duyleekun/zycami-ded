/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzeu;
import com.google.android.gms.internal.mlkit_vision_face.zzex;
import com.google.android.gms.internal.mlkit_vision_face.zzez;
import com.google.android.gms.internal.mlkit_vision_face.zzfq;
import com.google.android.gms.internal.mlkit_vision_face.zzfq$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzhl;
import com.google.android.gms.internal.mlkit_vision_face.zzib;
import com.google.android.gms.internal.mlkit_vision_face.zziz;
import com.google.android.gms.internal.mlkit_vision_face.zzjc;
import com.google.android.gms.internal.mlkit_vision_face.zzjg;
import com.google.android.gms.internal.mlkit_vision_face.zzjn;
import java.util.Objects;

public final class zzfq$zzb
extends zzfq {
    private final byte[] zzb;
    private final int zzc;
    private final int zzd;
    private int zze;

    public zzfq$zzb(byte[] object, int n10, int n11) {
        super(null);
        Object object2 = "buffer";
        Objects.requireNonNull(object, (String)object2);
        n10 = n11 | 0;
        int n12 = ((byte[])object).length - n11;
        n10 |= n12;
        n12 = 0;
        Integer n13 = null;
        if (n10 >= 0) {
            this.zzb = object;
            this.zzc = 0;
            this.zze = 0;
            this.zzd = n11;
            return;
        }
        Object[] objectArray = new Object[3];
        object = ((byte[])object).length;
        objectArray[0] = object;
        n13 = 0;
        objectArray[1] = n13;
        Integer n14 = n11;
        objectArray[2] = n14;
        object = String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", objectArray);
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    private final void zzc(byte[] byArray, int n10, int n11) {
        Object[] objectArray;
        try {
            objectArray = this.zzb;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            objectArray = new Object[3];
            Integer n12 = this.zze;
            objectArray[0] = (byte)n12;
            n12 = this.zzd;
            objectArray[1] = (byte)n12;
            Object object = n11;
            objectArray[2] = (byte)object;
            object = String.format("Pos: %d, limit: %d, len: %d", objectArray);
            zzfq$zza zzfq$zza = new zzfq$zza((String)object, indexOutOfBoundsException);
            throw zzfq$zza;
        }
        int n13 = this.zze;
        System.arraycopy(byArray, n10, objectArray, n13, n11);
        int n14 = this.zze + n11;
        this.zze = n14;
    }

    public final int zza() {
        int n10 = this.zzd;
        int n11 = this.zze;
        return n10 - n11;
    }

    public final void zza(byte by2) {
        Object object;
        try {
            object = this.zzb;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object = new zzfq$zza;
            Object object2 = new Object[3];
            Integer n10 = this.zze;
            object2[0] = n10;
            Integer n11 = this.zzd;
            int n12 = 1;
            object2[n12] = n11;
            n10 = n12;
            object2[2] = n10;
            object2 = String.format("Pos: %d, limit: %d, len: %d", object2);
            object((String)object2, indexOutOfBoundsException);
            throw object;
        }
        int n13 = this.zze;
        int n14 = n13 + 1;
        this.zze = n14;
        object[n13] = by2;
    }

    public final void zza(int n10) {
        if (n10 >= 0) {
            ((zzfq)this).zzb(n10);
            return;
        }
        long l10 = n10;
        ((zzfq)this).zza(l10);
    }

    public final void zza(int n10, int n11) {
        n10 = n10 << 3 | n11;
        ((zzfq)this).zzb(n10);
    }

    public final void zza(int n10, long l10) {
        ((zzfq)this).zza(n10, 0);
        ((zzfq)this).zza(l10);
    }

    public final void zza(int n10, zzez zzez2) {
        ((zzfq)this).zza(n10, 2);
        ((zzfq)this).zza(zzez2);
    }

    public final void zza(int n10, zzhl zzhl2) {
        int n11 = 1;
        int n12 = 3;
        ((zzfq)this).zza(n11, n12);
        int n13 = 2;
        ((zzfq)this).zzc(n13, n10);
        ((zzfq)this).zza(n12, n13);
        ((zzfq)this).zza(zzhl2);
        ((zzfq)this).zza(n11, 4);
    }

    public final void zza(int n10, zzhl zzhl2, zzib zzib2) {
        ((zzfq)this).zza(n10, 2);
        Object object = zzhl2;
        object = (zzeu)zzhl2;
        int n11 = ((zzeu)object).zzg();
        int n12 = -1;
        if (n11 == n12) {
            n11 = zzib2.zzb(object);
            ((zzeu)object).zza(n11);
        }
        ((zzfq)this).zzb(n11);
        object = this.zza;
        zzib2.zza((Object)zzhl2, (zzjn)object);
    }

    public final void zza(int n10, String string2) {
        ((zzfq)this).zza(n10, 2);
        ((zzfq)this).zza(string2);
    }

    public final void zza(int n10, boolean bl2) {
        ((zzfq)this).zza(n10, 0);
        n10 = (byte)(bl2 ? 1 : 0);
        ((zzfq)this).zza((byte)n10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zza(long var1_1) {
        var3_2 = zzfq.zzc();
        var4_3 = 7;
        var5_4 = 0L;
        var7_5 = -128;
        if (var3_2 != 0 && (var3_2 = this.zza()) >= (var9_6 = 10)) {
            while (true) {
                if ((var3_2 = (int)((cfr_temp_0 = (var10_10 = var1_1 & var7_5) - var5_4) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) == 0) {
                    var12_12 = this.zzb;
                    var4_3 = this.zze;
                    this.zze = var13_14 = var4_3 + 1;
                    var14_16 = var4_3;
                    var16_17 = (byte)var1_1;
                    zziz.zza(var12_12, var14_16, var16_17);
                    return;
                }
                var12_12 = this.zzb;
                var9_6 = this.zze;
                this.zze = var17_7 = var9_6 + 1;
                var10_10 = var9_6;
                var18_9 = (byte)((int)var1_1 & 127 | 128);
                zziz.zza(var12_12, var10_10, var18_9);
                var1_1 >>>= var4_3;
            }
        }
        while (true) {
            if ((var3_2 = (int)((cfr_temp_1 = (var10_11 = var1_1 & var7_5) - var5_4) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) != 0) ** GOTO lbl48
            var12_13 /* !! */  = this.zzb;
            break;
        }
        catch (IndexOutOfBoundsException var19_19) {
            var12_13 /* !! */  = (byte[])new Object[3];
            var21_21 = this.zze;
            var12_13 /* !! */ [0] = (byte)var21_21;
            var22_22 = this.zzd;
            var13_15 = 1;
            var12_13 /* !! */ [var13_15] = (byte)var22_22;
            var21_21 = var13_15;
            var12_13 /* !! */ [2] = (byte)var21_21;
            var12_13 /* !! */  = (byte[])String.format("Pos: %d, limit: %d, len: %d", var12_13 /* !! */ );
            var20_20 = new zzfq$zza((String)var12_13 /* !! */ , var19_19);
            throw var20_20;
        }
        {
            var4_3 = this.zze;
            var13_15 = var4_3 + 1;
            this.zze = var13_15;
            var16_18 = (byte)var1_1;
            var12_13 /* !! */ [var4_3] = var16_18;
            return;
lbl48:
            // 1 sources

            var12_13 /* !! */  = this.zzb;
            var9_6 = this.zze;
            var17_8 = var9_6 + 1;
            this.zze = var17_8;
            var17_8 = (byte)((int)var1_1 & 127 | 128);
            var12_13 /* !! */ [var9_6] = var17_8;
            var1_1 >>>= var4_3;
            continue;
        }
    }

    public final void zza(zzez zzez2) {
        int n10 = zzez2.zza();
        ((zzfq)this).zzb(n10);
        zzez2.zza(this);
    }

    public final void zza(zzhl zzhl2) {
        int n10 = zzhl2.zzj();
        ((zzfq)this).zzb(n10);
        zzhl2.zza(this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zza(String string2) {
        int n10 = this.zze;
        try {
            int n11 = string2.length() * 3;
            n11 = zzfq.zzg(n11);
            int n12 = string2.length();
            n12 = zzfq.zzg(n12);
            if (n12 == n11) {
                this.zze = n11 = n10 + n12;
                byte[] byArray = this.zzb;
                int n13 = ((zzfq)this).zza();
                n11 = zzjc.zza(string2, byArray, n11, n13);
                this.zze = n10;
                int n14 = n11 - n10 - n12;
                ((zzfq)this).zzb(n14);
                this.zze = n11;
                return;
            }
            n11 = zzjc.zza(string2);
            ((zzfq)this).zzb(n11);
            byte[] byArray = this.zzb;
            n12 = this.zze;
            int n15 = ((zzfq)this).zza();
            this.zze = n11 = zzjc.zza(string2, byArray, n12, n15);
            return;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            zzfq$zza zzfq$zza = new zzfq$zza(indexOutOfBoundsException);
            throw zzfq$zza;
        }
        catch (zzjg zzjg2) {
            this.zze = n10;
            this.zza(string2, zzjg2);
            return;
        }
    }

    public final void zza(byte[] byArray, int n10, int n11) {
        this.zzc(byArray, n10, n11);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzb(int var1_1) {
        var2_2 = zzfq.zzc();
        if (var2_2 != 0 && (var2_2 = zzex.zza()) == 0 && (var2_2 = this.zza()) >= (var3_3 = 5)) {
            var2_2 = var1_1 & -128;
            if (var2_2 == 0) {
                var4_4 = this.zzb;
                var3_3 = this.zze;
                this.zze = var5_7 = var3_3 + 1;
                var6_10 = var3_3;
                var1_1 = (byte)var1_1;
                zziz.zza(var4_4, var6_10, (byte)var1_1);
                return;
            }
            var4_5 = this.zzb;
            var3_3 = this.zze;
            this.zze = var5_8 = var3_3 + 1;
            var6_11 = var3_3;
            var8_12 = (byte)(var1_1 | 128);
            zziz.zza(var4_5, var6_11, var8_12);
            var2_2 = (var1_1 >>>= 7) & -128;
            if (var2_2 == 0) {
                var4_5 = this.zzb;
                var3_3 = this.zze;
                this.zze = var5_8 = var3_3 + 1;
                var6_11 = var3_3;
                var1_1 = (byte)var1_1;
                zziz.zza(var4_5, var6_11, (byte)var1_1);
                return;
            }
            var4_5 = this.zzb;
            var3_3 = this.zze;
            this.zze = var5_8 = var3_3 + 1;
            var6_11 = var3_3;
            var8_12 = (byte)(var1_1 | 128);
            zziz.zza(var4_5, var6_11, var8_12);
            var2_2 = (var1_1 >>>= 7) & -128;
            if (var2_2 == 0) {
                var4_5 = this.zzb;
                var3_3 = this.zze;
                this.zze = var5_8 = var3_3 + 1;
                var6_11 = var3_3;
                var1_1 = (byte)var1_1;
                zziz.zza(var4_5, var6_11, (byte)var1_1);
                return;
            }
            var4_5 = this.zzb;
            var3_3 = this.zze;
            this.zze = var5_8 = var3_3 + 1;
            var6_11 = var3_3;
            var8_12 = (byte)(var1_1 | 128);
            zziz.zza(var4_5, var6_11, var8_12);
            var2_2 = (var1_1 >>>= 7) & -128;
            if (var2_2 == 0) {
                var4_5 = this.zzb;
                var3_3 = this.zze;
                this.zze = var5_8 = var3_3 + 1;
                var6_11 = var3_3;
                var1_1 = (byte)var1_1;
                zziz.zza(var4_5, var6_11, (byte)var1_1);
                return;
            }
            var4_5 = this.zzb;
            var3_3 = this.zze;
            this.zze = var5_8 = var3_3 + 1;
            var6_11 = var3_3;
            var8_12 = (byte)(var1_1 | 128);
            zziz.zza(var4_5, var6_11, var8_12);
            var1_1 >>>= 7;
            var4_5 = this.zzb;
            var3_3 = this.zze;
            this.zze = var5_8 = var3_3 + 1;
            var6_11 = var3_3;
            var1_1 = (byte)var1_1;
            zziz.zza(var4_5, var6_11, (byte)var1_1);
            return;
        }
        while (true) {
            if ((var2_2 = var1_1 & -128) != 0) ** GOTO lbl97
            var4_6 /* !! */  = this.zzb;
            break;
        }
        catch (IndexOutOfBoundsException var9_14) {
            var4_6 /* !! */  = (byte[])new zzfq$zza;
            var10_15 /* !! */  = new Object[3];
            var11_16 = this.zze;
            var10_15 /* !! */ [0] = var11_16;
            var12_17 = this.zzd;
            var8_13 = 1;
            var10_15 /* !! */ [var8_13] = var12_17;
            var11_16 = var8_13;
            var10_15 /* !! */ [2] = var11_16;
            var10_15 /* !! */  = String.format("Pos: %d, limit: %d, len: %d", var10_15 /* !! */ );
            var4_6 /* !! */ ((String)var10_15 /* !! */ , var9_14);
            throw var4_6 /* !! */ ;
        }
        {
            var3_3 = this.zze;
            var5_9 = var3_3 + 1;
            this.zze = var5_9;
            var1_1 = (byte)var1_1;
            var4_6 /* !! */ [var3_3] = var1_1;
            return;
lbl97:
            // 1 sources

            var4_6 /* !! */  = this.zzb;
            var3_3 = this.zze;
            var5_9 = var3_3 + 1;
            this.zze = var5_9;
            var5_9 = (byte)(var1_1 & 127 | 128);
            var4_6 /* !! */ [var3_3] = var5_9;
            var1_1 >>>= 7;
            continue;
        }
    }

    public final void zzb(int n10, int n11) {
        ((zzfq)this).zza(n10, 0);
        ((zzfq)this).zza(n11);
    }

    public final void zzb(int n10, zzez zzez2) {
        int n11 = 1;
        int n12 = 3;
        ((zzfq)this).zza(n11, n12);
        ((zzfq)this).zzc(2, n10);
        ((zzfq)this).zza(n12, zzez2);
        ((zzfq)this).zza(n11, 4);
    }

    public final void zzb(byte[] byArray, int n10, int n11) {
        ((zzfq)this).zzb(n11);
        this.zzc(byArray, 0, n11);
    }

    public final void zzc(int n10, int n11) {
        ((zzfq)this).zza(n10, 0);
        ((zzfq)this).zzb(n11);
    }

    public final void zzc(int n10, long l10) {
        ((zzfq)this).zza(n10, 1);
        ((zzfq)this).zzc(l10);
    }

    public final void zzc(long l10) {
        int n10;
        Object object;
        try {
            object = this.zzb;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object = new Object[3];
            Integer n11 = this.zze;
            object[0] = (byte)n11;
            Integer n12 = this.zzd;
            n10 = 1;
            object[n10] = (byte)n12;
            n11 = n10;
            object[2] = (byte)n11;
            object = String.format("Pos: %d, limit: %d, len: %d", object);
            zzfq$zza zzfq$zza = new zzfq$zza((String)object, indexOutOfBoundsException);
            throw zzfq$zza;
        }
        int n13 = this.zze;
        n10 = n13 + 1;
        this.zze = n10;
        byte by2 = (byte)l10;
        object[n13] = by2;
        n13 = n10 + 1;
        this.zze = n13;
        long l11 = l10 >> 8;
        by2 = (byte)l11;
        object[n10] = by2;
        n10 = n13 + 1;
        this.zze = n10;
        l11 = l10 >> 16;
        by2 = (byte)l11;
        object[n13] = by2;
        n13 = n10 + 1;
        this.zze = n13;
        l11 = l10 >> 24;
        by2 = (byte)l11;
        object[n10] = by2;
        n10 = n13 + 1;
        this.zze = n10;
        l11 = l10 >> 32;
        by2 = (byte)l11;
        object[n13] = by2;
        n13 = n10 + 1;
        this.zze = n13;
        l11 = l10 >> 40;
        by2 = (byte)l11;
        object[n10] = by2;
        n10 = n13 + 1;
        this.zze = n10;
        l11 = l10 >> 48;
        by2 = (byte)l11;
        object[n13] = by2;
        n13 = n10 + 1;
        this.zze = n13;
        n13 = 56;
        byte by3 = (byte)(l10 >>= n13);
        object[n10] = by3;
    }

    public final void zzd(int n10) {
        byte by2;
        Object object;
        try {
            object = this.zzb;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object = new zzfq$zza;
            Object object2 = new Object[3];
            Integer n11 = this.zze;
            object2[0] = n11;
            Integer n12 = this.zzd;
            by2 = 1;
            object2[by2] = n12;
            n11 = by2;
            object2[2] = n11;
            object2 = String.format("Pos: %d, limit: %d, len: %d", object2);
            object((String)object2, indexOutOfBoundsException);
            throw object;
        }
        int n13 = this.zze;
        int n14 = n13 + 1;
        this.zze = n14;
        by2 = (byte)n10;
        object[n13] = by2;
        n13 = n14 + 1;
        this.zze = n13;
        by2 = (byte)(n10 >> 8);
        object[n14] = by2;
        n14 = n13 + 1;
        this.zze = n14;
        by2 = (byte)(n10 >> 16);
        object[n13] = by2;
        n13 = n14 + 1;
        this.zze = n13;
        n10 = (byte)(n10 >>> 24);
        object[n14] = n10;
    }

    public final void zze(int n10, int n11) {
        ((zzfq)this).zza(n10, 5);
        ((zzfq)this).zzd(n11);
    }
}

