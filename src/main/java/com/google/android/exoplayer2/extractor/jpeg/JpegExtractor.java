/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.jpeg.MotionPhotoDescription;
import com.google.android.exoplayer2.extractor.jpeg.StartOffsetExtractorInput;
import com.google.android.exoplayer2.extractor.jpeg.StartOffsetExtractorOutput;
import com.google.android.exoplayer2.extractor.jpeg.XmpMotionPhotoDescriptionParser;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class JpegExtractor
implements Extractor {
    private static final long EXIF_HEADER = 1165519206L;
    private static final String HEADER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/";
    private static final int IMAGE_TRACK_ID = 1024;
    private static final int JPEG_EXIF_HEADER_LENGTH = 12;
    private static final int MARKER_APP1 = 65505;
    private static final int MARKER_SOI = 65496;
    private static final int MARKER_SOS = 65498;
    private static final int STATE_ENDED = 6;
    private static final int STATE_READING_MARKER = 0;
    private static final int STATE_READING_MOTION_PHOTO_VIDEO = 5;
    private static final int STATE_READING_SEGMENT = 2;
    private static final int STATE_READING_SEGMENT_LENGTH = 1;
    private static final int STATE_SNIFFING_MOTION_PHOTO_VIDEO = 4;
    private ExtractorOutput extractorOutput;
    private ExtractorInput lastExtractorInput;
    private int marker;
    private MotionPhotoMetadata motionPhotoMetadata;
    private Mp4Extractor mp4Extractor;
    private StartOffsetExtractorInput mp4ExtractorStartOffsetExtractorInput;
    private long mp4StartPosition;
    private final ParsableByteArray scratch;
    private int segmentLength;
    private int state;

    public JpegExtractor() {
        ParsableByteArray parsableByteArray;
        this.scratch = parsableByteArray = new ParsableByteArray(12);
        this.mp4StartPosition = -1;
    }

    private void endReadingWithImageTrack() {
        Object object = new Metadata$Entry[]{};
        this.outputImageTrack((Metadata$Entry[])object);
        ((ExtractorOutput)Assertions.checkNotNull(this.extractorOutput)).endTracks();
        object = this.extractorOutput;
        SeekMap$Unseekable seekMap$Unseekable = new SeekMap$Unseekable(-9223372036854775807L);
        object.seekMap(seekMap$Unseekable);
        this.state = 6;
    }

    private static MotionPhotoMetadata getMotionPhotoMetadata(String object, long l10) {
        long l11 = -1;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            return null;
        }
        if ((object = XmpMotionPhotoDescriptionParser.parse((String)object)) == null) {
            return null;
        }
        return ((MotionPhotoDescription)object).getMotionPhotoMetadata(l10);
    }

    private void outputImageTrack(Metadata$Entry ... object) {
        TrackOutput trackOutput = ((ExtractorOutput)Assertions.checkNotNull(this.extractorOutput)).track(1024, 4);
        Format$Builder format$Builder = new Format$Builder();
        Metadata metadata = new Metadata((Metadata$Entry)object);
        object = format$Builder.setMetadata(metadata).build();
        trackOutput.format((Format)object);
    }

    private void readMarker(ExtractorInput object) {
        int n10;
        Object object2 = this.scratch;
        int n11 = 2;
        ((ParsableByteArray)object2).reset(n11);
        object2 = this.scratch.getData();
        object.readFully((byte[])object2, 0, n11);
        object = this.scratch;
        this.marker = n10 = ((ParsableByteArray)object).readUnsignedShort();
        int n12 = -38;
        if (n10 == n12) {
            long l10 = this.mp4StartPosition;
            long l11 = -1;
            long l12 = l10 - l11;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 != 0) {
                this.state = n10 = 4;
            } else {
                this.endReadingWithImageTrack();
            }
        } else {
            n12 = (char)-48;
            if ((n10 < n12 || n10 > (n12 = (int)((char)-39))) && n10 != (n12 = 65281)) {
                this.state = n10 = 1;
            }
        }
    }

    private void readSegment(ExtractorInput object) {
        int n10 = this.marker;
        int n11 = -31;
        if (n10 == n11) {
            String string2;
            n11 = this.segmentLength;
            Object object2 = new ParsableByteArray(n11);
            Object object3 = ((ParsableByteArray)object2).getData();
            int n12 = this.segmentLength;
            object.readFully((byte[])object3, 0, n12);
            object3 = this.motionPhotoMetadata;
            if (object3 == null && (n11 = (int)((string2 = HEADER_XMP_APP1).equals(object3 = (Object)((ParsableByteArray)object2).readNullTerminatedString()) ? 1 : 0)) != 0 && (object2 = ((ParsableByteArray)object2).readNullTerminatedString()) != null) {
                long l10 = object.getLength();
                this.motionPhotoMetadata = object = JpegExtractor.getMotionPhotoMetadata((String)object2, l10);
                if (object != null) {
                    this.mp4StartPosition = l10 = ((MotionPhotoMetadata)object).videoStartPosition;
                }
            }
        } else {
            n10 = this.segmentLength;
            object.skipFully(n10);
        }
        this.state = 0;
    }

    private void readSegmentLength(ExtractorInput extractorInput) {
        int n10;
        Object object = this.scratch;
        int n11 = 2;
        ((ParsableByteArray)object).reset(n11);
        object = this.scratch.getData();
        extractorInput.readFully((byte[])object, 0, n11);
        this.segmentLength = n10 = this.scratch.readUnsignedShort() - n11;
        this.state = n11;
    }

    private void sniffMotionPhotoVideo(ExtractorInput object) {
        boolean bl2;
        Object object2 = this.scratch.getData();
        boolean bl3 = object.peekFully((byte[])object2, 0, (int)((bl2 = true) ? 1 : 0), bl2);
        if (!bl3) {
            this.endReadingWithImageTrack();
        } else {
            object.resetPeekPosition();
            object2 = this.mp4Extractor;
            if (object2 == null) {
                object2 = new Mp4Extractor;
                object2();
                this.mp4Extractor = object2;
            }
            object2 = new StartOffsetExtractorInput;
            long l10 = this.mp4StartPosition;
            object2((ExtractorInput)object, l10);
            this.mp4ExtractorStartOffsetExtractorInput = object2;
            object = this.mp4Extractor;
            boolean bl4 = ((Mp4Extractor)object).sniff((ExtractorInput)object2);
            if (bl4) {
                object = this.mp4Extractor;
                object2 = new StartOffsetExtractorOutput;
                l10 = this.mp4StartPosition;
                ExtractorOutput extractorOutput = (ExtractorOutput)Assertions.checkNotNull(this.extractorOutput);
                object2(l10, extractorOutput);
                ((Mp4Extractor)object).init((ExtractorOutput)object2);
                this.startReadingMotionPhoto();
            } else {
                this.endReadingWithImageTrack();
            }
        }
    }

    private void startReadingMotionPhoto() {
        Metadata$Entry metadata$Entry = (Metadata$Entry)Assertions.checkNotNull(this.motionPhotoMetadata);
        Metadata$Entry[] metadata$EntryArray = new Metadata$Entry[]{metadata$Entry};
        this.outputImageTrack(metadata$EntryArray);
        this.state = 5;
    }

    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    public int read(ExtractorInput object, PositionHolder positionHolder) {
        int n10 = this.state;
        int n11 = 0;
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                int n13 = 2;
                if (n10 != n13) {
                    long l10;
                    n13 = 4;
                    if (n10 != n13) {
                        int n14;
                        n11 = 5;
                        if (n10 != n11) {
                            int n15 = 6;
                            if (n10 == n15) {
                                return -1;
                            }
                            object = new IllegalStateException();
                            throw object;
                        }
                        ExtractorInput extractorInput = this.mp4ExtractorStartOffsetExtractorInput;
                        if (extractorInput == null || object != (extractorInput = this.lastExtractorInput)) {
                            this.lastExtractorInput = object;
                            long l11 = this.mp4StartPosition;
                            this.mp4ExtractorStartOffsetExtractorInput = extractorInput = new StartOffsetExtractorInput((ExtractorInput)object, l11);
                        }
                        if ((n14 = ((Mp4Extractor)(object = (Mp4Extractor)Assertions.checkNotNull(this.mp4Extractor))).read(extractorInput = this.mp4ExtractorStartOffsetExtractorInput, positionHolder)) == n12) {
                            long l12 = positionHolder.position;
                            long l13 = this.mp4StartPosition;
                            positionHolder.position = l12 += l13;
                        }
                        return n14;
                    }
                    long l14 = object.getPosition();
                    long l15 = l14 - (l10 = this.mp4StartPosition);
                    n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
                    if (n10 != 0) {
                        positionHolder.position = l10;
                        return n12;
                    }
                    this.sniffMotionPhotoVideo((ExtractorInput)object);
                    return 0;
                }
                this.readSegment((ExtractorInput)object);
                return 0;
            }
            this.readSegmentLength((ExtractorInput)object);
            return 0;
        }
        this.readMarker((ExtractorInput)object);
        return 0;
    }

    public void release() {
        Mp4Extractor mp4Extractor = this.mp4Extractor;
        if (mp4Extractor != null) {
            mp4Extractor.release();
        }
    }

    public void seek(long l10, long l11) {
        long l12 = 0L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            this.state = 0;
        } else {
            object = this.state;
            int n10 = 5;
            if (object == n10) {
                Mp4Extractor mp4Extractor = (Mp4Extractor)Assertions.checkNotNull(this.mp4Extractor);
                mp4Extractor.seek(l10, l11);
            }
        }
    }

    public boolean sniff(ExtractorInput object) {
        byte[] byArray = this.scratch.getData();
        boolean bl2 = false;
        int n10 = 12;
        object.peekFully(byArray, 0, n10);
        object = this.scratch;
        int n11 = ((ParsableByteArray)object).readUnsignedShort();
        int n12 = -40;
        if (n11 == n12 && (n11 = ((ParsableByteArray)(object = this.scratch)).readUnsignedShort()) == (n12 = (char)-31)) {
            object = this.scratch;
            n12 = 2;
            ((ParsableByteArray)object).skipBytes(n12);
            object = this.scratch;
            long l10 = ((ParsableByteArray)object).readUnsignedInt();
            long l11 = 1165519206L;
            n11 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
            if (n11 == 0 && (n11 = ((ParsableByteArray)(object = this.scratch)).readUnsignedShort()) == 0) {
                bl2 = true;
            }
        }
        return bl2;
    }
}

