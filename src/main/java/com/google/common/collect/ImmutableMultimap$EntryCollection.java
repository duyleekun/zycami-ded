/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;

public class ImmutableMultimap$EntryCollection
extends ImmutableCollection {
    private static final long serialVersionUID;
    public final ImmutableMultimap multimap;

    public ImmutableMultimap$EntryCollection(ImmutableMultimap immutableMultimap) {
        this.multimap = immutableMultimap;
    }

    public boolean contains(Object object) {
        boolean bl2 = object instanceof Map.Entry;
        if (bl2) {
            object = (Map.Entry)object;
            ImmutableMultimap immutableMultimap = this.multimap;
            Object k10 = object.getKey();
            object = object.getValue();
            return immutableMultimap.containsEntry(k10, object);
        }
        return false;
    }

    public boolean isPartialView() {
        return this.multimap.isPartialView();
    }

    public UnmodifiableIterator iterator() {
        return this.multimap.entryIterator();
    }

    public int size() {
        return this.multimap.size();
    }
}

