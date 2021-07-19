/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import com.google.common.collect.Maps$Values;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Maps$TransformedEntriesMap
extends Maps$IteratorBasedAbstractMap {
    public final Map fromMap;
    public final Maps$EntryTransformer transformer;

    public Maps$TransformedEntriesMap(Map object, Maps$EntryTransformer maps$EntryTransformer) {
        object = (Map)Preconditions.checkNotNull(object);
        this.fromMap = object;
        this.transformer = object = (Maps$EntryTransformer)Preconditions.checkNotNull(maps$EntryTransformer);
    }

    public void clear() {
        this.fromMap.clear();
    }

    public boolean containsKey(Object object) {
        return this.fromMap.containsKey(object);
    }

    public Iterator entryIterator() {
        Iterator iterator2 = this.fromMap.entrySet().iterator();
        Function function = Maps.asEntryToEntryFunction(this.transformer);
        return Iterators.transform(iterator2, function);
    }

    public Object get(Object object) {
        Object object2;
        boolean bl2;
        Object v10 = this.fromMap.get(object);
        if (v10 == null && !(bl2 = (object2 = this.fromMap).containsKey(object))) {
            object = null;
        } else {
            object2 = this.transformer;
            object = object2.transformEntry(object, v10);
        }
        return object;
    }

    public Set keySet() {
        return this.fromMap.keySet();
    }

    public Object remove(Object object) {
        Object object2 = this.fromMap;
        boolean bl2 = object2.containsKey(object);
        if (bl2) {
            object2 = this.transformer;
            Object v10 = this.fromMap.remove(object);
            object = object2.transformEntry(object, v10);
        } else {
            object = null;
        }
        return object;
    }

    public int size() {
        return this.fromMap.size();
    }

    public Collection values() {
        Maps$Values maps$Values = new Maps$Values(this);
        return maps$Values;
    }
}

