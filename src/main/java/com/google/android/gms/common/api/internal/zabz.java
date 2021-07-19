/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.internal.RegistrationMethods$Builder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zabz
implements RemoteCall {
    private final RegistrationMethods$Builder zakg;

    public zabz(RegistrationMethods$Builder registrationMethods$Builder) {
        this.zakg = registrationMethods$Builder;
    }

    public final void accept(Object object, Object object2) {
        RegistrationMethods$Builder registrationMethods$Builder = this.zakg;
        object = (Api$AnyClient)object;
        object2 = (TaskCompletionSource)object2;
        registrationMethods$Builder.zaa((Api$AnyClient)object, (TaskCompletionSource)object2);
    }
}

