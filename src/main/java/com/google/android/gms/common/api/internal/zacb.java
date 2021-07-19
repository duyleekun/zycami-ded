/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey;
import com.google.android.gms.common.api.internal.RegistrationMethods$Builder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zacb
extends UnregisterListenerMethod {
    private final /* synthetic */ RegistrationMethods$Builder zakh;

    public zacb(RegistrationMethods$Builder registrationMethods$Builder, ListenerHolder$ListenerKey listenerHolder$ListenerKey) {
        this.zakh = registrationMethods$Builder;
        super(listenerHolder$ListenerKey);
    }

    public final void unregisterListener(Api$AnyClient api$AnyClient, TaskCompletionSource taskCompletionSource) {
        RegistrationMethods$Builder.zab(this.zakh).accept(api$AnyClient, taskCompletionSource);
    }
}

