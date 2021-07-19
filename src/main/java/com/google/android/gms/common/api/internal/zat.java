/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zas;

public final class zat
implements Runnable {
    private final /* synthetic */ zas zaeq;

    public zat(zas zas2) {
        this.zaeq = zas2;
    }

    public final void run() {
        Object object = zas.zaa(this.zaeq);
        object.lock();
        try {
            object = this.zaeq;
            zas.zab((zas)object);
            return;
        }
        finally {
            zas.zaa(this.zaeq).unlock();
        }
    }
}

