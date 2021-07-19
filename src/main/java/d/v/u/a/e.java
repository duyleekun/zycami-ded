/*
 * Decompiled with CFR 0.151.
 */
package d.v.u.a;

import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$CancelControl;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileEntityCallback;
import java.util.List;

public final class e
implements Runnable {
    public final /* synthetic */ DownLoadHelper a;
    public final /* synthetic */ List b;
    public final /* synthetic */ DownLoadHelper$OnDownloadFileEntityCallback c;
    public final /* synthetic */ DownLoadHelper$CancelControl d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ e(DownLoadHelper downLoadHelper, List list, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, DownLoadHelper$CancelControl downLoadHelper$CancelControl, boolean bl2) {
        this.a = downLoadHelper;
        this.b = list;
        this.c = downLoadHelper$OnDownloadFileEntityCallback;
        this.d = downLoadHelper$CancelControl;
        this.e = bl2;
    }

    public final void run() {
        DownLoadHelper downLoadHelper = this.a;
        List list = this.b;
        DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback = this.c;
        DownLoadHelper$CancelControl downLoadHelper$CancelControl = this.d;
        boolean bl2 = this.e;
        downLoadHelper.s(list, downLoadHelper$OnDownloadFileEntityCallback, downLoadHelper$CancelControl, bl2);
    }
}

