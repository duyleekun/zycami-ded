/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder$DeathRecipient
 */
package androidx.media;

import android.os.IBinder;
import androidx.collection.ArrayMap;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl;
import androidx.media.MediaBrowserServiceCompat$ServiceCallbacks;

public class MediaBrowserServiceCompat$ServiceBinderImpl$2
implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;

    public MediaBrowserServiceCompat$ServiceBinderImpl$2(MediaBrowserServiceCompat$ServiceBinderImpl mediaBrowserServiceCompat$ServiceBinderImpl, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        this.this$1 = mediaBrowserServiceCompat$ServiceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$ServiceCallbacks;
    }

    public void run() {
        Object object = this.val$callbacks.asBinder();
        ArrayMap arrayMap = this.this$1.this$0.mConnections;
        if ((object = (MediaBrowserServiceCompat$ConnectionRecord)arrayMap.remove(object)) != null) {
            arrayMap = object.callbacks.asBinder();
            arrayMap.unlinkToDeath((IBinder.DeathRecipient)object, 0);
        }
    }
}

