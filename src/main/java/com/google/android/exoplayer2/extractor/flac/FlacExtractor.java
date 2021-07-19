/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.flac;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacFrameReader$SampleNumberHolder;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.extractor.FlacMetadataReader$FlacStreamMetadataHolder;
import com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.h0.c.a;

public final class FlacExtractor
implements Extractor {
    private static final int BUFFER_LENGTH = 32768;
    public static final ExtractorsFactory FACTORY = a.a;
    public static final int FLAG_DISABLE_ID3_METADATA = 1;
    private static final int SAMPLE_NUMBER_UNKNOWN = 255;
    private static final int STATE_GET_FRAME_START_MARKER = 4;
    private static final int STATE_GET_STREAM_MARKER_AND_INFO_BLOCK_BYTES = 1;
    private static final int STATE_READ_FRAMES = 5;
    private static final int STATE_READ_ID3_METADATA = 0;
    private static final int STATE_READ_METADATA_BLOCKS = 3;
    private static final int STATE_READ_STREAM_MARKER = 2;
    private FlacBinarySearchSeeker binarySearchSeeker;
    private final ParsableByteArray buffer;
    private int currentFrameBytesWritten;
    private long currentFrameFirstSampleNumber;
    private ExtractorOutput extractorOutput;
    private FlacStreamMetadata flacStreamMetadata;
    private int frameStartMarker;
    private Metadata id3Metadata;
    private final boolean id3MetadataDisabled;
    private int minFrameSize;
    private final FlacFrameReader$SampleNumberHolder sampleNumberHolder;
    private int state;
    private final byte[] streamMarkerAndInfoBlock;
    private TrackOutput trackOutput;

    public FlacExtractor() {
        this(0);
    }

    public FlacExtractor(int n10) {
        FlacFrameReader$SampleNumberHolder flacFrameReader$SampleNumberHolder;
        Object object = new byte[42];
        this.streamMarkerAndInfoBlock = object;
        object = new ParsableByteArray;
        int n11 = 32768;
        byte[] byArray = new byte[n11];
        super(byArray, 0);
        this.buffer = object;
        int n12 = 1;
        if ((n10 &= n12) == 0) {
            n12 = 0;
            object = null;
        }
        this.id3MetadataDisabled = n12;
        this.sampleNumberHolder = flacFrameReader$SampleNumberHolder = new FlacFrameReader$SampleNumberHolder();
        this.state = 0;
    }

    public static /* synthetic */ Extractor[] a() {
        Extractor[] extractorArray = new Extractor[1];
        FlacExtractor flacExtractor = new FlacExtractor();
        extractorArray[0] = flacExtractor;
        return extractorArray;
    }

    private long findFrame(ParsableByteArray parsableByteArray, boolean n10) {
        FlacFrameReader$SampleNumberHolder flacFrameReader$SampleNumberHolder;
        int n11;
        FlacStreamMetadata flacStreamMetadata;
        int n12;
        int n13;
        FlacStreamMetadata flacStreamMetadata2 = this.flacStreamMetadata;
        Assertions.checkNotNull(flacStreamMetadata2);
        for (n13 = parsableByteArray.getPosition(); n13 <= (n12 = parsableByteArray.limit() + -16); ++n13) {
            parsableByteArray.setPosition(n13);
            flacStreamMetadata = this.flacStreamMetadata;
            n11 = this.frameStartMarker;
            flacFrameReader$SampleNumberHolder = this.sampleNumberHolder;
            n12 = (int)(FlacFrameReader.checkAndReadFrameHeader(parsableByteArray, flacStreamMetadata, n11, flacFrameReader$SampleNumberHolder) ? 1 : 0);
            if (n12 == 0) continue;
            parsableByteArray.setPosition(n13);
            return this.sampleNumberHolder.sampleNumber;
        }
        if (n10 != 0) {
            while (true) {
                n10 = parsableByteArray.limit();
                n12 = this.minFrameSize;
                if (n13 > (n10 -= n12)) break;
                parsableByteArray.setPosition(n13);
                n10 = 0;
                flacStreamMetadata = this.flacStreamMetadata;
                n11 = this.frameStartMarker;
                flacFrameReader$SampleNumberHolder = this.sampleNumberHolder;
                try {
                    n12 = (int)(FlacFrameReader.checkAndReadFrameHeader(parsableByteArray, flacStreamMetadata, n11, flacFrameReader$SampleNumberHolder) ? 1 : 0);
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    n12 = 0;
                    flacStreamMetadata = null;
                }
                n11 = parsableByteArray.getPosition();
                int n14 = parsableByteArray.limit();
                if (n11 <= n14) {
                    n10 = n12;
                }
                if (n10 != 0) {
                    parsableByteArray.setPosition(n13);
                    return this.sampleNumberHolder.sampleNumber;
                }
                ++n13;
            }
            n10 = parsableByteArray.limit();
            parsableByteArray.setPosition(n10);
        } else {
            parsableByteArray.setPosition(n13);
        }
        return -1;
    }

    private void getFrameStartMarker(ExtractorInput object) {
        int n10;
        this.frameStartMarker = n10 = FlacMetadataReader.getFrameStartMarker((ExtractorInput)object);
        ExtractorOutput extractorOutput = (ExtractorOutput)Util.castNonNull(this.extractorOutput);
        long l10 = object.getPosition();
        long l11 = object.getLength();
        object = this.getSeekMap(l10, l11);
        extractorOutput.seekMap((SeekMap)object);
        this.state = 5;
    }

    private SeekMap getSeekMap(long l10, long l11) {
        long l12;
        long l13;
        Assertions.checkNotNull(this.flacStreamMetadata);
        FlacStreamMetadata flacStreamMetadata = this.flacStreamMetadata;
        Object object = flacStreamMetadata.seekTable;
        if (object != null) {
            FlacSeekTableSeekMap flacSeekTableSeekMap = new FlacSeekTableSeekMap(flacStreamMetadata, l10);
            return flacSeekTableSeekMap;
        }
        long l14 = -1;
        long l15 = l11 - l14;
        Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object2 != false && (object2 = (l13 = (l14 = flacStreamMetadata.totalSamples) - (l12 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) > 0) {
            int n10 = this.frameStartMarker;
            this.binarySearchSeeker = object = new FlacBinarySearchSeeker(flacStreamMetadata, n10, l10, l11);
            return ((BinarySearchSeeker)object).getSeekMap();
        }
        long l16 = flacStreamMetadata.getDurationUs();
        SeekMap$Unseekable seekMap$Unseekable = new SeekMap$Unseekable(l16);
        return seekMap$Unseekable;
    }

    private void getStreamMarkerAndInfoBlockBytes(ExtractorInput extractorInput) {
        byte[] byArray = this.streamMarkerAndInfoBlock;
        int n10 = byArray.length;
        extractorInput.peekFully(byArray, 0, n10);
        extractorInput.resetPeekPosition();
        this.state = 2;
    }

    private void outputSampleMetadata() {
        Object object;
        long l10 = this.currentFrameFirstSampleNumber * 1000000L;
        long l11 = ((FlacStreamMetadata)Util.castNonNull((Object)this.flacStreamMetadata)).sampleRate;
        long l12 = l10 / l11;
        Object object2 = object = Util.castNonNull(this.trackOutput);
        object2 = (TrackOutput)object;
        int n10 = this.currentFrameBytesWritten;
        object2.sampleMetadata(l12, 1, n10, 0, null);
    }

    private int readFrames(ExtractorInput object, PositionHolder object2) {
        ParsableByteArray parsableByteArray;
        boolean bl2;
        int n10;
        int n11;
        boolean bl3;
        Assertions.checkNotNull(this.trackOutput);
        Assertions.checkNotNull(this.flacStreamMetadata);
        FlacBinarySearchSeeker flacBinarySearchSeeker = this.binarySearchSeeker;
        if (flacBinarySearchSeeker != null && (bl3 = flacBinarySearchSeeker.isSeeking())) {
            return this.binarySearchSeeker.handlePendingSeek((ExtractorInput)object, (PositionHolder)object2);
        }
        long l10 = this.currentFrameFirstSampleNumber;
        long l11 = -1;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        bl3 = false;
        flacBinarySearchSeeker = null;
        if (l12 == false) {
            long l13;
            object2 = this.flacStreamMetadata;
            this.currentFrameFirstSampleNumber = l13 = FlacFrameReader.getFirstSampleNumber((ExtractorInput)object, (FlacStreamMetadata)object2);
            return 0;
        }
        object2 = this.buffer;
        l12 = ((ParsableByteArray)object2).limit();
        if (l12 < (n11 = 32768)) {
            byte[] byArray = this.buffer.getData();
            n11 -= l12;
            n10 = object.read(byArray, (int)l12, n11);
            if (n10 == (n11 = -1)) {
                bl2 = true;
            } else {
                bl2 = false;
                byArray = null;
            }
            if (!bl2) {
                parsableByteArray = this.buffer;
                parsableByteArray.setLimit((int)(l12 += n10));
            } else {
                object = this.buffer;
                n10 = ((ParsableByteArray)object).bytesLeft();
                if (n10 == 0) {
                    this.outputSampleMetadata();
                    return n11;
                }
            }
        } else {
            bl2 = false;
            Object var13_11 = null;
        }
        object = this.buffer;
        n10 = ((ParsableByteArray)object).getPosition();
        l12 = this.currentFrameBytesWritten;
        n11 = this.minFrameSize;
        if (l12 < n11) {
            ParsableByteArray parsableByteArray2 = this.buffer;
            n11 -= l12;
            l12 = parsableByteArray2.bytesLeft();
            l12 = Math.min(n11, (int)l12);
            parsableByteArray2.skipBytes((int)l12);
        }
        object2 = this.buffer;
        long l14 = this.findFrame((ParsableByteArray)object2, bl2);
        object2 = this.buffer;
        l12 = ((ParsableByteArray)object2).getPosition() - n10;
        this.buffer.setPosition(n10);
        object = this.trackOutput;
        parsableByteArray = this.buffer;
        object.sampleData(parsableByteArray, (int)l12);
        this.currentFrameBytesWritten = n10 = this.currentFrameBytesWritten + l12;
        n10 = (int)(l14 == l11 ? 0 : (l14 < l11 ? -1 : 1));
        if (n10 != 0) {
            this.outputSampleMetadata();
            this.currentFrameBytesWritten = 0;
            this.currentFrameFirstSampleNumber = l14;
        }
        if ((n10 = ((ParsableByteArray)(object = this.buffer)).bytesLeft()) < (l12 = (long)16)) {
            object = this.buffer;
            n10 = ((ParsableByteArray)object).bytesLeft();
            object2 = this.buffer.getData();
            parsableByteArray = this.buffer;
            n11 = parsableByteArray.getPosition();
            byte[] byArray = this.buffer.getData();
            System.arraycopy(object2, n11, byArray, 0, n10);
            this.buffer.setPosition(0);
            object2 = this.buffer;
            ((ParsableByteArray)object2).setLimit(n10);
        }
        return 0;
    }

    private void readId3Metadata(ExtractorInput object) {
        boolean bl2 = this.id3MetadataDisabled;
        int n10 = 1;
        this.id3Metadata = object = FlacMetadataReader.readId3Metadata((ExtractorInput)object, bl2 ^= n10);
        this.state = n10;
    }

    private void readMetadataBlocks(ExtractorInput object) {
        int n10;
        Object object2;
        Object object3 = this.flacStreamMetadata;
        Object object4 = new FlacMetadataReader$FlacStreamMetadataHolder((FlacStreamMetadata)object3);
        boolean bl2 = false;
        object3 = null;
        while (!bl2) {
            bl2 = FlacMetadataReader.readMetadataBlock((ExtractorInput)object, (FlacMetadataReader$FlacStreamMetadataHolder)object4);
            object2 = (FlacStreamMetadata)Util.castNonNull(((FlacMetadataReader$FlacStreamMetadataHolder)object4).flacStreamMetadata);
            this.flacStreamMetadata = object2;
        }
        Assertions.checkNotNull(this.flacStreamMetadata);
        this.minFrameSize = n10 = Math.max(this.flacStreamMetadata.minFrameSize, 6);
        object = (TrackOutput)Util.castNonNull(this.trackOutput);
        object4 = this.flacStreamMetadata;
        object3 = this.streamMarkerAndInfoBlock;
        object2 = this.id3Metadata;
        object4 = ((FlacStreamMetadata)object4).getFormat((byte[])object3, (Metadata)object2);
        object.format((Format)object4);
        this.state = 4;
    }

    private void readStreamMarker(ExtractorInput extractorInput) {
        FlacMetadataReader.readStreamMarker(extractorInput);
        this.state = 3;
    }

    public void init(ExtractorOutput extractorOutput) {
        TrackOutput trackOutput;
        this.extractorOutput = extractorOutput;
        this.trackOutput = trackOutput = extractorOutput.track(0, 1);
        extractorOutput.endTracks();
    }

    public int read(ExtractorInput object, PositionHolder positionHolder) {
        int n10 = this.state;
        int n11 = 0;
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    n12 = 3;
                    if (n10 != n12) {
                        n12 = 4;
                        if (n10 != n12) {
                            n11 = 5;
                            if (n10 == n11) {
                                return this.readFrames((ExtractorInput)object, positionHolder);
                            }
                            object = new IllegalStateException();
                            throw object;
                        }
                        this.getFrameStartMarker((ExtractorInput)object);
                        return 0;
                    }
                    this.readMetadataBlocks((ExtractorInput)object);
                    return 0;
                }
                this.readStreamMarker((ExtractorInput)object);
                return 0;
            }
            this.getStreamMarkerAndInfoBlockBytes((ExtractorInput)object);
            return 0;
        }
        this.readId3Metadata((ExtractorInput)object);
        return 0;
    }

    public void release() {
    }

    public void seek(long l10, long l11) {
        long l12 = 0L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            this.state = 0;
        } else {
            FlacBinarySearchSeeker flacBinarySearchSeeker = this.binarySearchSeeker;
            if (flacBinarySearchSeeker != null) {
                flacBinarySearchSeeker.setSeekTargetUs(l11);
            }
        }
        object = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (object != false) {
            l12 = -1;
        }
        this.currentFrameFirstSampleNumber = l12;
        this.currentFrameBytesWritten = 0;
        this.buffer.reset(0);
    }

    public boolean sniff(ExtractorInput extractorInput) {
        FlacMetadataReader.peekId3Metadata(extractorInput, false);
        return FlacMetadataReader.checkAndPeekStreamMarker(extractorInput);
    }
}

