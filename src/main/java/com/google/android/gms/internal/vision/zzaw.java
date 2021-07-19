/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.ContentObserver
 *  android.os.Handler
 */
package com.google.android.gms.internal.vision;

import android.database.ContentObserver;
import android.os.Handler;
import com.google.android.gms.internal.vision.zzau;

public final class zzaw
extends ContentObserver {
    private final /* synthetic */ zzau zzfx;

    public zzaw(zzau zzau2, Handler handler) {
        this.zzfx = zzau2;
        super(null);
    }

    public final void onChange(boolean bl2) {
        this.zzfx.zzw();
    }
}

