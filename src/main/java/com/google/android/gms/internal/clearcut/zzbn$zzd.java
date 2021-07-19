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
import com.google.android.gms.internal.clearcut.zzff;
import com.google.android.gms.internal.clearcut.zzfi;
import com.google.android.gms.internal.clearcut.zzfr;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class zzbn$zzd
extends zzbn {
    private final int zzgb;
    private final ByteBuffer zzgc;
    private final ByteBuffer zzgd;

    public zzbn$zzd(ByteBuffer byteBuffer) {
        super(null);
        int n10;
        this.zzgc = byteBuffer;
        ByteBuffer byteBuffer2 = byteBuffer.duplicate();
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        this.zzgd = byteBuffer2 = byteBuffer2.order(byteOrder);
        this.zzgb = n10 = byteBuffer.position();
    }

    private final void zzi(String string2) {
        Object object;
        try {
            object = this.zzgd;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object = new zzbn$zzc(indexOutOfBoundsException);
            throw object;
        }
        zzff.zza(string2, (ByteBuffer)object);
    }

    public final void flush() {
        ByteBuffer byteBuffer = this.zzgc;
        int n10 = this.zzgd.position();
        byteBuffer.position(n10);
    }

    public final void write(byte[] byArray, int n10, int n11) {
        ByteBuffer byteBuffer = this.zzgd;
        try {
            byteBuffer.put(byArray, n10, n11);
            return;
        }
        catch (BufferOverflowException bufferOverflowException) {
            zzbn$zzc zzbn$zzc = new zzbn$zzc(bufferOverflowException);
            throw zzbn$zzc;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            zzbn$zzc zzbn$zzc = new zzbn$zzc(indexOutOfBoundsException);
            throw zzbn$zzc;
        }
    }

    public final void zza(byte by2) {
        Object object;
        try {
            object = this.zzgd;
        }
        catch (BufferOverflowException bufferOverflowException) {
            object = new zzbn$zzc(bufferOverflowException);
            throw object;
        }
        ((ByteBuffer)object).put(by2);
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
        ((zzbn)this).zza(zzdo2, zzef2);
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
        return this.zzgd.remaining();
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
     */
    public final void zzb(long var1_1) {
        while (true) lbl-1000:
        // 2 sources

        {
            if ((var7_4 = (cfr_temp_0 = (var3_2 = (long)-128 & var1_1) - (var5_3 = 0L)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false) ** GOTO lbl13
            var8_5 = this.zzgd;
            break;
        }
        catch (BufferOverflowException var11_8) {
            var12_9 = new zzbn$zzc(var11_8);
            throw var12_9;
        }
        {
            var9_7 = (byte)var1_1;
            var8_5.put(var9_7);
            return;
lbl13:
            // 1 sources

            var8_5 = this.zzgd;
            var10_6 = (byte)((int)var1_1 & 127 | 128);
            var8_5.put(var10_6);
            var7_4 = 7;
            var1_1 >>>= var7_4;
            ** while (true)
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
        ByteBuffer byteBuffer;
        try {
            byteBuffer = this.zzgd;
        }
        catch (BufferOverflowException bufferOverflowException) {
            zzbn$zzc zzbn$zzc = new zzbn$zzc(bufferOverflowException);
            throw zzbn$zzc;
        }
        byteBuffer.putLong(l10);
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
        Object object = this.zzgd;
        int n10 = ((Buffer)object).position();
        try {
            int n11 = string2.length() * 3;
            n11 = zzbn.zzt(n11);
            int n12 = string2.length();
            n12 = zzbn.zzt(n12);
            if (n12 == n11) {
                ByteBuffer byteBuffer = this.zzgd;
                n11 = byteBuffer.position() + n12;
                ByteBuffer byteBuffer2 = this.zzgd;
                byteBuffer2.position(n11);
                this.zzi(string2);
                byteBuffer2 = this.zzgd;
                n12 = byteBuffer2.position();
                ByteBuffer byteBuffer3 = this.zzgd;
                byteBuffer3.position(n10);
                n11 = n12 - n11;
                ((zzbn)this).zzo(n11);
                byteBuffer = this.zzgd;
                byteBuffer.position(n12);
                return;
            }
            n11 = zzff.zza(string2);
            ((zzbn)this).zzo(n11);
            this.zzi(string2);
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            object = new zzbn$zzc(illegalArgumentException);
            throw object;
        }
        catch (zzfi zzfi2) {
            this.zzgd.position(n10);
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
     */
    public final void zzo(int var1_1) {
        while (true) {
            if ((var2_2 = var1_1 & -128) != 0) ** GOTO lbl13
            var3_3 = this.zzgd;
            break;
        }
        catch (BufferOverflowException var5_5) {
            var3_3 = new zzbn$zzc(var5_5);
            throw var3_3;
        }
        {
            var1_1 = (byte)var1_1;
            var3_3.put((byte)var1_1);
            return;
lbl13:
            // 1 sources

            var3_3 = this.zzgd;
            var4_4 = (byte)(var1_1 & 127 | 128);
            var3_3.put(var4_4);
            var1_1 >>>= 7;
            continue;
        }
    }

    public final void zzq(int n10) {
        Object object;
        try {
            object = this.zzgd;
        }
        catch (BufferOverflowException bufferOverflowException) {
            object = new zzbn$zzc(bufferOverflowException);
            throw object;
        }
        ((ByteBuffer)object).putInt(n10);
    }
}

