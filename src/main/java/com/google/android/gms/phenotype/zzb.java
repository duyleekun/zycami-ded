/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.ContentObserver
 *  android.os.Handler
 */
package com.google.android.gms.phenotype;

import android.database.ContentObserver;
import android.os.Handler;
import com.google.android.gms.phenotype.zza;

public final class zzb
extends ContentObserver {
    private final /* synthetic */ zza zzm;

    public zzb(zza zza2, Handler handler) {
        this.zzm = zza2;
        super(null);
    }

    public final void onChange(boolean bl2) {
        this.zzm.zzb();
    }
}

