/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.PriorityDataSource;
import com.google.android.exoplayer2.util.PriorityTaskManager;

public final class PriorityDataSourceFactory
implements DataSource$Factory {
    private final int priority;
    private final PriorityTaskManager priorityTaskManager;
    private final DataSource$Factory upstreamFactory;

    public PriorityDataSourceFactory(DataSource$Factory dataSource$Factory, PriorityTaskManager priorityTaskManager, int n10) {
        this.upstreamFactory = dataSource$Factory;
        this.priorityTaskManager = priorityTaskManager;
        this.priority = n10;
    }

    public PriorityDataSource createDataSource() {
        DataSource dataSource = this.upstreamFactory.createDataSource();
        PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
        int n10 = this.priority;
        PriorityDataSource priorityDataSource = new PriorityDataSource(dataSource, priorityTaskManager, n10);
        return priorityDataSource;
    }
}

