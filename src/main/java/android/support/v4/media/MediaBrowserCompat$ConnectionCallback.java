/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.browse.MediaBrowser$ConnectionCallback
 *  android.os.Build$VERSION
 */
package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Build;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback$ConnectionCallbackApi21;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal;

public class MediaBrowserCompat$ConnectionCallback {
    public final MediaBrowser.ConnectionCallback mConnectionCallbackFwk;
    public MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal mConnectionCallbackInternal;

    public MediaBrowserCompat$ConnectionCallback() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            MediaBrowserCompat$ConnectionCallback$ConnectionCallbackApi21 mediaBrowserCompat$ConnectionCallback$ConnectionCallbackApi21 = new MediaBrowserCompat$ConnectionCallback$ConnectionCallbackApi21(this);
            this.mConnectionCallbackFwk = mediaBrowserCompat$ConnectionCallback$ConnectionCallbackApi21;
        } else {
            n10 = 0;
            Object var3_4 = null;
            this.mConnectionCallbackFwk = null;
        }
    }

    public void onConnected() {
    }

    public void onConnectionFailed() {
    }

    public void onConnectionSuspended() {
    }

    public void setInternalConnectionCallback(MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal mediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal) {
        this.mConnectionCallbackInternal = mediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal;
    }
}

