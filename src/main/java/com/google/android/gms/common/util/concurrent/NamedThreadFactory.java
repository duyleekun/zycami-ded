/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.zza;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory
implements ThreadFactory {
    private final String zza;
    private final int zzb;
    private final ThreadFactory zzc;

    public NamedThreadFactory(String string2) {
        this(string2, 0);
    }

    private NamedThreadFactory(String string2, int n10) {
        ThreadFactory threadFactory;
        this.zzc = threadFactory = Executors.defaultThreadFactory();
        this.zza = string2 = (String)Preconditions.checkNotNull(string2, "Name must not be null");
        this.zzb = 0;
    }

    public Thread newThread(Runnable runnable) {
        Object object = this.zzc;
        zza zza2 = new zza(runnable, 0);
        runnable = object.newThread(zza2);
        object = this.zza;
        ((Thread)runnable).setName((String)object);
        return runnable;
    }
}

