/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.media.browse.MediaBrowser$ItemCallback
 *  android.os.Bundle
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback;
import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21;
import android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper;

public class MediaBrowserCompat$MediaBrowserImplApi23
extends MediaBrowserCompat$MediaBrowserImplApi21 {
    public MediaBrowserCompat$MediaBrowserImplApi23(Context context, ComponentName componentName, MediaBrowserCompat$ConnectionCallback mediaBrowserCompat$ConnectionCallback, Bundle bundle) {
        super(context, componentName, mediaBrowserCompat$ConnectionCallback, bundle);
    }

    public void getItem(String string2, MediaBrowserCompat$ItemCallback mediaBrowserCompat$ItemCallback) {
        MediaBrowserCompat$ServiceBinderWrapper mediaBrowserCompat$ServiceBinderWrapper = this.mServiceBinderWrapper;
        if (mediaBrowserCompat$ServiceBinderWrapper == null) {
            mediaBrowserCompat$ServiceBinderWrapper = this.mBrowserFwk;
            mediaBrowserCompat$ItemCallback = mediaBrowserCompat$ItemCallback.mItemCallbackFwk;
            mediaBrowserCompat$ServiceBinderWrapper.getItem(string2, (MediaBrowser.ItemCallback)mediaBrowserCompat$ItemCallback);
        } else {
            super.getItem(string2, mediaBrowserCompat$ItemCallback);
        }
    }
}

