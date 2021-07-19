/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzas;
import com.google.android.gms.internal.clearcut.zzba;
import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzbn$zza;
import com.google.android.gms.internal.clearcut.zzbn$zzb;
import com.google.android.gms.internal.clearcut.zzbn$zzc;
import com.google.android.gms.internal.clearcut.zzbn$zzd;
import com.google.android.gms.internal.clearcut.zzbn$zze;
import com.google.android.gms.internal.clearcut.zzbo;
import com.google.android.gms.internal.clearcut.zzbp;
import com.google.android.gms.internal.clearcut.zzci;
import com.google.android.gms.internal.clearcut.zzcv;
import com.google.android.gms.internal.clearcut.zzdo;
import com.google.android.gms.internal.clearcut.zzef;
import com.google.android.gms.internal.clearcut.zzfd;
import com.google.android.gms.internal.clearcut.zzff;
import com.google.android.gms.internal.clearcut.zzfi;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzbn
extends zzba {
    private static final Logger logger = Logger.getLogger(zzbn.class.getName());
    private static final boolean zzfy = zzfd.zzed();
    public zzbp zzfz;

    private zzbn() {
    }

    public /* synthetic */ zzbn(zzbo zzbo2) {
        this();
    }

    public static int zza(int n10, zzcv zzcv2) {
        n10 = zzbn.zzr(n10);
        int n11 = zzcv2.zzas();
        int n12 = zzbn.zzt(n11) + n11;
        return n10 + n12;
    }

    public static int zza(zzcv zzcv2) {
        int n10 = zzcv2.zzas();
        return zzbn.zzt(n10) + n10;
    }

    public static zzbn zza(ByteBuffer object) {
        boolean bl2 = ((ByteBuffer)object).hasArray();
        if (bl2) {
            zzbn$zzb zzbn$zzb = new zzbn$zzb((ByteBuffer)object);
            return zzbn$zzb;
        }
        bl2 = ((ByteBuffer)object).isDirect();
        if (bl2 && !(bl2 = ((Buffer)object).isReadOnly())) {
            bl2 = zzfd.zzee();
            if (bl2) {
                zzbn$zze zzbn$zze = new zzbn$zze((ByteBuffer)object);
                return zzbn$zze;
            }
            zzbn$zzd zzbn$zzd = new zzbn$zzd((ByteBuffer)object);
            return zzbn$zzd;
        }
        object = new IllegalArgumentException("ByteBuffer is read-only");
        throw object;
    }

    public static /* synthetic */ boolean zzah() {
        return zzfy;
    }

    public static int zzb(double d10) {
        return 8;
    }

    public static int zzb(float f10) {
        return 4;
    }

    public static int zzb(int n10, double d10) {
        return zzbn.zzr(n10) + 8;
    }

    public static int zzb(int n10, float f10) {
        return zzbn.zzr(n10) + 4;
    }

    public static int zzb(int n10, zzcv zzcv2) {
        int n11 = zzbn.zzr(1) << 1;
        n10 = zzbn.zzh(2, n10);
        n11 += n10;
        n10 = zzbn.zza(3, zzcv2);
        return n11 + n10;
    }

    public static int zzb(int n10, zzdo zzdo2, zzef zzef2) {
        n10 = zzbn.zzr(n10);
        int n11 = zzbn.zzb(zzdo2, zzef2);
        return n10 + n11;
    }

    public static int zzb(int n10, String string2) {
        n10 = zzbn.zzr(n10);
        int n11 = zzbn.zzh(string2);
        return n10 + n11;
    }

    public static int zzb(zzbb zzbb2) {
        int n10 = zzbb2.size();
        return zzbn.zzt(n10) + n10;
    }

    public static int zzb(zzdo zzdo2, zzef zzef2) {
        int n10;
        int n11 = ((zzas)(zzdo2 = (zzas)zzdo2)).zzs();
        if (n11 == (n10 = -1)) {
            n11 = zzef2.zzm(zzdo2);
            ((zzas)zzdo2).zzf(n11);
        }
        return zzbn.zzt(n11) + n11;
    }

    public static int zzb(boolean bl2) {
        return 1;
    }

    public static int zzc(int n10, zzbb zzbb2) {
        n10 = zzbn.zzr(n10);
        int n11 = zzbb2.size();
        int n12 = zzbn.zzt(n11) + n11;
        return n10 + n12;
    }

    public static int zzc(int n10, zzdo zzdo2) {
        n10 = zzbn.zzr(n10);
        int n11 = zzbn.zzc(zzdo2);
        return n10 + n11;
    }

    public static int zzc(int n10, zzdo zzdo2, zzef zzef2) {
        int n11;
        n10 = zzbn.zzr(n10) << 1;
        int n12 = ((zzas)(zzdo2 = (zzas)zzdo2)).zzs();
        if (n12 == (n11 = -1)) {
            n12 = zzef2.zzm(zzdo2);
            ((zzas)zzdo2).zzf(n12);
        }
        return n10 + n12;
    }

    public static int zzc(int n10, boolean bl2) {
        return zzbn.zzr(n10) + 1;
    }

    public static int zzc(zzdo zzdo2) {
        int n10 = zzdo2.zzas();
        return zzbn.zzt(n10) + n10;
    }

    public static zzbn zzc(byte[] byArray) {
        int n10 = byArray.length;
        zzbn$zza zzbn$zza = new zzbn$zza(byArray, 0, n10);
        return zzbn$zza;
    }

    public static int zzd(int n10, long l10) {
        n10 = zzbn.zzr(n10);
        int n11 = zzbn.zzf(l10);
        return n10 + n11;
    }

    public static int zzd(int n10, zzbb zzbb2) {
        int n11 = zzbn.zzr(1) << 1;
        n10 = zzbn.zzh(2, n10);
        n11 += n10;
        n10 = zzbn.zzc(3, zzbb2);
        return n11 + n10;
    }

    public static int zzd(int n10, zzdo zzdo2) {
        int n11 = zzbn.zzr(1) << 1;
        n10 = zzbn.zzh(2, n10);
        n11 += n10;
        n10 = zzbn.zzc(3, zzdo2);
        return n11 + n10;
    }

    public static int zzd(zzdo zzdo2) {
        return zzdo2.zzas();
    }

    public static int zzd(byte[] byArray) {
        int n10 = byArray.length;
        return zzbn.zzt(n10) + n10;
    }

    public static int zze(int n10, long l10) {
        n10 = zzbn.zzr(n10);
        int n11 = zzbn.zzf(l10);
        return n10 + n11;
    }

    public static int zze(long l10) {
        return zzbn.zzf(l10);
    }

    public static int zzf(int n10, long l10) {
        n10 = zzbn.zzr(n10);
        int n11 = zzbn.zzf(zzbn.zzj(l10));
        return n10 + n11;
    }

    public static int zzf(long l10) {
        long l11;
        long l12;
        int n10;
        long l13 = (long)-128 & l10;
        long l14 = 0L;
        long l15 = l13 - l14;
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object == false) {
            return 1;
        }
        object = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
        if (object < 0) {
            return 10;
        }
        l13 = 0xFFFFFFF800000000L & l10;
        long l16 = l13 - l14;
        object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object != false) {
            object = 6;
            n10 = 28;
            l10 >>>= n10;
        } else {
            object = 2;
        }
        long l17 = 0xFFE00000L & l10;
        n10 = (int)(l17 == l14 ? 0 : (l17 < l14 ? -1 : 1));
        if (n10 != 0) {
            object += 2;
            n10 = 14;
            l10 >>>= n10;
        }
        if ((l12 = (l11 = (l10 &= (l17 = -16384L)) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            ++object;
        }
        return (int)object;
    }

    public static int zzg(int n10, int n11) {
        n10 = zzbn.zzr(n10);
        n11 = zzbn.zzs(n11);
        return n10 + n11;
    }

    public static int zzg(int n10, long l10) {
        return zzbn.zzr(n10) + 8;
    }

    public static int zzg(long l10) {
        return zzbn.zzf(zzbn.zzj(l10));
    }

    public static int zzh(int n10, int n11) {
        n10 = zzbn.zzr(n10);
        n11 = zzbn.zzt(n11);
        return n10 + n11;
    }

    public static int zzh(int n10, long l10) {
        return zzbn.zzr(n10) + 8;
    }

    public static int zzh(long l10) {
        return 8;
    }

    public static int zzh(String object) {
        int n10;
        try {
            n10 = zzff.zza((CharSequence)object);
        }
        catch (zzfi zzfi2) {
            Charset charset = zzci.UTF_8;
            object = ((String)object).getBytes(charset);
            n10 = ((Object)object).length;
        }
        return zzbn.zzt(n10) + n10;
    }

    public static int zzi(int n10, int n11) {
        n10 = zzbn.zzr(n10);
        n11 = zzbn.zzt(zzbn.zzy(n11));
        return n10 + n11;
    }

    public static int zzi(long l10) {
        return 8;
    }

    public static int zzj(int n10, int n11) {
        return zzbn.zzr(n10) + 4;
    }

    private static long zzj(long l10) {
        long l11 = l10 << 1;
        return l10 >> 63 ^ l11;
    }

    public static int zzk(int n10, int n11) {
        return zzbn.zzr(n10) + 4;
    }

    public static int zzl(int n10, int n11) {
        n10 = zzbn.zzr(n10);
        n11 = zzbn.zzs(n11);
        return n10 + n11;
    }

    public static int zzr(int n10) {
        return zzbn.zzt(n10 << 3);
    }

    public static int zzs(int n10) {
        if (n10 >= 0) {
            return zzbn.zzt(n10);
        }
        return 10;
    }

    public static int zzt(int n10) {
        int n11 = n10 & 0xFFFFFF80;
        if (n11 == 0) {
            return 1;
        }
        n11 = n10 & 0xFFFFC000;
        if (n11 == 0) {
            return 2;
        }
        n11 = 0xFFE00000 & n10;
        if (n11 == 0) {
            return 3;
        }
        n11 = -268435456;
        if ((n10 &= n11) == 0) {
            return 4;
        }
        return 5;
    }

    public static int zzu(int n10) {
        return zzbn.zzt(zzbn.zzy(n10));
    }

    public static int zzv(int n10) {
        return 4;
    }

    public static int zzw(int n10) {
        return 4;
    }

    public static int zzx(int n10) {
        return zzbn.zzs(n10);
    }

    private static int zzy(int n10) {
        int n11 = n10 << 1;
        return n10 >> 31 ^ n11;
    }

    public static int zzz(int n10) {
        return zzbn.zzt(n10);
    }

    public abstract void flush();

    public abstract void write(byte[] var1, int var2, int var3);

    public abstract void zza(byte var1);

    public final void zza(double d10) {
        long l10 = Double.doubleToRawLongBits(d10);
        this.zzd(l10);
    }

    public final void zza(float f10) {
        int n10 = Float.floatToRawIntBits(f10);
        this.zzq(n10);
    }

    public final void zza(int n10, double d10) {
        long l10 = Double.doubleToRawLongBits(d10);
        this.zzc(n10, l10);
    }

    public final void zza(int n10, float f10) {
        int n11 = Float.floatToRawIntBits(f10);
        this.zzf(n10, n11);
    }

    public abstract void zza(int var1, long var2);

    public abstract void zza(int var1, zzbb var2);

    public abstract void zza(int var1, zzdo var2);

    public abstract void zza(int var1, zzdo var2, zzef var3);

    public abstract void zza(int var1, String var2);

    public abstract void zza(zzbb var1);

    public abstract void zza(zzdo var1, zzef var2);

    public final void zza(String object, zzfi object2) {
        Logger logger = zzbn.logger;
        Level level = Level.WARNING;
        String string2 = "com.google.protobuf.CodedOutputStream";
        String string3 = "inefficientWriteStringNoTag";
        String string4 = "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!";
        logger.logp(level, string2, string3, string4, (Throwable)object2);
        object2 = zzci.UTF_8;
        object = ((String)object).getBytes((Charset)object2);
        int n10 = ((Object)object).length;
        this.zzo(n10);
        n10 = 0;
        object2 = null;
        int n11 = ((Object)object).length;
        try {
            this.zza((byte[])object, 0, n11);
            return;
        }
        catch (zzbn$zzc zzbn$zzc) {
            throw zzbn$zzc;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object2 = new zzbn$zzc(indexOutOfBoundsException);
            throw object2;
        }
    }

    public final void zza(boolean bl2) {
        byte by2 = (byte)(bl2 ? 1 : 0);
        this.zza(by2);
    }

    public abstract int zzag();

    public abstract void zzb(int var1, int var2);

    public final void zzb(int n10, long l10) {
        l10 = zzbn.zzj(l10);
        this.zza(n10, l10);
    }

    public abstract void zzb(int var1, zzbb var2);

    public abstract void zzb(int var1, zzdo var2);

    public abstract void zzb(int var1, boolean var2);

    public abstract void zzb(long var1);

    public abstract void zzb(zzdo var1);

    public abstract void zzc(int var1, int var2);

    public abstract void zzc(int var1, long var2);

    public final void zzc(long l10) {
        l10 = zzbn.zzj(l10);
        this.zzb(l10);
    }

    public abstract void zzd(int var1, int var2);

    public abstract void zzd(long var1);

    public abstract void zzd(byte[] var1, int var2, int var3);

    public final void zze(int n10, int n11) {
        n11 = zzbn.zzy(n11);
        this.zzd(n10, n11);
    }

    public abstract void zzf(int var1, int var2);

    public abstract void zzg(String var1);

    public abstract void zzn(int var1);

    public abstract void zzo(int var1);

    public final void zzp(int n10) {
        n10 = zzbn.zzy(n10);
        this.zzo(n10);
    }

    public abstract void zzq(int var1);
}

