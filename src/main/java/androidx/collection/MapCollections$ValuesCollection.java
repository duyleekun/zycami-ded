/*
 * Decompiled with CFR 0.151.
 */
package androidx.collection;

import androidx.collection.MapCollections;
import androidx.collection.MapCollections$ArrayIterator;
import java.util.Collection;
import java.util.Iterator;

public final class MapCollections$ValuesCollection
implements Collection {
    public final /* synthetic */ MapCollections this$0;

    public MapCollections$ValuesCollection(MapCollections mapCollections) {
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
        int n10 = mapCollections.colIndexOfValue(object);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
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
        MapCollections$ArrayIterator mapCollections$ArrayIterator = new MapCollections$ArrayIterator(mapCollections, 1);
        return mapCollections$ArrayIterator;
    }

    public boolean remove(Object object) {
        MapCollections mapCollections = this.this$0;
        int n10 = mapCollections.colIndexOfValue(object);
        if (n10 >= 0) {
            this.this$0.colRemoveAt(n10);
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection collection) {
        int n10;
        MapCollections mapCollections = this.this$0;
        int n11 = mapCollections.colGetSize();
        int n12 = 0;
        MapCollections mapCollections2 = null;
        for (int i10 = 0; i10 < n11; i10 += n10) {
            Object object = this.this$0;
            n10 = 1;
            boolean bl2 = collection.contains(object = ((MapCollections)object).colGetEntry(i10, n10));
            if (!bl2) continue;
            mapCollections2 = this.this$0;
            mapCollections2.colRemoveAt(i10);
            i10 += -1;
            n11 += -1;
            n12 = n10;
        }
        return n12 != 0;
    }

    public boolean retainAll(Collection collection) {
        int n10;
        MapCollections mapCollections = this.this$0;
        int n11 = mapCollections.colGetSize();
        int n12 = 0;
        MapCollections mapCollections2 = null;
        for (int i10 = 0; i10 < n11; i10 += n10) {
            Object object = this.this$0;
            n10 = 1;
            boolean bl2 = collection.contains(object = ((MapCollections)object).colGetEntry(i10, n10));
            if (bl2) continue;
            mapCollections2 = this.this$0;
            mapCollections2.colRemoveAt(i10);
            i10 += -1;
            n11 += -1;
            n12 = n10;
        }
        return n12 != 0;
    }

    public int size() {
        return this.this$0.colGetSize();
    }

    public Object[] toArray() {
        return this.this$0.toArrayHelper(1);
    }

    public Object[] toArray(Object[] objectArray) {
        return this.this$0.toArrayHelper(objectArray, 1);
    }
}

