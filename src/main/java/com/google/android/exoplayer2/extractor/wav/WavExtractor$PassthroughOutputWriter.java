/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.wav.WavExtractor$OutputWriter;
import com.google.android.exoplayer2.extractor.wav.WavHeader;
import com.google.android.exoplayer2.extractor.wav.WavSeekMap;
import com.google.android.exoplayer2.util.Util;

public final class WavExtractor$PassthroughOutputWriter
implements WavExtractor$OutputWriter {
    private final ExtractorOutput extractorOutput;
    private final Format format;
    private final WavHeader header;
    private long outputFrameCount;
    private int pendingOutputBytes;
    private long startTimeUs;
    private final int targetSampleSizeBytes;
    private final TrackOutput trackOutput;

    public WavExtractor$PassthroughOutputWriter(ExtractorOutput object, TrackOutput object2, WavHeader wavHeader, String string2, int n10) {
        this.extractorOutput = object;
        this.trackOutput = object2;
        this.header = wavHeader;
        int n11 = wavHeader.numChannels;
        int n12 = wavHeader.bitsPerSample;
        n11 = n11 * n12 / 8;
        n12 = wavHeader.blockSize;
        if (n12 == n11) {
            n12 = wavHeader.frameRateHz;
            int n13 = n12 * n11 * 8;
            n12 = n12 * n11 / 10;
            this.targetSampleSizeBytes = n11 = Math.max(n11, n12);
            object2 = new Format$Builder();
            object = ((Format$Builder)object2).setSampleMimeType(string2).setAverageBitrate(n13).setPeakBitrate(n13).setMaxInputSize(n11);
            n12 = wavHeader.numChannels;
            object = ((Format$Builder)object).setChannelCount(n12);
            n12 = wavHeader.frameRateHz;
            this.format = object = ((Format$Builder)object).setSampleRate(n12).setPcmEncoding(n10).build();
            return;
        }
        int n14 = wavHeader.blockSize;
        StringBuilder stringBuilder = new StringBuilder(50);
        stringBuilder.append("Expected block size: ");
        stringBuilder.append(n11);
        stringBuilder.append("; got: ");
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        object2 = new ParserException((String)object);
        throw object2;
    }

    public void init(int n10, long l10) {
        ExtractorOutput extractorOutput = this.extractorOutput;
        WavHeader wavHeader = this.header;
        long l11 = n10;
        WavSeekMap wavSeekMap = new WavSeekMap(wavHeader, 1, l11, l10);
        extractorOutput.seekMap(wavSeekMap);
        TrackOutput trackOutput = this.trackOutput;
        Format format = this.format;
        trackOutput.format(format);
    }

    public void reset(long l10) {
        this.startTimeUs = l10;
        this.pendingOutputBytes = 0;
        this.outputFrameCount = 0L;
    }

    public boolean sampleData(ExtractorInput extractorInput, long l10) {
        int n10;
        long l11;
        int n11;
        long l12;
        WavExtractor$PassthroughOutputWriter wavExtractor$PassthroughOutputWriter = this;
        long l13 = l10;
        while (true) {
            int n12;
            int n13;
            long l14 = 0L;
            l12 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
            n11 = 1;
            if (l12 <= 0 || (n13 = wavExtractor$PassthroughOutputWriter.pendingOutputBytes) >= (n12 = wavExtractor$PassthroughOutputWriter.targetSampleSizeBytes)) break;
            l11 = Math.min((long)(n12 -= n13), l13);
            l12 = (int)l11;
            TrackOutput trackOutput = wavExtractor$PassthroughOutputWriter.trackOutput;
            if ((l12 = (long)trackOutput.sampleData(extractorInput, (int)l12, n11 != 0)) == (n11 = -1)) {
                l13 = l14;
                continue;
            }
            wavExtractor$PassthroughOutputWriter.pendingOutputBytes = n10 = wavExtractor$PassthroughOutputWriter.pendingOutputBytes + l12;
            l14 = l12;
            l13 -= l14;
        }
        WavHeader wavHeader = wavExtractor$PassthroughOutputWriter.header;
        int n14 = wavHeader.blockSize;
        n10 = wavExtractor$PassthroughOutputWriter.pendingOutputBytes / n14;
        if (n10 > 0) {
            l11 = wavExtractor$PassthroughOutputWriter.startTimeUs;
            long l15 = wavExtractor$PassthroughOutputWriter.outputFrameCount;
            long l16 = 1000000L;
            long l17 = wavHeader.frameRateHz;
            l15 = Util.scaleLargeTimestamp(l15, l16, l17);
            long l18 = l11 + l15;
            int n15 = n10 * n14;
            int n16 = wavExtractor$PassthroughOutputWriter.pendingOutputBytes - n15;
            TrackOutput trackOutput = wavExtractor$PassthroughOutputWriter.trackOutput;
            int n17 = 1;
            trackOutput.sampleMetadata(l18, n17, n15, n16, null);
            l11 = wavExtractor$PassthroughOutputWriter.outputFrameCount;
            long l19 = n10;
            wavExtractor$PassthroughOutputWriter.outputFrameCount = l11 += l19;
            wavExtractor$PassthroughOutputWriter.pendingOutputBytes = n16;
        }
        if (l12 > 0) {
            n11 = 0;
        }
        return n11 != 0;
    }
}

