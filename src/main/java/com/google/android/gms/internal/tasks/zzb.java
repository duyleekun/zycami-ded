/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.gms.internal.tasks;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.tasks.zza;

public final class zzb
extends Handler {
    private static zza zza;

    public zzb() {
    }

    public zzb(Looper looper) {
        super(looper);
    }

    public final void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }
}

