/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.reflect.ImmutableTypeToInstanceMap$1;
import com.google.common.reflect.ImmutableTypeToInstanceMap$Builder;
import com.google.common.reflect.TypeToInstanceMap;
import com.google.common.reflect.TypeToken;
import java.util.Map;

public final class ImmutableTypeToInstanceMap
extends ForwardingMap
implements TypeToInstanceMap {
    private final ImmutableMap delegate;

    private ImmutableTypeToInstanceMap(ImmutableMap immutableMap) {
        this.delegate = immutableMap;
    }

    public /* synthetic */ ImmutableTypeToInstanceMap(ImmutableMap immutableMap, ImmutableTypeToInstanceMap$1 immutableTypeToInstanceMap$1) {
        this(immutableMap);
    }

    public static ImmutableTypeToInstanceMap$Builder builder() {
        ImmutableTypeToInstanceMap$Builder immutableTypeToInstanceMap$Builder = new ImmutableTypeToInstanceMap$Builder(null);
        return immutableTypeToInstanceMap$Builder;
    }

    public static ImmutableTypeToInstanceMap of() {
        ImmutableMap immutableMap = ImmutableMap.of();
        ImmutableTypeToInstanceMap immutableTypeToInstanceMap = new ImmutableTypeToInstanceMap(immutableMap);
        return immutableTypeToInstanceMap;
    }

    private Object trustedGet(TypeToken typeToken) {
        return this.delegate.get(typeToken);
    }

    public Map delegate() {
        return this.delegate;
    }

    public Object getInstance(TypeToken typeToken) {
        typeToken = typeToken.rejectTypeVariables();
        return this.trustedGet(typeToken);
    }

    public Object getInstance(Class serializable) {
        serializable = TypeToken.of(serializable);
        return this.trustedGet((TypeToken)serializable);
    }

    public Object put(TypeToken serializable, Object object) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public void putAll(Map object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public Object putInstance(TypeToken serializable, Object object) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public Object putInstance(Class serializable, Object object) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }
}

