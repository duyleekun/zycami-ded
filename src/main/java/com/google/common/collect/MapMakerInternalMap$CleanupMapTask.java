/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$Segment;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;

public final class MapMakerInternalMap$CleanupMapTask
implements Runnable {
    public final WeakReference mapReference;

    public MapMakerInternalMap$CleanupMapTask(MapMakerInternalMap mapMakerInternalMap) {
        WeakReference<MapMakerInternalMap> weakReference;
        this.mapReference = weakReference = new WeakReference<MapMakerInternalMap>(mapMakerInternalMap);
    }

    public void run() {
        MapMakerInternalMap object = (MapMakerInternalMap)this.mapReference.get();
        if (object != null) {
            for (MapMakerInternalMap$Segment mapMakerInternalMap$Segment : object.segments) {
                mapMakerInternalMap$Segment.runCleanup();
            }
            return;
        }
        CancellationException cancellationException = new CancellationException();
        throw cancellationException;
    }
}

