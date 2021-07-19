/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.session.MediaSessionManager$RemoteUserInfo
 *  android.os.Build$VERSION
 */
package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;
import androidx.media.MediaSessionManager$RemoteUserInfoImpl;
import androidx.media.MediaSessionManagerImplApi28$RemoteUserInfoImplApi28;
import androidx.media.MediaSessionManagerImplBase$RemoteUserInfoImplBase;

public final class MediaSessionManager$RemoteUserInfo {
    public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
    public static final int UNKNOWN_PID = 255;
    public static final int UNKNOWN_UID = 255;
    public MediaSessionManager$RemoteUserInfoImpl mImpl;

    public MediaSessionManager$RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        MediaSessionManagerImplApi28$RemoteUserInfoImplApi28 mediaSessionManagerImplApi28$RemoteUserInfoImplApi28 = new MediaSessionManagerImplApi28$RemoteUserInfoImplApi28(remoteUserInfo);
        this.mImpl = mediaSessionManagerImplApi28$RemoteUserInfoImplApi28;
    }

    public MediaSessionManager$RemoteUserInfo(String string2, int n10, int n11) {
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 28;
        if (n12 >= n13) {
            MediaSessionManagerImplApi28$RemoteUserInfoImplApi28 mediaSessionManagerImplApi28$RemoteUserInfoImplApi28 = new MediaSessionManagerImplApi28$RemoteUserInfoImplApi28(string2, n10, n11);
            this.mImpl = mediaSessionManagerImplApi28$RemoteUserInfoImplApi28;
        } else {
            MediaSessionManagerImplBase$RemoteUserInfoImplBase mediaSessionManagerImplBase$RemoteUserInfoImplBase = new MediaSessionManagerImplBase$RemoteUserInfoImplBase(string2, n10, n11);
            this.mImpl = mediaSessionManagerImplBase$RemoteUserInfoImplBase;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof MediaSessionManager$RemoteUserInfo;
        if (!bl2) {
            return false;
        }
        MediaSessionManager$RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl = this.mImpl;
        object = ((MediaSessionManager$RemoteUserInfo)object).mImpl;
        return mediaSessionManager$RemoteUserInfoImpl.equals(object);
    }

    public String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public int getPid() {
        return this.mImpl.getPid();
    }

    public int getUid() {
        return this.mImpl.getUid();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }
}

