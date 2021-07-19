/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;

public final class FirebaseInstallationsRegistrar$$Lambda$1
implements ComponentFactory {
    private static final FirebaseInstallationsRegistrar$$Lambda$1 instance;

    static {
        FirebaseInstallationsRegistrar$$Lambda$1 firebaseInstallationsRegistrar$$Lambda$1;
        instance = firebaseInstallationsRegistrar$$Lambda$1 = new FirebaseInstallationsRegistrar$$Lambda$1();
    }

    private FirebaseInstallationsRegistrar$$Lambda$1() {
    }

    public static ComponentFactory lambdaFactory$() {
        return instance;
    }

    public Object create(ComponentContainer componentContainer) {
        return FirebaseInstallationsRegistrar.lambda$getComponents$0(componentContainer);
    }
}

