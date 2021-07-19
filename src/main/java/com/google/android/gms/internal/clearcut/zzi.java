/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.clearcut.zzf;
import com.google.android.gms.internal.clearcut.zzg;
import com.google.android.gms.internal.clearcut.zzh;

public final class zzi
extends zzg {
    private final /* synthetic */ zzh zzap;

    public zzi(zzh zzh2) {
        this.zzap = zzh2;
        super((zzf)null);
    }

    public final void zza(Status status) {
        this.zzap.setResult(status);
    }
}

