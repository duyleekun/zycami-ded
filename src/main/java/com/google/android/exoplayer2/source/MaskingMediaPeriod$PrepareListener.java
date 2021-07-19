/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import java.io.IOException;

public interface MaskingMediaPeriod$PrepareListener {
    public void onPrepareComplete(MediaSource$MediaPeriodId var1);

    public void onPrepareError(MediaSource$MediaPeriodId var1, IOException var2);
}

