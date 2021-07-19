/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.session.MediaSession
 *  android.os.Bundle
 */
package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi28;
import androidx.versionedparcelable.VersionedParcelable;

public class MediaSessionCompat$MediaSessionImplApi29
extends MediaSessionCompat$MediaSessionImplApi28 {
    public MediaSessionCompat$MediaSessionImplApi29(MediaSession mediaSession, VersionedParcelable versionedParcelable, Bundle bundle) {
        super(mediaSession, versionedParcelable, bundle);
    }

    public MediaSessionCompat$MediaSessionImplApi29(Object object) {
        super(object);
        object = ((MediaSession)object).getController().getSessionInfo();
        this.mSessionInfo = object;
    }
}

