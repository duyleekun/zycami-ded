/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Process
 */
package com.google.android.gms.common.util.concurrent;

import android.os.Process;

public final class zza
implements Runnable {
    private final Runnable zza;
    private final int zzb;

    public zza(Runnable runnable, int n10) {
        this.zza = runnable;
        this.zzb = n10;
    }

    public final void run() {
        Process.setThreadPriority((int)this.zzb);
        this.zza.run();
    }
}

