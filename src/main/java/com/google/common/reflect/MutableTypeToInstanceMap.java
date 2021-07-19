/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Maps;
import com.google.common.reflect.MutableTypeToInstanceMap$UnmodifiableEntry;
import com.google.common.reflect.TypeToInstanceMap;
import com.google.common.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class MutableTypeToInstanceMap
extends ForwardingMap
implements TypeToInstanceMap {
    private final Map backingMap;

    public MutableTypeToInstanceMap() {
        HashMap hashMap = Maps.newHashMap();
        this.backingMap = hashMap;
    }

    private Object trustedGet(TypeToken typeToken) {
        return this.backingMap.get(typeToken);
    }

    private Object trustedPut(TypeToken typeToken, Object object) {
        return this.backingMap.put(typeToken, object);
    }

    public Map delegate() {
        return this.backingMap;
    }

    public Set entrySet() {
        return MutableTypeToInstanceMap$UnmodifiableEntry.transformEntries(super.entrySet());
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
        serializable = new UnsupportedOperationException("Please use putInstance() instead.");
        throw serializable;
    }

    public void putAll(Map object) {
        object = new UnsupportedOperationException("Please use putInstance() instead.");
        throw object;
    }

    public Object putInstance(TypeToken typeToken, Object object) {
        typeToken = typeToken.rejectTypeVariables();
        return this.trustedPut(typeToken, object);
    }

    public Object putInstance(Class serializable, Object object) {
        serializable = TypeToken.of(serializable);
        return this.trustedPut((TypeToken)serializable, object);
    }
}

