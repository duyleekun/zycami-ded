/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21;
import android.support.v4.media.MediaBrowserCompat$SearchCallback;

public class MediaBrowserCompat$MediaBrowserImplApi21$5
implements Runnable {
    public final /* synthetic */ MediaBrowserCompat$MediaBrowserImplApi21 this$0;
    public final /* synthetic */ MediaBrowserCompat$SearchCallback val$callback;
    public final /* synthetic */ Bundle val$extras;
    public final /* synthetic */ String val$query;

    public MediaBrowserCompat$MediaBrowserImplApi21$5(MediaBrowserCompat$MediaBrowserImplApi21 mediaBrowserCompat$MediaBrowserImplApi21, MediaBrowserCompat$SearchCallback mediaBrowserCompat$SearchCallback, String string2, Bundle bundle) {
        this.this$0 = mediaBrowserCompat$MediaBrowserImplApi21;
        this.val$callback = mediaBrowserCompat$SearchCallback;
        this.val$query = string2;
        this.val$extras = bundle;
    }

    public void run() {
        MediaBrowserCompat$SearchCallback mediaBrowserCompat$SearchCallback = this.val$callback;
        String string2 = this.val$query;
        Bundle bundle = this.val$extras;
        mediaBrowserCompat$SearchCallback.onError(string2, bundle);
    }
}

