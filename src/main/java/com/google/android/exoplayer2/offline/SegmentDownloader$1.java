/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import com.google.android.exoplayer2.util.RunnableFutureTask;

public class SegmentDownloader$1
extends RunnableFutureTask {
    public final /* synthetic */ SegmentDownloader this$0;
    public final /* synthetic */ DataSource val$dataSource;
    public final /* synthetic */ DataSpec val$dataSpec;

    public SegmentDownloader$1(SegmentDownloader segmentDownloader, DataSource dataSource, DataSpec dataSpec) {
        this.this$0 = segmentDownloader;
        this.val$dataSource = dataSource;
        this.val$dataSpec = dataSpec;
    }

    public FilterableManifest doWork() {
        DataSource dataSource = this.val$dataSource;
        ParsingLoadable$Parser parsingLoadable$Parser = SegmentDownloader.access$000(this.this$0);
        DataSpec dataSpec = this.val$dataSpec;
        return (FilterableManifest)ParsingLoadable.load(dataSource, parsingLoadable$Parser, dataSpec, 4);
    }
}

