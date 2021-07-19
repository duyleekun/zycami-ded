/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.reflect.ImmutableTypeToInstanceMap;
import com.google.common.reflect.ImmutableTypeToInstanceMap$1;
import com.google.common.reflect.TypeToken;

public final class ImmutableTypeToInstanceMap$Builder {
    private final ImmutableMap$Builder mapBuilder;

    private ImmutableTypeToInstanceMap$Builder() {
        ImmutableMap$Builder immutableMap$Builder;
        this.mapBuilder = immutableMap$Builder = ImmutableMap.builder();
    }

    public /* synthetic */ ImmutableTypeToInstanceMap$Builder(ImmutableTypeToInstanceMap$1 immutableTypeToInstanceMap$1) {
        this();
    }

    public ImmutableTypeToInstanceMap build() {
        ImmutableMap immutableMap = this.mapBuilder.build();
        ImmutableTypeToInstanceMap immutableTypeToInstanceMap = new ImmutableTypeToInstanceMap(immutableMap, null);
        return immutableTypeToInstanceMap;
    }

    public ImmutableTypeToInstanceMap$Builder put(TypeToken typeToken, Object object) {
        ImmutableMap$Builder immutableMap$Builder = this.mapBuilder;
        typeToken = typeToken.rejectTypeVariables();
        immutableMap$Builder.put(typeToken, object);
        return this;
    }

    public ImmutableTypeToInstanceMap$Builder put(Class serializable, Object object) {
        ImmutableMap$Builder immutableMap$Builder = this.mapBuilder;
        serializable = TypeToken.of(serializable);
        immutableMap$Builder.put(serializable, object);
        return this;
    }
}

