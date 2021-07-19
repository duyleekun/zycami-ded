/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.k0;

import com.google.android.exoplayer2.offline.DownloadHelper;
import java.io.IOException;

public final class c
implements Runnable {
    public final /* synthetic */ DownloadHelper a;
    public final /* synthetic */ IOException b;

    public /* synthetic */ c(DownloadHelper downloadHelper, IOException iOException) {
        this.a = downloadHelper;
        this.b = iOException;
    }

    public final void run() {
        DownloadHelper downloadHelper = this.a;
        IOException iOException = this.b;
        downloadHelper.e(iOException);
    }
}

