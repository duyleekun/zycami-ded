/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap$AsMapEntries;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap$AsMapIterator;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AbstractMapBasedMultimap$AsMap
extends Maps$ViewCachingAbstractMap {
    public final transient Map submap;
    public final /* synthetic */ AbstractMapBasedMultimap this$0;

    public AbstractMapBasedMultimap$AsMap(AbstractMapBasedMultimap abstractMapBasedMultimap, Map map) {
        this.this$0 = abstractMapBasedMultimap;
        this.submap = map;
    }

    public void clear() {
        Object object = this.submap;
        Map map = AbstractMapBasedMultimap.access$000(this.this$0);
        if (object == map) {
            object = this.this$0;
            ((AbstractMapBasedMultimap)object).clear();
        } else {
            object = new AbstractMapBasedMultimap$AsMap$AsMapIterator(this);
            Iterators.clear((Iterator)object);
        }
    }

    public boolean containsKey(Object object) {
        return Maps.safeContainsKey(this.submap, object);
    }

    public Set createEntrySet() {
        AbstractMapBasedMultimap$AsMap$AsMapEntries abstractMapBasedMultimap$AsMap$AsMapEntries = new AbstractMapBasedMultimap$AsMap$AsMapEntries(this);
        return abstractMapBasedMultimap$AsMap$AsMapEntries;
    }

    public boolean equals(Object object) {
        Map map;
        boolean bl2;
        if (this != object && !(bl2 = (map = this.submap).equals(object))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Collection get(Object object) {
        Collection collection = (Collection)Maps.safeGet(this.submap, object);
        if (collection == null) {
            return null;
        }
        return this.this$0.wrapCollection(object, collection);
    }

    public int hashCode() {
        return this.submap.hashCode();
    }

    public Set keySet() {
        return this.this$0.keySet();
    }

    public Collection remove(Object object) {
        Object object2 = this.submap;
        if ((object = (Collection)object2.remove(object)) == null) {
            return null;
        }
        object2 = this.this$0.createCollection();
        object2.addAll(object);
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        int n10 = AbstractMapBasedMultimap.access$200(abstractMapBasedMultimap);
        int n11 = object.size();
        AbstractMapBasedMultimap.access$202(abstractMapBasedMultimap, n10 -= n11);
        object.clear();
        return object2;
    }

    public int size() {
        return this.submap.size();
    }

    public String toString() {
        return this.submap.toString();
    }

    public Map.Entry wrapEntry(Map.Entry object) {
        Object k10 = object.getKey();
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        object = (Collection)object.getValue();
        object = abstractMapBasedMultimap.wrapCollection(k10, (Collection)object);
        return Maps.immutableEntry(k10, object);
    }
}

