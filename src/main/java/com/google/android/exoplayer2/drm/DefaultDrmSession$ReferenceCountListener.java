/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DefaultDrmSession;

public interface DefaultDrmSession$ReferenceCountListener {
    public void onReferenceCountDecremented(DefaultDrmSession var1, int var2);

    public void onReferenceCountIncremented(DefaultDrmSession var1, int var2);
}

