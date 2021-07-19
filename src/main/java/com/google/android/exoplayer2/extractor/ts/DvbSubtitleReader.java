/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$DvbSubtitleInfo;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

public final class DvbSubtitleReader
implements ElementaryStreamReader {
    private int bytesToCheck;
    private final TrackOutput[] outputs;
    private int sampleBytesWritten;
    private long sampleTimeUs;
    private final List subtitleInfos;
    private boolean writingSample;

    public DvbSubtitleReader(List trackOutputArray) {
        this.subtitleInfos = trackOutputArray;
        trackOutputArray = new TrackOutput[trackOutputArray.size()];
        this.outputs = trackOutputArray;
    }

    private boolean checkNextByte(ParsableByteArray parsableByteArray, int n10) {
        int n11 = parsableByteArray.bytesLeft();
        if (n11 == 0) {
            return false;
        }
        int n12 = parsableByteArray.readUnsignedByte();
        if (n12 != n10) {
            this.writingSample = false;
        }
        this.bytesToCheck = n12 = this.bytesToCheck + -1;
        return this.writingSample;
    }

    public void consume(ParsableByteArray parsableByteArray) {
        int n10 = this.writingSample;
        if (n10 != 0) {
            int n11;
            n10 = this.bytesToCheck;
            int n12 = 2;
            if (n10 == n12 && (n10 = (int)(this.checkNextByte(parsableByteArray, 32) ? 1 : 0)) == 0) {
                return;
            }
            n10 = this.bytesToCheck;
            int n13 = 1;
            if (n10 == n13 && (n10 = (int)(this.checkNextByte(parsableByteArray, 0) ? 1 : 0)) == 0) {
                return;
            }
            n10 = parsableByteArray.getPosition();
            n13 = parsableByteArray.bytesLeft();
            for (TrackOutput trackOutput : this.outputs) {
                parsableByteArray.setPosition(n10);
                trackOutput.sampleData(parsableByteArray, n13);
            }
            this.sampleBytesWritten = n11 = this.sampleBytesWritten + n13;
        }
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader$TrackIdGenerator tsPayloadReader$TrackIdGenerator) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((TrackOutput[])(object = this.outputs)).length); ++i10) {
            object = (TsPayloadReader$DvbSubtitleInfo)this.subtitleInfos.get(i10);
            tsPayloadReader$TrackIdGenerator.generateNewId();
            int n11 = tsPayloadReader$TrackIdGenerator.getTrackId();
            int n12 = 3;
            TrackOutput trackOutput = extractorOutput.track(n11, n12);
            Format$Builder format$Builder = new Format$Builder();
            Object object2 = tsPayloadReader$TrackIdGenerator.getFormatId();
            format$Builder = format$Builder.setId((String)object2).setSampleMimeType("application/dvbsubs");
            object2 = Collections.singletonList(object.initializationData);
            format$Builder = format$Builder.setInitializationData((List)object2);
            object = object.language;
            object = format$Builder.setLanguage((String)object).build();
            trackOutput.format((Format)object);
            object = this.outputs;
            object[i10] = trackOutput;
        }
    }

    public void packetFinished() {
        boolean bl2 = this.writingSample;
        if (bl2) {
            for (TrackOutput trackOutput : this.outputs) {
                long l10 = this.sampleTimeUs;
                int n10 = 1;
                int n11 = this.sampleBytesWritten;
                trackOutput.sampleMetadata(l10, n10, n11, 0, null);
            }
            this.writingSample = false;
        }
    }

    public void packetStarted(long l10, int n10) {
        if ((n10 &= 4) == 0) {
            return;
        }
        this.writingSample = true;
        this.sampleTimeUs = l10;
        this.sampleBytesWritten = 0;
        this.bytesToCheck = 2;
    }

    public void seek() {
        this.writingSample = false;
    }
}

