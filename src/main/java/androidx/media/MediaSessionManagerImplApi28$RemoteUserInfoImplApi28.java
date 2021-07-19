/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.session.MediaSessionManager$RemoteUserInfo
 */
package androidx.media;

import android.media.session.MediaSessionManager;
import androidx.media.MediaSessionManagerImplBase$RemoteUserInfoImplBase;

public final class MediaSessionManagerImplApi28$RemoteUserInfoImplApi28
extends MediaSessionManagerImplBase$RemoteUserInfoImplBase {
    public final MediaSessionManager.RemoteUserInfo mObject;

    public MediaSessionManagerImplApi28$RemoteUserInfoImplApi28(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        String string2 = remoteUserInfo.getPackageName();
        int n10 = remoteUserInfo.getPid();
        int n11 = remoteUserInfo.getUid();
        super(string2, n10, n11);
        this.mObject = remoteUserInfo;
    }

    public MediaSessionManagerImplApi28$RemoteUserInfoImplApi28(String string2, int n10, int n11) {
        super(string2, n10, n11);
        MediaSessionManager.RemoteUserInfo remoteUserInfo;
        this.mObject = remoteUserInfo = new MediaSessionManager.RemoteUserInfo(string2, n10, n11);
    }
}

