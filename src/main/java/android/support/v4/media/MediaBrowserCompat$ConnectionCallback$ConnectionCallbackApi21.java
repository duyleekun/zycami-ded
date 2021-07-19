/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.browse.MediaBrowser$ConnectionCallback
 */
package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal;

public class MediaBrowserCompat$ConnectionCallback$ConnectionCallbackApi21
extends MediaBrowser.ConnectionCallback {
    public final /* synthetic */ MediaBrowserCompat$ConnectionCallback this$0;

    public MediaBrowserCompat$ConnectionCallback$ConnectionCallbackApi21(MediaBrowserCompat$ConnectionCallback connectionCallback) {
        this.this$0 = connectionCallback;
    }

    public void onConnected() {
        MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal mediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal = this.this$0.mConnectionCallbackInternal;
        if (mediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal != null) {
            mediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal.onConnected();
        }
        this.this$0.onConnected();
    }

    public void onConnectionFailed() {
        MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal mediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal = this.this$0.mConnectionCallbackInternal;
        if (mediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal != null) {
            mediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal.onConnectionFailed();
        }
        this.this$0.onConnectionFailed();
    }

    public void onConnectionSuspended() {
        MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal mediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal = this.this$0.mConnectionCallbackInternal;
        if (mediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal != null) {
            mediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal.onConnectionSuspended();
        }
        this.this$0.onConnectionSuspended();
    }
}

