/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$WriteThroughEntry;
import com.google.common.cache.ReferenceEntry;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

public abstract class LocalCache$HashIterator
implements Iterator {
    public LocalCache$Segment currentSegment;
    public AtomicReferenceArray currentTable;
    public LocalCache$WriteThroughEntry lastReturned;
    public ReferenceEntry nextEntry;
    public LocalCache$WriteThroughEntry nextExternal;
    public int nextSegmentIndex;
    public int nextTableIndex;
    public final /* synthetic */ LocalCache this$0;

    public LocalCache$HashIterator(LocalCache localCache) {
        int n10;
        this.this$0 = localCache;
        this.nextSegmentIndex = n10 = localCache.segments.length + -1;
        this.nextTableIndex = -1;
        this.advance();
    }

    public final void advance() {
        Serializable serializable = null;
        this.nextExternal = null;
        int n10 = this.nextInChain();
        if (n10 != 0) {
            return;
        }
        n10 = this.nextInTable();
        if (n10 != 0) {
            return;
        }
        while ((n10 = this.nextSegmentIndex) >= 0) {
            int n11;
            LocalCache$Segment[] localCache$SegmentArray = this.this$0.segments;
            this.nextSegmentIndex = n11 = n10 + -1;
            serializable = localCache$SegmentArray[n10];
            this.currentSegment = serializable;
            n10 = ((LocalCache$Segment)serializable).count;
            if (n10 == 0) continue;
            serializable = this.currentSegment.table;
            this.currentTable = serializable;
            this.nextTableIndex = n10 = ((AtomicReferenceArray)serializable).length() + -1;
            n10 = (int)(this.nextInTable() ? 1 : 0);
            if (n10 == 0) continue;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean advanceTo(ReferenceEntry object) {
        try {
            boolean bl2;
            Object object2 = this.this$0;
            object2 = ((LocalCache)object2).ticker;
            long l10 = ((Ticker)object2).read();
            Object object3 = object.getKey();
            LocalCache localCache = this.this$0;
            object = localCache.getLiveValue((ReferenceEntry)object, l10);
            if (object != null) {
                LocalCache localCache2 = this.this$0;
                this.nextExternal = object2 = new LocalCache$WriteThroughEntry(localCache2, object3, object);
                bl2 = true;
                return bl2;
            } else {
                bl2 = false;
                object = null;
            }
            return bl2;
        }
        finally {
            this.currentSegment.postReadCleanup();
        }
    }

    public boolean hasNext() {
        boolean bl2;
        LocalCache$WriteThroughEntry localCache$WriteThroughEntry = this.nextExternal;
        if (localCache$WriteThroughEntry != null) {
            bl2 = true;
        } else {
            bl2 = false;
            localCache$WriteThroughEntry = null;
        }
        return bl2;
    }

    public abstract Object next();

    public LocalCache$WriteThroughEntry nextEntry() {
        Object object = this.nextExternal;
        if (object != null) {
            this.lastReturned = object;
            this.advance();
            return this.lastReturned;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public boolean nextInChain() {
        ReferenceEntry referenceEntry = this.nextEntry;
        if (referenceEntry != null) {
            while ((referenceEntry = (this.nextEntry = (referenceEntry = referenceEntry.getNext()))) != null) {
                boolean bl2 = this.advanceTo(referenceEntry);
                if (bl2) {
                    return true;
                }
                referenceEntry = this.nextEntry;
            }
        }
        return false;
    }

    public boolean nextInTable() {
        int n10;
        while ((n10 = this.nextTableIndex) >= 0) {
            ReferenceEntry referenceEntry;
            int n11;
            AtomicReferenceArray atomicReferenceArray = this.currentTable;
            this.nextTableIndex = n11 = n10 + -1;
            this.nextEntry = referenceEntry = (ReferenceEntry)atomicReferenceArray.get(n10);
            if (referenceEntry == null || (n10 = (int)(this.advanceTo(referenceEntry) ? 1 : 0)) == 0 && (n10 = (int)(this.nextInChain() ? 1 : 0)) == 0) continue;
            return true;
        }
        return false;
    }

    public void remove() {
        boolean bl2;
        Object object = this.lastReturned;
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Preconditions.checkState(bl2);
        object = this.this$0;
        Object object2 = this.lastReturned.getKey();
        ((LocalCache)object).remove(object2);
        this.lastReturned = null;
    }
}

