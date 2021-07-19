/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import com.zhiyun.net.api.entity.DownloadEntity;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileEntityCallback;
import java.util.List;

public class DownLoadHelper$9
implements DownLoadHelper$OnDownloadFileEntityCallback {
    public boolean bCancel = false;
    public int countFinish = 0;
    public int countTotal;
    public final /* synthetic */ DownLoadHelper this$0;
    public final /* synthetic */ boolean val$bCallbackSwitchToMainThread;
    public final /* synthetic */ DownLoadHelper$OnDownloadFileEntityCallback val$callback;
    public final /* synthetic */ List val$list;

    public DownLoadHelper$9(DownLoadHelper downLoadHelper, List list, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, boolean bl2) {
        int n10;
        this.this$0 = downLoadHelper;
        this.val$list = list;
        this.val$callback = downLoadHelper$OnDownloadFileEntityCallback;
        this.val$bCallbackSwitchToMainThread = bl2;
        this.countTotal = n10 = list.size();
    }

    private void callResult(DownloadEntity downloadEntity) {
        int n10;
        this.countFinish = n10 = this.countFinish + 1;
        DownLoadHelper downLoadHelper = this.this$0;
        int n11 = this.countTotal;
        DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback = this.val$callback;
        boolean bl2 = this.val$bCallbackSwitchToMainThread;
        DownLoadHelper.access$900(downLoadHelper, downloadEntity, n10, n11, downLoadHelper$OnDownloadFileEntityCallback, bl2);
    }

    public void cancel(DownloadEntity downloadEntity) {
        boolean bl2 = this.bCancel;
        if (!bl2) {
            DownLoadHelper downLoadHelper = this.this$0;
            DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback = this.val$callback;
            boolean bl3 = this.val$bCallbackSwitchToMainThread;
            DownLoadHelper.access$1400(downLoadHelper, downloadEntity, downLoadHelper$OnDownloadFileEntityCallback, bl3);
        }
        this.bCancel = true;
    }

    public void downloadCount(DownloadEntity downloadEntity, int n10, int n11) {
    }

    public void downloadFailed(DownloadEntity downloadEntity, Throwable throwable) {
        DownLoadHelper downLoadHelper = this.this$0;
        DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback = this.val$callback;
        boolean bl2 = this.val$bCallbackSwitchToMainThread;
        DownLoadHelper.access$1100(downLoadHelper, downloadEntity, throwable, downLoadHelper$OnDownloadFileEntityCallback, bl2);
        this.callResult(downloadEntity);
    }

    public void downloadProgress(DownloadEntity downloadEntity, int n10, long l10, long l11) {
        DownLoadHelper downLoadHelper = this.this$0;
        DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback = this.val$callback;
        boolean bl2 = this.val$bCallbackSwitchToMainThread;
        DownLoadHelper.access$1300(downLoadHelper, downloadEntity, n10, l10, l11, downLoadHelper$OnDownloadFileEntityCallback, bl2);
    }

    public void downloadSuccess(DownloadEntity downloadEntity) {
        DownLoadHelper downLoadHelper = this.this$0;
        DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback = this.val$callback;
        boolean bl2 = this.val$bCallbackSwitchToMainThread;
        DownLoadHelper.access$1000(downLoadHelper, downloadEntity, downLoadHelper$OnDownloadFileEntityCallback, bl2);
        this.callResult(downloadEntity);
    }

    public void saveFailed(DownloadEntity downloadEntity, Throwable throwable) {
        DownLoadHelper downLoadHelper = this.this$0;
        DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback = this.val$callback;
        boolean bl2 = this.val$bCallbackSwitchToMainThread;
        DownLoadHelper.access$1200(downLoadHelper, downloadEntity, throwable, downLoadHelper$OnDownloadFileEntityCallback, bl2);
        this.callResult(downloadEntity);
    }
}

