/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzeg;
import com.google.android.gms.internal.mlkit_common.zzem;
import com.google.android.gms.internal.mlkit_common.zzep;
import com.google.android.gms.internal.mlkit_common.zzfc$zza;
import com.google.android.gms.internal.mlkit_common.zzfc$zzb;
import com.google.android.gms.internal.mlkit_common.zzfe;
import com.google.android.gms.internal.mlkit_common.zzff;
import com.google.android.gms.internal.mlkit_common.zzfs;
import com.google.android.gms.internal.mlkit_common.zzgg;
import com.google.android.gms.internal.mlkit_common.zzhb;
import com.google.android.gms.internal.mlkit_common.zzhr;
import com.google.android.gms.internal.mlkit_common.zzip;
import com.google.android.gms.internal.mlkit_common.zzir;
import com.google.android.gms.internal.mlkit_common.zzis;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzfc
extends zzem {
    private static final Logger zzb = Logger.getLogger(zzfc.class.getName());
    private static final boolean zzc = zzip.zza();
    public zzff zza;

    private zzfc() {
    }

    public /* synthetic */ zzfc(zzfe zzfe2) {
        this();
    }

    public static int zza(int n10, zzgg zzgg2) {
        n10 = zzfc.zzg(n10 << 3);
        int n11 = zzgg2.zzb();
        int n12 = zzfc.zzg(n11) + n11;
        return n10 + n12;
    }

    public static int zza(zzgg zzgg2) {
        int n10 = zzgg2.zzb();
        return zzfc.zzg(n10) + n10;
    }

    public static int zza(zzhb zzhb2, zzhr zzhr2) {
        int n10;
        int n11 = ((zzeg)(zzhb2 = (zzeg)zzhb2)).zzg();
        if (n11 == (n10 = -1)) {
            n11 = zzhr2.zzd(zzhb2);
            ((zzeg)zzhb2).zza(n11);
        }
        return zzfc.zzg(n11) + n11;
    }

    public static zzfc zza(byte[] byArray) {
        int n10 = byArray.length;
        zzfc$zza zzfc$zza = new zzfc$zza(byArray, 0, n10);
        return zzfc$zza;
    }

    public static int zzb(double d10) {
        return 8;
    }

    public static int zzb(float f10) {
        return 4;
    }

    public static int zzb(int n10, double d10) {
        return zzfc.zzg(n10 << 3) + 8;
    }

    public static int zzb(int n10, float f10) {
        return zzfc.zzg(n10 << 3) + 4;
    }

    public static int zzb(int n10, zzgg zzgg2) {
        int n11 = zzfc.zzg(8) << 1;
        n10 = zzfc.zzg(2, n10);
        n11 += n10;
        n10 = zzfc.zza(3, zzgg2);
        return n11 + n10;
    }

    public static int zzb(int n10, zzhb zzhb2) {
        int n11 = zzfc.zzg(8) << 1;
        n10 = zzfc.zzg(2, n10);
        n11 += n10;
        n10 = zzfc.zzg(24);
        int n12 = zzfc.zzb(zzhb2);
        return n11 + (n10 += n12);
    }

    public static int zzb(int n10, zzhb zzhb2, zzhr zzhr2) {
        n10 = zzfc.zzg(n10 << 3);
        int n11 = zzfc.zza(zzhb2, zzhr2);
        return n10 + n11;
    }

    public static int zzb(int n10, String string2) {
        n10 = zzfc.zzg(n10 << 3);
        int n11 = zzfc.zzb(string2);
        return n10 + n11;
    }

    public static int zzb(int n10, boolean bl2) {
        return zzfc.zzg(n10 << 3) + 1;
    }

    public static int zzb(zzep zzep2) {
        int n10 = zzep2.zza();
        return zzfc.zzg(n10) + n10;
    }

    public static int zzb(zzhb zzhb2) {
        int n10 = zzhb2.zzj();
        return zzfc.zzg(n10) + n10;
    }

    public static int zzb(String object) {
        int n10;
        try {
            n10 = zzir.zza((CharSequence)object);
        }
        catch (zzis zzis2) {
            Charset charset = zzfs.zza;
            object = ((String)object).getBytes(charset);
            n10 = ((Object)object).length;
        }
        return zzfc.zzg(n10) + n10;
    }

    public static int zzb(boolean bl2) {
        return 1;
    }

    public static int zzb(byte[] byArray) {
        int n10 = byArray.length;
        return zzfc.zzg(n10) + n10;
    }

    public static int zzc(int n10, zzep zzep2) {
        n10 = zzfc.zzg(n10 << 3);
        int n11 = zzep2.zza();
        int n12 = zzfc.zzg(n11) + n11;
        return n10 + n12;
    }

    public static int zzc(int n10, zzhb zzhb2, zzhr zzhr2) {
        int n11;
        n10 = zzfc.zzg(n10 << 3) << 1;
        int n12 = ((zzeg)(zzhb2 = (zzeg)zzhb2)).zzg();
        if (n12 == (n11 = -1)) {
            n12 = zzhr2.zzd(zzhb2);
            ((zzeg)zzhb2).zza(n12);
        }
        return n10 + n12;
    }

    public static int zzc(zzhb zzhb2) {
        return zzhb2.zzj();
    }

    public static /* synthetic */ boolean zzc() {
        return zzc;
    }

    public static int zzd(int n10, long l10) {
        n10 = zzfc.zzg(n10 << 3);
        int n11 = zzfc.zze(l10);
        return n10 + n11;
    }

    public static int zzd(int n10, zzep zzep2) {
        int n11 = zzfc.zzg(8) << 1;
        n10 = zzfc.zzg(2, n10);
        n11 += n10;
        n10 = zzfc.zzc(3, zzep2);
        return n11 + n10;
    }

    public static int zzd(long l10) {
        return zzfc.zze(l10);
    }

    public static int zze(int n10) {
        return zzfc.zzg(n10 << 3);
    }

    public static int zze(int n10, long l10) {
        n10 = zzfc.zzg(n10 << 3);
        int n11 = zzfc.zze(l10);
        return n10 + n11;
    }

    public static int zze(long l10) {
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

    public static int zzf(int n10) {
        if (n10 >= 0) {
            return zzfc.zzg(n10);
        }
        return 10;
    }

    public static int zzf(int n10, int n11) {
        n10 = zzfc.zzg(n10 << 3);
        n11 = zzfc.zzf(n11);
        return n10 + n11;
    }

    public static int zzf(int n10, long l10) {
        n10 = zzfc.zzg(n10 << 3);
        int n11 = zzfc.zze(zzfc.zzi(l10));
        return n10 + n11;
    }

    public static int zzf(long l10) {
        return zzfc.zze(zzfc.zzi(l10));
    }

    public static int zzg(int n10) {
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

    public static int zzg(int n10, int n11) {
        n10 = zzfc.zzg(n10 << 3);
        n11 = zzfc.zzg(n11);
        return n10 + n11;
    }

    public static int zzg(int n10, long l10) {
        return zzfc.zzg(n10 << 3) + 8;
    }

    public static int zzg(long l10) {
        return 8;
    }

    public static int zzh(int n10) {
        return zzfc.zzg(zzfc.zzm(n10));
    }

    public static int zzh(int n10, int n11) {
        n10 = zzfc.zzg(n10 << 3);
        n11 = zzfc.zzg(zzfc.zzm(n11));
        return n10 + n11;
    }

    public static int zzh(int n10, long l10) {
        return zzfc.zzg(n10 << 3) + 8;
    }

    public static int zzh(long l10) {
        return 8;
    }

    public static int zzi(int n10) {
        return 4;
    }

    public static int zzi(int n10, int n11) {
        return zzfc.zzg(n10 << 3) + 4;
    }

    private static long zzi(long l10) {
        long l11 = l10 << 1;
        return l10 >> 63 ^ l11;
    }

    public static int zzj(int n10) {
        return 4;
    }

    public static int zzj(int n10, int n11) {
        return zzfc.zzg(n10 << 3) + 4;
    }

    public static int zzk(int n10) {
        return zzfc.zzf(n10);
    }

    public static int zzk(int n10, int n11) {
        n10 = zzfc.zzg(n10 << 3);
        n11 = zzfc.zzf(n11);
        return n10 + n11;
    }

    public static int zzl(int n10) {
        return zzfc.zzg(n10);
    }

    private static int zzm(int n10) {
        int n11 = n10 << 1;
        return n10 >> 31 ^ n11;
    }

    public abstract int zza();

    public abstract void zza(byte var1);

    public final void zza(double d10) {
        long l10 = Double.doubleToRawLongBits(d10);
        this.zzc(l10);
    }

    public final void zza(float f10) {
        int n10 = Float.floatToRawIntBits(f10);
        this.zzd(n10);
    }

    public abstract void zza(int var1);

    public final void zza(int n10, double d10) {
        long l10 = Double.doubleToRawLongBits(d10);
        this.zzc(n10, l10);
    }

    public final void zza(int n10, float f10) {
        int n11 = Float.floatToRawIntBits(f10);
        this.zze(n10, n11);
    }

    public abstract void zza(int var1, int var2);

    public abstract void zza(int var1, long var2);

    public abstract void zza(int var1, zzep var2);

    public abstract void zza(int var1, zzhb var2);

    public abstract void zza(int var1, zzhb var2, zzhr var3);

    public abstract void zza(int var1, String var2);

    public abstract void zza(int var1, boolean var2);

    public abstract void zza(long var1);

    public abstract void zza(zzep var1);

    public abstract void zza(zzhb var1);

    public abstract void zza(String var1);

    public final void zza(String object, zzis object2) {
        Logger logger = zzb;
        Level level = Level.WARNING;
        String string2 = "com.google.protobuf.CodedOutputStream";
        String string3 = "inefficientWriteStringNoTag";
        String string4 = "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!";
        logger.logp(level, string2, string3, string4, (Throwable)object2);
        object2 = zzfs.zza;
        object = ((String)object).getBytes((Charset)object2);
        int n10 = ((Object)object).length;
        this.zzb(n10);
        n10 = 0;
        object2 = null;
        int n11 = ((Object)object).length;
        try {
            this.zza((byte[])object, 0, n11);
            return;
        }
        catch (zzfc$zzb zzfc$zzb) {
            throw zzfc$zzb;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object2 = new zzfc$zzb(indexOutOfBoundsException);
            throw object2;
        }
    }

    public final void zza(boolean bl2) {
        byte by2 = (byte)(bl2 ? 1 : 0);
        this.zza(by2);
    }

    public final void zzb() {
        int n10 = this.zza();
        if (n10 == 0) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Did not write as much data as expected.");
        throw illegalStateException;
    }

    public abstract void zzb(int var1);

    public abstract void zzb(int var1, int var2);

    public final void zzb(int n10, long l10) {
        l10 = zzfc.zzi(l10);
        this.zza(n10, l10);
    }

    public abstract void zzb(int var1, zzep var2);

    public final void zzb(long l10) {
        l10 = zzfc.zzi(l10);
        this.zza(l10);
    }

    public abstract void zzb(byte[] var1, int var2, int var3);

    public final void zzc(int n10) {
        n10 = zzfc.zzm(n10);
        this.zzb(n10);
    }

    public abstract void zzc(int var1, int var2);

    public abstract void zzc(int var1, long var2);

    public abstract void zzc(long var1);

    public abstract void zzd(int var1);

    public final void zzd(int n10, int n11) {
        n11 = zzfc.zzm(n11);
        this.zzc(n10, n11);
    }

    public abstract void zze(int var1, int var2);
}

