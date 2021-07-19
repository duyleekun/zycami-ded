/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists$TransformingRandomAccessList$1;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class Lists$TransformingRandomAccessList
extends AbstractList
implements RandomAccess,
Serializable {
    private static final long serialVersionUID;
    public final List fromList;
    public final Function function;

    public Lists$TransformingRandomAccessList(List object, Function function) {
        object = (List)Preconditions.checkNotNull(object);
        this.fromList = object;
        this.function = object = (Function)Preconditions.checkNotNull(function);
    }

    public void clear() {
        this.fromList.clear();
    }

    public Object get(int n10) {
        Function function = this.function;
        Object e10 = this.fromList.get(n10);
        return function.apply(e10);
    }

    public boolean isEmpty() {
        return this.fromList.isEmpty();
    }

    public Iterator iterator() {
        return this.listIterator();
    }

    public ListIterator listIterator(int n10) {
        ListIterator listIterator = this.fromList.listIterator(n10);
        Lists$TransformingRandomAccessList$1 lists$TransformingRandomAccessList$1 = new Lists$TransformingRandomAccessList$1(this, listIterator);
        return lists$TransformingRandomAccessList$1;
    }

    public Object remove(int n10) {
        Function function = this.function;
        Object e10 = this.fromList.remove(n10);
        return function.apply(e10);
    }

    public int size() {
        return this.fromList.size();
    }
}

