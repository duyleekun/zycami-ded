/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.Collections2;
import com.google.common.collect.ForwardingObject;
import com.google.common.collect.Iterators;
import com.google.common.collect.ObjectArrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class ForwardingCollection
extends ForwardingObject
implements Collection {
    public boolean add(Object object) {
        return this.delegate().add(object);
    }

    public boolean addAll(Collection collection) {
        return this.delegate().addAll(collection);
    }

    public void clear() {
        this.delegate().clear();
    }

    public boolean contains(Object object) {
        return this.delegate().contains(object);
    }

    public boolean containsAll(Collection collection) {
        return this.delegate().containsAll(collection);
    }

    public abstract Collection delegate();

    public boolean isEmpty() {
        return this.delegate().isEmpty();
    }

    public Iterator iterator() {
        return this.delegate().iterator();
    }

    public boolean remove(Object object) {
        return this.delegate().remove(object);
    }

    public boolean removeAll(Collection collection) {
        return this.delegate().removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        return this.delegate().retainAll(collection);
    }

    public int size() {
        return this.delegate().size();
    }

    public boolean standardAddAll(Collection object) {
        object = object.iterator();
        return Iterators.addAll(this, (Iterator)object);
    }

    public void standardClear() {
        Iterators.clear(this.iterator());
    }

    public boolean standardContains(Object object) {
        return Iterators.contains(this.iterator(), object);
    }

    public boolean standardContainsAll(Collection collection) {
        return Collections2.containsAllImpl(this, collection);
    }

    public boolean standardIsEmpty() {
        return this.iterator().hasNext() ^ true;
    }

    public boolean standardRemove(Object object) {
        boolean bl2;
        Iterator iterator2 = this.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            bl2 = Objects.equal(e10, object);
            if (!bl2) continue;
            iterator2.remove();
            return true;
        }
        return false;
    }

    public boolean standardRemoveAll(Collection collection) {
        return Iterators.removeAll(this.iterator(), collection);
    }

    public boolean standardRetainAll(Collection collection) {
        return Iterators.retainAll(this.iterator(), collection);
    }

    public Object[] standardToArray() {
        Object[] objectArray = new Object[this.size()];
        return this.toArray(objectArray);
    }

    public Object[] standardToArray(Object[] objectArray) {
        return ObjectArrays.toArrayImpl(this, objectArray);
    }

    public String standardToString() {
        return Collections2.toStringImpl(this);
    }

    public Object[] toArray() {
        return this.delegate().toArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return this.delegate().toArray(objectArray);
    }
}

