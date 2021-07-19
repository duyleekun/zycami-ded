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
import com.google.android.gms.internal.vision.zzaq;

public final class zzat
extends ContentObserver {
    public zzat(Handler handler) {
        super(null);
    }

    public final void onChange(boolean bl2) {
        zzaq.zzt().set(true);
    }
}

