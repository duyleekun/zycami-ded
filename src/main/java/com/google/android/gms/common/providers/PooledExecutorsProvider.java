/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.providers;

import com.google.android.gms.common.providers.PooledExecutorsProvider$PooledExecutorFactory;
import com.google.android.gms.common.providers.zza;

public class PooledExecutorsProvider {
    private static PooledExecutorsProvider$PooledExecutorFactory zza;

    private PooledExecutorsProvider() {
    }

    public static PooledExecutorsProvider$PooledExecutorFactory getInstance() {
        Class<PooledExecutorsProvider> clazz = PooledExecutorsProvider.class;
        synchronized (clazz) {
            PooledExecutorsProvider$PooledExecutorFactory pooledExecutorsProvider$PooledExecutorFactory = zza;
            if (pooledExecutorsProvider$PooledExecutorFactory == null) {
                zza = pooledExecutorsProvider$PooledExecutorFactory = new zza();
            }
            pooledExecutorsProvider$PooledExecutorFactory = zza;
            return pooledExecutorsProvider$PooledExecutorFactory;
        }
    }
}

