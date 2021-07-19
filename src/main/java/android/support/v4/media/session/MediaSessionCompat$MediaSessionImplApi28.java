/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.session.MediaSession
 *  android.media.session.MediaSessionManager$RemoteUserInfo
 *  android.os.Bundle
 */
package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21;
import androidx.media.MediaSessionManager$RemoteUserInfo;
import androidx.versionedparcelable.VersionedParcelable;

public class MediaSessionCompat$MediaSessionImplApi28
extends MediaSessionCompat$MediaSessionImplApi21 {
    public MediaSessionCompat$MediaSessionImplApi28(MediaSession mediaSession, VersionedParcelable versionedParcelable, Bundle bundle) {
        super(mediaSession, versionedParcelable, bundle);
    }

    public MediaSessionCompat$MediaSessionImplApi28(Object object) {
        super(object);
    }

    public final MediaSessionManager$RemoteUserInfo getCurrentControllerInfo() {
        MediaSessionManager.RemoteUserInfo remoteUserInfo = this.mSessionFwk.getCurrentControllerInfo();
        MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo = new MediaSessionManager$RemoteUserInfo(remoteUserInfo);
        return mediaSessionManager$RemoteUserInfo;
    }

    public void setCurrentControllerInfo(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
    }
}

