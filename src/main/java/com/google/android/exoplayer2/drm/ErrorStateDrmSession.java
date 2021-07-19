/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSession$DrmSessionException;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;
import java.util.UUID;

public final class ErrorStateDrmSession
implements DrmSession {
    private final DrmSession$DrmSessionException error;

    public ErrorStateDrmSession(DrmSession$DrmSessionException drmSession$DrmSessionException) {
        this.error = drmSession$DrmSessionException = (DrmSession$DrmSessionException)Assertions.checkNotNull(drmSession$DrmSessionException);
    }

    public void acquire(DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher) {
    }

    public DrmSession$DrmSessionException getError() {
        return this.error;
    }

    public ExoMediaCrypto getMediaCrypto() {
        return null;
    }

    public byte[] getOfflineLicenseKeySetId() {
        return null;
    }

    public final UUID getSchemeUuid() {
        return C.UUID_NIL;
    }

    public int getState() {
        return 1;
    }

    public boolean playClearSamplesWithoutKeys() {
        return false;
    }

    public Map queryKeyStatus() {
        return null;
    }

    public void release(DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher) {
    }
}

