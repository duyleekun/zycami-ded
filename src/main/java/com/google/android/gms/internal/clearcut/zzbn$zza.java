/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzas;
import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzbn;
import com.google.android.gms.internal.clearcut.zzbn$zzc;
import com.google.android.gms.internal.clearcut.zzdo;
import com.google.android.gms.internal.clearcut.zzef;
import com.google.android.gms.internal.clearcut.zzfd;
import com.google.android.gms.internal.clearcut.zzff;
import com.google.android.gms.internal.clearcut.zzfi;
import com.google.android.gms.internal.clearcut.zzfr;
import java.util.Objects;

public class zzbn$zza
extends zzbn {
    private final byte[] buffer;
    private final int limit;
    private final int offset;
    private int position;

    public zzbn$zza(byte[] object, int n10, int n11) {
        super(null);
        Object object2 = "buffer";
        Objects.requireNonNull(object, (String)object2);
        int n12 = n10 | n11;
        int n13 = ((byte[])object).length;
        int n14 = n10 + n11;
        if ((n12 |= (n13 -= n14)) >= 0) {
            this.buffer = object;
            this.offset = n10;
            this.position = n10;
            this.limit = n14;
            return;
        }
        Object[] objectArray = new Object[3];
        object = ((byte[])object).length;
        objectArray[0] = object;
        Integer n15 = n10;
        objectArray[1] = n15;
        n15 = n11;
        objectArray[2] = n15;
        object = String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", objectArray);
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public void flush() {
    }

    public final void write(byte[] byArray, int n10, int n11) {
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
            zzbn$zzc zzbn$zzc = new zzbn$zzc((String)object, indexOutOfBoundsException);
            throw zzbn$zzc;
        }
        int n13 = this.position;
        System.arraycopy(byArray, n10, objectArray, n13, n11);
        int n14 = this.position + n11;
        this.position = n14;
    }

    public final void zza(byte by2) {
        Object object;
        try {
            object = this.buffer;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object = new zzbn$zzc;
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

    public final void zza(int n10, long l10) {
        ((zzbn)this).zzb(n10, 0);
        ((zzbn)this).zzb(l10);
    }

    public final void zza(int n10, zzbb zzbb2) {
        ((zzbn)this).zzb(n10, 2);
        ((zzbn)this).zza(zzbb2);
    }

    public final void zza(int n10, zzdo zzdo2) {
        ((zzbn)this).zzb(n10, 2);
        ((zzbn)this).zzb(zzdo2);
    }

    public final void zza(int n10, zzdo zzdo2, zzef zzef2) {
        ((zzbn)this).zzb(n10, 2);
        Object object = zzdo2;
        object = (zzas)zzdo2;
        int n11 = ((zzas)object).zzs();
        int n12 = -1;
        if (n11 == n12) {
            n11 = zzef2.zzm(object);
            ((zzas)object).zzf(n11);
        }
        ((zzbn)this).zzo(n11);
        object = this.zzfz;
        zzef2.zza(zzdo2, (zzfr)object);
    }

    public final void zza(int n10, String string2) {
        ((zzbn)this).zzb(n10, 2);
        ((zzbn)this).zzg(string2);
    }

    public final void zza(zzbb zzbb2) {
        int n10 = zzbb2.size();
        ((zzbn)this).zzo(n10);
        zzbb2.zza(this);
    }

    public final void zza(zzdo zzdo2, zzef zzef2) {
        int n10;
        Object object = zzdo2;
        object = (zzas)zzdo2;
        int n11 = ((zzas)object).zzs();
        if (n11 == (n10 = -1)) {
            n11 = zzef2.zzm(object);
            ((zzas)object).zzf(n11);
        }
        ((zzbn)this).zzo(n11);
        object = this.zzfz;
        zzef2.zza(zzdo2, (zzfr)object);
    }

    public final void zza(byte[] byArray, int n10, int n11) {
        ((zzbn)this).write(byArray, n10, n11);
    }

    public final int zzag() {
        int n10 = this.limit;
        int n11 = this.position;
        return n10 - n11;
    }

    public final int zzai() {
        int n10 = this.position;
        int n11 = this.offset;
        return n10 - n11;
    }

    public final void zzb(int n10, int n11) {
        n10 = n10 << 3 | n11;
        ((zzbn)this).zzo(n10);
    }

    public final void zzb(int n10, zzbb zzbb2) {
        int n11 = 1;
        int n12 = 3;
        ((zzbn)this).zzb(n11, n12);
        ((zzbn)this).zzd(2, n10);
        ((zzbn)this).zza(n12, zzbb2);
        ((zzbn)this).zzb(n11, 4);
    }

    public final void zzb(int n10, zzdo zzdo2) {
        int n11 = 1;
        int n12 = 3;
        ((zzbn)this).zzb(n11, n12);
        ((zzbn)this).zzd(2, n10);
        ((zzbn)this).zza(n12, zzdo2);
        ((zzbn)this).zzb(n11, 4);
    }

    public final void zzb(int n10, boolean bl2) {
        ((zzbn)this).zzb(n10, 0);
        n10 = (byte)(bl2 ? 1 : 0);
        ((zzbn)this).zza((byte)n10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzb(long var1_1) {
        var3_2 = zzbn.zzah();
        var4_3 = 7;
        var5_4 = 0L;
        var7_5 = -128;
        if (var3_2 != 0 && (var3_2 = this.zzag()) >= (var9_6 = 10)) {
            while (true) {
                if ((var3_2 = (int)((cfr_temp_0 = (var10_10 = var1_1 & var7_5) - var5_4) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) == 0) {
                    var12_12 = this.buffer;
                    var4_3 = this.position;
                    this.position = var13_14 = var4_3 + 1;
                    var14_16 = var4_3;
                    var16_17 = (byte)var1_1;
                    zzfd.zza(var12_12, var14_16, var16_17);
                    return;
                }
                var12_12 = this.buffer;
                var9_6 = this.position;
                this.position = var17_7 = var9_6 + 1;
                var10_10 = var9_6;
                var18_9 = (byte)((int)var1_1 & 127 | 128);
                zzfd.zza(var12_12, var10_10, var18_9);
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
            var20_20 = new zzbn$zzc((String)var12_13 /* !! */ , var19_19);
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

    public final void zzb(zzdo zzdo2) {
        int n10 = zzdo2.zzas();
        ((zzbn)this).zzo(n10);
        zzdo2.zzb(this);
    }

    public final void zzc(int n10, int n11) {
        ((zzbn)this).zzb(n10, 0);
        ((zzbn)this).zzn(n11);
    }

    public final void zzc(int n10, long l10) {
        ((zzbn)this).zzb(n10, 1);
        ((zzbn)this).zzd(l10);
    }

    public final void zzd(int n10, int n11) {
        ((zzbn)this).zzb(n10, 0);
        ((zzbn)this).zzo(n11);
    }

    public final void zzd(long l10) {
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
            zzbn$zzc zzbn$zzc = new zzbn$zzc((String)object, indexOutOfBoundsException);
            throw zzbn$zzc;
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

    public final void zzd(byte[] byArray, int n10, int n11) {
        ((zzbn)this).zzo(n11);
        ((zzbn)this).write(byArray, 0, n11);
    }

    public final void zzf(int n10, int n11) {
        ((zzbn)this).zzb(n10, 5);
        ((zzbn)this).zzq(n11);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzg(String string2) {
        int n10 = this.position;
        try {
            int n11 = string2.length() * 3;
            n11 = zzbn.zzt(n11);
            int n12 = string2.length();
            n12 = zzbn.zzt(n12);
            if (n12 == n11) {
                this.position = n11 = n10 + n12;
                byte[] byArray = this.buffer;
                int n13 = ((zzbn)this).zzag();
                n11 = zzff.zza(string2, byArray, n11, n13);
                this.position = n10;
                int n14 = n11 - n10 - n12;
                ((zzbn)this).zzo(n14);
                this.position = n11;
                return;
            }
            n11 = zzff.zza(string2);
            ((zzbn)this).zzo(n11);
            byte[] byArray = this.buffer;
            n12 = this.position;
            int n15 = ((zzbn)this).zzag();
            this.position = n11 = zzff.zza(string2, byArray, n12, n15);
            return;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            zzbn$zzc zzbn$zzc = new zzbn$zzc(indexOutOfBoundsException);
            throw zzbn$zzc;
        }
        catch (zzfi zzfi2) {
            this.position = n10;
            this.zza(string2, zzfi2);
            return;
        }
    }

    public final void zzn(int n10) {
        if (n10 >= 0) {
            ((zzbn)this).zzo(n10);
            return;
        }
        long l10 = n10;
        ((zzbn)this).zzb(l10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzo(int var1_1) {
        var2_2 = zzbn.zzah();
        if (var2_2 != 0 && (var2_2 = this.zzag()) >= (var3_3 = 10)) {
            while (true) {
                if ((var2_2 = var1_1 & -128) == 0) {
                    var4_4 = this.buffer;
                    var3_3 = this.position;
                    this.position = var5_6 = var3_3 + 1;
                    var6_8 = var3_3;
                    var1_1 = (byte)var1_1;
                    zzfd.zza(var4_4, var6_8, (byte)var1_1);
                    return;
                }
                var4_4 = this.buffer;
                var3_3 = this.position;
                this.position = var5_6 = var3_3 + 1;
                var6_8 = var3_3;
                var8_9 = (byte)(var1_1 & 127 | 128);
                zzfd.zza(var4_4, var6_8, var8_9);
                var1_1 >>>= 7;
            }
        }
        while (true) {
            if ((var2_2 = var1_1 & -128) != 0) ** GOTO lbl46
            var4_5 /* !! */  = this.buffer;
            break;
        }
        catch (IndexOutOfBoundsException var9_11) {
            var4_5 /* !! */  = (byte[])new zzbn$zzc;
            var10_12 /* !! */  = new Object[3];
            var11_13 = this.position;
            var10_12 /* !! */ [0] = var11_13;
            var12_14 = this.limit;
            var8_10 = 1;
            var10_12 /* !! */ [var8_10] = var12_14;
            var11_13 = var8_10;
            var10_12 /* !! */ [2] = var11_13;
            var10_12 /* !! */  = String.format("Pos: %d, limit: %d, len: %d", var10_12 /* !! */ );
            var4_5 /* !! */ ((String)var10_12 /* !! */ , var9_11);
            throw var4_5 /* !! */ ;
        }
        {
            var3_3 = this.position;
            var5_7 = var3_3 + 1;
            this.position = var5_7;
            var1_1 = (byte)var1_1;
            var4_5 /* !! */ [var3_3] = var1_1;
            return;
lbl46:
            // 1 sources

            var4_5 /* !! */  = this.buffer;
            var3_3 = this.position;
            var5_7 = var3_3 + 1;
            this.position = var5_7;
            var5_7 = (byte)(var1_1 & 127 | 128);
            var4_5 /* !! */ [var3_3] = var5_7;
            var1_1 >>>= 7;
            continue;
        }
    }

    public final void zzq(int n10) {
        byte by2;
        Object object;
        try {
            object = this.buffer;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object = new zzbn$zzc;
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
        n10 >>= 24;
        object[n14] = n10;
    }
}

