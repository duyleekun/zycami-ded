/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import java.io.Closeable;

public abstract class TransportRuntimeComponent
implements Closeable {
    public void close() {
        this.getEventStore().close();
    }

    public abstract EventStore getEventStore();

    public abstract TransportRuntime getTransportRuntime();
}

