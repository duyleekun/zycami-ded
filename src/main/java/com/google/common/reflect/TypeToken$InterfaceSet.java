/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken;
import com.google.common.reflect.TypeToken$InterfaceSet$1;
import com.google.common.reflect.TypeToken$TypeCollector;
import com.google.common.reflect.TypeToken$TypeFilter;
import com.google.common.reflect.TypeToken$TypeSet;
import java.util.Set;

public final class TypeToken$InterfaceSet
extends TypeToken$TypeSet {
    private static final long serialVersionUID;
    private final transient TypeToken$TypeSet allTypes;
    private transient ImmutableSet interfaces;
    public final /* synthetic */ TypeToken this$0;

    public TypeToken$InterfaceSet(TypeToken typeToken, TypeToken$TypeSet typeToken$TypeSet) {
        this.this$0 = typeToken;
        super(typeToken);
        this.allTypes = typeToken$TypeSet;
    }

    private Object readResolve() {
        return this.this$0.getTypes().interfaces();
    }

    public TypeToken$TypeSet classes() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("interfaces().classes() not supported.");
        throw unsupportedOperationException;
    }

    public Set delegate() {
        Iterable iterable = this.interfaces;
        if (iterable == null) {
            iterable = FluentIterable.from(this.allTypes);
            TypeToken$TypeFilter typeToken$TypeFilter = TypeToken$TypeFilter.INTERFACE_ONLY;
            iterable = ((FluentIterable)iterable).filter(typeToken$TypeFilter).toSet();
            this.interfaces = iterable;
        }
        return iterable;
    }

    public TypeToken$TypeSet interfaces() {
        return this;
    }

    public Set rawTypes() {
        Object object = TypeToken$TypeCollector.FOR_RAW_TYPE;
        Object object2 = TypeToken.access$300(this.this$0);
        object = FluentIterable.from(((TypeToken$TypeCollector)object).collectTypes((Iterable)object2));
        object2 = new TypeToken$InterfaceSet$1(this);
        return ((FluentIterable)object).filter((Predicate)object2).toSet();
    }
}

