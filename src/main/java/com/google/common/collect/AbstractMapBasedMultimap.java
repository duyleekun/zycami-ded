/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultimap$1;
import com.google.common.collect.AbstractMapBasedMultimap$2;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap;
import com.google.common.collect.AbstractMapBasedMultimap$KeySet;
import com.google.common.collect.AbstractMapBasedMultimap$NavigableAsMap;
import com.google.common.collect.AbstractMapBasedMultimap$NavigableKeySet;
import com.google.common.collect.AbstractMapBasedMultimap$RandomAccessWrappedList;
import com.google.common.collect.AbstractMapBasedMultimap$SortedAsMap;
import com.google.common.collect.AbstractMapBasedMultimap$SortedKeySet;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedList;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.AbstractMultimap$Entries;
import com.google.common.collect.AbstractMultimap$EntrySet;
import com.google.common.collect.AbstractMultimap$Values;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps$Keys;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

public abstract class AbstractMapBasedMultimap
extends AbstractMultimap
implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map map;
    private transient int totalSize;

    public AbstractMapBasedMultimap(Map map) {
        Preconditions.checkArgument(map.isEmpty());
        this.map = map;
    }

    public static /* synthetic */ Map access$000(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        return abstractMapBasedMultimap.map;
    }

    public static /* synthetic */ Iterator access$100(Collection collection) {
        return AbstractMapBasedMultimap.iteratorOrListIterator(collection);
    }

    public static /* synthetic */ int access$200(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        return abstractMapBasedMultimap.totalSize;
    }

    public static /* synthetic */ int access$202(AbstractMapBasedMultimap abstractMapBasedMultimap, int n10) {
        abstractMapBasedMultimap.totalSize = n10;
        return n10;
    }

    public static /* synthetic */ int access$208(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int n10;
        int n11 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = n10 = n11 + 1;
        return n11;
    }

    public static /* synthetic */ int access$210(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int n10;
        int n11 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = n10 = n11 + -1;
        return n11;
    }

    public static /* synthetic */ void access$300(AbstractMapBasedMultimap abstractMapBasedMultimap, Object object) {
        abstractMapBasedMultimap.removeValuesForKey(object);
    }

    private Collection getOrCreateCollection(Object object) {
        Collection collection = (Collection)this.map.get(object);
        if (collection == null) {
            collection = this.createCollection(object);
            Map map = this.map;
            map.put(object, collection);
        }
        return collection;
    }

    private static Iterator iteratorOrListIterator(Collection iterator2) {
        boolean bl2 = iterator2 instanceof List;
        iterator2 = bl2 ? ((List)((Object)iterator2)).listIterator() : iterator2.iterator();
        return iterator2;
    }

    private void removeValuesForKey(Object object) {
        Map map = this.map;
        if ((object = (Collection)Maps.safeRemove(map, object)) != null) {
            int n10;
            int n11 = object.size();
            object.clear();
            this.totalSize = n10 = this.totalSize - n11;
        }
    }

    public Map backingMap() {
        return this.map;
    }

    public void clear() {
        boolean bl2;
        Iterator iterator2 = this.map.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            Collection collection = (Collection)iterator2.next();
            collection.clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    public boolean containsKey(Object object) {
        return this.map.containsKey(object);
    }

    public Map createAsMap() {
        Map map = this.map;
        AbstractMapBasedMultimap$AsMap abstractMapBasedMultimap$AsMap = new AbstractMapBasedMultimap$AsMap(this, map);
        return abstractMapBasedMultimap$AsMap;
    }

    public abstract Collection createCollection();

    public Collection createCollection(Object object) {
        return this.createCollection();
    }

    public Collection createEntries() {
        boolean bl2 = this instanceof SetMultimap;
        if (bl2) {
            AbstractMultimap$EntrySet abstractMultimap$EntrySet = new AbstractMultimap$EntrySet(this);
            return abstractMultimap$EntrySet;
        }
        AbstractMultimap$Entries abstractMultimap$Entries = new AbstractMultimap$Entries(this);
        return abstractMultimap$Entries;
    }

    public Set createKeySet() {
        Map map = this.map;
        AbstractMapBasedMultimap$KeySet abstractMapBasedMultimap$KeySet = new AbstractMapBasedMultimap$KeySet(this, map);
        return abstractMapBasedMultimap$KeySet;
    }

    public Multiset createKeys() {
        Multimaps$Keys multimaps$Keys = new Multimaps$Keys(this);
        return multimaps$Keys;
    }

    public final Map createMaybeNavigableAsMap() {
        Map map = this.map;
        boolean bl2 = map instanceof NavigableMap;
        if (bl2) {
            NavigableMap navigableMap = (NavigableMap)this.map;
            map = new AbstractMapBasedMultimap$NavigableAsMap(this, navigableMap);
            return map;
        }
        boolean bl3 = map instanceof SortedMap;
        if (bl3) {
            SortedMap sortedMap = (SortedMap)this.map;
            map = new AbstractMapBasedMultimap$SortedAsMap(this, sortedMap);
            return map;
        }
        Map map2 = this.map;
        map = new AbstractMapBasedMultimap$AsMap(this, map2);
        return map;
    }

    public final Set createMaybeNavigableKeySet() {
        Object object = this.map;
        boolean bl2 = object instanceof NavigableMap;
        if (bl2) {
            NavigableMap navigableMap = (NavigableMap)this.map;
            object = new AbstractMapBasedMultimap$NavigableKeySet(this, navigableMap);
            return object;
        }
        boolean bl3 = object instanceof SortedMap;
        if (bl3) {
            SortedMap sortedMap = (SortedMap)this.map;
            object = new AbstractMapBasedMultimap$SortedKeySet(this, sortedMap);
            return object;
        }
        Map map = this.map;
        object = new AbstractMapBasedMultimap$KeySet(this, map);
        return object;
    }

    public Collection createUnmodifiableEmptyCollection() {
        Collection collection = this.createCollection();
        return this.unmodifiableCollectionSubclass(collection);
    }

    public Collection createValues() {
        AbstractMultimap$Values abstractMultimap$Values = new AbstractMultimap$Values(this);
        return abstractMultimap$Values;
    }

    public Collection entries() {
        return super.entries();
    }

    public Iterator entryIterator() {
        AbstractMapBasedMultimap$2 abstractMapBasedMultimap$2 = new AbstractMapBasedMultimap$2(this);
        return abstractMapBasedMultimap$2;
    }

    public Collection get(Object object) {
        Collection collection = (Collection)this.map.get(object);
        if (collection == null) {
            collection = this.createCollection(object);
        }
        return this.wrapCollection(object, collection);
    }

    public boolean put(Object object, Object object2) {
        Collection collection = (Collection)this.map.get(object);
        int n10 = 1;
        if (collection == null) {
            collection = this.createCollection(object);
            int n11 = collection.add(object2);
            if (n11 != 0) {
                this.totalSize = n11 = this.totalSize + n10;
                this.map.put(object, collection);
                return n10 != 0;
            }
            object = new AssertionError((Object)"New Collection violated the Collection spec");
            throw object;
        }
        int n12 = collection.add(object2);
        if (n12 != 0) {
            this.totalSize = n12 = this.totalSize + n10;
            return n10 != 0;
        }
        return false;
    }

    public Collection removeAll(Object object) {
        Object object2 = this.map;
        if ((object = (Collection)object2.remove(object)) == null) {
            return this.createUnmodifiableEmptyCollection();
        }
        object2 = this.createCollection();
        object2.addAll(object);
        int n10 = this.totalSize;
        int n11 = object.size();
        this.totalSize = n10 -= n11;
        object.clear();
        return this.unmodifiableCollectionSubclass((Collection)object2);
    }

    public Collection replaceValues(Object object, Iterable object2) {
        boolean bl2 = (object2 = object2.iterator()).hasNext();
        if (!bl2) {
            return this.removeAll(object);
        }
        object = this.getOrCreateCollection(object);
        Collection collection = this.createCollection();
        collection.addAll(object);
        int n10 = this.totalSize;
        int n11 = object.size();
        this.totalSize = n10 -= n11;
        object.clear();
        while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
            Object e10 = object2.next();
            n10 = (int)(object.add(e10) ? 1 : 0);
            if (n10 == 0) continue;
            this.totalSize = n10 = this.totalSize + 1;
        }
        return this.unmodifiableCollectionSubclass(collection);
    }

    public final void setMap(Map object) {
        this.map = object;
        int n10 = 0;
        Collection collection = null;
        this.totalSize = 0;
        object = object.values().iterator();
        while ((n10 = object.hasNext()) != 0) {
            collection = (Collection)object.next();
            Preconditions.checkArgument(collection.isEmpty() ^ true);
            int n11 = this.totalSize;
            n10 = collection.size();
            this.totalSize = n11 += n10;
        }
    }

    public int size() {
        return this.totalSize;
    }

    public Collection unmodifiableCollectionSubclass(Collection collection) {
        return Collections.unmodifiableCollection(collection);
    }

    public Iterator valueIterator() {
        AbstractMapBasedMultimap$1 abstractMapBasedMultimap$1 = new AbstractMapBasedMultimap$1(this);
        return abstractMapBasedMultimap$1;
    }

    public Collection values() {
        return super.values();
    }

    public Collection wrapCollection(Object object, Collection collection) {
        AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection = new AbstractMapBasedMultimap$WrappedCollection(this, object, collection, null);
        return abstractMapBasedMultimap$WrappedCollection;
    }

    public final List wrapList(Object object, List list, AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection) {
        boolean bl2 = list instanceof RandomAccess;
        AbstractMapBasedMultimap$WrappedList abstractMapBasedMultimap$WrappedList = bl2 ? new AbstractMapBasedMultimap$RandomAccessWrappedList(this, object, list, abstractMapBasedMultimap$WrappedCollection) : new AbstractMapBasedMultimap$WrappedList(this, object, list, abstractMapBasedMultimap$WrappedCollection);
        return abstractMapBasedMultimap$WrappedList;
    }
}

