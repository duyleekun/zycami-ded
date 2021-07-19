/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzdg;
import com.google.android.gms.internal.vision.zzfb;

public final class zzfc
extends zzfb {
    public static int zzc(int n10, int n11, int n12) {
        Object object;
        Object[] objectArray;
        int n13;
        n12 = 1;
        int n14 = -1 >>> 2;
        if (n11 <= n14) {
            n13 = n12;
        } else {
            n13 = 0;
            objectArray = null;
        }
        if (n13 != 0) {
            return Math.min(Math.max(n10, n11), n14);
        }
        objectArray = new Object[2];
        objectArray[0] = object = Integer.valueOf(n11);
        objectArray[n12] = object = Integer.valueOf(n14);
        object = zzdg.zza("min (%s) must be less than or equal to max (%s)", objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }
}

