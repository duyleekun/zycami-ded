/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.TaskExecutors$zza;
import com.google.android.gms.tasks.zzt;
import java.util.concurrent.Executor;

public final class TaskExecutors {
    public static final Executor MAIN_THREAD;
    public static final Executor zza;

    static {
        Executor executor = new TaskExecutors$zza();
        MAIN_THREAD = executor;
        executor = new zzt();
        zza = executor;
    }

    private TaskExecutors() {
    }
}

