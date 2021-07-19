/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class DtsReader
implements ElementaryStreamReader {
    private static final int HEADER_SIZE = 18;
    private static final int STATE_FINDING_SYNC = 0;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private int bytesRead;
    private Format format;
    private String formatId;
    private final ParsableByteArray headerScratchBytes;
    private final String language;
    private TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private int syncBytes;
    private long timeUs;

    public DtsReader(String string2) {
        ParsableByteArray parsableByteArray;
        byte[] byArray = new byte[18];
        this.headerScratchBytes = parsableByteArray = new ParsableByteArray(byArray);
        this.state = 0;
        this.language = string2;
    }

    private boolean continueRead(ParsableByteArray parsableByteArray, byte[] byArray, int n10) {
        int n11 = parsableByteArray.bytesLeft();
        int n12 = this.bytesRead;
        n12 = n10 - n12;
        n11 = Math.min(n11, n12);
        n12 = this.bytesRead;
        parsableByteArray.readBytes(byArray, n12, n11);
        int n13 = this.bytesRead + n11;
        this.bytesRead = n13;
        if (n13 == n10) {
            n13 = 1;
        } else {
            n13 = 0;
            parsableByteArray = null;
        }
        return n13;
    }

    private void parseHeader() {
        int n10;
        byte[] byArray = this.headerScratchBytes.getData();
        Object object = this.format;
        if (object == null) {
            object = this.formatId;
            Object object2 = this.language;
            this.format = object = DtsUtil.parseDtsFormat(byArray, (String)object, (String)object2, null);
            object2 = this.output;
            object2.format((Format)object);
        }
        this.sampleSize = n10 = DtsUtil.getDtsFrameSize(byArray);
        long l10 = (long)DtsUtil.parseDtsAudioSampleCount(byArray) * 1000000L;
        long l11 = this.format.sampleRate;
        this.sampleDurationUs = l11 = (long)((int)(l10 / l11));
    }

    private boolean skipToNextSync(ParsableByteArray object) {
        int n10;
        while ((n10 = ((ParsableByteArray)object).bytesLeft()) > 0) {
            this.syncBytes = n10 = this.syncBytes << 8;
            int n11 = ((ParsableByteArray)object).readUnsignedByte();
            this.syncBytes = n10 |= n11;
            if ((n10 = (int)(DtsUtil.isSyncWord(n10) ? 1 : 0)) == 0) continue;
            object = this.headerScratchBytes.getData();
            n10 = this.syncBytes;
            n11 = (byte)(n10 >> 24 & 0xFF);
            object[0] = n11;
            n11 = (byte)(n10 >> 16 & 0xFF);
            boolean bl2 = true;
            object[bl2] = n11;
            byte by2 = (byte)(n10 >> 8 & 0xFF);
            object[2] = by2;
            n10 = (byte)(n10 & 0xFF);
            object[3] = n10;
            this.bytesRead = 4;
            this.syncBytes = 0;
            return bl2;
        }
        return false;
    }

    public void consume(ParsableByteArray object) {
        int n10;
        Object object2 = this.output;
        Assertions.checkStateNotNull(object2);
        while ((n10 = ((ParsableByteArray)object).bytesLeft()) > 0) {
            n10 = this.state;
            int n11 = 1;
            if (n10 != 0) {
                ParsableByteArray parsableByteArray = null;
                int n12 = 2;
                if (n10 != n11) {
                    if (n10 == n12) {
                        n10 = ((ParsableByteArray)object).bytesLeft();
                        n11 = this.sampleSize;
                        n12 = this.bytesRead;
                        n10 = Math.min(n10, n11 -= n12);
                        TrackOutput trackOutput = this.output;
                        trackOutput.sampleData((ParsableByteArray)object, n10);
                        this.bytesRead = n11 = this.bytesRead + n10;
                        int n13 = this.sampleSize;
                        if (n11 != n13) continue;
                        TrackOutput trackOutput2 = this.output;
                        long l10 = this.timeUs;
                        int n14 = 1;
                        trackOutput2.sampleMetadata(l10, n14, n13, 0, null);
                        long l11 = this.timeUs;
                        long l12 = this.sampleDurationUs;
                        this.timeUs = l11 += l12;
                        this.state = 0;
                        continue;
                    }
                    object = new IllegalStateException();
                    throw object;
                }
                object2 = this.headerScratchBytes.getData();
                n10 = (int)(this.continueRead((ParsableByteArray)object, (byte[])object2, n11 = 18) ? 1 : 0);
                if (n10 == 0) continue;
                this.parseHeader();
                this.headerScratchBytes.setPosition(0);
                object2 = this.output;
                parsableByteArray = this.headerScratchBytes;
                object2.sampleData(parsableByteArray, n11);
                this.state = n12;
                continue;
            }
            n10 = (int)(this.skipToNextSync((ParsableByteArray)object) ? 1 : 0);
            if (n10 == 0) continue;
            this.state = n11;
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
        this.bytesRead = 0;
        this.syncBytes = 0;
    }
}

