/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.util.Log
 */
package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl;
import androidx.media.MediaBrowserServiceCompat$ServiceCallbacks;

public class MediaBrowserServiceCompat$ServiceBinderImpl$3
implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    public final /* synthetic */ String val$id;
    public final /* synthetic */ Bundle val$options;
    public final /* synthetic */ IBinder val$token;

    public MediaBrowserServiceCompat$ServiceBinderImpl$3(MediaBrowserServiceCompat$ServiceBinderImpl mediaBrowserServiceCompat$ServiceBinderImpl, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks, String string2, IBinder iBinder, Bundle bundle) {
        this.this$1 = mediaBrowserServiceCompat$ServiceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$ServiceCallbacks;
        this.val$id = string2;
        this.val$token = iBinder;
        this.val$options = bundle;
    }

    public void run() {
        Object object = this.val$callbacks.asBinder();
        Object object2 = this.this$1.this$0.mConnections;
        if ((object = (MediaBrowserServiceCompat$ConnectionRecord)((SimpleArrayMap)object2).get(object)) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("addSubscription for callback that isn't registered id=");
            object2 = this.val$id;
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            Log.w((String)"MBServiceCompat", (String)object);
            return;
        }
        object2 = this.this$1.this$0;
        String string2 = this.val$id;
        IBinder iBinder = this.val$token;
        Bundle bundle = this.val$options;
        ((MediaBrowserServiceCompat)((Object)object2)).addSubscription(string2, (MediaBrowserServiceCompat$ConnectionRecord)object, iBinder, bundle);
    }
}

