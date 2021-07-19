/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import java.io.Serializable;

public class ImmutableSet$SerializedForm
implements Serializable {
    private static final long serialVersionUID;
    public final Object[] elements;

    public ImmutableSet$SerializedForm(Object[] objectArray) {
        this.elements = objectArray;
    }

    public Object readResolve() {
        return ImmutableSet.copyOf(this.elements);
    }
}

