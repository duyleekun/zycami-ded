/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.dash.DashUtil;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource$RepresentationHolder;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.upstream.DataSpec;

public final class DefaultDashChunkSource$RepresentationSegmentIterator
extends BaseMediaChunkIterator {
    private final long nowPeriodTimeUs;
    private final DefaultDashChunkSource$RepresentationHolder representationHolder;

    public DefaultDashChunkSource$RepresentationSegmentIterator(DefaultDashChunkSource$RepresentationHolder defaultDashChunkSource$RepresentationHolder, long l10, long l11, long l12) {
        super(l10, l11);
        this.representationHolder = defaultDashChunkSource$RepresentationHolder;
        this.nowPeriodTimeUs = l12;
    }

    public long getChunkEndTimeUs() {
        this.checkInBounds();
        DefaultDashChunkSource$RepresentationHolder defaultDashChunkSource$RepresentationHolder = this.representationHolder;
        long l10 = this.getCurrentIndex();
        return defaultDashChunkSource$RepresentationHolder.getSegmentEndTimeUs(l10);
    }

    public long getChunkStartTimeUs() {
        this.checkInBounds();
        DefaultDashChunkSource$RepresentationHolder defaultDashChunkSource$RepresentationHolder = this.representationHolder;
        long l10 = this.getCurrentIndex();
        return defaultDashChunkSource$RepresentationHolder.getSegmentStartTimeUs(l10);
    }

    public DataSpec getDataSpec() {
        this.checkInBounds();
        long l10 = this.getCurrentIndex();
        RangedUri rangedUri = this.representationHolder.getSegmentUrl(l10);
        DefaultDashChunkSource$RepresentationHolder defaultDashChunkSource$RepresentationHolder = this.representationHolder;
        long l11 = this.nowPeriodTimeUs;
        int n10 = defaultDashChunkSource$RepresentationHolder.isSegmentAvailableAtFullNetworkSpeed(l10, l11);
        n10 = n10 != 0 ? 0 : 8;
        return DashUtil.buildDataSpec(this.representationHolder.representation, rangedUri, n10);
    }
}

