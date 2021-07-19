/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaSourceCaller;
import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final class MediaSourceList$MediaSourceAndListener {
    public final MediaSource.MediaSourceCaller caller;
    public final MediaSourceEventListener eventListener;
    public final MediaSource mediaSource;

    public MediaSourceList$MediaSourceAndListener(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, MediaSourceEventListener mediaSourceEventListener) {
        this.mediaSource = mediaSource;
        this.caller = mediaSourceCaller;
        this.eventListener = mediaSourceEventListener;
    }
}

