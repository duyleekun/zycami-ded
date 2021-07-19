/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;

public class Wrappers {
    private static Wrappers zzb;
    private PackageManagerWrapper zza = null;

    static {
        Wrappers wrappers;
        zzb = wrappers = new Wrappers();
    }

    public static PackageManagerWrapper packageManager(Context context) {
        return zzb.zza(context);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final PackageManagerWrapper zza(Context object) {
        synchronized (this) {
            void var1_3;
            PackageManagerWrapper packageManagerWrapper = this.zza;
            if (packageManagerWrapper != null) return this.zza;
            packageManagerWrapper = object.getApplicationContext();
            if (packageManagerWrapper != null) {
                Context context = object.getApplicationContext();
            }
            this.zza = packageManagerWrapper = new PackageManagerWrapper((Context)var1_3);
            return this.zza;
        }
    }
}

