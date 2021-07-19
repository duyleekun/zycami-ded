/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.session.MediaSessionManager
 */
package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import androidx.media.MediaSessionManager$RemoteUserInfoImpl;
import androidx.media.MediaSessionManagerImplApi21;

public class MediaSessionManagerImplApi28
extends MediaSessionManagerImplApi21 {
    public MediaSessionManager mObject;

    public MediaSessionManagerImplApi28(Context context) {
        super(context);
        context = (MediaSessionManager)context.getSystemService("media_session");
        this.mObject = context;
    }

    public boolean isTrustedForMediaControl(MediaSessionManager$RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl) {
        return super.isTrustedForMediaControl(mediaSessionManager$RemoteUserInfoImpl);
    }
}

