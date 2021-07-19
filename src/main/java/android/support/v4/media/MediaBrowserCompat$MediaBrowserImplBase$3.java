/*
 * Decompiled with CFR 0.151.
 */
package android.support.v4.media;

import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase;

public class MediaBrowserCompat$MediaBrowserImplBase$3
implements Runnable {
    public final /* synthetic */ MediaBrowserCompat$MediaBrowserImplBase this$0;
    public final /* synthetic */ MediaBrowserCompat$ItemCallback val$cb;
    public final /* synthetic */ String val$mediaId;

    public MediaBrowserCompat$MediaBrowserImplBase$3(MediaBrowserCompat$MediaBrowserImplBase mediaBrowserCompat$MediaBrowserImplBase, MediaBrowserCompat$ItemCallback mediaBrowserCompat$ItemCallback, String string2) {
        this.this$0 = mediaBrowserCompat$MediaBrowserImplBase;
        this.val$cb = mediaBrowserCompat$ItemCallback;
        this.val$mediaId = string2;
    }

    public void run() {
        MediaBrowserCompat$ItemCallback mediaBrowserCompat$ItemCallback = this.val$cb;
        String string2 = this.val$mediaId;
        mediaBrowserCompat$ItemCallback.onError(string2);
    }
}

