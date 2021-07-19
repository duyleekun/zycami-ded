/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.media;

import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl;
import androidx.media.MediaBrowserServiceCompat$ServiceCallbacks;

public class MediaBrowserServiceCompat$ServiceBinderImpl$5
implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    public final /* synthetic */ String val$mediaId;
    public final /* synthetic */ ResultReceiver val$receiver;

    public MediaBrowserServiceCompat$ServiceBinderImpl$5(MediaBrowserServiceCompat$ServiceBinderImpl mediaBrowserServiceCompat$ServiceBinderImpl, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks, String string2, ResultReceiver resultReceiver) {
        this.this$1 = mediaBrowserServiceCompat$ServiceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$ServiceCallbacks;
        this.val$mediaId = string2;
        this.val$receiver = resultReceiver;
    }

    public void run() {
        Object object = this.val$callbacks.asBinder();
        Object object2 = this.this$1.this$0.mConnections;
        if ((object = (MediaBrowserServiceCompat$ConnectionRecord)((SimpleArrayMap)object2).get(object)) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("getMediaItem for callback that isn't registered id=");
            object2 = this.val$mediaId;
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            Log.w((String)"MBServiceCompat", (String)object);
            return;
        }
        object2 = this.this$1.this$0;
        String string2 = this.val$mediaId;
        ResultReceiver resultReceiver = this.val$receiver;
        ((MediaBrowserServiceCompat)((Object)object2)).performLoadItem(string2, (MediaBrowserServiceCompat$ConnectionRecord)object, resultReceiver);
    }
}

