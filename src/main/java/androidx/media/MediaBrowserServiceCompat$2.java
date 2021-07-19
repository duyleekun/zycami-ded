/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package androidx.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$Result;

public class MediaBrowserServiceCompat$2
extends MediaBrowserServiceCompat$Result {
    public final /* synthetic */ MediaBrowserServiceCompat this$0;
    public final /* synthetic */ ResultReceiver val$receiver;

    public MediaBrowserServiceCompat$2(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object object, ResultReceiver resultReceiver) {
        this.this$0 = mediaBrowserServiceCompat;
        this.val$receiver = resultReceiver;
        super(object);
    }

    public void onResultSent(MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem) {
        int n10 = this.getFlags() & 2;
        if (n10 != 0) {
            this.val$receiver.send(-1, null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("media_item", (Parcelable)mediaBrowserCompat$MediaItem);
        this.val$receiver.send(0, bundle);
    }
}

