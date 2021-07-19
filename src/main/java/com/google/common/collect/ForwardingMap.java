/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.ForwardingObject;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class ForwardingMap
extends ForwardingObject
implements Map {
    public void clear() {
        this.delegate().clear();
    }

    public boolean containsKey(Object object) {
        return this.delegate().containsKey(object);
    }

    public boolean containsValue(Object object) {
        return this.delegate().containsValue(object);
    }

    public abstract Map delegate();

    public Set entrySet() {
        return this.delegate().entrySet();
    }

    public boolean equals(Object object) {
        Object object2;
        boolean bl2;
        if (object != this && !(bl2 = (object2 = this.delegate()).equals(object))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Object get(Object object) {
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

    public Object put(Object object, Object object2) {
        return this.delegate().put(object, object2);
    }

    public void putAll(Map map) {
        this.delegate().putAll(map);
    }

    public Object remove(Object object) {
        return this.delegate().remove(object);
    }

    public int size() {
        return this.delegate().size();
    }

    public void standardClear() {
        Iterators.clear(this.entrySet().iterator());
    }

    public boolean standardContainsKey(Object object) {
        return Maps.containsKeyImpl(this, object);
    }

    public boolean standardContainsValue(Object object) {
        return Maps.containsValueImpl(this, object);
    }

    public boolean standardEquals(Object object) {
        return Maps.equalsImpl(this, object);
    }

    public int standardHashCode() {
        return Sets.hashCodeImpl(this.entrySet());
    }

    public boolean standardIsEmpty() {
        return this.entrySet().iterator().hasNext() ^ true;
    }

    public void standardPutAll(Map map) {
        Maps.putAllImpl(this, map);
    }

    public Object standardRemove(Object object) {
        boolean bl2;
        Iterator iterator2 = this.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator2.next();
            Object k10 = entry.getKey();
            boolean bl3 = Objects.equal(k10, object);
            if (!bl3) continue;
            object = entry.getValue();
            iterator2.remove();
            return object;
        }
        return null;
    }

    public String standardToString() {
        return Maps.toStringImpl(this);
    }

    public Collection values() {
        return this.delegate().values();
    }
}

