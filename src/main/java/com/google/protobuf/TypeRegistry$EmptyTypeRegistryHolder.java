/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.TypeRegistry;
import java.util.Collections;
import java.util.Map;

public class TypeRegistry$EmptyTypeRegistryHolder {
    private static final TypeRegistry EMPTY;

    static {
        TypeRegistry typeRegistry;
        Map map = Collections.emptyMap();
        EMPTY = typeRegistry = new TypeRegistry(map);
    }

    private TypeRegistry$EmptyTypeRegistryHolder() {
    }

    public static /* synthetic */ TypeRegistry access$000() {
        return EMPTY;
    }
}

