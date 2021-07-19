/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public interface SectionPayloadReader {
    public void consume(ParsableByteArray var1);

    public void init(TimestampAdjuster var1, ExtractorOutput var2, TsPayloadReader$TrackIdGenerator var3);
}

