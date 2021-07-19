/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.FlacMetadataReader$FlacStreamMetadataHolder;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata$SeekTable;
import com.google.android.exoplayer2.extractor.Id3Peeker;
import com.google.android.exoplayer2.extractor.VorbisUtil;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder$FramePredicate;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.base.Charsets;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class FlacMetadataReader {
    private static final int SEEK_POINT_SIZE = 18;
    private static final int STREAM_MARKER = 1716281667;
    private static final int SYNC_CODE = 16382;

    private FlacMetadataReader() {
    }

    public static boolean checkAndPeekStreamMarker(ExtractorInput extractorInput) {
        int n10 = 4;
        ParsableByteArray parsableByteArray = new ParsableByteArray(n10);
        byte[] byArray = parsableByteArray.getData();
        boolean bl2 = false;
        extractorInput.peekFully(byArray, 0, n10);
        long l10 = parsableByteArray.readUnsignedInt();
        long l11 = 1716281667L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            bl2 = true;
        }
        return bl2;
    }

    public static int getFrameStartMarker(ExtractorInput object) {
        object.resetPeekPosition();
        int n10 = 2;
        ParsableByteArray parsableByteArray = new ParsableByteArray(n10);
        byte[] byArray = parsableByteArray.getData();
        object.peekFully(byArray, 0, n10);
        int n11 = parsableByteArray.readUnsignedShort();
        n10 = n11 >> 2;
        int n12 = 16382;
        if (n10 == n12) {
            object.resetPeekPosition();
            return n11;
        }
        object.resetPeekPosition();
        object = new ParserException("First frame does not start with sync code.");
        throw object;
    }

    public static Metadata peekId3Metadata(ExtractorInput object, boolean bl2) {
        Id3Decoder.FramePredicate framePredicate;
        Object object2 = null;
        if (bl2) {
            bl2 = false;
            framePredicate = null;
        } else {
            framePredicate = Id3Decoder.NO_FRAMES_PREDICATE;
        }
        Id3Peeker id3Peeker = new Id3Peeker();
        object = id3Peeker.peekId3Data((ExtractorInput)object, framePredicate);
        if (object != null && (bl2 = ((Metadata)object).length())) {
            object2 = object;
        }
        return object2;
    }

    public static Metadata readId3Metadata(ExtractorInput extractorInput, boolean bl2) {
        extractorInput.resetPeekPosition();
        long l10 = extractorInput.getPeekPosition();
        Metadata metadata = FlacMetadataReader.peekId3Metadata(extractorInput, bl2);
        int n10 = (int)(extractorInput.getPeekPosition() - l10);
        extractorInput.skipFully(n10);
        return metadata;
    }

    public static boolean readMetadataBlock(ExtractorInput object, FlacMetadataReader$FlacStreamMetadataHolder flacMetadataReader$FlacStreamMetadataHolder) {
        block11: {
            boolean bl2;
            block10: {
                int n10;
                int n11;
                int n12;
                block9: {
                    object.resetPeekPosition();
                    n12 = 4;
                    byte[] byArray = new byte[n12];
                    ParsableBitArray parsableBitArray = new ParsableBitArray(byArray);
                    byArray = parsableBitArray.data;
                    object.peekFully(byArray, 0, n12);
                    bl2 = parsableBitArray.readBit();
                    n11 = parsableBitArray.readBits(7);
                    int n13 = 24;
                    n10 = parsableBitArray.readBits(n13) + n12;
                    if (n11 != 0) break block9;
                    flacMetadataReader$FlacStreamMetadataHolder.flacStreamMetadata = object = FlacMetadataReader.readStreamInfoBlock((ExtractorInput)object);
                    break block10;
                }
                FlacStreamMetadata flacStreamMetadata = flacMetadataReader$FlacStreamMetadataHolder.flacStreamMetadata;
                if (flacStreamMetadata == null) break block11;
                int n14 = 3;
                if (n11 == n14) {
                    object = FlacMetadataReader.readSeekTableMetadataBlock((ExtractorInput)object, n10);
                    flacMetadataReader$FlacStreamMetadataHolder.flacStreamMetadata = object = flacStreamMetadata.copyWithSeekTable((FlacStreamMetadata$SeekTable)object);
                } else if (n11 == n12) {
                    object = FlacMetadataReader.readVorbisCommentMetadataBlock((ExtractorInput)object, n10);
                    flacMetadataReader$FlacStreamMetadataHolder.flacStreamMetadata = object = flacStreamMetadata.copyWithVorbisComments((List)object);
                } else {
                    n12 = 6;
                    if (n11 == n12) {
                        object = Collections.singletonList(FlacMetadataReader.readPictureMetadataBlock((ExtractorInput)object, n10));
                        flacMetadataReader$FlacStreamMetadataHolder.flacStreamMetadata = object = flacStreamMetadata.copyWithPictureFrames((List)object);
                    } else {
                        object.skipFully(n10);
                    }
                }
            }
            return bl2;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    private static PictureFrame readPictureMetadataBlock(ExtractorInput object, int n10) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(n10);
        byte[] byArray = parsableByteArray.getData();
        object.readFully(byArray, 0, n10);
        parsableByteArray.skipBytes(4);
        int n11 = parsableByteArray.readInt();
        int n12 = parsableByteArray.readInt();
        Charset charset = Charsets.US_ASCII;
        String string2 = parsableByteArray.readString(n12, charset);
        n12 = parsableByteArray.readInt();
        String string3 = parsableByteArray.readString(n12);
        int n13 = parsableByteArray.readInt();
        int n14 = parsableByteArray.readInt();
        int n15 = parsableByteArray.readInt();
        int n16 = parsableByteArray.readInt();
        n12 = parsableByteArray.readInt();
        byte[] byArray2 = new byte[n12];
        parsableByteArray.readBytes(byArray2, 0, n12);
        object = new PictureFrame(n11, string2, string3, n13, n14, n15, n16, byArray2);
        return object;
    }

    private static FlacStreamMetadata$SeekTable readSeekTableMetadataBlock(ExtractorInput extractorInput, int n10) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(n10);
        byte[] byArray = parsableByteArray.getData();
        extractorInput.readFully(byArray, 0, n10);
        return FlacMetadataReader.readSeekTableMetadataBlock(parsableByteArray);
    }

    public static FlacStreamMetadata$SeekTable readSeekTableMetadataBlock(ParsableByteArray object) {
        ((ParsableByteArray)object).skipBytes(1);
        int n10 = ((ParsableByteArray)object).readUnsignedInt24();
        int n11 = ((ParsableByteArray)object).getPosition();
        long l10 = n11;
        long l11 = n10;
        l10 += l11;
        long[] lArray = new long[n10 /= 18];
        long[] lArray2 = new long[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            long l12;
            long l13 = ((ParsableByteArray)object).readLong();
            long l14 = l13 - (l12 = (long)-1);
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 == false) {
                lArray = Arrays.copyOf(lArray, i10);
                lArray2 = Arrays.copyOf(lArray2, i10);
                break;
            }
            lArray[i10] = l13;
            lArray2[i10] = l13 = ((ParsableByteArray)object).readLong();
            int n12 = 2;
            ((ParsableByteArray)object).skipBytes(n12);
        }
        long l15 = ((ParsableByteArray)object).getPosition();
        n10 = (int)(l10 - l15);
        ((ParsableByteArray)object).skipBytes(n10);
        object = new FlacStreamMetadata$SeekTable(lArray, lArray2);
        return object;
    }

    private static FlacStreamMetadata readStreamInfoBlock(ExtractorInput object) {
        int n10 = 38;
        byte[] byArray = new byte[n10];
        object.readFully(byArray, 0, n10);
        object = new FlacStreamMetadata(byArray, 4);
        return object;
    }

    public static void readStreamMarker(ExtractorInput object) {
        int n10 = 4;
        ParsableByteArray parsableByteArray = new ParsableByteArray(n10);
        byte[] byArray = parsableByteArray.getData();
        object.readFully(byArray, 0, n10);
        long l10 = parsableByteArray.readUnsignedInt();
        long l11 = 1716281667L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            return;
        }
        object = new ParserException("Failed to read FLAC stream marker.");
        throw object;
    }

    private static List readVorbisCommentMetadataBlock(ExtractorInput extractorInput, int n10) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(n10);
        byte[] byArray = parsableByteArray.getData();
        extractorInput.readFully(byArray, 0, n10);
        parsableByteArray.skipBytes(4);
        return Arrays.asList(VorbisUtil.readVorbisCommentHeader((ParsableByteArray)parsableByteArray, (boolean)false, (boolean)false).comments);
    }
}

