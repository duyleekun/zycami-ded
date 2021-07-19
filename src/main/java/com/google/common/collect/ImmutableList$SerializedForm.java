/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;

public class ImmutableList$SerializedForm
implements Serializable {
    private static final long serialVersionUID;
    public final Object[] elements;

    public ImmutableList$SerializedForm(Object[] objectArray) {
        this.elements = objectArray;
    }

    public Object readResolve() {
        return ImmutableList.copyOf(this.elements);
    }
}

