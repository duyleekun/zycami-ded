/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import java.io.Closeable;

public interface EventStore
extends Closeable {
    public int cleanUp();

    public long getNextCallTime(TransportContext var1);

    public boolean hasPendingEventsFor(TransportContext var1);

    public Iterable loadActiveContexts();

    public Iterable loadBatch(TransportContext var1);

    public PersistedEvent persist(TransportContext var1, EventInternal var2);

    public void recordFailure(Iterable var1);

    public void recordNextCallTime(TransportContext var1, long var2);

    public void recordSuccess(Iterable var1);
}

