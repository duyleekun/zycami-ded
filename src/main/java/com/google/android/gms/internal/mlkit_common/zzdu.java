/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.concurrent.Callable;

public final class zzdu
implements Callable {
    private final SharedPrefManager zza;

    private zzdu(SharedPrefManager sharedPrefManager) {
        this.zza = sharedPrefManager;
    }

    public static Callable zza(SharedPrefManager sharedPrefManager) {
        zzdu zzdu2 = new zzdu(sharedPrefManager);
        return zzdu2;
    }

    public final Object call() {
        return this.zza.getMlSdkInstanceId();
    }
}

