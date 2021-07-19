/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.media;

import android.content.Context;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$MediaBrowserServiceApi23;
import androidx.media.MediaBrowserServiceCompat$ResultWrapper;

public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi23
extends MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 {
    public final /* synthetic */ MediaBrowserServiceCompat this$0;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi23(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.this$0 = mediaBrowserServiceCompat;
        super(mediaBrowserServiceCompat);
    }

    public void onCreate() {
        MediaBrowserServiceCompat mediaBrowserServiceCompat = this.this$0;
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$MediaBrowserServiceApi23 mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$MediaBrowserServiceApi23 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$MediaBrowserServiceApi23(this, (Context)mediaBrowserServiceCompat);
        this.mServiceFwk = mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$MediaBrowserServiceApi23;
        mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$MediaBrowserServiceApi23.onCreate();
    }

    public void onLoadItem(String string2, MediaBrowserServiceCompat$ResultWrapper object) {
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord;
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1 mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1(this, string2, (MediaBrowserServiceCompat$ResultWrapper)object);
        object = this.this$0;
        ((MediaBrowserServiceCompat)object).mCurConnection = mediaBrowserServiceCompat$ConnectionRecord = ((MediaBrowserServiceCompat)object).mConnectionFromFwk;
        ((MediaBrowserServiceCompat)((Object)object)).onLoadItem(string2, mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1);
        this.this$0.mCurConnection = null;
    }
}

