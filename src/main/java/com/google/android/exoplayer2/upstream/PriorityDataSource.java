/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.util.Map;

public final class PriorityDataSource
implements DataSource {
    private final int priority;
    private final PriorityTaskManager priorityTaskManager;
    private final DataSource upstream;

    public PriorityDataSource(DataSource object, PriorityTaskManager priorityTaskManager, int n10) {
        object = (DataSource)Assertions.checkNotNull(object);
        this.upstream = object;
        this.priorityTaskManager = object = (PriorityTaskManager)Assertions.checkNotNull(priorityTaskManager);
        this.priority = n10;
    }

    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.upstream.addTransferListener(transferListener);
    }

    public void close() {
        this.upstream.close();
    }

    public Map getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    public Uri getUri() {
        return this.upstream.getUri();
    }

    public long open(DataSpec dataSpec) {
        PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
        int n10 = this.priority;
        priorityTaskManager.proceedOrThrow(n10);
        return this.upstream.open(dataSpec);
    }

    public int read(byte[] byArray, int n10, int n11) {
        PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
        int n12 = this.priority;
        priorityTaskManager.proceedOrThrow(n12);
        return this.upstream.read(byArray, n10, n11);
    }
}

