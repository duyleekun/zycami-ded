/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzgw;
import com.google.android.gms.internal.measurement.zzgx;
import com.google.android.gms.internal.measurement.zzgy;
import com.google.android.gms.internal.measurement.zzha;
import com.google.android.gms.internal.measurement.zzia;
import com.google.android.gms.internal.measurement.zzif;
import com.google.android.gms.internal.measurement.zzix;
import com.google.android.gms.internal.measurement.zzji;
import com.google.android.gms.internal.measurement.zzkh;
import com.google.android.gms.internal.measurement.zzkl;
import com.google.android.gms.internal.measurement.zzkn;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzgz
extends zzgh {
    private static final Logger zzb = Logger.getLogger(zzgz.class.getName());
    private static final boolean zzc = zzkh.zza();
    public zzha zza;

    private zzgz() {
    }

    public /* synthetic */ zzgz(zzgw zzgw2) {
    }

    public static int zzA(zzgs zzgs2) {
        int n10 = zzgs2.zzc();
        return zzgz.zzw(n10) + n10;
    }

    public static int zzB(zzix zzix2, zzji zzji2) {
        int n10;
        int n11 = ((zzgb)(zzix2 = (zzgb)zzix2)).zzbq();
        if (n11 == (n10 = -1)) {
            n11 = zzji2.zze(zzix2);
            ((zzgb)zzix2).zzbr(n11);
        }
        return zzgz.zzw(n11) + n11;
    }

    public static int zzE(int n10, zzix zzix2, zzji zzji2) {
        int n11;
        n10 = zzgz.zzw(n10 << 3);
        n10 += n10;
        int n12 = ((zzgb)(zzix2 = (zzgb)zzix2)).zzbq();
        if (n12 == (n11 = -1)) {
            n12 = zzji2.zze(zzix2);
            ((zzgb)zzix2).zzbr(n12);
        }
        return n10 + n12;
    }

    public static /* synthetic */ boolean zzF() {
        return zzc;
    }

    public static zzgz zzt(byte[] byArray) {
        int n10 = byArray.length;
        zzgx zzgx2 = new zzgx(byArray, 0, n10);
        return zzgx2;
    }

    public static int zzu(int n10) {
        return zzgz.zzw(n10 << 3);
    }

    public static int zzv(int n10) {
        if (n10 >= 0) {
            return zzgz.zzw(n10);
        }
        return 10;
    }

    public static int zzw(int n10) {
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

    public static int zzx(long l10) {
        long l11;
        long l12;
        long l13 = (long)-128 & l10;
        long l14 = 0L;
        Object object = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        int n10 = 1;
        if (object == false) {
            return n10;
        }
        object = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
        if (object < 0) {
            return 10;
        }
        long l15 = 0xFFFFFFF800000000L & l10;
        long l16 = l15 - l14;
        object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object != false) {
            l10 >>>= 28;
            object = 6;
        } else {
            object = 2;
        }
        l15 = 0xFFE00000L & l10;
        long l17 = l15 == l14 ? 0 : (l15 < l14 ? -1 : 1);
        if (l17 != false) {
            object += 2;
            l17 = 14;
            l10 >>>= l17;
        }
        if ((l12 = (l11 = (l10 &= (l15 = -16384L)) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            object += n10;
        }
        return (int)object;
    }

    public static int zzy(String object) {
        int n10;
        try {
            n10 = zzkn.zzc((CharSequence)object);
        }
        catch (zzkl zzkl2) {
            Charset charset = zzia.zza;
            object = ((String)object).getBytes(charset);
            n10 = ((Object)object).length;
        }
        return zzgz.zzw(n10) + n10;
    }

    public static int zzz(zzif zzif2) {
        int n10 = zzif2.zza();
        return zzgz.zzw(n10) + n10;
    }

    public final void zzC() {
        int n10 = this.zzs();
        if (n10 == 0) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Did not write as much data as expected.");
        throw illegalStateException;
    }

    public final void zzD(String object, zzkl object2) {
        Logger logger = zzb;
        Level level = Level.WARNING;
        String string2 = "com.google.protobuf.CodedOutputStream";
        String string3 = "inefficientWriteStringNoTag";
        String string4 = "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!";
        logger.logp(level, string2, string3, string4, (Throwable)object2);
        object2 = zzia.zza;
        object = ((String)object).getBytes((Charset)object2);
        int n10 = ((Object)object).length;
        this.zzl(n10);
        logger = null;
        try {
            this.zzq((byte[])object, 0, n10);
            return;
        }
        catch (zzgy zzgy2) {
            throw zzgy2;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object2 = new zzgy(indexOutOfBoundsException);
            throw object2;
        }
    }

    public abstract void zza(int var1, int var2);

    public abstract void zzb(int var1, int var2);

    public abstract void zzc(int var1, int var2);

    public abstract void zzd(int var1, int var2);

    public abstract void zze(int var1, long var2);

    public abstract void zzf(int var1, long var2);

    public abstract void zzg(int var1, boolean var2);

    public abstract void zzh(int var1, String var2);

    public abstract void zzi(int var1, zzgs var2);

    public abstract void zzj(byte var1);

    public abstract void zzk(int var1);

    public abstract void zzl(int var1);

    public abstract void zzm(int var1);

    public abstract void zzn(long var1);

    public abstract void zzo(long var1);

    public abstract void zzq(byte[] var1, int var2, int var3);

    public abstract int zzs();
}

