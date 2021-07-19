/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader$Callback;
import com.google.android.exoplayer2.upstream.Loader$LoadErrorAction;
import com.google.android.exoplayer2.upstream.Loader$Loadable;
import com.google.android.exoplayer2.util.SntpClient;
import com.google.android.exoplayer2.util.SntpClient$InitializationCallback;
import java.io.IOException;
import java.util.ConcurrentModificationException;

public final class SntpClient$NtpTimeCallback
implements Loader$Callback {
    private final SntpClient$InitializationCallback callback;

    public SntpClient$NtpTimeCallback(SntpClient$InitializationCallback sntpClient$InitializationCallback) {
        this.callback = sntpClient$InitializationCallback;
    }

    public void onLoadCanceled(Loader$Loadable loader$Loadable, long l10, long l11, boolean bl2) {
    }

    public void onLoadCompleted(Loader$Loadable object, long l10, long l11) {
        object = this.callback;
        if (object != null) {
            boolean bl2 = SntpClient.isInitialized();
            if (!bl2) {
                object = this.callback;
                ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
                IOException iOException = new IOException(concurrentModificationException);
                object.onInitializationFailed(iOException);
            } else {
                object = this.callback;
                object.onInitialized();
            }
        }
    }

    public Loader$LoadErrorAction onLoadError(Loader$Loadable object, long l10, long l11, IOException iOException, int n10) {
        object = this.callback;
        if (object != null) {
            object.onInitializationFailed(iOException);
        }
        return Loader.DONT_RETRY;
    }
}

