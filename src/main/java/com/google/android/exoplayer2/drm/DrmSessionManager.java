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
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.DrmSessionManager$1;

public interface DrmSessionManager {
    public static final DrmSessionManager DRM_UNSUPPORTED;
    public static final DrmSessionManager DUMMY;

    static {
        DrmSessionManager$1 drmSessionManager$1 = new DrmSessionManager$1();
        DRM_UNSUPPORTED = drmSessionManager$1;
        DUMMY = drmSessionManager$1;
    }

    public static DrmSessionManager getDummyDrmSessionManager() {
        return DRM_UNSUPPORTED;
    }

    public DrmSession acquireSession(Looper var1, DrmSessionEventListener$EventDispatcher var2, Format var3);

    public Class getExoMediaCryptoType(Format var1);

    default public void prepare() {
    }

    default public void release() {
    }
}

