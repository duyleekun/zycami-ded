/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.service.media.MediaBrowserService
 *  android.service.media.MediaBrowserService$BrowserRoot
 *  android.service.media.MediaBrowserService$Result
 */
package androidx.media;

import android.content.Context;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.MediaBrowserServiceCompat$BrowserRoot;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21;
import androidx.media.MediaBrowserServiceCompat$ResultWrapper;

public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21
extends MediaBrowserService {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 this$1;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21(MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21, Context context) {
        this.this$1 = mediaBrowserServiceCompat$MediaBrowserServiceImplApi21;
        this.attachBaseContext(context);
    }

    public MediaBrowserService.BrowserRoot onGetRoot(String object, int n10, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader(bundle);
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21 = this.this$1;
        MediaBrowserService.BrowserRoot browserRoot = null;
        Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        object = mediaBrowserServiceCompat$MediaBrowserServiceImplApi21.onGetRoot((String)object, n10, bundle2);
        if (object != null) {
            String string2 = MediaBrowserServiceCompat$BrowserRoot.access$000((MediaBrowserServiceCompat$BrowserRoot)object);
            object = MediaBrowserServiceCompat$BrowserRoot.access$100((MediaBrowserServiceCompat$BrowserRoot)object);
            browserRoot = new MediaBrowserService.BrowserRoot(string2, (Bundle)object);
        }
        return browserRoot;
    }

    public void onLoadChildren(String string2, MediaBrowserService.Result result2) {
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21 = this.this$1;
        MediaBrowserServiceCompat$ResultWrapper mediaBrowserServiceCompat$ResultWrapper = new MediaBrowserServiceCompat$ResultWrapper(result2);
        mediaBrowserServiceCompat$MediaBrowserServiceImplApi21.onLoadChildren(string2, mediaBrowserServiceCompat$ResultWrapper);
    }
}

