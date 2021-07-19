/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingMultiset;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class Multisets$UnmodifiableMultiset
extends ForwardingMultiset
implements Serializable {
    private static final long serialVersionUID;
    public final Multiset delegate;
    public transient Set elementSet;
    public transient Set entrySet;

    public Multisets$UnmodifiableMultiset(Multiset multiset) {
        this.delegate = multiset;
    }

    public int add(Object object, int n10) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean add(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean addAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public Set createElementSet() {
        return Collections.unmodifiableSet(this.delegate.elementSet());
    }

    public Multiset delegate() {
        return this.delegate;
    }

    public Set elementSet() {
        Set set = this.elementSet;
        if (set == null) {
            this.elementSet = set = this.createElementSet();
        }
        return set;
    }

    public Set entrySet() {
        Set set = this.entrySet;
        if (set == null) {
            this.entrySet = set = Collections.unmodifiableSet(this.delegate.entrySet());
        }
        return set;
    }

    public Iterator iterator() {
        return Iterators.unmodifiableIterator(this.delegate.iterator());
    }

    public int remove(Object object, int n10) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean remove(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean removeAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean retainAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public int setCount(Object object, int n10) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean setCount(Object object, int n10, int n11) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

