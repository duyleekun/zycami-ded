/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbr;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class zzav
implements ThreadFactory {
    private final ThreadFactory zza;

    public zzav(zzbr object) {
        this.zza = object = Executors.defaultThreadFactory();
    }

    public final Thread newThread(Runnable runnable) {
        runnable = this.zza.newThread(runnable);
        ((Thread)runnable).setName("ScionFrontendApi");
        return runnable;
    }
}

