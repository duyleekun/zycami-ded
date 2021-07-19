/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.ListMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class AbstractListMultimap
extends AbstractMapBasedMultimap
implements ListMultimap {
    private static final long serialVersionUID = 6588350623831699109L;

    public AbstractListMultimap(Map map) {
        super(map);
    }

    public Map asMap() {
        return super.asMap();
    }

    public abstract List createCollection();

    public List createUnmodifiableEmptyCollection() {
        return Collections.emptyList();
    }

    public boolean equals(Object object) {
        return super.equals(object);
    }

    public List get(Object object) {
        return (List)super.get(object);
    }

    public boolean put(Object object, Object object2) {
        return super.put(object, object2);
    }

    public List removeAll(Object object) {
        return (List)super.removeAll(object);
    }

    public List replaceValues(Object object, Iterable iterable) {
        return (List)super.replaceValues(object, iterable);
    }

    public Collection unmodifiableCollectionSubclass(Collection collection) {
        return Collections.unmodifiableList((List)collection);
    }

    public Collection wrapCollection(Object object, Collection collection) {
        collection = (List)collection;
        return this.wrapList(object, (List)collection, null);
    }
}

