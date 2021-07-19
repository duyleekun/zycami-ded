/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableByteArray;

public interface ElementaryStreamReader {
    public void consume(ParsableByteArray var1);

    public void createTracks(ExtractorOutput var1, TsPayloadReader.TrackIdGenerator var2);

    public void packetFinished();

    public void packetStarted(long var1, int var3);

    public void seek();
}

