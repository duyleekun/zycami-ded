/*
 * Decompiled with CFR 0.151.
 */
package androidx.collection;

import androidx.collection.ContainerHelpers;
import androidx.collection.MapCollections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public final class MapCollections$MapIterator
implements Iterator,
Map.Entry {
    public int mEnd;
    public boolean mEntryValid = false;
    public int mIndex;
    public final /* synthetic */ MapCollections this$0;

    public MapCollections$MapIterator(MapCollections mapCollections) {
        int n10;
        this.this$0 = mapCollections;
        this.mEnd = n10 = mapCollections.colGetSize() + -1;
        this.mIndex = -1;
    }

    public boolean equals(Object object) {
        boolean bl2 = this.mEntryValid;
        if (bl2) {
            bl2 = object instanceof Map.Entry;
            int n10 = 0;
            if (!bl2) {
                return false;
            }
            object = (Map.Entry)object;
            Object object2 = object.getKey();
            Object object3 = this.this$0;
            int n11 = this.mIndex;
            object3 = ((MapCollections)object3).colGetEntry(n11, 0);
            bl2 = ContainerHelpers.equal(object2, object3);
            int n12 = 1;
            if (bl2) {
                object = object.getValue();
                object2 = this.this$0;
                n11 = this.mIndex;
                boolean bl3 = ContainerHelpers.equal(object, object2 = ((MapCollections)object2).colGetEntry(n11, n12));
                if (bl3) {
                    n10 = n12;
                }
            }
            return n10 != 0;
        }
        object = new IllegalStateException("This container does not support retaining Map.Entry objects");
        throw object;
    }

    public Object getKey() {
        boolean bl2 = this.mEntryValid;
        if (bl2) {
            MapCollections mapCollections = this.this$0;
            int n10 = this.mIndex;
            return mapCollections.colGetEntry(n10, 0);
        }
        IllegalStateException illegalStateException = new IllegalStateException("This container does not support retaining Map.Entry objects");
        throw illegalStateException;
    }

    public Object getValue() {
        boolean bl2 = this.mEntryValid;
        if (bl2) {
            MapCollections mapCollections = this.this$0;
            int n10 = this.mIndex;
            return mapCollections.colGetEntry(n10, 1);
        }
        IllegalStateException illegalStateException = new IllegalStateException("This container does not support retaining Map.Entry objects");
        throw illegalStateException;
    }

    public boolean hasNext() {
        int n10 = this.mIndex;
        int n11 = this.mEnd;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.mEntryValid;
        if (n10 != 0) {
            Object object = this.this$0;
            int n11 = this.mIndex;
            int n12 = 0;
            object = ((MapCollections)object).colGetEntry(n11, 0);
            Object object2 = this.this$0;
            int n13 = this.mIndex;
            int n14 = 1;
            object2 = ((MapCollections)object2).colGetEntry(n13, n14);
            if (object == null) {
                n10 = 0;
                object = null;
            } else {
                n10 = object.hashCode();
            }
            if (object2 != null) {
                n12 = object2.hashCode();
            }
            return n10 ^ n12;
        }
        IllegalStateException illegalStateException = new IllegalStateException("This container does not support retaining Map.Entry objects");
        throw illegalStateException;
    }

    public Map.Entry next() {
        int n10 = this.hasNext();
        if (n10 != 0) {
            n10 = this.mIndex;
            int n11 = 1;
            this.mIndex = n10 += n11;
            this.mEntryValid = n11;
            return this;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        int n10 = this.mEntryValid;
        if (n10 != 0) {
            MapCollections mapCollections = this.this$0;
            int n11 = this.mIndex;
            mapCollections.colRemoveAt(n11);
            this.mIndex = n10 = this.mIndex + -1;
            this.mEnd = n10 = this.mEnd + -1;
            this.mEntryValid = false;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    public Object setValue(Object object) {
        boolean bl2 = this.mEntryValid;
        if (bl2) {
            MapCollections mapCollections = this.this$0;
            int n10 = this.mIndex;
            return mapCollections.colSetValue(n10, object);
        }
        object = new IllegalStateException("This container does not support retaining Map.Entry objects");
        throw object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.getKey();
        stringBuilder.append(object);
        stringBuilder.append("=");
        object = this.getValue();
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}

