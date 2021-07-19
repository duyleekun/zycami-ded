/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Looper;

public final class zzz {
    public zzz(Context context) {
    }

    public static final boolean zza() {
        Looper looper;
        Looper looper2 = Looper.myLooper();
        return looper2 == (looper = Looper.getMainLooper());
    }
}

