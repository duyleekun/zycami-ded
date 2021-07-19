/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.rawcc;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

public final class RawCcExtractor
implements Extractor {
    private static final int HEADER_ID = 1380139777;
    private static final int HEADER_SIZE = 8;
    private static final int SCRATCH_SIZE = 9;
    private static final int STATE_READING_HEADER = 0;
    private static final int STATE_READING_SAMPLES = 2;
    private static final int STATE_READING_TIMESTAMP_AND_COUNT = 1;
    private static final int TIMESTAMP_SIZE_V0 = 4;
    private static final int TIMESTAMP_SIZE_V1 = 8;
    private final ParsableByteArray dataScratch;
    private final Format format;
    private int parserState;
    private int remainingSampleCount;
    private int sampleBytesWritten;
    private long timestampUs;
    private TrackOutput trackOutput;
    private int version;

    public RawCcExtractor(Format object) {
        this.format = object;
        this.dataScratch = object = new ParsableByteArray(9);
        this.parserState = 0;
    }

    private boolean parseHeader(ExtractorInput object) {
        Object object2 = this.dataScratch;
        int n10 = 8;
        ((ParsableByteArray)object2).reset(n10);
        object2 = this.dataScratch.getData();
        boolean bl2 = true;
        int n11 = object.readFully((byte[])object2, 0, n10, bl2);
        if (n11 != 0) {
            int n12;
            object = this.dataScratch;
            n11 = ((ParsableByteArray)object).readInt();
            if (n11 == (n12 = 1380139777)) {
                this.version = n11 = this.dataScratch.readUnsignedByte();
                return bl2;
            }
            object = new IOException("Input not RawCC");
            throw object;
        }
        return false;
    }

    private void parseSamples(ExtractorInput extractorInput) {
        int n10;
        while ((n10 = this.remainingSampleCount) > 0) {
            Object object = this.dataScratch;
            int n11 = 3;
            ((ParsableByteArray)object).reset(n11);
            object = this.dataScratch.getData();
            extractorInput.readFully((byte[])object, 0, n11);
            object = this.trackOutput;
            ParsableByteArray parsableByteArray = this.dataScratch;
            object.sampleData(parsableByteArray, n11);
            this.sampleBytesWritten = n10 = this.sampleBytesWritten + n11;
            this.remainingSampleCount = n10 = this.remainingSampleCount + -1;
        }
        int n12 = this.sampleBytesWritten;
        if (n12 > 0) {
            TrackOutput trackOutput = this.trackOutput;
            long l10 = this.timestampUs;
            int n13 = 1;
            trackOutput.sampleMetadata(l10, n13, n12, 0, null);
        }
    }

    private boolean parseTimestampAndSampleCount(ExtractorInput object) {
        StringBuilder stringBuilder;
        block7: {
            int n10;
            boolean bl2;
            block6: {
                long l10;
                boolean bl22;
                block5: {
                    bl22 = this.version;
                    bl2 = true;
                    stringBuilder = null;
                    if (bl22) break block5;
                    Object object3 = this.dataScratch;
                    int n12 = 5;
                    ((ParsableByteArray)object3).reset(n12);
                    object3 = this.dataScratch.getData();
                    n10 = object.readFully((byte[])object3, 0, n12, bl2);
                    if (n10 == 0) {
                        return false;
                    }
                    object = this.dataScratch;
                    long l102 = ((ParsableByteArray)object).readUnsignedInt() * 1000L;
                    long l11 = 45;
                    this.timestampUs = l102 /= l11;
                    break block6;
                }
                if (bl22 != bl2) break block7;
                Object string2 = this.dataScratch;
                int n11 = 9;
                ((ParsableByteArray)string2).reset(n11);
                string2 = this.dataScratch.getData();
                n10 = object.readFully((byte[])string2, 0, n11, bl2);
                if (n10 == 0) {
                    return false;
                }
                object = this.dataScratch;
                this.timestampUs = l10 = ((ParsableByteArray)object).readLong();
            }
            this.remainingSampleCount = n10 = this.dataScratch.readUnsignedByte();
            this.sampleBytesWritten = 0;
            return bl2;
        }
        int n12 = this.version;
        stringBuilder = new StringBuilder(39);
        stringBuilder.append("Unsupported version number: ");
        stringBuilder.append(n12);
        String string2 = stringBuilder.toString();
        object = new ParserException(string2);
        throw object;
    }

    public void init(ExtractorOutput extractorOutput) {
        Object object = new SeekMap$Unseekable(-9223372036854775807L);
        extractorOutput.seekMap((SeekMap)object);
        this.trackOutput = object = extractorOutput.track(0, 3);
        Format format = this.format;
        object.format(format);
        extractorOutput.endTracks();
    }

    public int read(ExtractorInput object, PositionHolder object2) {
        int n10;
        object2 = this.trackOutput;
        Assertions.checkStateNotNull(object2);
        while (true) {
            int n11 = this.parserState;
            n10 = -1;
            int n12 = 1;
            if (n11 != 0) {
                int n13 = 2;
                if (n11 != n12) {
                    if (n11 == n13) {
                        this.parseSamples((ExtractorInput)object);
                        this.parserState = n12;
                        return 0;
                    }
                    object = new IllegalStateException();
                    throw object;
                }
                n11 = (int)(this.parseTimestampAndSampleCount((ExtractorInput)object) ? 1 : 0);
                if (n11 != 0) {
                    this.parserState = n13;
                    continue;
                }
                this.parserState = 0;
                return n10;
            }
            n11 = (int)(this.parseHeader((ExtractorInput)object) ? 1 : 0);
            if (n11 == 0) break;
            this.parserState = n12;
        }
        return n10;
    }

    public void release() {
    }

    public void seek(long l10, long l11) {
        this.parserState = 0;
    }

    public boolean sniff(ExtractorInput object) {
        Object object2 = this.dataScratch;
        int n10 = 8;
        ((ParsableByteArray)object2).reset(n10);
        object2 = this.dataScratch.getData();
        boolean bl2 = false;
        object.peekFully((byte[])object2, 0, n10);
        object = this.dataScratch;
        int n11 = ((ParsableByteArray)object).readInt();
        int n12 = 1380139777;
        if (n11 == n12) {
            bl2 = true;
        }
        return bl2;
    }
}

