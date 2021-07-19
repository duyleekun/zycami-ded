/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets$1;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Set;

public abstract class Sets$SetView
extends AbstractSet {
    private Sets$SetView() {
    }

    public /* synthetic */ Sets$SetView(Sets.1 var1_1) {
        this();
    }

    public final boolean add(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final boolean addAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public Set copyInto(Set set) {
        set.addAll(this);
        return set;
    }

    public ImmutableSet immutableCopy() {
        return ImmutableSet.copyOf((Collection)this);
    }

    public abstract UnmodifiableIterator iterator();

    public final boolean remove(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final boolean removeAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final boolean retainAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

