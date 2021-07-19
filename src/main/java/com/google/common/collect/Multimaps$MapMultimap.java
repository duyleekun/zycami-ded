/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$AsMap;
import com.google.common.collect.Multimaps$Keys;
import com.google.common.collect.Multimaps$MapMultimap$1;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Multimaps$MapMultimap
extends AbstractMultimap
implements SetMultimap,
Serializable {
    private static final long serialVersionUID = 7845222491160860175L;
    public final Map map;

    public Multimaps$MapMultimap(Map map) {
        this.map = map = (Map)Preconditions.checkNotNull(map);
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsEntry(Object object, Object object2) {
        Set set = this.map.entrySet();
        object = Maps.immutableEntry(object, object2);
        return set.contains(object);
    }

    public boolean containsKey(Object object) {
        return this.map.containsKey(object);
    }

    public boolean containsValue(Object object) {
        return this.map.containsValue(object);
    }

    public Map createAsMap() {
        Multimaps$AsMap multimaps$AsMap = new Multimaps$AsMap(this);
        return multimaps$AsMap;
    }

    public Collection createEntries() {
        AssertionError assertionError = new AssertionError((Object)"unreachable");
        throw assertionError;
    }

    public Set createKeySet() {
        return this.map.keySet();
    }

    public Multiset createKeys() {
        Multimaps$Keys multimaps$Keys = new Multimaps$Keys(this);
        return multimaps$Keys;
    }

    public Collection createValues() {
        return this.map.values();
    }

    public Set entries() {
        return this.map.entrySet();
    }

    public Iterator entryIterator() {
        return this.map.entrySet().iterator();
    }

    public Set get(Object object) {
        Multimaps$MapMultimap$1 multimaps$MapMultimap$1 = new Multimaps$MapMultimap$1(this, object);
        return multimaps$MapMultimap$1;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public boolean put(Object object, Object object2) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean putAll(Multimap object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean putAll(Object object, Iterable iterable) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean remove(Object object, Object object2) {
        Set set = this.map.entrySet();
        object = Maps.immutableEntry(object, object2);
        return set.remove(object);
    }

    public Set removeAll(Object object) {
        HashSet<Object> hashSet = new HashSet<Object>(2);
        Map map = this.map;
        boolean bl2 = map.containsKey(object);
        if (!bl2) {
            return hashSet;
        }
        object = this.map.remove(object);
        hashSet.add(object);
        return hashSet;
    }

    public Set replaceValues(Object object, Iterable iterable) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public int size() {
        return this.map.size();
    }
}

