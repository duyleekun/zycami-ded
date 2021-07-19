/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.common;

import com.google.android.gms.internal.common.zzf;
import com.google.android.gms.internal.common.zzh;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class zzg
implements zzf {
    private zzg() {
    }

    public /* synthetic */ zzg(zzh zzh2) {
        this();
    }

    public final ScheduledExecutorService zza(int n10, int n11) {
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }
}

