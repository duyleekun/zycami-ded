/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableClassToInstanceMap$1;
import com.google.common.collect.ImmutableClassToInstanceMap$Builder;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Map;

public final class ImmutableClassToInstanceMap
extends ForwardingMap
implements ClassToInstanceMap,
Serializable {
    private static final ImmutableClassToInstanceMap EMPTY;
    private final ImmutableMap delegate;

    static {
        ImmutableClassToInstanceMap immutableClassToInstanceMap;
        ImmutableMap immutableMap = ImmutableMap.of();
        EMPTY = immutableClassToInstanceMap = new ImmutableClassToInstanceMap(immutableMap);
    }

    private ImmutableClassToInstanceMap(ImmutableMap immutableMap) {
        this.delegate = immutableMap;
    }

    public /* synthetic */ ImmutableClassToInstanceMap(ImmutableMap immutableMap, ImmutableClassToInstanceMap$1 immutableClassToInstanceMap$1) {
        this(immutableMap);
    }

    public static ImmutableClassToInstanceMap$Builder builder() {
        ImmutableClassToInstanceMap$Builder immutableClassToInstanceMap$Builder = new ImmutableClassToInstanceMap$Builder();
        return immutableClassToInstanceMap$Builder;
    }

    public static ImmutableClassToInstanceMap copyOf(Map map) {
        boolean bl2 = map instanceof ImmutableClassToInstanceMap;
        if (bl2) {
            return (ImmutableClassToInstanceMap)map;
        }
        ImmutableClassToInstanceMap$Builder immutableClassToInstanceMap$Builder = new ImmutableClassToInstanceMap$Builder();
        return immutableClassToInstanceMap$Builder.putAll(map).build();
    }

    public static ImmutableClassToInstanceMap of() {
        return EMPTY;
    }

    public static ImmutableClassToInstanceMap of(Class serializable, Object object) {
        serializable = ImmutableMap.of(serializable, object);
        object = new ImmutableClassToInstanceMap((ImmutableMap)serializable);
        return object;
    }

    public Map delegate() {
        return this.delegate;
    }

    public Object getInstance(Class object) {
        ImmutableMap immutableMap = this.delegate;
        object = Preconditions.checkNotNull(object);
        return immutableMap.get(object);
    }

    public Object putInstance(Class serializable, Object object) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public Object readResolve() {
        boolean bl2 = this.isEmpty();
        ImmutableClassToInstanceMap immutableClassToInstanceMap = bl2 ? ImmutableClassToInstanceMap.of() : this;
        return immutableClassToInstanceMap;
    }
}

