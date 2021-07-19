/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken;
import com.google.common.reflect.TypeToken$1;
import com.google.common.reflect.TypeToken$TypeCollector;
import com.google.common.reflect.TypeToken$TypeFilter;
import com.google.common.reflect.TypeToken$TypeSet;
import java.util.Collection;
import java.util.Set;

public final class TypeToken$ClassSet
extends TypeToken$TypeSet {
    private static final long serialVersionUID;
    private transient ImmutableSet classes;
    public final /* synthetic */ TypeToken this$0;

    private TypeToken$ClassSet(TypeToken typeToken) {
        this.this$0 = typeToken;
        super(typeToken);
    }

    public /* synthetic */ TypeToken$ClassSet(TypeToken typeToken, TypeToken$1 typeToken$1) {
        this(typeToken);
    }

    private Object readResolve() {
        return this.this$0.getTypes().classes();
    }

    public TypeToken$TypeSet classes() {
        return this;
    }

    public Set delegate() {
        Object object = this.classes;
        if (object == null) {
            object = TypeToken$TypeCollector.FOR_GENERIC_TYPE.classesOnly();
            Object object2 = this.this$0;
            object = FluentIterable.from(((TypeToken$TypeCollector)object).collectTypes(object2));
            object2 = TypeToken$TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD;
            this.classes = object = ((FluentIterable)object).filter((Predicate)object2).toSet();
        }
        return object;
    }

    public TypeToken$TypeSet interfaces() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("classes().interfaces() not supported.");
        throw unsupportedOperationException;
    }

    public Set rawTypes() {
        TypeToken$TypeCollector typeToken$TypeCollector = TypeToken$TypeCollector.FOR_RAW_TYPE.classesOnly();
        ImmutableSet immutableSet = TypeToken.access$300(this.this$0);
        return ImmutableSet.copyOf((Collection)typeToken$TypeCollector.collectTypes(immutableSet));
    }
}

