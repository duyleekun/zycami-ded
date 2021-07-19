/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.media.browse.MediaBrowser$SubscriptionCallback
 *  android.os.Bundle
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi23;
import android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallback;

public class MediaBrowserCompat$MediaBrowserImplApi26
extends MediaBrowserCompat$MediaBrowserImplApi23 {
    public MediaBrowserCompat$MediaBrowserImplApi26(Context context, ComponentName componentName, MediaBrowserCompat$ConnectionCallback mediaBrowserCompat$ConnectionCallback, Bundle bundle) {
        super(context, componentName, mediaBrowserCompat$ConnectionCallback, bundle);
    }

    public void subscribe(String string2, Bundle bundle, MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback) {
        int n10;
        int n11;
        MediaBrowserCompat$ServiceBinderWrapper mediaBrowserCompat$ServiceBinderWrapper = this.mServiceBinderWrapper;
        if (mediaBrowserCompat$ServiceBinderWrapper != null && (n11 = this.mServiceVersion) >= (n10 = 2)) {
            super.subscribe(string2, bundle, mediaBrowserCompat$SubscriptionCallback);
        } else if (bundle == null) {
            bundle = this.mBrowserFwk;
            mediaBrowserCompat$SubscriptionCallback = mediaBrowserCompat$SubscriptionCallback.mSubscriptionCallbackFwk;
            bundle.subscribe(string2, (MediaBrowser.SubscriptionCallback)mediaBrowserCompat$SubscriptionCallback);
        } else {
            mediaBrowserCompat$ServiceBinderWrapper = this.mBrowserFwk;
            mediaBrowserCompat$SubscriptionCallback = mediaBrowserCompat$SubscriptionCallback.mSubscriptionCallbackFwk;
            mediaBrowserCompat$ServiceBinderWrapper.subscribe(string2, bundle, (MediaBrowser.SubscriptionCallback)mediaBrowserCompat$SubscriptionCallback);
        }
    }

    public void unsubscribe(String string2, MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback) {
        int n10;
        int n11;
        MediaBrowserCompat$ServiceBinderWrapper mediaBrowserCompat$ServiceBinderWrapper = this.mServiceBinderWrapper;
        if (mediaBrowserCompat$ServiceBinderWrapper != null && (n11 = this.mServiceVersion) >= (n10 = 2)) {
            super.unsubscribe(string2, mediaBrowserCompat$SubscriptionCallback);
        } else if (mediaBrowserCompat$SubscriptionCallback == null) {
            mediaBrowserCompat$SubscriptionCallback = this.mBrowserFwk;
            mediaBrowserCompat$SubscriptionCallback.unsubscribe(string2);
        } else {
            mediaBrowserCompat$ServiceBinderWrapper = this.mBrowserFwk;
            mediaBrowserCompat$SubscriptionCallback = mediaBrowserCompat$SubscriptionCallback.mSubscriptionCallbackFwk;
            mediaBrowserCompat$ServiceBinderWrapper.unsubscribe(string2, (MediaBrowser.SubscriptionCallback)mediaBrowserCompat$SubscriptionCallback);
        }
    }
}

