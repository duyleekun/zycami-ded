/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$InternalEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$WeakKeyStrongValueEntry;
import java.lang.ref.ReferenceQueue;

public final class MapMakerInternalMap$WeakKeyStrongValueSegment
extends MapMakerInternalMap$Segment {
    private final ReferenceQueue queueForKeys;

    public MapMakerInternalMap$WeakKeyStrongValueSegment(MapMakerInternalMap referenceQueue, int n10, int n11) {
        super((MapMakerInternalMap)((Object)referenceQueue), n10, n11);
        this.queueForKeys = referenceQueue = new ReferenceQueue();
    }

    public static /* synthetic */ ReferenceQueue access$300(MapMakerInternalMap$WeakKeyStrongValueSegment mapMakerInternalMap$WeakKeyStrongValueSegment) {
        return mapMakerInternalMap$WeakKeyStrongValueSegment.queueForKeys;
    }

    public MapMakerInternalMap$WeakKeyStrongValueEntry castForTesting(MapMakerInternalMap$InternalEntry mapMakerInternalMap$InternalEntry) {
        return (MapMakerInternalMap$WeakKeyStrongValueEntry)mapMakerInternalMap$InternalEntry;
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

    public MapMakerInternalMap$WeakKeyStrongValueSegment self() {
        return this;
    }
}

