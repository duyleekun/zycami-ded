/*
 * Decompiled with CFR 0.151.
 */
package androidx.collection;

import androidx.collection.MapCollections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class MapCollections$ArrayIterator
implements Iterator {
    public boolean mCanRemove = false;
    public int mIndex;
    public final int mOffset;
    public int mSize;
    public final /* synthetic */ MapCollections this$0;

    public MapCollections$ArrayIterator(MapCollections mapCollections, int n10) {
        int n11;
        this.this$0 = mapCollections;
        this.mOffset = n10;
        this.mSize = n11 = mapCollections.colGetSize();
    }

    public boolean hasNext() {
        int n10 = this.mIndex;
        int n11 = this.mSize;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public Object next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            Object object = this.this$0;
            int n10 = this.mIndex;
            int n11 = this.mOffset;
            object = ((MapCollections)object).colGetEntry(n10, n11);
            n10 = this.mIndex;
            n11 = 1;
            this.mIndex = n10 += n11;
            this.mCanRemove = n11;
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        int n10 = this.mCanRemove;
        if (n10 != 0) {
            int n11;
            this.mIndex = n10 = this.mIndex + -1;
            this.mSize = n11 = this.mSize + -1;
            this.mCanRemove = false;
            this.this$0.colRemoveAt(n10);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }
}

