/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsMediaFileConvertor;
import com.meicam.sdk.NvsMediaFileConvertor$MeidaFileConvertorCallback;

public class NvsMediaFileConvertor$1
implements Runnable {
    public final /* synthetic */ NvsMediaFileConvertor this$0;
    public final /* synthetic */ NvsMediaFileConvertor$MeidaFileConvertorCallback val$convertCallback;
    public final /* synthetic */ float val$progress;
    public final /* synthetic */ long val$taskId;

    public NvsMediaFileConvertor$1(NvsMediaFileConvertor nvsMediaFileConvertor, NvsMediaFileConvertor$MeidaFileConvertorCallback nvsMediaFileConvertor$MeidaFileConvertorCallback, long l10, float f10) {
        this.this$0 = nvsMediaFileConvertor;
        this.val$convertCallback = nvsMediaFileConvertor$MeidaFileConvertorCallback;
        this.val$taskId = l10;
        this.val$progress = f10;
    }

    public void run() {
        NvsMediaFileConvertor$MeidaFileConvertorCallback nvsMediaFileConvertor$MeidaFileConvertorCallback = this.val$convertCallback;
        long l10 = this.val$taskId;
        float f10 = this.val$progress;
        nvsMediaFileConvertor$MeidaFileConvertorCallback.onProgress(l10, f10);
    }
}

