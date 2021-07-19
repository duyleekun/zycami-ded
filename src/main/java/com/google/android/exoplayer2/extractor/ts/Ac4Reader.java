/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.audio.Ac4Util$SyncFrameInfo;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Ac4Reader
implements ElementaryStreamReader {
    private static final int STATE_FINDING_SYNC = 0;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private int bytesRead;
    private Format format;
    private String formatId;
    private boolean hasCRC;
    private final ParsableBitArray headerScratchBits;
    private final ParsableByteArray headerScratchBytes;
    private final String language;
    private boolean lastByteWasAC;
    private TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private long timeUs;

    public Ac4Reader() {
        this(null);
    }

    public Ac4Reader(String string2) {
        Object object = new byte[16];
        Object object2 = new ParsableBitArray((byte[])object);
        this.headerScratchBits = object2;
        object = new ParsableByteArray;
        object2 = ((ParsableBitArray)object2).data;
        super((byte[])object2);
        this.headerScratchBytes = object;
        this.state = 0;
        this.bytesRead = 0;
        this.lastByteWasAC = false;
        this.hasCRC = false;
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
        int n11;
        Object object = this.headerScratchBits;
        int n12 = 0;
        ((ParsableBitArray)object).setPosition(0);
        object = Ac4Util.parseAc4SyncframeInfo(this.headerScratchBits);
        Object object2 = this.format;
        Object object3 = "audio/ac4";
        if (object2 == null || (n11 = ((Ac4Util$SyncFrameInfo)object).channelCount) != (n10 = ((Format)object2).channelCount) || (n11 = ((Ac4Util$SyncFrameInfo)object).sampleRate) != (n10 = ((Format)object2).sampleRate) || (n12 = ((String)object3).equals(object2 = ((Format)object2).sampleMimeType)) == 0) {
            object2 = new Format$Builder();
            String string2 = this.formatId;
            object2 = ((Format$Builder)object2).setId(string2).setSampleMimeType((String)object3);
            int n13 = ((Ac4Util$SyncFrameInfo)object).channelCount;
            object2 = ((Format$Builder)object2).setChannelCount(n13);
            n13 = ((Ac4Util$SyncFrameInfo)object).sampleRate;
            object2 = ((Format$Builder)object2).setSampleRate(n13);
            object3 = this.language;
            this.format = object2 = ((Format$Builder)object2).setLanguage((String)object3).build();
            object3 = this.output;
            object3.format((Format)object2);
        }
        this.sampleSize = n12 = ((Ac4Util$SyncFrameInfo)object).frameSize;
        long l10 = (long)((Ac4Util$SyncFrameInfo)object).sampleCount * 1000000L;
        long l11 = this.format.sampleRate;
        this.sampleDurationUs = l10 /= l11;
    }

    private boolean skipToNextSync(ParsableByteArray parsableByteArray) {
        block4: {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            while (true) {
                bl5 = parsableByteArray.bytesLeft();
                bl4 = false;
                if (bl5 <= false) break block4;
                bl5 = this.lastByteWasAC;
                boolean bl6 = 172 != 0;
                bl3 = true;
                if (!bl5) {
                    bl5 = parsableByteArray.readUnsignedByte();
                    if (bl5 == bl6) {
                        bl4 = bl3;
                    }
                    this.lastByteWasAC = bl4;
                    continue;
                }
                bl5 = parsableByteArray.readUnsignedByte();
                bl6 = bl5 == bl6 ? bl3 : false;
                this.lastByteWasAC = bl6;
                bl6 = 64 != 0;
                bl2 = 65 != 0;
                if (bl5 == bl6 || bl5 == bl2) break;
            }
            if (bl5 == bl2) {
                bl4 = bl3;
            }
            this.hasCRC = bl4;
            return bl3;
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
                n10 = (int)(this.continueRead(parsableByteArray, (byte[])object, n13 = 16) ? 1 : 0);
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
            int n16 = -84;
            object[0] = n16;
            object = this.headerScratchBytes.getData();
            n11 = this.hasCRC;
            n11 = n11 != 0 ? 65 : 64;
            n11 = (byte)n11;
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
        this.lastByteWasAC = false;
        this.hasCRC = false;
    }
}

