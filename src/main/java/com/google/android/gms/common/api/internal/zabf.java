/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zabd;
import com.google.android.gms.common.api.internal.zabe;

public abstract class zabf {
    private final zabd zahu;

    public zabf(zabd zabd2) {
        this.zahu = zabd2;
    }

    public abstract void zaan();

    public final void zac(zabe zabe2) {
        block5: {
            Object object = zabe.zaa(zabe2);
            object.lock();
            object = zabe.zab(zabe2);
            zabd zabd2 = this.zahu;
            if (object == zabd2) break block5;
            zabe.zaa(zabe2).unlock();
            return;
        }
        try {
            this.zaan();
            return;
        }
        finally {
            zabe.zaa(zabe2).unlock();
        }
    }
}

