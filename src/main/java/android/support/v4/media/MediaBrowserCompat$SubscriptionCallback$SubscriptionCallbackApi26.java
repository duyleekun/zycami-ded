/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallback;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallback$SubscriptionCallbackApi21;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

public class MediaBrowserCompat$SubscriptionCallback$SubscriptionCallbackApi26
extends MediaBrowserCompat$SubscriptionCallback$SubscriptionCallbackApi21 {
    public final /* synthetic */ MediaBrowserCompat$SubscriptionCallback this$0;

    public MediaBrowserCompat$SubscriptionCallback$SubscriptionCallbackApi26(MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback) {
        this.this$0 = mediaBrowserCompat$SubscriptionCallback;
        super(mediaBrowserCompat$SubscriptionCallback);
    }

    public void onChildrenLoaded(String string2, List list, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader(bundle);
        MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback = this.this$0;
        list = MediaBrowserCompat$MediaItem.fromMediaItemList(list);
        mediaBrowserCompat$SubscriptionCallback.onChildrenLoaded(string2, list, bundle);
    }

    public void onError(String string2, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader(bundle);
        this.this$0.onError(string2, bundle);
    }
}

