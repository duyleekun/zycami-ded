/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsMediaFileConvertor;
import com.meicam.sdk.NvsMediaFileConvertor$MeidaFileConvertorCallback;

public class NvsMediaFileConvertor$3
implements Runnable {
    public final /* synthetic */ NvsMediaFileConvertor this$0;
    public final /* synthetic */ NvsMediaFileConvertor$MeidaFileConvertorCallback val$convertCallback;
    public final /* synthetic */ long val$endPts;
    public final /* synthetic */ long val$startPts;
    public final /* synthetic */ long val$taskId;

    public NvsMediaFileConvertor$3(NvsMediaFileConvertor nvsMediaFileConvertor, NvsMediaFileConvertor$MeidaFileConvertorCallback nvsMediaFileConvertor$MeidaFileConvertorCallback, long l10, long l11, long l12) {
        this.this$0 = nvsMediaFileConvertor;
        this.val$convertCallback = nvsMediaFileConvertor$MeidaFileConvertorCallback;
        this.val$taskId = l10;
        this.val$startPts = l11;
        this.val$endPts = l12;
    }

    public void run() {
        NvsMediaFileConvertor$MeidaFileConvertorCallback nvsMediaFileConvertor$MeidaFileConvertorCallback = this.val$convertCallback;
        long l10 = this.val$taskId;
        long l11 = this.val$startPts;
        long l12 = this.val$endPts;
        nvsMediaFileConvertor$MeidaFileConvertorCallback.notifyAudioMuteRage(l10, l11, l12);
    }
}

