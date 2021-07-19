/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcz;
import com.google.android.gms.internal.vision.zzec;

public final class zzea {
    public static int zza(Object object, int n10) {
        boolean bl2 = object instanceof byte[];
        if (bl2) {
            return ((byte[])object)[n10] & 0xFF;
        }
        bl2 = object instanceof short[];
        if (bl2) {
            return ((short[])object)[n10] & (char)-1;
        }
        return ((int[])object)[n10];
    }

    public static int zza(Object object, Object object2, int n10, Object object3, int[] nArray, Object[] objectArray, Object[] objectArray2) {
        int n11 = zzec.zzf(object);
        int n12 = n11 & n10;
        int n13 = zzea.zza(object3, n12);
        int n14 = -1;
        if (n13 == 0) {
            return n14;
        }
        int n15 = ~n10;
        int n16 = n14;
        while (true) {
            Object object4;
            int n17;
            int n18;
            if ((n18 = (n17 = nArray[n13 += -1]) & n15) == (n11 &= n15) && (n18 = (int)(zzcz.equal(object, object4 = objectArray[n13]) ? 1 : 0)) != 0 && (objectArray2 == null || (n18 = (int)(zzcz.equal(object2, object4 = objectArray2[n13]) ? 1 : 0)) != 0)) {
                int n19 = n17 & n10;
                if (n16 == n14) {
                    zzea.zza(object3, n12, n19);
                } else {
                    int n20 = nArray[n16];
                    nArray[n16] = n19 = zzea.zzb(n20, n19, n10);
                }
                return n13;
            }
            n16 = n17 & n10;
            if (n16 == 0) {
                return n14;
            }
            int n21 = n16;
            n16 = n13;
            n13 = n21;
        }
    }

    public static void zza(Object object, int n10, int n11) {
        boolean bl2 = object instanceof byte[];
        if (bl2) {
            object = (byte[])object;
            n11 = (byte)n11;
            object[n10] = n11;
            return;
        }
        bl2 = object instanceof short[];
        if (bl2) {
            object = (short[])object;
            n11 = (short)n11;
            object[n10] = n11;
            return;
        }
        ((int[])object)[n10] = n11;
    }

    public static int zzb(int n10, int n11, int n12) {
        int n13 = ~n12;
        return (n10 &= n13) | (n11 &= n12);
    }

    public static Object zzv(int n10) {
        int n11 = 2;
        if (n10 >= n11 && n10 <= (n11 = 0x40000000) && (n11 = Integer.highestOneBit(n10)) == n10) {
            n11 = 256;
            if (n10 <= n11) {
                return new byte[n10];
            }
            n11 = 65536;
            if (n10 <= n11) {
                return new short[n10];
            }
            return new int[n10];
        }
        StringBuilder stringBuilder = new StringBuilder(52);
        stringBuilder.append("must be power of 2 between 2^1 and 2^30: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static int zzw(int n10) {
        int n11 = 32;
        n11 = n10 < n11 ? 4 : 2;
        return n11 * ++n10;
    }
}

