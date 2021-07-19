/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods$Builder;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zaca
extends RegisterListenerMethod {
    private final /* synthetic */ RegistrationMethods$Builder zakh;

    public zaca(RegistrationMethods$Builder registrationMethods$Builder, ListenerHolder listenerHolder, Feature[] featureArray, boolean bl2) {
        this.zakh = registrationMethods$Builder;
        super(listenerHolder, featureArray, bl2);
    }

    public final void registerListener(Api$AnyClient api$AnyClient, TaskCompletionSource taskCompletionSource) {
        RegistrationMethods$Builder.zaa(this.zakh).accept(api$AnyClient, taskCompletionSource);
    }
}

