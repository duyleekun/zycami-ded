/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder$DeathRecipient
 */
package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$BrowserRoot;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord$1;
import androidx.media.MediaBrowserServiceCompat$ServiceCallbacks;
import androidx.media.MediaBrowserServiceCompat$ServiceHandler;
import androidx.media.MediaSessionManager$RemoteUserInfo;
import java.util.HashMap;

public class MediaBrowserServiceCompat$ConnectionRecord
implements IBinder.DeathRecipient {
    public final MediaSessionManager$RemoteUserInfo browserInfo;
    public final MediaBrowserServiceCompat$ServiceCallbacks callbacks;
    public final int pid;
    public final String pkg;
    public MediaBrowserServiceCompat$BrowserRoot root;
    public final Bundle rootHints;
    public final HashMap subscriptions;
    public final /* synthetic */ MediaBrowserServiceCompat this$0;
    public final int uid;

    public MediaBrowserServiceCompat$ConnectionRecord(MediaBrowserServiceCompat object, String string2, int n10, int n11, Bundle bundle, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        this.this$0 = object;
        this.subscriptions = object;
        this.pkg = string2;
        this.pid = n10;
        this.uid = n11;
        super(string2, n10, n11);
        this.browserInfo = object;
        this.rootHints = bundle;
        this.callbacks = mediaBrowserServiceCompat$ServiceCallbacks;
    }

    public void binderDied() {
        MediaBrowserServiceCompat$ServiceHandler mediaBrowserServiceCompat$ServiceHandler = this.this$0.mHandler;
        MediaBrowserServiceCompat$ConnectionRecord$1 mediaBrowserServiceCompat$ConnectionRecord$1 = new MediaBrowserServiceCompat$ConnectionRecord$1(this);
        mediaBrowserServiceCompat$ServiceHandler.post(mediaBrowserServiceCompat$ConnectionRecord$1);
    }
}

