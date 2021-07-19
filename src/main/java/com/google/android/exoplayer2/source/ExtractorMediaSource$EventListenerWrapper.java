/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.ExtractorMediaSource$EventListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class ExtractorMediaSource$EventListenerWrapper
implements MediaSourceEventListener {
    private final ExtractorMediaSource$EventListener eventListener;

    public ExtractorMediaSource$EventListenerWrapper(ExtractorMediaSource$EventListener extractorMediaSource$EventListener) {
        this.eventListener = extractorMediaSource$EventListener = (ExtractorMediaSource$EventListener)Assertions.checkNotNull(extractorMediaSource$EventListener);
    }

    public void onLoadError(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean bl2) {
        this.eventListener.onLoadError(iOException);
    }
}

