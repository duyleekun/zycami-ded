/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzfu;
import com.google.android.gms.internal.clearcut.zzfw;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzfy {
    private static final Charset ISO_8859_1;
    private static final Charset UTF_8;
    public static final Object zzrr;

    static {
        Object object;
        UTF_8 = Charset.forName("UTF-8");
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        zzrr = object = new Object();
    }

    public static boolean equals(int[] nArray, int[] nArray2) {
        int n10;
        int n11;
        if (nArray != null && (n11 = nArray.length) != 0) {
            return Arrays.equals(nArray, nArray2);
        }
        return nArray2 == null || (n10 = nArray2.length) == 0;
        {
        }
    }

    public static boolean equals(long[] lArray, long[] lArray2) {
        int n10;
        int n11;
        if (lArray != null && (n11 = lArray.length) != 0) {
            return Arrays.equals(lArray, lArray2);
        }
        return lArray2 == null || (n10 = lArray2.length) == 0;
        {
        }
    }

    public static boolean equals(Object[] objectArray, Object[] objectArray2) {
        int n10 = objectArray == null ? 0 : objectArray.length;
        int n11 = objectArray2 == null ? 0 : objectArray2.length;
        int n12 = 0;
        int n13 = 0;
        while (true) {
            Object object;
            boolean bl2;
            Object object2;
            if (n12 < n10 && (object2 = objectArray[n12]) == null) {
                ++n12;
                continue;
            }
            while (n13 < n11 && (object2 = objectArray2[n13]) == null) {
                ++n13;
            }
            boolean bl3 = true;
            if (n12 >= n10) {
                bl2 = bl3;
            } else {
                bl2 = false;
                object = null;
            }
            boolean bl4 = n13 >= n11 ? bl3 : false;
            if (bl2 && bl4) {
                return bl3;
            }
            if (bl2 != bl4) {
                return false;
            }
            object2 = objectArray[n12];
            object = objectArray2[n13];
            bl3 = object2.equals(object);
            if (!bl3) {
                return false;
            }
            ++n12;
            ++n13;
        }
    }

    public static int hashCode(int[] nArray) {
        int n10;
        if (nArray != null && (n10 = nArray.length) != 0) {
            return Arrays.hashCode(nArray);
        }
        return 0;
    }

    public static int hashCode(long[] lArray) {
        int n10;
        if (lArray != null && (n10 = lArray.length) != 0) {
            return Arrays.hashCode(lArray);
        }
        return 0;
    }

    public static int hashCode(Object[] objectArray) {
        int n10 = objectArray == null ? 0 : objectArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            if (object == null) continue;
            n11 *= 31;
            int n12 = object.hashCode();
            n11 += n12;
        }
        return n11;
    }

    public static int zza(byte[][] byArray) {
        int n10 = byArray == null ? 0 : byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte[] byArray2 = byArray[i10];
            if (byArray2 == null) continue;
            n11 *= 31;
            int n12 = Arrays.hashCode(byArray2);
            n11 += n12;
        }
        return n11;
    }

    public static void zza(zzfu object, zzfu zzfu2) {
        object = ((zzfu)object).zzrj;
        if (object != null) {
            zzfu2.zzrj = object = (zzfw)((zzfw)object).clone();
        }
    }

    public static boolean zza(byte[][] byArray, byte[][] byArray2) {
        int n10 = byArray == null ? 0 : byArray.length;
        int n11 = byArray2 == null ? 0 : byArray2.length;
        int n12 = 0;
        int n13 = 0;
        while (true) {
            byte[] byArray3;
            boolean bl2;
            byte[] byArray4;
            if (n12 < n10 && (byArray4 = byArray[n12]) == null) {
                ++n12;
                continue;
            }
            while (n13 < n11 && (byArray4 = byArray2[n13]) == null) {
                ++n13;
            }
            boolean bl3 = true;
            if (n12 >= n10) {
                bl2 = bl3;
            } else {
                bl2 = false;
                byArray3 = null;
            }
            boolean bl4 = n13 >= n11 ? bl3 : false;
            if (bl2 && bl4) {
                return bl3;
            }
            if (bl2 != bl4) {
                return false;
            }
            byArray4 = byArray[n12];
            byArray3 = byArray2[n13];
            bl3 = Arrays.equals(byArray4, byArray3);
            if (!bl3) {
                return false;
            }
            ++n12;
            ++n13;
        }
    }
}

