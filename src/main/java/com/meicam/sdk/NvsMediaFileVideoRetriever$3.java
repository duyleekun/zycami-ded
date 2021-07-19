/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsMediaFileVideoRetriever;
import com.meicam.sdk.NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback;
import java.nio.ByteBuffer;

public class NvsMediaFileVideoRetriever$3
implements Runnable {
    public final /* synthetic */ NvsMediaFileVideoRetriever this$0;
    public final /* synthetic */ ByteBuffer val$data;
    public final /* synthetic */ int val$height;
    public final /* synthetic */ NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback val$retrieverCallback;
    public final /* synthetic */ int val$rotation;
    public final /* synthetic */ long val$taskId;
    public final /* synthetic */ int val$videoFrameSize;
    public final /* synthetic */ int val$width;

    public NvsMediaFileVideoRetriever$3(NvsMediaFileVideoRetriever nvsMediaFileVideoRetriever, NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback, long l10, ByteBuffer byteBuffer, int n10, int n11, int n12, int n13) {
        this.this$0 = nvsMediaFileVideoRetriever;
        this.val$retrieverCallback = nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback;
        this.val$taskId = l10;
        this.val$data = byteBuffer;
        this.val$width = n10;
        this.val$height = n11;
        this.val$rotation = n12;
        this.val$videoFrameSize = n13;
    }

    public void run() {
        NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback = this.val$retrieverCallback;
        long l10 = this.val$taskId;
        ByteBuffer byteBuffer = this.val$data;
        int n10 = this.val$width;
        int n11 = this.val$height;
        int n12 = this.val$rotation;
        int n13 = this.val$videoFrameSize;
        nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback.notifySengmentData(l10, byteBuffer, n10, n11, n12, n13);
    }
}

