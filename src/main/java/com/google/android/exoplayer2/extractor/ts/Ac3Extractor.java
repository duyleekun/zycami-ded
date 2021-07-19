/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
import com.google.android.exoplayer2.extractor.ts.Ac3Reader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import d.h.a.a.h0.i.a;

public final class Ac3Extractor
implements Extractor {
    private static final int AC3_SYNC_WORD = 2935;
    public static final ExtractorsFactory FACTORY = a.a;
    private static final int MAX_SNIFF_BYTES = 8192;
    private static final int MAX_SYNC_FRAME_SIZE = 2786;
    private final Ac3Reader reader;
    private final ParsableByteArray sampleData;
    private boolean startedPacket;

    public Ac3Extractor() {
        Object object = new Ac3Reader();
        this.reader = object;
        this.sampleData = object = new ParsableByteArray(2786);
    }

    public static /* synthetic */ Extractor[] a() {
        Extractor[] extractorArray = new Extractor[1];
        Ac3Extractor ac3Extractor = new Ac3Extractor();
        extractorArray[0] = ac3Extractor;
        return extractorArray;
    }

    public void init(ExtractorOutput extractorOutput) {
        Object object = this.reader;
        TsPayloadReader$TrackIdGenerator tsPayloadReader$TrackIdGenerator = new TsPayloadReader$TrackIdGenerator(0, 1);
        ((Ac3Reader)object).createTracks(extractorOutput, tsPayloadReader$TrackIdGenerator);
        extractorOutput.endTracks();
        object = new SeekMap$Unseekable(-9223372036854775807L);
        extractorOutput.seekMap((SeekMap)object);
    }

    public int read(ExtractorInput object, PositionHolder object2) {
        int n10;
        int n11;
        object2 = this.sampleData.getData();
        int n12 = object.read((byte[])object2, 0, n11 = 2786);
        if (n12 == (n10 = -1)) {
            return n10;
        }
        this.sampleData.setPosition(0);
        object2 = this.sampleData;
        ((ParsableByteArray)object2).setLimit(n12);
        n12 = (int)(this.startedPacket ? 1 : 0);
        if (n12 == 0) {
            object = this.reader;
            long l10 = 0L;
            n10 = 4;
            ((Ac3Reader)object).packetStarted(l10, n10);
            n12 = 1;
            this.startedPacket = n12;
        }
        object = this.reader;
        object2 = this.sampleData;
        ((Ac3Reader)object).consume((ParsableByteArray)object2);
        return 0;
    }

    public void release() {
    }

    public void seek(long l10, long l11) {
        this.startedPacket = false;
        this.reader.seek();
    }

    public boolean sniff(ExtractorInput extractorInput) {
        int n10 = 10;
        ParsableByteArray parsableByteArray = new ParsableByteArray(n10);
        int n11 = 0;
        while (true) {
            byte[] byArray = parsableByteArray.getData();
            extractorInput.peekFully(byArray, 0, n10);
            parsableByteArray.setPosition(0);
            int n12 = parsableByteArray.readUnsignedInt24();
            int n13 = 0x494433;
            if (n12 != n13) {
                extractorInput.resetPeekPosition();
                extractorInput.advancePeekPosition(n11);
                n10 = 0;
                n12 = n11;
                while (true) {
                    byte[] byArray2 = parsableByteArray.getData();
                    extractorInput.peekFully(byArray2, 0, 6);
                    parsableByteArray.setPosition(0);
                    n13 = parsableByteArray.readUnsignedShort();
                    int n14 = 2935;
                    if (n13 != n14) {
                        extractorInput.resetPeekPosition();
                        n10 = ++n12 - n11;
                        n13 = 8192;
                        if (n10 >= n13) {
                            return false;
                        }
                        extractorInput.advancePeekPosition(n12);
                        n10 = 0;
                        continue;
                    }
                    n13 = 1;
                    n14 = 4;
                    if ((n10 += n13) >= n14) {
                        return n13 != 0;
                    }
                    byArray2 = parsableByteArray.getData();
                    n13 = Ac3Util.parseAc3SyncframeSize(byArray2);
                    if (n13 == (n14 = -1)) {
                        return false;
                    }
                    extractorInput.advancePeekPosition(n13 += -6);
                }
            }
            parsableByteArray.skipBytes(3);
            n12 = parsableByteArray.readSynchSafeInt();
            n13 = n12 + 10;
            n11 += n13;
            extractorInput.advancePeekPosition(n12);
        }
    }
}

