/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.k0;

import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.offline.DownloadService$DownloadManagerHelper;

public final class k
implements Runnable {
    public final /* synthetic */ DownloadService$DownloadManagerHelper a;
    public final /* synthetic */ DownloadService b;

    public /* synthetic */ k(DownloadService$DownloadManagerHelper downloadService$DownloadManagerHelper, DownloadService downloadService) {
        this.a = downloadService$DownloadManagerHelper;
        this.b = downloadService;
    }

    public final void run() {
        DownloadService$DownloadManagerHelper downloadService$DownloadManagerHelper = this.a;
        DownloadService downloadService = this.b;
        downloadService$DownloadManagerHelper.b(downloadService);
    }
}

