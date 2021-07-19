/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.SectionPayloadReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

public final class PassthroughSectionPayloadReader
implements SectionPayloadReader {
    private Format format;
    private TrackOutput output;
    private TimestampAdjuster timestampAdjuster;

    public PassthroughSectionPayloadReader(String object) {
        Format$Builder format$Builder = new Format$Builder();
        this.format = object = format$Builder.setSampleMimeType((String)object).build();
    }

    private void assertInitialized() {
        Assertions.checkStateNotNull(this.timestampAdjuster);
        Util.castNonNull(this.output);
    }

    public void consume(ParsableByteArray parsableByteArray) {
        this.assertInitialized();
        Object object = this.timestampAdjuster;
        long l10 = ((TimestampAdjuster)object).getTimestampOffsetUs();
        long l11 = -9223372036854775807L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            return;
        }
        Object object2 = this.format;
        long l13 = ((Format)object2).subsampleOffsetUs;
        long l14 = l10 - l13;
        Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object3 != false) {
            object2 = ((Format)object2).buildUpon();
            this.format = object = ((Format$Builder)object2).setSubsampleOffsetUs(l10).build();
            TrackOutput trackOutput = this.output;
            trackOutput.format((Format)object);
        }
        int n10 = parsableByteArray.bytesLeft();
        this.output.sampleData(parsableByteArray, n10);
        object2 = this.output;
        l13 = this.timestampAdjuster.getLastAdjustedTimestampUs();
        object2.sampleMetadata(l13, 1, n10, 0, null);
    }

    public void init(TimestampAdjuster object, ExtractorOutput object2, TsPayloadReader$TrackIdGenerator tsPayloadReader$TrackIdGenerator) {
        this.timestampAdjuster = object;
        tsPayloadReader$TrackIdGenerator.generateNewId();
        int n10 = tsPayloadReader$TrackIdGenerator.getTrackId();
        this.output = object = object2.track(n10, 5);
        object2 = this.format;
        object.format((Format)object2);
    }
}

