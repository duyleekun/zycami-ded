/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder$DeathRecipient
 *  android.os.RemoteException
 *  android.util.Log
 */
package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$BrowserRoot;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl;
import androidx.media.MediaBrowserServiceCompat$ServiceCallbacks;

public class MediaBrowserServiceCompat$ServiceBinderImpl$1
implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    public final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    public final /* synthetic */ int val$pid;
    public final /* synthetic */ String val$pkg;
    public final /* synthetic */ Bundle val$rootHints;
    public final /* synthetic */ int val$uid;

    public MediaBrowserServiceCompat$ServiceBinderImpl$1(MediaBrowserServiceCompat$ServiceBinderImpl serviceBinderImpl, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks, String string2, int n10, int n11, Bundle bundle) {
        this.this$1 = serviceBinderImpl;
        this.val$callbacks = mediaBrowserServiceCompat$ServiceCallbacks;
        this.val$pkg = string2;
        this.val$pid = n10;
        this.val$uid = n11;
        this.val$rootHints = bundle;
    }

    public void run() {
        block20: {
            Object object;
            Object object2 = this.val$callbacks.asBinder();
            this.this$1.this$0.mConnections.remove(object2);
            Object object3 = this.this$1.this$0;
            String string2 = this.val$pkg;
            int n10 = this.val$pid;
            int n11 = this.val$uid;
            Bundle bundle = this.val$rootHints;
            MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks = this.val$callbacks;
            Object object4 = object;
            object = new MediaBrowserServiceCompat$ConnectionRecord((MediaBrowserServiceCompat)((Object)object3), string2, n10, n11, bundle, mediaBrowserServiceCompat$ServiceCallbacks);
            object4 = this.this$1.this$0;
            ((MediaBrowserServiceCompat)object4).mCurConnection = object;
            object3 = this.val$pkg;
            int n12 = this.val$uid;
            Object object5 = this.val$rootHints;
            ((MediaBrowserServiceCompat$ConnectionRecord)object).root = object4 = ((MediaBrowserServiceCompat)((Object)object4)).onGetRoot((String)object3, n12, (Bundle)object5);
            object3 = this.this$1.this$0;
            n12 = 0;
            ((MediaBrowserServiceCompat)object3).mCurConnection = null;
            string2 = "MBServiceCompat";
            if (object4 == null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("No root for client ");
                object = this.val$pkg;
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(" from service ");
                object = this.getClass().getName();
                ((StringBuilder)object2).append((String)object);
                object2 = ((StringBuilder)object2).toString();
                Log.i((String)string2, (String)object2);
                object2 = this.val$callbacks;
                try {
                    object2.onConnectFailed();
                }
                catch (RemoteException remoteException) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Calling onConnectFailed() failed. Ignoring. pkg=");
                    object = this.val$pkg;
                    ((StringBuilder)object2).append((String)object);
                    object2 = ((StringBuilder)object2).toString();
                    Log.w((String)string2, (String)object2);
                }
            } else {
                object4 = ((MediaBrowserServiceCompat)object3).mConnections;
                ((SimpleArrayMap)object4).put(object2, object);
                object4 = null;
                object2.linkToDeath((IBinder.DeathRecipient)object, 0);
                object4 = this.this$1;
                object4 = ((MediaBrowserServiceCompat$ServiceBinderImpl)object4).this$0;
                object4 = ((MediaBrowserServiceCompat)object4).mSession;
                if (object4 == null) break block20;
                object4 = this.val$callbacks;
                object3 = ((MediaBrowserServiceCompat$ConnectionRecord)object).root;
                object3 = ((MediaBrowserServiceCompat$BrowserRoot)object3).getRootId();
                object5 = this.this$1;
                object5 = object5.this$0;
                object5 = object5.mSession;
                object = ((MediaBrowserServiceCompat$ConnectionRecord)object).root;
                object = ((MediaBrowserServiceCompat$BrowserRoot)object).getExtras();
                try {
                    object4.onConnect((String)object3, (MediaSessionCompat$Token)object5, (Bundle)object);
                }
                catch (RemoteException remoteException) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Calling onConnect() failed. Dropping client. pkg=");
                    object4 = this.val$pkg;
                    ((StringBuilder)object).append((String)object4);
                    object = ((StringBuilder)object).toString();
                    Log.w((String)string2, (String)object);
                    object = this.this$1.this$0.mConnections;
                    ((SimpleArrayMap)object).remove(object2);
                }
            }
        }
    }
}

