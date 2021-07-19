/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.audio.Ac3Util$SyncFrameInfo;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class Ac3Reader
implements ElementaryStreamReader {
    private static final int HEADER_SIZE = 128;
    private static final int STATE_FINDING_SYNC = 0;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private int bytesRead;
    private Format format;
    private String formatId;
    private final ParsableBitArray headerScratchBits;
    private final ParsableByteArray headerScratchBytes;
    private final String language;
    private boolean lastByteWas0B;
    private TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private long timeUs;

    public Ac3Reader() {
        this(null);
    }

    public Ac3Reader(String string2) {
        Object object = new byte[128];
        Object object2 = new ParsableBitArray((byte[])object);
        this.headerScratchBits = object2;
        object = new ParsableByteArray;
        object2 = ((ParsableBitArray)object2).data;
        super((byte[])object2);
        this.headerScratchBytes = object;
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
        Object object;
        int n10;
        int n11;
        Object object2 = this.headerScratchBits;
        int n12 = 0;
        ((ParsableBitArray)object2).setPosition(0);
        object2 = Ac3Util.parseAc3SyncframeInfo(this.headerScratchBits);
        Object object3 = this.format;
        if (object3 == null || (n11 = ((Ac3Util$SyncFrameInfo)object2).channelCount) != (n10 = ((Format)object3).channelCount) || (n11 = ((Ac3Util$SyncFrameInfo)object2).sampleRate) != (n10 = ((Format)object3).sampleRate) || (n12 = Util.areEqual(object = ((Ac3Util$SyncFrameInfo)object2).mimeType, object3 = ((Format)object3).sampleMimeType)) == 0) {
            object3 = new Format$Builder();
            object = this.formatId;
            object3 = ((Format$Builder)object3).setId((String)object);
            object = ((Ac3Util$SyncFrameInfo)object2).mimeType;
            object3 = ((Format$Builder)object3).setSampleMimeType((String)object);
            n11 = ((Ac3Util$SyncFrameInfo)object2).channelCount;
            object3 = ((Format$Builder)object3).setChannelCount(n11);
            n11 = ((Ac3Util$SyncFrameInfo)object2).sampleRate;
            object3 = ((Format$Builder)object3).setSampleRate(n11);
            object = this.language;
            this.format = object3 = ((Format$Builder)object3).setLanguage((String)object).build();
            object = this.output;
            object.format((Format)object3);
        }
        this.sampleSize = n12 = ((Ac3Util$SyncFrameInfo)object2).frameSize;
        long l10 = (long)((Ac3Util$SyncFrameInfo)object2).sampleCount * 1000000L;
        long l11 = this.format.sampleRate;
        this.sampleDurationUs = l10 /= l11;
    }

    private boolean skipToNextSync(ParsableByteArray parsableByteArray) {
        while (true) {
            int n10;
            int n11 = parsableByteArray.bytesLeft();
            boolean bl2 = false;
            if (n11 <= 0) break;
            n11 = (int)(this.lastByteWas0B ? 1 : 0);
            int n12 = 11;
            boolean bl3 = true;
            if (n11 == 0) {
                n11 = parsableByteArray.readUnsignedByte();
                if (n11 == n12) {
                    bl2 = bl3;
                }
                this.lastByteWas0B = bl2;
                continue;
            }
            n11 = parsableByteArray.readUnsignedByte();
            if (n11 == (n10 = 119)) {
                this.lastByteWas0B = false;
                return bl3;
            }
            if (n11 == n12) {
                bl2 = bl3;
            }
            this.lastByteWas0B = bl2;
        }
        return false;
    }

    public void consume(ParsableByteArray parsableByteArray) {
        int n10;
        Object object = this.output;
        Assertions.checkStateNotNull(object);
        while ((n10 = parsableByteArray.bytesLeft()) > 0) {
            n10 = this.state;
            int n11 = 0;
            ParsableByteArray parsableByteArray2 = null;
            int n12 = 2;
            int n13 = 1;
            if (n10 != 0) {
                if (n10 != n13) {
                    if (n10 != n12) continue;
                    n10 = parsableByteArray.bytesLeft();
                    n12 = this.sampleSize;
                    n13 = this.bytesRead;
                    n10 = Math.min(n10, n12 -= n13);
                    TrackOutput trackOutput = this.output;
                    trackOutput.sampleData(parsableByteArray, n10);
                    this.bytesRead = n12 = this.bytesRead + n10;
                    int n14 = this.sampleSize;
                    if (n12 != n14) continue;
                    TrackOutput trackOutput2 = this.output;
                    long l10 = this.timeUs;
                    int n15 = 1;
                    trackOutput2.sampleMetadata(l10, n15, n14, 0, null);
                    long l11 = this.timeUs;
                    l10 = this.sampleDurationUs;
                    this.timeUs = l11 += l10;
                    this.state = 0;
                    continue;
                }
                object = this.headerScratchBytes.getData();
                n10 = (int)(this.continueRead(parsableByteArray, (byte[])object, n13 = 128) ? 1 : 0);
                if (n10 == 0) continue;
                this.parseHeader();
                this.headerScratchBytes.setPosition(0);
                object = this.output;
                parsableByteArray2 = this.headerScratchBytes;
                object.sampleData(parsableByteArray2, n13);
                this.state = n12;
                continue;
            }
            n10 = (int)(this.skipToNextSync(parsableByteArray) ? 1 : 0);
            if (n10 == 0) continue;
            this.state = n13;
            object = this.headerScratchBytes.getData();
            int n16 = 11;
            object[0] = n16;
            object = this.headerScratchBytes.getData();
            n11 = 119;
            object[n13] = n11;
            this.bytesRead = n12;
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
        this.lastByteWas0B = false;
    }
}

