/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata$SeekTable;
import com.google.android.exoplayer2.extractor.ogg.FlacReader$FlacOggSeeker;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.extractor.ogg.StreamReader$SetupData;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

public final class FlacReader
extends StreamReader {
    private static final byte AUDIO_PACKET_TYPE = -1;
    private static final int FRAME_HEADER_SAMPLE_NUMBER_OFFSET = 4;
    private FlacReader$FlacOggSeeker flacOggSeeker;
    private FlacStreamMetadata streamMetadata;

    private int getFlacFrameBlockSize(ParsableByteArray parsableByteArray) {
        byte[] byArray = parsableByteArray.getData();
        int n10 = byArray[2] & 0xFF;
        int n11 = 4;
        int n12 = 6;
        if ((n10 >>= n11) == n12 || n10 == (n12 = 7)) {
            parsableByteArray.skipBytes(n11);
            parsableByteArray.readUtf8EncodedLong();
        }
        n10 = FlacFrameReader.readFrameBlockSizeSamplesFromKey(parsableByteArray, n10);
        parsableByteArray.setPosition(0);
        return n10;
    }

    private static boolean isAudioPacket(byte[] byArray) {
        boolean bl2 = false;
        byte by2 = byArray[0];
        byte by3 = -1;
        if (by2 == by3) {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        long l10;
        long l11;
        long l12;
        boolean bl2;
        int n10;
        int n11 = parsableByteArray.bytesLeft();
        if (n11 >= (n10 = 5) && (n11 = parsableByteArray.readUnsignedByte()) == (n10 = 127) && !(bl2 = (l12 = (l11 = parsableByteArray.readUnsignedInt()) - (l10 = 1179402563L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            bl2 = true;
        } else {
            bl2 = false;
            parsableByteArray = null;
        }
        return bl2;
    }

    public long preparePayload(ParsableByteArray parsableByteArray) {
        byte[] byArray = parsableByteArray.getData();
        boolean bl2 = FlacReader.isAudioPacket(byArray);
        if (!bl2) {
            return -1;
        }
        return this.getFlacFrameBlockSize(parsableByteArray);
    }

    public boolean readHeaders(ParsableByteArray object, long l10, StreamReader$SetupData streamReader$SetupData) {
        byte[] byArray = ((ParsableByteArray)object).getData();
        FlacStreamMetadata flacStreamMetadata = this.streamMetadata;
        boolean bl2 = true;
        if (flacStreamMetadata == null) {
            FlacStreamMetadata flacStreamMetadata2;
            this.streamMetadata = flacStreamMetadata2 = new FlacStreamMetadata(byArray, 17);
            int n10 = ((ParsableByteArray)object).limit();
            object = Arrays.copyOfRange(byArray, 9, n10);
            streamReader$SetupData.format = object = flacStreamMetadata2.getFormat((byte[])object, null);
            return bl2;
        }
        int n11 = byArray[0] & 0x7F;
        int n12 = 3;
        if (n11 == n12) {
            FlacReader$FlacOggSeeker flacReader$FlacOggSeeker;
            FlacStreamMetadata flacStreamMetadata3;
            object = FlacMetadataReader.readSeekTableMetadataBlock((ParsableByteArray)object);
            this.streamMetadata = flacStreamMetadata3 = flacStreamMetadata.copyWithSeekTable((FlacStreamMetadata$SeekTable)object);
            this.flacOggSeeker = flacReader$FlacOggSeeker = new FlacReader$FlacOggSeeker(flacStreamMetadata3, (FlacStreamMetadata$SeekTable)object);
            return bl2;
        }
        boolean bl3 = FlacReader.isAudioPacket(byArray);
        if (bl3) {
            object = this.flacOggSeeker;
            if (object != null) {
                ((FlacReader$FlacOggSeeker)object).setFirstFrameOffset(l10);
                streamReader$SetupData.oggSeeker = object = this.flacOggSeeker;
            }
            Assertions.checkNotNull(streamReader$SetupData.format);
            return false;
        }
        return bl2;
    }

    public void reset(boolean bl2) {
        super.reset(bl2);
        if (bl2) {
            bl2 = false;
            this.streamMetadata = null;
            this.flacOggSeeker = null;
        }
    }
}

