/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat$CustomActionCallback;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21;

public class MediaBrowserCompat$MediaBrowserImplApi21$6
implements Runnable {
    public final /* synthetic */ MediaBrowserCompat$MediaBrowserImplApi21 this$0;
    public final /* synthetic */ String val$action;
    public final /* synthetic */ MediaBrowserCompat$CustomActionCallback val$callback;
    public final /* synthetic */ Bundle val$extras;

    public MediaBrowserCompat$MediaBrowserImplApi21$6(MediaBrowserCompat$MediaBrowserImplApi21 mediaBrowserCompat$MediaBrowserImplApi21, MediaBrowserCompat$CustomActionCallback mediaBrowserCompat$CustomActionCallback, String string2, Bundle bundle) {
        this.this$0 = mediaBrowserCompat$MediaBrowserImplApi21;
        this.val$callback = mediaBrowserCompat$CustomActionCallback;
        this.val$action = string2;
        this.val$extras = bundle;
    }

    public void run() {
        MediaBrowserCompat$CustomActionCallback mediaBrowserCompat$CustomActionCallback = this.val$callback;
        String string2 = this.val$action;
        Bundle bundle = this.val$extras;
        mediaBrowserCompat$CustomActionCallback.onError(string2, bundle, null);
    }
}

