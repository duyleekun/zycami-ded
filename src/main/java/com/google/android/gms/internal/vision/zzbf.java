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
import com.google.android.gms.internal.vision.zzbd;
import com.google.android.gms.internal.vision.zzbi;

public final class zzbf
extends ContentObserver {
    public zzbf(zzbd zzbd2, Handler handler) {
        super(null);
    }

    public final void onChange(boolean bl2) {
        zzbi.zzaf();
    }
}

