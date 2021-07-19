/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat$CustomActionCallback;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase;

public class MediaBrowserCompat$MediaBrowserImplBase$6
implements Runnable {
    public final /* synthetic */ MediaBrowserCompat$MediaBrowserImplBase this$0;
    public final /* synthetic */ String val$action;
    public final /* synthetic */ MediaBrowserCompat$CustomActionCallback val$callback;
    public final /* synthetic */ Bundle val$extras;

    public MediaBrowserCompat$MediaBrowserImplBase$6(MediaBrowserCompat$MediaBrowserImplBase mediaBrowserCompat$MediaBrowserImplBase, MediaBrowserCompat$CustomActionCallback mediaBrowserCompat$CustomActionCallback, String string2, Bundle bundle) {
        this.this$0 = mediaBrowserCompat$MediaBrowserImplBase;
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

