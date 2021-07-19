/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package androidx.media;

import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21;
import androidx.media.MediaBrowserServiceCompat$Result;
import androidx.media.MediaBrowserServiceCompat$ResultWrapper;
import java.util.ArrayList;
import java.util.List;

public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2
extends MediaBrowserServiceCompat$Result {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 this$1;
    public final /* synthetic */ MediaBrowserServiceCompat$ResultWrapper val$resultWrapper;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2(MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21, Object object, MediaBrowserServiceCompat$ResultWrapper mediaBrowserServiceCompat$ResultWrapper) {
        this.this$1 = mediaBrowserServiceCompat$MediaBrowserServiceImplApi21;
        this.val$resultWrapper = mediaBrowserServiceCompat$ResultWrapper;
        super(object);
    }

    public void detach() {
        this.val$resultWrapper.detach();
    }

    public void onResultSent(List object) {
        ArrayList<Parcel> arrayList;
        if (object != null) {
            boolean bl2;
            arrayList = new ArrayList<Parcel>();
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem = (MediaBrowserCompat$MediaItem)object.next();
                Parcel parcel = Parcel.obtain();
                mediaBrowserCompat$MediaItem.writeToParcel(parcel, 0);
                arrayList.add(parcel);
            }
        } else {
            arrayList = null;
        }
        this.val$resultWrapper.sendResult(arrayList);
    }
}

