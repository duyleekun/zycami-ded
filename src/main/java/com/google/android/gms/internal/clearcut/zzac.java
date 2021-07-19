/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.ContentObserver
 *  android.os.Handler
 */
package com.google.android.gms.internal.clearcut;

import android.database.ContentObserver;
import android.os.Handler;
import com.google.android.gms.internal.clearcut.zzab;

public final class zzac
extends ContentObserver {
    private final /* synthetic */ zzab zzdm;

    public zzac(zzab zzab2, Handler handler) {
        this.zzdm = zzab2;
        super(null);
    }

    public final void onChange(boolean bl2) {
        this.zzdm.zzh();
        zzab.zza(this.zzdm);
    }
}

