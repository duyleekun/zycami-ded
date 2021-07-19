/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource$1;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;

public final class ConcatenatingMediaSource$FakeMediaSource
extends BaseMediaSource {
    private ConcatenatingMediaSource$FakeMediaSource() {
    }

    public /* synthetic */ ConcatenatingMediaSource$FakeMediaSource(ConcatenatingMediaSource$1 concatenatingMediaSource$1) {
        this();
    }

    public MediaPeriod createPeriod(MediaSource$MediaPeriodId object, Allocator allocator, long l10) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public MediaItem getMediaItem() {
        return ConcatenatingMediaSource.access$100();
    }

    public void maybeThrowSourceInfoRefreshError() {
    }

    public void prepareSourceInternal(TransferListener transferListener) {
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
    }

    public void releaseSourceInternal() {
    }
}

