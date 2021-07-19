/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingObject;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class ForwardingMultimap
extends ForwardingObject
implements Multimap {
    public Map asMap() {
        return this.delegate().asMap();
    }

    public void clear() {
        this.delegate().clear();
    }

    public boolean containsEntry(Object object, Object object2) {
        return this.delegate().containsEntry(object, object2);
    }

    public boolean containsKey(Object object) {
        return this.delegate().containsKey(object);
    }

    public boolean containsValue(Object object) {
        return this.delegate().containsValue(object);
    }

    public abstract Multimap delegate();

    public Collection entries() {
        return this.delegate().entries();
    }

    public boolean equals(Object object) {
        Multimap multimap;
        boolean bl2;
        if (object != this && !(bl2 = (multimap = this.delegate()).equals(object))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Collection get(Object object) {
        return this.delegate().get(object);
    }

    public int hashCode() {
        return this.delegate().hashCode();
    }

    public boolean isEmpty() {
        return this.delegate().isEmpty();
    }

    public Set keySet() {
        return this.delegate().keySet();
    }

    public Multiset keys() {
        return this.delegate().keys();
    }

    public boolean put(Object object, Object object2) {
        return this.delegate().put(object, object2);
    }

    public boolean putAll(Multimap multimap) {
        return this.delegate().putAll(multimap);
    }

    public boolean putAll(Object object, Iterable iterable) {
        return this.delegate().putAll(object, iterable);
    }

    public boolean remove(Object object, Object object2) {
        return this.delegate().remove(object, object2);
    }

    public Collection removeAll(Object object) {
        return this.delegate().removeAll(object);
    }

    public Collection replaceValues(Object object, Iterable iterable) {
        return this.delegate().replaceValues(object, iterable);
    }

    public int size() {
        return this.delegate().size();
    }

    public Collection values() {
        return this.delegate().values();
    }
}

