/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final class Component$$Lambda$1
implements ComponentFactory {
    private final Object arg$1;

    private Component$$Lambda$1(Object object) {
        this.arg$1 = object;
    }

    public static ComponentFactory lambdaFactory$(Object object) {
        Component$$Lambda$1 component$$Lambda$1 = new Component$$Lambda$1(object);
        return component$$Lambda$1;
    }

    public Object create(ComponentContainer componentContainer) {
        return Component.lambda$of$0(this.arg$1, componentContainer);
    }
}

