/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$SeekPoints;
import com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.mp4.Atom$ContainerAtom;
import com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom;
import com.google.android.exoplayer2.extractor.mp4.AtomParsers;
import com.google.android.exoplayer2.extractor.mp4.MetadataUtil;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor$Mp4Track;
import com.google.android.exoplayer2.extractor.mp4.SefReader;
import com.google.android.exoplayer2.extractor.mp4.Sniffer;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.extractor.mp4.TrackSampleTable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.h0.g.b;
import d.h.a.a.h0.g.c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public final class Mp4Extractor
implements Extractor,
SeekMap {
    public static final ExtractorsFactory FACTORY = c.a;
    private static final int FILE_TYPE_HEIC = 2;
    private static final int FILE_TYPE_MP4 = 0;
    private static final int FILE_TYPE_QUICKTIME = 1;
    public static final int FLAG_READ_MOTION_PHOTO_METADATA = 2;
    public static final int FLAG_READ_SEF_DATA = 4;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 1;
    private static final long MAXIMUM_READ_AHEAD_BYTES_STREAM = 0xA00000L;
    private static final long RELOAD_MINIMUM_SEEK_DISTANCE = 262144L;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private static final int STATE_READING_SEF = 3;
    private long[][] accumulatedSampleSizes;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private final ArrayDeque containerAtoms;
    private long durationUs;
    private ExtractorOutput extractorOutput;
    private int fileType;
    private int firstVideoTrackIndex;
    private final int flags;
    private MotionPhotoMetadata motionPhotoMetadata;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleTrackIndex;
    private final ParsableByteArray scratch;
    private final SefReader sefReader;
    private final List slowMotionMetadataEntries;
    private Mp4Extractor$Mp4Track[] tracks;

    public Mp4Extractor() {
        this(0);
    }

    public Mp4Extractor(int n10) {
        Object object;
        this.flags = n10;
        int n11 = 4;
        if ((n10 &= n11) != 0) {
            n10 = 3;
        } else {
            n10 = 0;
            object = null;
        }
        this.parserState = n10;
        object = new SefReader();
        this.sefReader = object;
        object = new ArrayList();
        this.slowMotionMetadataEntries = object;
        this.atomHeader = object = new ParsableByteArray(16);
        object = new ArrayDeque();
        this.containerAtoms = object;
        byte[] byArray = NalUnitUtil.NAL_START_CODE;
        this.nalStartCode = object = new ParsableByteArray(byArray);
        this.nalLength = object = new ParsableByteArray(n11);
        this.scratch = object = new ParsableByteArray();
        this.sampleTrackIndex = -1;
    }

    public static /* synthetic */ Track a(Track track) {
        return track;
    }

    public static /* synthetic */ Extractor[] b() {
        Extractor[] extractorArray = new Extractor[1];
        Mp4Extractor mp4Extractor = new Mp4Extractor();
        extractorArray[0] = mp4Extractor;
        return extractorArray;
    }

    private static int brandToFileType(int n10) {
        int n11 = 1751476579;
        if (n10 != n11) {
            n11 = 1903435808;
            if (n10 != n11) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    private static long[][] calculateAccumulatedSampleSizes(Mp4Extractor$Mp4Track[] mp4Extractor$Mp4TrackArray) {
        int n10;
        int n11;
        int n12 = mp4Extractor$Mp4TrackArray.length;
        long[][] lArrayArray = new long[n12][];
        int n13 = mp4Extractor$Mp4TrackArray.length;
        int[] nArray = new int[n13];
        int n14 = mp4Extractor$Mp4TrackArray.length;
        long[] lArray = new long[n14];
        int n15 = mp4Extractor$Mp4TrackArray.length;
        boolean[] blArray = new boolean[n15];
        for (int i10 = 0; i10 < (n11 = mp4Extractor$Mp4TrackArray.length); ++i10) {
            long l10;
            n11 = mp4Extractor$Mp4TrackArray[i10].sampleTable.sampleCount;
            long[] lArray2 = new long[n11];
            lArrayArray[i10] = lArray2;
            lArray2 = mp4Extractor$Mp4TrackArray[i10].sampleTable.timestampsUs;
            lArray[i10] = l10 = lArray2[0];
        }
        long l11 = 0L;
        int n16 = 0;
        while (n16 < (n10 = mp4Extractor$Mp4TrackArray.length)) {
            int n17;
            int n18;
            long l12 = Long.MAX_VALUE;
            int n19 = -1;
            long[] lArray3 = null;
            for (n18 = 0; n18 < (n17 = mp4Extractor$Mp4TrackArray.length); ++n18) {
                long l13;
                long l14;
                n17 = blArray[n18];
                if (n17 != 0 || (n17 = (int)((l14 = (l13 = lArray[n18]) - l12) == 0L ? 0 : (l14 < 0L ? -1 : 1))) > 0) continue;
                l12 = lArray[n18];
                n19 = n18;
            }
            n10 = nArray[n19];
            lArrayArray[n19][n10] = l11;
            Object[] objectArray = mp4Extractor$Mp4TrackArray[n19].sampleTable.sizes;
            long l15 = objectArray[n10];
            l11 += l15;
            int n20 = 1;
            nArray[n19] = n10 += n20;
            lArray3 = lArrayArray[n19];
            n18 = lArray3.length;
            if (n10 < n18) {
                objectArray = mp4Extractor$Mp4TrackArray[n19].sampleTable.timestampsUs;
                lArray[n19] = l12 = (long)objectArray[n10];
                continue;
            }
            blArray[n19] = n20;
            ++n16;
        }
        return lArrayArray;
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private static int getSynchronizationSampleIndex(TrackSampleTable trackSampleTable, long l10) {
        int n10;
        int n11 = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(l10);
        if (n11 == (n10 = -1)) {
            n11 = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(l10);
        }
        return n11;
    }

    private int getTrackIndexOfNextReadSample(long l10) {
        Object object;
        Object object2;
        int n10;
        int n11;
        Mp4Extractor mp4Extractor = this;
        int n12 = n11 = -1;
        long l11 = Long.MAX_VALUE;
        int n13 = 1;
        Object object3 = Long.MAX_VALUE;
        int n14 = 1;
        long l12 = Long.MAX_VALUE;
        for (int i10 = 0; i10 < (n10 = ((Mp4Extractor$Mp4Track[])(object2 = (Mp4Extractor$Mp4Track[])Util.castNonNull(mp4Extractor.tracks))).length); ++i10) {
            long l13;
            object2 = mp4Extractor.tracks[i10];
            Object object4 = object2.sampleIndex;
            object2 = object2.sampleTable;
            int n15 = object2.sampleCount;
            if (object4 == n15) continue;
            long l14 = object2.offsets[object4];
            object2 = ((long[][])Util.castNonNull(mp4Extractor.accumulatedSampleSizes))[i10];
            Mp4Extractor$Mp4Track mp4Extractor$Mp4Track = object2[object4];
            long l15 = 0L;
            long l16 = (l14 -= l10) - l15;
            n10 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
            if (n10 >= 0 && (n10 = (int)((l13 = l14 - (l15 = 262144L)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) < 0) {
                n10 = 0;
                object2 = null;
            } else {
                n10 = 1;
            }
            if (n10 == 0 && n14 != 0 || n10 == n14 && (object4 = (Object)(l14 == l12 ? 0 : (l14 < l12 ? -1 : 1))) < 0) {
                n14 = n10;
                l12 = l14;
                n12 = i10;
                object3 = mp4Extractor$Mp4Track;
            }
            if ((object4 = (Object)(mp4Extractor$Mp4Track == l11 ? 0 : (mp4Extractor$Mp4Track < l11 ? -1 : 1))) >= 0) continue;
            n13 = n10;
            n11 = i10;
            l11 = (long)mp4Extractor$Mp4Track;
        }
        long l17 = Long.MAX_VALUE;
        long l18 = l11 - l17;
        n10 = (int)(l18 == 0L ? 0 : (l18 < 0L ? -1 : 1));
        if (n10 == 0 || n13 == 0 || (n10 = (int)((object = object3 - (l11 += (l17 = 0xA00000L))) == 0L ? 0 : (object < 0L ? -1 : 1))) < 0) {
            n11 = n12;
        }
        return n11;
    }

    private static long maybeAdjustSeekOffset(TrackSampleTable trackSampleTable, long l10, long l11) {
        int n10;
        int n11 = Mp4Extractor.getSynchronizationSampleIndex(trackSampleTable, l10);
        if (n11 == (n10 = -1)) {
            return l11;
        }
        return Math.min(trackSampleTable.offsets[n11], l11);
    }

    private void maybeSkipRemainingMetaAtomHeaderBytes(ExtractorInput extractorInput) {
        Object object = this.scratch;
        int n10 = 8;
        ((ParsableByteArray)object).reset(n10);
        object = this.scratch.getData();
        extractorInput.peekFully((byte[])object, 0, n10);
        AtomParsers.maybeSkipRemainingMetaAtomHeaderBytes(this.scratch);
        int n11 = this.scratch.getPosition();
        extractorInput.skipFully(n11);
        extractorInput.resetPeekPosition();
    }

    private void processAtomEnded(long l10) {
        int n10;
        int n11;
        while (true) {
            Object object = this.containerAtoms;
            Object object2 = ((ArrayDeque)object).isEmpty();
            n11 = 2;
            if (object2) break;
            object = (Atom$ContainerAtom)this.containerAtoms.peek();
            long l11 = ((Atom$ContainerAtom)object).endPosition;
            long l12 = l11 - l10;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2) break;
            object = (Atom$ContainerAtom)this.containerAtoms.pop();
            int n12 = ((Atom)object).type;
            int n13 = 1836019574;
            if (n12 == n13) {
                this.processMoovAtom((Atom$ContainerAtom)object);
                object = this.containerAtoms;
                ((ArrayDeque)object).clear();
                this.parserState = n11;
                continue;
            }
            Object object3 = this.containerAtoms;
            n11 = (int)(((ArrayDeque)object3).isEmpty() ? 1 : 0);
            if (n11 != 0) continue;
            object3 = (Atom$ContainerAtom)this.containerAtoms.peek();
            ((Atom$ContainerAtom)object3).add((Atom$ContainerAtom)object);
        }
        if ((n10 = this.parserState) != n11) {
            this.enterReadingAtomHeaderState();
        }
    }

    private void processEndOfStreamReadingAtomHeader() {
        int n10 = this.fileType;
        int n11 = 2;
        if (n10 == n11 && (n10 = this.flags & n11) != 0) {
            ExtractorOutput extractorOutput = (ExtractorOutput)Assertions.checkNotNull(this.extractorOutput);
            n11 = 4;
            Object object = null;
            Object object2 = extractorOutput.track(0, n11);
            Object object3 = this.motionPhotoMetadata;
            if (object3 == null) {
                object = null;
            } else {
                int n12 = 1;
                Metadata$Entry[] metadata$EntryArray = new Metadata$Entry[n12];
                MotionPhotoMetadata motionPhotoMetadata = this.motionPhotoMetadata;
                metadata$EntryArray[0] = motionPhotoMetadata;
                object = object3 = new Metadata(metadata$EntryArray);
            }
            object3 = new Format$Builder();
            object = ((Format$Builder)object3).setMetadata((Metadata)object).build();
            object2.format((Format)object);
            extractorOutput.endTracks();
            long l10 = -9223372036854775807L;
            object2 = new SeekMap$Unseekable(l10);
            extractorOutput.seekMap((SeekMap)object2);
        }
    }

    private static int processFtypAtom(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int n10 = Mp4Extractor.brandToFileType(parsableByteArray.readInt());
        if (n10 != 0) {
            return n10;
        }
        n10 = 4;
        parsableByteArray.skipBytes(n10);
        while ((n10 = parsableByteArray.bytesLeft()) > 0) {
            n10 = Mp4Extractor.brandToFileType(parsableByteArray.readInt());
            if (n10 == 0) continue;
            return n10;
        }
        return 0;
    }

    private void processMoovAtom(Atom$ContainerAtom atom$ContainerAtom) {
        Object object;
        float f10;
        int n10;
        float f11;
        int n11;
        Object object2;
        Metadata metadata;
        Object object3;
        Object object4;
        Mp4Extractor mp4Extractor = this;
        Object object5 = atom$ContainerAtom;
        List<Object> list = new List<Object>();
        int n12 = this.fileType;
        int n13 = 1;
        float f12 = Float.MIN_VALUE;
        int n14 = n12 == n13 ? n13 : 0;
        GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
        n12 = 1969517665;
        Object object6 = object5.getLeafAtomOfType(n12);
        if (object6 != null) {
            object6 = AtomParsers.parseUdta((Atom$LeafAtom)object6);
            object4 = (Metadata)((Pair)object6).first;
            object6 = (Metadata)((Pair)object6).second;
            if (object4 != null) {
                gaplessInfoHolder.setFromMetadata((Metadata)object4);
            }
            object3 = object6;
            metadata = object4;
        } else {
            object3 = null;
            metadata = null;
        }
        n12 = 1835365473;
        object6 = object5.getContainerAtomOfType(n12);
        if (object6 != null) {
            object2 = object6 = AtomParsers.parseMdtaFromMeta((Atom$ContainerAtom)object6);
        } else {
            n11 = 0;
            f11 = 0.0f;
            object2 = null;
        }
        n12 = mp4Extractor.flags & n13;
        if (n12 != 0) {
            n10 = n13;
            f10 = f12;
        } else {
            n10 = 0;
            f10 = 0.0f;
            object = null;
        }
        long l10 = -9223372036854775807L;
        ArrayList<Mp4Extractor$Mp4Track[]> arrayList = null;
        b b10 = b.a;
        object5 = atom$ContainerAtom;
        object6 = gaplessInfoHolder;
        Object object7 = object2;
        object2 = b10;
        object5 = AtomParsers.parseTraks(atom$ContainerAtom, gaplessInfoHolder, l10, null, n10 != 0, n14 != 0, b10);
        object6 = (ExtractorOutput)Assertions.checkNotNull(mp4Extractor.extractorOutput);
        int n15 = object5.size();
        n11 = -1;
        f11 = 0.0f / 0.0f;
        long l11 = -9223372036854775807L;
        for (n14 = 0; n14 < n15; ++n14) {
            int n16;
            Mp4Extractor$Mp4Track[] mp4Extractor$Mp4TrackArray;
            block14: {
                long l12;
                block17: {
                    block16: {
                        float f13;
                        block15: {
                            long l13;
                            long l14;
                            long l15;
                            int n17;
                            int n18;
                            block13: {
                                Object e10 = object5.get(n14);
                                object = e10;
                                object = (Metadata[])e10;
                                n18 = object.sampleCount;
                                if (n18 != 0) break block13;
                                mp4Extractor$Mp4TrackArray = object5;
                                n16 = n15;
                                arrayList = list;
                                n15 = -1;
                                f13 = 0.0f / 0.0f;
                                n17 = 1;
                                l15 = -9223372036854775807L;
                                break block14;
                            }
                            Track track = object.track;
                            int n19 = n11;
                            arrayList = list;
                            long l16 = track.durationUs;
                            l15 = -9223372036854775807L;
                            long l17 = l16 - l15;
                            Object object8 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                            if (object8 == false) {
                                l16 = object.durationUs;
                            }
                            l11 = Math.max(l11, l16);
                            mp4Extractor$Mp4TrackArray = object5;
                            n16 = n15;
                            n15 = track.type;
                            object4 = object6.track(n14, n15);
                            object5 = new Mp4Extractor$Mp4Track(track, (TrackSampleTable)object, (TrackOutput)object4);
                            n15 = object.maximumSize + 30;
                            l12 = l11;
                            Format$Builder format$Builder = track.format.buildUpon();
                            format$Builder.setMaxInputSize(n15);
                            n15 = track.type;
                            n13 = 2;
                            f12 = 2.8E-45f;
                            if (n15 == n13 && (n15 = (int)((l14 = l16 - (l13 = 0L)) == 0L ? 0 : (l14 < 0L ? -1 : 1))) > 0) {
                                n15 = object.sampleCount;
                                n10 = 1;
                                f10 = Float.MIN_VALUE;
                                if (n15 > n10) {
                                    f13 = n15;
                                    f10 = l16;
                                    n11 = 1232348160;
                                    f11 = 1000000.0f;
                                    format$Builder.setFrameRate(f13 /= (f10 /= f11));
                                }
                            }
                            MetadataUtil.setFormatGaplessInfo(track.type, gaplessInfoHolder, format$Builder);
                            n15 = track.type;
                            object = new Metadata[n13];
                            f11 = 0.0f;
                            object[0] = object3;
                            object2 = mp4Extractor.slowMotionMetadataEntries;
                            n11 = (int)(object2.isEmpty() ? 1 : 0);
                            if (n11 != 0) {
                                n11 = 0;
                                f11 = 0.0f;
                                object2 = null;
                            } else {
                                list = mp4Extractor.slowMotionMetadataEntries;
                                object2 = new Metadata(list);
                            }
                            n17 = 1;
                            object[n17] = object2;
                            MetadataUtil.setFormatMetadata(n15, metadata, (Metadata)object7, format$Builder, object);
                            object4 = object5.trackOutput;
                            object = format$Builder.build();
                            object4.format((Format)object);
                            n15 = track.type;
                            n10 = n19;
                            if (n15 != n13) break block15;
                            n15 = -1;
                            f13 = 0.0f / 0.0f;
                            if (n19 != n15) break block16;
                            n11 = n18 = arrayList.size();
                            break block17;
                        }
                        n15 = -1;
                        f13 = 0.0f / 0.0f;
                    }
                    n11 = n10;
                }
                arrayList.add((Mp4Extractor$Mp4Track[])object5);
                l11 = l12;
            }
            list = arrayList;
            object5 = mp4Extractor$Mp4TrackArray;
            n15 = n16;
        }
        n10 = n11;
        arrayList = list;
        mp4Extractor.firstVideoTrackIndex = n11;
        mp4Extractor.durationUs = l11;
        object5 = new Mp4Extractor$Mp4Track[]{};
        object5 = list.toArray((T[])object5);
        mp4Extractor.tracks = object5;
        object5 = Mp4Extractor.calculateAccumulatedSampleSizes(object5);
        mp4Extractor.accumulatedSampleSizes = (long[][])object5;
        object6.endTracks();
        object6.seekMap(mp4Extractor);
    }

    private void processUnparsedAtom(long l10) {
        int n10 = this.atomType;
        int n11 = 1836086884;
        if (n10 == n11) {
            MotionPhotoMetadata motionPhotoMetadata;
            long l11 = 0L;
            long l12 = -9223372036854775807L;
            n11 = this.atomHeaderBytesRead;
            long l13 = n11;
            long l14 = l10 + l13;
            l13 = this.atomSize;
            long l15 = n11;
            long l16 = l13 - l15;
            l13 = l10;
            this.motionPhotoMetadata = motionPhotoMetadata = new MotionPhotoMetadata(l11, l10, l12, l14, l16);
        }
    }

    private boolean readAtomHeader(ExtractorInput object) {
        long l10;
        long l11;
        long l12;
        Object object2;
        int n10 = this.atomHeaderBytesRead;
        int n11 = 1;
        int n12 = 8;
        if (n10 == 0) {
            object2 = this.atomHeader.getData();
            n10 = (int)(object.readFully((byte[])object2, 0, n12, n11 != 0) ? 1 : 0);
            if (n10 == 0) {
                this.processEndOfStreamReadingAtomHeader();
                return false;
            }
            this.atomHeaderBytesRead = n12;
            this.atomHeader.setPosition(0);
            this.atomSize = l12 = this.atomHeader.readUnsignedInt();
            object2 = this.atomHeader;
            this.atomType = n10 = object2.readInt();
        }
        if ((n10 = (int)((l11 = (l12 = this.atomSize) - (l10 = 1L)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) == 0) {
            object2 = this.atomHeader.getData();
            object.readFully((byte[])object2, n12, n12);
            this.atomHeaderBytesRead = n10 = this.atomHeaderBytesRead + n12;
            object2 = this.atomHeader;
            this.atomSize = l12 = object2.readUnsignedLongToLong();
        } else {
            l10 = 0L;
            long l13 = l12 - l10;
            n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n10 == 0) {
                l12 = object.getLength();
                long l14 = l12 - (l10 = (long)-1);
                n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
                if (n10 == 0 && (object2 = (Atom$ContainerAtom)this.containerAtoms.peek()) != null) {
                    l12 = object2.endPosition;
                }
                if ((n10 = (int)(l12 == l10 ? 0 : (l12 < l10 ? -1 : 1))) != 0) {
                    l10 = object.getPosition();
                    l12 -= l10;
                    n10 = this.atomHeaderBytesRead;
                    l10 = n10;
                    this.atomSize = l12 += l10;
                }
            }
        }
        l12 = this.atomSize;
        l10 = this.atomHeaderBytesRead;
        n10 = (int)(l12 == l10 ? 0 : (l12 < l10 ? -1 : 1));
        if (n10 >= 0) {
            n10 = (int)(Mp4Extractor.shouldParseContainerAtom(this.atomType) ? 1 : 0);
            if (n10 != 0) {
                int n13;
                long l15 = object.getPosition();
                l12 = this.atomSize;
                l15 += l12;
                n10 = this.atomHeaderBytesRead;
                l10 = n10;
                l15 -= l10;
                l10 = n10;
                long l16 = l12 - l10;
                if ((n10 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1))) != 0 && (n10 = this.atomType) == (n13 = 1835365473)) {
                    this.maybeSkipRemainingMetaAtomHeaderBytes((ExtractorInput)object);
                }
                object = this.containerAtoms;
                n13 = this.atomType;
                object2 = new Atom$ContainerAtom(n13, l15);
                ((ArrayDeque)object).push(object2);
                l12 = this.atomSize;
                l10 = this.atomHeaderBytesRead;
                long l17 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
                if (l17 == false) {
                    this.processAtomEnded(l15);
                } else {
                    this.enterReadingAtomHeaderState();
                }
            } else {
                n10 = (int)(Mp4Extractor.shouldParseLeafAtom(this.atomType) ? 1 : 0);
                if (n10 != 0) {
                    int n14 = this.atomHeaderBytesRead;
                    if (n14 == n12) {
                        n14 = n11;
                    } else {
                        n14 = 0;
                        object = null;
                    }
                    Assertions.checkState(n14 != 0);
                    l12 = this.atomSize;
                    l10 = Integer.MAX_VALUE;
                    n14 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
                    if (n14 <= 0) {
                        n14 = n11;
                    } else {
                        n14 = 0;
                        object = null;
                    }
                    Assertions.checkState(n14 != 0);
                    l12 = this.atomSize;
                    n10 = (int)l12;
                    object = new ParsableByteArray(n10);
                    object2 = this.atomHeader.getData();
                    byte[] byArray = ((ParsableByteArray)object).getData();
                    System.arraycopy(object2, 0, byArray, 0, n12);
                    this.atomData = object;
                    this.parserState = n11;
                } else {
                    long l18 = object.getPosition();
                    l12 = this.atomHeaderBytesRead;
                    this.processUnparsedAtom(l18 -= l12);
                    boolean bl2 = false;
                    object = null;
                    this.atomData = null;
                    this.parserState = n11;
                }
            }
            return n11 != 0;
        }
        object = new ParserException("Atom size less than header length (unsupported).");
        throw object;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private boolean readAtomPayload(ExtractorInput var1_1, PositionHolder var2_2) {
        block6: {
            var3_3 = this.atomSize;
            var5_4 = this.atomHeaderBytesRead;
            var6_5 = var5_4;
            var3_3 -= var6_5;
            var6_5 = var1_1.getPosition() + var3_3;
            var8_6 = this.atomData;
            var9_7 = 1;
            if (var8_6 == null) break block6;
            var2_2 = var8_6.getData();
            var10_8 = this.atomHeaderBytesRead;
            var11_9 = (int)var3_3;
            var1_1.readFully((byte[])var2_2, var10_8, var11_9);
            var12_10 = this.atomType;
            var13_11 = 1718909296;
            if (var12_10 == var13_11) {
                this.fileType = var12_10 = Mp4Extractor.processFtypAtom(var8_6);
            } else {
                var1_1 = this.containerAtoms;
                var12_10 = (int)var1_1.isEmpty();
                if (var12_10 == 0) {
                    var1_1 = (Atom$ContainerAtom)this.containerAtoms.peek();
                    var11_9 = this.atomType;
                    var2_2 = new Atom$LeafAtom(var11_9, var8_6);
                    var1_1.add((Atom$LeafAtom)var2_2);
                }
            }
            ** GOTO lbl33
        }
        var14_12 = 262144L;
        cfr_temp_0 = var3_3 - var14_12;
        var16_13 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
        if (var16_13 /* !! */  < 0) {
            var13_11 = (int)var3_3;
            var1_1.skipFully(var13_11);
lbl33:
            // 3 sources

            var12_10 = 0;
            var1_1 = null;
        } else {
            var2_2.position = var14_12 = var1_1.getPosition() + var3_3;
            var12_10 = var9_7;
        }
        this.processAtomEnded(var6_5);
        if (var12_10 == 0 || (var12_10 = this.parserState) == (var13_11 = 2)) {
            var9_7 = 0;
        }
        return (boolean)var9_7;
    }

    /*
     * WARNING - void declaration
     */
    private int readSample(ExtractorInput extractorInput, PositionHolder positionHolder) {
        long l10;
        long l11;
        Mp4Extractor mp4Extractor = this;
        Object object = extractorInput;
        long l12 = extractorInput.getPosition();
        int n10 = this.sampleTrackIndex;
        int n11 = -1;
        if (n10 == n11) {
            this.sampleTrackIndex = n10 = this.getTrackIndexOfNextReadSample(l12);
            if (n10 == n11) {
                return n11;
            }
        }
        Object object2 = (Mp4Extractor$Mp4Track[])Util.castNonNull(mp4Extractor.tracks);
        int n12 = mp4Extractor.sampleTrackIndex;
        object2 = object2[n12];
        TrackOutput trackOutput = object2.trackOutput;
        int n13 = object2.sampleIndex;
        Object object3 = object2.sampleTable;
        Object object4 = ((TrackSampleTable)object3).offsets;
        long l13 = object4[n13];
        object3 = ((TrackSampleTable)object3).sizes;
        Object object5 = object3[n13];
        l12 = l13 - l12;
        long l14 = mp4Extractor.sampleBytesRead;
        l12 += l14;
        l14 = 0L;
        long l15 = l12 == l14 ? 0 : (l12 < l14 ? -1 : 1);
        int n14 = 1;
        if (l15 >= 0 && (l15 = (l11 = l12 - (l10 = 262144L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
            void var17_19;
            int n15;
            reference var17_16;
            object4 = object2.track;
            l15 = object4.sampleTransformation;
            if (l15 == n14) {
                long l16 = 8;
                l12 += l16;
                var17_16 = object5 + -8;
            }
            int n16 = (int)l12;
            object.skipFully(n16);
            Object object6 = object2.track;
            int n17 = ((Track)object6).nalUnitLengthFieldLength;
            if (n17 != 0) {
                object6 = mp4Extractor.nalLength.getData();
                object6[0] = false;
                object6[n14] = false;
                object6[2] = false;
                Track track = object2.track;
                n17 = track.nalUnitLengthFieldLength;
                l15 = 4 - n17;
                while ((n15 = mp4Extractor.sampleBytesWritten) < (var17_17 += l15)) {
                    int n18;
                    n15 = mp4Extractor.sampleCurrentNalBytesRemaining;
                    if (n15 == 0) {
                        object.readFully((byte[])object6, (int)l15, n17);
                        mp4Extractor.sampleBytesRead = n15 = mp4Extractor.sampleBytesRead + n17;
                        mp4Extractor.nalLength.setPosition(0);
                        ParsableByteArray parsableByteArray = mp4Extractor.nalLength;
                        n15 = parsableByteArray.readInt();
                        if (n15 >= 0) {
                            mp4Extractor.sampleCurrentNalBytesRemaining = n15;
                            mp4Extractor.nalStartCode.setPosition(0);
                            parsableByteArray = mp4Extractor.nalStartCode;
                            n18 = 4;
                            trackOutput.sampleData(parsableByteArray, n18);
                            mp4Extractor.sampleBytesWritten = n15 = mp4Extractor.sampleBytesWritten + n18;
                            continue;
                        }
                        object = new ParserException("Invalid NAL length");
                        throw object;
                    }
                    n15 = trackOutput.sampleData((DataReader)object, n15, false);
                    mp4Extractor.sampleBytesRead = n18 = mp4Extractor.sampleBytesRead + n15;
                    mp4Extractor.sampleBytesWritten = n18 = mp4Extractor.sampleBytesWritten + n15;
                    mp4Extractor.sampleCurrentNalBytesRemaining = n18 = mp4Extractor.sampleCurrentNalBytesRemaining - n15;
                }
            } else {
                reference var17_18;
                String string2 = "audio/ac4";
                object6 = object6.format.sampleMimeType;
                n16 = (int)(string2.equals(object6) ? 1 : 0);
                if (n16 != 0) {
                    n16 = mp4Extractor.sampleBytesWritten;
                    if (n16 == 0) {
                        object6 = mp4Extractor.scratch;
                        Ac4Util.getAc4SampleHeader((int)var17_16, (ParsableByteArray)object6);
                        object6 = mp4Extractor.scratch;
                        n17 = 7;
                        trackOutput.sampleData((ParsableByteArray)object6, n17);
                        mp4Extractor.sampleBytesWritten = n16 = mp4Extractor.sampleBytesWritten + n17;
                    }
                    var17_18 = var17_16 + 7;
                }
                while ((n16 = mp4Extractor.sampleBytesWritten) < var17_18) {
                    n16 = var17_18 - n16;
                    n16 = trackOutput.sampleData((DataReader)object, n16, false);
                    mp4Extractor.sampleBytesRead = n17 = mp4Extractor.sampleBytesRead + n16;
                    mp4Extractor.sampleBytesWritten = n17 = mp4Extractor.sampleBytesWritten + n16;
                    mp4Extractor.sampleCurrentNalBytesRemaining = n17 = mp4Extractor.sampleCurrentNalBytesRemaining - n16;
                }
            }
            n15 = var17_19;
            object = object2.sampleTable;
            long l17 = ((TrackSampleTable)object).timestampsUs[n13];
            int n19 = ((TrackSampleTable)object).flags[n13];
            l15 = n19;
            trackOutput.sampleMetadata(l17, n19, (int)var17_19, 0, null);
            object2.sampleIndex = n19 = object2.sampleIndex + n14;
            mp4Extractor.sampleTrackIndex = n11;
            mp4Extractor.sampleBytesRead = 0;
            mp4Extractor.sampleBytesWritten = 0;
            mp4Extractor.sampleCurrentNalBytesRemaining = 0;
            return 0;
        }
        object = positionHolder;
        positionHolder.position = l13;
        return n14;
    }

    private int readSefData(ExtractorInput extractorInput, PositionHolder positionHolder) {
        long l10;
        long l11;
        long l12;
        long l13;
        int n10;
        SefReader sefReader = this.sefReader;
        List list = this.slowMotionMetadataEntries;
        int n11 = sefReader.read(extractorInput, positionHolder, list);
        if (n11 == (n10 = 1) && (l13 = (l12 = (l11 = positionHolder.position) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
            this.enterReadingAtomHeaderState();
        }
        return n11;
    }

    private static boolean shouldParseContainerAtom(int n10) {
        int n11 = 1836019574;
        n10 = n10 != n11 && n10 != (n11 = 1953653099) && n10 != (n11 = 1835297121) && n10 != (n11 = 1835626086) && n10 != (n11 = 1937007212) && n10 != (n11 = 1701082227) && n10 != (n11 = 1835365473) ? 0 : 1;
        return n10 != 0;
    }

    private static boolean shouldParseLeafAtom(int n10) {
        int n11 = 1835296868;
        n10 = n10 != n11 && n10 != (n11 = 1836476516) && n10 != (n11 = 1751411826) && n10 != (n11 = 1937011556) && n10 != (n11 = 0x73747473) && n10 != (n11 = 0x73747373) && n10 != (n11 = 1668576371) && n10 != (n11 = 1701606260) && n10 != (n11 = 1937011555) && n10 != (n11 = 1937011578) && n10 != (n11 = 1937013298) && n10 != (n11 = 1937007471) && n10 != (n11 = 1668232756) && n10 != (n11 = 1953196132) && n10 != (n11 = 1718909296) && n10 != (n11 = 1969517665) && n10 != (n11 = 1801812339) && n10 != (n11 = 1768715124) ? 0 : 1;
        return n10 != 0;
    }

    private void updateSampleIndices(long l10) {
        for (Mp4Extractor$Mp4Track mp4Extractor$Mp4Track : this.tracks) {
            int n10;
            TrackSampleTable trackSampleTable = mp4Extractor$Mp4Track.sampleTable;
            int n11 = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(l10);
            if (n11 == (n10 = -1)) {
                n11 = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(l10);
            }
            mp4Extractor$Mp4Track.sampleIndex = n11;
        }
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap$SeekPoints getSeekPoints(long object) {
        int n10;
        long l10;
        Object object2;
        Object object3;
        long l11;
        Object object4;
        long l12;
        int n11;
        Object object5;
        Mp4Extractor$Mp4Track[] mp4Extractor$Mp4TrackArray = (Mp4Extractor$Mp4Track[])Assertions.checkNotNull(this.tracks);
        int n12 = mp4Extractor$Mp4TrackArray.length;
        if (n12 == 0) {
            SeekPoint seekPoint = SeekPoint.START;
            SeekMap$SeekPoints seekMap$SeekPoints = new SeekMap$SeekPoints(seekPoint);
            return seekMap$SeekPoints;
        }
        long l13 = -1;
        int n13 = this.firstVideoTrackIndex;
        int n14 = -1;
        long l14 = -9223372036854775807L;
        double d10 = -4.9E-324;
        if (n13 != n14) {
            object5 = this.tracks;
            TrackSampleTable trackSampleTable = object5[n13].sampleTable;
            n11 = Mp4Extractor.getSynchronizationSampleIndex(trackSampleTable, object);
            if (n11 == n14) {
                SeekPoint seekPoint = SeekPoint.START;
                SeekMap$SeekPoints seekMap$SeekPoints = new SeekMap$SeekPoints(seekPoint);
                return seekMap$SeekPoints;
            }
            l12 = trackSampleTable.timestampsUs[n11];
            object4 = trackSampleTable.offsets;
            l11 = (long)object4[n11];
            Object object6 = l12 == object ? 0 : (l12 < object ? -1 : 1);
            if (object6 < 0 && n11 < (object6 = (Object)(trackSampleTable.sampleCount + -1)) && (object3 = (Object)trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample((long)object)) != n14 && object3 != n11) {
                l13 = trackSampleTable.timestampsUs[object3];
                object2 = trackSampleTable.offsets;
                object = object2[object3];
            } else {
                object = l13;
                l13 = l14;
            }
            l10 = object;
            object = l12;
        } else {
            l11 = Long.MAX_VALUE;
            l10 = l13;
            l13 = l14;
        }
        object5 = null;
        for (n11 = 0; n11 < (n10 = ((Mp4Extractor$Mp4Track[])(object4 = this.tracks)).length); ++n11) {
            n10 = this.firstVideoTrackIndex;
            if (n11 == n10) continue;
            object4 = object4[n11].sampleTable;
            l12 = Mp4Extractor.maybeAdjustSeekOffset((TrackSampleTable)object4, object, l11);
            Object object7 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
            if (object7 != false) {
                l10 = Mp4Extractor.maybeAdjustSeekOffset((TrackSampleTable)object4, l13, l10);
            }
            l11 = l12;
        }
        object5 = new SeekPoint((long)object, l11);
        object3 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        if (object3 == false) {
            SeekMap$SeekPoints seekMap$SeekPoints = new SeekMap$SeekPoints((SeekPoint)object5);
            return seekMap$SeekPoints;
        }
        SeekPoint seekPoint = new SeekPoint(l13, l10);
        object2 = new SeekMap$SeekPoints((SeekPoint)object5, seekPoint);
        return object2;
    }

    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    public boolean isSeekable() {
        return true;
    }

    public int read(ExtractorInput object, PositionHolder positionHolder) {
        while (true) {
            int n10;
            if ((n10 = this.parserState) != 0) {
                int n11 = 1;
                if (n10 != n11) {
                    n11 = 2;
                    if (n10 != n11) {
                        n11 = 3;
                        if (n10 == n11) {
                            return this.readSefData((ExtractorInput)object, positionHolder);
                        }
                        object = new IllegalStateException();
                        throw object;
                    }
                    return this.readSample((ExtractorInput)object, positionHolder);
                }
                n10 = (int)(this.readAtomPayload((ExtractorInput)object, positionHolder) ? 1 : 0);
                if (n10 == 0) continue;
                return n11;
            }
            n10 = (int)(this.readAtomHeader((ExtractorInput)object) ? 1 : 0);
            if (n10 == 0) break;
        }
        return -1;
    }

    public void release() {
    }

    public void seek(long l10, long l11) {
        int n10;
        this.containerAtoms.clear();
        this.atomHeaderBytesRead = 0;
        this.sampleTrackIndex = n10 = -1;
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        long l12 = 0L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        if (l13 == false) {
            l13 = this.parserState;
            int n11 = 3;
            if (l13 != n11) {
                this.enterReadingAtomHeaderState();
            } else {
                this.sefReader.reset();
                List list = this.slowMotionMetadataEntries;
                list.clear();
            }
        } else {
            Mp4Extractor$Mp4Track[] mp4Extractor$Mp4TrackArray = this.tracks;
            if (mp4Extractor$Mp4TrackArray != null) {
                this.updateSampleIndices(l11);
            }
        }
    }

    public boolean sniff(ExtractorInput extractorInput) {
        int n10 = this.flags & 2;
        n10 = n10 != 0 ? 1 : 0;
        return Sniffer.sniffUnfragmented(extractorInput, n10 != 0);
    }
}

