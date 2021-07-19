/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.ContentObserver
 *  android.os.Handler
 */
package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import com.google.android.gms.internal.measurement.zzen;

public final class zzem
extends ContentObserver {
    public final /* synthetic */ zzen zza;

    public zzem(zzen zzen2, Handler handler) {
        this.zza = zzen2;
        super(null);
    }

    public final void onChange(boolean bl2) {
        this.zza.zzc();
    }
}

