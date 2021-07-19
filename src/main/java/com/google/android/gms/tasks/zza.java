/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzb;
import com.google.android.gms.tasks.zzu;

public final class zza
extends CancellationToken {
    private final zzu zza;

    public zza() {
        zzu zzu2;
        this.zza = zzu2 = new zzu();
    }

    public final boolean isCancellationRequested() {
        return ((Task)this.zza).isComplete();
    }

    public final CancellationToken onCanceledRequested(OnTokenCanceledListener onTokenCanceledListener) {
        zzu zzu2 = this.zza;
        zzb zzb2 = new zzb(this, onTokenCanceledListener);
        ((Task)zzu2).addOnSuccessListener(zzb2);
        return this;
    }

    public final void zza() {
        this.zza.zzb((Object)null);
    }
}

