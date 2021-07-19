/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Set;

public interface ComponentContainer {
    public Object get(Class var1);

    public Deferred getDeferred(Class var1);

    public Provider getProvider(Class var1);

    public Set setOf(Class var1);

    public Provider setOfProvider(Class var1);
}

