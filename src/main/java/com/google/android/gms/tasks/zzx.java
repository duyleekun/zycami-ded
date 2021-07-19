/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.zzv;
import com.google.android.gms.tasks.zzw;
import java.util.concurrent.Executor;

public final class zzx
implements zzw {
    public static final zzw zza;

    static {
        zzx zzx2 = new zzx();
        zza = zzx2;
    }

    private zzx() {
    }

    public final Executor zza(Executor executor) {
        return zzv.zzb(executor);
    }
}

