/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.audio.MpegAudioUtil$Header;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class MpegAudioReader
implements ElementaryStreamReader {
    private static final int HEADER_SIZE = 4;
    private static final int STATE_FINDING_HEADER = 0;
    private static final int STATE_READING_FRAME = 2;
    private static final int STATE_READING_HEADER = 1;
    private String formatId;
    private int frameBytesRead;
    private long frameDurationUs;
    private int frameSize;
    private boolean hasOutputFormat;
    private final MpegAudioUtil$Header header;
    private final ParsableByteArray headerScratch;
    private final String language;
    private boolean lastByteWasFF;
    private TrackOutput output;
    private int state = 0;
    private long timeUs;

    public MpegAudioReader() {
        this(null);
    }

    public MpegAudioReader(String string2) {
        MpegAudioUtil$Header mpegAudioUtil$Header;
        ParsableByteArray parsableByteArray;
        this.headerScratch = parsableByteArray = new ParsableByteArray(4);
        parsableByteArray.getData()[0] = -1;
        this.header = mpegAudioUtil$Header = new MpegAudioUtil$Header();
        this.language = string2;
    }

    /*
     * Unable to fully structure code
     */
    private void findHeader(ParsableByteArray var1_1) {
        var2_2 = var1_1.getData();
        var4_4 = var1_1.limit();
        for (var3_3 = var1_1.getPosition(); var3_3 < var4_4; ++var3_3) {
            var5_5 = var2_2[var3_3];
            var6_6 = 255;
            var7_7 = 1;
            var5_5 = (var5_5 &= var6_6) == var6_6 ? var7_7 : 0;
            var6_6 = (int)this.lastByteWasFF;
            if (var6_6 == 0) ** GOTO lbl-1000
            var6_6 = var2_2[var3_3];
            var8_8 = 224;
            if ((var6_6 &= var8_8) == var8_8) {
                var6_6 = var7_7;
            } else lbl-1000:
            // 2 sources

            {
                var6_6 = 0;
            }
            this.lastByteWasFF = var5_5;
            if (var6_6 == 0) continue;
            var4_4 = var3_3 + 1;
            var1_1.setPosition(var4_4);
            this.lastByteWasFF = false;
            var1_1 = this.headerScratch.getData();
            var9_9 = var2_2[var3_3];
            var1_1[var7_7] = var9_9;
            this.frameBytesRead = 2;
            this.state = var7_7;
            return;
        }
        var1_1.setPosition(var4_4);
    }

    private void readFrameRemainder(ParsableByteArray parsableByteArray) {
        int n10;
        int n11 = parsableByteArray.bytesLeft();
        int n12 = this.frameSize;
        int n13 = this.frameBytesRead;
        n11 = Math.min(n11, n12 -= n13);
        TrackOutput trackOutput = this.output;
        trackOutput.sampleData(parsableByteArray, n11);
        this.frameBytesRead = n10 = this.frameBytesRead + n11;
        int n14 = this.frameSize;
        if (n10 < n14) {
            return;
        }
        TrackOutput trackOutput2 = this.output;
        long l10 = this.timeUs;
        trackOutput2.sampleMetadata(l10, 1, n14, 0, null);
        long l11 = this.timeUs;
        long l12 = this.frameDurationUs;
        this.timeUs = l11 += l12;
        this.frameBytesRead = 0;
        this.state = 0;
    }

    private void readHeaderRemainder(ParsableByteArray object) {
        int n10;
        int n11 = ((ParsableByteArray)object).bytesLeft();
        int n12 = this.frameBytesRead;
        int n13 = 4;
        n12 = 4 - n12;
        n11 = Math.min(n11, n12);
        Object object2 = this.headerScratch.getData();
        int n14 = this.frameBytesRead;
        ((ParsableByteArray)object).readBytes((byte[])object2, n14, n11);
        this.frameBytesRead = n10 = this.frameBytesRead + n11;
        if (n10 < n13) {
            return;
        }
        object = this.headerScratch;
        n11 = 0;
        ParsableByteArray parsableByteArray = null;
        ((ParsableByteArray)object).setPosition(0);
        object = this.header;
        object2 = this.headerScratch;
        n12 = ((ParsableByteArray)object2).readInt();
        n10 = (int)(((MpegAudioUtil$Header)object).setForHeaderData(n12) ? 1 : 0);
        n12 = 1;
        if (n10 == 0) {
            this.frameBytesRead = 0;
            this.state = n12;
            return;
        }
        object = this.header;
        this.frameSize = n14 = ((MpegAudioUtil$Header)object).frameSize;
        n14 = (int)(this.hasOutputFormat ? 1 : 0);
        if (n14 == 0) {
            int n15 = ((MpegAudioUtil$Header)object).samplesPerFrame;
            long l10 = (long)n15 * 1000000L;
            n10 = ((MpegAudioUtil$Header)object).sampleRate;
            long l11 = n10;
            this.frameDurationUs = l10 /= l11;
            object = new Format$Builder();
            Object object3 = this.formatId;
            object = ((Format$Builder)object).setId((String)object3);
            object3 = this.header.mimeType;
            object = ((Format$Builder)object).setSampleMimeType((String)object3).setMaxInputSize(4096);
            n14 = this.header.channels;
            object = ((Format$Builder)object).setChannelCount(n14);
            n14 = this.header.sampleRate;
            object = ((Format$Builder)object).setSampleRate(n14);
            object3 = this.language;
            object = ((Format$Builder)object).setLanguage((String)object3).build();
            object3 = this.output;
            object3.format((Format)object);
            this.hasOutputFormat = n12;
        }
        this.headerScratch.setPosition(0);
        object = this.output;
        parsableByteArray = this.headerScratch;
        object.sampleData(parsableByteArray, n13);
        this.state = 2;
    }

    public void consume(ParsableByteArray object) {
        int n10;
        TrackOutput trackOutput = this.output;
        Assertions.checkStateNotNull(trackOutput);
        while ((n10 = ((ParsableByteArray)object).bytesLeft()) > 0) {
            n10 = this.state;
            if (n10 != 0) {
                int n11 = 1;
                if (n10 != n11) {
                    n11 = 2;
                    if (n10 == n11) {
                        this.readFrameRemainder((ParsableByteArray)object);
                        continue;
                    }
                    object = new IllegalStateException();
                    throw object;
                }
                this.readHeaderRemainder((ParsableByteArray)object);
                continue;
            }
            this.findHeader((ParsableByteArray)object);
        }
    }

    public void createTracks(ExtractorOutput object, TsPayloadReader$TrackIdGenerator tsPayloadReader$TrackIdGenerator) {
        String string2;
        tsPayloadReader$TrackIdGenerator.generateNewId();
        this.formatId = string2 = tsPayloadReader$TrackIdGenerator.getFormatId();
        int n10 = tsPayloadReader$TrackIdGenerator.getTrackId();
        this.output = object = object.track(n10, 1);
    }

    public void packetFinished() {
    }

    public void packetStarted(long l10, int n10) {
        this.timeUs = l10;
    }

    public void seek() {
        this.state = 0;
        this.frameBytesRead = 0;
        this.lastByteWasFF = false;
    }
}

