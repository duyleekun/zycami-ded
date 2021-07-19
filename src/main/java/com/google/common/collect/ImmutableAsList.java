/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableAsList$SerializedForm;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public abstract class ImmutableAsList
extends ImmutableList {
    private void readObject(ObjectInputStream object) {
        object = new InvalidObjectException("Use SerializedForm");
        throw object;
    }

    public boolean contains(Object object) {
        return this.delegateCollection().contains(object);
    }

    public abstract ImmutableCollection delegateCollection();

    public boolean isEmpty() {
        return this.delegateCollection().isEmpty();
    }

    public boolean isPartialView() {
        return this.delegateCollection().isPartialView();
    }

    public int size() {
        return this.delegateCollection().size();
    }

    public Object writeReplace() {
        ImmutableCollection immutableCollection = this.delegateCollection();
        ImmutableAsList$SerializedForm immutableAsList$SerializedForm = new ImmutableAsList$SerializedForm(immutableCollection);
        return immutableAsList$SerializedForm;
    }
}

