/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.concurrent.Callable;

public final class zzcs
implements Callable {
    private final SharedPrefManager zza;

    private zzcs(SharedPrefManager sharedPrefManager) {
        this.zza = sharedPrefManager;
    }

    public static Callable zza(SharedPrefManager sharedPrefManager) {
        zzcs zzcs2 = new zzcs(sharedPrefManager);
        return zzcs2;
    }

    public final Object call() {
        return this.zza.getMlSdkInstanceId();
    }
}

