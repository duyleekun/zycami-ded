/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgu;
import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzix;
import com.google.android.gms.internal.measurement.zzkn;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

public final class zzia {
    public static final Charset zza;
    public static final Charset zzb;
    public static final byte[] zzc;
    public static final ByteBuffer zzd;
    public static final zzgv zze;

    static {
        zzgu zzgu2;
        zza = Charset.forName("UTF-8");
        zzb = Charset.forName("ISO-8859-1");
        Object var0 = null;
        byte[] byArray = new byte[]{};
        zzc = byArray;
        zzd = ByteBuffer.wrap(byArray);
        Object object = zzgu2;
        zzgu2 = new zzgu(byArray, 0, 0, false, null);
        try {
            zzgu2.zza(0);
            zze = zzgu2;
            return;
        }
        catch (zzic zzic2) {
            object = new IllegalArgumentException(zzic2);
            throw object;
        }
    }

    public static Object zza(Object object) {
        Objects.requireNonNull(object);
        return object;
    }

    public static Object zzb(Object object, String string2) {
        Objects.requireNonNull(object, string2);
        return object;
    }

    public static boolean zzc(byte[] byArray) {
        return zzkn.zza(byArray);
    }

    public static String zzd(byte[] byArray) {
        Charset charset = zza;
        String string2 = new String(byArray, charset);
        return string2;
    }

    public static int zze(long l10) {
        long l11 = l10 >>> 32;
        return (int)(l10 ^ l11);
    }

    public static int zzf(boolean bl2) {
        if (bl2) {
            return 1231;
        }
        return 1237;
    }

    public static int zzg(byte[] byArray) {
        int n10 = byArray.length;
        int n11 = zzia.zzh(n10, byArray, 0, n10);
        if (n11 == 0) {
            n11 = 1;
        }
        return n11;
    }

    public static int zzh(int n10, byte[] byArray, int n11, int n12) {
        for (n11 = 0; n11 < n12; ++n11) {
            n10 *= 31;
            byte by2 = byArray[n11];
            n10 += by2;
        }
        return n10;
    }

    public static Object zzi(Object object, Object object2) {
        object = ((zzix)object).zzbG();
        object2 = (zzix)object2;
        return object.zzau((zzix)object2).zzaD();
    }
}

