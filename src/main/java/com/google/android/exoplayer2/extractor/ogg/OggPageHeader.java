/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;

public final class OggPageHeader {
    private static final int CAPTURE_PATTERN = 1332176723;
    private static final int CAPTURE_PATTERN_SIZE = 4;
    public static final int EMPTY_PAGE_HEADER_SIZE = 27;
    public static final int MAX_PAGE_PAYLOAD = 65025;
    public static final int MAX_PAGE_SIZE = 65307;
    public static final int MAX_SEGMENT_COUNT = 255;
    public int bodySize;
    public long granulePosition;
    public int headerSize;
    public final int[] laces;
    public long pageChecksum;
    public int pageSegmentCount;
    public long pageSequenceNumber;
    public int revision;
    private final ParsableByteArray scratch;
    public long streamSerialNumber;
    public int type;

    public OggPageHeader() {
        int n10 = 255;
        Object object = new int[n10];
        this.laces = object;
        object = new ParsableByteArray;
        super(n10);
        this.scratch = object;
    }

    private static boolean peekSafely(ExtractorInput extractorInput, byte[] byArray, int n10, int n11, boolean bl2) {
        try {
            return extractorInput.peekFully(byArray, n10, n11, bl2);
        }
        catch (EOFException eOFException) {
            if (bl2) {
                return false;
            }
            throw eOFException;
        }
    }

    public boolean populate(ExtractorInput object, boolean bl2) {
        long l10;
        long l11;
        long l12;
        this.reset();
        Object object2 = this.scratch;
        int n10 = 27;
        ((ParsableByteArray)object2).reset(n10);
        object2 = this.scratch.getData();
        int n11 = OggPageHeader.peekSafely((ExtractorInput)object, (byte[])object2, 0, n10, bl2);
        if (n11 != 0 && (n11 = (l12 = (l11 = ((ParsableByteArray)(object2 = this.scratch)).readUnsignedInt()) - (l10 = 1332176723L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == 0) {
            int n12;
            int n13;
            int n14;
            object2 = this.scratch;
            this.revision = n11 = ((ParsableByteArray)object2).readUnsignedByte();
            if (n11 != 0) {
                if (bl2) {
                    return false;
                }
                object = new ParserException("unsupported bit stream revision");
                throw object;
            }
            this.type = n14 = this.scratch.readUnsignedByte();
            this.granulePosition = l11 = this.scratch.readLittleEndianLong();
            this.streamSerialNumber = l11 = this.scratch.readLittleEndianUnsignedInt();
            this.pageSequenceNumber = l11 = this.scratch.readLittleEndianUnsignedInt();
            this.pageChecksum = l11 = this.scratch.readLittleEndianUnsignedInt();
            this.pageSegmentCount = n13 = this.scratch.readUnsignedByte();
            this.headerSize = n11 = n13 + 27;
            object2 = this.scratch;
            ((ParsableByteArray)object2).reset(n13);
            Object[] objectArray = this.scratch.getData();
            n11 = this.pageSegmentCount;
            object.peekFully((byte[])objectArray, 0, n11);
            for (int i10 = 0; i10 < (n12 = this.pageSegmentCount); ++i10) {
                object = this.laces;
                int n15 = this.scratch.readUnsignedByte();
                object[i10] = n15;
                n12 = this.bodySize;
                objectArray = this.laces;
                n15 = objectArray[i10];
                this.bodySize = n12 += n15;
            }
            return true;
        }
        return false;
    }

    public void reset() {
        long l10;
        this.revision = 0;
        this.type = 0;
        this.granulePosition = l10 = 0L;
        this.streamSerialNumber = l10;
        this.pageSequenceNumber = l10;
        this.pageChecksum = l10;
        this.pageSegmentCount = 0;
        this.headerSize = 0;
        this.bodySize = 0;
    }

    public boolean skipToNextPage(ExtractorInput extractorInput) {
        return this.skipToNextPage(extractorInput, -1);
    }

    public boolean skipToNextPage(ExtractorInput extractorInput, long l10) {
        long l11;
        long l12;
        Object object;
        ParsableByteArray parsableByteArray;
        long l13 = extractorInput.getPosition();
        long l14 = extractorInput.getPeekPosition();
        long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        boolean bl2 = true;
        if (l15 == false) {
            l15 = (long)bl2;
        } else {
            l15 = 0;
            parsableByteArray = null;
        }
        Assertions.checkArgument((boolean)l15);
        parsableByteArray = this.scratch;
        int n10 = 4;
        parsableByteArray.reset(n10);
        while (true) {
            byte[] byArray;
            long l16;
            long l17;
            long l18;
            if ((l15 = (l18 = l10 - (l17 = (long)-1)) == 0L ? 0 : (l18 < 0L ? -1 : 1)) != false) {
                l17 = extractorInput.getPosition();
                l16 = 4;
                long l19 = (l17 += l16) - l10;
                object = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                if (object >= 0) break;
            }
            if ((object = OggPageHeader.peekSafely(extractorInput, byArray = this.scratch.getData(), 0, n10, bl2)) == 0) break;
            this.scratch.setPosition(0);
            parsableByteArray = this.scratch;
            l17 = parsableByteArray.readUnsignedInt();
            l16 = 1332176723L;
            l15 = l17 == l16 ? 0 : (l17 < l16 ? -1 : 1);
            if (l15 == false) {
                extractorInput.resetPeekPosition();
                return bl2;
            }
            extractorInput.skipFully((int)(bl2 ? 1 : 0));
        }
        while ((l15 == false || (n10 = (int)((l12 = (l11 = extractorInput.getPosition()) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1))) < 0) && (n10 = extractorInput.skip((int)(bl2 ? 1 : 0))) != (object = -1)) {
        }
        return false;
    }
}

