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
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;

public final class zzbn$zze
extends zzbn {
    private final ByteBuffer zzgc;
    private final ByteBuffer zzgd;
    private final long zzge;
    private final long zzgf;
    private final long zzgg;
    private final long zzgh;
    private long zzgi;

    public zzbn$zze(ByteBuffer byteBuffer) {
        super(null);
        long l10;
        long l11;
        this.zzgc = byteBuffer;
        ByteBuffer byteBuffer2 = byteBuffer.duplicate();
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        this.zzgd = byteBuffer2 = byteBuffer2.order(byteOrder);
        this.zzge = l11 = zzfd.zzb(byteBuffer);
        this.zzgf = l10 = (long)byteBuffer.position() + l11;
        long l12 = byteBuffer.limit();
        this.zzgg = l11 += l12;
        this.zzgh = l11 -= (long)10;
        this.zzgi = l10;
    }

    private final void zzk(long l10) {
        ByteBuffer byteBuffer = this.zzgd;
        long l11 = this.zzge;
        int n10 = (int)(l10 - l11);
        byteBuffer.position(n10);
    }

    public final void flush() {
        ByteBuffer byteBuffer = this.zzgc;
        long l10 = this.zzgi;
        long l11 = this.zzge;
        int n10 = (int)(l10 - l11);
        byteBuffer.position(n10);
    }

    public final void write(byte[] object, int n10, int n11) {
        int n12;
        if (object != null && n10 >= 0 && n11 >= 0 && (n12 = ((byte[])object).length - n11) >= n10) {
            long l10 = this.zzgg;
            long l11 = n11;
            long l12 = this.zzgi;
            long l13 = (l10 -= l11) - l12;
            n12 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n12 >= 0) {
                long l14;
                long l15 = n10;
                zzfd.zza(object, l15, l12, l11);
                this.zzgi = l14 = this.zzgi + l11;
                return;
            }
        }
        Objects.requireNonNull(object, "value");
        object = new zzbn$zzc;
        Object object2 = new Object[3];
        Long l16 = this.zzgi;
        object2[0] = l16;
        l16 = this.zzgg;
        object2[1] = l16;
        Integer n13 = n11;
        object2[2] = n13;
        object2 = String.format("Pos: %d, limit: %d, len: %d", object2);
        object((String)object2);
        throw object;
    }

    public final void zza(byte by2) {
        long l10 = this.zzgi;
        long l11 = this.zzgg;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) {
            this.zzgi = l11 = 1L + l10;
            zzfd.zza(l10, by2);
            return;
        }
        Object object2 = new Object[3];
        Number number = this.zzgi;
        object2[0] = number;
        Long l13 = this.zzgg;
        object = 1;
        object2[object] = l13;
        number = (int)object;
        object2[2] = number;
        object2 = String.format("Pos: %d, limit: %d, len: %d", object2);
        zzbn$zzc zzbn$zzc = new zzbn$zzc((String)object2);
        throw zzbn$zzc;
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
        long l10 = this.zzgg;
        long l11 = this.zzgi;
        return (int)(l10 - l11);
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

    public final void zzb(long l10) {
        long l11;
        long l12;
        long l13;
        long l14 = this.zzgi;
        long l15 = this.zzgh;
        Object object = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
        int n10 = 7;
        l15 = 0L;
        long l16 = -128;
        long l17 = 1L;
        if (object <= 0) {
            while (true) {
                long l18;
                long l19;
                long l20;
                if ((object = (l20 = (l19 = l10 & l16) - l15) == 0L ? 0 : (l20 < 0L ? -1 : 1)) == false) {
                    l14 = this.zzgi;
                    this.zzgi = l17 += l14;
                    byte by2 = (byte)l10;
                    zzfd.zza(l14, by2);
                    return;
                }
                l19 = this.zzgi;
                this.zzgi = l18 = l19 + l17;
                object = (byte)((int)l10 & 0x7F | 0x80);
                zzfd.zza(l19, (byte)object);
                l10 >>>= n10;
            }
        }
        while ((object = (l13 = (l12 = this.zzgi) - (l11 = this.zzgg)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) < 0) {
            l11 = l10 & l16;
            long l21 = l11 - l15;
            object = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
            if (object == false) {
                this.zzgi = l17 += l12;
                byte by3 = (byte)l10;
                zzfd.zza(l12, by3);
                return;
            }
            this.zzgi = l11 = l12 + l17;
            object = (byte)((int)l10 & 0x7F | 0x80);
            zzfd.zza(l12, (byte)object);
            l10 >>>= n10;
        }
        Object object2 = new Object[3];
        Number number = this.zzgi;
        object2[0] = number;
        Long l22 = this.zzgg;
        n10 = 1;
        object2[n10] = l22;
        number = n10;
        object2[2] = number;
        object2 = String.format("Pos: %d, limit: %d, len: %d", object2);
        zzbn$zzc zzbn$zzc = new zzbn$zzc((String)object2);
        throw zzbn$zzc;
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
        ByteBuffer byteBuffer = this.zzgd;
        long l11 = this.zzgi;
        long l12 = this.zzge;
        int n10 = (int)(l11 - l12);
        byteBuffer.putLong(n10, l10);
        this.zzgi = l10 = this.zzgi + (long)8;
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
     * Unable to fully structure code
     */
    public final void zzg(String var1_1) {
        var2_4 = this.zzgi;
        var4_5 = var1_1.length() * 3;
        var4_5 = zzbn.zzt(var4_5);
        var5_6 = var1_1.length();
        var5_6 = zzbn.zzt(var5_6);
        if (var5_6 != var4_5) ** GOTO lbl35
        var6_7 = this.zzgi;
        var8_8 = this.zzge;
        var4_5 = (int)(var6_7 -= var8_8) + var5_6;
        var10_9 = this.zzgd;
        var10_9.position(var4_5);
        var10_9 = this.zzgd;
        zzff.zza(var1_1, var10_9);
        var10_9 = this.zzgd;
        var5_6 = var10_9.position() - var4_5;
        this.zzo(var5_6);
        var6_7 = this.zzgi;
        var11_11 = var5_6;
        var6_7 += var11_11;
        this.zzgi = var6_7;
        return;
lbl35:
        // 1 sources

        var4_5 = zzff.zza(var1_1);
        this.zzo(var4_5);
        var13_12 = this.zzgi;
        this.zzk(var13_12);
        var10_10 = this.zzgd;
        zzff.zza(var1_1, var10_10);
        var13_12 = this.zzgi;
        var15_13 = var4_5;
        var13_12 += var15_13;
        try {
            this.zzgi = var13_12;
            return;
        }
        catch (IndexOutOfBoundsException var1_2) {
            var17_14 = new zzbn$zzc(var1_2);
            throw var17_14;
        }
        catch (IllegalArgumentException var1_3) {
            var17_15 = new zzbn$zzc(var1_3);
            throw var17_15;
        }
        catch (zzfi var18_16) {
            this.zzgi = var2_4;
            this.zzk(var2_4);
            this.zza(var1_1, var18_16);
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
     * Enabled aggressive block sorting
     */
    public final void zzo(int n10) {
        long l10;
        long l11 = this.zzgi;
        long l12 = this.zzgh;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        long l14 = 1L;
        if (l13 <= 0) {
            while (true) {
                l13 = n10 & 0xFFFFFF80;
                l10 = this.zzgi;
                if (l13 != false) {
                    long l15;
                    this.zzgi = l15 = l10 + l14;
                    l13 = (byte)(n10 & 0x7F | 0x80);
                    zzfd.zza(l10, (byte)l13);
                    n10 >>>= 7;
                    continue;
                }
                break;
            }
        } else {
            while (true) {
                long l16;
                long l17;
                if ((l13 = (l17 = (l10 = this.zzgi) - (l16 = this.zzgg)) == 0L ? 0 : (l17 < 0L ? -1 : 1)) >= 0) {
                    Object[] objectArray = new Object[3];
                    Long l18 = this.zzgi;
                    objectArray[0] = l18;
                    Long l19 = this.zzgg;
                    int n11 = 1;
                    objectArray[n11] = l19;
                    Integer n12 = n11;
                    objectArray[2] = n12;
                    String string2 = String.format("Pos: %d, limit: %d, len: %d", objectArray);
                    zzbn$zzc zzbn$zzc = new zzbn$zzc(string2);
                    throw zzbn$zzc;
                }
                l13 = n10 & 0xFFFFFF80;
                if (l13 == false) break;
                this.zzgi = l16 = l10 + l14;
                l13 = (byte)(n10 & 0x7F | 0x80);
                zzfd.zza(l10, (byte)l13);
                n10 >>>= 7;
            }
        }
        this.zzgi = l14 += l10;
        n10 = (byte)n10;
        zzfd.zza(l10, (byte)n10);
    }

    public final void zzq(int n10) {
        long l10;
        ByteBuffer byteBuffer = this.zzgd;
        long l11 = this.zzgi;
        long l12 = this.zzge;
        int n11 = (int)(l11 - l12);
        byteBuffer.putInt(n11, n10);
        this.zzgi = l10 = this.zzgi + (long)4;
    }
}

