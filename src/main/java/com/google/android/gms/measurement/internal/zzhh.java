/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzhn;

public final class zzhh
implements Runnable {
    public final /* synthetic */ Boolean zza;
    public final /* synthetic */ zzhn zzb;

    public zzhh(zzhn zzhn2, Boolean bl2) {
        this.zzb = zzhn2;
        this.zza = bl2;
    }

    public final void run() {
        zzhn zzhn2 = this.zzb;
        Boolean bl2 = this.zza;
        zzhn.zzV(zzhn2, bl2, true);
    }
}

