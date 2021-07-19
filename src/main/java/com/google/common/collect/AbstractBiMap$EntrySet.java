/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.AbstractBiMap$1;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AbstractBiMap$EntrySet
extends ForwardingSet {
    public final Set esDelegate;
    public final /* synthetic */ AbstractBiMap this$0;

    private AbstractBiMap$EntrySet(AbstractBiMap object) {
        this.this$0 = object;
        this.esDelegate = object = AbstractBiMap.access$100((AbstractBiMap)object).entrySet();
    }

    public /* synthetic */ AbstractBiMap$EntrySet(AbstractBiMap abstractBiMap, AbstractBiMap$1 abstractBiMap$1) {
        this(abstractBiMap);
    }

    public void clear() {
        this.this$0.clear();
    }

    public boolean contains(Object object) {
        return Maps.containsEntryImpl((Collection)this.delegate(), object);
    }

    public boolean containsAll(Collection collection) {
        return this.standardContainsAll(collection);
    }

    public Set delegate() {
        return this.esDelegate;
    }

    public Iterator iterator() {
        return this.this$0.entrySetIterator();
    }

    public boolean remove(Object object) {
        Object object2 = this.esDelegate;
        boolean bl2 = object2.contains(object);
        if (!bl2) {
            return false;
        }
        object = (Map.Entry)object;
        object2 = AbstractBiMap.access$100(this.this$0.inverse);
        Object v10 = object.getValue();
        object2.remove(v10);
        this.esDelegate.remove(object);
        return true;
    }

    public boolean removeAll(Collection collection) {
        return this.standardRemoveAll(collection);
    }

    public boolean retainAll(Collection collection) {
        return this.standardRetainAll(collection);
    }

    public Object[] toArray() {
        return this.standardToArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return this.standardToArray(objectArray);
    }
}

