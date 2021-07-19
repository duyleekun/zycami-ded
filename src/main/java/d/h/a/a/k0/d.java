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
import com.google.android.exoplayer2.offline.DownloadHelper$MediaPreparer;

public final class d
implements Handler.Callback {
    public final /* synthetic */ DownloadHelper$MediaPreparer a;

    public /* synthetic */ d(DownloadHelper$MediaPreparer downloadHelper$MediaPreparer) {
        this.a = downloadHelper$MediaPreparer;
    }

    public final boolean handleMessage(Message message) {
        return DownloadHelper$MediaPreparer.a(this.a, message);
    }
}

