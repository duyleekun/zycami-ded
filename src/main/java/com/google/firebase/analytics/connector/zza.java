/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.analytics.connector;

import java.util.concurrent.Executor;

public final class zza
implements Executor {
    public static final Executor zza;

    static {
        zza zza2 = new zza();
        zza = zza2;
    }

    private zza() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}

