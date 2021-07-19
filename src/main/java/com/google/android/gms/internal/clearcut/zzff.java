/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzfd;
import com.google.android.gms.internal.clearcut.zzfg;
import com.google.android.gms.internal.clearcut.zzfh;
import com.google.android.gms.internal.clearcut.zzfi;
import com.google.android.gms.internal.clearcut.zzfj;
import java.nio.ByteBuffer;

public final class zzff {
    private static final zzfg zzqb;

    static {
        zzfg zzfg2;
        boolean bl2 = zzfd.zzed();
        if (bl2 && (bl2 = zzfd.zzee())) {
            bl2 = true;
        } else {
            bl2 = false;
            zzfg2 = null;
        }
        zzfg2 = bl2 ? new zzfj() : new zzfh();
        zzqb = zzfg2;
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
                            object = new zzfi(n12, n10);
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
        return zzqb.zzb(charSequence, byArray, n10, n11);
    }

    public static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        zzfg zzfg2 = zzqb;
        boolean bl2 = byteBuffer.hasArray();
        if (bl2) {
            int n10 = byteBuffer.arrayOffset();
            byte[] byArray = byteBuffer.array();
            int n11 = byteBuffer.position() + n10;
            int n12 = byteBuffer.remaining();
            int n13 = zzff.zza(charSequence, byArray, n11, n12) - n10;
            byteBuffer.position(n13);
            return;
        }
        bl2 = byteBuffer.isDirect();
        if (bl2) {
            zzfg2.zzb(charSequence, byteBuffer);
            return;
        }
        zzfg.zzc(charSequence, byteBuffer);
    }

    private static int zzam(int n10) {
        int n11 = -12;
        if (n10 > n11) {
            n10 = -1;
        }
        return n10;
    }

    public static /* synthetic */ int zzan(int n10) {
        return zzff.zzam(n10);
    }

    private static int zzd(int n10, int n11, int n12) {
        int n13 = -12;
        if (n10 <= n13 && n11 <= (n13 = -65) && n12 <= n13) {
            n11 = n12 << 16;
            return (n10 ^= (n11 <<= 8)) ^ n11;
        }
        return -1;
    }

    public static /* synthetic */ int zze(int n10, int n11, int n12) {
        return zzff.zzd(n10, n11, n12);
    }

    public static boolean zze(byte[] byArray) {
        zzfg zzfg2 = zzqb;
        int n10 = byArray.length;
        return zzfg2.zze(byArray, 0, n10);
    }

    public static boolean zze(byte[] byArray, int n10, int n11) {
        return zzqb.zze(byArray, n10, n11);
    }

    private static int zzf(byte[] object, int n10, int n11) {
        int n12 = n10 + -1;
        n12 = object[n12];
        if ((n11 -= n10) != 0) {
            int n13 = 1;
            if (n11 != n13) {
                int n14 = 2;
                if (n11 == n14) {
                    n11 = object[n10];
                    byte by2 = object[n10 += n13];
                    return zzff.zzd(n12, n11, by2);
                }
                object = new AssertionError;
                object();
                throw object;
            }
            byte by3 = object[n10];
            return zzff.zzp(n12, by3);
        }
        return zzff.zzam(n12);
    }

    public static /* synthetic */ int zzg(byte[] byArray, int n10, int n11) {
        return zzff.zzf(byArray, n10, n11);
    }

    private static int zzp(int n10, int n11) {
        int n12 = -12;
        if (n10 <= n12 && n11 <= (n12 = -65)) {
            return n10 ^ (n11 <<= 8);
        }
        return -1;
    }

    public static /* synthetic */ int zzq(int n10, int n11) {
        return zzff.zzp(n10, n11);
    }
}

