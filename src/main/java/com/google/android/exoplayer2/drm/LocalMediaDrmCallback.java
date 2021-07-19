/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.ExoMediaDrm$KeyRequest;
import com.google.android.exoplayer2.drm.ExoMediaDrm$ProvisionRequest;
import com.google.android.exoplayer2.drm.MediaDrmCallback;
import com.google.android.exoplayer2.util.Assertions;
import java.util.UUID;

public final class LocalMediaDrmCallback
implements MediaDrmCallback {
    private final byte[] keyResponse;

    public LocalMediaDrmCallback(byte[] byArray) {
        byArray = (byte[])Assertions.checkNotNull(byArray);
        this.keyResponse = byArray;
    }

    public byte[] executeKeyRequest(UUID uUID, ExoMediaDrm$KeyRequest exoMediaDrm$KeyRequest) {
        return this.keyResponse;
    }

    public byte[] executeProvisionRequest(UUID serializable, ExoMediaDrm$ProvisionRequest exoMediaDrm$ProvisionRequest) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }
}

