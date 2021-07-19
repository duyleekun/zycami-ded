/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final class zzf
implements Continuation {
    public static final Continuation zza;

    static {
        zzf zzf2 = new zzf();
        zza = zzf2;
    }

    private zzf() {
    }

    public final Object then(Task task) {
        return task.getResult();
    }
}

