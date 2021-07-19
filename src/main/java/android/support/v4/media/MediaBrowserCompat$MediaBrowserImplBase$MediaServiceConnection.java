/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  android.util.Log
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$1;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$2;
import android.util.Log;

public class MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection
implements ServiceConnection {
    public final /* synthetic */ MediaBrowserCompat$MediaBrowserImplBase this$0;

    public MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection(MediaBrowserCompat$MediaBrowserImplBase mediaBrowserCompat$MediaBrowserImplBase) {
        this.this$0 = mediaBrowserCompat$MediaBrowserImplBase;
    }

    private void postOrRun(Runnable runnable) {
        Thread thread;
        Object object = Thread.currentThread();
        if (object == (thread = this.this$0.mHandler.getLooper().getThread())) {
            runnable.run();
        } else {
            object = this.this$0.mHandler;
            object.post(runnable);
        }
    }

    public boolean isCurrent(String object) {
        int n10;
        Object object2 = this.this$0;
        MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection mediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection = ((MediaBrowserCompat$MediaBrowserImplBase)object2).mServiceConnection;
        int n11 = 1;
        if (mediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection == this && (n10 = ((MediaBrowserCompat$MediaBrowserImplBase)object2).mState) && n10 != n11) {
            return n11;
        }
        int n12 = ((MediaBrowserCompat$MediaBrowserImplBase)object2).mState;
        if (n12 != 0 && n12 != n11) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" for ");
            object = this.this$0.mServiceComponent;
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append(" with mServiceConnection=");
            object = this.this$0.mServiceConnection;
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append(" this=");
            ((StringBuilder)object2).append(this);
            object = ((StringBuilder)object2).toString();
            object2 = "MediaBrowserCompat";
            Log.i((String)object2, (String)object);
        }
        return false;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$1 mediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$1 = new MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$1(this, componentName, iBinder);
        this.postOrRun(mediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$1);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$2 mediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$2 = new MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$2(this, componentName);
        this.postOrRun(mediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$2);
    }
}

