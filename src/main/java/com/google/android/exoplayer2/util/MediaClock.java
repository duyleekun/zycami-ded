/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.PlaybackParameters;

public interface MediaClock {
    public PlaybackParameters getPlaybackParameters();

    public long getPositionUs();

    public void setPlaybackParameters(PlaybackParameters var1);
}

