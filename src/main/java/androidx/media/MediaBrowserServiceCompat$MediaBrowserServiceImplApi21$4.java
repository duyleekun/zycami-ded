/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.media;

import android.os.Bundle;
import androidx.collection.SimpleArrayMap;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21;
import androidx.media.MediaSessionManager$RemoteUserInfo;

public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$4
implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 this$1;
    public final /* synthetic */ Bundle val$options;
    public final /* synthetic */ String val$parentId;
    public final /* synthetic */ MediaSessionManager$RemoteUserInfo val$remoteUserInfo;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$4(MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21, MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, String string2, Bundle bundle) {
        this.this$1 = mediaBrowserServiceCompat$MediaBrowserServiceImplApi21;
        this.val$remoteUserInfo = mediaSessionManager$RemoteUserInfo;
        this.val$parentId = string2;
        this.val$options = bundle;
    }

    public void run() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((SimpleArrayMap)(object = this.this$1.this$0.mConnections)).size()); ++i10) {
            object = (MediaBrowserServiceCompat$ConnectionRecord)this.this$1.this$0.mConnections.valueAt(i10);
            Object object2 = ((MediaBrowserServiceCompat$ConnectionRecord)object).browserInfo;
            Object object3 = this.val$remoteUserInfo;
            boolean bl2 = ((MediaSessionManager$RemoteUserInfo)object2).equals(object3);
            if (!bl2) continue;
            object2 = this.this$1;
            object3 = this.val$parentId;
            Bundle bundle = this.val$options;
            ((MediaBrowserServiceCompat$MediaBrowserServiceImplApi21)object2).notifyChildrenChangedForCompatOnHandler((MediaBrowserServiceCompat$ConnectionRecord)object, (String)object3, bundle);
        }
    }
}

