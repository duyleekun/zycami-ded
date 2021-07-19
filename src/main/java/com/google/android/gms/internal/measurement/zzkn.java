/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzkh;
import com.google.android.gms.internal.measurement.zzkj;
import com.google.android.gms.internal.measurement.zzkk;
import com.google.android.gms.internal.measurement.zzkl;
import com.google.android.gms.internal.measurement.zzkm;

public final class zzkn {
    private static final zzkj zza;

    static {
        boolean bl2 = zzkh.zza();
        zzkj zzkj2 = bl2 && (bl2 = zzkh.zzb()) && !(bl2 = zzgd.zza()) ? new zzkm() : new zzkk();
        zza = zzkj2;
    }

    public static boolean zza(byte[] byArray) {
        zzkj zzkj2 = zza;
        int n10 = byArray.length;
        return zzkj2.zza(byArray, 0, n10);
    }

    public static boolean zzb(byte[] byArray, int n10, int n11) {
        return zza.zza(byArray, n10, n11);
    }

    public static int zzc(CharSequence object) {
        int n10;
        int n11;
        int n12;
        int n13 = object.length();
        int n14 = 0;
        for (n12 = 0; n12 < n13 && (n11 = (int)object.charAt(n12)) < (n10 = 128); ++n12) {
        }
        n11 = n13;
        while (n12 < n13) {
            int n15;
            n10 = object.charAt(n12);
            if (n10 < (n15 = 2048)) {
                n10 = 127 - n10 >>> 31;
                n11 += n10;
                ++n12;
                continue;
            }
            n10 = object.length();
            while (n12 < n10) {
                int n16 = object.charAt(n12);
                if (n16 < n15) {
                    n16 = 127 - n16 >>> 31;
                    n14 += n16;
                } else {
                    n14 += 2;
                    int n17 = 55296;
                    if (n16 >= n17 && n16 <= (n17 = 57343)) {
                        n16 = Character.codePointAt((CharSequence)object, n12);
                        if (n16 >= (n17 = 65536)) {
                            ++n12;
                        } else {
                            object = new zzkl(n12, n10);
                            throw object;
                        }
                    }
                }
                ++n12;
            }
            n11 += n14;
            break;
        }
        if (n11 >= n13) {
            return n11;
        }
        CharSequence charSequence = new StringBuilder(54);
        charSequence.append("UTF-8 length does not fit in int: ");
        long l10 = (long)n11 + 0x100000000L;
        charSequence.append(l10);
        charSequence = charSequence.toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }

    public static int zzd(CharSequence charSequence, byte[] byArray, int n10, int n11) {
        return zza.zzd(charSequence, byArray, n10, n11);
    }

    public static String zze(byte[] byArray, int n10, int n11) {
        return zza.zzc(byArray, n10, n11);
    }

    public static /* synthetic */ int zzf(int n10, int n11) {
        return zzkn.zzk(n10, n11);
    }

    public static /* synthetic */ int zzg(int n10, int n11, int n12) {
        return zzkn.zzl(n10, n11, n12);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ int zzh(byte[] object, int n10, int n11) {
        int n12;
        byte by2;
        void var1_2;
        byte by3 = var1_2 + -1;
        by3 = object[by3];
        if ((by2 -= var1_2) == false) return zzkn.zzj(by3);
        byte by4 = 1;
        if (by2 != by4) {
            byte by5 = 2;
            if (by2 == by5) {
                by2 = object[var1_2];
                n12 = object[var1_2 += by4];
                return zzkn.zzl(by3, by2, n12);
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        n12 = object[var1_2];
        return zzkn.zzk(by3, n12);
    }

    public static /* synthetic */ int zzi(int n10) {
        return zzkn.zzj(n10);
    }

    private static int zzj(int n10) {
        int n11 = -12;
        if (n10 > n11) {
            n10 = -1;
        }
        return n10;
    }

    private static int zzk(int n10, int n11) {
        int n12 = -12;
        if (n10 <= n12 && n11 <= (n12 = -65)) {
            return n10 ^ (n11 <<= 8);
        }
        return -1;
    }

    private static int zzl(int n10, int n11, int n12) {
        int n13 = -12;
        if (n10 <= n13 && n11 <= (n13 = -65) && n12 <= n13) {
            n11 = n12 << 16;
            return (n10 ^= (n11 <<= 8)) ^ n11;
        }
        return -1;
    }
}

