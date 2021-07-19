/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.crashlytics.CrashlyticsRegistrar;

public final class CrashlyticsRegistrar$$Lambda$1
implements ComponentFactory {
    private final CrashlyticsRegistrar arg$1;

    private CrashlyticsRegistrar$$Lambda$1(CrashlyticsRegistrar crashlyticsRegistrar) {
        this.arg$1 = crashlyticsRegistrar;
    }

    public static ComponentFactory lambdaFactory$(CrashlyticsRegistrar crashlyticsRegistrar) {
        CrashlyticsRegistrar$$Lambda$1 crashlyticsRegistrar$$Lambda$1 = new CrashlyticsRegistrar$$Lambda$1(crashlyticsRegistrar);
        return crashlyticsRegistrar$$Lambda$1;
    }

    public Object create(ComponentContainer componentContainer) {
        return CrashlyticsRegistrar.access$lambda$0(this.arg$1, componentContainer);
    }
}

