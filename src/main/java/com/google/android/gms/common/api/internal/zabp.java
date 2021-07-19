/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 */
package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.zaag;
import com.google.android.gms.common.api.internal.zacm;

public final class zabp
extends zaag {
    private final GoogleApi zajh;

    public zabp(GoogleApi googleApi) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.zajh = googleApi;
    }

    public final BaseImplementation$ApiMethodImpl enqueue(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        return this.zajh.doRead(baseImplementation$ApiMethodImpl);
    }

    public final BaseImplementation$ApiMethodImpl execute(BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        return this.zajh.doWrite(baseImplementation$ApiMethodImpl);
    }

    public final Context getContext() {
        return this.zajh.getApplicationContext();
    }

    public final Looper getLooper() {
        return this.zajh.getLooper();
    }

    public final void zaa(zacm zacm2) {
    }

    public final void zab(zacm zacm2) {
    }
}

