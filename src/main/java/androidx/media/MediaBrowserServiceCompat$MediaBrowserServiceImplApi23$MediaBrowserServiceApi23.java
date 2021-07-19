/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.service.media.MediaBrowserService$Result
 */
package androidx.media;

import android.content.Context;
import android.service.media.MediaBrowserService;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23;
import androidx.media.MediaBrowserServiceCompat$ResultWrapper;

public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$MediaBrowserServiceApi23
extends MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21 {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplApi23 this$1;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$MediaBrowserServiceApi23(MediaBrowserServiceCompat$MediaBrowserServiceImplApi23 mediaBrowserServiceCompat$MediaBrowserServiceImplApi23, Context context) {
        this.this$1 = mediaBrowserServiceCompat$MediaBrowserServiceImplApi23;
        super(mediaBrowserServiceCompat$MediaBrowserServiceImplApi23, context);
    }

    public void onLoadItem(String string2, MediaBrowserService.Result result2) {
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi23 mediaBrowserServiceCompat$MediaBrowserServiceImplApi23 = this.this$1;
        MediaBrowserServiceCompat$ResultWrapper mediaBrowserServiceCompat$ResultWrapper = new MediaBrowserServiceCompat$ResultWrapper(result2);
        mediaBrowserServiceCompat$MediaBrowserServiceImplApi23.onLoadItem(string2, mediaBrowserServiceCompat$ResultWrapper);
    }
}

