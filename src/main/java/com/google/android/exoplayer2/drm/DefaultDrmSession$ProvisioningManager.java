/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DefaultDrmSession;

public interface DefaultDrmSession$ProvisioningManager {
    public void onProvisionCompleted();

    public void onProvisionError(Exception var1);

    public void provisionRequired(DefaultDrmSession var1);
}

