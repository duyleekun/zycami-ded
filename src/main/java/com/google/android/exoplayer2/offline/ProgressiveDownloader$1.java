/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.ProgressiveDownloader;
import com.google.android.exoplayer2.util.RunnableFutureTask;

public class ProgressiveDownloader$1
extends RunnableFutureTask {
    public final /* synthetic */ ProgressiveDownloader this$0;

    public ProgressiveDownloader$1(ProgressiveDownloader progressiveDownloader) {
        this.this$0 = progressiveDownloader;
    }

    public void cancelWork() {
        ProgressiveDownloader.access$000(this.this$0).cancel();
    }

    public Void doWork() {
        ProgressiveDownloader.access$000(this.this$0).cache();
        return null;
    }
}

