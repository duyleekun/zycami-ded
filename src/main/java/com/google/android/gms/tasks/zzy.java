/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.zzu;
import java.util.concurrent.Callable;

public final class zzy
implements Runnable {
    private final /* synthetic */ zzu zza;
    private final /* synthetic */ Callable zzb;

    public zzy(zzu zzu2, Callable callable) {
        this.zza = zzu2;
        this.zzb = callable;
    }

    public final void run() {
        zzu zzu2;
        try {
            zzu2 = this.zza;
        }
        catch (Exception exception) {
            this.zza.zza(exception);
            return;
        }
        Callable callable = this.zzb;
        callable = callable.call();
        zzu2.zza(callable);
    }
}

