/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Messenger
 *  android.os.RemoteException
 *  android.util.Log
 */
package android.support.v4.media;

import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase;
import android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper;
import android.util.Log;

public class MediaBrowserCompat$MediaBrowserImplBase$2
implements Runnable {
    public final /* synthetic */ MediaBrowserCompat$MediaBrowserImplBase this$0;

    public MediaBrowserCompat$MediaBrowserImplBase$2(MediaBrowserCompat$MediaBrowserImplBase mediaBrowserCompat$MediaBrowserImplBase) {
        this.this$0 = mediaBrowserCompat$MediaBrowserImplBase;
    }

    public void run() {
        boolean bl2;
        Object object = this.this$0;
        Messenger messenger = ((MediaBrowserCompat$MediaBrowserImplBase)object).mCallbacksMessenger;
        String string2 = "MediaBrowserCompat";
        if (messenger != null) {
            object = ((MediaBrowserCompat$MediaBrowserImplBase)object).mServiceBinderWrapper;
            try {
                ((MediaBrowserCompat$ServiceBinderWrapper)object).disconnect(messenger);
            }
            catch (RemoteException remoteException) {
                object = new StringBuilder();
                ((StringBuilder)object).append("RemoteException during connect for ");
                messenger = this.this$0.mServiceComponent;
                ((StringBuilder)object).append(messenger);
                object = ((StringBuilder)object).toString();
                Log.w((String)string2, (String)object);
            }
        }
        object = this.this$0;
        int n10 = ((MediaBrowserCompat$MediaBrowserImplBase)object).mState;
        ((MediaBrowserCompat$MediaBrowserImplBase)object).forceCloseConnection();
        if (n10 != 0) {
            object = this.this$0;
            ((MediaBrowserCompat$MediaBrowserImplBase)object).mState = n10;
        }
        if (bl2 = MediaBrowserCompat.DEBUG) {
            Log.d((String)string2, (String)"disconnect...");
            object = this.this$0;
            ((MediaBrowserCompat$MediaBrowserImplBase)object).dump();
        }
    }
}

