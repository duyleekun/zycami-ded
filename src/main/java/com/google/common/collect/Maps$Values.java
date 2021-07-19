/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Maps$Values
extends AbstractCollection {
    public final Map map;

    public Maps$Values(Map map) {
        this.map = map = (Map)Preconditions.checkNotNull(map);
    }

    public void clear() {
        this.map().clear();
    }

    public boolean contains(Object object) {
        return this.map().containsValue(object);
    }

    public boolean isEmpty() {
        return this.map().isEmpty();
    }

    public Iterator iterator() {
        return Maps.valueIterator(this.map().entrySet().iterator());
    }

    public final Map map() {
        return this.map;
    }

    public boolean remove(Object object) {
        try {
            return super.remove(object);
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            boolean bl2;
            Iterator iterator2 = this.map().entrySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                Map.Entry entry = iterator2.next();
                Object v10 = entry.getValue();
                boolean bl3 = Objects.equal(object, v10);
                if (!bl3) continue;
                object = this.map();
                iterator2 = entry.getKey();
                object.remove(iterator2);
                return true;
            }
            return false;
        }
    }

    public boolean removeAll(Collection collection) {
        Object object;
        try {
            object = Preconditions.checkNotNull(collection);
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            boolean bl2;
            object = Sets.newHashSet();
            Iterator iterator2 = this.map().entrySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                Map.Entry entry = iterator2.next();
                Object v10 = entry.getValue();
                boolean bl3 = collection.contains(v10);
                if (!bl3) continue;
                entry = entry.getKey();
                object.add(entry);
            }
            return this.map().keySet().removeAll((Collection<?>)object);
        }
        object = (Collection)object;
        return super.removeAll((Collection<?>)object);
    }

    public boolean retainAll(Collection collection) {
        Object object;
        try {
            object = Preconditions.checkNotNull(collection);
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            boolean bl2;
            object = Sets.newHashSet();
            Iterator iterator2 = this.map().entrySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                Map.Entry entry = iterator2.next();
                Object v10 = entry.getValue();
                boolean bl3 = collection.contains(v10);
                if (!bl3) continue;
                entry = entry.getKey();
                object.add(entry);
            }
            return this.map().keySet().retainAll((Collection<?>)object);
        }
        object = (Collection)object;
        return super.retainAll((Collection<?>)object);
    }

    public int size() {
        return this.map().size();
    }
}

