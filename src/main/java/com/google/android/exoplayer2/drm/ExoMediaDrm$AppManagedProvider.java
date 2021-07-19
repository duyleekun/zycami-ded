/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm$Provider;
import java.util.UUID;

public final class ExoMediaDrm$AppManagedProvider
implements ExoMediaDrm$Provider {
    private final ExoMediaDrm exoMediaDrm;

    public ExoMediaDrm$AppManagedProvider(ExoMediaDrm exoMediaDrm) {
        this.exoMediaDrm = exoMediaDrm;
    }

    public ExoMediaDrm acquireExoMediaDrm(UUID uUID) {
        this.exoMediaDrm.acquire();
        return this.exoMediaDrm;
    }
}

