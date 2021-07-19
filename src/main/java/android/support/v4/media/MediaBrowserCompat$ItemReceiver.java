/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 */
package android.support.v4.media;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;

public class MediaBrowserCompat$ItemReceiver
extends ResultReceiver {
    private final MediaBrowserCompat$ItemCallback mCallback;
    private final String mMediaId;

    public MediaBrowserCompat$ItemReceiver(String string2, MediaBrowserCompat$ItemCallback mediaBrowserCompat$ItemCallback, Handler handler) {
        super(handler);
        this.mMediaId = string2;
        this.mCallback = mediaBrowserCompat$ItemCallback;
    }

    public void onReceiveResult(int n10, Bundle object) {
        Object object2;
        boolean bl2;
        if (object != null) {
            object = MediaSessionCompat.unparcelWithClassLoader((Bundle)object);
        }
        if (n10 == 0 && object != null && (bl2 = object.containsKey((String)(object2 = "media_item")))) {
            boolean bl3;
            if ((object2 = object.getParcelable((String)object2)) != null && !(bl3 = object2 instanceof MediaBrowserCompat$MediaItem)) {
                object2 = this.mCallback;
                object = this.mMediaId;
                ((MediaBrowserCompat$ItemCallback)object2).onError((String)object);
            } else {
                object = this.mCallback;
                object2 = (MediaBrowserCompat$MediaItem)object2;
                ((MediaBrowserCompat$ItemCallback)object).onItemLoaded((MediaBrowserCompat$MediaItem)object2);
            }
            return;
        }
        object2 = this.mCallback;
        object = this.mMediaId;
        ((MediaBrowserCompat$ItemCallback)object2).onError((String)object);
    }
}

