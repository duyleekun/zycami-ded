/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.zza;

public class CancellationTokenSource {
    private final zza zza;

    public CancellationTokenSource() {
        zza zza2;
        this.zza = zza2 = new zza();
    }

    public void cancel() {
        this.zza.zza();
    }

    public CancellationToken getToken() {
        return this.zza;
    }
}

