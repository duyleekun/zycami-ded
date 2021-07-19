/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final class Component$$Lambda$3
implements ComponentFactory {
    private final Object arg$1;

    private Component$$Lambda$3(Object object) {
        this.arg$1 = object;
    }

    public static ComponentFactory lambdaFactory$(Object object) {
        Component$$Lambda$3 component$$Lambda$3 = new Component$$Lambda$3(object);
        return component$$Lambda$3;
    }

    public Object create(ComponentContainer componentContainer) {
        return Component.lambda$intoSet$2(this.arg$1, componentContainer);
    }
}

