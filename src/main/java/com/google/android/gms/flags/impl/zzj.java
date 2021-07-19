/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 */
package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.flags.impl.zzk;
import com.google.android.gms.internal.flags.zze;
import java.util.concurrent.Callable;

public final class zzj {
    private static SharedPreferences zzw;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static SharedPreferences zza(Context object) {
        Class<SharedPreferences> clazz = SharedPreferences.class;
        synchronized (clazz) {
            Object object2 = zzw;
            if (object2 != null) return zzw;
            object2 = new zzk((Context)object);
            object = zze.zza((Callable)object2);
            object = (SharedPreferences)object;
            zzw = object;
            return zzw;
        }
    }
}

