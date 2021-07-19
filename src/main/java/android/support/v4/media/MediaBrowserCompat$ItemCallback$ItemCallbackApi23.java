/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.browse.MediaBrowser$ItemCallback
 *  android.media.browse.MediaBrowser$MediaItem
 */
package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$MediaItem;

public class MediaBrowserCompat$ItemCallback$ItemCallbackApi23
extends MediaBrowser.ItemCallback {
    public final /* synthetic */ MediaBrowserCompat$ItemCallback this$0;

    public MediaBrowserCompat$ItemCallback$ItemCallbackApi23(MediaBrowserCompat$ItemCallback itemCallback) {
        this.this$0 = itemCallback;
    }

    public void onError(String string2) {
        this.this$0.onError(string2);
    }

    public void onItemLoaded(MediaBrowser.MediaItem object) {
        MediaBrowserCompat$ItemCallback mediaBrowserCompat$ItemCallback = this.this$0;
        object = MediaBrowserCompat$MediaItem.fromMediaItem(object);
        mediaBrowserCompat$ItemCallback.onItemLoaded((MediaBrowserCompat$MediaItem)object);
    }
}

