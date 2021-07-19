/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsMediaFileConvertor;
import com.meicam.sdk.NvsMediaFileConvertor$MeidaFileConvertorCallback;

public class NvsMediaFileConvertor$2
implements Runnable {
    public final /* synthetic */ NvsMediaFileConvertor this$0;
    public final /* synthetic */ NvsMediaFileConvertor$MeidaFileConvertorCallback val$convertCallback;
    public final /* synthetic */ String val$dstFile;
    public final /* synthetic */ int val$errorCode;
    public final /* synthetic */ String val$srcFile;
    public final /* synthetic */ long val$taskId;

    public NvsMediaFileConvertor$2(NvsMediaFileConvertor nvsMediaFileConvertor, NvsMediaFileConvertor$MeidaFileConvertorCallback nvsMediaFileConvertor$MeidaFileConvertorCallback, long l10, String string2, String string3, int n10) {
        this.this$0 = nvsMediaFileConvertor;
        this.val$convertCallback = nvsMediaFileConvertor$MeidaFileConvertorCallback;
        this.val$taskId = l10;
        this.val$srcFile = string2;
        this.val$dstFile = string3;
        this.val$errorCode = n10;
    }

    public void run() {
        NvsMediaFileConvertor$MeidaFileConvertorCallback nvsMediaFileConvertor$MeidaFileConvertorCallback = this.val$convertCallback;
        long l10 = this.val$taskId;
        String string2 = this.val$srcFile;
        String string3 = this.val$dstFile;
        int n10 = this.val$errorCode;
        nvsMediaFileConvertor$MeidaFileConvertorCallback.onFinish(l10, string2, string3, n10);
    }
}

