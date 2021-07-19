/*
 * Decompiled with CFR 0.151.
 */
package d.v.u.a;

import com.zhiyun.net.api.entity.DownloadEntity;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$CancelControl;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileEntityCallback;

public final class i
implements Runnable {
    public final /* synthetic */ DownLoadHelper a;
    public final /* synthetic */ DownloadEntity b;
    public final /* synthetic */ DownLoadHelper$OnDownloadFileEntityCallback c;
    public final /* synthetic */ DownLoadHelper$CancelControl d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ i(DownLoadHelper downLoadHelper, DownloadEntity downloadEntity, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, DownLoadHelper$CancelControl downLoadHelper$CancelControl, boolean bl2) {
        this.a = downLoadHelper;
        this.b = downloadEntity;
        this.c = downLoadHelper$OnDownloadFileEntityCallback;
        this.d = downLoadHelper$CancelControl;
        this.e = bl2;
    }

    public final void run() {
        DownLoadHelper downLoadHelper = this.a;
        DownloadEntity downloadEntity = this.b;
        DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback = this.c;
        DownLoadHelper$CancelControl downLoadHelper$CancelControl = this.d;
        boolean bl2 = this.e;
        downLoadHelper.q(downloadEntity, downLoadHelper$OnDownloadFileEntityCallback, downLoadHelper$CancelControl, bl2);
    }
}

