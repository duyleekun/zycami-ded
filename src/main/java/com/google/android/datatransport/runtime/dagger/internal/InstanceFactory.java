/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

public final class InstanceFactory
implements Factory,
Lazy {
    private static final InstanceFactory NULL_INSTANCE_FACTORY;
    private final Object instance;

    static {
        InstanceFactory instanceFactory;
        NULL_INSTANCE_FACTORY = instanceFactory = new InstanceFactory(null);
    }

    private InstanceFactory(Object object) {
        this.instance = object;
    }

    public static Factory create(Object object) {
        object = Preconditions.checkNotNull(object, "instance cannot be null");
        InstanceFactory instanceFactory = new InstanceFactory(object);
        return instanceFactory;
    }

    public static Factory createNullable(Object object) {
        if (object == null) {
            object = InstanceFactory.nullInstanceFactory();
        } else {
            InstanceFactory instanceFactory = new InstanceFactory(object);
            object = instanceFactory;
        }
        return object;
    }

    private static InstanceFactory nullInstanceFactory() {
        return NULL_INSTANCE_FACTORY;
    }

    public Object get() {
        return this.instance;
    }
}

