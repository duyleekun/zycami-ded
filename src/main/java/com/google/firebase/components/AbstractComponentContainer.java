/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.ComponentContainer;
import java.util.Set;

public abstract class AbstractComponentContainer
implements ComponentContainer {
    public Object get(Class object) {
        if ((object = this.getProvider((Class)object)) == null) {
            return null;
        }
        return object.get();
    }

    public Set setOf(Class clazz) {
        return (Set)this.setOfProvider(clazz).get();
    }
}

