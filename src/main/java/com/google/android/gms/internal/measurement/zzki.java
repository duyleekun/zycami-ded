/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzic;

public final class zzki {
    public static /* synthetic */ boolean zza(byte by2) {
        return by2 >= 0;
    }

    public static /* synthetic */ boolean zzb(byte by2) {
        byte by3 = -32;
        return by2 < by3;
    }

    public static /* synthetic */ void zzc(byte by2, byte by3, char[] cArray, int n10) {
        byte by4 = -62;
        if (by2 >= by4 && (by4 = (byte)(zzki.zzg(by3) ? 1 : 0)) == 0) {
            by2 = (byte)((by2 & 0x1F) << 6);
            by3 = (byte)(by3 & 0x3F);
            by2 = (byte)(by2 | by3);
            cArray[n10] = (char)by2;
            return;
        }
        throw zzic.zzf();
    }

    public static /* synthetic */ boolean zzd(byte by2) {
        byte by3 = -16;
        return by2 < by3;
    }

    public static /* synthetic */ void zze(byte n10, byte by2, byte by3, char[] cArray, int n11) {
        block4: {
            byte by4;
            block6: {
                int n12;
                block5: {
                    by4 = zzki.zzg(by2);
                    if (by4 != 0) break block4;
                    by4 = -96;
                    n12 = -32;
                    if (n10 != n12) break block5;
                    if (by2 < by4) break block4;
                    n10 = n12;
                }
                if (n10 != (n12 = -19)) break block6;
                if (by2 >= by4) break block4;
                n10 = n12;
            }
            if ((by4 = (byte)(zzki.zzg(by3) ? 1 : 0)) == 0) {
                n10 = (n10 & 0xF) << 12;
                by2 = (byte)((by2 & 0x3F) << 6);
                n10 |= by2;
                by2 = (byte)(by3 & 0x3F);
                cArray[n11] = n10 = (int)((char)(n10 | by2));
                return;
            }
        }
        throw zzic.zzf();
    }

    public static /* synthetic */ void zzf(byte by2, byte by3, byte by4, byte by5, char[] cArray, int n10) {
        int n11 = zzki.zzg(by3);
        if (n11 == 0) {
            n11 = by2 << 28;
            int n12 = by3 + 112;
            if ((n11 = n11 + n12 >> 30) == 0 && (n11 = (int)(zzki.zzg(by4) ? 1 : 0)) == 0 && (n11 = (int)(zzki.zzg(by5) ? 1 : 0)) == 0) {
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
        throw zzic.zzf();
    }

    private static boolean zzg(byte by2) {
        byte by3 = -65;
        return by2 > by3;
    }
}

