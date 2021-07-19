/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsMediaFileVideoRetriever;
import com.meicam.sdk.NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback;

public class NvsMediaFileVideoRetriever$2
implements Runnable {
    public final /* synthetic */ NvsMediaFileVideoRetriever this$0;
    public final /* synthetic */ int val$errorCode;
    public final /* synthetic */ NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback val$retrieverCallback;
    public final /* synthetic */ long val$taskId;

    public NvsMediaFileVideoRetriever$2(NvsMediaFileVideoRetriever nvsMediaFileVideoRetriever, NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback, long l10, int n10) {
        this.this$0 = nvsMediaFileVideoRetriever;
        this.val$retrieverCallback = nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback;
        this.val$taskId = l10;
        this.val$errorCode = n10;
    }

    public void run() {
        NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback = this.val$retrieverCallback;
        long l10 = this.val$taskId;
        int n10 = this.val$errorCode;
        nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback.notifyFinsih(l10, n10);
    }
}

