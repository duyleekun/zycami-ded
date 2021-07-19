/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.Cue;

public final class WebvttCueInfo {
    public final Cue cue;
    public final long endTimeUs;
    public final long startTimeUs;

    public WebvttCueInfo(Cue cue, long l10, long l11) {
        this.cue = cue;
        this.startTimeUs = l10;
        this.endTimeUs = l11;
    }
}

