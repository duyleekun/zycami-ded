/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FilteredKeyMultimap$AddRejectingList
extends ForwardingList {
    public final Object key;

    public FilteredKeyMultimap$AddRejectingList(Object object) {
        this.key = object;
    }

    public void add(int n10, Object object) {
        Preconditions.checkPositionIndex(n10, 0);
        object = new StringBuilder();
        ((StringBuilder)object).append("Key does not satisfy predicate: ");
        Object object2 = this.key;
        ((StringBuilder)object).append(object2);
        object = ((StringBuilder)object).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public boolean add(Object object) {
        this.add(0, object);
        return true;
    }

    public boolean addAll(int n10, Collection object) {
        Preconditions.checkNotNull(object);
        Preconditions.checkPositionIndex(n10, 0);
        object = new StringBuilder();
        ((StringBuilder)object).append("Key does not satisfy predicate: ");
        Object object2 = this.key;
        ((StringBuilder)object).append(object2);
        object = ((StringBuilder)object).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public boolean addAll(Collection collection) {
        this.addAll(0, collection);
        return true;
    }

    public List delegate() {
        return Collections.emptyList();
    }
}

