/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.jpeg.StartOffsetExtractorOutput$1;

public final class StartOffsetExtractorOutput
implements ExtractorOutput {
    private final ExtractorOutput extractorOutput;
    private final long startOffset;

    public StartOffsetExtractorOutput(long l10, ExtractorOutput extractorOutput) {
        this.startOffset = l10;
        this.extractorOutput = extractorOutput;
    }

    public static /* synthetic */ long access$000(StartOffsetExtractorOutput startOffsetExtractorOutput) {
        return startOffsetExtractorOutput.startOffset;
    }

    public void endTracks() {
        this.extractorOutput.endTracks();
    }

    public void seekMap(SeekMap seekMap) {
        ExtractorOutput extractorOutput = this.extractorOutput;
        StartOffsetExtractorOutput$1 startOffsetExtractorOutput$1 = new StartOffsetExtractorOutput$1(this, seekMap);
        extractorOutput.seekMap(startOffsetExtractorOutput$1);
    }

    public TrackOutput track(int n10, int n11) {
        return this.extractorOutput.track(n10, n11);
    }
}

