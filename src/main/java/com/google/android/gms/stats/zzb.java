/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.stats;

import com.google.android.gms.stats.WakeLock;

public final class zzb
implements Runnable {
    private final /* synthetic */ WakeLock zzp;

    public zzb(WakeLock wakeLock) {
        this.zzp = wakeLock;
    }

    public final void run() {
        WakeLock.zza(this.zzp, 0);
    }
}

