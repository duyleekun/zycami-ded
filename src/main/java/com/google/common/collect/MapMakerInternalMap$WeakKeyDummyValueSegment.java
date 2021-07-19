/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$InternalEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$WeakKeyDummyValueEntry;
import java.lang.ref.ReferenceQueue;

public final class MapMakerInternalMap$WeakKeyDummyValueSegment
extends MapMakerInternalMap$Segment {
    private final ReferenceQueue queueForKeys;

    public MapMakerInternalMap$WeakKeyDummyValueSegment(MapMakerInternalMap referenceQueue, int n10, int n11) {
        super((MapMakerInternalMap)((Object)referenceQueue), n10, n11);
        this.queueForKeys = referenceQueue = new ReferenceQueue();
    }

    public static /* synthetic */ ReferenceQueue access$200(MapMakerInternalMap$WeakKeyDummyValueSegment mapMakerInternalMap$WeakKeyDummyValueSegment) {
        return mapMakerInternalMap$WeakKeyDummyValueSegment.queueForKeys;
    }

    public MapMakerInternalMap$WeakKeyDummyValueEntry castForTesting(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry) {
        return (MapMakerInternalMap$WeakKeyDummyValueEntry)mapMakerInternalMap$InternalEntry;
    }

    public ReferenceQueue getKeyReferenceQueueForTesting() {
        return this.queueForKeys;
    }

    public void maybeClearReferenceQueues() {
        ReferenceQueue referenceQueue = this.queueForKeys;
        this.clearReferenceQueue(referenceQueue);
    }

    public void maybeDrainReferenceQueues() {
        ReferenceQueue referenceQueue = this.queueForKeys;
        this.drainKeyReferenceQueue(referenceQueue);
    }

    public MapMakerInternalMap$WeakKeyDummyValueSegment self() {
        return this;
    }
}

