/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.internal.GoogleApiManager$zaa;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zabw;
import com.google.android.gms.common.api.internal.zad;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zaf
extends zad {
    private final RegisterListenerMethod zacp;
    private final UnregisterListenerMethod zacq;

    public zaf(zabw object, TaskCompletionSource object2) {
        super(3, (TaskCompletionSource)object2);
        this.zacp = object2 = ((zabw)object).zajx;
        this.zacq = object = ((zabw)object).zajy;
    }

    public final Feature[] zab(GoogleApiManager$zaa googleApiManager$zaa) {
        return this.zacp.getRequiredFeatures();
    }

    public final boolean zac(GoogleApiManager$zaa googleApiManager$zaa) {
        return this.zacp.shouldAutoResolveMissingFeatures();
    }

    public final void zad(GoogleApiManager$zaa object) {
        Object object2 = this.zacp;
        Object object3 = ((GoogleApiManager$zaa)object).zaab();
        Object object4 = this.zacn;
        ((RegisterListenerMethod)object2).registerListener((Api$AnyClient)object3, (TaskCompletionSource)object4);
        object2 = this.zacp.getListenerKey();
        if (object2 != null) {
            object = ((GoogleApiManager$zaa)object).zabk();
            object2 = this.zacp.getListenerKey();
            object4 = this.zacp;
            UnregisterListenerMethod unregisterListenerMethod = this.zacq;
            object3 = new zabw((RegisterListenerMethod)object4, unregisterListenerMethod);
            object.put(object2, object3);
        }
    }
}

