/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileCallback;

public class DownLoadHelper$7
implements DownLoadHelper$OnDownloadFileCallback {
    public boolean bCancel = false;
    public boolean bFail = false;
    public int countFinish;
    public final /* synthetic */ DownLoadHelper this$0;
    public final /* synthetic */ boolean val$bCallbackSwitchToMainThread;
    public final /* synthetic */ DownLoadHelper$OnDownloadFileCallback val$callback;
    public final /* synthetic */ int val$countTotal;

    public DownLoadHelper$7(DownLoadHelper downLoadHelper, DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback, boolean bl2, int n10) {
        this.this$0 = downLoadHelper;
        this.val$callback = downLoadHelper$OnDownloadFileCallback;
        this.val$bCallbackSwitchToMainThread = bl2;
        this.val$countTotal = n10;
    }

    private void callResult() {
        int n10;
        this.countFinish = n10 = this.countFinish + 1;
        DownLoadHelper downLoadHelper = this.this$0;
        DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback = this.val$callback;
        boolean bl2 = this.val$bCallbackSwitchToMainThread;
        DownLoadHelper.access$800(downLoadHelper, n10, downLoadHelper$OnDownloadFileCallback, bl2);
        n10 = this.val$countTotal;
        int n11 = this.countFinish;
        if (n10 == n11) {
            n10 = (int)(this.bFail ? 1 : 0);
            n11 = 0;
            downLoadHelper = null;
            if (n10 != 0) {
                DownLoadHelper downLoadHelper2 = this.this$0;
                downLoadHelper$OnDownloadFileCallback = this.val$callback;
                bl2 = this.val$bCallbackSwitchToMainThread;
                DownLoadHelper.access$200(downLoadHelper2, null, downLoadHelper$OnDownloadFileCallback, bl2);
            } else {
                DownLoadHelper downLoadHelper3 = this.this$0;
                downLoadHelper$OnDownloadFileCallback = this.val$callback;
                bl2 = this.val$bCallbackSwitchToMainThread;
                DownLoadHelper.access$400(downLoadHelper3, null, downLoadHelper$OnDownloadFileCallback, bl2);
            }
        }
    }

    public void cancel() {
        boolean bl2 = this.bCancel;
        if (!bl2) {
            DownLoadHelper downLoadHelper = this.this$0;
            DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback = this.val$callback;
            boolean bl3 = this.val$bCallbackSwitchToMainThread;
            DownLoadHelper.access$600(downLoadHelper, downLoadHelper$OnDownloadFileCallback, bl3);
        }
        this.bCancel = true;
    }

    public void downloadCount(int n10) {
    }

    public void downloadFailed(Throwable throwable) {
        this.bFail = true;
        this.callResult();
    }

    public void downloadProgress(int n10) {
        DownLoadHelper downLoadHelper = this.this$0;
        DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback = this.val$callback;
        boolean bl2 = this.val$bCallbackSwitchToMainThread;
        DownLoadHelper.access$700(downLoadHelper, n10, downLoadHelper$OnDownloadFileCallback, bl2);
    }

    public void downloadSuccess(String string2) {
        this.callResult();
    }

    public void saveFailed(Throwable throwable) {
        this.bFail = true;
        this.callResult();
    }
}

