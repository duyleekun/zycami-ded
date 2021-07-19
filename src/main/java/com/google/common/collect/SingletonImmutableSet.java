/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;

public final class SingletonImmutableSet
extends ImmutableSet {
    private transient int cachedHashCode;
    public final transient Object element;

    public SingletonImmutableSet(Object object) {
        this.element = object = Preconditions.checkNotNull(object);
    }

    public SingletonImmutableSet(Object object, int n10) {
        this.element = object;
        this.cachedHashCode = n10;
    }

    public boolean contains(Object object) {
        return this.element.equals(object);
    }

    public int copyIntoArray(Object[] objectArray, int n10) {
        Object object;
        objectArray[n10] = object = this.element;
        return n10 + 1;
    }

    public ImmutableList createAsList() {
        return ImmutableList.of(this.element);
    }

    public final int hashCode() {
        int n10 = this.cachedHashCode;
        if (n10 == 0) {
            Object object = this.element;
            this.cachedHashCode = n10 = object.hashCode();
        }
        return n10;
    }

    public boolean isHashCodeFast() {
        int n10 = this.cachedHashCode;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isPartialView() {
        return false;
    }

    public UnmodifiableIterator iterator() {
        return Iterators.singletonIterator(this.element);
    }

    public int size() {
        return 1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        String string2 = this.element.toString();
        stringBuilder.append(string2);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

