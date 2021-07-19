/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgg;
import com.google.android.gms.internal.vision.zzhe;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzlf;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

public final class zzie {
    private static final Charset ISO_8859_1;
    public static final Charset UTF_8;
    public static final byte[] zzys;
    private static final ByteBuffer zzyt;
    private static final zzhe zzyu;

    static {
        UTF_8 = Charset.forName("UTF-8");
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        byte[] byArray = new byte[]{};
        zzys = byArray;
        zzyt = ByteBuffer.wrap(byArray);
        int n10 = byArray.length;
        zzyu = zzhe.zza(byArray, 0, n10, false);
    }

    public static Object checkNotNull(Object object) {
        Objects.requireNonNull(object);
        return object;
    }

    public static int hashCode(byte[] byArray) {
        int n10 = byArray.length;
        int n11 = zzie.zza(n10, byArray, 0, n10);
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

    public static Object zza(Object object, String string2) {
        Objects.requireNonNull(object, string2);
        return object;
    }

    public static int zzab(long l10) {
        long l11 = l10 >>> 32;
        return (int)(l10 ^ l11);
    }

    public static Object zzb(Object object, Object object2) {
        object = ((zzjn)object).zzhc();
        object2 = (zzjn)object2;
        return object.zza((zzjn)object2).zzgv();
    }

    public static boolean zzf(zzjn zzjn2) {
        boolean bl2 = zzjn2 instanceof zzgg;
        if (bl2) {
            zzjn2 = (zzgg)zzjn2;
        }
        return false;
    }

    public static boolean zzg(byte[] byArray) {
        return zzlf.zzg(byArray);
    }

    public static String zzh(byte[] byArray) {
        Charset charset = UTF_8;
        String string2 = new String(byArray, charset);
        return string2;
    }

    public static int zzm(boolean bl2) {
        if (bl2) {
            return 1231;
        }
        return 1237;
    }
}

