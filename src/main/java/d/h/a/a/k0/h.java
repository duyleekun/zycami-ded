/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.k0;

import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher$Listener;

public final class h
implements RequirementsWatcher$Listener {
    public final /* synthetic */ DownloadManager a;

    public /* synthetic */ h(DownloadManager downloadManager) {
        this.a = downloadManager;
    }

    public final void onRequirementsStateChanged(RequirementsWatcher requirementsWatcher, int n10) {
        DownloadManager.a(this.a, requirementsWatcher, n10);
    }
}

