/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$AsMap$EntrySet;
import java.util.Collection;
import java.util.Set;

public final class Multimaps$AsMap
extends Maps$ViewCachingAbstractMap {
    private final Multimap multimap;

    public Multimaps$AsMap(Multimap multimap) {
        this.multimap = multimap = (Multimap)Preconditions.checkNotNull(multimap);
    }

    public static /* synthetic */ Multimap access$200(Multimaps$AsMap multimaps$AsMap) {
        return multimaps$AsMap.multimap;
    }

    public void clear() {
        this.multimap.clear();
    }

    public boolean containsKey(Object object) {
        return this.multimap.containsKey(object);
    }

    public Set createEntrySet() {
        Multimaps$AsMap$EntrySet multimaps$AsMap$EntrySet = new Multimaps$AsMap$EntrySet(this);
        return multimaps$AsMap$EntrySet;
    }

    public Collection get(Object object) {
        boolean bl2 = this.containsKey(object);
        if (bl2) {
            Multimap multimap = this.multimap;
            object = multimap.get(object);
        } else {
            object = null;
        }
        return object;
    }

    public boolean isEmpty() {
        return this.multimap.isEmpty();
    }

    public Set keySet() {
        return this.multimap.keySet();
    }

    public Collection remove(Object object) {
        boolean bl2 = this.containsKey(object);
        if (bl2) {
            Multimap multimap = this.multimap;
            object = multimap.removeAll(object);
        } else {
            object = null;
        }
        return object;
    }

    public void removeValuesForKey(Object object) {
        this.multimap.keySet().remove(object);
    }

    public int size() {
        return this.multimap.keySet().size();
    }
}

