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
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase;
import androidx.media.MediaSessionManager$RemoteUserInfo;

public class MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3
implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplBase this$1;
    public final /* synthetic */ Bundle val$options;
    public final /* synthetic */ String val$parentId;
    public final /* synthetic */ MediaSessionManager$RemoteUserInfo val$remoteUserInfo;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3(MediaBrowserServiceCompat$MediaBrowserServiceImplBase mediaBrowserServiceCompat$MediaBrowserServiceImplBase, MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, String string2, Bundle bundle) {
        this.this$1 = mediaBrowserServiceCompat$MediaBrowserServiceImplBase;
        this.val$remoteUserInfo = mediaSessionManager$RemoteUserInfo;
        this.val$parentId = string2;
        this.val$options = bundle;
    }

    public void run() {
        Object object;
        int n10;
        MediaBrowserServiceCompat$MediaBrowserServiceImplBase mediaBrowserServiceCompat$MediaBrowserServiceImplBase = null;
        for (int i10 = 0; i10 < (n10 = ((SimpleArrayMap)(object = this.this$1.this$0.mConnections)).size()); ++i10) {
            object = (MediaBrowserServiceCompat$ConnectionRecord)this.this$1.this$0.mConnections.valueAt(i10);
            Object object2 = ((MediaBrowserServiceCompat$ConnectionRecord)object).browserInfo;
            MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo = this.val$remoteUserInfo;
            boolean bl2 = ((MediaSessionManager$RemoteUserInfo)object2).equals(mediaSessionManager$RemoteUserInfo);
            if (!bl2) continue;
            mediaBrowserServiceCompat$MediaBrowserServiceImplBase = this.this$1;
            object2 = this.val$parentId;
            mediaSessionManager$RemoteUserInfo = this.val$options;
            mediaBrowserServiceCompat$MediaBrowserServiceImplBase.notifyChildrenChangedOnHandler((MediaBrowserServiceCompat$ConnectionRecord)object, (String)object2, (Bundle)mediaSessionManager$RemoteUserInfo);
            break;
        }
    }
}

