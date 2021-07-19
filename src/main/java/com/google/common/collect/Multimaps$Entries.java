/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import java.util.AbstractCollection;
import java.util.Map;

public abstract class Multimaps$Entries
extends AbstractCollection {
    public void clear() {
        this.multimap().clear();
    }

    public boolean contains(Object object) {
        boolean bl2 = object instanceof Map.Entry;
        if (bl2) {
            object = (Map.Entry)object;
            Multimap multimap = this.multimap();
            Object k10 = object.getKey();
            object = object.getValue();
            return multimap.containsEntry(k10, object);
        }
        return false;
    }

    public abstract Multimap multimap();

    public boolean remove(Object object) {
        boolean bl2 = object instanceof Map.Entry;
        if (bl2) {
            object = (Map.Entry)object;
            Multimap multimap = this.multimap();
            Object k10 = object.getKey();
            object = object.getValue();
            return multimap.remove(k10, object);
        }
        return false;
    }

    public int size() {
        return this.multimap().size();
    }
}

