/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$Result;

public class MediaBrowserServiceCompat$4
extends MediaBrowserServiceCompat$Result {
    public final /* synthetic */ MediaBrowserServiceCompat this$0;
    public final /* synthetic */ ResultReceiver val$receiver;

    public MediaBrowserServiceCompat$4(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object object, ResultReceiver resultReceiver) {
        this.this$0 = mediaBrowserServiceCompat;
        this.val$receiver = resultReceiver;
        super(object);
    }

    public void onErrorSent(Bundle bundle) {
        this.val$receiver.send(-1, bundle);
    }

    public void onProgressUpdateSent(Bundle bundle) {
        this.val$receiver.send(1, bundle);
    }

    public void onResultSent(Bundle bundle) {
        this.val$receiver.send(0, bundle);
    }
}

