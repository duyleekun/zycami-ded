/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaSourceCaller;
import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final class CompositeMediaSource$MediaSourceAndListener {
    public final MediaSource$MediaSourceCaller caller;
    public final MediaSourceEventListener eventListener;
    public final MediaSource mediaSource;

    public CompositeMediaSource$MediaSourceAndListener(MediaSource mediaSource, MediaSource$MediaSourceCaller mediaSource$MediaSourceCaller, MediaSourceEventListener mediaSourceEventListener) {
        this.mediaSource = mediaSource;
        this.caller = mediaSource$MediaSourceCaller;
        this.eventListener = mediaSourceEventListener;
    }
}

