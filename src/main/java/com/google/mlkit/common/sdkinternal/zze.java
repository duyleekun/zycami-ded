/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.mlkit.common.sdkinternal.CloseGuard;

public final class zze
implements Runnable {
    private final CloseGuard zza;

    public zze(CloseGuard closeGuard) {
        this.zza = closeGuard;
    }

    public final void run() {
        this.zza.zza();
    }
}

