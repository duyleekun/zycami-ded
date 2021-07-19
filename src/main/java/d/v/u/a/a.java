/*
 * Decompiled with CFR 0.151.
 */
package d.v.u.a;

import com.zhiyun.net.api.entity.DownloadEntity;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$CancelControl;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileCallback;

public final class a
implements Runnable {
    public final /* synthetic */ DownLoadHelper a;
    public final /* synthetic */ DownloadEntity b;
    public final /* synthetic */ DownLoadHelper$OnDownloadFileCallback c;
    public final /* synthetic */ DownLoadHelper$CancelControl d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ a(DownLoadHelper downLoadHelper, DownloadEntity downloadEntity, DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback, DownLoadHelper$CancelControl downLoadHelper$CancelControl, boolean bl2) {
        this.a = downLoadHelper;
        this.b = downloadEntity;
        this.c = downLoadHelper$OnDownloadFileCallback;
        this.d = downLoadHelper$CancelControl;
        this.e = bl2;
    }

    public final void run() {
        DownLoadHelper downLoadHelper = this.a;
        DownloadEntity downloadEntity = this.b;
        DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback = this.c;
        DownLoadHelper$CancelControl downLoadHelper$CancelControl = this.d;
        boolean bl2 = this.e;
        downLoadHelper.o(downloadEntity, downLoadHelper$OnDownloadFileCallback, downLoadHelper$CancelControl, bl2);
    }
}

