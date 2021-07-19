/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData$SchemeData;
import com.google.android.exoplayer2.extractor.CeaUtil;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput$CryptoData;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.mp4.Atom$ContainerAtom;
import com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom;
import com.google.android.exoplayer2.extractor.mp4.AtomParsers;
import com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$TrackBundle;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.extractor.mp4.Sniffer;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.extractor.mp4.TrackFragment;
import com.google.android.exoplayer2.extractor.mp4.TrackSampleTable;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.h0.g.a;
import d.h.a.a.h0.g.d;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class FragmentedMp4Extractor
implements Extractor {
    private static final Format EMSG_FORMAT;
    private static final int EXTRA_TRACKS_BASE_ID = 100;
    public static final ExtractorsFactory FACTORY;
    public static final int FLAG_ENABLE_EMSG_TRACK = 4;
    public static final int FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 16;
    public static final int FLAG_WORKAROUND_IGNORE_TFDT_BOX = 2;
    private static final byte[] PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE;
    private static final int SAMPLE_GROUP_TYPE_seig = 1936025959;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_ENCRYPTION_DATA = 2;
    private static final int STATE_READING_SAMPLE_CONTINUE = 4;
    private static final int STATE_READING_SAMPLE_START = 3;
    private static final String TAG = "FragmentedMp4Extractor";
    private final TrackOutput additionalEmsgTrackOutput;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private TrackOutput[] ceaTrackOutputs;
    private final List closedCaptionFormats;
    private final ArrayDeque containerAtoms;
    private FragmentedMp4Extractor$TrackBundle currentTrackBundle;
    private long durationUs;
    private TrackOutput[] emsgTrackOutputs;
    private long endOfMdatPosition;
    private final EventMessageEncoder eventMessageEncoder;
    private ExtractorOutput extractorOutput;
    private final int flags;
    private boolean haveOutputSeekMap;
    private final ParsableByteArray nalBuffer;
    private final ParsableByteArray nalPrefix;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int pendingMetadataSampleBytes;
    private final ArrayDeque pendingMetadataSampleInfos;
    private long pendingSeekTimeUs;
    private boolean processSeiNalUnitPayload;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleSize;
    private final ParsableByteArray scratch;
    private final byte[] scratchBytes;
    private long segmentIndexEarliestPresentationTimeUs;
    private final Track sideloadedTrack;
    private final TimestampAdjuster timestampAdjuster;
    private final SparseArray trackBundles;

    static {
        FACTORY = a.a;
        Object object = new byte[16];
        byte[] byArray = object;
        byte[] byArray2 = object;
        byArray[0] = -94;
        byArray2[1] = 57;
        byArray[2] = 79;
        byArray2[3] = 82;
        byArray[4] = 90;
        byArray2[5] = -101;
        byArray[6] = 79;
        byArray2[7] = 20;
        byArray[8] = -94;
        byArray2[9] = 68;
        byArray[10] = 108;
        byArray2[11] = 66;
        byArray[12] = 124;
        byArray2[13] = 100;
        byArray[14] = -115;
        byArray2[15] = -12;
        PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = object;
        object = new Format$Builder;
        ((Format$Builder)object)();
        EMSG_FORMAT = ((Format$Builder)object).setSampleMimeType("application/x-emsg").build();
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    public FragmentedMp4Extractor(int n10) {
        this(n10, null);
    }

    public FragmentedMp4Extractor(int n10, TimestampAdjuster timestampAdjuster) {
        List list = Collections.emptyList();
        this(n10, timestampAdjuster, null, list);
    }

    public FragmentedMp4Extractor(int n10, TimestampAdjuster timestampAdjuster, Track track) {
        List list = Collections.emptyList();
        this(n10, timestampAdjuster, track, list);
    }

    public FragmentedMp4Extractor(int n10, TimestampAdjuster timestampAdjuster, Track track, List list) {
        this(n10, timestampAdjuster, track, list, null);
    }

    public FragmentedMp4Extractor(int n10, TimestampAdjuster trackOutputArray, Track object, List list, TrackOutput trackOutput) {
        long l10;
        this.flags = n10;
        this.timestampAdjuster = trackOutputArray;
        this.sideloadedTrack = object;
        TrackOutput[] trackOutputArray2 = Collections.unmodifiableList(list);
        this.closedCaptionFormats = trackOutputArray2;
        this.additionalEmsgTrackOutput = trackOutput;
        trackOutputArray2 = new EventMessageEncoder();
        this.eventMessageEncoder = trackOutputArray2;
        int n11 = 16;
        trackOutputArray2 = new ParsableByteArray(n11);
        this.atomHeader = trackOutputArray2;
        object = NalUnitUtil.NAL_START_CODE;
        trackOutputArray2 = new ParsableByteArray((byte[])object);
        this.nalStartCode = trackOutputArray2;
        trackOutputArray2 = new ParsableByteArray(5);
        this.nalPrefix = trackOutputArray2;
        trackOutputArray2 = new ParsableByteArray();
        this.nalBuffer = trackOutputArray2;
        trackOutputArray2 = (TrackOutput[])new byte[n11];
        this.scratchBytes = (byte[])trackOutputArray2;
        trackOutputArray = new ParsableByteArray((byte[])trackOutputArray2);
        this.scratch = trackOutputArray;
        trackOutputArray2 = new ArrayDeque();
        this.containerAtoms = trackOutputArray2;
        trackOutputArray2 = new ArrayDeque();
        this.pendingMetadataSampleInfos = trackOutputArray2;
        trackOutputArray2 = new SparseArray();
        this.trackBundles = trackOutputArray2;
        this.durationUs = l10 = -9223372036854775807L;
        this.pendingSeekTimeUs = l10;
        this.segmentIndexEarliestPresentationTimeUs = l10;
        trackOutputArray2 = ExtractorOutput.PLACEHOLDER;
        this.extractorOutput = trackOutputArray2;
        trackOutputArray = new TrackOutput[]{};
        this.emsgTrackOutputs = trackOutputArray;
        trackOutputArray2 = new TrackOutput[]{};
        this.ceaTrackOutputs = trackOutputArray2;
    }

    public static /* synthetic */ Extractor[] a() {
        Extractor[] extractorArray = new Extractor[1];
        FragmentedMp4Extractor fragmentedMp4Extractor = new FragmentedMp4Extractor();
        extractorArray[0] = fragmentedMp4Extractor;
        return extractorArray;
    }

    private static int checkNonNegative(int n10) {
        if (n10 >= 0) {
            return n10;
        }
        StringBuilder stringBuilder = new StringBuilder(38);
        stringBuilder.append("Unexpected negative value: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        ParserException parserException = new ParserException(string2);
        throw parserException;
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private DefaultSampleValues getDefaultSampleValues(SparseArray sparseArray, int n10) {
        int n11;
        int n12 = sparseArray.size();
        if (n12 == (n11 = 1)) {
            return (DefaultSampleValues)sparseArray.valueAt(0);
        }
        return (DefaultSampleValues)Assertions.checkNotNull((DefaultSampleValues)sparseArray.get(n10));
    }

    private static DrmInitData getDrmInitDataFromAtoms(List list) {
        int n10 = list.size();
        DrmInitData drmInitData = null;
        ArrayList<DrmInitData$SchemeData> arrayList = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object;
            Object object2 = (Atom$LeafAtom)list.get(i10);
            int n11 = ((Atom)object2).type;
            int n12 = 1886614376;
            if (n11 != n12) continue;
            if (arrayList == null) {
                arrayList = new ArrayList<DrmInitData$SchemeData>();
            }
            if ((object = PsshAtomUtil.parseUuid((byte[])(object2 = (Object)((Atom$LeafAtom)object2).data.getData()))) == null) {
                object2 = TAG;
                object = "Skipped pssh atom (failed to extract uuid)";
                Log.w((String)object2, (String)object);
                continue;
            }
            String string2 = "video/mp4";
            DrmInitData$SchemeData drmInitData$SchemeData = new DrmInitData$SchemeData((UUID)object, string2, (byte[])object2);
            arrayList.add(drmInitData$SchemeData);
        }
        if (arrayList != null) {
            drmInitData = new DrmInitData(arrayList);
        }
        return drmInitData;
    }

    private static FragmentedMp4Extractor$TrackBundle getNextTrackBundle(SparseArray sparseArray) {
        int n10 = sparseArray.size();
        FragmentedMp4Extractor$TrackBundle fragmentedMp4Extractor$TrackBundle = null;
        long l10 = Long.MAX_VALUE;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11;
            long l12;
            long l13;
            int n11;
            Object object;
            FragmentedMp4Extractor$TrackBundle fragmentedMp4Extractor$TrackBundle2 = (FragmentedMp4Extractor$TrackBundle)sparseArray.valueAt(i10);
            int n12 = FragmentedMp4Extractor$TrackBundle.access$000(fragmentedMp4Extractor$TrackBundle2);
            if (n12 == 0) {
                n12 = fragmentedMp4Extractor$TrackBundle2.currentSampleIndex;
                object = fragmentedMp4Extractor$TrackBundle2.moovSampleTable;
                n11 = ((TrackSampleTable)object).sampleCount;
                if (n12 == n11) continue;
            }
            if ((n12 = (int)(FragmentedMp4Extractor$TrackBundle.access$000(fragmentedMp4Extractor$TrackBundle2) ? 1 : 0)) != 0) {
                n12 = fragmentedMp4Extractor$TrackBundle2.currentTrackRunIndex;
                object = fragmentedMp4Extractor$TrackBundle2.fragment;
                n11 = ((TrackFragment)object).trunCount;
                if (n12 == n11) continue;
            }
            if ((l13 = (l12 = (l11 = fragmentedMp4Extractor$TrackBundle2.getCurrentSampleOffset()) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) >= 0) continue;
            fragmentedMp4Extractor$TrackBundle = fragmentedMp4Extractor$TrackBundle2;
            l10 = l11;
        }
        return fragmentedMp4Extractor$TrackBundle;
    }

    private static FragmentedMp4Extractor$TrackBundle getTrackBundle(SparseArray sparseArray, int n10) {
        int n11;
        int n12 = sparseArray.size();
        if (n12 == (n11 = 1)) {
            return (FragmentedMp4Extractor$TrackBundle)sparseArray.valueAt(0);
        }
        return (FragmentedMp4Extractor$TrackBundle)sparseArray.get(n10);
    }

    private void initExtraTracks() {
        Object object;
        int n10;
        int n11 = 2;
        Object object2 = new TrackOutput[n11];
        this.emsgTrackOutputs = object2;
        TrackOutput trackOutput = this.additionalEmsgTrackOutput;
        int n12 = 0;
        if (trackOutput != null) {
            object2[0] = trackOutput;
            n10 = 1;
        } else {
            n10 = 0;
            trackOutput = null;
        }
        int n13 = this.flags & 4;
        int n14 = 100;
        if (n13 != 0) {
            TrackOutput trackOutput2;
            n13 = n10 + 1;
            object = this.extractorOutput;
            int n15 = 101;
            int n16 = 5;
            object2[n10] = trackOutput2 = object.track(n14, n16);
            n10 = n13;
            n14 = n15;
        }
        object2 = (TrackOutput[])Util.nullSafeArrayCopy(this.emsgTrackOutputs, n10);
        this.emsgTrackOutputs = object2;
        n10 = ((TrackOutput[])object2).length;
        TrackOutput[] trackOutputArray = null;
        for (n13 = 0; n13 < n10; ++n13) {
            object = object2[n13];
            Format format = EMSG_FORMAT;
            object.format(format);
        }
        n11 = this.closedCaptionFormats.size();
        object2 = new TrackOutput[n11];
        this.ceaTrackOutputs = object2;
        while (n12 < (n11 = ((TrackOutput[])(object2 = this.ceaTrackOutputs)).length)) {
            object2 = this.extractorOutput;
            n10 = n14 + 1;
            n13 = 3;
            object2 = object2.track(n14, n13);
            trackOutputArray = (TrackOutput[])this.closedCaptionFormats.get(n12);
            object2.format((Format)trackOutputArray);
            trackOutputArray = this.ceaTrackOutputs;
            trackOutputArray[n12] = object2;
            ++n12;
            n14 = n10;
        }
    }

    private void onContainerAtomRead(Atom$ContainerAtom atom$ContainerAtom) {
        int n10 = atom$ContainerAtom.type;
        int n11 = 1836019574;
        if (n10 == n11) {
            this.onMoovContainerAtomRead(atom$ContainerAtom);
        } else {
            n11 = 0x6D6F6F66;
            if (n10 == n11) {
                this.onMoofContainerAtomRead(atom$ContainerAtom);
            } else {
                Object object = this.containerAtoms;
                n10 = (int)(((ArrayDeque)object).isEmpty() ? 1 : 0);
                if (n10 == 0) {
                    object = (Atom$ContainerAtom)this.containerAtoms.peek();
                    ((Atom$ContainerAtom)object).add(atom$ContainerAtom);
                }
            }
        }
    }

    private void onEmsgLeafAtomRead(ParsableByteArray parsableByteArray) {
        long l10;
        TrackOutput[] trackOutputArray;
        long l11;
        long l12;
        Object object;
        TrackOutput[] trackOutputArray2;
        long l13;
        long l14;
        long l15;
        int n10;
        FragmentedMp4Extractor fragmentedMp4Extractor = this;
        Object object2 = parsableByteArray;
        Object object3 = this.emsgTrackOutputs;
        int n11 = ((TrackOutput[])object3).length;
        if (n11 == 0) {
            return;
        }
        parsableByteArray.setPosition(8);
        n11 = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        long l16 = -9223372036854775807L;
        if (n11 != 0) {
            n10 = 1;
            if (n11 != n10) {
                StringBuilder stringBuilder = new StringBuilder(46);
                stringBuilder.append("Skipping unsupported emsg version: ");
                stringBuilder.append(n11);
                object2 = stringBuilder.toString();
                Log.w(TAG, (String)object2);
                return;
            }
            long l17 = parsableByteArray.readUnsignedInt();
            l15 = Util.scaleLargeTimestamp(parsableByteArray.readUnsignedLongToLong(), 1000000L, l17);
            l14 = Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000L, l17);
            l13 = parsableByteArray.readUnsignedInt();
            object3 = (String)Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
            trackOutputArray2 = (String)Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
            object = object3;
            l12 = l14;
            l11 = l13;
            trackOutputArray = trackOutputArray2;
            l13 = l16;
        } else {
            TrackOutput[] trackOutputArray3;
            object3 = (String)Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
            trackOutputArray2 = trackOutputArray3 = Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
            trackOutputArray2 = (String)trackOutputArray3;
            l14 = parsableByteArray.readUnsignedInt();
            long l18 = parsableByteArray.readUnsignedInt();
            long l19 = 1000000L;
            l13 = Util.scaleLargeTimestamp(l18, l19, l14);
            l18 = this.segmentIndexEarliestPresentationTimeUs;
            long l20 = l18 - l16;
            Object object4 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
            l10 = object4 != false ? (l18 += l13) : l16;
            l18 = parsableByteArray.readUnsignedInt();
            l19 = 1000L;
            l14 = Util.scaleLargeTimestamp(l18, l19, l14);
            l18 = parsableByteArray.readUnsignedInt();
            object = object3;
            l12 = l14;
            trackOutputArray = trackOutputArray2;
            l11 = l18;
            l15 = l10;
        }
        n11 = parsableByteArray.bytesLeft();
        object3 = new byte[n11];
        n10 = parsableByteArray.bytesLeft();
        int n12 = 0;
        ((ParsableByteArray)object2).readBytes((byte[])object3, 0, n10);
        object2 = new EventMessage((String)object, (String)trackOutputArray, l12, l11, (byte[])object3);
        object2 = fragmentedMp4Extractor.eventMessageEncoder.encode((EventMessage)object2);
        object3 = new ParsableByteArray((byte[])object2);
        int n13 = ((ParsableByteArray)object3).bytesLeft();
        for (TrackOutput trackOutput : fragmentedMp4Extractor.emsgTrackOutputs) {
            ((ParsableByteArray)object3).setPosition(0);
            trackOutput.sampleData((ParsableByteArray)object3, n13);
        }
        n11 = (int)(l15 == l16 ? 0 : (l15 < l16 ? -1 : 1));
        if (n11 == 0) {
            object3 = fragmentedMp4Extractor.pendingMetadataSampleInfos;
            FragmentedMp4Extractor$MetadataSampleInfo fragmentedMp4Extractor$MetadataSampleInfo = new FragmentedMp4Extractor$MetadataSampleInfo(l13, n13);
            ((ArrayDeque)object3).addLast(fragmentedMp4Extractor$MetadataSampleInfo);
            fragmentedMp4Extractor.pendingMetadataSampleBytes = n11 = fragmentedMp4Extractor.pendingMetadataSampleBytes + n13;
        } else {
            object3 = fragmentedMp4Extractor.timestampAdjuster;
            if (object3 != null) {
                l15 = ((TimestampAdjuster)object3).adjustSampleTimestamp(l15);
            }
            object3 = fragmentedMp4Extractor.emsgTrackOutputs;
            int n14 = ((Object)object3).length;
            while (n12 < n14) {
                Object object5 = object3[n12];
                int n15 = 1;
                trackOutputArray = null;
                l10 = l15;
                object5.sampleMetadata(l15, n15, n13, 0, null);
                ++n12;
            }
        }
    }

    private void onLeafAtomRead(Atom$LeafAtom object, long l10) {
        ArrayDeque arrayDeque = this.containerAtoms;
        int n10 = arrayDeque.isEmpty();
        if (n10 == 0) {
            Atom$ContainerAtom atom$ContainerAtom = (Atom$ContainerAtom)this.containerAtoms.peek();
            atom$ContainerAtom.add((Atom$LeafAtom)object);
        } else {
            n10 = ((Atom)object).type;
            int n11 = 1936286840;
            if (n10 == n11) {
                boolean bl2;
                object = FragmentedMp4Extractor.parseSidx(((Atom$LeafAtom)object).data, l10);
                this.segmentIndexEarliestPresentationTimeUs = l10 = ((Long)((Pair)object).first).longValue();
                ExtractorOutput extractorOutput = this.extractorOutput;
                object = (SeekMap)((Pair)object).second;
                extractorOutput.seekMap((SeekMap)object);
                this.haveOutputSeekMap = bl2 = true;
            } else {
                int n12 = 1701671783;
                if (n10 == n12) {
                    object = ((Atom$LeafAtom)object).data;
                    this.onEmsgLeafAtomRead((ParsableByteArray)object);
                }
            }
        }
    }

    private void onMoofContainerAtomRead(Atom$ContainerAtom object) {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object2;
        SparseArray sparseArray = this.trackBundles;
        int n10 = this.flags;
        byte[] byArray = this.scratchBytes;
        FragmentedMp4Extractor.parseMoof((Atom$ContainerAtom)object, sparseArray, n10, byArray);
        object = FragmentedMp4Extractor.getDrmInitDataFromAtoms(((Atom$ContainerAtom)object).leafChildren);
        int n11 = 0;
        sparseArray = null;
        if (object != null) {
            object2 = this.trackBundles;
            n10 = object2.size();
            byArray = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                FragmentedMp4Extractor$TrackBundle fragmentedMp4Extractor$TrackBundle = (FragmentedMp4Extractor$TrackBundle)this.trackBundles.valueAt(i10);
                fragmentedMp4Extractor$TrackBundle.updateDrmInitData((DrmInitData)object);
            }
        }
        if ((l13 = (l12 = (l11 = this.pendingSeekTimeUs) - (l10 = -9223372036854775807L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            object = this.trackBundles;
            l13 = object.size();
            while (n11 < l13) {
                object2 = (FragmentedMp4Extractor$TrackBundle)this.trackBundles.valueAt(n11);
                long l14 = this.pendingSeekTimeUs;
                ((FragmentedMp4Extractor$TrackBundle)object2).seek(l14);
                ++n11;
            }
            this.pendingSeekTimeUs = l10;
        }
    }

    private void onMoovContainerAtomRead(Atom$ContainerAtom object) {
        Object object2;
        int n10;
        int n11;
        Object object3;
        int n12;
        int n13;
        Object object4 = this.sideloadedTrack;
        int n14 = 1;
        float f10 = Float.MIN_VALUE;
        int n15 = 0;
        if (object4 == null) {
            n13 = n14;
        } else {
            n13 = 0;
            object4 = null;
        }
        Assertions.checkState(n13 != 0, "Unexpected moov box.");
        DrmInitData drmInitData = FragmentedMp4Extractor.getDrmInitDataFromAtoms(((Atom$ContainerAtom)object).leafChildren);
        n13 = 1836475768;
        object4 = (Atom$ContainerAtom)Assertions.checkNotNull(((Atom$ContainerAtom)object).getContainerAtomOfType(n13));
        SparseArray sparseArray = new SparseArray();
        long l10 = -9223372036854775807L;
        Object object5 = ((Atom$ContainerAtom)object4).leafChildren;
        int n16 = object5.size();
        long l11 = l10;
        Object object6 = null;
        for (n12 = 0; n12 < n16; ++n12) {
            object3 = (Atom$LeafAtom)((Atom$ContainerAtom)object4).leafChildren.get(n12);
            n11 = ((Atom)object3).type;
            n10 = 1953654136;
            if (n11 == n10) {
                object3 = FragmentedMp4Extractor.parseTrex(((Atom$LeafAtom)object3).data);
                object2 = (Integer)((Pair)object3).first;
                n11 = (Integer)object2;
                object3 = (DefaultSampleValues)((Pair)object3).second;
                sparseArray.put(n11, object3);
                continue;
            }
            n10 = 1835362404;
            if (n11 != n10) continue;
            object3 = ((Atom$LeafAtom)object3).data;
            l11 = FragmentedMp4Extractor.parseMehd((ParsableByteArray)object3);
        }
        object3 = new GaplessInfoHolder();
        n13 = this.flags & 0x10;
        if (n13 != 0) {
            n13 = n14;
        } else {
            n13 = 0;
            object4 = null;
        }
        n10 = 0;
        d d10 = new d(this);
        object6 = object;
        object = AtomParsers.parseTraks((Atom$ContainerAtom)object, (GaplessInfoHolder)object3, l11, drmInitData, n13 != 0, false, d10);
        n13 = object.size();
        object6 = this.trackBundles;
        n12 = object6.size();
        if (n12 == 0) {
            while (n15 < n13) {
                TrackSampleTable trackSampleTable = (TrackSampleTable)object.get(n15);
                object6 = trackSampleTable.track;
                object5 = this.extractorOutput;
                n11 = ((Track)object6).type;
                object5 = object5.track(n15, n11);
                n11 = ((Track)object6).id;
                object2 = this.getDefaultSampleValues(sparseArray, n11);
                object3 = new FragmentedMp4Extractor$TrackBundle((TrackOutput)object5, trackSampleTable, (DefaultSampleValues)object2);
                trackSampleTable = this.trackBundles;
                n16 = ((Track)object6).id;
                trackSampleTable.put(n16, object3);
                long l12 = this.durationUs;
                long l13 = ((Track)object6).durationUs;
                this.durationUs = l10 = Math.max(l12, l13);
                ++n15;
            }
            object = this.extractorOutput;
            object.endTracks();
        } else {
            TrackSampleTable trackSampleTable;
            object6 = this.trackBundles;
            n12 = object6.size();
            if (n12 != n13) {
                n14 = 0;
                trackSampleTable = null;
                f10 = 0.0f;
            }
            Assertions.checkState(n14 != 0);
            while (n15 < n13) {
                trackSampleTable = (TrackSampleTable)object.get(n15);
                object6 = trackSampleTable.track;
                object3 = this.trackBundles;
                n16 = ((Track)object6).id;
                object3 = (FragmentedMp4Extractor$TrackBundle)object3.get(n16);
                n12 = ((Track)object6).id;
                object6 = this.getDefaultSampleValues(sparseArray, n12);
                ((FragmentedMp4Extractor$TrackBundle)object3).reset(trackSampleTable, (DefaultSampleValues)object6);
                ++n15;
            }
        }
    }

    private void outputPendingMetadataSamples(long l10) {
        Object object;
        boolean bl2;
        while (!(bl2 = ((ArrayDeque)(object = this.pendingMetadataSampleInfos)).isEmpty())) {
            object = (FragmentedMp4Extractor$MetadataSampleInfo)this.pendingMetadataSampleInfos.removeFirst();
            int n10 = this.pendingMetadataSampleBytes;
            int n11 = ((FragmentedMp4Extractor$MetadataSampleInfo)object).size;
            this.pendingMetadataSampleBytes = n10 -= n11;
            long l11 = ((FragmentedMp4Extractor$MetadataSampleInfo)object).presentationTimeDeltaUs + l10;
            Object object2 = this.timestampAdjuster;
            if (object2 != null) {
                l11 = ((TimestampAdjuster)object2).adjustSampleTimestamp(l11);
            }
            TrackOutput[] trackOutputArray = this.emsgTrackOutputs;
            int n12 = trackOutputArray.length;
            object2 = null;
            for (int i10 = 0; i10 < n12; ++i10) {
                object2 = trackOutputArray[i10];
                int n13 = 1;
                int n14 = ((FragmentedMp4Extractor$MetadataSampleInfo)object).size;
                int n15 = this.pendingMetadataSampleBytes;
                object2.sampleMetadata(l11, n13, n14, n15, null);
            }
        }
    }

    private static long parseMehd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int n10 = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        long l10 = n10 == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
        return l10;
    }

    private static void parseMoof(Atom$ContainerAtom atom$ContainerAtom, SparseArray sparseArray, int n10, byte[] byArray) {
        List list = atom$ContainerAtom.containerChildren;
        int n11 = list.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            Atom$ContainerAtom atom$ContainerAtom2 = (Atom$ContainerAtom)atom$ContainerAtom.containerChildren.get(i10);
            int n12 = atom$ContainerAtom2.type;
            int n13 = 1953653094;
            if (n12 != n13) continue;
            FragmentedMp4Extractor.parseTraf(atom$ContainerAtom2, sparseArray, n10, byArray);
        }
    }

    private static void parseSaio(ParsableByteArray object, TrackFragment object2) {
        int n10 = 8;
        ((ParsableByteArray)object).setPosition(n10);
        int n11 = ((ParsableByteArray)object).readInt();
        int n12 = Atom.parseFullAtomFlags(n11);
        int n13 = 1;
        if ((n12 &= n13) == n13) {
            ((ParsableByteArray)object).skipBytes(n10);
        }
        if ((n10 = ((ParsableByteArray)object).readUnsignedIntToInt()) == n13) {
            n10 = Atom.parseFullAtomVersion(n11);
            long l10 = ((TrackFragment)object2).auxiliaryDataPosition;
            long l11 = n10 == 0 ? ((ParsableByteArray)object).readUnsignedInt() : ((ParsableByteArray)object).readUnsignedLongToLong();
            ((TrackFragment)object2).auxiliaryDataPosition = l10 += l11;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(40);
        stringBuilder.append("Unexpected saio entry count: ");
        stringBuilder.append(n10);
        object2 = stringBuilder.toString();
        object = new ParserException((String)object2);
        throw object;
    }

    private static void parseSaiz(TrackEncryptionBox object, ParsableByteArray object2, TrackFragment trackFragment) {
        int n10;
        int n11 = ((TrackEncryptionBox)object).perSampleIvSize;
        int n12 = 8;
        ((ParsableByteArray)object2).setPosition(n12);
        int n13 = Atom.parseFullAtomFlags(((ParsableByteArray)object2).readInt());
        int n14 = 1;
        if ((n13 &= n14) == n14) {
            ((ParsableByteArray)object2).skipBytes(n12);
        }
        n12 = ((ParsableByteArray)object2).readUnsignedByte();
        n13 = ((ParsableByteArray)object2).readUnsignedIntToInt();
        if (n13 <= (n10 = trackFragment.sampleCount)) {
            int n15;
            n10 = 0;
            if (n12 == 0) {
                boolean[] blArray = trackFragment.sampleHasSubsampleEncryptionTable;
                n15 = 0;
                for (int i10 = 0; i10 < n13; ++i10) {
                    int n16 = ((ParsableByteArray)object2).readUnsignedByte();
                    n15 += n16;
                    n16 = n16 > n11 ? n14 : 0;
                    blArray[i10] = n16;
                }
            } else {
                if (n12 <= n11) {
                    n14 = 0;
                }
                n15 = (n12 *= n13) + 0;
                object = trackFragment.sampleHasSubsampleEncryptionTable;
                Arrays.fill((boolean[])object, 0, n13, n14 != 0);
            }
            object = trackFragment.sampleHasSubsampleEncryptionTable;
            int n17 = trackFragment.sampleCount;
            Arrays.fill((boolean[])object, n13, n17, false);
            if (n15 > 0) {
                trackFragment.initEncryptionData(n15);
            }
            return;
        }
        int n18 = trackFragment.sampleCount;
        StringBuilder stringBuilder = new StringBuilder(78);
        stringBuilder.append("Saiz sample count ");
        stringBuilder.append(n13);
        stringBuilder.append(" is greater than fragment sample count");
        stringBuilder.append(n18);
        object2 = stringBuilder.toString();
        object = new ParserException((String)object2);
        throw object;
    }

    private static void parseSampleGroups(Atom$ContainerAtom atom$ContainerAtom, String string2, TrackFragment trackFragment) {
        int n10;
        Object object;
        int n11;
        int n12;
        Object object2 = atom$ContainerAtom;
        TrackFragment trackFragment2 = trackFragment;
        byte[] byArray = null;
        ParsableByteArray parsableByteArray = null;
        ParsableByteArray parsableByteArray2 = null;
        for (n12 = 0; n12 < (n11 = (object = ((Atom$ContainerAtom)object2).leafChildren).size()); ++n12) {
            object = (Atom$LeafAtom)((Atom$ContainerAtom)object2).leafChildren.get(n12);
            ParsableByteArray parsableByteArray3 = ((Atom$LeafAtom)object).data;
            n11 = ((Atom)object).type;
            int n13 = 1935828848;
            n10 = 1936025959;
            int n14 = 12;
            if (n11 == n13) {
                parsableByteArray3.setPosition(n14);
                n11 = parsableByteArray3.readInt();
                if (n11 != n10) continue;
                parsableByteArray = parsableByteArray3;
                continue;
            }
            n13 = 1936158820;
            if (n11 != n13) continue;
            parsableByteArray3.setPosition(n14);
            n11 = parsableByteArray3.readInt();
            if (n11 != n10) continue;
            parsableByteArray2 = parsableByteArray3;
        }
        if (parsableByteArray != null && parsableByteArray2 != null) {
            int n15 = 8;
            parsableByteArray.setPosition(n15);
            n12 = Atom.parseFullAtomVersion(parsableByteArray.readInt());
            n11 = 4;
            parsableByteArray.skipBytes(n11);
            int n16 = 1;
            if (n12 == n16) {
                parsableByteArray.skipBytes(n11);
            }
            if ((n12 = parsableByteArray.readInt()) == n16) {
                long l10;
                long l11;
                parsableByteArray2.setPosition(n15);
                n15 = Atom.parseFullAtomVersion(parsableByteArray2.readInt());
                parsableByteArray2.skipBytes(n11);
                if (n15 == n16) {
                    l11 = parsableByteArray2.readUnsignedInt();
                    long l12 = l11 - (l10 = 0L);
                    n15 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                    if (n15 == 0) {
                        object2 = new ParserException("Variable length description in sgpd found (unsupported)");
                        throw object2;
                    }
                } else {
                    n12 = 2;
                    if (n15 >= n12) {
                        parsableByteArray2.skipBytes(n11);
                    }
                }
                l11 = parsableByteArray2.readUnsignedInt();
                l10 = 1L;
                n15 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
                if (n15 == 0) {
                    parsableByteArray2.skipBytes(n16);
                    n15 = parsableByteArray2.readUnsignedByte();
                    n12 = n15 & 0xF0;
                    int n17 = n12 >> 4;
                    int n18 = n15 & 0xF;
                    n15 = parsableByteArray2.readUnsignedByte();
                    n10 = n15 == n16 ? n16 : 0;
                    if (n10 == 0) {
                        return;
                    }
                    int n19 = parsableByteArray2.readUnsignedByte();
                    n15 = 16;
                    byte[] byArray2 = new byte[n15];
                    parsableByteArray2.readBytes(byArray2, 0, n15);
                    if (n19 == 0) {
                        n15 = parsableByteArray2.readUnsignedByte();
                        byArray = new byte[n15];
                        parsableByteArray2.readBytes(byArray, 0, n15);
                    }
                    trackFragment2.definesEncryptionData = n16;
                    trackFragment2.trackEncryptionBox = object2 = new TrackEncryptionBox(n10 != 0, string2, n19, byArray2, n17, n18, byArray);
                    return;
                }
                object2 = new ParserException("Entry count in sgpd != 1 (unsupported).");
                throw object2;
            }
            object2 = new ParserException("Entry count in sbgp != 1 (unsupported).");
            throw object2;
        }
    }

    private static void parseSenc(ParsableByteArray object, int n10, TrackFragment trackFragment) {
        ((ParsableByteArray)object).setPosition(n10 += 8);
        n10 = Atom.parseFullAtomFlags(((ParsableByteArray)object).readInt());
        int n11 = n10 & 1;
        if (n11 == 0) {
            String string2;
            n11 = 0;
            StringBuilder stringBuilder = null;
            if ((n10 &= 2) != 0) {
                n10 = 1;
            } else {
                n10 = 0;
                string2 = null;
            }
            int n12 = ((ParsableByteArray)object).readUnsignedIntToInt();
            if (n12 == 0) {
                object = trackFragment.sampleHasSubsampleEncryptionTable;
                n10 = trackFragment.sampleCount;
                Arrays.fill((boolean[])object, 0, n10, false);
                return;
            }
            int n13 = trackFragment.sampleCount;
            if (n12 == n13) {
                Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, n12, n10 != 0);
                n10 = ((ParsableByteArray)object).bytesLeft();
                trackFragment.initEncryptionData(n10);
                trackFragment.fillEncryptionData((ParsableByteArray)object);
                return;
            }
            n10 = trackFragment.sampleCount;
            stringBuilder = new StringBuilder(80);
            stringBuilder.append("Senc sample count ");
            stringBuilder.append(n12);
            stringBuilder.append(" is different from fragment sample count");
            stringBuilder.append(n10);
            string2 = stringBuilder.toString();
            object = new ParserException(string2);
            throw object;
        }
        object = new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        throw object;
    }

    private static void parseSenc(ParsableByteArray parsableByteArray, TrackFragment trackFragment) {
        FragmentedMp4Extractor.parseSenc(parsableByteArray, 0, trackFragment);
    }

    private static Pair parseSidx(ParsableByteArray parsableByteArray, long l10) {
        long l11;
        long l12;
        Object object = parsableByteArray;
        parsableByteArray.setPosition(8);
        int n10 = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int n11 = 4;
        parsableByteArray.skipBytes(n11);
        long l13 = parsableByteArray.readUnsignedInt();
        if (n10 == 0) {
            l12 = parsableByteArray.readUnsignedInt();
            l11 = parsableByteArray.readUnsignedInt();
        } else {
            l12 = parsableByteArray.readUnsignedLongToLong();
            l11 = parsableByteArray.readUnsignedLongToLong();
        }
        long l14 = l10 + l11;
        l11 = 1000000L;
        long l15 = Util.scaleLargeTimestamp(l12, l11, l13);
        ((ParsableByteArray)object).skipBytes(2);
        n10 = parsableByteArray.readUnsignedShort();
        int[] nArray = new int[n10];
        long[] lArray = new long[n10];
        long[] lArray2 = new long[n10];
        long[] lArray3 = new long[n10];
        ChunkIndex chunkIndex = null;
        long l16 = l15;
        long l17 = l12;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = parsableByteArray.readInt();
            int n13 = n12 & -1 << -1;
            if (n13 == 0) {
                long l18 = parsableByteArray.readUnsignedInt();
                int n14 = -1 >>> 1;
                nArray[i10] = n12 &= n14;
                lArray[i10] = l14;
                lArray3[i10] = l16;
                l16 = l12 + l18;
                l18 = 1000000L;
                l12 = l16;
                l11 = l18;
                l12 = Util.scaleLargeTimestamp(l16, l18, l13);
                l11 = lArray3[i10];
                lArray2[i10] = l11 = l12 - l11;
                int n15 = 4;
                ((ParsableByteArray)object).skipBytes(n15);
                int n16 = nArray[i10];
                long l19 = n16;
                l14 += l19;
                n11 = n15;
                l17 = l12;
                l12 = l16;
                l16 = l17;
                continue;
            }
            object = new ParserException("Unhandled indirect reference");
            throw object;
        }
        object = l15;
        chunkIndex = new ChunkIndex(nArray, lArray, lArray2, lArray3);
        return Pair.create((Object)object, (Object)chunkIndex);
    }

    private static long parseTfdt(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int n10 = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int n11 = 1;
        long l10 = n10 == n11 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
        return l10;
    }

    private static FragmentedMp4Extractor$TrackBundle parseTfhd(ParsableByteArray parsableByteArray, SparseArray object) {
        parsableByteArray.setPosition(8);
        int n10 = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        int n11 = parsableByteArray.readInt();
        object = FragmentedMp4Extractor.getTrackBundle(object, n11);
        if (object == null) {
            return null;
        }
        n11 = n10 & 1;
        if (n11 != 0) {
            long l10 = parsableByteArray.readUnsignedLongToLong();
            TrackFragment trackFragment = object.fragment;
            trackFragment.dataPosition = l10;
            trackFragment.auxiliaryDataPosition = l10;
        }
        DefaultSampleValues defaultSampleValues = object.defaultSampleValues;
        int n12 = n10 & 2;
        n12 = n12 != 0 ? parsableByteArray.readInt() + -1 : defaultSampleValues.sampleDescriptionIndex;
        int n13 = n10 & 8;
        n13 = n13 != 0 ? parsableByteArray.readInt() : defaultSampleValues.duration;
        int n14 = n10 & 0x10;
        n14 = n14 != 0 ? parsableByteArray.readInt() : defaultSampleValues.size;
        int n15 = (n10 &= 0x20) != 0 ? parsableByteArray.readInt() : defaultSampleValues.flags;
        TrackFragment trackFragment = object.fragment;
        trackFragment.header = defaultSampleValues = new DefaultSampleValues(n12, n13, n14, n15);
        return object;
    }

    private static void parseTraf(Atom$ContainerAtom atom$ContainerAtom, SparseArray object, int n10, byte[] byArray) {
        int n11;
        Object object2;
        int n12;
        int n13 = 1952868452;
        Object object3 = ((Atom$LeafAtom)Assertions.checkNotNull((Object)atom$ContainerAtom.getLeafAtomOfType((int)n13))).data;
        if ((object = FragmentedMp4Extractor.parseTfhd((ParsableByteArray)object3, (SparseArray)object)) == null) {
            return;
        }
        object3 = ((FragmentedMp4Extractor$TrackBundle)object).fragment;
        long l10 = ((TrackFragment)object3).nextFragmentDecodeTime;
        int n14 = ((TrackFragment)object3).nextFragmentDecodeTimeIncludesMoov;
        ((FragmentedMp4Extractor$TrackBundle)object).resetFragmentInfo();
        boolean bl2 = true;
        FragmentedMp4Extractor$TrackBundle.access$002((FragmentedMp4Extractor$TrackBundle)object, bl2);
        int n15 = 0x74666474;
        Atom$LeafAtom atom$LeafAtom = atom$ContainerAtom.getLeafAtomOfType(n15);
        if (atom$LeafAtom != null && (n12 = n10 & 2) == 0) {
            object2 = atom$LeafAtom.data;
            ((TrackFragment)object3).nextFragmentDecodeTime = l10 = FragmentedMp4Extractor.parseTfdt((ParsableByteArray)object2);
            ((TrackFragment)object3).nextFragmentDecodeTimeIncludesMoov = bl2;
        } else {
            ((TrackFragment)object3).nextFragmentDecodeTime = l10;
            ((TrackFragment)object3).nextFragmentDecodeTimeIncludesMoov = n14;
        }
        FragmentedMp4Extractor.parseTruns(atom$ContainerAtom, (FragmentedMp4Extractor$TrackBundle)object, n10);
        object = object.moovSampleTable.track;
        n10 = ((DefaultSampleValues)Assertions.checkNotNull((Object)object3.header)).sampleDescriptionIndex;
        object = ((Track)object).getSampleDescriptionEncryptionBox(n10);
        n10 = 1935763834;
        Object object4 = atom$ContainerAtom.getLeafAtomOfType(n10);
        if (object4 != null) {
            object2 = (TrackEncryptionBox)Assertions.checkNotNull(object);
            object4 = ((Atom$LeafAtom)object4).data;
            FragmentedMp4Extractor.parseSaiz((TrackEncryptionBox)object2, (ParsableByteArray)object4, (TrackFragment)object3);
        }
        if ((object4 = atom$ContainerAtom.getLeafAtomOfType(n10 = 1935763823)) != null) {
            object4 = ((Atom$LeafAtom)object4).data;
            FragmentedMp4Extractor.parseSaio((ParsableByteArray)object4, (TrackFragment)object3);
        }
        if ((object4 = atom$ContainerAtom.getLeafAtomOfType(n10 = 1936027235)) != null) {
            object4 = ((Atom$LeafAtom)object4).data;
            FragmentedMp4Extractor.parseSenc((ParsableByteArray)object4, (TrackFragment)object3);
        }
        if (object != null) {
            object = ((TrackEncryptionBox)object).schemeType;
        } else {
            n11 = 0;
            object = null;
        }
        FragmentedMp4Extractor.parseSampleGroups(atom$ContainerAtom, (String)object, (TrackFragment)object3);
        object = atom$ContainerAtom.leafChildren;
        n11 = object.size();
        object4 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            object2 = (Atom$LeafAtom)atom$ContainerAtom.leafChildren.get(n10);
            int n16 = ((Atom)object2).type;
            n14 = 1970628964;
            if (n16 != n14) continue;
            object2 = ((Atom$LeafAtom)object2).data;
            FragmentedMp4Extractor.parseUuid((ParsableByteArray)object2, (TrackFragment)object3, byArray);
        }
    }

    private static Pair parseTrex(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(12);
        int n10 = parsableByteArray.readInt();
        int n11 = parsableByteArray.readInt() + -1;
        int n12 = parsableByteArray.readInt();
        int n13 = parsableByteArray.readInt();
        int n14 = parsableByteArray.readInt();
        Integer n15 = n10;
        DefaultSampleValues defaultSampleValues = new DefaultSampleValues(n11, n12, n13, n14);
        return Pair.create((Object)n15, (Object)defaultSampleValues);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static int parseTrun(FragmentedMp4Extractor$TrackBundle var0, int var1_1, int var2_2, ParsableByteArray var3_3, int var4_4) {
        block28: {
            block27: {
                block26: {
                    var5_5 = var0;
                    var6_6 = 1.1E-44f;
                    var7_7 = var3_3;
                    var3_3.setPosition(8);
                    var8_8 = Atom.parseFullAtomFlags(var3_3.readInt());
                    var9_9 = var0.moovSampleTable.track;
                    var10_10 = var0.fragment;
                    var11_11 = (DefaultSampleValues)Util.castNonNull(var10_10.header);
                    var12_12 /* !! */  = var10_10.trunLength;
                    var12_12 /* !! */ [var1_1] = var13_13 = var3_3.readUnsignedIntToInt();
                    var12_12 /* !! */  = (int[])var10_10.trunDataPosition;
                    var14_14 = var10_10.dataPosition;
                    var12_12 /* !! */ [var1_1] = (int)var14_14;
                    var13_13 = var8_8 & 1;
                    if (var13_13 != 0) {
                        var14_14 = var12_12 /* !! */ [var1_1];
                        var16_15 = var3_3.readInt();
                        var17_16 = var16_15;
                        var12_12 /* !! */ [var1_1] = (int)(var14_14 += var17_16);
                    }
                    var19_17 = var8_8 & 4;
                    var13_13 = 0;
                    var20_18 = null;
                    var21_19 = 1;
                    var22_20 = 1.4E-45f;
                    if (var19_17 != 0) {
                        var19_17 = var21_19;
                        var23_21 = var22_20;
                    } else {
                        var19_17 = 0;
                        var12_12 /* !! */  = null;
                        var23_21 = 0.0f;
                    }
                    var16_15 = var11_11.flags;
                    if (var19_17 != 0) {
                        var16_15 = var3_3.readInt();
                    }
                    if ((var24_22 = var8_8 & 256) != 0) {
                        var24_22 = var21_19;
                        var25_23 = var22_20;
                    } else {
                        var24_22 = 0;
                        var25_23 = 0.0f;
                    }
                    var26_24 = var8_8 & 512;
                    if (var26_24 != 0) {
                        var26_24 = var21_19;
                        var27_25 = var22_20;
                    } else {
                        var26_24 = 0;
                        var27_25 = 0.0f;
                    }
                    var28_26 = var8_8 & 1024;
                    if (var28_26 != 0) {
                        var28_26 = var21_19;
                        var29_27 = var22_20;
                    } else {
                        var28_26 = 0;
                        var29_27 = 0.0f;
                    }
                    if ((var8_8 &= 2048) != 0) {
                        var8_8 = var21_19;
                        var6_6 = var22_20;
                    } else {
                        var8_8 = 0;
                        var30_28 = null;
                        var6_6 = 0.0f;
                    }
                    var31_29 = var9_9.editListDurations;
                    if (var31_29 == null || (var32_30 = var31_29.length) != var21_19) break block26;
                    var33_31 = var31_29[0];
                    var35_32 = 0L;
                    cfr_temp_0 = var33_31 - var35_32;
                    var37_33 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                    if (var37_33 /* !! */  != false) break block27;
                    var31_29 = (long[])Util.castNonNull(var9_9.editListMediaTimes);
                    var33_31 = var31_29[0];
                    var35_32 = 1000000L;
                    var14_14 = var9_9.timescale;
                    var33_31 = Util.scaleLargeTimestamp(var33_31, var35_32, var14_14);
                    break block28;
                }
                var35_32 = 0L;
            }
            var33_31 = var35_32;
        }
        var20_18 = var10_10.sampleSizeTable;
        var38_34 = var10_10.sampleCompositionTimeOffsetUsTable;
        var31_29 = var10_10.sampleDecodingTimeUsTable;
        var7_7 = var10_10.sampleIsSyncFrameTable;
        var39_35 = var16_15;
        var16_15 = var9_9.type;
        var40_36 = var7_7;
        var41_37 = 2;
        if (var16_15 != var41_37) ** GOTO lbl-1000
        var41_37 = 1;
        var16_15 = var2_2 & 1;
        if (var16_15 != 0) {
            var41_37 = 1;
        } else lbl-1000:
        // 2 sources

        {
            var41_37 = 0;
            var7_7 = null;
        }
        var42_38 = var10_10.trunLength;
        var16_15 = var42_38[var1_1];
        var16_15 = var4_4 + var16_15;
        var2_2 = var41_37;
        var43_39 = var9_9.timescale;
        var45_40 = var33_31;
        var47_41 = var31_29;
        var50_43 = var48_42 = var10_10.nextFragmentDecodeTime;
        for (var37_33 /* !! */  = (long)var4_4; var37_33 /* !! */  < var16_15; ++var37_33 /* !! */ ) {
            var32_30 = var24_22 != 0 ? var3_3.readInt() : var11_11.duration;
            var32_30 = FragmentedMp4Extractor.checkNonNegative(var32_30);
            if (var26_24 != 0) {
                var52_44 = var3_3.readInt();
                var53_45 = var24_22;
                var54_46 = var25_23;
                var24_22 = var52_44;
            } else {
                var53_45 = var24_22;
                var54_46 = var25_23;
                var24_22 = var11_11.size;
            }
            var24_22 = FragmentedMp4Extractor.checkNonNegative(var24_22);
            if (var28_26 != 0) {
                var55_47 = var3_3.readInt();
                var56_48 = var19_17;
                var57_49 = var23_21;
                var19_17 = var55_47;
            } else if (var37_33 /* !! */  == false && var19_17 != 0) {
                var56_48 = var19_17;
                var57_49 = var23_21;
                var19_17 = var39_35;
            } else {
                var56_48 = var19_17;
                var57_49 = var23_21;
                var19_17 = var11_11.flags;
            }
            if (var8_8 != 0) {
                var58_50 = var8_8;
                var59_51 = var6_6;
                var8_8 = var3_3.readInt();
                var60_52 = var26_24;
                var61_53 = var27_25;
                var62_54 = var28_26;
                var63_55 = var29_27;
                var64_56 = var8_8;
                var66_57 = 1000000L;
                var64_56 = var64_56 * var66_57 / var43_39;
                var38_34[var37_33 /* !! */ ] = var8_8 = (int)var64_56;
            } else {
                var58_50 = var8_8;
                var59_51 = var6_6;
                var60_52 = var26_24;
                var61_53 = var27_25;
                var62_54 = var28_26;
                var63_55 = var29_27;
                var38_34[var37_33 /* !! */ ] = 0;
            }
            var68_58 = 1000000L;
            var66_57 = var50_43;
            var47_41[var37_33 /* !! */ ] = var64_56 = Util.scaleLargeTimestamp(var50_43, var68_58, var43_39) - var45_40;
            var8_8 = (int)var10_10.nextFragmentDecodeTimeIncludesMoov;
            if (var8_8 == 0) {
                var64_56 = var47_41[var37_33 /* !! */ ];
                var30_28 = var5_5.moovSampleTable;
                var70_59 = var30_28.durationUs;
                var47_41[var37_33 /* !! */ ] = var64_56 += var70_59;
            }
            var20_18[var37_33 /* !! */ ] = var24_22;
            var72_60 = var19_17 >> 16;
            var8_8 = 1;
            var6_6 = 1.4E-45f;
            if ((var72_60 &= var8_8) == 0 && (var2_2 == 0 || var37_33 /* !! */  == false)) {
                var72_60 = var8_8;
            } else {
                var72_60 = 0;
                var5_5 = null;
            }
            var40_36[var37_33 /* !! */ ] = var72_60;
            var73_61 = var32_30;
            var50_43 += var73_61;
            var5_5 = var0;
            var24_22 = var53_45;
            var25_23 = var54_46;
            var19_17 = var56_48;
            var23_21 = var57_49;
            var8_8 = var58_50;
            var6_6 = var59_51;
            var26_24 = var60_52;
            var27_25 = var61_53;
            var28_26 = var62_54;
            var29_27 = var63_55;
        }
        var10_10.nextFragmentDecodeTime = var50_43;
        return var16_15;
    }

    private static void parseTruns(Atom$ContainerAtom object, FragmentedMp4Extractor$TrackBundle fragmentedMp4Extractor$TrackBundle, int n10) {
        int n11;
        int n12;
        object = ((Atom$ContainerAtom)object).leafChildren;
        int n13 = object.size();
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        int n17 = 0;
        Object object2 = null;
        while (true) {
            n12 = 1953658222;
            if (n15 >= n13) break;
            Atom$LeafAtom atom$LeafAtom = (Atom$LeafAtom)object.get(n15);
            int n18 = atom$LeafAtom.type;
            if (n18 == n12) {
                ParsableByteArray parsableByteArray = atom$LeafAtom.data;
                n11 = 12;
                parsableByteArray.setPosition(n11);
                n12 = parsableByteArray.readUnsignedIntToInt();
                if (n12 > 0) {
                    n17 += n12;
                    ++n16;
                }
            }
            ++n15;
        }
        fragmentedMp4Extractor$TrackBundle.currentTrackRunIndex = 0;
        fragmentedMp4Extractor$TrackBundle.currentSampleInTrackRun = 0;
        fragmentedMp4Extractor$TrackBundle.currentSampleIndex = 0;
        fragmentedMp4Extractor$TrackBundle.fragment.initTables(n16, n17);
        n15 = 0;
        n16 = 0;
        while (n14 < n13) {
            object2 = (Atom$LeafAtom)object.get(n14);
            n11 = ((Atom)object2).type;
            if (n11 == n12) {
                n11 = n15 + 1;
                object2 = ((Atom$LeafAtom)object2).data;
                n16 = FragmentedMp4Extractor.parseTrun(fragmentedMp4Extractor$TrackBundle, n15, n10, (ParsableByteArray)object2, n16);
                n15 = n11;
            }
            ++n14;
        }
    }

    private static void parseUuid(ParsableByteArray parsableByteArray, TrackFragment trackFragment, byte[] byArray) {
        parsableByteArray.setPosition(8);
        int n10 = 16;
        parsableByteArray.readBytes(byArray, 0, n10);
        byte[] byArray2 = PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE;
        boolean bl2 = Arrays.equals(byArray, byArray2);
        if (!bl2) {
            return;
        }
        FragmentedMp4Extractor.parseSenc(parsableByteArray, n10, trackFragment);
    }

    private void processAtomEnded(long l10) {
        Object object;
        Object object2;
        while (!(object2 = ((ArrayDeque)(object = this.containerAtoms)).isEmpty())) {
            object = (Atom$ContainerAtom)this.containerAtoms.peek();
            long l11 = ((Atom$ContainerAtom)object).endPosition;
            long l12 = l11 - l10;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2) break;
            object = (Atom$ContainerAtom)this.containerAtoms.pop();
            this.onContainerAtomRead((Atom$ContainerAtom)object);
        }
        this.enterReadingAtomHeaderState();
    }

    private boolean readAtomHeader(ExtractorInput object) {
        block16: {
            block22: {
                boolean bl2;
                block18: {
                    int n10;
                    long l10;
                    block19: {
                        block20: {
                            block21: {
                                long l11;
                                Object object2;
                                int n11;
                                int n12;
                                block17: {
                                    Object object3;
                                    long l12;
                                    n12 = this.atomHeaderBytesRead;
                                    n11 = 8;
                                    Atom$ContainerAtom atom$ContainerAtom = null;
                                    bl2 = true;
                                    if (n12 == 0) {
                                        object2 = this.atomHeader.getData();
                                        n12 = (int)(object.readFully((byte[])object2, 0, n11, bl2) ? 1 : 0);
                                        if (n12 == 0) {
                                            return false;
                                        }
                                        this.atomHeaderBytesRead = n11;
                                        this.atomHeader.setPosition(0);
                                        this.atomSize = l10 = this.atomHeader.readUnsignedInt();
                                        object2 = this.atomHeader;
                                        this.atomType = n12 = object2.readInt();
                                    }
                                    if ((n12 = (int)((l12 = (l10 = this.atomSize) - (l11 = 1L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0) {
                                        object2 = this.atomHeader.getData();
                                        object.readFully((byte[])object2, n11, n11);
                                        this.atomHeaderBytesRead = n12 = this.atomHeaderBytesRead + n11;
                                        object2 = this.atomHeader;
                                        this.atomSize = l10 = object2.readUnsignedLongToLong();
                                    } else {
                                        l11 = 0L;
                                        long l13 = l10 - l11;
                                        n12 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                                        if (n12 == 0) {
                                            l10 = object.getLength();
                                            long l14 = l10 - (l11 = (long)-1);
                                            n12 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
                                            if (n12 == 0 && (n12 = (int)((object2 = this.containerAtoms).isEmpty() ? 1 : 0)) == 0) {
                                                object2 = (Atom$ContainerAtom)this.containerAtoms.peek();
                                                l10 = object2.endPosition;
                                            }
                                            if ((n12 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1))) != 0) {
                                                l11 = object.getPosition();
                                                l10 -= l11;
                                                n12 = this.atomHeaderBytesRead;
                                                l11 = n12;
                                                this.atomSize = l10 += l11;
                                            }
                                        }
                                    }
                                    l10 = this.atomSize;
                                    l11 = this.atomHeaderBytesRead;
                                    n12 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
                                    if (n12 < 0) break block16;
                                    l10 = object.getPosition();
                                    l11 = this.atomHeaderBytesRead;
                                    l10 -= l11;
                                    n12 = this.atomType;
                                    int n13 = 1835295092;
                                    int n14 = 0x6D6F6F66;
                                    if ((n12 == n14 || n12 == n13) && (n12 = (int)(this.haveOutputSeekMap ? 1 : 0)) == 0) {
                                        object2 = this.extractorOutput;
                                        long l15 = this.durationUs;
                                        object3 = new SeekMap$Unseekable(l15, l10);
                                        object2.seekMap((SeekMap)object3);
                                        this.haveOutputSeekMap = bl2;
                                    }
                                    if ((n12 = this.atomType) == n14) {
                                        object2 = this.trackBundles;
                                        n12 = object2.size();
                                        for (n14 = 0; n14 < n12; ++n14) {
                                            object3 = ((FragmentedMp4Extractor$TrackBundle)this.trackBundles.valueAt((int)n14)).fragment;
                                            ((TrackFragment)object3).atomPosition = l10;
                                            ((TrackFragment)object3).auxiliaryDataPosition = l10;
                                            ((TrackFragment)object3).dataPosition = l10;
                                        }
                                    }
                                    n12 = this.atomType;
                                    n14 = 0;
                                    if (n12 == n13) {
                                        this.currentTrackBundle = null;
                                        long l16 = this.atomSize;
                                        this.endOfMdatPosition = l10 += l16;
                                        this.parserState = 2;
                                        return bl2;
                                    }
                                    if ((n12 = (int)(FragmentedMp4Extractor.shouldParseContainerAtom(n12) ? 1 : 0)) == 0) break block17;
                                    long l17 = object.getPosition();
                                    l10 = this.atomSize;
                                    l17 = l17 + l10 - (long)8;
                                    object = this.containerAtoms;
                                    int n15 = this.atomType;
                                    atom$ContainerAtom = new Atom$ContainerAtom(n15, l17);
                                    ((ArrayDeque)object).push(atom$ContainerAtom);
                                    l10 = this.atomSize;
                                    l11 = this.atomHeaderBytesRead;
                                    long l18 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                                    if (l18 == false) {
                                        this.processAtomEnded(l17);
                                    } else {
                                        this.enterReadingAtomHeaderState();
                                    }
                                    break block18;
                                }
                                n10 = FragmentedMp4Extractor.shouldParseLeafAtom(this.atomType);
                                l10 = Integer.MAX_VALUE;
                                if (n10 == 0) break block19;
                                n10 = this.atomHeaderBytesRead;
                                if (n10 != n11) break block20;
                                l11 = this.atomSize;
                                long l19 = l11 - l10;
                                n10 = (int)(l19 == 0L ? 0 : (l19 < 0L ? -1 : 1));
                                if (n10 > 0) break block21;
                                n12 = (int)l11;
                                object = new ParsableByteArray(n12);
                                object2 = this.atomHeader.getData();
                                byte[] byArray = ((ParsableByteArray)object).getData();
                                System.arraycopy(object2, 0, byArray, 0, n11);
                                this.atomData = object;
                                this.parserState = (int)(bl2 ? 1 : 0);
                                break block18;
                            }
                            object = new ParserException("Leaf atom with length > 2147483647 (unsupported).");
                            throw object;
                        }
                        object = new ParserException("Leaf atom defines extended atom size (unsupported).");
                        throw object;
                    }
                    long l20 = this.atomSize;
                    long l21 = l20 - l10;
                    n10 = (int)(l21 == 0L ? 0 : (l21 < 0L ? -1 : 1));
                    if (n10 > 0) break block22;
                    this.atomData = null;
                    this.parserState = (int)(bl2 ? 1 : 0);
                }
                return bl2;
            }
            object = new ParserException("Skipping atom with length > 2147483647 (unsupported).");
            throw object;
        }
        object = new ParserException("Atom size less than header length (unsupported).");
        throw object;
    }

    private void readAtomPayload(ExtractorInput extractorInput) {
        long l10 = this.atomSize;
        int n10 = (int)l10;
        int n11 = this.atomHeaderBytesRead;
        n10 -= n11;
        ParsableByteArray parsableByteArray = this.atomData;
        if (parsableByteArray != null) {
            byte[] byArray = parsableByteArray.getData();
            int n12 = 8;
            extractorInput.readFully(byArray, n12, n10);
            int n13 = this.atomType;
            Atom$LeafAtom atom$LeafAtom = new Atom$LeafAtom(n13, parsableByteArray);
            long l11 = extractorInput.getPosition();
            this.onLeafAtomRead(atom$LeafAtom, l11);
        } else {
            extractorInput.skipFully(n10);
        }
        l10 = extractorInput.getPosition();
        this.processAtomEnded(l10);
    }

    private void readEncryptionData(ExtractorInput object) {
        SparseArray sparseArray = this.trackBundles;
        int n10 = sparseArray.size();
        FragmentedMp4Extractor$TrackBundle fragmentedMp4Extractor$TrackBundle = null;
        long l10 = Long.MAX_VALUE;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11;
            long l12;
            long l13;
            TrackFragment trackFragment = ((FragmentedMp4Extractor$TrackBundle)this.trackBundles.valueAt((int)i10)).fragment;
            boolean bl2 = trackFragment.sampleEncryptionDataNeedsFill;
            if (!bl2 || (l13 = (l12 = (l11 = trackFragment.auxiliaryDataPosition) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) >= 0) continue;
            fragmentedMp4Extractor$TrackBundle = (FragmentedMp4Extractor$TrackBundle)this.trackBundles.valueAt(i10);
            l10 = l11;
        }
        if (fragmentedMp4Extractor$TrackBundle == null) {
            this.parserState = 3;
            return;
        }
        long l14 = object.getPosition();
        n10 = (int)(l10 -= l14);
        if (n10 >= 0) {
            object.skipFully(n10);
            fragmentedMp4Extractor$TrackBundle.fragment.fillEncryptionData((ExtractorInput)object);
            return;
        }
        object = new ParserException("Offset to encryption data was negative.");
        throw object;
    }

    private boolean readSample(ExtractorInput extractorInput) {
        boolean bl2;
        int n10;
        Object object;
        Object object2;
        int n11;
        Object object3;
        Object object4;
        int n12;
        long l10;
        FragmentedMp4Extractor fragmentedMp4Extractor = this;
        Object object5 = extractorInput;
        FragmentedMp4Extractor$TrackBundle fragmentedMp4Extractor$TrackBundle = this.currentTrackBundle;
        if (fragmentedMp4Extractor$TrackBundle == null) {
            fragmentedMp4Extractor$TrackBundle = FragmentedMp4Extractor.getNextTrackBundle(this.trackBundles);
            if (fragmentedMp4Extractor$TrackBundle == null) {
                long l11 = this.endOfMdatPosition;
                long l12 = extractorInput.getPosition();
                int n13 = (int)(l11 -= l12);
                if (n13 >= 0) {
                    extractorInput.skipFully(n13);
                    this.enterReadingAtomHeaderState();
                    return false;
                }
                object5 = new ParserException("Offset to end of mdat was negative.");
                throw object5;
            }
            l10 = fragmentedMp4Extractor$TrackBundle.getCurrentSampleOffset();
            long l13 = extractorInput.getPosition();
            n12 = (int)(l10 -= l13);
            if (n12 < 0) {
                object4 = "Ignoring negative offset to sample data.";
                Log.w(TAG, (String)object4);
                n12 = 0;
                object3 = null;
            }
            object5.skipFully(n12);
            fragmentedMp4Extractor.currentTrackBundle = fragmentedMp4Extractor$TrackBundle;
        }
        n12 = fragmentedMp4Extractor.parserState;
        int n14 = 0;
        object4 = null;
        int n15 = 3;
        int n16 = 4;
        int n17 = 1;
        if (n12 == n15) {
            fragmentedMp4Extractor.sampleSize = n12 = fragmentedMp4Extractor$TrackBundle.getCurrentSampleSize();
            int n18 = fragmentedMp4Extractor$TrackBundle.currentSampleIndex;
            n11 = fragmentedMp4Extractor$TrackBundle.firstSampleToOutputIndex;
            if (n18 < n11) {
                object5.skipFully(n12);
                fragmentedMp4Extractor$TrackBundle.skipSampleEncryptionData();
                boolean bl3 = fragmentedMp4Extractor$TrackBundle.next();
                if (!bl3) {
                    fragmentedMp4Extractor.currentTrackBundle = null;
                }
                fragmentedMp4Extractor.parserState = n15;
                return n17 != 0;
            }
            object2 = fragmentedMp4Extractor$TrackBundle.moovSampleTable.track;
            n18 = ((Track)object2).sampleTransformation;
            if (n18 == n17) {
                n18 = 8;
                fragmentedMp4Extractor.sampleSize = n12 -= n18;
                object5.skipFully(n18);
            }
            if ((n12 = (int)(((String)(object2 = "audio/ac4")).equals(object3 = fragmentedMp4Extractor$TrackBundle.moovSampleTable.track.format.sampleMimeType) ? 1 : 0)) != 0) {
                n12 = fragmentedMp4Extractor.sampleSize;
                n18 = 7;
                fragmentedMp4Extractor.sampleBytesWritten = n12 = fragmentedMp4Extractor$TrackBundle.outputSampleEncryptionData(n12, n18);
                n12 = fragmentedMp4Extractor.sampleSize;
                object = fragmentedMp4Extractor.scratch;
                Ac4Util.getAc4SampleHeader(n12, (ParsableByteArray)object);
                object3 = fragmentedMp4Extractor$TrackBundle.output;
                object = fragmentedMp4Extractor.scratch;
                object3.sampleData((ParsableByteArray)object, n18);
                fragmentedMp4Extractor.sampleBytesWritten = n12 = fragmentedMp4Extractor.sampleBytesWritten + n18;
            } else {
                n12 = fragmentedMp4Extractor.sampleSize;
                fragmentedMp4Extractor.sampleBytesWritten = n12 = fragmentedMp4Extractor$TrackBundle.outputSampleEncryptionData(n12, 0);
            }
            n12 = fragmentedMp4Extractor.sampleSize;
            n18 = fragmentedMp4Extractor.sampleBytesWritten;
            fragmentedMp4Extractor.sampleSize = n12 += n18;
            fragmentedMp4Extractor.parserState = n16;
            fragmentedMp4Extractor.sampleCurrentNalBytesRemaining = 0;
        }
        object3 = fragmentedMp4Extractor$TrackBundle.moovSampleTable.track;
        object2 = fragmentedMp4Extractor$TrackBundle.output;
        long l14 = fragmentedMp4Extractor$TrackBundle.getCurrentSamplePresentationTimeUs();
        TimestampAdjuster timestampAdjuster = fragmentedMp4Extractor.timestampAdjuster;
        if (timestampAdjuster != null) {
            l14 = timestampAdjuster.adjustSampleTimestamp(l14);
        }
        long l15 = l14;
        n11 = ((Track)object3).nalUnitLengthFieldLength;
        if (n11 != 0) {
            byte by2;
            object = fragmentedMp4Extractor.nalPrefix.getData();
            object[0] = 0;
            object[n17] = 0;
            object[2] = 0;
            int n19 = ((Track)object3).nalUnitLengthFieldLength;
            n10 = n19 + 1;
            n19 = 4 - n19;
            while ((by2 = fragmentedMp4Extractor.sampleBytesWritten) < (n15 = fragmentedMp4Extractor.sampleSize)) {
                Object object6;
                n15 = fragmentedMp4Extractor.sampleCurrentNalBytesRemaining;
                if (n15 == 0) {
                    object5.readFully((byte[])object, n19, n10);
                    fragmentedMp4Extractor.nalPrefix.setPosition(0);
                    object6 = fragmentedMp4Extractor.nalPrefix;
                    n15 = object6.readInt();
                    if (n15 >= n17) {
                        fragmentedMp4Extractor.sampleCurrentNalBytesRemaining = n15 += -1;
                        fragmentedMp4Extractor.nalStartCode.setPosition(0);
                        object6 = fragmentedMp4Extractor.nalStartCode;
                        object2.sampleData((ParsableByteArray)object6, n16);
                        object6 = fragmentedMp4Extractor.nalPrefix;
                        object2.sampleData((ParsableByteArray)object6, n17);
                        object6 = fragmentedMp4Extractor.ceaTrackOutputs;
                        n15 = ((TrackOutput[])object6).length;
                        if (n15 > 0 && (n15 = (int)(NalUnitUtil.isNalUnitSei((String)(object6 = object3.format.sampleMimeType), by2 = object[n16]) ? 1 : 0)) != 0) {
                            n15 = n17;
                        } else {
                            n15 = 0;
                            object6 = null;
                        }
                        fragmentedMp4Extractor.processSeiNalUnitPayload = n15;
                        fragmentedMp4Extractor.sampleBytesWritten = n15 = fragmentedMp4Extractor.sampleBytesWritten + 5;
                        fragmentedMp4Extractor.sampleSize = n15 = fragmentedMp4Extractor.sampleSize + n19;
                        n15 = 3;
                        continue;
                    }
                    object5 = new ParserException("Invalid NAL length");
                    throw object5;
                }
                by2 = (byte)(fragmentedMp4Extractor.processSeiNalUnitPayload ? 1 : 0);
                if (by2 != 0) {
                    fragmentedMp4Extractor.nalBuffer.reset(n15);
                    object6 = fragmentedMp4Extractor.nalBuffer.getData();
                    by2 = fragmentedMp4Extractor.sampleCurrentNalBytesRemaining;
                    object5.readFully((byte[])object6, 0, by2);
                    object6 = fragmentedMp4Extractor.nalBuffer;
                    by2 = fragmentedMp4Extractor.sampleCurrentNalBytesRemaining;
                    object2.sampleData((ParsableByteArray)object6, by2);
                    n15 = fragmentedMp4Extractor.sampleCurrentNalBytesRemaining;
                    Object object7 = fragmentedMp4Extractor.nalBuffer.getData();
                    n16 = fragmentedMp4Extractor.nalBuffer.limit();
                    n16 = NalUnitUtil.unescapeStream((byte[])object7, n16);
                    object7 = fragmentedMp4Extractor.nalBuffer;
                    String string2 = object3.format.sampleMimeType;
                    n14 = (int)("video/hevc".equals(string2) ? 1 : 0);
                    ((ParsableByteArray)object7).setPosition(n14);
                    fragmentedMp4Extractor.nalBuffer.setLimit(n16);
                    object4 = fragmentedMp4Extractor.nalBuffer;
                    TrackOutput[] trackOutputArray = fragmentedMp4Extractor.ceaTrackOutputs;
                    CeaUtil.consume(l15, (ParsableByteArray)object4, trackOutputArray);
                } else {
                    n15 = object2.sampleData((DataReader)object5, n15, false);
                }
                fragmentedMp4Extractor.sampleBytesWritten = n14 = fragmentedMp4Extractor.sampleBytesWritten + n15;
                fragmentedMp4Extractor.sampleCurrentNalBytesRemaining = n14 = fragmentedMp4Extractor.sampleCurrentNalBytesRemaining - n15;
                n14 = 0;
                object4 = null;
                n15 = 3;
                n16 = 4;
                n17 = 1;
            }
        } else {
            while ((n12 = fragmentedMp4Extractor.sampleBytesWritten) < (n14 = fragmentedMp4Extractor.sampleSize)) {
                n14 -= n12;
                n12 = object2.sampleData((DataReader)object5, n14, false);
                fragmentedMp4Extractor.sampleBytesWritten = n14 = fragmentedMp4Extractor.sampleBytesWritten + n12;
            }
        }
        n10 = fragmentedMp4Extractor$TrackBundle.getCurrentSampleFlags();
        object5 = fragmentedMp4Extractor$TrackBundle.getEncryptionBoxIfEncrypted();
        if (object5 != null) {
            object5 = ((TrackEncryptionBox)object5).cryptoData;
        } else {
            bl2 = false;
            object5 = null;
        }
        int n13 = fragmentedMp4Extractor.sampleSize;
        l14 = l15;
        l10 = l15;
        object2.sampleMetadata(l15, n10, n13, 0, (TrackOutput$CryptoData)object5);
        fragmentedMp4Extractor.outputPendingMetadataSamples(l15);
        bl2 = fragmentedMp4Extractor$TrackBundle.next();
        if (!bl2) {
            bl2 = false;
            object5 = null;
            fragmentedMp4Extractor.currentTrackBundle = null;
        }
        fragmentedMp4Extractor.parserState = 3;
        return true;
    }

    private static boolean shouldParseContainerAtom(int n10) {
        int n11 = 1836019574;
        n10 = n10 != n11 && n10 != (n11 = 1953653099) && n10 != (n11 = 1835297121) && n10 != (n11 = 1835626086) && n10 != (n11 = 1937007212) && n10 != (n11 = 0x6D6F6F66) && n10 != (n11 = 1953653094) && n10 != (n11 = 1836475768) && n10 != (n11 = 1701082227) ? 0 : 1;
        return n10 != 0;
    }

    private static boolean shouldParseLeafAtom(int n10) {
        int n11 = 1751411826;
        n10 = n10 != n11 && n10 != (n11 = 1835296868) && n10 != (n11 = 1836476516) && n10 != (n11 = 1936286840) && n10 != (n11 = 1937011556) && n10 != (n11 = 0x73747473) && n10 != (n11 = 1668576371) && n10 != (n11 = 1937011555) && n10 != (n11 = 1937011578) && n10 != (n11 = 1937013298) && n10 != (n11 = 1937007471) && n10 != (n11 = 1668232756) && n10 != (n11 = 0x73747373) && n10 != (n11 = 0x74666474) && n10 != (n11 = 1952868452) && n10 != (n11 = 1953196132) && n10 != (n11 = 1953654136) && n10 != (n11 = 1953658222) && n10 != (n11 = 1886614376) && n10 != (n11 = 1935763834) && n10 != (n11 = 1935763823) && n10 != (n11 = 1936027235) && n10 != (n11 = 1970628964) && n10 != (n11 = 1935828848) && n10 != (n11 = 1936158820) && n10 != (n11 = 1701606260) && n10 != (n11 = 1835362404) && n10 != (n11 = 1701671783) ? 0 : 1;
        return n10 != 0;
    }

    public void init(ExtractorOutput object) {
        this.extractorOutput = object;
        this.enterReadingAtomHeaderState();
        this.initExtraTracks();
        Object object2 = this.sideloadedTrack;
        if (object2 != null) {
            int n10 = ((Track)object2).type;
            object = object.track(0, n10);
            Track track = this.sideloadedTrack;
            long[] lArray = new long[]{};
            int[] nArray = new int[]{};
            long[] lArray2 = new long[]{};
            int[] nArray2 = new int[]{};
            long l10 = 0L;
            Object object3 = object2;
            object2 = new TrackSampleTable(track, lArray, nArray, 0, lArray2, nArray2, l10);
            object3 = new DefaultSampleValues(0, 0, 0, 0);
            FragmentedMp4Extractor$TrackBundle fragmentedMp4Extractor$TrackBundle = new FragmentedMp4Extractor$TrackBundle((TrackOutput)object, (TrackSampleTable)object2, (DefaultSampleValues)object3);
            this.trackBundles.put(0, (Object)fragmentedMp4Extractor$TrackBundle);
            object = this.extractorOutput;
            object.endTracks();
        }
    }

    public Track modifyTrack(Track track) {
        return track;
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        while (true) {
            int n10;
            if ((n10 = this.parserState) != 0) {
                int n11 = 1;
                if (n10 != n11) {
                    n11 = 2;
                    if (n10 != n11) {
                        n10 = (int)(this.readSample(extractorInput) ? 1 : 0);
                        if (n10 == 0) continue;
                        return 0;
                    }
                    this.readEncryptionData(extractorInput);
                    continue;
                }
                this.readAtomPayload(extractorInput);
                continue;
            }
            n10 = (int)(this.readAtomHeader(extractorInput) ? 1 : 0);
            if (n10 == 0) break;
        }
        return -1;
    }

    public void release() {
    }

    public void seek(long l10, long l11) {
        SparseArray sparseArray = this.trackBundles;
        int n10 = sparseArray.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            FragmentedMp4Extractor$TrackBundle fragmentedMp4Extractor$TrackBundle = (FragmentedMp4Extractor$TrackBundle)this.trackBundles.valueAt(i10);
            fragmentedMp4Extractor$TrackBundle.resetFragmentInfo();
        }
        this.pendingMetadataSampleInfos.clear();
        this.pendingMetadataSampleBytes = 0;
        this.pendingSeekTimeUs = l11;
        this.containerAtoms.clear();
        this.enterReadingAtomHeaderState();
    }

    public boolean sniff(ExtractorInput extractorInput) {
        return Sniffer.sniffFragmented(extractorInput);
    }
}

