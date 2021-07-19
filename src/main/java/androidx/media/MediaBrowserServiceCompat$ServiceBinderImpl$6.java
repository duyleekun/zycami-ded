/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder$DeathRecipient
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  android.util.Log
 */
package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl;
import androidx.media.MediaBrowserServiceCompat$ServiceCallbacks;

public class MediaBrowserServiceCompat$ServiceBinderImpl$6
implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    public final /* synthetic */ int val$pid;
    public final /* synthetic */ String val$pkg;
    public final /* synthetic */ Bundle val$rootHints;
    public final /* synthetic */ int val$uid;

    public MediaBrowserServiceCompat$ServiceBinderImpl$6(MediaBrowserServiceCompat$ServiceBinderImpl mediaBrowserServiceCompat$ServiceBinderImpl, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks, int n10, String string2, int n11, Bundle bundle) {
        this.this$1 = mediaBrowserServiceCompat$ServiceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$ServiceCallbacks;
        this.val$uid = n10;
        this.val$pkg = string2;
        this.val$pid = n11;
        this.val$rootHints = bundle;
    }

    public void run() {
        Object object;
        Object object2;
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord;
        boolean bl2;
        Object object3 = this.val$callbacks.asBinder();
        this.this$1.this$0.mConnections.remove(object3);
        Object object4 = this.this$1.this$0.mPendingConnections.iterator();
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord2 = null;
        while (bl2 = object4.hasNext()) {
            mediaBrowserServiceCompat$ConnectionRecord = (MediaBrowserServiceCompat$ConnectionRecord)object4.next();
            int n10 = mediaBrowserServiceCompat$ConnectionRecord.uid;
            int n11 = this.val$uid;
            if (n10 != n11) continue;
            object2 = this.val$pkg;
            n10 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
            if (n10 != 0 || (n10 = this.val$pid) <= 0) {
                object2 = this.this$1;
                MediaBrowserServiceCompat mediaBrowserServiceCompat = ((MediaBrowserServiceCompat$ServiceBinderImpl)object2).this$0;
                String string2 = mediaBrowserServiceCompat$ConnectionRecord.pkg;
                int n12 = mediaBrowserServiceCompat$ConnectionRecord.pid;
                int n13 = mediaBrowserServiceCompat$ConnectionRecord.uid;
                Bundle bundle = this.val$rootHints;
                MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks = this.val$callbacks;
                object = mediaBrowserServiceCompat$ConnectionRecord2;
                mediaBrowserServiceCompat$ConnectionRecord2 = new MediaBrowserServiceCompat$ConnectionRecord(mediaBrowserServiceCompat, string2, n12, n13, bundle, mediaBrowserServiceCompat$ServiceCallbacks);
            }
            object4.remove();
        }
        if (mediaBrowserServiceCompat$ConnectionRecord2 == null) {
            object4 = this.this$1;
            object2 = ((MediaBrowserServiceCompat$ServiceBinderImpl)object4).this$0;
            object = this.val$pkg;
            int n14 = this.val$pid;
            int n15 = this.val$uid;
            Bundle bundle = this.val$rootHints;
            MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks = this.val$callbacks;
            mediaBrowserServiceCompat$ConnectionRecord = mediaBrowserServiceCompat$ConnectionRecord2;
            mediaBrowserServiceCompat$ConnectionRecord2 = new MediaBrowserServiceCompat$ConnectionRecord((MediaBrowserServiceCompat)((Object)object2), (String)object, n14, n15, bundle, mediaBrowserServiceCompat$ServiceCallbacks);
        }
        this.this$1.this$0.mConnections.put(object3, mediaBrowserServiceCompat$ConnectionRecord2);
        object4 = null;
        try {
            object3.linkToDeath((IBinder.DeathRecipient)mediaBrowserServiceCompat$ConnectionRecord2, 0);
        }
        catch (RemoteException remoteException) {
            object3 = "MBServiceCompat";
            object4 = "IBinder is already dead.";
            Log.w((String)object3, (String)object4);
        }
    }
}

