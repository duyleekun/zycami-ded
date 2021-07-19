/*
 * Decompiled with CFR 0.151.
 */
package androidx.collection;

import androidx.collection.ContainerHelpers;
import androidx.collection.MapCollections;
import androidx.collection.MapCollections$MapIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class MapCollections$EntrySet
implements Set {
    public final /* synthetic */ MapCollections this$0;

    public MapCollections$EntrySet(MapCollections mapCollections) {
        this.this$0 = mapCollections;
    }

    public boolean add(Map.Entry object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean addAll(Collection object) {
        boolean bl2;
        MapCollections mapCollections = this.this$0;
        int n10 = mapCollections.colGetSize();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            MapCollections mapCollections2 = this.this$0;
            Object k10 = entry.getKey();
            entry = entry.getValue();
            mapCollections2.colPut(k10, entry);
        }
        object = this.this$0;
        int n11 = ((MapCollections)object).colGetSize();
        if (n10 != n11) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11 != 0;
    }

    public void clear() {
        this.this$0.colClear();
    }

    public boolean contains(Object object) {
        int n10 = object instanceof Map.Entry;
        if (n10 == 0) {
            return false;
        }
        Object object2 = this.this$0;
        Object k10 = (object = (Map.Entry)object).getKey();
        n10 = ((MapCollections)object2).colIndexOfKey(k10);
        if (n10 < 0) {
            return false;
        }
        object2 = this.this$0.colGetEntry(n10, 1);
        object = object.getValue();
        return ContainerHelpers.equal(object2, object);
    }

    public boolean containsAll(Collection object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            bl2 = this.contains(e10);
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public boolean equals(Object object) {
        return MapCollections.equalsSetHelper(this, object);
    }

    public int hashCode() {
        MapCollections mapCollections = this.this$0;
        int n10 = mapCollections.colGetSize();
        int n11 = 1;
        n10 -= n11;
        int n12 = 0;
        while (n10 >= 0) {
            int n13;
            int n14;
            Object object = this.this$0.colGetEntry(n10, 0);
            Object object2 = this.this$0.colGetEntry(n10, n11);
            if (object == null) {
                n14 = 0;
                object = null;
            } else {
                n14 = object.hashCode();
            }
            if (object2 == null) {
                n13 = 0;
                object2 = null;
            } else {
                n13 = object2.hashCode();
            }
            n12 += (n14 ^= n13);
            n10 += -1;
        }
        return n12;
    }

    public boolean isEmpty() {
        MapCollections mapCollections = this.this$0;
        int n10 = mapCollections.colGetSize();
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            mapCollections = null;
        }
        return n10 != 0;
    }

    public Iterator iterator() {
        MapCollections mapCollections = this.this$0;
        MapCollections$MapIterator mapCollections$MapIterator = new MapCollections$MapIterator(mapCollections);
        return mapCollections$MapIterator;
    }

    public boolean remove(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean removeAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean retainAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public int size() {
        return this.this$0.colGetSize();
    }

    public Object[] toArray() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public Object[] toArray(Object[] object) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

