/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbk;
import com.google.android.gms.internal.clearcut.zzdo;
import com.google.android.gms.internal.clearcut.zzff;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

public final class zzci {
    private static final Charset ISO_8859_1;
    public static final Charset UTF_8;
    public static final byte[] zzkt;
    private static final ByteBuffer zzku;
    private static final zzbk zzkv;

    static {
        UTF_8 = Charset.forName("UTF-8");
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        byte[] byArray = new byte[]{};
        zzkt = byArray;
        zzku = ByteBuffer.wrap(byArray);
        int n10 = byArray.length;
        zzkv = zzbk.zza(byArray, 0, n10, false);
    }

    public static Object checkNotNull(Object object) {
        Objects.requireNonNull(object);
        return object;
    }

    public static int hashCode(byte[] byArray) {
        int n10 = byArray.length;
        int n11 = zzci.zza(n10, byArray, 0, n10);
        if (n11 == 0) {
            n11 = 1;
        }
        return n11;
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

    public static Object zza(Object object, Object object2) {
        object = ((zzdo)object).zzbc();
        object2 = (zzdo)object2;
        return object.zza((zzdo)object2).zzbi();
    }

    public static Object zza(Object object, String string2) {
        Objects.requireNonNull(object, string2);
        return object;
    }

    public static int zzc(boolean bl2) {
        if (bl2) {
            return 1231;
        }
        return 1237;
    }

    public static boolean zze(byte[] byArray) {
        return zzff.zze(byArray);
    }

    public static String zzf(byte[] byArray) {
        Charset charset = UTF_8;
        String string2 = new String(byArray, charset);
        return string2;
    }

    public static boolean zzf(zzdo zzdo2) {
        return false;
    }

    public static int zzl(long l10) {
        long l11 = l10 >>> 32;
        return (int)(l10 ^ l11);
    }
}

