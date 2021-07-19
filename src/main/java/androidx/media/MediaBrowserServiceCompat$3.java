/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$Result;
import java.util.List;

public class MediaBrowserServiceCompat$3
extends MediaBrowserServiceCompat$Result {
    public final /* synthetic */ MediaBrowserServiceCompat this$0;
    public final /* synthetic */ ResultReceiver val$receiver;

    public MediaBrowserServiceCompat$3(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object object, ResultReceiver resultReceiver) {
        this.this$0 = mediaBrowserServiceCompat;
        this.val$receiver = resultReceiver;
        super(object);
    }

    public void onResultSent(List parcelableArray) {
        int n10 = this.getFlags() & 4;
        if (n10 == 0 && parcelableArray != null) {
            Bundle bundle = new Bundle();
            MediaBrowserCompat$MediaItem[] mediaBrowserCompat$MediaItemArray = new MediaBrowserCompat$MediaItem[]{};
            parcelableArray = parcelableArray.toArray(mediaBrowserCompat$MediaItemArray);
            bundle.putParcelableArray("search_results", parcelableArray);
            this.val$receiver.send(0, bundle);
            return;
        }
        this.val$receiver.send(-1, null);
    }
}

