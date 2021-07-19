/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken$TypeCollector;
import com.google.common.reflect.TypeToken$TypeCollector$ForwardingTypeCollector;

public class TypeToken$TypeCollector$3
extends TypeToken$TypeCollector$ForwardingTypeCollector {
    public final /* synthetic */ TypeToken$TypeCollector this$0;

    public TypeToken$TypeCollector$3(TypeToken$TypeCollector typeToken$TypeCollector, TypeToken$TypeCollector typeToken$TypeCollector2) {
        this.this$0 = typeToken$TypeCollector;
        super(typeToken$TypeCollector2);
    }

    public ImmutableList collectTypes(Iterable object) {
        boolean bl2;
        ImmutableList$Builder immutableList$Builder = ImmutableList.builder();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Class clazz = this.getRawType(e10);
            boolean bl3 = clazz.isInterface();
            if (bl3) continue;
            immutableList$Builder.add(e10);
        }
        object = immutableList$Builder.build();
        return super.collectTypes((Iterable)object);
    }

    public Iterable getInterfaces(Object object) {
        return ImmutableSet.of();
    }
}

