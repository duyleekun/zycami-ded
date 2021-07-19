/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
import com.google.android.exoplayer2.extractor.ts.AdtsReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$TrackIdGenerator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import d.h.a.a.h0.i.c;

public final class AdtsExtractor
implements Extractor {
    public static final ExtractorsFactory FACTORY = c.a;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    private static final int MAX_PACKET_SIZE = 2048;
    private static final int MAX_SNIFF_BYTES = 8192;
    private static final int NUM_FRAMES_FOR_AVERAGE_FRAME_SIZE = 1000;
    private int averageFrameSize;
    private ExtractorOutput extractorOutput;
    private long firstFramePosition;
    private long firstSampleTimestampUs;
    private final int flags;
    private boolean hasCalculatedAverageFrameSize;
    private boolean hasOutputSeekMap;
    private final ParsableByteArray packetBuffer;
    private final AdtsReader reader;
    private final ParsableByteArray scratch;
    private final ParsableBitArray scratchBits;
    private boolean startedPacket;

    public AdtsExtractor() {
        this(0);
    }

    public AdtsExtractor(int n10) {
        ParsableBitArray parsableBitArray;
        this.flags = n10;
        Object object = new AdtsReader(true);
        this.reader = object;
        this.packetBuffer = object = new ParsableByteArray(2048);
        this.averageFrameSize = -1;
        this.firstFramePosition = -1;
        this.scratch = object = new ParsableByteArray(10);
        object = ((ParsableByteArray)object).getData();
        this.scratchBits = parsableBitArray = new ParsableBitArray((byte[])object);
    }

    public static /* synthetic */ Extractor[] a() {
        Extractor[] extractorArray = new Extractor[1];
        AdtsExtractor adtsExtractor = new AdtsExtractor();
        extractorArray[0] = adtsExtractor;
        return extractorArray;
    }

    /*
     * Exception decompiling
     */
    private void calculateAverageFrameSize(ExtractorInput var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [17[DOLOOP]], but top level block is 13[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static int getBitrateFromFrameSize(int n10, long l10) {
        return (int)((long)(n10 * 8) * 1000000L / l10);
    }

    private SeekMap getConstantBitrateSeekMap(long l10) {
        int n10 = this.averageFrameSize;
        long l11 = this.reader.getSampleDurationUs();
        int n11 = AdtsExtractor.getBitrateFromFrameSize(n10, l11);
        long l12 = this.firstFramePosition;
        int n12 = this.averageFrameSize;
        ConstantBitrateSeekMap constantBitrateSeekMap = new ConstantBitrateSeekMap(l10, l12, n11, n12);
        return constantBitrateSeekMap;
    }

    private void maybeOutputSeekMap(long l10, boolean n10, boolean bl2) {
        long l11;
        long l12;
        AdtsReader adtsReader;
        long l13;
        long l14;
        long l15;
        Object object;
        boolean bl3 = this.hasOutputSeekMap;
        if (bl3) {
            return;
        }
        bl3 = true;
        if (n10 != 0 && (n10 = this.averageFrameSize) > 0) {
            n10 = (int)(bl3 ? 1 : 0);
        } else {
            n10 = 0;
            object = null;
        }
        long l16 = -9223372036854775807L;
        if (n10 != 0 && (l15 = (l14 = (l13 = (adtsReader = this.reader).getSampleDurationUs()) - l16) == 0L ? 0 : (l14 < 0L ? -1 : 1)) == false && !bl2) {
            return;
        }
        if (n10 != 0 && (n10 = (int)((l12 = (l11 = ((AdtsReader)(object = this.reader)).getSampleDurationUs()) - l16) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0) {
            object = this.extractorOutput;
            SeekMap seekMap = this.getConstantBitrateSeekMap(l10);
            object.seekMap(seekMap);
        } else {
            ExtractorOutput extractorOutput = this.extractorOutput;
            SeekMap$Unseekable seekMap$Unseekable = new SeekMap$Unseekable(l16);
            extractorOutput.seekMap(seekMap$Unseekable);
        }
        this.hasOutputSeekMap = bl3;
    }

    private int peekId3Header(ExtractorInput extractorInput) {
        int n10 = 0;
        while (true) {
            Object object = this.scratch.getData();
            extractorInput.peekFully((byte[])object, 0, 10);
            this.scratch.setPosition(0);
            object = this.scratch;
            int n11 = ((ParsableByteArray)object).readUnsignedInt24();
            int n12 = 0x494433;
            if (n11 != n12) {
                extractorInput.resetPeekPosition();
                extractorInput.advancePeekPosition(n10);
                long l10 = this.firstFramePosition;
                long l11 = -1;
                long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (l12 == false) {
                    this.firstFramePosition = l10 = (long)n10;
                }
                return n10;
            }
            this.scratch.skipBytes(3);
            object = this.scratch;
            n11 = ((ParsableByteArray)object).readSynchSafeInt();
            n12 = n11 + 10;
            n10 += n12;
            extractorInput.advancePeekPosition(n11);
        }
    }

    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        AdtsReader adtsReader = this.reader;
        TsPayloadReader$TrackIdGenerator tsPayloadReader$TrackIdGenerator = new TsPayloadReader$TrackIdGenerator(0, 1);
        adtsReader.createTracks(extractorOutput, tsPayloadReader$TrackIdGenerator);
        extractorOutput.endTracks();
    }

    public int read(ExtractorInput object, PositionHolder object2) {
        int n10;
        int n11;
        byte[] byArray;
        int n12;
        long l10;
        long l11;
        object2 = this.extractorOutput;
        Assertions.checkStateNotNull(object2);
        long l12 = object.getLength();
        int n13 = this.flags;
        int n14 = 1;
        if ((n13 &= n14) != 0 && (n13 = (int)((l11 = l12 - (l10 = (long)-1)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) != 0) {
            n13 = n14;
        } else {
            n13 = 0;
            object2 = null;
        }
        if (n13 != 0) {
            this.calculateAverageFrameSize((ExtractorInput)object);
        }
        n11 = (n12 = object.read(byArray = this.packetBuffer.getData(), 0, n11 = 2048)) == (n10 = -1) ? n14 : 0;
        this.maybeOutputSeekMap(l12, n13 != 0, n11 != 0);
        if (n11 != 0) {
            return n10;
        }
        this.packetBuffer.setPosition(0);
        object2 = this.packetBuffer;
        ((ParsableByteArray)object2).setLimit(n12);
        n12 = (int)(this.startedPacket ? 1 : 0);
        if (n12 == 0) {
            object = this.reader;
            l12 = this.firstSampleTimestampUs;
            n13 = 4;
            ((AdtsReader)object).packetStarted(l12, n13);
            this.startedPacket = n14;
        }
        object = this.reader;
        object2 = this.packetBuffer;
        ((AdtsReader)object).consume((ParsableByteArray)object2);
        return 0;
    }

    public void release() {
    }

    public void seek(long l10, long l11) {
        this.startedPacket = false;
        this.reader.seek();
        this.firstSampleTimestampUs = l11;
    }

    public boolean sniff(ExtractorInput extractorInput) {
        int n10;
        int n11 = n10 = this.peekId3Header(extractorInput);
        block0: while (true) {
            int n12 = 0;
            int n13 = 0;
            while (true) {
                int n14;
                Object object = this.scratch.getData();
                int n15 = 2;
                extractorInput.peekFully((byte[])object, 0, n15);
                this.scratch.setPosition(0);
                object = this.scratch;
                int n16 = AdtsReader.isAdtsSyncWord(((ParsableByteArray)object).readUnsignedShort());
                if (n16 == 0) {
                    extractorInput.resetPeekPosition();
                    n12 = ++n11 - n10;
                    n13 = 8192;
                    if (n12 >= n13) {
                        return false;
                    }
                    extractorInput.advancePeekPosition(n11);
                    continue block0;
                }
                n16 = 1;
                n15 = 4;
                if ((n12 += n16) >= n15 && n13 > (n14 = 188)) {
                    return n16 != 0;
                }
                object = this.scratch.getData();
                extractorInput.peekFully((byte[])object, 0, n15);
                this.scratchBits.setPosition(14);
                object = this.scratchBits;
                n16 = ((ParsableBitArray)object).readBits(13);
                n15 = 6;
                if (n16 <= n15) {
                    return false;
                }
                n15 = n16 + -6;
                extractorInput.advancePeekPosition(n15);
                n13 += n16;
            }
            break;
        }
    }
}

