/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.service.media.MediaBrowserService
 */
package androidx.media;

import android.content.Context;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$1;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26;
import androidx.media.MediaBrowserServiceCompat$ResultWrapper;

public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi26
extends MediaBrowserServiceCompat$MediaBrowserServiceImplApi23 {
    public final /* synthetic */ MediaBrowserServiceCompat this$0;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi26(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.this$0 = mediaBrowserServiceCompat;
        super(mediaBrowserServiceCompat);
    }

    public Bundle getBrowserRootHints() {
        Object object = this.this$0;
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = object.mCurConnection;
        if (mediaBrowserServiceCompat$ConnectionRecord != null) {
            object = object.mConnectionFromFwk;
            if (mediaBrowserServiceCompat$ConnectionRecord == object) {
                return this.mServiceFwk.getBrowserRootHints();
            }
            object = mediaBrowserServiceCompat$ConnectionRecord.rootHints;
            if (object == null) {
                object = null;
            } else {
                mediaBrowserServiceCompat$ConnectionRecord = this.this$0.mCurConnection.rootHints;
                object = new Bundle((Bundle)mediaBrowserServiceCompat$ConnectionRecord);
            }
            return object;
        }
        object = new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        throw object;
    }

    public void notifyChildrenChangedForFramework(String string2, Bundle bundle) {
        if (bundle != null) {
            MediaBrowserService mediaBrowserService = this.mServiceFwk;
            mediaBrowserService.notifyChildrenChanged(string2, bundle);
        } else {
            super.notifyChildrenChangedForFramework(string2, bundle);
        }
    }

    public void onCreate() {
        MediaBrowserServiceCompat mediaBrowserServiceCompat = this.this$0;
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26 mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26(this, (Context)mediaBrowserServiceCompat);
        this.mServiceFwk = mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26;
        mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$MediaBrowserServiceApi26.onCreate();
    }

    public void onLoadChildren(String string2, MediaBrowserServiceCompat$ResultWrapper object, Bundle bundle) {
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord;
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$1 mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$1 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$1(this, string2, (MediaBrowserServiceCompat$ResultWrapper)object, bundle);
        object = this.this$0;
        ((MediaBrowserServiceCompat)object).mCurConnection = mediaBrowserServiceCompat$ConnectionRecord = ((MediaBrowserServiceCompat)object).mConnectionFromFwk;
        ((MediaBrowserServiceCompat)((Object)object)).onLoadChildren(string2, mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$1, bundle);
        this.this$0.mCurConnection = null;
    }
}

