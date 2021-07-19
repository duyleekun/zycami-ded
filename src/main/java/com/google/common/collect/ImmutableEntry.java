/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import java.io.Serializable;

public class ImmutableEntry
extends AbstractMapEntry
implements Serializable {
    private static final long serialVersionUID;
    public final Object key;
    public final Object value;

    public ImmutableEntry(Object object, Object object2) {
        this.key = object;
        this.value = object2;
    }

    public final Object getKey() {
        return this.key;
    }

    public final Object getValue() {
        return this.value;
    }

    public final Object setValue(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

