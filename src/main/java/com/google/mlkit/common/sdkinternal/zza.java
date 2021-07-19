/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import java.util.concurrent.ThreadFactory;

public final class zza
implements ThreadFactory {
    public static final ThreadFactory zza;

    static {
        zza zza2 = new zza();
        zza = zza2;
    }

    private zza() {
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "MlKitCleaner");
        thread.setDaemon(true);
        return thread;
    }
}

