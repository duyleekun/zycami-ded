/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.media;

import android.content.Context;
import androidx.media.MediaSessionManager$RemoteUserInfoImpl;
import androidx.media.MediaSessionManagerImplBase;

public class MediaSessionManagerImplApi21
extends MediaSessionManagerImplBase {
    public MediaSessionManagerImplApi21(Context context) {
        super(context);
        this.mContext = context;
    }

    /*
     * WARNING - void declaration
     */
    private boolean hasMediaControlPermission(MediaSessionManager$RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl) {
        void var4_8;
        int bl2;
        int n10;
        String string2;
        Context context = this.getContext();
        int n11 = context.checkPermission(string2 = "android.permission.MEDIA_CONTENT_CONTROL", n10 = mediaSessionManager$RemoteUserInfoImpl.getPid(), bl2 = mediaSessionManager$RemoteUserInfoImpl.getUid());
        if (n11 == 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            mediaSessionManager$RemoteUserInfoImpl = null;
        }
        return (boolean)var4_8;
    }

    public boolean isTrustedForMediaControl(MediaSessionManager$RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl) {
        boolean bl2;
        boolean bl3 = this.hasMediaControlPermission(mediaSessionManager$RemoteUserInfoImpl);
        if (!bl3 && !(bl2 = super.isTrustedForMediaControl(mediaSessionManager$RemoteUserInfoImpl))) {
            bl2 = false;
            mediaSessionManager$RemoteUserInfoImpl = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

