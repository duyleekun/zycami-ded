/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.ResultReceiver
 */
package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.IMediaSession$Stub;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21;
import android.support.v4.media.session.MediaSessionCompat$Token;
import androidx.core.app.BundleCompat;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.ref.WeakReference;

public class MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver
extends ResultReceiver {
    private WeakReference mMediaControllerImpl;

    public MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver(MediaControllerCompat$MediaControllerImplApi21 mediaControllerImplApi21) {
        super(null);
        WeakReference<MediaControllerCompat$MediaControllerImplApi21> weakReference;
        this.mMediaControllerImpl = weakReference = new WeakReference<MediaControllerCompat$MediaControllerImplApi21>(mediaControllerImplApi21);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onReceiveResult(int n10, Bundle object) {
        MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = (MediaControllerCompat$MediaControllerImplApi21)this.mMediaControllerImpl.get();
        if (mediaControllerCompat$MediaControllerImplApi21 == null) return;
        if (object == null) {
            return;
        }
        Object object2 = mediaControllerCompat$MediaControllerImplApi21.mLock;
        synchronized (object2) {
            MediaSessionCompat$Token mediaSessionCompat$Token = mediaControllerCompat$MediaControllerImplApi21.mSessionToken;
            Object object3 = "android.support.v4.media.session.EXTRA_BINDER";
            object3 = BundleCompat.getBinder(object, (String)object3);
            object3 = IMediaSession$Stub.asInterface((IBinder)object3);
            mediaSessionCompat$Token.setExtraBinder((IMediaSession)object3);
            mediaSessionCompat$Token = mediaControllerCompat$MediaControllerImplApi21.mSessionToken;
            object3 = "android.support.v4.media.session.SESSION_TOKEN2";
            object = ParcelUtils.getVersionedParcelable(object, (String)object3);
            mediaSessionCompat$Token.setSession2Token((VersionedParcelable)object);
            mediaControllerCompat$MediaControllerImplApi21.processPendingCallbacksLocked();
            return;
        }
    }
}

