/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;

public class ProgressiveMediaSource$1
extends ForwardingTimeline {
    public ProgressiveMediaSource$1(ProgressiveMediaSource progressiveMediaSource, Timeline timeline) {
        super(timeline);
    }

    public Timeline$Window getWindow(int n10, Timeline$Window timeline$Window, long l10) {
        super.getWindow(n10, timeline$Window, l10);
        timeline$Window.isPlaceholder = true;
        return timeline$Window;
    }
}

