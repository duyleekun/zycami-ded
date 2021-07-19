/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableSortedSet$Builder;
import java.io.Serializable;
import java.util.Comparator;

public class ImmutableSortedSet$SerializedForm
implements Serializable {
    private static final long serialVersionUID;
    public final Comparator comparator;
    public final Object[] elements;

    public ImmutableSortedSet$SerializedForm(Comparator comparator, Object[] objectArray) {
        this.comparator = comparator;
        this.elements = objectArray;
    }

    public Object readResolve() {
        Object[] objectArray = this.comparator;
        ImmutableSortedSet$Builder immutableSortedSet$Builder = new ImmutableSortedSet$Builder((Comparator)objectArray);
        objectArray = this.elements;
        return ((ImmutableSortedSet$Builder)immutableSortedSet$Builder.add(objectArray)).build();
    }
}

