/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class UnregisterListenerMethod {
    private final ListenerHolder$ListenerKey zajl;

    public UnregisterListenerMethod(ListenerHolder$ListenerKey listenerHolder$ListenerKey) {
        this.zajl = listenerHolder$ListenerKey;
    }

    public ListenerHolder$ListenerKey getListenerKey() {
        return this.zajl;
    }

    public abstract void unregisterListener(Api$AnyClient var1, TaskCompletionSource var2);
}

