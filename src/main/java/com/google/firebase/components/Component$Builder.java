/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.Component;
import com.google.firebase.components.Component$1;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Preconditions;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Component$Builder {
    private final Set dependencies;
    private ComponentFactory factory;
    private int instantiation;
    private final Set providedInterfaces;
    private Set publishedEvents;
    private int type;

    private Component$Builder(Class clazz, Class ... classArray) {
        HashSet hashSet;
        Serializable serializable;
        this.providedInterfaces = serializable = new Serializable();
        this.dependencies = hashSet = new HashSet();
        hashSet = null;
        this.instantiation = 0;
        this.type = 0;
        Object object = new HashSet();
        this.publishedEvents = object;
        object = "Null interface";
        Preconditions.checkNotNull(clazz, (String)object);
        serializable.add(clazz);
        int n10 = classArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            serializable = classArray[i10];
            Preconditions.checkNotNull(serializable, (String)object);
        }
        Collections.addAll(this.providedInterfaces, classArray);
    }

    public /* synthetic */ Component$Builder(Class clazz, Class[] classArray, Component$1 component$1) {
        this(clazz, classArray);
    }

    public static /* synthetic */ Component$Builder access$100(Component$Builder component$Builder) {
        return component$Builder.intoSet();
    }

    private Component$Builder intoSet() {
        this.type = 1;
        return this;
    }

    private Component$Builder setInstantiation(int n10) {
        int n11 = this.instantiation;
        n11 = n11 == 0 ? 1 : 0;
        Preconditions.checkState(n11 != 0, "Instantiation type has already been set.");
        this.instantiation = n10;
        return this;
    }

    private void validateInterface(Class clazz) {
        Preconditions.checkArgument(this.providedInterfaces.contains(clazz) ^ true, "Components are not allowed to depend on interfaces they themselves provide.");
    }

    public Component$Builder add(Dependency dependency) {
        Preconditions.checkNotNull(dependency, "Null dependency");
        Class clazz = dependency.getInterface();
        this.validateInterface(clazz);
        this.dependencies.add(dependency);
        return this;
    }

    public Component$Builder alwaysEager() {
        return this.setInstantiation(1);
    }

    public Component build() {
        boolean bl2;
        Object object = this.factory;
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Preconditions.checkState(bl2, "Missing required property: factory.");
        Set set = this.providedInterfaces;
        HashSet hashSet = new HashSet(set);
        set = this.dependencies;
        HashSet hashSet2 = new HashSet(set);
        int n10 = this.instantiation;
        int n11 = this.type;
        ComponentFactory componentFactory = this.factory;
        Set set2 = this.publishedEvents;
        object = new Component(hashSet, hashSet2, n10, n11, componentFactory, set2, null);
        return object;
    }

    public Component$Builder eagerInDefaultApp() {
        return this.setInstantiation(2);
    }

    public Component$Builder factory(ComponentFactory componentFactory) {
        this.factory = componentFactory = (ComponentFactory)Preconditions.checkNotNull(componentFactory, "Null factory");
        return this;
    }

    public Component$Builder publishes(Class clazz) {
        this.publishedEvents.add(clazz);
        return this;
    }
}

