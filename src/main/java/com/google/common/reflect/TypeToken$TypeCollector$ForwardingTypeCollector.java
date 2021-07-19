/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.TypeToken$TypeCollector;

public class TypeToken$TypeCollector$ForwardingTypeCollector
extends TypeToken$TypeCollector {
    private final TypeToken$TypeCollector delegate;

    public TypeToken$TypeCollector$ForwardingTypeCollector(TypeToken$TypeCollector typeToken$TypeCollector) {
        super(null);
        this.delegate = typeToken$TypeCollector;
    }

    public Iterable getInterfaces(Object object) {
        return this.delegate.getInterfaces(object);
    }

    public Class getRawType(Object object) {
        return this.delegate.getRawType(object);
    }

    public Object getSuperclass(Object object) {
        return this.delegate.getSuperclass(object);
    }
}

