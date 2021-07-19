/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.k0;

import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.offline.DownloadHelper$Callback;

public final class g
implements Runnable {
    public final /* synthetic */ DownloadHelper a;
    public final /* synthetic */ DownloadHelper$Callback b;

    public /* synthetic */ g(DownloadHelper downloadHelper, DownloadHelper$Callback downloadHelper$Callback) {
        this.a = downloadHelper;
        this.b = downloadHelper$Callback;
    }

    public final void run() {
        DownloadHelper downloadHelper = this.a;
        DownloadHelper$Callback downloadHelper$Callback = this.b;
        downloadHelper.i(downloadHelper$Callback);
    }
}

