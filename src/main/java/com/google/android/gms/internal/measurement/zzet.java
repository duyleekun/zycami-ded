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
import com.google.android.gms.internal.measurement.zzeu;
import com.google.android.gms.internal.measurement.zzfg;

public final class zzet
extends ContentObserver {
    public zzet(zzeu zzeu2, Handler handler) {
        super(null);
    }

    public final void onChange(boolean bl2) {
        zzfg.zzc();
    }
}

