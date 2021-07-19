/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.ExoMediaDrm$KeyRequest;
import com.google.android.exoplayer2.drm.ExoMediaDrm$ProvisionRequest;
import java.util.UUID;

public interface MediaDrmCallback {
    public byte[] executeKeyRequest(UUID var1, ExoMediaDrm$KeyRequest var2);

    public byte[] executeProvisionRequest(UUID var1, ExoMediaDrm$ProvisionRequest var2);
}

