/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.internal.mlkit_common.zzav$zzaj$zza;
import com.google.android.gms.internal.mlkit_common.zzds;
import com.google.mlkit.common.sdkinternal.Cleaner;
import com.google.mlkit.common.sdkinternal.CloseGuard;

public class CloseGuard$Factory {
    private final Cleaner zza;
    private final zzds zzb;

    public CloseGuard$Factory(Cleaner cleaner, zzds zzds2) {
        this.zza = cleaner;
        this.zzb = zzds2;
    }

    public CloseGuard create(Object object, int n10, Runnable runnable) {
        zzav$zzaj$zza zzav$zzaj$zza = zzav$zzaj$zza.zza(n10);
        Cleaner cleaner = this.zza;
        zzds zzds2 = this.zzb;
        CloseGuard closeGuard = new CloseGuard(object, zzav$zzaj$zza, cleaner, zzds2, runnable);
        return closeGuard;
    }
}

