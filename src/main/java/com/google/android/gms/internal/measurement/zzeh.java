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
import com.google.android.gms.internal.measurement.zzei;

public final class zzeh
extends ContentObserver {
    public zzeh(Handler handler) {
        super(null);
    }

    public final void onChange(boolean bl2) {
        zzei.zzb().set(true);
    }
}

