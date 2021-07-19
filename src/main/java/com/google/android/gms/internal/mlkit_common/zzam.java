/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import java.util.concurrent.Executor;

public final class zzam
extends Enum
implements Executor {
    public static final /* enum */ zzam zza;
    private static final /* synthetic */ zzam[] zzb;

    static {
        zzam zzam2;
        zza = zzam2 = new zzam("INSTANCE", 0);
        zzam[] zzamArray = new zzam[]{zzam2};
        zzb = zzamArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzam() {
        void var1_-1;
    }

    public static zzam[] values() {
        return (zzam[])zzb.clone();
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }

    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}

