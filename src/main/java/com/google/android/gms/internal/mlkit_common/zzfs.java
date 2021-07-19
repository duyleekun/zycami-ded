/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzei;
import com.google.android.gms.internal.mlkit_common.zzfb;
import com.google.android.gms.internal.mlkit_common.zzhb;
import com.google.android.gms.internal.mlkit_common.zzir;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

public final class zzfs {
    public static final Charset zza = Charset.forName("UTF-8");
    public static final byte[] zzb;
    private static final Charset zzc;
    private static final ByteBuffer zzd;
    private static final zzfb zze;

    static {
        zzc = Charset.forName("ISO-8859-1");
        byte[] byArray = new byte[]{};
        zzb = byArray;
        zzd = ByteBuffer.wrap(byArray);
        int n10 = byArray.length;
        zze = zzfb.zza(byArray, 0, n10, false);
    }

    public static int zza(int n10, byte[] byArray, int n11, int n12) {
        int n13;
        for (int i10 = n11; i10 < (n13 = n11 + n12); ++i10) {
            n10 *= 31;
            n13 = byArray[i10];
            n10 += n13;
        }
        return n10;
    }

    public static int zza(long l10) {
        long l11 = l10 >>> 32;
        return (int)(l10 ^ l11);
    }

    public static int zza(boolean bl2) {
        if (bl2) {
            return 1231;
        }
        return 1237;
    }

    public static Object zza(Object object) {
        Objects.requireNonNull(object);
        return object;
    }

    public static Object zza(Object object, Object object2) {
        object = ((zzhb)object).zzm();
        object2 = (zzhb)object2;
        return object.zza((zzhb)object2).zzf();
    }

    public static Object zza(Object object, String string2) {
        Objects.requireNonNull(object, string2);
        return object;
    }

    public static boolean zza(zzhb zzhb2) {
        boolean bl2 = zzhb2 instanceof zzei;
        if (bl2) {
            zzhb2 = (zzei)zzhb2;
        }
        return false;
    }

    public static boolean zza(byte[] byArray) {
        return zzir.zza(byArray);
    }

    public static String zzb(byte[] byArray) {
        Charset charset = zza;
        String string2 = new String(byArray, charset);
        return string2;
    }

    public static int zzc(byte[] byArray) {
        int n10 = byArray.length;
        int n11 = zzfs.zza(n10, byArray, 0, n10);
        if (n11 == 0) {
            n11 = 1;
        }
        return n11;
    }
}

