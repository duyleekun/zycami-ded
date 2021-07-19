/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$InternalEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$WriteThroughEntry;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

public abstract class MapMakerInternalMap$HashIterator
implements Iterator {
    public MapMakerInternalMap$Segment currentSegment;
    public AtomicReferenceArray currentTable;
    public MapMakerInternalMap$WriteThroughEntry lastReturned;
    public MapMakerInternalMap$InternalEntry nextEntry;
    public MapMakerInternalMap$WriteThroughEntry nextExternal;
    public int nextSegmentIndex;
    public int nextTableIndex;
    public final /* synthetic */ MapMakerInternalMap this$0;

    public MapMakerInternalMap$HashIterator(MapMakerInternalMap mapMakerInternalMap) {
        int n10;
        this.this$0 = mapMakerInternalMap;
        this.nextSegmentIndex = n10 = mapMakerInternalMap.segments.length + -1;
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
            MapMakerInternalMap$Segment[] mapMakerInternalMap$SegmentArray = this.this$0.segments;
            this.nextSegmentIndex = n11 = n10 + -1;
            serializable = mapMakerInternalMap$SegmentArray[n10];
            this.currentSegment = serializable;
            n10 = ((MapMakerInternalMap$Segment)serializable).count;
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
    public boolean advanceTo(MapMakerInternalMap$InternalEntry object) {
        try {
            boolean bl2;
            Object object2 = object.getKey();
            Object object3 = this.this$0;
            object = ((MapMakerInternalMap)object3).getLiveValue((MapMakerInternalMap$InternalEntry)object);
            if (object != null) {
                MapMakerInternalMap mapMakerInternalMap = this.this$0;
                this.nextExternal = object3 = new MapMakerInternalMap$WriteThroughEntry(mapMakerInternalMap, object2, object);
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
        MapMakerInternalMap$WriteThroughEntry mapMakerInternalMap$WriteThroughEntry = this.nextExternal;
        if (mapMakerInternalMap$WriteThroughEntry != null) {
            bl2 = true;
        } else {
            bl2 = false;
            mapMakerInternalMap$WriteThroughEntry = null;
        }
        return bl2;
    }

    public abstract Object next();

    public MapMakerInternalMap$WriteThroughEntry nextEntry() {
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
        MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry = this.nextEntry;
        if (mapMakerInternalMap$InternalEntry != null) {
            while ((mapMakerInternalMap$InternalEntry = (this.nextEntry = (mapMakerInternalMap$InternalEntry = mapMakerInternalMap$InternalEntry.getNext()))) != null) {
                boolean bl2 = this.advanceTo(mapMakerInternalMap$InternalEntry);
                if (bl2) {
                    return true;
                }
                mapMakerInternalMap$InternalEntry = this.nextEntry;
            }
        }
        return false;
    }

    public boolean nextInTable() {
        int n10;
        while ((n10 = this.nextTableIndex) >= 0) {
            MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry;
            int n11;
            AtomicReferenceArray atomicReferenceArray = this.currentTable;
            this.nextTableIndex = n11 = n10 + -1;
            this.nextEntry = mapMakerInternalMap$InternalEntry = (MapMakerInternalMap$InternalEntry)atomicReferenceArray.get(n10);
            if (mapMakerInternalMap$InternalEntry == null || (n10 = (int)(this.advanceTo(mapMakerInternalMap$InternalEntry) ? 1 : 0)) == 0 && (n10 = (int)(this.nextInChain() ? 1 : 0)) == 0) continue;
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
        CollectPreconditions.checkRemove(bl2);
        object = this.this$0;
        Object object2 = this.lastReturned.getKey();
        ((MapMakerInternalMap)object).remove(object2);
        this.lastReturned = null;
    }
}

