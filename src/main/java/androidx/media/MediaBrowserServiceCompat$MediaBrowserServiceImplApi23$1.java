/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package androidx.media;

import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23;
import androidx.media.MediaBrowserServiceCompat$Result;
import androidx.media.MediaBrowserServiceCompat$ResultWrapper;

public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1
extends MediaBrowserServiceCompat$Result {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplApi23 this$1;
    public final /* synthetic */ MediaBrowserServiceCompat$ResultWrapper val$resultWrapper;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1(MediaBrowserServiceCompat$MediaBrowserServiceImplApi23 mediaBrowserServiceCompat$MediaBrowserServiceImplApi23, Object object, MediaBrowserServiceCompat$ResultWrapper mediaBrowserServiceCompat$ResultWrapper) {
        this.this$1 = mediaBrowserServiceCompat$MediaBrowserServiceImplApi23;
        this.val$resultWrapper = mediaBrowserServiceCompat$ResultWrapper;
        super(object);
    }

    public void detach() {
        this.val$resultWrapper.detach();
    }

    public void onResultSent(MediaBrowserCompat$MediaItem object) {
        if (object == null) {
            object = this.val$resultWrapper;
            Object var2_2 = null;
            ((MediaBrowserServiceCompat$ResultWrapper)object).sendResult(null);
        } else {
            Parcel parcel = Parcel.obtain();
            ((MediaBrowserCompat$MediaItem)object).writeToParcel(parcel, 0);
            object = this.val$resultWrapper;
            ((MediaBrowserServiceCompat$ResultWrapper)object).sendResult(parcel);
        }
    }
}

