/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$SerializedForm;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Platform;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;

public abstract class ImmutableCollection
extends AbstractCollection
implements Serializable {
    private static final Object[] EMPTY_ARRAY = new Object[0];

    public final boolean add(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final boolean addAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public ImmutableList asList() {
        boolean bl2 = this.isEmpty();
        ImmutableList immutableList = bl2 ? ImmutableList.of() : ImmutableList.asImmutableList(this.toArray());
        return immutableList;
    }

    public final void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public abstract boolean contains(Object var1);

    public int copyIntoArray(Object[] objectArray, int n10) {
        boolean bl2;
        UnmodifiableIterator unmodifiableIterator = this.iterator();
        while (bl2 = unmodifiableIterator.hasNext()) {
            Object e10 = unmodifiableIterator.next();
            int n11 = n10 + 1;
            objectArray[n10] = e10;
            n10 = n11;
        }
        return n10;
    }

    public Object[] internalArray() {
        return null;
    }

    public int internalArrayEnd() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public int internalArrayStart() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public abstract boolean isPartialView();

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

    public final Object[] toArray() {
        Object[] objectArray = EMPTY_ARRAY;
        return this.toArray(objectArray);
    }

    public final Object[] toArray(Object[] objectArray) {
        Preconditions.checkNotNull(objectArray);
        int n10 = this.size();
        int n11 = objectArray.length;
        if (n11 < n10) {
            Object[] objectArray2 = this.internalArray();
            if (objectArray2 != null) {
                n10 = this.internalArrayStart();
                int n12 = this.internalArrayEnd();
                return Platform.copy(objectArray2, n10, n12, objectArray);
            }
            objectArray = ObjectArrays.newArray(objectArray, n10);
        } else {
            n11 = objectArray.length;
            if (n11 > n10) {
                n11 = 0;
                Object var4_5 = null;
                objectArray[n10] = null;
            }
        }
        this.copyIntoArray(objectArray, 0);
        return objectArray;
    }

    public Object writeReplace() {
        Object[] objectArray = this.toArray();
        ImmutableList$SerializedForm immutableList$SerializedForm = new ImmutableList$SerializedForm(objectArray);
        return immutableList$SerializedForm;
    }
}

