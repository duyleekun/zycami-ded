/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;

public interface DrmSessionManagerProvider {
    public DrmSessionManager get(MediaItem var1);
}

