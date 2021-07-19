/*
 * Decompiled with CFR 0.151.
 */
package androidx.collection;

import androidx.collection.MapCollections;
import androidx.collection.MapCollections$ArrayIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class MapCollections$KeySet
implements Set {
    public final /* synthetic */ MapCollections this$0;

    public MapCollections$KeySet(MapCollections mapCollections) {
        this.this$0 = mapCollections;
    }

    public boolean add(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean addAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void clear() {
        this.this$0.colClear();
    }

    public boolean contains(Object object) {
        MapCollections mapCollections = this.this$0;
        int n10 = mapCollections.colIndexOfKey(object);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public boolean containsAll(Collection collection) {
        return MapCollections.containsAllHelper(this.this$0.colGetMap(), collection);
    }

    public boolean equals(Object object) {
        return MapCollections.equalsSetHelper(this, object);
    }

    public int hashCode() {
        MapCollections mapCollections = this.this$0;
        int n10 = 0;
        for (int i10 = mapCollections.colGetSize() + -1; i10 >= 0; i10 += -1) {
            int n11;
            Object object = this.this$0.colGetEntry(i10, 0);
            if (object == null) {
                n11 = 0;
                object = null;
            } else {
                n11 = object.hashCode();
            }
            n10 += n11;
        }
        return n10;
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
        MapCollections$ArrayIterator mapCollections$ArrayIterator = new MapCollections$ArrayIterator(mapCollections, 0);
        return mapCollections$ArrayIterator;
    }

    public boolean remove(Object object) {
        MapCollections mapCollections = this.this$0;
        int n10 = mapCollections.colIndexOfKey(object);
        if (n10 >= 0) {
            this.this$0.colRemoveAt(n10);
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection collection) {
        return MapCollections.removeAllHelper(this.this$0.colGetMap(), collection);
    }

    public boolean retainAll(Collection collection) {
        return MapCollections.retainAllHelper(this.this$0.colGetMap(), collection);
    }

    public int size() {
        return this.this$0.colGetSize();
    }

    public Object[] toArray() {
        return this.this$0.toArrayHelper(0);
    }

    public Object[] toArray(Object[] objectArray) {
        return this.this$0.toArrayHelper(objectArray, 0);
    }
}

