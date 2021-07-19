/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.google.android.gms.internal.measurement;

import android.os.Build;

public final class zzej {
    private static volatile boolean zza = zzej.zza() ^ true;

    public static boolean zza() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        return n10 >= n11;
    }
}

