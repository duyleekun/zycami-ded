/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;

public class ImmutableAsList$SerializedForm
implements Serializable {
    private static final long serialVersionUID;
    public final ImmutableCollection collection;

    public ImmutableAsList$SerializedForm(ImmutableCollection immutableCollection) {
        this.collection = immutableCollection;
    }

    public Object readResolve() {
        return this.collection.asList();
    }
}

