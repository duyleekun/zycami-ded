/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSession$DrmSessionException;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import java.util.Map;
import java.util.UUID;

public interface DrmSession {
    public static final int STATE_ERROR = 1;
    public static final int STATE_OPENED = 3;
    public static final int STATE_OPENED_WITH_KEYS = 4;
    public static final int STATE_OPENING = 2;
    public static final int STATE_RELEASED;

    public static void replaceSession(DrmSession drmSession, DrmSession drmSession2) {
        if (drmSession == drmSession2) {
            return;
        }
        if (drmSession2 != null) {
            drmSession2.acquire(null);
        }
        if (drmSession != null) {
            drmSession.release(null);
        }
    }

    public void acquire(DrmSessionEventListener$EventDispatcher var1);

    public DrmSession$DrmSessionException getError();

    public ExoMediaCrypto getMediaCrypto();

    public byte[] getOfflineLicenseKeySetId();

    public UUID getSchemeUuid();

    public int getState();

    default public boolean playClearSamplesWithoutKeys() {
        return false;
    }

    public Map queryKeyStatus();

    public void release(DrmSessionEventListener$EventDispatcher var1);
}

