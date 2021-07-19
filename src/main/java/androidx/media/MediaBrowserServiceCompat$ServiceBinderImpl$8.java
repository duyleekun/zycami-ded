/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.util.Log
 */
package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl;
import androidx.media.MediaBrowserServiceCompat$ServiceCallbacks;

public class MediaBrowserServiceCompat$ServiceBinderImpl$8
implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    public final /* synthetic */ Bundle val$extras;
    public final /* synthetic */ String val$query;
    public final /* synthetic */ ResultReceiver val$receiver;

    public MediaBrowserServiceCompat$ServiceBinderImpl$8(MediaBrowserServiceCompat$ServiceBinderImpl mediaBrowserServiceCompat$ServiceBinderImpl, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks, String string2, Bundle bundle, ResultReceiver resultReceiver) {
        this.this$1 = mediaBrowserServiceCompat$ServiceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$ServiceCallbacks;
        this.val$query = string2;
        this.val$extras = bundle;
        this.val$receiver = resultReceiver;
    }

    public void run() {
        Object object = this.val$callbacks.asBinder();
        Object object2 = this.this$1.this$0.mConnections;
        if ((object = (MediaBrowserServiceCompat$ConnectionRecord)((SimpleArrayMap)object2).get(object)) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("search for callback that isn't registered query=");
            object2 = this.val$query;
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            Log.w((String)"MBServiceCompat", (String)object);
            return;
        }
        object2 = this.this$1.this$0;
        String string2 = this.val$query;
        Bundle bundle = this.val$extras;
        ResultReceiver resultReceiver = this.val$receiver;
        ((MediaBrowserServiceCompat)((Object)object2)).performSearch(string2, bundle, (MediaBrowserServiceCompat$ConnectionRecord)object, resultReceiver);
    }
}

