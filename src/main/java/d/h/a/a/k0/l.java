/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.k0;

import com.google.android.exoplayer2.offline.DownloadService$ForegroundNotificationUpdater;

public final class l
implements Runnable {
    public final /* synthetic */ DownloadService$ForegroundNotificationUpdater a;

    public /* synthetic */ l(DownloadService$ForegroundNotificationUpdater downloadService$ForegroundNotificationUpdater) {
        this.a = downloadService$ForegroundNotificationUpdater;
    }

    public final void run() {
        DownloadService$ForegroundNotificationUpdater.a(this.a);
    }
}

