/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.providers;

import com.google.android.gms.common.providers.PooledExecutorsProvider$PooledExecutorFactory;
import com.google.android.gms.internal.common.zze;
import com.google.android.gms.internal.common.zzf;
import com.google.android.gms.internal.common.zzj;
import java.util.concurrent.ScheduledExecutorService;

public final class zza
implements PooledExecutorsProvider$PooledExecutorFactory {
    public final ScheduledExecutorService newSingleThreadScheduledExecutor() {
        zzf zzf2 = zze.zza();
        int n10 = zzj.zza;
        return zzf2.zza(1, n10);
    }
}

