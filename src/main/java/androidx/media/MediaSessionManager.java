/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package androidx.media;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.media.MediaSessionManager$MediaSessionManagerImpl;
import androidx.media.MediaSessionManager$RemoteUserInfo;
import androidx.media.MediaSessionManager$RemoteUserInfoImpl;
import androidx.media.MediaSessionManagerImplApi21;
import androidx.media.MediaSessionManagerImplApi28;
import androidx.media.MediaSessionManagerImplBase;

public final class MediaSessionManager {
    public static final boolean DEBUG = false;
    public static final String TAG = "MediaSessionManager";
    private static final Object sLock;
    private static volatile MediaSessionManager sSessionManager;
    public MediaSessionManager$MediaSessionManagerImpl mImpl;

    static {
        Object object;
        DEBUG = Log.isLoggable((String)TAG, (int)3);
        sLock = object = new Object();
    }

    private MediaSessionManager(Context context) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            MediaSessionManagerImplApi28 mediaSessionManagerImplApi28 = new MediaSessionManagerImplApi28(context);
            this.mImpl = mediaSessionManagerImplApi28;
        } else {
            n11 = 21;
            if (n10 >= n11) {
                MediaSessionManagerImplApi21 mediaSessionManagerImplApi21 = new MediaSessionManagerImplApi21(context);
                this.mImpl = mediaSessionManagerImplApi21;
            } else {
                MediaSessionManagerImplBase mediaSessionManagerImplBase = new MediaSessionManagerImplBase(context);
                this.mImpl = mediaSessionManagerImplBase;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static MediaSessionManager getSessionManager(Context object) {
        if (object == null) {
            object = new IllegalArgumentException("context cannot be null");
            throw object;
        }
        Object object2 = sLock;
        synchronized (object2) {
            MediaSessionManager mediaSessionManager = sSessionManager;
            if (mediaSessionManager != null) return sSessionManager;
            object = object.getApplicationContext();
            sSessionManager = mediaSessionManager = new MediaSessionManager((Context)object);
            return sSessionManager;
        }
    }

    public Context getContext() {
        return this.mImpl.getContext();
    }

    public boolean isTrustedForMediaControl(MediaSessionManager$RemoteUserInfo object) {
        if (object != null) {
            MediaSessionManager$MediaSessionManagerImpl mediaSessionManager$MediaSessionManagerImpl = this.mImpl;
            object = ((MediaSessionManager$RemoteUserInfo)object).mImpl;
            return mediaSessionManager$MediaSessionManagerImpl.isTrustedForMediaControl((MediaSessionManager$RemoteUserInfoImpl)object);
        }
        object = new IllegalArgumentException("userInfo should not be null");
        throw object;
    }
}

