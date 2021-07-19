/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.util.Log
 */
package androidx.media;

import android.os.IBinder;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl;
import androidx.media.MediaBrowserServiceCompat$ServiceCallbacks;

public class MediaBrowserServiceCompat$ServiceBinderImpl$4
implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    public final /* synthetic */ String val$id;
    public final /* synthetic */ IBinder val$token;

    public MediaBrowserServiceCompat$ServiceBinderImpl$4(MediaBrowserServiceCompat$ServiceBinderImpl mediaBrowserServiceCompat$ServiceBinderImpl, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks, String string2, IBinder iBinder) {
        this.this$1 = mediaBrowserServiceCompat$ServiceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$ServiceCallbacks;
        this.val$id = string2;
        this.val$token = iBinder;
    }

    public void run() {
        Object object = this.val$callbacks.asBinder();
        object = (MediaBrowserServiceCompat$ConnectionRecord)this.this$1.this$0.mConnections.get(object);
        String string2 = "MBServiceCompat";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("removeSubscription for callback that isn't registered id=");
            String string3 = this.val$id;
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            Log.w((String)string2, (String)object);
            return;
        }
        Object object2 = this.this$1.this$0;
        String string4 = this.val$id;
        IBinder iBinder = this.val$token;
        boolean bl2 = object2.removeSubscription(string4, (MediaBrowserServiceCompat$ConnectionRecord)object, iBinder);
        if (!bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("removeSubscription called for ");
            object2 = this.val$id;
            ((StringBuilder)object).append((String)object2);
            object2 = " which is not subscribed";
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            Log.w((String)string2, (String)object);
        }
    }
}

