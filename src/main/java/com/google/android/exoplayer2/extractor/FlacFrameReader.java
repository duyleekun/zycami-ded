/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.extractor.FlacFrameReader$SampleNumberHolder;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class FlacFrameReader {
    private FlacFrameReader() {
    }

    private static boolean checkAndReadBlockSizeSamples(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int n10) {
        int n11;
        int n12 = FlacFrameReader.readFrameBlockSizeSamplesFromKey(parsableByteArray, n10);
        if (n12 != (n10 = -1) && n12 <= (n11 = flacStreamMetadata.maxBlockSizeSamples)) {
            n12 = 1;
        } else {
            n12 = 0;
            parsableByteArray = null;
        }
        return n12 != 0;
    }

    private static boolean checkAndReadCrc(ParsableByteArray object, int n10) {
        int n11;
        int n12 = ((ParsableByteArray)object).readUnsignedByte();
        int n13 = ((ParsableByteArray)object).getPosition();
        int n14 = Util.crc8((byte[])(object = (Object)((ParsableByteArray)object).getData()), n10, n13 -= (n11 = 1), 0);
        if (n12 != n14) {
            n11 = 0;
        }
        return n11 != 0;
    }

    private static boolean checkAndReadFirstSampleNumber(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, boolean bl2, FlacFrameReader$SampleNumberHolder flacFrameReader$SampleNumberHolder) {
        long l10;
        block2: {
            int n10;
            try {
                l10 = parsableByteArray.readUtf8EncodedLong();
                if (bl2) break block2;
                n10 = flacStreamMetadata.maxBlockSizeSamples;
            }
            catch (NumberFormatException numberFormatException) {
                return false;
            }
            long l11 = n10;
            l10 *= l11;
        }
        flacFrameReader$SampleNumberHolder.sampleNumber = l10;
        return true;
    }

    /*
     * WARNING - void declaration
     */
    public static boolean checkAndReadFrameHeader(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int n10, FlacFrameReader$SampleNumberHolder flacFrameReader$SampleNumberHolder) {
        boolean bl2;
        boolean bl3;
        void var9_12;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        FlacStreamMetadata flacStreamMetadata2 = flacStreamMetadata;
        int n11 = parsableByteArray.getPosition();
        long l10 = parsableByteArray.readUnsignedInt();
        int bl4 = 16;
        long l11 = l10 >>> bl4;
        int n12 = n10;
        long l12 = n10;
        n12 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
        int n13 = 0;
        if (n12 != 0) {
            return false;
        }
        long l13 = 1L;
        long l14 = (l11 &= l13) - l13;
        long l15 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        int n14 = 1;
        if (l15 == false) {
            int n15 = n14;
        } else {
            boolean bl5 = false;
        }
        long l16 = l10 >> 12;
        long l17 = 15;
        n12 = (int)(l16 & l17);
        l16 = l10 >> 8 & l17;
        int n16 = (int)l16;
        long l18 = l10 >> 4 & l17;
        int n17 = (int)l18;
        l17 = l10 >> n14;
        long l19 = 7;
        int n18 = (int)(l17 &= l19);
        long l20 = (l10 &= l13) - l13;
        long l21 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
        l21 = l21 == false ? (long)n14 : (long)0;
        boolean bl6 = FlacFrameReader.checkChannelAssignment(n17, flacStreamMetadata2);
        if (bl6 && (bl6 = FlacFrameReader.checkBitsPerSample(n18, flacStreamMetadata2)) && l21 == false && (l21 = (long)FlacFrameReader.checkAndReadFirstSampleNumber(parsableByteArray2, flacStreamMetadata2, (boolean)var9_12, flacFrameReader$SampleNumberHolder)) != false && (l21 = (long)FlacFrameReader.checkAndReadBlockSizeSamples(parsableByteArray2, flacStreamMetadata2, n12)) != false && (bl3 = FlacFrameReader.checkAndReadSampleRate(parsableByteArray2, flacStreamMetadata2, n16)) && (bl2 = FlacFrameReader.checkAndReadCrc(parsableByteArray2, n11))) {
            n13 = n14;
        }
        return n13 != 0;
    }

    private static boolean checkAndReadSampleRate(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int n10) {
        int n11 = flacStreamMetadata.sampleRate;
        boolean bl2 = true;
        if (n10 == 0) {
            return bl2;
        }
        int n12 = 11;
        if (n10 <= n12) {
            int n13 = flacStreamMetadata.sampleRateLookupKey;
            if (n10 != n13) {
                bl2 = false;
            }
            return bl2;
        }
        int n14 = 12;
        if (n10 == n14) {
            int n15 = parsableByteArray.readUnsignedByte() * 1000;
            if (n15 != n11) {
                bl2 = false;
            }
            return bl2;
        }
        n14 = 14;
        if (n10 <= n14) {
            int n16 = parsableByteArray.readUnsignedShort();
            if (n10 == n14) {
                n16 *= 10;
            }
            if (n16 != n11) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    private static boolean checkBitsPerSample(int n10, FlacStreamMetadata flacStreamMetadata) {
        boolean bl2 = true;
        if (n10 == 0) {
            return bl2;
        }
        int n11 = flacStreamMetadata.bitsPerSampleLookupKey;
        if (n10 != n11) {
            bl2 = false;
        }
        return bl2;
    }

    private static boolean checkChannelAssignment(int n10, FlacStreamMetadata flacStreamMetadata) {
        int n11;
        int n12 = 0;
        int n13 = 1;
        int n14 = 7;
        if (n10 <= n14) {
            int n15 = flacStreamMetadata.channels - n13;
            if (n10 == n15) {
                n12 = n13;
            }
            return n12 != 0;
        }
        n14 = 10;
        if (n10 <= n14 && (n10 = flacStreamMetadata.channels) == (n11 = 2)) {
            n12 = n13;
        }
        return n12 != 0;
    }

    public static boolean checkFrameHeaderFromPeek(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata, int n10, FlacFrameReader$SampleNumberHolder flacFrameReader$SampleNumberHolder) {
        long l10 = extractorInput.getPeekPosition();
        int n11 = 2;
        byte[] byArray = new byte[n11];
        extractorInput.peekFully(byArray, 0, n11);
        int n12 = (byArray[0] & 0xFF) << 8;
        int n13 = byArray[1] & 0xFF;
        if ((n12 |= n13) != n10) {
            extractorInput.resetPeekPosition();
            long l11 = extractorInput.getPosition();
            int n14 = (int)(l10 - l11);
            extractorInput.advancePeekPosition(n14);
            return false;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        byte[] byArray2 = parsableByteArray.getData();
        System.arraycopy(byArray, 0, byArray2, 0, n11);
        byArray = parsableByteArray.getData();
        n11 = ExtractorUtil.peekToLength(extractorInput, byArray, n11, 14);
        parsableByteArray.setLimit(n11);
        extractorInput.resetPeekPosition();
        long l12 = extractorInput.getPosition();
        int n15 = (int)(l10 - l12);
        extractorInput.advancePeekPosition(n15);
        return FlacFrameReader.checkAndReadFrameHeader(parsableByteArray, flacStreamMetadata, n10, flacFrameReader$SampleNumberHolder);
    }

    public static long getFirstSampleNumber(ExtractorInput object, FlacStreamMetadata flacStreamMetadata) {
        object.resetPeekPosition();
        int n10 = 1;
        object.advancePeekPosition(n10);
        byte[] byArray = new byte[n10];
        object.peekFully(byArray, 0, n10);
        int n11 = byArray[0] & n10;
        if (n11 != n10) {
            n10 = 0;
        }
        n11 = 2;
        object.advancePeekPosition(n11);
        n11 = n10 != 0 ? 7 : 6;
        ParsableByteArray parsableByteArray = new ParsableByteArray(n11);
        byte[] byArray2 = parsableByteArray.getData();
        n11 = ExtractorUtil.peekToLength((ExtractorInput)object, byArray2, 0, n11);
        parsableByteArray.setLimit(n11);
        object.resetPeekPosition();
        object = new FlacFrameReader$SampleNumberHolder();
        boolean bl2 = FlacFrameReader.checkAndReadFirstSampleNumber(parsableByteArray, flacStreamMetadata, n10 != 0, (FlacFrameReader$SampleNumberHolder)object);
        if (bl2) {
            return ((FlacFrameReader$SampleNumberHolder)object).sampleNumber;
        }
        object = new ParserException();
        throw object;
    }

    public static int readFrameBlockSizeSamplesFromKey(ParsableByteArray parsableByteArray, int n10) {
        switch (n10) {
            default: {
                return -1;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                return 256 << (n10 += -8);
            }
            case 7: {
                return parsableByteArray.readUnsignedShort() + 1;
            }
            case 6: {
                return parsableByteArray.readUnsignedByte() + 1;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return 576 << (n10 += -2);
            }
            case 1: 
        }
        return 192;
    }
}

