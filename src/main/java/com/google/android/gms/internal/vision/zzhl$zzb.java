/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzge;
import com.google.android.gms.internal.vision.zzgl;
import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzhl;
import com.google.android.gms.internal.vision.zzhl$zza;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzkf;
import com.google.android.gms.internal.vision.zzld;
import com.google.android.gms.internal.vision.zzlf;
import com.google.android.gms.internal.vision.zzlj;
import com.google.android.gms.internal.vision.zzlq;
import java.util.Objects;

public final class zzhl$zzb
extends zzhl {
    private final byte[] buffer;
    private final int limit;
    private final int offset;
    private int position;

    public zzhl$zzb(byte[] object, int n10, int n11) {
        super(null);
        Object object2 = "buffer";
        Objects.requireNonNull(object, (String)object2);
        n10 = n11 | 0;
        int n12 = ((byte[])object).length - n11;
        n10 |= n12;
        n12 = 0;
        Integer n13 = null;
        if (n10 >= 0) {
            this.buffer = object;
            this.offset = 0;
            this.position = 0;
            this.limit = n11;
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

    private final void write(byte[] byArray, int n10, int n11) {
        Object[] objectArray;
        try {
            objectArray = this.buffer;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            objectArray = new Object[3];
            Integer n12 = this.position;
            objectArray[0] = (byte)n12;
            n12 = this.limit;
            objectArray[1] = (byte)n12;
            Object object = n11;
            objectArray[2] = (byte)object;
            object = String.format("Pos: %d, limit: %d, len: %d", objectArray);
            zzhl$zza zzhl$zza = new zzhl$zza((String)object, indexOutOfBoundsException);
            throw zzhl$zza;
        }
        int n13 = this.position;
        System.arraycopy(byArray, n10, objectArray, n13, n11);
        int n14 = this.position + n11;
        this.position = n14;
    }

    public final void writeTag(int n10, int n11) {
        n10 = n10 << 3 | n11;
        ((zzhl)this).zzbe(n10);
    }

    public final void zza(int n10, long l10) {
        ((zzhl)this).writeTag(n10, 0);
        ((zzhl)this).zzs(l10);
    }

    public final void zza(int n10, zzgs zzgs2) {
        ((zzhl)this).writeTag(n10, 2);
        ((zzhl)this).zza(zzgs2);
    }

    public final void zza(int n10, zzjn zzjn2) {
        int n11 = 1;
        int n12 = 3;
        ((zzhl)this).writeTag(n11, n12);
        int n13 = 2;
        ((zzhl)this).zzk(n13, n10);
        ((zzhl)this).writeTag(n12, n13);
        ((zzhl)this).zzb(zzjn2);
        ((zzhl)this).writeTag(n11, 4);
    }

    public final void zza(int n10, zzjn zzjn2, zzkf zzkf2) {
        ((zzhl)this).writeTag(n10, 2);
        Object object = zzjn2;
        object = (zzge)zzjn2;
        int n11 = ((zzge)object).zzef();
        int n12 = -1;
        if (n11 == n12) {
            n11 = zzkf2.zzu(object);
            ((zzge)object).zzak(n11);
        }
        ((zzhl)this).zzbe(n11);
        object = this.zzuo;
        zzkf2.zza(zzjn2, (zzlq)object);
    }

    public final void zza(int n10, String string2) {
        ((zzhl)this).writeTag(n10, 2);
        ((zzhl)this).zzw(string2);
    }

    public final void zza(int n10, boolean bl2) {
        ((zzhl)this).writeTag(n10, 0);
        n10 = (byte)(bl2 ? 1 : 0);
        ((zzhl)this).zzc((byte)n10);
    }

    public final void zza(zzgs zzgs2) {
        int n10 = zzgs2.size();
        ((zzhl)this).zzbe(n10);
        zzgs2.zza(this);
    }

    public final void zzb(int n10, zzgs zzgs2) {
        int n11 = 1;
        int n12 = 3;
        ((zzhl)this).writeTag(n11, n12);
        ((zzhl)this).zzk(2, n10);
        ((zzhl)this).zza(n12, zzgs2);
        ((zzhl)this).writeTag(n11, 4);
    }

    public final void zzb(zzjn zzjn2) {
        int n10 = zzjn2.zzgz();
        ((zzhl)this).zzbe(n10);
        zzjn2.zzb(this);
    }

    public final void zzbd(int n10) {
        if (n10 >= 0) {
            ((zzhl)this).zzbe(n10);
            return;
        }
        long l10 = n10;
        ((zzhl)this).zzs(l10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzbe(int var1_1) {
        var2_2 = zzhl.zzgc();
        if (var2_2 != 0 && (var2_2 = zzgl.zzel()) == 0 && (var2_2 = this.zzga()) >= (var3_3 = 5)) {
            var2_2 = var1_1 & -128;
            if (var2_2 == 0) {
                var4_4 = this.buffer;
                var3_3 = this.position;
                this.position = var5_7 = var3_3 + 1;
                var6_10 = var3_3;
                var1_1 = (byte)var1_1;
                zzld.zza(var4_4, var6_10, (byte)var1_1);
                return;
            }
            var4_5 = this.buffer;
            var3_3 = this.position;
            this.position = var5_8 = var3_3 + 1;
            var6_11 = var3_3;
            var8_12 = (byte)(var1_1 | 128);
            zzld.zza(var4_5, var6_11, var8_12);
            var2_2 = (var1_1 >>>= 7) & -128;
            if (var2_2 == 0) {
                var4_5 = this.buffer;
                var3_3 = this.position;
                this.position = var5_8 = var3_3 + 1;
                var6_11 = var3_3;
                var1_1 = (byte)var1_1;
                zzld.zza(var4_5, var6_11, (byte)var1_1);
                return;
            }
            var4_5 = this.buffer;
            var3_3 = this.position;
            this.position = var5_8 = var3_3 + 1;
            var6_11 = var3_3;
            var8_12 = (byte)(var1_1 | 128);
            zzld.zza(var4_5, var6_11, var8_12);
            var2_2 = (var1_1 >>>= 7) & -128;
            if (var2_2 == 0) {
                var4_5 = this.buffer;
                var3_3 = this.position;
                this.position = var5_8 = var3_3 + 1;
                var6_11 = var3_3;
                var1_1 = (byte)var1_1;
                zzld.zza(var4_5, var6_11, (byte)var1_1);
                return;
            }
            var4_5 = this.buffer;
            var3_3 = this.position;
            this.position = var5_8 = var3_3 + 1;
            var6_11 = var3_3;
            var8_12 = (byte)(var1_1 | 128);
            zzld.zza(var4_5, var6_11, var8_12);
            var2_2 = (var1_1 >>>= 7) & -128;
            if (var2_2 == 0) {
                var4_5 = this.buffer;
                var3_3 = this.position;
                this.position = var5_8 = var3_3 + 1;
                var6_11 = var3_3;
                var1_1 = (byte)var1_1;
                zzld.zza(var4_5, var6_11, (byte)var1_1);
                return;
            }
            var4_5 = this.buffer;
            var3_3 = this.position;
            this.position = var5_8 = var3_3 + 1;
            var6_11 = var3_3;
            var8_12 = (byte)(var1_1 | 128);
            zzld.zza(var4_5, var6_11, var8_12);
            var1_1 >>>= 7;
            var4_5 = this.buffer;
            var3_3 = this.position;
            this.position = var5_8 = var3_3 + 1;
            var6_11 = var3_3;
            var1_1 = (byte)var1_1;
            zzld.zza(var4_5, var6_11, (byte)var1_1);
            return;
        }
        while (true) {
            if ((var2_2 = var1_1 & -128) != 0) ** GOTO lbl97
            var4_6 /* !! */  = this.buffer;
            break;
        }
        catch (IndexOutOfBoundsException var9_14) {
            var4_6 /* !! */  = (byte[])new zzhl$zza;
            var10_15 /* !! */  = new Object[3];
            var11_16 = this.position;
            var10_15 /* !! */ [0] = var11_16;
            var12_17 = this.limit;
            var8_13 = 1;
            var10_15 /* !! */ [var8_13] = var12_17;
            var11_16 = var8_13;
            var10_15 /* !! */ [2] = var11_16;
            var10_15 /* !! */  = String.format("Pos: %d, limit: %d, len: %d", var10_15 /* !! */ );
            var4_6 /* !! */ ((String)var10_15 /* !! */ , var9_14);
            throw var4_6 /* !! */ ;
        }
        {
            var3_3 = this.position;
            var5_9 = var3_3 + 1;
            this.position = var5_9;
            var1_1 = (byte)var1_1;
            var4_6 /* !! */ [var3_3] = var1_1;
            return;
lbl97:
            // 1 sources

            var4_6 /* !! */  = this.buffer;
            var3_3 = this.position;
            var5_9 = var3_3 + 1;
            this.position = var5_9;
            var5_9 = (byte)(var1_1 & 127 | 128);
            var4_6 /* !! */ [var3_3] = var5_9;
            var1_1 >>>= 7;
            continue;
        }
    }

    public final void zzbg(int n10) {
        byte by2;
        Object object;
        try {
            object = this.buffer;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object = new zzhl$zza;
            Object object2 = new Object[3];
            Integer n11 = this.position;
            object2[0] = n11;
            Integer n12 = this.limit;
            by2 = 1;
            object2[by2] = n12;
            n11 = by2;
            object2[2] = n11;
            object2 = String.format("Pos: %d, limit: %d, len: %d", object2);
            object((String)object2, indexOutOfBoundsException);
            throw object;
        }
        int n13 = this.position;
        int n14 = n13 + 1;
        this.position = n14;
        by2 = (byte)n10;
        object[n13] = by2;
        n13 = n14 + 1;
        this.position = n13;
        by2 = (byte)(n10 >> 8);
        object[n14] = by2;
        n14 = n13 + 1;
        this.position = n14;
        by2 = (byte)(n10 >> 16);
        object[n13] = by2;
        n13 = n14 + 1;
        this.position = n13;
        n10 = (byte)(n10 >>> 24);
        object[n14] = n10;
    }

    public final void zzc(byte by2) {
        Object object;
        try {
            object = this.buffer;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object = new zzhl$zza;
            Object object2 = new Object[3];
            Integer n10 = this.position;
            object2[0] = n10;
            Integer n11 = this.limit;
            int n12 = 1;
            object2[n12] = n11;
            n10 = n12;
            object2[2] = n10;
            object2 = String.format("Pos: %d, limit: %d, len: %d", object2);
            object((String)object2, indexOutOfBoundsException);
            throw object;
        }
        int n13 = this.position;
        int n14 = n13 + 1;
        this.position = n14;
        object[n13] = by2;
    }

    public final void zzc(int n10, long l10) {
        ((zzhl)this).writeTag(n10, 1);
        ((zzhl)this).zzu(l10);
    }

    public final void zzc(byte[] byArray, int n10, int n11) {
        this.write(byArray, n10, n11);
    }

    public final void zze(byte[] byArray, int n10, int n11) {
        ((zzhl)this).zzbe(n11);
        this.write(byArray, 0, n11);
    }

    public final int zzga() {
        int n10 = this.limit;
        int n11 = this.position;
        return n10 - n11;
    }

    public final void zzj(int n10, int n11) {
        ((zzhl)this).writeTag(n10, 0);
        ((zzhl)this).zzbd(n11);
    }

    public final void zzk(int n10, int n11) {
        ((zzhl)this).writeTag(n10, 0);
        ((zzhl)this).zzbe(n11);
    }

    public final void zzm(int n10, int n11) {
        ((zzhl)this).writeTag(n10, 5);
        ((zzhl)this).zzbg(n11);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzs(long var1_1) {
        var3_2 = zzhl.zzgc();
        var4_3 = 7;
        var5_4 = 0L;
        var7_5 = -128;
        if (var3_2 != 0 && (var3_2 = this.zzga()) >= (var9_6 = 10)) {
            while (true) {
                if ((var3_2 = (int)((cfr_temp_0 = (var10_10 = var1_1 & var7_5) - var5_4) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) == 0) {
                    var12_12 = this.buffer;
                    var4_3 = this.position;
                    this.position = var13_14 = var4_3 + 1;
                    var14_16 = var4_3;
                    var16_17 = (byte)var1_1;
                    zzld.zza(var12_12, var14_16, var16_17);
                    return;
                }
                var12_12 = this.buffer;
                var9_6 = this.position;
                this.position = var17_7 = var9_6 + 1;
                var10_10 = var9_6;
                var18_9 = (byte)((int)var1_1 & 127 | 128);
                zzld.zza(var12_12, var10_10, var18_9);
                var1_1 >>>= var4_3;
            }
        }
        while (true) {
            if ((var3_2 = (int)((cfr_temp_1 = (var10_11 = var1_1 & var7_5) - var5_4) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) != 0) ** GOTO lbl48
            var12_13 /* !! */  = this.buffer;
            break;
        }
        catch (IndexOutOfBoundsException var19_19) {
            var12_13 /* !! */  = (byte[])new Object[3];
            var21_21 = this.position;
            var12_13 /* !! */ [0] = (byte)var21_21;
            var22_22 = this.limit;
            var13_15 = 1;
            var12_13 /* !! */ [var13_15] = (byte)var22_22;
            var21_21 = var13_15;
            var12_13 /* !! */ [2] = (byte)var21_21;
            var12_13 /* !! */  = (byte[])String.format("Pos: %d, limit: %d, len: %d", var12_13 /* !! */ );
            var20_20 = new zzhl$zza((String)var12_13 /* !! */ , var19_19);
            throw var20_20;
        }
        {
            var4_3 = this.position;
            var13_15 = var4_3 + 1;
            this.position = var13_15;
            var16_18 = (byte)var1_1;
            var12_13 /* !! */ [var4_3] = var16_18;
            return;
lbl48:
            // 1 sources

            var12_13 /* !! */  = this.buffer;
            var9_6 = this.position;
            var17_8 = var9_6 + 1;
            this.position = var17_8;
            var17_8 = (byte)((int)var1_1 & 127 | 128);
            var12_13 /* !! */ [var9_6] = var17_8;
            var1_1 >>>= var4_3;
            continue;
        }
    }

    public final void zzu(long l10) {
        int n10;
        Object object;
        try {
            object = this.buffer;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object = new Object[3];
            Integer n11 = this.position;
            object[0] = (byte)n11;
            Integer n12 = this.limit;
            n10 = 1;
            object[n10] = (byte)n12;
            n11 = n10;
            object[2] = (byte)n11;
            object = String.format("Pos: %d, limit: %d, len: %d", object);
            zzhl$zza zzhl$zza = new zzhl$zza((String)object, indexOutOfBoundsException);
            throw zzhl$zza;
        }
        int n13 = this.position;
        n10 = n13 + 1;
        this.position = n10;
        byte by2 = (byte)l10;
        object[n13] = by2;
        n13 = n10 + 1;
        this.position = n13;
        long l11 = l10 >> 8;
        by2 = (byte)l11;
        object[n10] = by2;
        n10 = n13 + 1;
        this.position = n10;
        l11 = l10 >> 16;
        by2 = (byte)l11;
        object[n13] = by2;
        n13 = n10 + 1;
        this.position = n13;
        l11 = l10 >> 24;
        by2 = (byte)l11;
        object[n10] = by2;
        n10 = n13 + 1;
        this.position = n10;
        l11 = l10 >> 32;
        by2 = (byte)l11;
        object[n13] = by2;
        n13 = n10 + 1;
        this.position = n13;
        l11 = l10 >> 40;
        by2 = (byte)l11;
        object[n10] = by2;
        n10 = n13 + 1;
        this.position = n10;
        l11 = l10 >> 48;
        by2 = (byte)l11;
        object[n13] = by2;
        n13 = n10 + 1;
        this.position = n13;
        n13 = 56;
        byte by3 = (byte)(l10 >>= n13);
        object[n10] = by3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzw(String string2) {
        int n10 = this.position;
        try {
            int n11 = string2.length() * 3;
            n11 = zzhl.zzbj(n11);
            int n12 = string2.length();
            n12 = zzhl.zzbj(n12);
            if (n12 == n11) {
                this.position = n11 = n10 + n12;
                byte[] byArray = this.buffer;
                int n13 = ((zzhl)this).zzga();
                n11 = zzlf.zza(string2, byArray, n11, n13);
                this.position = n10;
                int n14 = n11 - n10 - n12;
                ((zzhl)this).zzbe(n14);
                this.position = n11;
                return;
            }
            n11 = zzlf.zza(string2);
            ((zzhl)this).zzbe(n11);
            byte[] byArray = this.buffer;
            n12 = this.position;
            int n15 = ((zzhl)this).zzga();
            this.position = n11 = zzlf.zza(string2, byArray, n12, n15);
            return;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            zzhl$zza zzhl$zza = new zzhl$zza(indexOutOfBoundsException);
            throw zzhl$zza;
        }
        catch (zzlj zzlj2) {
            this.position = n10;
            this.zza(string2, zzlj2);
            return;
        }
    }
}

