/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.concurrent.Callable;

public final class zzen
implements Callable {
    private final SharedPrefManager zza;

    private zzen(SharedPrefManager sharedPrefManager) {
        this.zza = sharedPrefManager;
    }

    public static Callable zza(SharedPrefManager sharedPrefManager) {
        zzen zzen2 = new zzen(sharedPrefManager);
        return zzen2;
    }

    public final Object call() {
        return this.zza.getMlSdkInstanceId();
    }
}

