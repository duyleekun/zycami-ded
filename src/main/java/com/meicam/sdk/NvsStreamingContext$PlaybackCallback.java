/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsTimeline;

public interface NvsStreamingContext$PlaybackCallback {
    public void onPlaybackEOF(NvsTimeline var1);

    public void onPlaybackPreloadingCompletion(NvsTimeline var1);

    public void onPlaybackStopped(NvsTimeline var1);
}

