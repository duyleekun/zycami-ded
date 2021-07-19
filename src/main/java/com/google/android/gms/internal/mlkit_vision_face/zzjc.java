/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzex;
import com.google.android.gms.internal.mlkit_vision_face.zziz;
import com.google.android.gms.internal.mlkit_vision_face.zzjd;
import com.google.android.gms.internal.mlkit_vision_face.zzje;
import com.google.android.gms.internal.mlkit_vision_face.zzjf;
import com.google.android.gms.internal.mlkit_vision_face.zzjg;

public final class zzjc {
    private static final zzje zza;

    static {
        zzje zzje2;
        boolean bl2 = zziz.zza();
        if (bl2 && (bl2 = zziz.zzb())) {
            bl2 = true;
        } else {
            bl2 = false;
            zzje2 = null;
        }
        zzje2 = bl2 && !(bl2 = zzex.zza()) ? new zzjf() : new zzjd();
        zza = zzje2;
    }

    public static /* synthetic */ int zza(int n10) {
        return zzjc.zzb(n10);
    }

    public static /* synthetic */ int zza(int n10, int n11) {
        return zzjc.zzb(n10, n11);
    }

    public static /* synthetic */ int zza(int n10, int n11, int n12) {
        return zzjc.zzb(n10, n11, n12);
    }

    public static int zza(CharSequence object) {
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
                    if (n17 <= n16 && n16 <= (n17 = 57343)) {
                        n16 = Character.codePointAt((CharSequence)object, n12);
                        if (n16 >= (n17 = 65536)) {
                            ++n12;
                        } else {
                            object = new zzjg(n12, n10);
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
        long l10 = (long)n11 + 0x100000000L;
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("UTF-8 length does not fit in int: ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public static int zza(CharSequence charSequence, byte[] byArray, int n10, int n11) {
        return zza.zza(charSequence, byArray, n10, n11);
    }

    public static boolean zza(byte[] byArray) {
        zzje zzje2 = zza;
        int n10 = byArray.length;
        return zzje2.zza(byArray, 0, n10);
    }

    public static boolean zza(byte[] byArray, int n10, int n11) {
        return zza.zza(byArray, n10, n11);
    }

    private static int zzb(int n10) {
        int n11 = -12;
        if (n10 > n11) {
            n10 = -1;
        }
        return n10;
    }

    private static int zzb(int n10, int n11) {
        int n12 = -12;
        if (n10 <= n12 && n11 <= (n12 = -65)) {
            return n10 ^ (n11 <<= 8);
        }
        return -1;
    }

    private static int zzb(int n10, int n11, int n12) {
        int n13 = -12;
        if (n10 <= n13 && n11 <= (n13 = -65) && n12 <= n13) {
            n11 = n12 << 16;
            return (n10 ^= (n11 <<= 8)) ^ n11;
        }
        return -1;
    }

    public static /* synthetic */ int zzb(byte[] byArray, int n10, int n11) {
        return zzjc.zzc(byArray, n10, n11);
    }

    private static int zzc(byte[] object, int n10, int n11) {
        int n12 = n10 + -1;
        n12 = object[n12];
        if ((n11 -= n10) != 0) {
            int n13 = 1;
            if (n11 != n13) {
                int n14 = 2;
                if (n11 == n14) {
                    n11 = object[n10];
                    byte by2 = object[n10 += n13];
                    return zzjc.zzb(n12, n11, (int)by2);
                }
                object = new AssertionError;
                object();
                throw object;
            }
            byte by3 = object[n10];
            return zzjc.zzb(n12, by3);
        }
        return zzjc.zzb(n12);
    }
}

