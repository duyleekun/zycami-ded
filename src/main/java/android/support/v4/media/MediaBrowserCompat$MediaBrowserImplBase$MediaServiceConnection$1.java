/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Messenger
 *  android.os.RemoteException
 *  android.util.Log
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection;
import android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper;
import android.util.Log;

public class MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$1
implements Runnable {
    public final /* synthetic */ MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection this$1;
    public final /* synthetic */ IBinder val$binder;
    public final /* synthetic */ ComponentName val$name;

    public MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$1(MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection mediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection, ComponentName componentName, IBinder iBinder) {
        this.this$1 = mediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection;
        this.val$name = componentName;
        this.val$binder = iBinder;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void run() {
        block11: {
            var1_1 = MediaBrowserCompat.DEBUG;
            var2_2 = "MediaBrowserCompat";
            if (var1_1) {
                var3_3 = new StringBuilder();
                var3_3.append("MediaServiceConnection.onServiceConnected name=");
                var4_4 = this.val$name;
                var3_3.append(var4_4);
                var3_3.append(" binder=");
                var4_4 = this.val$binder;
                var3_3.append(var4_4);
                var3_3 = var3_3.toString();
                Log.d((String)var2_2, (String)var3_3);
                var3_3 = this.this$1.this$0;
                var3_3.dump();
            }
            if (!(var5_5 = (var3_3 = this.this$1).isCurrent((String)(var4_4 = "onServiceConnected")))) {
                return;
            }
            var3_3 = this.this$1.this$0;
            var6_6 /* !! */  = this.val$binder;
            var7_7 = var3_3.mRootHints;
            var3_3.mServiceBinderWrapper = var4_4 = new MediaBrowserCompat$ServiceBinderWrapper(var6_6 /* !! */ , var7_7);
            var3_3 = this.this$1.this$0;
            var6_6 /* !! */  = this.this$1.this$0.mHandler;
            var4_4 = new Messenger((Handler)var6_6 /* !! */ );
            var3_3.mCallbacksMessenger = var4_4;
            var3_3 = this.this$1.this$0;
            var4_4 = var3_3.mHandler;
            var3_3 = var3_3.mCallbacksMessenger;
            var4_4.setCallbacksMessenger((Messenger)var3_3);
            var3_3 = this.this$1.this$0;
            var3_3.mState = var8_8 = 2;
            var3_3 = "ServiceCallbacks.onConnect...";
            if (!var1_1) ** GOTO lbl46
            Log.d((String)var2_2, (String)var3_3);
            var9_9 = this.this$1;
            var9_9 = var9_9.this$0;
            var9_9.dump();
lbl46:
            // 2 sources

            var9_9 = this.this$1;
            var9_9 = var9_9.this$0;
            var4_4 = var9_9.mServiceBinderWrapper;
            var6_6 /* !! */  = var9_9.mContext;
            var9_9 = var9_9.mCallbacksMessenger;
            try {
                var4_4.connect((Context)var6_6 /* !! */ , (Messenger)var9_9);
            }
            catch (RemoteException v0) {
                var9_9 = new StringBuilder();
                var9_9.append("RemoteException during connect for ");
                var4_4 = this.this$1.this$0.mServiceComponent;
                var9_9.append(var4_4);
                var9_9 = var9_9.toString();
                Log.w((String)var2_2, (String)var9_9);
                var1_1 = MediaBrowserCompat.DEBUG;
                if (!var1_1) break block11;
                Log.d((String)var2_2, (String)var3_3);
                var9_9 = this.this$1.this$0;
                var9_9.dump();
            }
        }
    }
}

