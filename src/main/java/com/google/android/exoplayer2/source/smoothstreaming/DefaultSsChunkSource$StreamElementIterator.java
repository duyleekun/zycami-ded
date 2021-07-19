/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest$StreamElement;
import com.google.android.exoplayer2.upstream.DataSpec;

public final class DefaultSsChunkSource$StreamElementIterator
extends BaseMediaChunkIterator {
    private final SsManifest$StreamElement streamElement;
    private final int trackIndex;

    public DefaultSsChunkSource$StreamElementIterator(SsManifest$StreamElement ssManifest$StreamElement, int n10, int n11) {
        long l10 = n11;
        long l11 = ssManifest$StreamElement.chunkCount + -1;
        super(l10, l11);
        this.streamElement = ssManifest$StreamElement;
        this.trackIndex = n10;
    }

    public long getChunkEndTimeUs() {
        long l10 = this.getChunkStartTimeUs();
        SsManifest$StreamElement ssManifest$StreamElement = this.streamElement;
        int n10 = (int)this.getCurrentIndex();
        long l11 = ssManifest$StreamElement.getChunkDurationUs(n10);
        return l10 + l11;
    }

    public long getChunkStartTimeUs() {
        this.checkInBounds();
        SsManifest$StreamElement ssManifest$StreamElement = this.streamElement;
        int n10 = (int)this.getCurrentIndex();
        return ssManifest$StreamElement.getStartTimeUs(n10);
    }

    public DataSpec getDataSpec() {
        this.checkInBounds();
        SsManifest$StreamElement ssManifest$StreamElement = this.streamElement;
        int n10 = this.trackIndex;
        int n11 = (int)this.getCurrentIndex();
        ssManifest$StreamElement = ssManifest$StreamElement.buildRequestUri(n10, n11);
        DataSpec dataSpec = new DataSpec((Uri)ssManifest$StreamElement);
        return dataSpec;
    }
}

