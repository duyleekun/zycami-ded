/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package android.support.v4.media.session;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.MediaSessionCompat$Callback;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl;
import androidx.media.MediaSessionManager$RemoteUserInfo;
import java.lang.ref.Reference;

public class MediaSessionCompat$Callback$CallbackHandler
extends Handler {
    private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;
    public final /* synthetic */ MediaSessionCompat$Callback this$0;

    public MediaSessionCompat$Callback$CallbackHandler(MediaSessionCompat$Callback callback, Looper looper) {
        this.this$0 = callback;
        super(looper);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void handleMessage(Message object) {
        MediaSessionCompat$Callback$CallbackHandler mediaSessionCompat$Callback$CallbackHandler;
        MediaSessionCompat$Callback mediaSessionCompat$Callback;
        Object object2;
        int n10 = object.what;
        int n11 = 1;
        if (n10 != n11) return;
        Object object3 = this.this$0.mLock;
        synchronized (object3) {
            object2 = this.this$0;
            object2 = ((MediaSessionCompat$Callback)object2).mSessionImpl;
            object2 = ((Reference)object2).get();
            object2 = (MediaSessionCompat$MediaSessionImpl)object2;
            mediaSessionCompat$Callback = this.this$0;
            mediaSessionCompat$Callback$CallbackHandler = mediaSessionCompat$Callback.mCallbackHandler;
        }
        if (object2 == null) return;
        object3 = object2.getCallback();
        if (mediaSessionCompat$Callback != object3) return;
        if (mediaSessionCompat$Callback$CallbackHandler == null) {
            return;
        }
        object = (MediaSessionManager$RemoteUserInfo)object.obj;
        object2.setCurrentControllerInfo((MediaSessionManager$RemoteUserInfo)object);
        this.this$0.handleMediaPlayPauseIfPendingOnHandler((MediaSessionCompat$MediaSessionImpl)object2, mediaSessionCompat$Callback$CallbackHandler);
        object = null;
        object2.setCurrentControllerInfo(null);
    }
}

