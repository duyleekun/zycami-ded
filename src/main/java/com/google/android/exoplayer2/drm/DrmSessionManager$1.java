/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package com.google.android.exoplayer2.drm;

import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSession$DrmSessionException;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.ErrorStateDrmSession;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import com.google.android.exoplayer2.drm.UnsupportedMediaCrypto;

public class DrmSessionManager$1
implements DrmSessionManager {
    public DrmSession acquireSession(Looper object, DrmSessionEventListener$EventDispatcher object2, Format object3) {
        object = ((Format)object3).drmInitData;
        if (object == null) {
            return null;
        }
        object3 = new UnsupportedDrmException(1);
        object2 = new DrmSession$DrmSessionException((Throwable)object3);
        object = new ErrorStateDrmSession((DrmSession$DrmSessionException)object2);
        return object;
    }

    public Class getExoMediaCryptoType(Format object) {
        object = ((Format)object).drmInitData;
        object = object != null ? UnsupportedMediaCrypto.class : null;
        return object;
    }
}

