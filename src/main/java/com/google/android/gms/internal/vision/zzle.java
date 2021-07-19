/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzin;

public final class zzle {
    private static void zza(byte by2, byte by3, byte by4, byte by5, char[] cArray, int n10) {
        int n11 = zzle.zzg(by3);
        if (n11 == 0) {
            n11 = by2 << 28;
            int n12 = by3 + 112;
            if ((n11 = n11 + n12 >> 30) == 0 && (n11 = (int)(zzle.zzg(by4) ? 1 : 0)) == 0 && (n11 = (int)(zzle.zzg(by5) ? 1 : 0)) == 0) {
                by2 = (byte)((by2 & 7) << 18);
                by3 = (byte)((by3 & 0x3F) << 12);
                by2 = (byte)(by2 | by3);
                by3 = (byte)((by4 & 0x3F) << 6);
                by2 = (byte)(by2 | by3);
                by3 = (byte)(by5 & 0x3F);
                by2 = (byte)(by2 | by3);
                by3 = (byte)((by2 >>> 10) + 55232);
                cArray[n10] = (char)by3;
                by2 = (byte)((by2 & 0x3FF) + 56320);
                cArray[++n10] = (char)by2;
                return;
            }
        }
        throw zzin.zzho();
    }

    private static void zza(byte n10, byte by2, byte by3, char[] cArray, int n11) {
        int n12 = zzle.zzg(by2);
        if (n12 == 0) {
            n12 = -32;
            byte by4 = -96;
            if (!(n10 == n12 && by2 < by4 || n10 == (n12 = -19) && by2 >= by4 || (n12 = (int)(zzle.zzg(by3) ? 1 : 0)) != 0)) {
                n10 = (n10 & 0xF) << 12;
                by2 = (byte)((by2 & 0x3F) << 6);
                n10 |= by2;
                by2 = (byte)(by3 & 0x3F);
                cArray[n11] = n10 = (int)((char)(n10 | by2));
                return;
            }
        }
        throw zzin.zzho();
    }

    private static void zza(byte by2, byte by3, char[] cArray, int n10) {
        byte by4 = -62;
        if (by2 >= by4 && (by4 = (byte)(zzle.zzg(by3) ? 1 : 0)) == 0) {
            by2 = (byte)((by2 & 0x1F) << 6);
            by3 = (byte)(by3 & 0x3F);
            by2 = (byte)(by2 | by3);
            cArray[n10] = (char)by2;
            return;
        }
        throw zzin.zzho();
    }

    private static void zza(byte by2, char[] cArray, int n10) {
        by2 = by2;
        cArray[n10] = (char)by2;
    }

    public static /* synthetic */ void zzb(byte by2, byte by3, byte by4, byte by5, char[] cArray, int n10) {
        zzle.zza(by2, by3, by4, by5, cArray, n10);
    }

    public static /* synthetic */ void zzb(byte by2, byte by3, byte by4, char[] cArray, int n10) {
        zzle.zza(by2, by3, by4, cArray, n10);
    }

    public static /* synthetic */ void zzb(byte by2, byte by3, char[] cArray, int n10) {
        zzle.zza(by2, by3, cArray, n10);
    }

    public static /* synthetic */ void zzb(byte by2, char[] cArray, int n10) {
        zzle.zza(by2, cArray, n10);
    }

    private static boolean zzd(byte by2) {
        return by2 >= 0;
    }

    private static boolean zze(byte by2) {
        byte by3 = -32;
        return by2 < by3;
    }

    private static boolean zzf(byte by2) {
        byte by3 = -16;
        return by2 < by3;
    }

    private static boolean zzg(byte by2) {
        byte by3 = -65;
        return by2 > by3;
    }

    public static /* synthetic */ boolean zzh(byte by2) {
        return zzle.zzd(by2);
    }

    public static /* synthetic */ boolean zzi(byte by2) {
        return zzle.zze(by2);
    }

    public static /* synthetic */ boolean zzj(byte by2) {
        return zzle.zzf(by2);
    }
}

