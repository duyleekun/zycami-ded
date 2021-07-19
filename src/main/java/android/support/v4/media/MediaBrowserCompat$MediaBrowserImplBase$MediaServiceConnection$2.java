/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.util.Log
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection;
import android.util.Log;

public class MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$2
implements Runnable {
    public final /* synthetic */ MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection this$1;
    public final /* synthetic */ ComponentName val$name;

    public MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$2(MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection mediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection, ComponentName componentName) {
        this.this$1 = mediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection;
        this.val$name = componentName;
    }

    public void run() {
        Object object;
        Object object2;
        boolean bl2 = MediaBrowserCompat.DEBUG;
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("MediaServiceConnection.onServiceDisconnected name=");
            object = this.val$name;
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append(" this=");
            ((StringBuilder)object2).append(this);
            ((StringBuilder)object2).append(" mServiceConnection=");
            object = this.this$1.this$0.mServiceConnection;
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            object = "MediaBrowserCompat";
            Log.d((String)object, (String)object2);
            object2 = this.this$1.this$0;
            ((MediaBrowserCompat$MediaBrowserImplBase)object2).dump();
        }
        if (!(bl2 = ((MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection)(object2 = this.this$1)).isCurrent((String)(object = "onServiceDisconnected")))) {
            return;
        }
        object2 = this.this$1.this$0;
        ((MediaBrowserCompat$MediaBrowserImplBase)object2).mServiceBinderWrapper = null;
        ((MediaBrowserCompat$MediaBrowserImplBase)object2).mCallbacksMessenger = null;
        ((MediaBrowserCompat$MediaBrowserImplBase)object2).mHandler.setCallbacksMessenger(null);
        object2 = this.this$1.this$0;
        ((MediaBrowserCompat$MediaBrowserImplBase)object2).mState = 4;
        ((MediaBrowserCompat$MediaBrowserImplBase)object2).mCallback.onConnectionSuspended();
    }
}

