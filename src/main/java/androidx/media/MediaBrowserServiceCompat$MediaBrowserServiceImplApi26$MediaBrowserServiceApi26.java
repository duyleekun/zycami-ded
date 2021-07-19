/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.service.media.MediaBrowserService$Result
 */
package androidx.media;

import android.content.Context;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$MediaBrowserServiceApi23;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26;
import androidx.media.MediaBrowserServiceCompat$ResultWrapper;

public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26
extends MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$MediaBrowserServiceApi23 {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplApi26 this$1;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26(MediaBrowserServiceCompat$MediaBrowserServiceImplApi26 mediaBrowserServiceCompat$MediaBrowserServiceImplApi26, Context context) {
        this.this$1 = mediaBrowserServiceCompat$MediaBrowserServiceImplApi26;
        super(mediaBrowserServiceCompat$MediaBrowserServiceImplApi26, context);
    }

    public void onLoadChildren(String string2, MediaBrowserService.Result result2, Bundle bundle) {
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord;
        MediaSessionCompat.ensureClassLoader(bundle);
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi26 mediaBrowserServiceCompat$MediaBrowserServiceImplApi26 = this.this$1;
        Object object = mediaBrowserServiceCompat$MediaBrowserServiceImplApi26.this$0;
        object.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord = object.mConnectionFromFwk;
        object = new MediaBrowserServiceCompat$ResultWrapper(result2);
        mediaBrowserServiceCompat$MediaBrowserServiceImplApi26.onLoadChildren(string2, (MediaBrowserServiceCompat$ResultWrapper)object, bundle);
        this.this$1.this$0.mCurConnection = null;
    }
}

