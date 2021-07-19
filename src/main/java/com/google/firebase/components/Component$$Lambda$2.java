/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final class Component$$Lambda$2
implements ComponentFactory {
    private final Object arg$1;

    private Component$$Lambda$2(Object object) {
        this.arg$1 = object;
    }

    public static ComponentFactory lambdaFactory$(Object object) {
        Component$$Lambda$2 component$$Lambda$2 = new Component$$Lambda$2(object);
        return component$$Lambda$2;
    }

    public Object create(ComponentContainer componentContainer) {
        return Component.lambda$of$1(this.arg$1, componentContainer);
    }
}

