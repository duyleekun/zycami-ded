/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import java.io.IOException;

public final class UnexpectedSampleTimestampException
extends IOException {
    public final long lastAcceptedSampleTimeUs;
    public final MediaChunk mediaChunk;
    public final long rejectedSampleTimeUs;

    public UnexpectedSampleTimestampException(MediaChunk mediaChunk, long l10, long l11) {
        long l12 = C.usToMs(l11);
        long l13 = mediaChunk.startTimeUs;
        long l14 = mediaChunk.endTimeUs;
        StringBuilder stringBuilder = new StringBuilder(103);
        stringBuilder.append("Unexpected sample timestamp: ");
        stringBuilder.append(l12);
        stringBuilder.append(" in chunk [");
        stringBuilder.append(l13);
        stringBuilder.append(", ");
        stringBuilder.append(l14);
        stringBuilder.append("]");
        String string2 = stringBuilder.toString();
        super(string2);
        this.mediaChunk = mediaChunk;
        this.lastAcceptedSampleTimeUs = l10;
        this.rejectedSampleTimeUs = l11;
    }
}

