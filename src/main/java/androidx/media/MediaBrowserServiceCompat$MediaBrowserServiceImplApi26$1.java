/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 */
package androidx.media;

import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26;
import androidx.media.MediaBrowserServiceCompat$Result;
import androidx.media.MediaBrowserServiceCompat$ResultWrapper;
import java.util.ArrayList;
import java.util.List;

public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$1
extends MediaBrowserServiceCompat$Result {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplApi26 this$1;
    public final /* synthetic */ Bundle val$options;
    public final /* synthetic */ MediaBrowserServiceCompat$ResultWrapper val$resultWrapper;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$1(MediaBrowserServiceCompat$MediaBrowserServiceImplApi26 mediaBrowserServiceCompat$MediaBrowserServiceImplApi26, Object object, MediaBrowserServiceCompat$ResultWrapper mediaBrowserServiceCompat$ResultWrapper, Bundle bundle) {
        this.this$1 = mediaBrowserServiceCompat$MediaBrowserServiceImplApi26;
        this.val$resultWrapper = mediaBrowserServiceCompat$ResultWrapper;
        this.val$options = bundle;
        super(object);
    }

    public void detach() {
        this.val$resultWrapper.detach();
    }

    public void onResultSent(List object) {
        boolean bl2;
        Object object2;
        Object object3;
        if (object == null) {
            this.val$resultWrapper.sendResult(null);
            return;
        }
        int n10 = this.getFlags() & 1;
        if (n10 != 0) {
            object3 = this.this$1.this$0;
            object2 = this.val$options;
            object = ((MediaBrowserServiceCompat)((Object)object3)).applyOptions((List)object, (Bundle)object2);
        }
        object3 = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (MediaBrowserCompat$MediaItem)object.next();
            Parcel parcel = Parcel.obtain();
            ((MediaBrowserCompat$MediaItem)object2).writeToParcel(parcel, 0);
            object3.add(parcel);
        }
        this.val$resultWrapper.sendResult(object3);
    }
}

