/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$InternalEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$StrongKeyWeakValueEntry;
import com.google.common.collect.MapMakerInternalMap$WeakValueReference;
import com.google.common.collect.MapMakerInternalMap$WeakValueReferenceImpl;
import java.lang.ref.ReferenceQueue;

public final class MapMakerInternalMap$StrongKeyWeakValueSegment
extends MapMakerInternalMap$Segment {
    private final ReferenceQueue queueForValues;

    public MapMakerInternalMap$StrongKeyWeakValueSegment(MapMakerInternalMap referenceQueue, int n10, int n11) {
        super((MapMakerInternalMap)((Object)referenceQueue), n10, n11);
        this.queueForValues = referenceQueue = new ReferenceQueue();
    }

    public static /* synthetic */ ReferenceQueue access$100(MapMakerInternalMap$StrongKeyWeakValueSegment mapMakerInternalMap$StrongKeyWeakValueSegment) {
        return mapMakerInternalMap$StrongKeyWeakValueSegment.queueForValues;
    }

    public MapMakerInternalMap$StrongKeyWeakValueEntry castForTesting(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry) {
        return (MapMakerInternalMap$StrongKeyWeakValueEntry)mapMakerInternalMap$InternalEntry;
    }

    public ReferenceQueue getValueReferenceQueueForTesting() {
        return this.queueForValues;
    }

    public MapMakerInternalMap$WeakValueReference getWeakValueReferenceForTesting(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry) {
        return ((MapMakerInternalMap$StrongKeyWeakValueEntry)this.castForTesting(mapMakerInternalMap$InternalEntry)).getValueReference();
    }

    public void maybeClearReferenceQueues() {
        ReferenceQueue referenceQueue = this.queueForValues;
        this.clearReferenceQueue(referenceQueue);
    }

    public void maybeDrainReferenceQueues() {
        ReferenceQueue referenceQueue = this.queueForValues;
        this.drainValueReferenceQueue(referenceQueue);
    }

    public MapMakerInternalMap$WeakValueReference newWeakValueReferenceForTesting(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry, Object object) {
        ReferenceQueue referenceQueue = this.queueForValues;
        mapMakerInternalMap$InternalEntry = this.castForTesting(mapMakerInternalMap$InternalEntry);
        MapMakerInternalMap$WeakValueReferenceImpl mapMakerInternalMap$WeakValueReferenceImpl = new MapMakerInternalMap$WeakValueReferenceImpl(referenceQueue, object, mapMakerInternalMap$InternalEntry);
        return mapMakerInternalMap$WeakValueReferenceImpl;
    }

    public MapMakerInternalMap$StrongKeyWeakValueSegment self() {
        return this;
    }

    public void setWeakValueReferenceForTesting(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry, MapMakerInternalMap$WeakValueReference mapMakerInternalMap$WeakValueReference) {
        mapMakerInternalMap$InternalEntry = this.castForTesting(mapMakerInternalMap$InternalEntry);
        MapMakerInternalMap$WeakValueReference mapMakerInternalMap$WeakValueReference2 = MapMakerInternalMap$StrongKeyWeakValueEntry.access$600((MapMakerInternalMap$StrongKeyWeakValueEntry)mapMakerInternalMap$InternalEntry);
        MapMakerInternalMap$StrongKeyWeakValueEntry.access$602((MapMakerInternalMap$StrongKeyWeakValueEntry)mapMakerInternalMap$InternalEntry, mapMakerInternalMap$WeakValueReference);
        mapMakerInternalMap$WeakValueReference2.clear();
    }
}

