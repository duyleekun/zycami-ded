/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.internal.GoogleApiManager$zaa;
import com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zabw;
import com.google.android.gms.common.api.internal.zad;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zah
extends zad {
    private final ListenerHolder$ListenerKey zact;

    public zah(ListenerHolder$ListenerKey listenerHolder$ListenerKey, TaskCompletionSource taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zact = listenerHolder$ListenerKey;
    }

    public final Feature[] zab(GoogleApiManager$zaa object) {
        object = ((GoogleApiManager$zaa)object).zabk();
        ListenerHolder$ListenerKey listenerHolder$ListenerKey = this.zact;
        if ((object = (zabw)object.get(listenerHolder$ListenerKey)) == null) {
            return null;
        }
        return ((zabw)object).zajx.getRequiredFeatures();
    }

    public final boolean zac(GoogleApiManager$zaa object) {
        boolean bl2;
        object = ((GoogleApiManager$zaa)object).zabk();
        ListenerHolder$ListenerKey listenerHolder$ListenerKey = this.zact;
        return (object = (zabw)object.get(listenerHolder$ListenerKey)) != null && (bl2 = ((RegisterListenerMethod)(object = ((zabw)object).zajx)).shouldAutoResolveMissingFeatures());
    }

    public final void zad(GoogleApiManager$zaa object) {
        Object object2 = ((GoogleApiManager$zaa)object).zabk();
        Object object3 = this.zact;
        if ((object2 = (zabw)object2.remove(object3)) != null) {
            object3 = ((zabw)object2).zajy;
            object = ((GoogleApiManager$zaa)object).zaab();
            TaskCompletionSource taskCompletionSource = this.zacn;
            ((UnregisterListenerMethod)object3).unregisterListener((Api$AnyClient)object, taskCompletionSource);
            ((zabw)object2).zajx.clearListener();
            return;
        }
        object = this.zacn;
        object2 = Boolean.FALSE;
        ((TaskCompletionSource)object).trySetResult(object2);
    }
}

