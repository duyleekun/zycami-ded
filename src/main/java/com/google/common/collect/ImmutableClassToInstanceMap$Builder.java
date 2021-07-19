/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableClassToInstanceMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.primitives.Primitives;
import java.util.Map;

public final class ImmutableClassToInstanceMap$Builder {
    private final ImmutableMap$Builder mapBuilder;

    public ImmutableClassToInstanceMap$Builder() {
        ImmutableMap$Builder immutableMap$Builder;
        this.mapBuilder = immutableMap$Builder = ImmutableMap.builder();
    }

    private static Object cast(Class clazz, Object object) {
        return Primitives.wrap(clazz).cast(object);
    }

    public ImmutableClassToInstanceMap build() {
        ImmutableMap immutableMap = this.mapBuilder.build();
        boolean bl2 = immutableMap.isEmpty();
        if (bl2) {
            return ImmutableClassToInstanceMap.of();
        }
        ImmutableClassToInstanceMap immutableClassToInstanceMap = new ImmutableClassToInstanceMap(immutableMap, null);
        return immutableClassToInstanceMap;
    }

    public ImmutableClassToInstanceMap$Builder put(Class clazz, Object object) {
        this.mapBuilder.put(clazz, object);
        return this;
    }

    public ImmutableClassToInstanceMap$Builder putAll(Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            Class clazz = (Class)object2.getKey();
            object2 = object2.getValue();
            ImmutableMap$Builder immutableMap$Builder = this.mapBuilder;
            object2 = ImmutableClassToInstanceMap$Builder.cast(clazz, object2);
            immutableMap$Builder.put(clazz, object2);
        }
        return this;
    }
}

