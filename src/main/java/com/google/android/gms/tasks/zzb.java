/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.zza;

public final class zzb
implements OnSuccessListener {
    private final /* synthetic */ OnTokenCanceledListener zza;

    public zzb(zza zza2, OnTokenCanceledListener onTokenCanceledListener) {
        this.zza = onTokenCanceledListener;
    }

    public final /* synthetic */ void onSuccess(Object object) {
        object = (Void)object;
        this.zza.onCanceled();
    }
}

