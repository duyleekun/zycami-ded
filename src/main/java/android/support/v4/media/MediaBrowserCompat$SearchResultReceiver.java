/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Parcelable
 */
package android.support.v4.media;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaBrowserCompat$SearchCallback;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import java.util.ArrayList;
import java.util.List;

public class MediaBrowserCompat$SearchResultReceiver
extends ResultReceiver {
    private final MediaBrowserCompat$SearchCallback mCallback;
    private final Bundle mExtras;
    private final String mQuery;

    public MediaBrowserCompat$SearchResultReceiver(String string2, Bundle bundle, MediaBrowserCompat$SearchCallback mediaBrowserCompat$SearchCallback, Handler handler) {
        super(handler);
        this.mQuery = string2;
        this.mExtras = bundle;
        this.mCallback = mediaBrowserCompat$SearchCallback;
    }

    public void onReceiveResult(int n10, Bundle object) {
        Object object2;
        int n11;
        if (object != null) {
            object = MediaSessionCompat.unparcelWithClassLoader((Bundle)object);
        }
        if (n10 == 0 && object != null && (n11 = object.containsKey((String)(object2 = "search_results"))) != 0) {
            if ((object2 = object.getParcelableArray((String)object2)) != null) {
                object = new ArrayList();
                n11 = ((Parcelable[])object2).length;
                Bundle bundle = null;
                for (int i10 = 0; i10 < n11; ++i10) {
                    MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem = (MediaBrowserCompat$MediaItem)object2[i10];
                    object.add(mediaBrowserCompat$MediaItem);
                }
                object2 = this.mCallback;
                String string2 = this.mQuery;
                bundle = this.mExtras;
                ((MediaBrowserCompat$SearchCallback)object2).onSearchResult(string2, bundle, (List)object);
            } else {
                object2 = this.mCallback;
                object = this.mQuery;
                Bundle bundle = this.mExtras;
                ((MediaBrowserCompat$SearchCallback)object2).onError((String)object, bundle);
            }
            return;
        }
        object2 = this.mCallback;
        object = this.mQuery;
        Bundle bundle = this.mExtras;
        ((MediaBrowserCompat$SearchCallback)object2).onError((String)object, bundle);
    }
}

