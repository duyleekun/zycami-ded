/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package com.google.android.gms.common.util;

import android.os.Looper;

public final class zzc {
    public static boolean zza() {
        Looper looper;
        Looper looper2 = Looper.getMainLooper();
        return looper2 == (looper = Looper.myLooper());
    }
}

