/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.session.MediaSessionManager$RemoteUserInfo
 */
package androidx.media;

import android.media.session.MediaSessionManager;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26;
import androidx.media.MediaSessionManager$RemoteUserInfo;

public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi28
extends MediaBrowserServiceCompat$MediaBrowserServiceImplApi26 {
    public final /* synthetic */ MediaBrowserServiceCompat this$0;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi28(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.this$0 = mediaBrowserServiceCompat;
        super(mediaBrowserServiceCompat);
    }

    public MediaSessionManager$RemoteUserInfo getCurrentBrowserInfo() {
        Object object = this.this$0;
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = object.mCurConnection;
        if (mediaBrowserServiceCompat$ConnectionRecord != null) {
            object = object.mConnectionFromFwk;
            if (mediaBrowserServiceCompat$ConnectionRecord == object) {
                mediaBrowserServiceCompat$ConnectionRecord = this.mServiceFwk.getCurrentBrowserInfo();
                object = new MediaSessionManager$RemoteUserInfo((MediaSessionManager.RemoteUserInfo)mediaBrowserServiceCompat$ConnectionRecord);
                return object;
            }
            return mediaBrowserServiceCompat$ConnectionRecord.browserInfo;
        }
        object = new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        throw object;
    }
}

