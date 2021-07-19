/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.amr;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.h0.b.a;
import java.io.EOFException;
import java.util.Arrays;

public final class AmrExtractor
implements Extractor {
    public static final ExtractorsFactory FACTORY;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    private static final int MAX_FRAME_SIZE_BYTES = 0;
    private static final int NUM_SAME_SIZE_CONSTANT_BIT_RATE_THRESHOLD = 20;
    private static final int SAMPLE_RATE_NB = 8000;
    private static final int SAMPLE_RATE_WB = 16000;
    private static final int SAMPLE_TIME_PER_FRAME_US = 20000;
    private static final byte[] amrSignatureNb;
    private static final byte[] amrSignatureWb;
    private static final int[] frameSizeBytesByTypeNb;
    private static final int[] frameSizeBytesByTypeWb;
    private int currentSampleBytesRemaining;
    private int currentSampleSize;
    private long currentSampleTimeUs;
    private ExtractorOutput extractorOutput;
    private long firstSamplePosition;
    private int firstSampleSize;
    private final int flags;
    private boolean hasOutputFormat;
    private boolean hasOutputSeekMap;
    private boolean isWideBand;
    private int numSamplesWithSameSize;
    private final byte[] scratch;
    private SeekMap seekMap;
    private long timeOffsetUs;
    private TrackOutput trackOutput;

    static {
        int[] nArray;
        int[] nArray2;
        FACTORY = a.a;
        int n10 = 16;
        int[] nArray3 = nArray2 = new int[n10];
        int[] nArray4 = nArray2;
        nArray3[0] = 13;
        nArray4[1] = 14;
        nArray3[2] = 16;
        nArray4[3] = 18;
        nArray3[4] = 20;
        nArray4[5] = 21;
        nArray3[6] = 27;
        nArray4[7] = 32;
        nArray3[8] = 6;
        nArray4[9] = 7;
        nArray3[10] = 6;
        nArray4[11] = 6;
        nArray3[12] = 1;
        nArray4[13] = 1;
        nArray3[14] = 1;
        nArray4[15] = 1;
        frameSizeBytesByTypeNb = nArray2;
        int[] nArray5 = nArray = new int[n10];
        int[] nArray6 = nArray;
        nArray5[0] = 18;
        nArray6[1] = 24;
        nArray5[2] = 33;
        nArray6[3] = 37;
        nArray5[4] = 41;
        nArray6[5] = 47;
        nArray5[6] = 51;
        nArray6[7] = 59;
        nArray5[8] = 61;
        nArray6[9] = 6;
        nArray5[10] = 1;
        nArray6[11] = 1;
        nArray5[12] = 1;
        nArray6[13] = 1;
        nArray5[14] = 1;
        nArray6[15] = 1;
        frameSizeBytesByTypeWb = nArray;
        amrSignatureNb = Util.getUtf8Bytes("#!AMR\n");
        amrSignatureWb = Util.getUtf8Bytes("#!AMR-WB\n");
        MAX_FRAME_SIZE_BYTES = nArray[8];
    }

    public AmrExtractor() {
        this(0);
    }

    public AmrExtractor(int n10) {
        this.flags = n10;
        byte[] byArray = new byte[1];
        this.scratch = byArray;
        this.firstSampleSize = -1;
    }

    public static /* synthetic */ Extractor[] a() {
        Extractor[] extractorArray = new Extractor[1];
        AmrExtractor amrExtractor = new AmrExtractor();
        extractorArray[0] = amrExtractor;
        return extractorArray;
    }

    public static byte[] amrSignatureNb() {
        byte[] byArray = amrSignatureNb;
        int n10 = byArray.length;
        return Arrays.copyOf(byArray, n10);
    }

    public static byte[] amrSignatureWb() {
        byte[] byArray = amrSignatureWb;
        int n10 = byArray.length;
        return Arrays.copyOf(byArray, n10);
    }

    private void assertInitialized() {
        Assertions.checkStateNotNull(this.trackOutput);
        Util.castNonNull(this.extractorOutput);
    }

    public static int frameSizeBytesByTypeNb(int n10) {
        return frameSizeBytesByTypeNb[n10];
    }

    public static int frameSizeBytesByTypeWb(int n10) {
        return frameSizeBytesByTypeWb[n10];
    }

    private static int getBitrateFromFrameSize(int n10, long l10) {
        return (int)((long)(n10 * 8) * 1000000L / l10);
    }

    private SeekMap getConstantBitrateSeekMap(long l10) {
        int n10 = AmrExtractor.getBitrateFromFrameSize(this.firstSampleSize, 20000L);
        long l11 = this.firstSamplePosition;
        int n11 = this.firstSampleSize;
        ConstantBitrateSeekMap constantBitrateSeekMap = new ConstantBitrateSeekMap(l10, l11, n10, n11);
        return constantBitrateSeekMap;
    }

    private int getFrameSizeInBytes(int n10) {
        boolean bl2 = this.isValidFrameType(n10);
        if (!bl2) {
            boolean bl3 = this.isWideBand;
            String string2 = bl3 ? "WB" : "NB";
            int n11 = string2.length() + 35;
            StringBuilder stringBuilder = new StringBuilder(n11);
            stringBuilder.append("Illegal AMR ");
            stringBuilder.append(string2);
            stringBuilder.append(" frame type ");
            stringBuilder.append(n10);
            String string3 = stringBuilder.toString();
            ParserException parserException = new ParserException(string3);
            throw parserException;
        }
        bl2 = this.isWideBand;
        if (bl2) {
            int[] nArray = frameSizeBytesByTypeWb;
            n10 = nArray[n10];
        } else {
            int[] nArray = frameSizeBytesByTypeNb;
            n10 = nArray[n10];
        }
        return n10;
    }

    private boolean isNarrowBandValidFrameType(int n10) {
        int n11 = this.isWideBand;
        n10 = n11 == 0 && (n10 < (n11 = 12) || n10 > (n11 = 14)) ? 1 : 0;
        return n10 != 0;
    }

    private boolean isValidFrameType(int n10) {
        int n11;
        n10 = n10 >= 0 && n10 <= (n11 = 15) && ((n11 = (int)(this.isWideBandValidFrameType(n10) ? 1 : 0)) != 0 || (n10 = (int)(this.isNarrowBandValidFrameType(n10) ? 1 : 0)) != 0) ? 1 : 0;
        return n10 != 0;
    }

    private boolean isWideBandValidFrameType(int n10) {
        int n11 = this.isWideBand;
        n10 = n11 != 0 && (n10 < (n11 = 10) || n10 > (n11 = 13)) ? 1 : 0;
        return n10 != 0;
    }

    private void maybeOutputFormat() {
        int n10 = (int)(this.hasOutputFormat ? 1 : 0);
        if (n10 == 0) {
            n10 = 1;
            this.hasOutputFormat = n10;
            int n11 = this.isWideBand;
            Object object = n11 != 0 ? "audio/amr-wb" : "audio/3gpp";
            n11 = n11 != 0 ? 16000 : 8000;
            TrackOutput trackOutput = this.trackOutput;
            Format$Builder format$Builder = new Format$Builder();
            object = format$Builder.setSampleMimeType((String)object);
            int n12 = MAX_FRAME_SIZE_BYTES;
            object = ((Format$Builder)object).setMaxInputSize(n12);
            Format format = ((Format$Builder)object).setChannelCount(n10).setSampleRate(n11).build();
            trackOutput.format(format);
        }
    }

    private void maybeOutputSeekMap(long l10, int n10) {
        int n11;
        int n12;
        long l11;
        long l12;
        int n13 = this.hasOutputSeekMap;
        if (n13 != 0) {
            return;
        }
        n13 = this.flags;
        int n14 = 1;
        if ((n13 &= n14) != 0 && (n13 = (int)((l12 = l10 - (l11 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0 && ((n13 = this.firstSampleSize) == (n12 = -1) || n13 == (n11 = this.currentSampleSize))) {
            n13 = this.numSamplesWithSameSize;
            n11 = 20;
            if (n13 >= n11 || n10 == n12) {
                SeekMap seekMap;
                this.seekMap = seekMap = this.getConstantBitrateSeekMap(l10);
                ExtractorOutput extractorOutput = this.extractorOutput;
                extractorOutput.seekMap(seekMap);
                this.hasOutputSeekMap = n14;
            }
        } else {
            long l13 = -9223372036854775807L;
            SeekMap$Unseekable seekMap$Unseekable = new SeekMap$Unseekable(l13);
            this.seekMap = seekMap$Unseekable;
            ExtractorOutput extractorOutput = this.extractorOutput;
            extractorOutput.seekMap(seekMap$Unseekable);
            this.hasOutputSeekMap = n14;
        }
    }

    private static boolean peekAmrSignature(ExtractorInput extractorInput, byte[] byArray) {
        extractorInput.resetPeekPosition();
        byte[] byArray2 = new byte[byArray.length];
        int n10 = byArray.length;
        extractorInput.peekFully(byArray2, 0, n10);
        return Arrays.equals(byArray2, byArray);
    }

    private int peekNextSampleSize(ExtractorInput object) {
        object.resetPeekPosition();
        Object object2 = this.scratch;
        int n10 = 1;
        object.peekFully((byte[])object2, 0, n10);
        object = this.scratch;
        Object object3 = object[0];
        int n11 = object3 & 0x83;
        if (n11 <= 0) {
            object3 = object3 >> 3 & 0xF;
            return this.getFrameSizeInBytes((int)object3);
        }
        object2 = new ParserException;
        StringBuilder stringBuilder = new StringBuilder(42);
        stringBuilder.append("Invalid padding bits for frame header ");
        stringBuilder.append((int)object3);
        object = stringBuilder.toString();
        object2((String)object);
        throw object2;
    }

    private boolean readAmrHeader(ExtractorInput extractorInput) {
        byte[] byArray = amrSignatureNb;
        boolean bl2 = AmrExtractor.peekAmrSignature(extractorInput, byArray);
        boolean bl3 = true;
        if (bl2) {
            this.isWideBand = false;
            int n10 = byArray.length;
            extractorInput.skipFully(n10);
            return bl3;
        }
        byArray = amrSignatureWb;
        bl2 = AmrExtractor.peekAmrSignature(extractorInput, byArray);
        if (bl2) {
            this.isWideBand = bl3;
            int n11 = byArray.length;
            extractorInput.skipFully(n11);
            return bl3;
        }
        return false;
    }

    private int readSample(ExtractorInput extractorInput) {
        long l10;
        TrackOutput trackOutput;
        int n10;
        int n11;
        int n12 = this.currentSampleBytesRemaining;
        int n13 = 1;
        int n14 = -1;
        if (n12 == 0) {
            try {
                n12 = this.peekNextSampleSize(extractorInput);
            }
            catch (EOFException eOFException) {
                return n14;
            }
            this.currentSampleSize = n12;
            this.currentSampleBytesRemaining = n12;
            n12 = this.firstSampleSize;
            if (n12 == n14) {
                long l11;
                this.firstSamplePosition = l11 = extractorInput.getPosition();
                this.firstSampleSize = n12 = this.currentSampleSize;
            }
            if ((n12 = this.firstSampleSize) == (n11 = this.currentSampleSize)) {
                this.numSamplesWithSameSize = n12 = this.numSamplesWithSameSize + n13;
            }
        }
        if ((n10 = (trackOutput = this.trackOutput).sampleData(extractorInput, n11 = this.currentSampleBytesRemaining, n13 != 0)) == n14) {
            return n14;
        }
        this.currentSampleBytesRemaining = n12 = this.currentSampleBytesRemaining - n10;
        n10 = 0;
        extractorInput = null;
        if (n12 > 0) {
            return 0;
        }
        TrackOutput trackOutput2 = this.trackOutput;
        long l12 = this.timeOffsetUs;
        long l13 = this.currentSampleTimeUs;
        int n15 = this.currentSampleSize;
        trackOutput2.sampleMetadata(l12 += l13, 1, n15, 0, null);
        this.currentSampleTimeUs = l10 = this.currentSampleTimeUs + 20000L;
        return 0;
    }

    public void init(ExtractorOutput extractorOutput) {
        TrackOutput trackOutput;
        this.extractorOutput = extractorOutput;
        this.trackOutput = trackOutput = extractorOutput.track(0, 1);
        extractorOutput.endTracks();
    }

    public int read(ExtractorInput object, PositionHolder positionHolder) {
        this.assertInitialized();
        long l10 = object.getPosition();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false && (l12 = (long)this.readAmrHeader((ExtractorInput)object)) == false) {
            object = new ParserException("Could not find AMR header.");
            throw object;
        }
        this.maybeOutputFormat();
        l12 = this.readSample((ExtractorInput)object);
        l10 = object.getLength();
        this.maybeOutputSeekMap(l10, (int)l12);
        return (int)l12;
    }

    public void release() {
    }

    public void seek(long l10, long l11) {
        boolean bl2;
        this.currentSampleTimeUs = l11 = 0L;
        SeekMap seekMap = null;
        this.currentSampleSize = 0;
        this.currentSampleBytesRemaining = 0;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object != false && (bl2 = (seekMap = this.seekMap) instanceof ConstantBitrateSeekMap)) {
            seekMap = (ConstantBitrateSeekMap)seekMap;
            this.timeOffsetUs = l10 = ((ConstantBitrateSeekMap)seekMap).getTimeUsAtPosition(l10);
        } else {
            this.timeOffsetUs = l11;
        }
    }

    public boolean sniff(ExtractorInput extractorInput) {
        return this.readAmrHeader(extractorInput);
    }
}

