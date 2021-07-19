/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsMediaFileVideoRetriever;
import com.meicam.sdk.NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback;

public class NvsMediaFileVideoRetriever$1
implements Runnable {
    public final /* synthetic */ NvsMediaFileVideoRetriever this$0;
    public final /* synthetic */ float val$progress;
    public final /* synthetic */ NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback val$retrieverCallback;
    public final /* synthetic */ long val$taskId;

    public NvsMediaFileVideoRetriever$1(NvsMediaFileVideoRetriever nvsMediaFileVideoRetriever, NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback meidaFileVideoRetrieverCallback, long l10, float f10) {
        this.this$0 = nvsMediaFileVideoRetriever;
        this.val$retrieverCallback = meidaFileVideoRetrieverCallback;
        this.val$taskId = l10;
        this.val$progress = f10;
    }

    public void run() {
        NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback = this.val$retrieverCallback;
        long l10 = this.val$taskId;
        float f10 = this.val$progress;
        nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback.notifyProgress(l10, f10);
    }
}

