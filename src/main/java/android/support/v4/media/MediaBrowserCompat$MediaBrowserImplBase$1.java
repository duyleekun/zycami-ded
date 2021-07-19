/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.util.Log
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection;
import android.util.Log;

public class MediaBrowserCompat$MediaBrowserImplBase$1
implements Runnable {
    public final /* synthetic */ MediaBrowserCompat$MediaBrowserImplBase this$0;

    public MediaBrowserCompat$MediaBrowserImplBase$1(MediaBrowserCompat$MediaBrowserImplBase mediaBrowserImplBase) {
        this.this$0 = mediaBrowserImplBase;
    }

    public void run() {
        Object object;
        Object object2 = "MediaBrowserCompat";
        Object object3 = this.this$0;
        int n10 = ((MediaBrowserCompat$MediaBrowserImplBase)object3).mState;
        if (n10 == 0) {
            return;
        }
        ((MediaBrowserCompat$MediaBrowserImplBase)object3).mState = 2;
        n10 = MediaBrowserCompat.DEBUG ? 1 : 0;
        if (n10 != 0 && (object = ((MediaBrowserCompat$MediaBrowserImplBase)object3).mServiceConnection) != null) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("mServiceConnection should be null. Instead it is ");
            object = this.this$0.mServiceConnection;
            ((StringBuilder)object3).append(object);
            object3 = ((StringBuilder)object3).toString();
            object2 = new RuntimeException((String)object3);
            throw object2;
        }
        object = ((MediaBrowserCompat$MediaBrowserImplBase)object3).mServiceBinderWrapper;
        if (object == null) {
            object3 = ((MediaBrowserCompat$MediaBrowserImplBase)object3).mCallbacksMessenger;
            if (object3 == null) {
                boolean bl2;
                object3 = new Intent("android.media.browse.MediaBrowserService");
                object = this.this$0.mServiceComponent;
                object3.setComponent((ComponentName)object);
                object = this.this$0;
                Object object4 = new MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection((MediaBrowserCompat$MediaBrowserImplBase)object);
                ((MediaBrowserCompat$MediaBrowserImplBase)object).mServiceConnection = object4;
                n10 = 0;
                object = null;
                object4 = this.this$0;
                Context context = ((MediaBrowserCompat$MediaBrowserImplBase)object4).mContext;
                object4 = ((MediaBrowserCompat$MediaBrowserImplBase)object4).mServiceConnection;
                int n11 = 1;
                try {
                    n10 = context.bindService((Intent)object3, (ServiceConnection)object4, n11) ? 1 : 0;
                }
                catch (Exception exception) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Failed binding to service ");
                    object4 = this.this$0.mServiceComponent;
                    ((StringBuilder)object3).append(object4);
                    object3 = ((StringBuilder)object3).toString();
                    Log.e((String)object2, (String)object3);
                }
                if (n10 == 0) {
                    this.this$0.forceCloseConnection();
                    object3 = this.this$0.mCallback;
                    ((MediaBrowserCompat$ConnectionCallback)object3).onConnectionFailed();
                }
                if (bl2 = MediaBrowserCompat.DEBUG) {
                    object3 = "connect...";
                    Log.d((String)object2, (String)object3);
                    object2 = this.this$0;
                    ((MediaBrowserCompat$MediaBrowserImplBase)object2).dump();
                }
                return;
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("mCallbacksMessenger should be null. Instead it is ");
            object = this.this$0.mCallbacksMessenger;
            ((StringBuilder)object3).append(object);
            object3 = ((StringBuilder)object3).toString();
            object2 = new RuntimeException((String)object3);
            throw object2;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("mServiceBinderWrapper should be null. Instead it is ");
        object = this.this$0.mServiceBinderWrapper;
        ((StringBuilder)object3).append(object);
        object3 = ((StringBuilder)object3).toString();
        object2 = new RuntimeException((String)object3);
        throw object2;
    }
}

