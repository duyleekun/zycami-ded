/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.offline;

import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.source.dash.DashUtil;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.offline.DashDownloader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.RunnableFutureTask;

public class DashDownloader$1
extends RunnableFutureTask {
    public final /* synthetic */ DataSource val$dataSource;
    public final /* synthetic */ Representation val$representation;
    public final /* synthetic */ int val$trackType;

    public DashDownloader$1(DashDownloader dashDownloader, DataSource dataSource, int n10, Representation representation) {
        this.val$dataSource = dataSource;
        this.val$trackType = n10;
        this.val$representation = representation;
    }

    public ChunkIndex doWork() {
        DataSource dataSource = this.val$dataSource;
        int n10 = this.val$trackType;
        Representation representation = this.val$representation;
        return DashUtil.loadChunkIndex(dataSource, n10, representation);
    }
}

