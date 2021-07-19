/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzge;
import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzgt;
import com.google.android.gms.internal.vision.zzhk;
import com.google.android.gms.internal.vision.zzhl$zza;
import com.google.android.gms.internal.vision.zzhl$zzb;
import com.google.android.gms.internal.vision.zzhn;
import com.google.android.gms.internal.vision.zzie;
import com.google.android.gms.internal.vision.zzis;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzkf;
import com.google.android.gms.internal.vision.zzld;
import com.google.android.gms.internal.vision.zzlf;
import com.google.android.gms.internal.vision.zzlj;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzhl
extends zzgt {
    private static final Logger logger = Logger.getLogger(zzhl.class.getName());
    private static final boolean zzun = zzld.zzje();
    public zzhn zzuo;

    private zzhl() {
    }

    public /* synthetic */ zzhl(zzhk zzhk2) {
        this();
    }

    public static int zza(int n10, zzis zzis2) {
        n10 = zzhl.zzbj(n10 << 3);
        int n11 = zzis2.zzgz();
        int n12 = zzhl.zzbj(n11) + n11;
        return n10 + n12;
    }

    public static int zza(zzis zzis2) {
        int n10 = zzis2.zzgz();
        return zzhl.zzbj(n10) + n10;
    }

    public static int zza(zzjn zzjn2, zzkf zzkf2) {
        int n10;
        int n11 = ((zzge)(zzjn2 = (zzge)zzjn2)).zzef();
        if (n11 == (n10 = -1)) {
            n11 = zzkf2.zzu(zzjn2);
            ((zzge)zzjn2).zzak(n11);
        }
        return zzhl.zzbj(n11) + n11;
    }

    private static long zzaa(long l10) {
        long l11 = l10 << 1;
        return l10 >> 63 ^ l11;
    }

    public static int zzb(double d10) {
        return 8;
    }

    public static int zzb(int n10, double d10) {
        return zzhl.zzbj(n10 << 3) + 8;
    }

    public static int zzb(int n10, float f10) {
        return zzhl.zzbj(n10 << 3) + 4;
    }

    public static int zzb(int n10, zzis zzis2) {
        int n11 = zzhl.zzbj(8) << 1;
        n10 = zzhl.zzo(2, n10);
        n11 += n10;
        n10 = zzhl.zza(3, zzis2);
        return n11 + n10;
    }

    public static int zzb(int n10, zzjn zzjn2) {
        int n11 = zzhl.zzbj(8) << 1;
        n10 = zzhl.zzo(2, n10);
        n11 += n10;
        n10 = zzhl.zzbj(24);
        int n12 = zzhl.zzc(zzjn2);
        return n11 + (n10 += n12);
    }

    public static int zzb(int n10, zzjn zzjn2, zzkf zzkf2) {
        n10 = zzhl.zzbj(n10 << 3);
        int n11 = zzhl.zza(zzjn2, zzkf2);
        return n10 + n11;
    }

    public static int zzb(int n10, String string2) {
        n10 = zzhl.zzbj(n10 << 3);
        int n11 = zzhl.zzx(string2);
        return n10 + n11;
    }

    public static int zzb(int n10, boolean bl2) {
        return zzhl.zzbj(n10 << 3) + 1;
    }

    public static int zzb(zzgs zzgs2) {
        int n10 = zzgs2.size();
        return zzhl.zzbj(n10) + n10;
    }

    public static int zzbh(int n10) {
        return zzhl.zzbj(n10 << 3);
    }

    public static int zzbi(int n10) {
        if (n10 >= 0) {
            return zzhl.zzbj(n10);
        }
        return 10;
    }

    public static int zzbj(int n10) {
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

    public static int zzbk(int n10) {
        return zzhl.zzbj(zzhl.zzbo(n10));
    }

    public static int zzbl(int n10) {
        return 4;
    }

    public static int zzbm(int n10) {
        return 4;
    }

    public static int zzbn(int n10) {
        return zzhl.zzbi(n10);
    }

    private static int zzbo(int n10) {
        int n11 = n10 << 1;
        return n10 >> 31 ^ n11;
    }

    public static int zzbp(int n10) {
        return zzhl.zzbj(n10);
    }

    public static int zzc(int n10, zzgs zzgs2) {
        n10 = zzhl.zzbj(n10 << 3);
        int n11 = zzgs2.size();
        int n12 = zzhl.zzbj(n11) + n11;
        return n10 + n12;
    }

    public static int zzc(int n10, zzjn zzjn2, zzkf zzkf2) {
        int n11;
        n10 = zzhl.zzbj(n10 << 3) << 1;
        int n12 = ((zzge)(zzjn2 = (zzge)zzjn2)).zzef();
        if (n12 == (n11 = -1)) {
            n12 = zzkf2.zzu(zzjn2);
            ((zzge)zzjn2).zzak(n12);
        }
        return n10 + n12;
    }

    public static int zzc(zzjn zzjn2) {
        int n10 = zzjn2.zzgz();
        return zzhl.zzbj(n10) + n10;
    }

    public static int zzd(int n10, long l10) {
        n10 = zzhl.zzbj(n10 << 3);
        int n11 = zzhl.zzw(l10);
        return n10 + n11;
    }

    public static int zzd(int n10, zzgs zzgs2) {
        int n11 = zzhl.zzbj(8) << 1;
        n10 = zzhl.zzo(2, n10);
        n11 += n10;
        n10 = zzhl.zzc(3, zzgs2);
        return n11 + n10;
    }

    public static int zzd(zzjn zzjn2) {
        return zzjn2.zzgz();
    }

    public static int zze(int n10, long l10) {
        n10 = zzhl.zzbj(n10 << 3);
        int n11 = zzhl.zzw(l10);
        return n10 + n11;
    }

    public static zzhl zze(byte[] byArray) {
        int n10 = byArray.length;
        zzhl$zzb zzhl$zzb = new zzhl$zzb(byArray, 0, n10);
        return zzhl$zzb;
    }

    public static int zzf(int n10, long l10) {
        n10 = zzhl.zzbj(n10 << 3);
        int n11 = zzhl.zzw(zzhl.zzaa(l10));
        return n10 + n11;
    }

    public static int zzf(byte[] byArray) {
        int n10 = byArray.length;
        return zzhl.zzbj(n10) + n10;
    }

    public static int zzg(int n10, long l10) {
        return zzhl.zzbj(n10 << 3) + 8;
    }

    public static /* synthetic */ boolean zzgc() {
        return zzun;
    }

    public static int zzh(int n10, long l10) {
        return zzhl.zzbj(n10 << 3) + 8;
    }

    public static int zzl(boolean bl2) {
        return 1;
    }

    public static int zzn(int n10, int n11) {
        n10 = zzhl.zzbj(n10 << 3);
        n11 = zzhl.zzbi(n11);
        return n10 + n11;
    }

    public static int zzo(int n10, int n11) {
        n10 = zzhl.zzbj(n10 << 3);
        n11 = zzhl.zzbj(n11);
        return n10 + n11;
    }

    public static int zzp(int n10, int n11) {
        n10 = zzhl.zzbj(n10 << 3);
        n11 = zzhl.zzbj(zzhl.zzbo(n11));
        return n10 + n11;
    }

    public static int zzq(int n10, int n11) {
        return zzhl.zzbj(n10 << 3) + 4;
    }

    public static int zzr(int n10, int n11) {
        return zzhl.zzbj(n10 << 3) + 4;
    }

    public static int zzs(int n10, int n11) {
        n10 = zzhl.zzbj(n10 << 3);
        n11 = zzhl.zzbi(n11);
        return n10 + n11;
    }

    public static int zzt(float f10) {
        return 4;
    }

    public static int zzv(long l10) {
        return zzhl.zzw(l10);
    }

    public static int zzw(long l10) {
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

    public static int zzx(long l10) {
        return zzhl.zzw(zzhl.zzaa(l10));
    }

    public static int zzx(String object) {
        int n10;
        try {
            n10 = zzlf.zza((CharSequence)object);
        }
        catch (zzlj zzlj2) {
            Charset charset = zzie.UTF_8;
            object = ((String)object).getBytes(charset);
            n10 = ((Object)object).length;
        }
        return zzhl.zzbj(n10) + n10;
    }

    public static int zzy(long l10) {
        return 8;
    }

    public static int zzz(long l10) {
        return 8;
    }

    public abstract void writeTag(int var1, int var2);

    public final void zza(double d10) {
        long l10 = Double.doubleToRawLongBits(d10);
        this.zzu(l10);
    }

    public final void zza(int n10, double d10) {
        long l10 = Double.doubleToRawLongBits(d10);
        this.zzc(n10, l10);
    }

    public final void zza(int n10, float f10) {
        int n11 = Float.floatToRawIntBits(f10);
        this.zzm(n10, n11);
    }

    public abstract void zza(int var1, long var2);

    public abstract void zza(int var1, zzgs var2);

    public abstract void zza(int var1, zzjn var2);

    public abstract void zza(int var1, zzjn var2, zzkf var3);

    public abstract void zza(int var1, String var2);

    public abstract void zza(int var1, boolean var2);

    public abstract void zza(zzgs var1);

    public final void zza(String object, zzlj object2) {
        Logger logger = zzhl.logger;
        Level level = Level.WARNING;
        String string2 = "com.google.protobuf.CodedOutputStream";
        String string3 = "inefficientWriteStringNoTag";
        String string4 = "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!";
        logger.logp(level, string2, string3, string4, (Throwable)object2);
        object2 = zzie.UTF_8;
        object = ((String)object).getBytes((Charset)object2);
        int n10 = ((Object)object).length;
        this.zzbe(n10);
        n10 = 0;
        object2 = null;
        int n11 = ((Object)object).length;
        try {
            this.zzc((byte[])object, 0, n11);
            return;
        }
        catch (zzhl$zza zzhl$zza) {
            throw zzhl$zza;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            object2 = new zzhl$zza(indexOutOfBoundsException);
            throw object2;
        }
    }

    public final void zzb(int n10, long l10) {
        l10 = zzhl.zzaa(l10);
        this.zza(n10, l10);
    }

    public abstract void zzb(int var1, zzgs var2);

    public abstract void zzb(zzjn var1);

    public abstract void zzbd(int var1);

    public abstract void zzbe(int var1);

    public final void zzbf(int n10) {
        n10 = zzhl.zzbo(n10);
        this.zzbe(n10);
    }

    public abstract void zzbg(int var1);

    public abstract void zzc(byte var1);

    public abstract void zzc(int var1, long var2);

    public abstract void zze(byte[] var1, int var2, int var3);

    public abstract int zzga();

    public final void zzgb() {
        int n10 = this.zzga();
        if (n10 == 0) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Did not write as much data as expected.");
        throw illegalStateException;
    }

    public abstract void zzj(int var1, int var2);

    public abstract void zzk(int var1, int var2);

    public final void zzk(boolean bl2) {
        byte by2 = (byte)(bl2 ? 1 : 0);
        this.zzc(by2);
    }

    public final void zzl(int n10, int n11) {
        n11 = zzhl.zzbo(n11);
        this.zzk(n10, n11);
    }

    public abstract void zzm(int var1, int var2);

    public final void zzs(float f10) {
        int n10 = Float.floatToRawIntBits(f10);
        this.zzbg(n10);
    }

    public abstract void zzs(long var1);

    public final void zzt(long l10) {
        l10 = zzhl.zzaa(l10);
        this.zzs(l10);
    }

    public abstract void zzu(long var1);

    public abstract void zzw(String var1);
}

