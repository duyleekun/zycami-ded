/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package d.h.a.a.k0;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.offline.DownloadManager;

public final class j
implements Handler.Callback {
    public final /* synthetic */ DownloadManager a;

    public /* synthetic */ j(DownloadManager downloadManager) {
        this.a = downloadManager;
    }

    public final boolean handleMessage(Message message) {
        return DownloadManager.b(this.a, message);
    }
}

