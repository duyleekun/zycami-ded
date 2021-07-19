/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class RegisterListenerMethod {
    private final ListenerHolder zaju;
    private final Feature[] zajv;
    private final boolean zajw;

    public RegisterListenerMethod(ListenerHolder listenerHolder) {
        this.zaju = listenerHolder;
        this.zajv = null;
        this.zajw = false;
    }

    public RegisterListenerMethod(ListenerHolder listenerHolder, Feature[] featureArray, boolean bl2) {
        this.zaju = listenerHolder;
        this.zajv = featureArray;
        this.zajw = bl2;
    }

    public void clearListener() {
        this.zaju.clear();
    }

    public ListenerHolder$ListenerKey getListenerKey() {
        return this.zaju.getListenerKey();
    }

    public Feature[] getRequiredFeatures() {
        return this.zajv;
    }

    public abstract void registerListener(Api$AnyClient var1, TaskCompletionSource var2);

    public final boolean shouldAutoResolveMissingFeatures() {
        return this.zajw;
    }
}

