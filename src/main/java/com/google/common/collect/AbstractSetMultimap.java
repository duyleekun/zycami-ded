/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedSet;
import com.google.common.collect.SetMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public abstract class AbstractSetMultimap
extends AbstractMapBasedMultimap
implements SetMultimap {
    private static final long serialVersionUID = 7431625294878419160L;

    public AbstractSetMultimap(Map map) {
        super(map);
    }

    public Map asMap() {
        return super.asMap();
    }

    public abstract Set createCollection();

    public Set createUnmodifiableEmptyCollection() {
        return Collections.emptySet();
    }

    public Set entries() {
        return (Set)super.entries();
    }

    public boolean equals(Object object) {
        return super.equals(object);
    }

    public Set get(Object object) {
        return (Set)super.get(object);
    }

    public boolean put(Object object, Object object2) {
        return super.put(object, object2);
    }

    public Set removeAll(Object object) {
        return (Set)super.removeAll(object);
    }

    public Set replaceValues(Object object, Iterable iterable) {
        return (Set)super.replaceValues(object, iterable);
    }

    public Collection unmodifiableCollectionSubclass(Collection collection) {
        return Collections.unmodifiableSet((Set)collection);
    }

    public Collection wrapCollection(Object object, Collection collection) {
        collection = (Set)collection;
        AbstractMapBasedMultimap$WrappedSet abstractMapBasedMultimap$WrappedSet = new AbstractMapBasedMultimap$WrappedSet(this, object, (Set)collection);
        return abstractMapBasedMultimap$WrappedSet;
    }
}

