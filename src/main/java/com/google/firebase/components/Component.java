/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.Component$$Lambda$1;
import com.google.firebase.components.Component$$Lambda$2;
import com.google.firebase.components.Component$$Lambda$3;
import com.google.firebase.components.Component$1;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

public final class Component {
    private final Set dependencies;
    private final ComponentFactory factory;
    private final int instantiation;
    private final Set providedInterfaces;
    private final Set publishedEvents;
    private final int type;

    private Component(Set set, Set set2, int n10, int n11, ComponentFactory componentFactory, Set set3) {
        this.providedInterfaces = set = Collections.unmodifiableSet(set);
        this.dependencies = set = Collections.unmodifiableSet(set2);
        this.instantiation = n10;
        this.type = n11;
        this.factory = componentFactory;
        this.publishedEvents = set = Collections.unmodifiableSet(set3);
    }

    public /* synthetic */ Component(Set set, Set set2, int n10, int n11, ComponentFactory componentFactory, Set set3, Component$1 component$1) {
        this(set, set2, n10, n11, componentFactory, set3);
    }

    public static Component$Builder builder(Class clazz) {
        Class[] classArray = new Class[]{};
        Component$Builder component$Builder = new Component$Builder(clazz, classArray, null);
        return component$Builder;
    }

    public static Component$Builder builder(Class clazz, Class ... classArray) {
        Component$Builder component$Builder = new Component$Builder(clazz, classArray, null);
        return component$Builder;
    }

    public static Component intoSet(Object object, Class object2) {
        object2 = Component.intoSetBuilder((Class)object2);
        object = Component$$Lambda$3.lambdaFactory$(object);
        return ((Component$Builder)object2).factory((ComponentFactory)object).build();
    }

    public static Component$Builder intoSetBuilder(Class clazz) {
        return Component$Builder.access$100(Component.builder(clazz));
    }

    public static /* synthetic */ Object lambda$intoSet$2(Object object, ComponentContainer componentContainer) {
        return object;
    }

    public static /* synthetic */ Object lambda$of$0(Object object, ComponentContainer componentContainer) {
        return object;
    }

    public static /* synthetic */ Object lambda$of$1(Object object, ComponentContainer componentContainer) {
        return object;
    }

    public static Component of(Class object, Object object2) {
        object = Component.builder((Class)object);
        object2 = Component$$Lambda$1.lambdaFactory$(object2);
        return ((Component$Builder)object).factory((ComponentFactory)object2).build();
    }

    public static Component of(Object object, Class object2, Class ... classArray) {
        object2 = Component.builder((Class)object2, classArray);
        object = Component$$Lambda$2.lambdaFactory$(object);
        return ((Component$Builder)object2).factory((ComponentFactory)object).build();
    }

    public Set getDependencies() {
        return this.dependencies;
    }

    public ComponentFactory getFactory() {
        return this.factory;
    }

    public Set getProvidedInterfaces() {
        return this.providedInterfaces;
    }

    public Set getPublishedEvents() {
        return this.publishedEvents;
    }

    public boolean isAlwaysEager() {
        int n10 = this.instantiation;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isEagerInDefaultApp() {
        int n10 = this.instantiation;
        int n11 = 2;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isLazy() {
        int n10 = this.instantiation;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isValue() {
        int n10 = this.type;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Component<");
        String string2 = Arrays.toString(this.providedInterfaces.toArray());
        stringBuilder.append(string2);
        stringBuilder.append(">{");
        int n10 = this.instantiation;
        stringBuilder.append(n10);
        stringBuilder.append(", type=");
        n10 = this.type;
        stringBuilder.append(n10);
        stringBuilder.append(", deps=");
        string2 = Arrays.toString(this.dependencies.toArray());
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

