/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods$Builder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zabx;

public class RegistrationMethods {
    public final RegisterListenerMethod zajz;
    public final UnregisterListenerMethod zaka;

    private RegistrationMethods(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod) {
        this.zajz = registerListenerMethod;
        this.zaka = unregisterListenerMethod;
    }

    public /* synthetic */ RegistrationMethods(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, zabx zabx2) {
        this(registerListenerMethod, unregisterListenerMethod);
    }

    public static RegistrationMethods$Builder builder() {
        RegistrationMethods$Builder registrationMethods$Builder = new RegistrationMethods$Builder(null);
        return registrationMethods$Builder;
    }
}

