/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken;
import com.google.common.reflect.TypeToken$ClassSet;
import com.google.common.reflect.TypeToken$InterfaceSet;
import com.google.common.reflect.TypeToken$TypeCollector;
import com.google.common.reflect.TypeToken$TypeFilter;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public class TypeToken$TypeSet
extends ForwardingSet
implements Serializable {
    private static final long serialVersionUID;
    public final /* synthetic */ TypeToken this$0;
    private transient ImmutableSet types;

    public TypeToken$TypeSet(TypeToken typeToken) {
        this.this$0 = typeToken;
    }

    public TypeToken$TypeSet classes() {
        TypeToken typeToken = this.this$0;
        TypeToken$ClassSet typeToken$ClassSet = new TypeToken$ClassSet(typeToken, null);
        return typeToken$ClassSet;
    }

    public Set delegate() {
        Object object = this.types;
        if (object == null) {
            object = TypeToken$TypeCollector.FOR_GENERIC_TYPE;
            Object object2 = this.this$0;
            object = FluentIterable.from(((TypeToken$TypeCollector)object).collectTypes(object2));
            object2 = TypeToken$TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD;
            this.types = object = ((FluentIterable)object).filter((Predicate)object2).toSet();
        }
        return object;
    }

    public TypeToken$TypeSet interfaces() {
        TypeToken typeToken = this.this$0;
        TypeToken$InterfaceSet typeToken$InterfaceSet = new TypeToken$InterfaceSet(typeToken, this);
        return typeToken$InterfaceSet;
    }

    public Set rawTypes() {
        TypeToken$TypeCollector typeToken$TypeCollector = TypeToken$TypeCollector.FOR_RAW_TYPE;
        ImmutableSet immutableSet = TypeToken.access$300(this.this$0);
        return ImmutableSet.copyOf((Collection)typeToken$TypeCollector.collectTypes(immutableSet));
    }
}

