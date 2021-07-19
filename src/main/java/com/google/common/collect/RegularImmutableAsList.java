/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;

public class RegularImmutableAsList
extends ImmutableAsList {
    private final ImmutableCollection delegate;
    private final ImmutableList delegateList;

    public RegularImmutableAsList(ImmutableCollection immutableCollection, ImmutableList immutableList) {
        this.delegate = immutableCollection;
        this.delegateList = immutableList;
    }

    public RegularImmutableAsList(ImmutableCollection immutableCollection, Object[] object) {
        object = ImmutableList.asImmutableList(object);
        this(immutableCollection, (ImmutableList)object);
    }

    public RegularImmutableAsList(ImmutableCollection immutableCollection, Object[] object, int n10) {
        object = ImmutableList.asImmutableList(object, n10);
        this(immutableCollection, (ImmutableList)object);
    }

    public int copyIntoArray(Object[] objectArray, int n10) {
        return this.delegateList.copyIntoArray(objectArray, n10);
    }

    public ImmutableCollection delegateCollection() {
        return this.delegate;
    }

    public ImmutableList delegateList() {
        return this.delegateList;
    }

    public Object get(int n10) {
        return this.delegateList.get(n10);
    }

    public Object[] internalArray() {
        return this.delegateList.internalArray();
    }

    public int internalArrayEnd() {
        return this.delegateList.internalArrayEnd();
    }

    public int internalArrayStart() {
        return this.delegateList.internalArrayStart();
    }

    public UnmodifiableListIterator listIterator(int n10) {
        return this.delegateList.listIterator(n10);
    }
}

