/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

public class Lists$AbstractListWrapper
extends AbstractList {
    public final List backingList;

    public Lists$AbstractListWrapper(List list) {
        this.backingList = list = (List)Preconditions.checkNotNull(list);
    }

    public void add(int n10, Object object) {
        this.backingList.add(n10, object);
    }

    public boolean addAll(int n10, Collection collection) {
        return this.backingList.addAll(n10, collection);
    }

    public boolean contains(Object object) {
        return this.backingList.contains(object);
    }

    public Object get(int n10) {
        return this.backingList.get(n10);
    }

    public Object remove(int n10) {
        return this.backingList.remove(n10);
    }

    public Object set(int n10, Object object) {
        return this.backingList.set(n10, object);
    }

    public int size() {
        return this.backingList.size();
    }
}

