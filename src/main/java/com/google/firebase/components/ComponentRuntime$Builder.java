/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.ComponentRuntime$Builder$$Lambda$1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;

public final class ComponentRuntime$Builder {
    private final List additionalComponents;
    private final Executor defaultExecutor;
    private final List lazyRegistrars;

    public ComponentRuntime$Builder(Executor executor) {
        ArrayList arrayList;
        this.lazyRegistrars = arrayList = new ArrayList();
        this.additionalComponents = arrayList = new ArrayList();
        this.defaultExecutor = executor;
    }

    public static /* synthetic */ ComponentRegistrar lambda$addComponentRegistrar$0(ComponentRegistrar componentRegistrar) {
        return componentRegistrar;
    }

    public ComponentRuntime$Builder addComponent(Component component) {
        this.additionalComponents.add(component);
        return this;
    }

    public ComponentRuntime$Builder addComponentRegistrar(ComponentRegistrar object) {
        List list = this.lazyRegistrars;
        object = ComponentRuntime$Builder$$Lambda$1.lambdaFactory$((ComponentRegistrar)object);
        list.add(object);
        return this;
    }

    public ComponentRuntime$Builder addLazyComponentRegistrars(Collection collection) {
        this.lazyRegistrars.addAll(collection);
        return this;
    }

    public ComponentRuntime build() {
        Executor executor = this.defaultExecutor;
        List list = this.lazyRegistrars;
        List list2 = this.additionalComponents;
        ComponentRuntime componentRuntime = new ComponentRuntime(executor, (Iterable)list, list2, null);
        return componentRuntime;
    }
}

