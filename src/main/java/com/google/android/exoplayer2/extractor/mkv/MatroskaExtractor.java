/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.extractor.mkv;

import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData$SchemeData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput$CryptoData;
import com.google.android.exoplayer2.extractor.mkv.DefaultEbmlReader;
import com.google.android.exoplayer2.extractor.mkv.EbmlReader;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$InnerEbmlProcessor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$Track;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$TrueHdSampleRechunker;
import com.google.android.exoplayer2.extractor.mkv.Sniffer;
import com.google.android.exoplayer2.extractor.mkv.VarintReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.h0.e.a;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class MatroskaExtractor
implements Extractor {
    private static final int BLOCK_ADDITIONAL_ID_VP9_ITU_T_35 = 4;
    private static final int BLOCK_ADD_ID_TYPE_DVCC = 1685480259;
    private static final int BLOCK_ADD_ID_TYPE_DVVC = 1685485123;
    private static final int BLOCK_STATE_DATA = 2;
    private static final int BLOCK_STATE_HEADER = 1;
    private static final int BLOCK_STATE_START = 0;
    private static final String CODEC_ID_AAC = "A_AAC";
    private static final String CODEC_ID_AC3 = "A_AC3";
    private static final String CODEC_ID_ACM = "A_MS/ACM";
    private static final String CODEC_ID_ASS = "S_TEXT/ASS";
    private static final String CODEC_ID_AV1 = "V_AV1";
    private static final String CODEC_ID_DTS = "A_DTS";
    private static final String CODEC_ID_DTS_EXPRESS = "A_DTS/EXPRESS";
    private static final String CODEC_ID_DTS_LOSSLESS = "A_DTS/LOSSLESS";
    private static final String CODEC_ID_DVBSUB = "S_DVBSUB";
    private static final String CODEC_ID_E_AC3 = "A_EAC3";
    private static final String CODEC_ID_FLAC = "A_FLAC";
    private static final String CODEC_ID_FOURCC = "V_MS/VFW/FOURCC";
    private static final String CODEC_ID_H264 = "V_MPEG4/ISO/AVC";
    private static final String CODEC_ID_H265 = "V_MPEGH/ISO/HEVC";
    private static final String CODEC_ID_MP2 = "A_MPEG/L2";
    private static final String CODEC_ID_MP3 = "A_MPEG/L3";
    private static final String CODEC_ID_MPEG2 = "V_MPEG2";
    private static final String CODEC_ID_MPEG4_AP = "V_MPEG4/ISO/AP";
    private static final String CODEC_ID_MPEG4_ASP = "V_MPEG4/ISO/ASP";
    private static final String CODEC_ID_MPEG4_SP = "V_MPEG4/ISO/SP";
    private static final String CODEC_ID_OPUS = "A_OPUS";
    private static final String CODEC_ID_PCM_FLOAT = "A_PCM/FLOAT/IEEE";
    private static final String CODEC_ID_PCM_INT_BIG = "A_PCM/INT/BIG";
    private static final String CODEC_ID_PCM_INT_LIT = "A_PCM/INT/LIT";
    private static final String CODEC_ID_PGS = "S_HDMV/PGS";
    private static final String CODEC_ID_SUBRIP = "S_TEXT/UTF8";
    private static final String CODEC_ID_THEORA = "V_THEORA";
    private static final String CODEC_ID_TRUEHD = "A_TRUEHD";
    private static final String CODEC_ID_VOBSUB = "S_VOBSUB";
    private static final String CODEC_ID_VORBIS = "A_VORBIS";
    private static final String CODEC_ID_VP8 = "V_VP8";
    private static final String CODEC_ID_VP9 = "V_VP9";
    private static final String DOC_TYPE_MATROSKA = "matroska";
    private static final String DOC_TYPE_WEBM = "webm";
    private static final int ENCRYPTION_IV_SIZE = 8;
    public static final ExtractorsFactory FACTORY;
    public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;
    private static final int FOURCC_COMPRESSION_DIVX = 1482049860;
    private static final int FOURCC_COMPRESSION_H263 = 859189832;
    private static final int FOURCC_COMPRESSION_VC1 = 826496599;
    private static final int ID_AUDIO = 225;
    private static final int ID_AUDIO_BIT_DEPTH = 25188;
    private static final int ID_BLOCK = 161;
    private static final int ID_BLOCK_ADDITIONAL = 165;
    private static final int ID_BLOCK_ADDITIONS = 30113;
    private static final int ID_BLOCK_ADDITION_MAPPING = 16868;
    private static final int ID_BLOCK_ADD_ID = 238;
    private static final int ID_BLOCK_ADD_ID_EXTRA_DATA = 16877;
    private static final int ID_BLOCK_ADD_ID_TYPE = 16871;
    private static final int ID_BLOCK_DURATION = 155;
    private static final int ID_BLOCK_GROUP = 160;
    private static final int ID_BLOCK_MORE = 166;
    private static final int ID_CHANNELS = 159;
    private static final int ID_CLUSTER = 524531317;
    private static final int ID_CODEC_DELAY = 22186;
    private static final int ID_CODEC_ID = 134;
    private static final int ID_CODEC_PRIVATE = 25506;
    private static final int ID_COLOUR = 21936;
    private static final int ID_COLOUR_PRIMARIES = 21947;
    private static final int ID_COLOUR_RANGE = 21945;
    private static final int ID_COLOUR_TRANSFER = 21946;
    private static final int ID_CONTENT_COMPRESSION = 20532;
    private static final int ID_CONTENT_COMPRESSION_ALGORITHM = 16980;
    private static final int ID_CONTENT_COMPRESSION_SETTINGS = 16981;
    private static final int ID_CONTENT_ENCODING = 25152;
    private static final int ID_CONTENT_ENCODINGS = 28032;
    private static final int ID_CONTENT_ENCODING_ORDER = 20529;
    private static final int ID_CONTENT_ENCODING_SCOPE = 20530;
    private static final int ID_CONTENT_ENCRYPTION = 20533;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS = 18407;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE = 18408;
    private static final int ID_CONTENT_ENCRYPTION_ALGORITHM = 18401;
    private static final int ID_CONTENT_ENCRYPTION_KEY_ID = 18402;
    private static final int ID_CUES = 475249515;
    private static final int ID_CUE_CLUSTER_POSITION = 241;
    private static final int ID_CUE_POINT = 187;
    private static final int ID_CUE_TIME = 179;
    private static final int ID_CUE_TRACK_POSITIONS = 183;
    private static final int ID_DEFAULT_DURATION = 2352003;
    private static final int ID_DISPLAY_HEIGHT = 21690;
    private static final int ID_DISPLAY_UNIT = 21682;
    private static final int ID_DISPLAY_WIDTH = 21680;
    private static final int ID_DOC_TYPE = 17026;
    private static final int ID_DOC_TYPE_READ_VERSION = 17029;
    private static final int ID_DURATION = 17545;
    private static final int ID_EBML = 440786851;
    private static final int ID_EBML_READ_VERSION = 17143;
    private static final int ID_FLAG_DEFAULT = 136;
    private static final int ID_FLAG_FORCED = 21930;
    private static final int ID_INFO = 357149030;
    private static final int ID_LANGUAGE = 2274716;
    private static final int ID_LUMNINANCE_MAX = 21977;
    private static final int ID_LUMNINANCE_MIN = 21978;
    private static final int ID_MASTERING_METADATA = 21968;
    private static final int ID_MAX_BLOCK_ADDITION_ID = 21998;
    private static final int ID_MAX_CLL = 21948;
    private static final int ID_MAX_FALL = 21949;
    private static final int ID_NAME = 21358;
    private static final int ID_PIXEL_HEIGHT = 186;
    private static final int ID_PIXEL_WIDTH = 176;
    private static final int ID_PRIMARY_B_CHROMATICITY_X = 21973;
    private static final int ID_PRIMARY_B_CHROMATICITY_Y = 21974;
    private static final int ID_PRIMARY_G_CHROMATICITY_X = 21971;
    private static final int ID_PRIMARY_G_CHROMATICITY_Y = 21972;
    private static final int ID_PRIMARY_R_CHROMATICITY_X = 21969;
    private static final int ID_PRIMARY_R_CHROMATICITY_Y = 21970;
    private static final int ID_PROJECTION = 30320;
    private static final int ID_PROJECTION_POSE_PITCH = 30324;
    private static final int ID_PROJECTION_POSE_ROLL = 30325;
    private static final int ID_PROJECTION_POSE_YAW = 30323;
    private static final int ID_PROJECTION_PRIVATE = 30322;
    private static final int ID_PROJECTION_TYPE = 30321;
    private static final int ID_REFERENCE_BLOCK = 251;
    private static final int ID_SAMPLING_FREQUENCY = 181;
    private static final int ID_SEEK = 19899;
    private static final int ID_SEEK_HEAD = 290298740;
    private static final int ID_SEEK_ID = 21419;
    private static final int ID_SEEK_POSITION = 21420;
    private static final int ID_SEEK_PRE_ROLL = 22203;
    private static final int ID_SEGMENT = 408125543;
    private static final int ID_SEGMENT_INFO = 357149030;
    private static final int ID_SIMPLE_BLOCK = 163;
    private static final int ID_STEREO_MODE = 21432;
    private static final int ID_TIMECODE_SCALE = 2807729;
    private static final int ID_TIME_CODE = 231;
    private static final int ID_TRACKS = 374648427;
    private static final int ID_TRACK_ENTRY = 174;
    private static final int ID_TRACK_NUMBER = 215;
    private static final int ID_TRACK_TYPE = 131;
    private static final int ID_VIDEO = 224;
    private static final int ID_WHITE_POINT_CHROMATICITY_X = 21975;
    private static final int ID_WHITE_POINT_CHROMATICITY_Y = 21976;
    private static final int LACING_EBML = 3;
    private static final int LACING_FIXED_SIZE = 2;
    private static final int LACING_NONE = 0;
    private static final int LACING_XIPH = 1;
    private static final int OPUS_MAX_INPUT_SIZE = 5760;
    private static final byte[] SSA_DIALOGUE_FORMAT;
    private static final byte[] SSA_PREFIX;
    private static final int SSA_PREFIX_END_TIMECODE_OFFSET = 21;
    private static final String SSA_TIMECODE_FORMAT = "%01d:%02d:%02d:%02d";
    private static final long SSA_TIMECODE_LAST_VALUE_SCALING_FACTOR = 10000L;
    private static final byte[] SUBRIP_PREFIX;
    private static final int SUBRIP_PREFIX_END_TIMECODE_OFFSET = 19;
    private static final String SUBRIP_TIMECODE_FORMAT = "%02d:%02d:%02d,%03d";
    private static final long SUBRIP_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000L;
    private static final String TAG = "MatroskaExtractor";
    private static final Map TRACK_NAME_TO_ROTATION_DEGREES;
    private static final int TRACK_TYPE_AUDIO = 2;
    private static final int UNSET_ENTRY_ID = 255;
    private static final int VORBIS_MAX_INPUT_SIZE = 8192;
    private static final int WAVE_FORMAT_EXTENSIBLE = 65534;
    private static final int WAVE_FORMAT_PCM = 1;
    private static final int WAVE_FORMAT_SIZE = 18;
    private static final UUID WAVE_SUBFORMAT_PCM;
    private final ParsableByteArray blockAdditionalData;
    private int blockAdditionalId;
    private long blockDurationUs;
    private int blockFlags;
    private boolean blockHasReferenceBlock;
    private int blockSampleCount;
    private int blockSampleIndex;
    private int[] blockSampleSizes;
    private int blockState;
    private long blockTimeUs;
    private int blockTrackNumber;
    private int blockTrackNumberLength;
    private long clusterTimecodeUs;
    private LongArray cueClusterPositions;
    private LongArray cueTimesUs;
    private long cuesContentPosition;
    private MatroskaExtractor$Track currentTrack;
    private long durationTimecode;
    private long durationUs;
    private final ParsableByteArray encryptionInitializationVector;
    private final ParsableByteArray encryptionSubsampleData;
    private ByteBuffer encryptionSubsampleDataBuffer;
    private ExtractorOutput extractorOutput;
    private boolean haveOutputSample;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private final EbmlReader reader;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private boolean sampleEncodingHandled;
    private boolean sampleInitializationVectorRead;
    private int samplePartitionCount;
    private boolean samplePartitionCountRead;
    private byte sampleSignalByte;
    private boolean sampleSignalByteRead;
    private final ParsableByteArray sampleStrippedBytes;
    private final ParsableByteArray scratch;
    private int seekEntryId;
    private final ParsableByteArray seekEntryIdBytes;
    private long seekEntryPosition;
    private boolean seekForCues;
    private final boolean seekForCuesEnabled;
    private long seekPositionAfterBuildingCues;
    private boolean seenClusterPositionForCurrentCuePoint;
    private long segmentContentPosition;
    private long segmentContentSize;
    private boolean sentSeekMap;
    private final ParsableByteArray subtitleSample;
    private long timecodeScale;
    private final SparseArray tracks;
    private final VarintReader varintReader;
    private final ParsableByteArray vorbisNumPageSamples;

    static {
        Object object;
        FACTORY = a.a;
        int n10 = 32;
        byte[] byArray = object = new byte[n10];
        byte[] byArray2 = object;
        byArray[0] = 49;
        byArray2[1] = 10;
        byArray[2] = 48;
        byArray2[3] = 48;
        byArray[4] = 58;
        byArray2[5] = 48;
        byArray[6] = 48;
        byArray2[7] = 58;
        byArray[8] = 48;
        byArray2[9] = 48;
        byArray[10] = 44;
        byArray2[11] = 48;
        byArray[12] = 48;
        byArray2[13] = 48;
        byArray[14] = 32;
        byArray2[15] = 45;
        byArray[16] = 45;
        byArray2[17] = 62;
        byArray[18] = 32;
        byArray2[19] = 48;
        byArray[20] = 48;
        byArray2[21] = 58;
        byArray[22] = 48;
        byArray2[23] = 48;
        byArray[24] = 58;
        byArray2[25] = 48;
        byArray[26] = 48;
        byArray2[27] = 44;
        byArray[28] = 48;
        byArray2[29] = 48;
        byArray[30] = 48;
        byArray2[31] = 10;
        SUBRIP_PREFIX = object;
        SSA_DIALOGUE_FORMAT = Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
        Object object2 = new byte[n10];
        byte[] byArray3 = object2;
        byte[] byArray4 = object2;
        byArray3[0] = 68;
        byArray4[1] = 105;
        byArray3[2] = 97;
        byArray4[3] = 108;
        byArray3[4] = 111;
        byArray4[5] = 103;
        byArray3[6] = 117;
        byArray4[7] = 101;
        byArray3[8] = 58;
        byArray4[9] = 32;
        byArray3[10] = 48;
        byArray4[11] = 58;
        byArray3[12] = 48;
        byArray4[13] = 48;
        byArray3[14] = 58;
        byArray4[15] = 48;
        byArray3[16] = 48;
        byArray4[17] = 58;
        byArray3[18] = 48;
        byArray4[19] = 48;
        byArray3[20] = 44;
        byArray4[21] = 48;
        byArray3[22] = 58;
        byArray4[23] = 48;
        byArray3[24] = 48;
        byArray4[25] = 58;
        byArray3[26] = 48;
        byArray4[27] = 48;
        byArray3[28] = 58;
        byArray4[29] = 48;
        byArray3[30] = 48;
        byArray4[31] = 44;
        SSA_PREFIX = object2;
        object2 = new UUID;
        ((UUID)object2)(0x100000000001000L, -9223371306706625679L);
        WAVE_SUBFORMAT_PCM = object2;
        object2 = new HashMap;
        ((HashMap)object2)();
        object = 0;
        object2.put("htc_video_rotA-000", object);
        object = 90;
        object2.put("htc_video_rotA-090", object);
        object = 180;
        object2.put("htc_video_rotA-180", object);
        object = 270;
        object2.put("htc_video_rotA-270", object);
        TRACK_NAME_TO_ROTATION_DEGREES = Collections.unmodifiableMap(object2);
    }

    public MatroskaExtractor() {
        this(0);
    }

    public MatroskaExtractor(int n10) {
        DefaultEbmlReader defaultEbmlReader = new DefaultEbmlReader();
        this(defaultEbmlReader, n10);
    }

    public MatroskaExtractor(EbmlReader object, int n10) {
        Object object2;
        long l10;
        long l11;
        this.segmentContentPosition = l11 = (long)-1;
        this.timecodeScale = l10 = -9223372036854775807L;
        this.durationTimecode = l10;
        this.durationUs = l10;
        this.cuesContentPosition = l11;
        this.seekPositionAfterBuildingCues = l11;
        this.clusterTimecodeUs = l10;
        this.reader = object;
        byte[] byArray = null;
        MatroskaExtractor$InnerEbmlProcessor matroskaExtractor$InnerEbmlProcessor = new MatroskaExtractor$InnerEbmlProcessor(this, null);
        object.init(matroskaExtractor$InnerEbmlProcessor);
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object2 = null;
        }
        this.seekForCuesEnabled = n10;
        object2 = new VarintReader();
        this.varintReader = object2;
        this.tracks = object2;
        int n12 = 4;
        this.scratch = object2 = new ParsableByteArray(n12);
        byArray = ByteBuffer.allocate(n12).putInt(-1).array();
        this.vorbisNumPageSamples = object2 = new ParsableByteArray(byArray);
        this.seekEntryIdBytes = object2 = new ParsableByteArray(n12);
        byArray = NalUnitUtil.NAL_START_CODE;
        this.nalStartCode = object2 = new ParsableByteArray(byArray);
        this.nalLength = object2 = new ParsableByteArray(n12);
        this.sampleStrippedBytes = object2 = new ParsableByteArray();
        this.subtitleSample = object2 = new ParsableByteArray();
        this.encryptionInitializationVector = object2 = new ParsableByteArray(8);
        this.encryptionSubsampleData = object2 = new ParsableByteArray();
        this.blockAdditionalData = object2 = new ParsableByteArray();
        object = new int[n11];
        this.blockSampleSizes = (int[])object;
    }

    public static /* synthetic */ Extractor[] a() {
        Extractor[] extractorArray = new Extractor[1];
        MatroskaExtractor matroskaExtractor = new MatroskaExtractor();
        extractorArray[0] = matroskaExtractor;
        return extractorArray;
    }

    public static /* synthetic */ byte[] access$500() {
        return SSA_DIALOGUE_FORMAT;
    }

    public static /* synthetic */ Map access$600() {
        return TRACK_NAME_TO_ROTATION_DEGREES;
    }

    public static /* synthetic */ UUID access$700() {
        return WAVE_SUBFORMAT_PCM;
    }

    private void assertInCues(int n10) {
        Object object = this.cueTimesUs;
        if (object != null && (object = this.cueClusterPositions) != null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Element ");
        stringBuilder.append(n10);
        stringBuilder.append(" must be in a Cues");
        String string2 = stringBuilder.toString();
        object = new ParserException(string2);
        throw object;
    }

    private void assertInTrackEntry(int n10) {
        Object object = this.currentTrack;
        if (object != null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(43);
        stringBuilder.append("Element ");
        stringBuilder.append(n10);
        stringBuilder.append(" must be in a TrackEntry");
        String string2 = stringBuilder.toString();
        object = new ParserException(string2);
        throw object;
    }

    private void assertInitialized() {
        Assertions.checkStateNotNull(this.extractorOutput);
    }

    private SeekMap buildSeekMap(LongArray object, LongArray object2) {
        int n10;
        long l10;
        long l11 = this.segmentContentPosition;
        long l12 = -1;
        long l13 = l11 - l12;
        Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object3 != false && (object3 = (l10 = (l11 = this.durationUs) - (l12 = -9223372036854775807L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false && object != null && (object3 = (Object)((LongArray)object).size()) != false && object2 != null && (object3 = (Object)((LongArray)object2).size()) == (n10 = ((LongArray)object).size())) {
            int n11;
            long l14;
            long l15;
            object3 = ((LongArray)object).size();
            int[] nArray = new int[object3];
            long[] lArray = new long[object3];
            long[] lArray2 = new long[object3];
            long[] lArray3 = new long[object3];
            int n12 = 0;
            for (int i10 = 0; i10 < object3; ++i10) {
                lArray3[i10] = l15 = ((LongArray)object).get(i10);
                l15 = this.segmentContentPosition;
                long l16 = ((LongArray)object2).get(i10);
                lArray[i10] = l15 += l16;
            }
            while (n12 < (l14 = object3 + -1)) {
                l14 = n12 + 1;
                long l17 = lArray[l14];
                long l18 = lArray[n12];
                nArray[n12] = n11 = (int)(l17 - l18);
                l17 = lArray3[l14];
                l18 = lArray3[n12];
                lArray2[n12] = l17 -= l18;
                n12 = (int)l14;
            }
            long l19 = this.segmentContentPosition;
            l15 = this.segmentContentSize;
            l19 += l15;
            l15 = lArray[l14];
            nArray[l14] = n11 = (int)(l19 - l15);
            l19 = this.durationUs;
            l15 = lArray3[l14];
            lArray2[l14] = l19 -= l15;
            l19 = lArray2[l14];
            l15 = 0L;
            long l20 = l19 - l15;
            n11 = (int)(l20 == 0L ? 0 : (l20 < 0L ? -1 : 1));
            if (n11 <= 0) {
                n11 = 72;
                CharSequence charSequence = new StringBuilder(n11);
                charSequence.append("Discarding last cue point with unexpected duration: ");
                charSequence.append(l19);
                object2 = charSequence.toString();
                charSequence = TAG;
                Log.w((String)charSequence, (String)object2);
                nArray = Arrays.copyOf(nArray, (int)l14);
                lArray = Arrays.copyOf(lArray, (int)l14);
                lArray2 = Arrays.copyOf(lArray2, (int)l14);
                lArray3 = Arrays.copyOf(lArray3, (int)l14);
            }
            object = new ChunkIndex(nArray, lArray, lArray2, lArray3);
            return object;
        }
        l11 = this.durationUs;
        object = new SeekMap$Unseekable(l11);
        return object;
    }

    /*
     * WARNING - void declaration
     */
    private void commitSampleToOutput(MatroskaExtractor$Track matroskaExtractor$Track, long l10, int n10, int n11, int n12) {
        Object object = matroskaExtractor$Track.trueHdSampleRechunker;
        int n13 = 1;
        if (object != null) {
            MatroskaExtractor$Track matroskaExtractor$Track2 = matroskaExtractor$Track;
            long l11 = l10;
            ((MatroskaExtractor$TrueHdSampleRechunker)object).sampleMetadata(matroskaExtractor$Track, l10, n10, n11, n12);
        } else {
            int n14;
            int n15;
            boolean bl2;
            Object object2 = CODEC_ID_SUBRIP;
            object = matroskaExtractor$Track.codecId;
            boolean n152 = ((String)object2).equals(object);
            if (n152 || (bl2 = ((String)(object2 = CODEC_ID_ASS)).equals(object = matroskaExtractor$Track.codecId))) {
                int n16 = this.blockSampleCount;
                object2 = TAG;
                if (n16 > n13) {
                    object = "Skipping subtitle sample in laced block.";
                    Log.w((String)object2, (String)object);
                } else {
                    long l12 = this.blockDurationUs;
                    long l11 = -9223372036854775807L;
                    long l13 = l12 - l11;
                    Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                    if (object3 == false) {
                        object = "Skipping subtitle sample with no duration.";
                        Log.w((String)object2, (String)object);
                    } else {
                        Object object4;
                        void var12_17;
                        object = matroskaExtractor$Track.codecId;
                        object2 = this.subtitleSample.getData();
                        MatroskaExtractor.setSubtitleEndTime((String)object, l12, (byte[])object2);
                        object = this.subtitleSample;
                        int n17 = ((ParsableByteArray)object).getPosition();
                        while (++var12_17 < (object4 = ((ParsableByteArray)(object2 = this.subtitleSample)).limit())) {
                            object2 = this.subtitleSample.getData();
                            object4 = object2[var12_17];
                            if (object4 != 0) continue;
                            object2 = this.subtitleSample;
                            ((ParsableByteArray)object2).setLimit((int)var12_17);
                            break;
                        }
                        object = matroskaExtractor$Track.output;
                        object2 = this.subtitleSample;
                        int n18 = ((ParsableByteArray)object2).limit();
                        object.sampleData((ParsableByteArray)object2, n18);
                        object = this.subtitleSample;
                        int n19 = ((ParsableByteArray)object).limit();
                        n11 += n19;
                    }
                }
            }
            if ((n15 = 0x10000000 & n10) != 0) {
                int n20 = this.blockSampleCount;
                if (n20 > n13) {
                    int n21 = -268435457;
                    n10 &= n21;
                } else {
                    object = this.blockAdditionalData;
                    int n22 = ((ParsableByteArray)object).limit();
                    object2 = matroskaExtractor$Track.output;
                    ParsableByteArray parsableByteArray = this.blockAdditionalData;
                    n14 = 2;
                    object2.sampleData(parsableByteArray, n22, n14);
                    n11 += n22;
                }
            }
            n14 = n10;
            object = matroskaExtractor$Track.output;
            TrackOutput$CryptoData trackOutput$CryptoData = matroskaExtractor$Track.cryptoData;
            object.sampleMetadata(l10, n10, n11, n12, trackOutput$CryptoData);
        }
        this.haveOutputSample = n13;
    }

    private static int[] ensureArrayCapacity(int[] nArray, int n10) {
        if (nArray == null) {
            return new int[n10];
        }
        int n11 = nArray.length;
        if (n11 >= n10) {
            return nArray;
        }
        return new int[Math.max(nArray.length * 2, n10)];
    }

    private int finishWriteSampleData() {
        int n10 = this.sampleBytesWritten;
        this.resetWriteSampleData();
        return n10;
    }

    private static byte[] formatSubtitleTimecode(long l10, String string2, long l11) {
        Integer n10;
        long l12 = -9223372036854775807L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        int n11 = 1;
        if (l13 != false) {
            l13 = n11;
        } else {
            l13 = 0;
            n10 = null;
        }
        Assertions.checkArgument((boolean)l13);
        l13 = (int)(l10 / 3600000000L);
        long l14 = l13 * 3600;
        long l15 = 1000000L;
        int n12 = (int)((l10 -= (l14 *= l15)) / 60000000L);
        long l16 = (long)(n12 * 60) * l15;
        int n13 = (int)((l10 -= l16) / l15);
        l16 = (long)n13 * l15;
        int n14 = (int)((l10 - l16) / l11);
        Locale locale = Locale.US;
        Object[] objectArray = new Object[4];
        Integer n15 = (int)l13;
        objectArray[0] = n15;
        n15 = n12;
        objectArray[n11] = n15;
        n10 = n13;
        objectArray[2] = n10;
        Integer n16 = n14;
        objectArray[3] = n16;
        return Util.getUtf8Bytes(String.format(locale, string2, objectArray));
    }

    private MatroskaExtractor$Track getCurrentTrack(int n10) {
        this.assertInTrackEntry(n10);
        return this.currentTrack;
    }

    private static boolean isCodecSupported(String string2) {
        string2.hashCode();
        int n10 = string2.hashCode();
        int n11 = 1;
        int n12 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 1951062397: {
                String string3 = CODEC_ID_OPUS;
                boolean bl2 = string2.equals(string3);
                if (!bl2) break;
                n12 = 31;
                break;
            }
            case 1950789798: {
                String string4 = CODEC_ID_FLAC;
                boolean bl3 = string2.equals(string4);
                if (!bl3) break;
                n12 = 30;
                break;
            }
            case 1950749482: {
                String string5 = CODEC_ID_E_AC3;
                boolean bl4 = string2.equals(string5);
                if (!bl4) break;
                n12 = 29;
                break;
            }
            case 1809237540: {
                String string6 = CODEC_ID_MPEG2;
                boolean bl5 = string2.equals(string6);
                if (!bl5) break;
                n12 = 28;
                break;
            }
            case 1422270023: {
                String string7 = CODEC_ID_SUBRIP;
                boolean bl6 = string2.equals(string7);
                if (!bl6) break;
                n12 = 27;
                break;
            }
            case 855502857: {
                String string8 = CODEC_ID_H265;
                boolean bl7 = string2.equals(string8);
                if (!bl7) break;
                n12 = 26;
                break;
            }
            case 738597099: {
                String string9 = CODEC_ID_ASS;
                boolean bl8 = string2.equals(string9);
                if (!bl8) break;
                n12 = 25;
                break;
            }
            case 725957860: {
                String string10 = CODEC_ID_PCM_INT_LIT;
                boolean bl9 = string2.equals(string10);
                if (!bl9) break;
                n12 = 24;
                break;
            }
            case 725948237: {
                String string11 = CODEC_ID_PCM_INT_BIG;
                boolean bl10 = string2.equals(string11);
                if (!bl10) break;
                n12 = 23;
                break;
            }
            case 635596514: {
                String string12 = CODEC_ID_PCM_FLOAT;
                boolean bl11 = string2.equals(string12);
                if (!bl11) break;
                n12 = 22;
                break;
            }
            case 542569478: {
                String string13 = CODEC_ID_DTS_EXPRESS;
                boolean bl12 = string2.equals(string13);
                if (!bl12) break;
                n12 = 21;
                break;
            }
            case 444813526: {
                String string14 = CODEC_ID_THEORA;
                boolean bl13 = string2.equals(string14);
                if (!bl13) break;
                n12 = 20;
                break;
            }
            case 99146302: {
                String string15 = CODEC_ID_PGS;
                boolean bl14 = string2.equals(string15);
                if (!bl14) break;
                n12 = 19;
                break;
            }
            case 82338134: {
                String string16 = CODEC_ID_VP9;
                boolean bl15 = string2.equals(string16);
                if (!bl15) break;
                n12 = 18;
                break;
            }
            case 82338133: {
                String string17 = CODEC_ID_VP8;
                boolean bl16 = string2.equals(string17);
                if (!bl16) break;
                n12 = 17;
                break;
            }
            case 82318131: {
                String string18 = CODEC_ID_AV1;
                boolean bl17 = string2.equals(string18);
                if (!bl17) break;
                n12 = 16;
                break;
            }
            case 62927045: {
                String string19 = CODEC_ID_DTS;
                boolean bl18 = string2.equals(string19);
                if (!bl18) break;
                n12 = 15;
                break;
            }
            case 62923603: {
                String string20 = CODEC_ID_AC3;
                boolean bl19 = string2.equals(string20);
                if (!bl19) break;
                n12 = 14;
                break;
            }
            case 62923557: {
                String string21 = CODEC_ID_AAC;
                boolean bl20 = string2.equals(string21);
                if (!bl20) break;
                n12 = 13;
                break;
            }
            case -356037306: {
                String string22 = CODEC_ID_DTS_LOSSLESS;
                boolean bl21 = string2.equals(string22);
                if (!bl21) break;
                n12 = 12;
                break;
            }
            case -425012669: {
                String string23 = CODEC_ID_VOBSUB;
                boolean bl22 = string2.equals(string23);
                if (!bl22) break;
                n12 = 11;
                break;
            }
            case -538363109: {
                String string24 = CODEC_ID_H264;
                boolean bl23 = string2.equals(string24);
                if (!bl23) break;
                n12 = 10;
                break;
            }
            case -538363189: {
                String string25 = CODEC_ID_MPEG4_ASP;
                boolean bl24 = string2.equals(string25);
                if (!bl24) break;
                n12 = 9;
                break;
            }
            case -933872740: {
                String string26 = CODEC_ID_DVBSUB;
                boolean bl25 = string2.equals(string26);
                if (!bl25) break;
                n12 = 8;
                break;
            }
            case -1373388978: {
                String string27 = CODEC_ID_FOURCC;
                boolean bl26 = string2.equals(string27);
                if (!bl26) break;
                n12 = 7;
                break;
            }
            case -1482641357: {
                String string28 = CODEC_ID_MP3;
                boolean bl27 = string2.equals(string28);
                if (!bl27) break;
                n12 = 6;
                break;
            }
            case -1482641358: {
                String string29 = CODEC_ID_MP2;
                boolean bl28 = string2.equals(string29);
                if (!bl28) break;
                n12 = 5;
                break;
            }
            case -1730367663: {
                String string30 = CODEC_ID_VORBIS;
                boolean bl29 = string2.equals(string30);
                if (!bl29) break;
                n12 = 4;
                break;
            }
            case -1784763192: {
                String string31 = CODEC_ID_TRUEHD;
                boolean bl30 = string2.equals(string31);
                if (!bl30) break;
                n12 = 3;
                break;
            }
            case -1985379776: {
                String string32 = CODEC_ID_ACM;
                boolean bl31 = string2.equals(string32);
                if (!bl31) break;
                n12 = 2;
                break;
            }
            case -2095575984: {
                String string33 = CODEC_ID_MPEG4_SP;
                boolean bl32 = string2.equals(string33);
                if (!bl32) break;
                n12 = n11;
                break;
            }
            case -2095576542: {
                String string34 = CODEC_ID_MPEG4_AP;
                boolean bl33 = string2.equals(string34);
                if (!bl33) break;
                n12 = 0;
            }
        }
        switch (n12) {
            default: {
                return false;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 31: 
        }
        return n11 != 0;
    }

    private boolean maybeSeekForCues(PositionHolder positionHolder, long l10) {
        long l11;
        long l12;
        boolean bl2 = this.seekForCues;
        boolean bl3 = true;
        if (bl2) {
            this.seekPositionAfterBuildingCues = l10;
            positionHolder.position = l10 = this.cuesContentPosition;
            this.seekForCues = false;
            return bl3;
        }
        boolean bl4 = this.sentSeekMap;
        if (bl4 && (bl2 = (l12 = (l10 = this.seekPositionAfterBuildingCues) - (l11 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            positionHolder.position = l10;
            this.seekPositionAfterBuildingCues = l11;
            return bl3;
        }
        return false;
    }

    private void readScratch(ExtractorInput extractorInput, int n10) {
        int n11;
        Object object = this.scratch;
        int n12 = ((ParsableByteArray)object).limit();
        if (n12 >= n10) {
            return;
        }
        object = this.scratch;
        n12 = ((ParsableByteArray)object).capacity();
        if (n12 < n10) {
            object = this.scratch;
            n11 = Math.max(((ParsableByteArray)object).capacity() * 2, n10);
            ((ParsableByteArray)object).ensureCapacity(n11);
        }
        object = this.scratch.getData();
        n11 = this.scratch.limit();
        int n13 = this.scratch.limit();
        n13 = n10 - n13;
        extractorInput.readFully((byte[])object, n11, n13);
        this.scratch.setLimit(n10);
    }

    private void resetWriteSampleData() {
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.sampleEncodingHandled = false;
        this.sampleSignalByteRead = false;
        this.samplePartitionCountRead = false;
        this.samplePartitionCount = 0;
        this.sampleSignalByte = 0;
        this.sampleInitializationVectorRead = false;
        this.sampleStrippedBytes.reset(0);
    }

    private long scaleTimecodeToUs(long l10) {
        long l11 = this.timecodeScale;
        long l12 = -9223372036854775807L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false) {
            l12 = l10;
            return Util.scaleLargeTimestamp(l10, l11, 1000L);
        }
        ParserException parserException = new ParserException("Can't scale timecode prior to timecodeScale being set.");
        throw parserException;
    }

    private static void setSubtitleEndTime(String object, long l10, byte[] byArray) {
        int n10;
        ((String)object).hashCode();
        String string2 = CODEC_ID_ASS;
        boolean n11 = ((String)object).equals(string2);
        if (!n11) {
            string2 = CODEC_ID_SUBRIP;
            boolean bl2 = ((String)object).equals(string2);
            if (!bl2) {
                object = new IllegalArgumentException();
                throw object;
            }
            long l12 = 1000L;
            object = MatroskaExtractor.formatSubtitleTimecode(l10, SUBRIP_TIMECODE_FORMAT, l12);
            n10 = 19;
        } else {
            long l11 = 10000L;
            object = MatroskaExtractor.formatSubtitleTimecode(l10, SSA_TIMECODE_FORMAT, l11);
            n10 = 21;
        }
        int n12 = ((Object)object).length;
        System.arraycopy(object, 0, byArray, n10, n12);
    }

    /*
     * WARNING - void declaration
     */
    private int writeSampleData(ExtractorInput object, MatroskaExtractor$Track object2, int n10) {
        int n11;
        boolean bl2;
        Object object3;
        short s10;
        int n12;
        Object object4 = CODEC_ID_SUBRIP;
        Object object5 = ((MatroskaExtractor$Track)object2).codecId;
        boolean bl22 = ((String)object4).equals(object5);
        if (bl22) {
            object2 = SUBRIP_PREFIX;
            this.writeSubtitleSampleData((ExtractorInput)object, (byte[])object2, n10);
            return this.finishWriteSampleData();
        }
        object4 = CODEC_ID_ASS;
        object5 = ((MatroskaExtractor$Track)object2).codecId;
        bl22 = ((String)object4).equals(object5);
        if (bl22) {
            object2 = SSA_PREFIX;
            this.writeSubtitleSampleData((ExtractorInput)object, (byte[])object2, n10);
            return this.finishWriteSampleData();
        }
        object5 = ((MatroskaExtractor$Track)object2).output;
        boolean s102 = this.sampleEncodingHandled;
        int n13 = 4;
        int n14 = 2;
        short s11 = 1;
        if (!s102) {
            int n15;
            boolean bl3 = ((MatroskaExtractor$Track)object2).hasContentEncryption;
            if (bl3) {
                Object object6;
                byte by2;
                int n16;
                this.blockFlags = n16 = this.blockFlags & 0xBFFFFFFF;
                boolean bl4 = this.sampleSignalByteRead;
                n12 = 128;
                if (!bl4) {
                    int n17;
                    object4 = this.scratch.getData();
                    object.readFully((byte[])object4, 0, s11);
                    this.sampleBytesRead = n17 = this.sampleBytesRead + s11;
                    object4 = this.scratch.getData();
                    int n18 = object4[0] & n12;
                    if (n18 != n12) {
                        object4 = this.scratch.getData();
                        Object object7 = object4[0];
                        this.sampleSignalByte = (byte)object7;
                        this.sampleSignalByteRead = s11;
                    } else {
                        object = new ParserException("Extension bit is set in signal byte");
                        throw object;
                    }
                }
                if ((s10 = (by2 = this.sampleSignalByte) & 1) == s11) {
                    s10 = s11;
                } else {
                    s10 = 0;
                    object6 = null;
                }
                if (s10 != 0) {
                    void var7_18;
                    int n19 = by2 & n14;
                    if (n19 == n14) {
                        short s12 = s11;
                    } else {
                        boolean bl5 = false;
                        object4 = null;
                    }
                    s10 = this.blockFlags;
                    short s13 = 0x40000000;
                    this.blockFlags = s10 |= s13;
                    s10 = (short)(this.sampleInitializationVectorRead ? 1 : 0);
                    if (s10 == 0) {
                        object6 = this.encryptionInitializationVector.getData();
                        s13 = 8;
                        object.readFully((byte[])object6, 0, s13);
                        s10 = this.sampleBytesRead + s13;
                        this.sampleBytesRead = s10;
                        this.sampleInitializationVectorRead = s11;
                        object6 = this.scratch.getData();
                        if (var7_18 == false) {
                            n12 = 0;
                            object3 = null;
                        }
                        object6[0] = n12 = (int)((byte)(n12 | s13));
                        this.scratch.setPosition(0);
                        object3 = this.scratch;
                        object5.sampleData((ParsableByteArray)object3, (int)s11, s11);
                        this.sampleBytesWritten = n12 = this.sampleBytesWritten + s11;
                        this.encryptionInitializationVector.setPosition(0);
                        object3 = this.encryptionInitializationVector;
                        object5.sampleData((ParsableByteArray)object3, (int)s13, s11);
                        this.sampleBytesWritten = n12 = this.sampleBytesWritten + s13;
                    }
                    if (var7_18 != false) {
                        int n20;
                        void var7_25;
                        boolean bl6 = this.samplePartitionCountRead;
                        if (!bl6) {
                            int n21;
                            int n22;
                            object4 = this.scratch.getData();
                            object.readFully((byte[])object4, 0, s11);
                            this.sampleBytesRead = n22 = this.sampleBytesRead + s11;
                            this.scratch.setPosition(0);
                            object4 = this.scratch;
                            this.samplePartitionCount = n21 = ((ParsableByteArray)object4).readUnsignedByte();
                            this.samplePartitionCountRead = s11;
                        }
                        int n23 = this.samplePartitionCount * n13;
                        this.scratch.reset(n23);
                        object3 = this.scratch.getData();
                        object.readFully((byte[])object3, 0, n23);
                        this.sampleBytesRead = n12 = this.sampleBytesRead + n23;
                        short s14 = (short)(this.samplePartitionCount / n14 + s11);
                        n12 = s14 * 6 + n14;
                        object6 = this.encryptionSubsampleDataBuffer;
                        if (object6 == null || (s10 = object6.capacity()) < n12) {
                            object6 = ByteBuffer.allocate(n12);
                            this.encryptionSubsampleDataBuffer = object6;
                        }
                        this.encryptionSubsampleDataBuffer.position(0);
                        this.encryptionSubsampleDataBuffer.putShort(s14);
                        boolean bl7 = false;
                        object4 = null;
                        s10 = 0;
                        object6 = null;
                        while (++var7_25 < (s13 = this.samplePartitionCount)) {
                            ByteBuffer byteBuffer;
                            ParsableByteArray parsableByteArray = this.scratch;
                            s13 = parsableByteArray.readUnsignedIntToInt();
                            void var17_47 = var7_25 % 2;
                            if (var17_47 == false) {
                                byteBuffer = this.encryptionSubsampleDataBuffer;
                                s10 = (short)(s13 - s10);
                                byteBuffer.putShort(s10);
                            } else {
                                byteBuffer = this.encryptionSubsampleDataBuffer;
                                s10 = s13 - s10;
                                byteBuffer.putInt(s10);
                            }
                            s10 = s13;
                        }
                        int n25 = this.sampleBytesRead;
                        n25 = n10 - n25 - s10;
                        if ((s13 %= n14) == s11) {
                            object6 = this.encryptionSubsampleDataBuffer;
                            object6.putInt(n25);
                        } else {
                            object6 = this.encryptionSubsampleDataBuffer;
                            short s15 = (short)n25;
                            object6.putShort(s15);
                            object4 = this.encryptionSubsampleDataBuffer;
                            ((ByteBuffer)object4).putInt(0);
                        }
                        object4 = this.encryptionSubsampleData;
                        object6 = this.encryptionSubsampleDataBuffer.array();
                        ((ParsableByteArray)object4).reset((byte[])object6, n12);
                        object4 = this.encryptionSubsampleData;
                        object5.sampleData((ParsableByteArray)object4, n12, s11);
                        this.sampleBytesWritten = n20 = this.sampleBytesWritten + n12;
                    }
                }
            } else {
                object4 = ((MatroskaExtractor$Track)object2).sampleStrippedBytes;
                if (object4 != null) {
                    object3 = this.sampleStrippedBytes;
                    s10 = ((Object)object4).length;
                    ((ParsableByteArray)object3).reset((byte[])object4, s10);
                }
            }
            if ((n15 = ((MatroskaExtractor$Track)object2).maxBlockAdditionId) > 0) {
                int n26;
                int n27;
                this.blockFlags = n27 = this.blockFlags | 0x10000000;
                this.blockAdditionalData.reset(0);
                this.scratch.reset(n13);
                object4 = this.scratch.getData();
                n12 = (byte)(n10 >> 24 & 0xFF);
                object4[0] = n12;
                object4 = this.scratch.getData();
                n12 = (byte)(n10 >> 16 & 0xFF);
                object4[s11] = n12;
                object4 = this.scratch.getData();
                n12 = (byte)(n10 >> 8 & 0xFF);
                object4[n14] = n12;
                object4 = this.scratch.getData();
                n12 = 3;
                s10 = (byte)(n10 & 0xFF);
                object4[n12] = s10;
                object4 = this.scratch;
                object5.sampleData((ParsableByteArray)object4, n13, n14);
                this.sampleBytesWritten = n26 = this.sampleBytesWritten + n13;
            }
            this.sampleEncodingHandled = s11;
        }
        int n28 = this.sampleStrippedBytes.limit();
        n10 += n28;
        object3 = CODEC_ID_H264;
        object4 = ((MatroskaExtractor$Track)object2).codecId;
        boolean bl8 = ((String)object3).equals(object4);
        if (!bl8 && !(bl2 = ((String)(object3 = CODEC_ID_H265)).equals(object4 = ((MatroskaExtractor$Track)object2).codecId))) {
            int n29;
            object4 = ((MatroskaExtractor$Track)object2).trueHdSampleRechunker;
            if (object4 != null) {
                object4 = this.sampleStrippedBytes;
                int n30 = ((ParsableByteArray)object4).limit();
                if (n30 != 0) {
                    s11 = 0;
                }
                Assertions.checkState(s11 != 0);
                object4 = ((MatroskaExtractor$Track)object2).trueHdSampleRechunker;
                ((MatroskaExtractor$TrueHdSampleRechunker)object4).startSample((ExtractorInput)object);
            }
            while ((n29 = this.sampleBytesRead) < n10) {
                int n29 = n10 - n29;
                n29 = this.writeToOutput((ExtractorInput)object, (TrackOutput)object5, n29);
                this.sampleBytesRead = n14 = this.sampleBytesRead + n29;
                this.sampleBytesWritten = n14 = this.sampleBytesWritten + n29;
            }
        } else {
            object4 = this.nalLength.getData();
            object4[0] = false;
            object4[s11] = false;
            object4[n14] = false;
            n14 = ((MatroskaExtractor$Track)object2).nalUnitLengthFieldLength;
            s11 = 4 - n14;
            while ((n12 = this.sampleBytesRead) < n10) {
                n12 = this.sampleCurrentNalBytesRemaining;
                if (n12 == 0) {
                    this.writeToTarget((ExtractorInput)object, (byte[])object4, s11, n14);
                    this.sampleBytesRead = n12 = this.sampleBytesRead + n14;
                    this.nalLength.setPosition(0);
                    this.sampleCurrentNalBytesRemaining = n12 = this.nalLength.readUnsignedIntToInt();
                    this.nalStartCode.setPosition(0);
                    object3 = this.nalStartCode;
                    object5.sampleData((ParsableByteArray)object3, n13);
                    this.sampleBytesWritten = n12 = this.sampleBytesWritten + n13;
                    continue;
                }
                n12 = this.writeToOutput((ExtractorInput)object, (TrackOutput)object5, n12);
                s10 = this.sampleBytesRead + n12;
                this.sampleBytesRead = s10;
                s10 = this.sampleBytesWritten + n12;
                this.sampleBytesWritten = s10;
                s10 = this.sampleCurrentNalBytesRemaining - n12;
                this.sampleCurrentNalBytesRemaining = s10;
            }
        }
        if ((n11 = ((String)(object2 = CODEC_ID_VORBIS)).equals(object = ((MatroskaExtractor$Track)object2).codecId)) != 0) {
            this.vorbisNumPageSamples.setPosition(0);
            object = this.vorbisNumPageSamples;
            object5.sampleData((ParsableByteArray)object, n13);
            this.sampleBytesWritten = n11 = this.sampleBytesWritten + n13;
        }
        return this.finishWriteSampleData();
    }

    private void writeSubtitleSampleData(ExtractorInput extractorInput, byte[] byArray, int n10) {
        int n11 = byArray.length + n10;
        Object object = this.subtitleSample;
        int n12 = ((ParsableByteArray)object).capacity();
        if (n12 < n11) {
            object = this.subtitleSample;
            int n13 = n11 + n10;
            byte[] byArray2 = Arrays.copyOf(byArray, n13);
            ((ParsableByteArray)object).reset(byArray2);
        } else {
            object = this.subtitleSample.getData();
            int n14 = byArray.length;
            System.arraycopy(byArray, 0, object, 0, n14);
        }
        object = this.subtitleSample.getData();
        int n15 = byArray.length;
        extractorInput.readFully((byte[])object, n15, n10);
        this.subtitleSample.setPosition(0);
        this.subtitleSample.setLimit(n11);
    }

    private int writeToOutput(ExtractorInput extractorInput, TrackOutput trackOutput, int n10) {
        int n11;
        ParsableByteArray parsableByteArray = this.sampleStrippedBytes;
        int n12 = parsableByteArray.bytesLeft();
        if (n12 > 0) {
            n11 = Math.min(n10, n12);
            ParsableByteArray parsableByteArray2 = this.sampleStrippedBytes;
            trackOutput.sampleData(parsableByteArray2, n11);
        } else {
            n12 = 0;
            parsableByteArray = null;
            n11 = trackOutput.sampleData(extractorInput, n10, false);
        }
        return n11;
    }

    private void writeToTarget(ExtractorInput object, byte[] byArray, int n10, int n11) {
        ParsableByteArray parsableByteArray = this.sampleStrippedBytes;
        int n12 = parsableByteArray.bytesLeft();
        n12 = Math.min(n11, n12);
        int n13 = n10 + n12;
        object.readFully(byArray, n13, n11 -= n12);
        if (n12 > 0) {
            object = this.sampleStrippedBytes;
            ((ParsableByteArray)object).readBytes(byArray, n10, n12);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void binaryElement(int var1_1, int var2_2, ExtractorInput var3_3) {
        block26: {
            block33: {
                block27: {
                    block32: {
                        block29: {
                            block31: {
                                block30: {
                                    block28: {
                                        block20: {
                                            block21: {
                                                block22: {
                                                    block23: {
                                                        block24: {
                                                            block25: {
                                                                var4_4 = this;
                                                                var5_5 = var1_1;
                                                                var6_6 = var2_2;
                                                                var7_7 = var3_3;
                                                                var8_8 = 161;
                                                                var9_9 = 163;
                                                                var10_10 = 2;
                                                                var11_11 = 1;
                                                                if (var1_1 == var8_8 || var1_1 == var9_9) break block20;
                                                                var8_8 = 165;
                                                                if (var1_1 == var8_8) break block21;
                                                                var8_8 = 16877;
                                                                if (var1_1 == var8_8) break block22;
                                                                var8_8 = 16981;
                                                                if (var1_1 == var8_8) break block23;
                                                                var8_8 = 18402;
                                                                if (var1_1 == var8_8) break block24;
                                                                var8_8 = 21419;
                                                                if (var1_1 == var8_8) break block25;
                                                                var8_8 = 25506;
                                                                if (var1_1 == var8_8) ** GOTO lbl38
                                                                var8_8 = 30322;
                                                                if (var1_1 == var8_8) {
                                                                    this.assertInTrackEntry(var1_1);
                                                                    var12_12 = this.currentTrack;
                                                                    var13_24 = new byte[var2_2];
                                                                    var12_12.projectionData = var13_24;
                                                                    var3_3.readFully(var13_24, 0, var2_2);
                                                                } else {
                                                                    var15_33 = new StringBuilder(26);
                                                                    var15_33.append("Unexpected id: ");
                                                                    var15_33.append(var1_1);
                                                                    var12_13 = var15_33.toString();
                                                                    var14_29 = new ParserException(var12_13);
                                                                    throw var14_29;
lbl38:
                                                                    // 1 sources

                                                                    this.assertInTrackEntry(var1_1);
                                                                    var12_14 = this.currentTrack;
                                                                    var13_25 = new byte[var2_2];
                                                                    var12_14.codecPrivate = var13_25;
                                                                    var3_3.readFully(var13_25, 0, var2_2);
                                                                }
                                                                break block26;
                                                            }
                                                            Arrays.fill(this.seekEntryIdBytes.getData(), (byte)0);
                                                            var12_15 = this.seekEntryIdBytes.getData();
                                                            var8_8 = 4 - var2_2;
                                                            var3_3.readFully((byte[])var12_15, var8_8, var2_2);
                                                            this.seekEntryIdBytes.setPosition(0);
                                                            var12_15 = this.seekEntryIdBytes;
                                                            var16_34 = var12_15.readUnsignedInt();
                                                            this.seekEntryId = var5_5 = (int)var16_34;
                                                            break block26;
                                                        }
                                                        var13_26 = new byte[var2_2];
                                                        var3_3.readFully(var13_26, 0, var2_2);
                                                        var12_16 = this.getCurrentTrack(var1_1);
                                                        var12_16.cryptoData = var14_30 = new TrackOutput$CryptoData(var11_11, var13_26, 0, 0);
                                                        break block26;
                                                    }
                                                    this.assertInTrackEntry(var1_1);
                                                    var12_17 = this.currentTrack;
                                                    var13_27 = new byte[var2_2];
                                                    var12_17.sampleStrippedBytes = var13_27;
                                                    var3_3.readFully(var13_27, 0, var2_2);
                                                    break block26;
                                                }
                                                var12_18 = this.getCurrentTrack(var1_1);
                                                this.handleBlockAddIDExtraData(var12_18, var3_3, var2_2);
                                                break block26;
                                            }
                                            var5_5 = this.blockState;
                                            if (var5_5 != var10_10) {
                                                return;
                                            }
                                            var12_19 /* !! */  = this.tracks;
                                            var8_8 = this.blockTrackNumber;
                                            var12_19 /* !! */  = (MatroskaExtractor$Track)var12_19 /* !! */ .get(var8_8);
                                            var8_8 = this.blockAdditionalId;
                                            this.handleBlockAdditionalData((MatroskaExtractor$Track)var12_19 /* !! */ , var8_8, var3_3, var2_2);
                                            break block26;
                                        }
                                        var8_8 = var4_4.blockState;
                                        var18_36 = 8;
                                        if (var8_8 == 0) {
                                            var4_4.blockTrackNumber = var8_8 = (int)var4_4.varintReader.readUnsignedVarint(var7_7, false, (boolean)var11_11, var18_36);
                                            var4_4.blockTrackNumberLength = var8_8 = var4_4.varintReader.getLastLength();
                                            var4_4.blockDurationUs = var19_37 = -9223372036854775807L;
                                            var4_4.blockState = var11_11;
                                            var13_28 /* !! */  = var4_4.scratch;
                                            var13_28 /* !! */ .reset(0);
                                        }
                                        var13_28 /* !! */  = var4_4.tracks;
                                        var21_38 = var4_4.blockTrackNumber;
                                        var22_39 /* !! */  = var13_28 /* !! */  = var13_28 /* !! */ .get(var21_38);
                                        var22_39 /* !! */  = (MatroskaExtractor$Track)var13_28 /* !! */ ;
                                        if (var22_39 /* !! */  == null) {
                                            var5_5 = var4_4.blockTrackNumberLength;
                                            var5_5 = var6_6 - var5_5;
                                            var7_7.skipFully(var5_5);
                                            var4_4.blockState = 0;
                                            return;
                                        }
                                        MatroskaExtractor$Track.access$100((MatroskaExtractor$Track)var22_39 /* !! */ );
                                        var8_8 = var4_4.blockState;
                                        if (var8_8 != var11_11) break block27;
                                        var8_8 = 3;
                                        var4_4.readScratch(var7_7, var8_8);
                                        var23_40 /* !! */  = var4_4.scratch.getData();
                                        var21_38 = (var23_40 /* !! */ [var10_10] & 6) >> var11_11;
                                        var24_41 = 255;
                                        if (var21_38 != 0) break block28;
                                        var4_4.blockSampleCount = var11_11;
                                        var23_40 /* !! */  = (byte[])MatroskaExtractor.ensureArrayCapacity(var4_4.blockSampleSizes, var11_11);
                                        var4_4.blockSampleSizes = var23_40 /* !! */ ;
                                        var25_42 = var4_4.blockTrackNumberLength;
                                        var23_40 /* !! */ [0] = var6_6 = var6_6 - var25_42 - var8_8;
                                        break block29;
                                    }
                                    var25_42 = 4;
                                    var4_4.readScratch(var7_7, var25_42);
                                    var4_4.blockSampleCount = var26_43 = (var4_4.scratch.getData()[var8_8] & var24_41) + var11_11;
                                    var27_44 = var4_4.blockSampleSizes;
                                    var28_45 /* !! */  = MatroskaExtractor.ensureArrayCapacity(var27_44, var26_43);
                                    var4_4.blockSampleSizes = var28_45 /* !! */ ;
                                    if (var21_38 != var10_10) break block30;
                                    var8_8 = var4_4.blockTrackNumberLength;
                                    var6_6 = var6_6 - var8_8 - var25_42;
                                    var8_8 = var4_4.blockSampleCount;
                                    Arrays.fill(var28_45 /* !! */ , 0, var8_8, var6_6 /= var8_8);
                                    break block29;
                                }
                                if (var21_38 != var11_11) break block31;
                                var13_28 /* !! */  = null;
                                var21_38 = 0;
                                var23_40 /* !! */  = null;
                                for (var8_8 = 0; var8_8 < (var29_46 = (var26_43 = var4_4.blockSampleCount) + -1); ++var8_8) {
                                    var28_45 /* !! */  = var4_4.blockSampleSizes;
                                    var28_45 /* !! */ [var8_8] = 0;
                                    do {
                                        var4_4.readScratch(var7_7, var25_42 += var11_11);
                                        var28_45 /* !! */  = var4_4.scratch.getData();
                                        var29_46 = var25_42 + -1;
                                        var26_43 = var28_45 /* !! */ [var29_46] & var24_41;
                                        var27_44 = var4_4.blockSampleSizes;
                                        var27_44[var8_8] = var30_47 = var27_44[var8_8] + var26_43;
                                    } while (var26_43 == var24_41);
                                    var26_43 = var27_44[var8_8];
                                    var21_38 += var26_43;
                                }
                                var13_28 /* !! */  = (SparseArray)var4_4.blockSampleSizes;
                                var29_46 = var4_4.blockTrackNumberLength;
                                var6_6 = var6_6 - var29_46 - var25_42 - var21_38;
                                var13_28 /* !! */ [var26_43 -= var11_11] = (SparseArray)var6_6;
                                break block29;
                            }
                            if (var21_38 != var8_8) break block32;
                            var13_28 /* !! */  = null;
                            var21_38 = 0;
                            var23_40 /* !! */  = null;
                            for (var8_8 = 0; var8_8 < (var29_46 = (var26_43 = var4_4.blockSampleCount) + -1); ++var8_8) {
                                var4_4.blockSampleSizes[var8_8] = 0;
                                var4_4.readScratch(var7_7, ++var25_42);
                                var28_45 /* !! */  = var4_4.scratch.getData();
                                var29_46 = var25_42 + -1;
                                var26_43 = var28_45 /* !! */ [var29_46];
                                if (var26_43 != 0) {
                                    var31_48 = 0L;
                                    var28_45 /* !! */  = null;
                                    for (var26_43 = 0; var26_43 < var18_36; ++var26_43) {
                                        var33_49 = 7 - var26_43;
                                        var9_9 = var11_11 << var33_49;
                                        var34_50 /* !! */  = var4_4.scratch.getData();
                                        var10_10 = var34_50 /* !! */ [var29_46] & var9_9;
                                        if (var10_10 != 0) {
                                            var4_4.readScratch(var7_7, var25_42 += var26_43);
                                            var34_50 /* !! */  = var4_4.scratch.getData();
                                            var30_47 = var29_46 + 1;
                                            var10_10 = var34_50 /* !! */ [var29_46] & var24_41;
                                            var37_52 = var35_51 = (long)(~var9_9 & var10_10);
                                            var9_9 = var30_47;
                                            while (true) {
                                                var31_48 = var37_52;
                                                if (var9_9 >= var25_42) break;
                                                var39_53 = var37_52 << var18_36;
                                                var34_50 /* !! */  = var4_4.scratch.getData();
                                                var41_54 = var9_9 + 1;
                                                var37_52 = var35_51 = (long)(var34_50 /* !! */ [var9_9] & var24_41) | var39_53;
                                                var9_9 = var41_54;
                                            }
                                            if (var8_8 <= 0) break;
                                            var26_43 = var26_43 * 7 + 6;
                                            var35_51 = 1L;
                                            var42_55 = (var35_51 << var26_43) - var35_51;
                                            var31_48 = var37_52 - var42_55;
                                            break;
                                        }
                                        var9_9 = 163;
                                        var10_10 = 2;
                                    }
                                    var35_51 = var31_48;
                                    var42_55 = 0x80000000L;
                                    cfr_temp_0 = var31_48 - var42_55;
                                    var26_43 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                    if (var26_43 >= 0 && (var26_43 = (int)((cfr_temp_1 = var31_48 - (var42_55 = 0x7FFFFFFFL)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) <= 0) {
                                        var9_9 = (int)var31_48;
                                        var34_50 /* !! */  = (byte[])var4_4.blockSampleSizes;
                                        if (var8_8 != 0) {
                                            var26_43 = var8_8 + -1;
                                            var26_43 = var34_50 /* !! */ [var26_43];
                                            var9_9 += var26_43;
                                        }
                                        var34_50 /* !! */ [var8_8] = var9_9;
                                        var9_9 = var34_50 /* !! */ [var8_8];
                                        var21_38 += var9_9;
                                        var9_9 = 163;
                                        var10_10 = 2;
                                        continue;
                                    }
                                    var12_20 = new ParserException("EBML lacing sample size out of range.");
                                    throw var12_20;
                                }
                                var12_21 = new ParserException("No valid varint length mask found");
                                throw var12_21;
                            }
                            var13_28 /* !! */  = (SparseArray)var4_4.blockSampleSizes;
                            var9_9 = var4_4.blockTrackNumberLength;
                            var6_6 = var6_6 - var9_9 - var25_42 - var21_38;
                            var13_28 /* !! */ [var26_43 -= var11_11] = (SparseArray)var6_6;
                        }
                        var14_31 /* !! */  = var4_4.scratch.getData();
                        var6_6 = var14_31 /* !! */ [0] << var18_36;
                        var13_28 /* !! */  = (SparseArray)var4_4.scratch.getData();
                        var8_8 = var13_28 /* !! */ [var11_11] & var24_41;
                        var44_56 = var4_4.clusterTimecodeUs;
                        var46_57 = var6_6 |= var8_8;
                        var46_57 = var4_4.scaleTimecodeToUs(var46_57);
                        var4_4.blockTimeUs = var44_56 += var46_57;
                        var6_6 = var22_39 /* !! */ .type;
                        var8_8 = 2;
                        if (var6_6 == var8_8) ** GOTO lbl-1000
                        var6_6 = 163;
                        if (var5_5 != var6_6) ** GOTO lbl-1000
                        var14_31 /* !! */  = var4_4.scratch.getData();
                        var6_6 = var14_31 /* !! */ [var8_8];
                        var8_8 = 128;
                        if ((var6_6 &= var8_8) != var8_8) lbl-1000:
                        // 2 sources

                        {
                            var6_6 = 0;
                            var14_31 /* !! */  = null;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var6_6 = var11_11;
                        }
                        var4_4.blockFlags = var6_6;
                        var4_4.blockState = 2;
                        var4_4.blockSampleIndex = 0;
                        var6_6 = 163;
                        break block33;
                    }
                    var13_28 /* !! */  = new StringBuilder(36);
                    var13_28 /* !! */ .append("Unexpected lacing value: ");
                    var13_28 /* !! */ .append(var21_38);
                    var14_32 = var13_28 /* !! */ .toString();
                    var12_22 = new ParserException(var14_32);
                    throw var12_22;
                }
                var6_6 = var9_9;
            }
            if (var5_5 == var6_6) {
                while ((var5_5 = var4_4.blockSampleIndex) < (var6_6 = var4_4.blockSampleCount)) {
                    var5_5 = var4_4.blockSampleSizes[var5_5];
                    var18_36 = var4_4.writeSampleData(var7_7, (MatroskaExtractor$Track)var22_39 /* !! */ , var5_5);
                    var16_35 = var4_4.blockTimeUs;
                    var8_8 = var4_4.blockSampleIndex;
                    var9_9 = var22_39 /* !! */ .defaultSampleDurationNs;
                    var8_8 = var8_8 * var9_9 / 1000;
                    var44_56 = (long)var8_8 + var16_35;
                    var10_10 = var4_4.blockFlags;
                    var21_38 = 0;
                    var23_40 /* !! */  = null;
                    var12_23 = this;
                    var14_31 /* !! */  = (int[])var22_39 /* !! */ ;
                    this.commitSampleToOutput((MatroskaExtractor$Track)var22_39 /* !! */ , var44_56, var10_10, var18_36, 0);
                    var4_4.blockSampleIndex = var5_5 = var4_4.blockSampleIndex + var11_11;
                }
                var4_4.blockState = 0;
            } else {
                while ((var5_5 = var4_4.blockSampleIndex) < (var6_6 = var4_4.blockSampleCount)) {
                    var14_31 /* !! */  = var4_4.blockSampleSizes;
                    var8_8 = var14_31 /* !! */ [var5_5];
                    var14_31 /* !! */ [var5_5] = var8_8 = var4_4.writeSampleData(var7_7, (MatroskaExtractor$Track)var22_39 /* !! */ , var8_8);
                    var4_4.blockSampleIndex = var5_5 = var4_4.blockSampleIndex + var11_11;
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void endMasterElement(int n10) {
        int n11;
        this.assertInitialized();
        int n12 = 160;
        int n13 = 0;
        LongArray longArray = null;
        if (n10 != n12) {
            n12 = 174;
            boolean bl2 = false;
            Object var6_7 = null;
            if (n10 != n12) {
                long l10;
                long l11;
                long l12;
                n12 = 19899;
                int n14 = 475249515;
                if (n10 != n12) {
                    n12 = 25152;
                    int n15 = 1;
                    if (n10 != n12) {
                        n12 = 28032;
                        if (n10 != n12) {
                            long l13;
                            n12 = 357149030;
                            if (n10 != n12) {
                                n12 = 374648427;
                                if (n10 != n12) {
                                    if (n10 != n14) {
                                        return;
                                    }
                                    n10 = (int)(this.sentSeekMap ? 1 : 0);
                                    if (n10 == 0) {
                                        ExtractorOutput extractorOutput = this.extractorOutput;
                                        Object object = this.cueTimesUs;
                                        longArray = this.cueClusterPositions;
                                        object = this.buildSeekMap((LongArray)object, longArray);
                                        extractorOutput.seekMap((SeekMap)object);
                                        this.sentSeekMap = n15;
                                    }
                                    this.cueTimesUs = null;
                                    this.cueClusterPositions = null;
                                    return;
                                }
                                SparseArray sparseArray = this.tracks;
                                n10 = sparseArray.size();
                                if (n10 != 0) {
                                    ExtractorOutput extractorOutput = this.extractorOutput;
                                    extractorOutput.endTracks();
                                    return;
                                }
                                ParserException parserException = new ParserException("No valid tracks were found");
                                throw parserException;
                            }
                            long l14 = this.timecodeScale;
                            long l15 = -9223372036854775807L;
                            long l16 = l14 - l15;
                            n10 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
                            if (n10 == 0) {
                                this.timecodeScale = l14 = 1000000L;
                            }
                            if ((n10 = (int)((l13 = (l14 = this.durationTimecode) - l15) == 0L ? 0 : (l13 < 0L ? -1 : 1))) == 0) return;
                            this.durationUs = l14 = this.scaleTimecodeToUs(l14);
                            return;
                        }
                        this.assertInTrackEntry(n10);
                        MatroskaExtractor$Track matroskaExtractor$Track = this.currentTrack;
                        n12 = (int)(matroskaExtractor$Track.hasContentEncryption ? 1 : 0);
                        if (n12 == 0) return;
                        byte[] byArray = matroskaExtractor$Track.sampleStrippedBytes;
                        if (byArray == null) {
                            return;
                        }
                        ParserException parserException = new ParserException("Combining encryption and compression is not supported");
                        throw parserException;
                    }
                    this.assertInTrackEntry(n10);
                    MatroskaExtractor$Track matroskaExtractor$Track = this.currentTrack;
                    n12 = (int)(matroskaExtractor$Track.hasContentEncryption ? 1 : 0);
                    if (n12 == 0) return;
                    Object object = matroskaExtractor$Track.cryptoData;
                    if (object != null) {
                        DrmInitData$SchemeData drmInitData$SchemeData;
                        DrmInitData$SchemeData[] drmInitData$SchemeDataArray = new DrmInitData$SchemeData[n15];
                        UUID uUID = C.UUID_NIL;
                        byte[] byArray = this.currentTrack.cryptoData.encryptionKey;
                        String string2 = "video/webm";
                        drmInitData$SchemeDataArray[0] = drmInitData$SchemeData = new DrmInitData$SchemeData(uUID, string2, byArray);
                        matroskaExtractor$Track.drmInitData = object = new DrmInitData(drmInitData$SchemeDataArray);
                        return;
                    }
                    ParserException parserException = new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                    throw parserException;
                }
                n10 = this.seekEntryId;
                n12 = -1;
                if (n10 != n12 && (bl2 = (l12 = (l11 = this.seekEntryPosition) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
                    if (n10 != n14) return;
                    this.cuesContentPosition = l11;
                    return;
                }
                ParserException parserException = new ParserException("Mandatory element SeekID or SeekPosition not found");
                throw parserException;
            }
            MatroskaExtractor$Track matroskaExtractor$Track = (MatroskaExtractor$Track)Assertions.checkStateNotNull(this.currentTrack);
            Object object = matroskaExtractor$Track.codecId;
            if (object == null) {
                ParserException parserException = new ParserException("CodecId is missing in TrackEntry element");
                throw parserException;
            }
            n12 = (int)(MatroskaExtractor.isCodecSupported((String)object) ? 1 : 0);
            if (n12 != 0) {
                object = this.extractorOutput;
                n13 = matroskaExtractor$Track.number;
                matroskaExtractor$Track.initializeOutput((ExtractorOutput)object, n13);
                object = this.tracks;
                n13 = matroskaExtractor$Track.number;
                object.put(n13, (Object)matroskaExtractor$Track);
            }
            this.currentTrack = null;
            return;
        }
        n10 = this.blockState;
        n12 = 2;
        if (n10 != n12) {
            return;
        }
        Object var9_28 = null;
        n12 = 0;
        Object var10_34 = null;
        for (n10 = 0; n10 < (n11 = this.blockSampleCount); n12 += n11, ++n10) {
            int[] nArray = this.blockSampleSizes;
            n11 = nArray[n10];
        }
        SparseArray sparseArray = this.tracks;
        n11 = this.blockTrackNumber;
        MatroskaExtractor$Track matroskaExtractor$Track = (MatroskaExtractor$Track)sparseArray.get(n11);
        MatroskaExtractor$Track.access$100(matroskaExtractor$Track);
        int n16 = 0;
        while (true) {
            boolean bl3;
            if (n16 >= (n11 = this.blockSampleCount)) {
                this.blockState = 0;
                return;
            }
            long l17 = this.blockTimeUs;
            int n17 = matroskaExtractor$Track.defaultSampleDurationNs * n16 / 1000;
            long l18 = (long)n17 + l17;
            n11 = this.blockFlags;
            if (n16 == 0 && !(bl3 = this.blockHasReferenceBlock)) {
                n11 |= 1;
            }
            int n18 = this.blockSampleSizes[n16];
            MatroskaExtractor matroskaExtractor = this;
            MatroskaExtractor$Track matroskaExtractor$Track2 = matroskaExtractor$Track;
            this.commitSampleToOutput(matroskaExtractor$Track, l18, n11, n18, n12 -= n18);
            ++n16;
        }
    }

    public void floatElement(int n10, double d10) {
        int n11 = 181;
        if (n10 != n11) {
            n11 = 17545;
            if (n10 != n11) {
                block0 : switch (n10) {
                    default: {
                        float f10;
                        switch (n10) {
                            default: {
                                break block0;
                            }
                            case 30325: {
                                float f11;
                                MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                                matroskaExtractor$Track.projectionPoseRoll = f11 = (float)d10;
                                break block0;
                            }
                            case 30324: {
                                float f12;
                                MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                                matroskaExtractor$Track.projectionPosePitch = f12 = (float)d10;
                                break block0;
                            }
                            case 30323: 
                        }
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.projectionPoseYaw = f10 = (float)d10;
                        break;
                    }
                    case 21978: {
                        float f13;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.minMasteringLuminance = f13 = (float)d10;
                        break;
                    }
                    case 21977: {
                        float f14;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.maxMasteringLuminance = f14 = (float)d10;
                        break;
                    }
                    case 21976: {
                        float f15;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.whitePointChromaticityY = f15 = (float)d10;
                        break;
                    }
                    case 21975: {
                        float f16;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.whitePointChromaticityX = f16 = (float)d10;
                        break;
                    }
                    case 21974: {
                        float f17;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.primaryBChromaticityY = f17 = (float)d10;
                        break;
                    }
                    case 21973: {
                        float f18;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.primaryBChromaticityX = f18 = (float)d10;
                        break;
                    }
                    case 21972: {
                        float f19;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.primaryGChromaticityY = f19 = (float)d10;
                        break;
                    }
                    case 21971: {
                        float f20;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.primaryGChromaticityX = f20 = (float)d10;
                        break;
                    }
                    case 21970: {
                        float f21;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.primaryRChromaticityY = f21 = (float)d10;
                        break;
                    }
                    case 21969: {
                        float f22;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.primaryRChromaticityX = f22 = (float)d10;
                        break;
                    }
                }
            } else {
                long l10;
                this.durationTimecode = l10 = (long)d10;
            }
        } else {
            int n12;
            MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
            matroskaExtractor$Track.sampleRate = n12 = (int)d10;
        }
    }

    public int getElementType(int n10) {
        switch (n10) {
            default: {
                return 0;
            }
            case 181: 
            case 17545: 
            case 21969: 
            case 21970: 
            case 21971: 
            case 21972: 
            case 21973: 
            case 21974: 
            case 21975: 
            case 21976: 
            case 21977: 
            case 21978: 
            case 30323: 
            case 30324: 
            case 30325: {
                return 5;
            }
            case 161: 
            case 163: 
            case 165: 
            case 16877: 
            case 16981: 
            case 18402: 
            case 21419: 
            case 25506: 
            case 30322: {
                return 4;
            }
            case 160: 
            case 166: 
            case 174: 
            case 183: 
            case 187: 
            case 224: 
            case 225: 
            case 16868: 
            case 18407: 
            case 19899: 
            case 20532: 
            case 20533: 
            case 21936: 
            case 21968: 
            case 25152: 
            case 28032: 
            case 30113: 
            case 30320: 
            case 290298740: 
            case 357149030: 
            case 374648427: 
            case 408125543: 
            case 440786851: 
            case 475249515: 
            case 524531317: {
                return 1;
            }
            case 134: 
            case 17026: 
            case 21358: 
            case 2274716: {
                return 3;
            }
            case 131: 
            case 136: 
            case 155: 
            case 159: 
            case 176: 
            case 179: 
            case 186: 
            case 215: 
            case 231: 
            case 238: 
            case 241: 
            case 251: 
            case 16871: 
            case 16980: 
            case 17029: 
            case 17143: 
            case 18401: 
            case 18408: 
            case 20529: 
            case 20530: 
            case 21420: 
            case 21432: 
            case 21680: 
            case 21682: 
            case 21690: 
            case 21930: 
            case 21945: 
            case 21946: 
            case 21947: 
            case 21948: 
            case 21949: 
            case 21998: 
            case 22186: 
            case 22203: 
            case 25188: 
            case 30321: 
            case 2352003: 
            case 2807729: 
        }
        return 2;
    }

    public void handleBlockAddIDExtraData(MatroskaExtractor$Track matroskaExtractor$Track, ExtractorInput extractorInput, int n10) {
        int n11;
        int n12 = MatroskaExtractor$Track.access$300(matroskaExtractor$Track);
        if (n12 != (n11 = 1685485123) && (n12 = MatroskaExtractor$Track.access$300(matroskaExtractor$Track)) != (n11 = 1685480259)) {
            extractorInput.skipFully(n10);
        } else {
            byte[] byArray = new byte[n10];
            matroskaExtractor$Track.dolbyVisionConfigBytes = byArray;
            matroskaExtractor$Track = null;
            extractorInput.readFully(byArray, 0, n10);
        }
    }

    public void handleBlockAdditionalData(MatroskaExtractor$Track object, int n10, ExtractorInput extractorInput, int n11) {
        String string2;
        boolean bl2;
        int n12 = 4;
        if (n10 == n12 && (bl2 = (string2 = CODEC_ID_VP9).equals(object = ((MatroskaExtractor$Track)object).codecId))) {
            this.blockAdditionalData.reset(n11);
            object = this.blockAdditionalData.getData();
            n10 = 0;
            string2 = null;
            extractorInput.readFully((byte[])object, 0, n11);
        } else {
            extractorInput.skipFully(n11);
        }
    }

    public final void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void integerElement(int n10, long l10) {
        int n11 = 20529;
        int n12 = 55;
        String string2 = " not supported";
        if (n10 != n11) {
            n11 = 20530;
            long l11 = 1L;
            if (n10 != n11) {
                int n13;
                n11 = 50;
                n12 = 0;
                StringBuilder stringBuilder = null;
                int n14 = 3;
                int n15 = 2;
                int n16 = 1;
                switch (n10) {
                    default: {
                        n11 = 7;
                        n12 = 6;
                        switch (n10) {
                            default: {
                                return;
                            }
                            case 21949: {
                                int n17;
                                MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                                matroskaExtractor$Track.maxFrameAverageLuminance = n17 = (int)l10;
                                return;
                            }
                            case 21948: {
                                int n18;
                                MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                                matroskaExtractor$Track.maxContentLuminance = n18 = (int)l10;
                                return;
                            }
                            case 21947: {
                                this.assertInTrackEntry(n10);
                                MatroskaExtractor$Track matroskaExtractor$Track = this.currentTrack;
                                matroskaExtractor$Track.hasColorInfo = n16;
                                int n19 = (int)l10;
                                if (n19 == n16) {
                                    matroskaExtractor$Track.colorSpace = n16;
                                    return;
                                }
                                int n20 = 9;
                                if (n19 == n20) {
                                    matroskaExtractor$Track.colorSpace = n12;
                                    return;
                                }
                                n20 = 4;
                                if (n19 != n20 && n19 != (n20 = 5) && n19 != n12 && n19 != n11) {
                                    return;
                                }
                                matroskaExtractor$Track.colorSpace = n15;
                                return;
                            }
                            case 21946: {
                                this.assertInTrackEntry(n10);
                                n10 = (int)l10;
                                if (n10 != n16) {
                                    int n21 = 16;
                                    if (n10 == n21) {
                                        MatroskaExtractor$Track matroskaExtractor$Track = this.currentTrack;
                                        matroskaExtractor$Track.colorTransfer = n12;
                                        return;
                                    }
                                    n21 = 18;
                                    if (n10 == n21) {
                                        MatroskaExtractor$Track matroskaExtractor$Track = this.currentTrack;
                                        matroskaExtractor$Track.colorTransfer = n11;
                                        return;
                                    }
                                    if (n10 != n12 && n10 != n11) {
                                        return;
                                    }
                                }
                                MatroskaExtractor$Track matroskaExtractor$Track = this.currentTrack;
                                matroskaExtractor$Track.colorTransfer = n14;
                                return;
                            }
                            case 21945: 
                        }
                        this.assertInTrackEntry(n10);
                        n10 = (int)l10;
                        if (n10 == n16) {
                            MatroskaExtractor$Track matroskaExtractor$Track = this.currentTrack;
                            matroskaExtractor$Track.colorRange = n15;
                            return;
                        }
                        if (n10 != n15) {
                            return;
                        }
                        MatroskaExtractor$Track matroskaExtractor$Track = this.currentTrack;
                        matroskaExtractor$Track.colorRange = n16;
                        return;
                    }
                    case 2807729: {
                        this.timecodeScale = l10;
                        return;
                    }
                    case 2352003: {
                        int n22;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.defaultSampleDurationNs = n22 = (int)l10;
                        return;
                    }
                    case 30321: {
                        this.assertInTrackEntry(n10);
                        n10 = (int)l10;
                        if (n10 == 0) {
                            MatroskaExtractor$Track matroskaExtractor$Track = this.currentTrack;
                            matroskaExtractor$Track.projectionType = 0;
                            return;
                        }
                        if (n10 == n16) {
                            MatroskaExtractor$Track matroskaExtractor$Track = this.currentTrack;
                            matroskaExtractor$Track.projectionType = n16;
                            return;
                        }
                        if (n10 == n15) {
                            MatroskaExtractor$Track matroskaExtractor$Track = this.currentTrack;
                            matroskaExtractor$Track.projectionType = n15;
                            return;
                        }
                        if (n10 != n14) {
                            return;
                        }
                        MatroskaExtractor$Track matroskaExtractor$Track = this.currentTrack;
                        matroskaExtractor$Track.projectionType = n14;
                        return;
                    }
                    case 25188: {
                        int n23;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.audioBitDepth = n23 = (int)l10;
                        return;
                    }
                    case 22203: {
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.seekPreRollNs = l10;
                        return;
                    }
                    case 22186: {
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.codecDelayNs = l10;
                        return;
                    }
                    case 21998: {
                        int n24;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.maxBlockAdditionId = n24 = (int)l10;
                        return;
                    }
                    case 21930: {
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                        if (l12 == false) {
                            n12 = n16;
                        }
                        matroskaExtractor$Track.flagForced = n12;
                        return;
                    }
                    case 21690: {
                        int n25;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.displayHeight = n25 = (int)l10;
                        return;
                    }
                    case 21682: {
                        int n26;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.displayUnit = n26 = (int)l10;
                        return;
                    }
                    case 21680: {
                        int n27;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.displayWidth = n27 = (int)l10;
                        return;
                    }
                    case 21432: {
                        int n28 = (int)l10;
                        this.assertInTrackEntry(n10);
                        if (n28 == 0) {
                            MatroskaExtractor$Track matroskaExtractor$Track = this.currentTrack;
                            matroskaExtractor$Track.stereoMode = 0;
                            return;
                        }
                        if (n28 == n16) {
                            MatroskaExtractor$Track matroskaExtractor$Track = this.currentTrack;
                            matroskaExtractor$Track.stereoMode = n15;
                            return;
                        }
                        if (n28 == n14) {
                            MatroskaExtractor$Track matroskaExtractor$Track = this.currentTrack;
                            matroskaExtractor$Track.stereoMode = n16;
                            return;
                        }
                        n10 = 15;
                        if (n28 != n10) {
                            return;
                        }
                        MatroskaExtractor$Track matroskaExtractor$Track = this.currentTrack;
                        matroskaExtractor$Track.stereoMode = n14;
                        return;
                    }
                    case 21420: {
                        long l13 = this.segmentContentPosition;
                        this.seekEntryPosition = l10 += l13;
                        return;
                    }
                    case 18408: {
                        n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
                        if (n10 == 0) {
                            return;
                        }
                        stringBuilder = new StringBuilder(56);
                        stringBuilder.append("AESSettingsCipherMode ");
                        stringBuilder.append(l10);
                        stringBuilder.append(string2);
                        String string3 = stringBuilder.toString();
                        ParserException parserException = new ParserException(string3);
                        throw parserException;
                    }
                    case 18401: {
                        long l14 = 5;
                        n10 = (int)(l10 == l14 ? 0 : (l10 < l14 ? -1 : 1));
                        if (n10 == 0) {
                            return;
                        }
                        stringBuilder = new StringBuilder(49);
                        stringBuilder.append("ContentEncAlgo ");
                        stringBuilder.append(l10);
                        stringBuilder.append(string2);
                        String string4 = stringBuilder.toString();
                        ParserException parserException = new ParserException(string4);
                        throw parserException;
                    }
                    case 17143: {
                        n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
                        if (n10 == 0) {
                            return;
                        }
                        stringBuilder = new StringBuilder(n11);
                        stringBuilder.append("EBMLReadVersion ");
                        stringBuilder.append(l10);
                        stringBuilder.append(string2);
                        String string5 = stringBuilder.toString();
                        ParserException parserException = new ParserException(string5);
                        throw parserException;
                    }
                    case 17029: {
                        long l15;
                        long l16;
                        n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
                        if (n10 >= 0 && (n10 = (int)((l16 = l10 - (l15 = (long)2)) == 0L ? 0 : (l16 < 0L ? -1 : 1))) <= 0) {
                            return;
                        }
                        stringBuilder = new StringBuilder(53);
                        stringBuilder.append("DocTypeReadVersion ");
                        stringBuilder.append(l10);
                        stringBuilder.append(string2);
                        String string6 = stringBuilder.toString();
                        ParserException parserException = new ParserException(string6);
                        throw parserException;
                    }
                    case 16980: {
                        l11 = 3;
                        n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
                        if (n10 == 0) {
                            return;
                        }
                        stringBuilder = new StringBuilder(n11);
                        stringBuilder.append("ContentCompAlgo ");
                        stringBuilder.append(l10);
                        stringBuilder.append(string2);
                        String string7 = stringBuilder.toString();
                        ParserException parserException = new ParserException(string7);
                        throw parserException;
                    }
                    case 16871: {
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        int n29 = (int)l10;
                        MatroskaExtractor$Track.access$302(matroskaExtractor$Track, n29);
                        return;
                    }
                    case 251: {
                        this.blockHasReferenceBlock = n16;
                        return;
                    }
                    case 241: {
                        n11 = (int)(this.seenClusterPositionForCurrentCuePoint ? 1 : 0);
                        if (n11 != 0) return;
                        this.assertInCues(n10);
                        LongArray longArray = this.cueClusterPositions;
                        longArray.add(l10);
                        this.seenClusterPositionForCurrentCuePoint = n16;
                        return;
                    }
                    case 238: {
                        this.blockAdditionalId = n10 = (int)l10;
                        return;
                    }
                    case 231: {
                        long l17;
                        this.clusterTimecodeUs = l17 = this.scaleTimecodeToUs(l10);
                        return;
                    }
                    case 215: {
                        int n30;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.number = n30 = (int)l10;
                        return;
                    }
                    case 186: {
                        int n31;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.height = n31 = (int)l10;
                        return;
                    }
                    case 179: {
                        this.assertInCues(n10);
                        LongArray longArray = this.cueTimesUs;
                        l10 = this.scaleTimecodeToUs(l10);
                        longArray.add(l10);
                        return;
                    }
                    case 176: {
                        int n32;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.width = n32 = (int)l10;
                        return;
                    }
                    case 159: {
                        int n33;
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        matroskaExtractor$Track.channelCount = n33 = (int)l10;
                        return;
                    }
                    case 155: {
                        long l18;
                        this.blockDurationUs = l18 = this.scaleTimecodeToUs(l10);
                        return;
                    }
                    case 136: {
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        long l19 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                        if (l19 == false) {
                            n12 = n16;
                        }
                        matroskaExtractor$Track.flagDefault = n12;
                        return;
                    }
                    case 131: 
                }
                MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                matroskaExtractor$Track.type = n13 = (int)l10;
                return;
            }
            n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
            if (n10 == 0) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder(n12);
            stringBuilder.append("ContentEncodingScope ");
            stringBuilder.append(l10);
            stringBuilder.append(string2);
            String string8 = stringBuilder.toString();
            ParserException parserException = new ParserException(string8);
            throw parserException;
        }
        long l20 = 0L;
        long l21 = l10 - l20;
        n10 = (int)(l21 == 0L ? 0 : (l21 < 0L ? -1 : 1));
        if (n10 == 0) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(n12);
        stringBuilder.append("ContentEncodingOrder ");
        stringBuilder.append(l10);
        stringBuilder.append(string2);
        String string9 = stringBuilder.toString();
        ParserException parserException = new ParserException(string9);
        throw parserException;
    }

    public boolean isLevel1Element(int n10) {
        int n11 = 357149030;
        n10 = n10 != n11 && n10 != (n11 = 524531317) && n10 != (n11 = 475249515) && n10 != (n11 = 374648427) ? 0 : 1;
        return n10 != 0;
    }

    public final int read(ExtractorInput object, PositionHolder positionHolder) {
        boolean bl2;
        int n10;
        int n11 = 0;
        this.haveOutputSample = false;
        int n12 = n10 = 1;
        while (n12 != 0 && !(bl2 = this.haveOutputSample)) {
            long l10;
            EbmlReader ebmlReader = this.reader;
            n12 = ebmlReader.read((ExtractorInput)object);
            if (n12 == 0 || !(bl2 = this.maybeSeekForCues(positionHolder, l10 = object.getPosition()))) continue;
            return n10;
        }
        if (n12 == 0) {
            int n13;
            while (n11 < (n13 = (object = this.tracks).size())) {
                object = (MatroskaExtractor$Track)this.tracks.valueAt(n11);
                MatroskaExtractor$Track.access$100((MatroskaExtractor$Track)object);
                ((MatroskaExtractor$Track)object).outputPendingSampleMetadata();
                ++n11;
            }
            return -1;
        }
        return 0;
    }

    public final void release() {
    }

    public void seek(long l10, long l11) {
        int n10;
        this.clusterTimecodeUs = l10 = -9223372036854775807L;
        this.blockState = 0;
        this.reader.reset();
        Object object = this.varintReader;
        ((VarintReader)object).reset();
        this.resetWriteSampleData();
        for (int i10 = 0; i10 < (n10 = (object = this.tracks).size()); ++i10) {
            object = (MatroskaExtractor$Track)this.tracks.valueAt(i10);
            ((MatroskaExtractor$Track)object).reset();
        }
    }

    public final boolean sniff(ExtractorInput extractorInput) {
        Sniffer sniffer = new Sniffer();
        return sniffer.sniff(extractorInput);
    }

    public void startMasterElement(int n10, long l10, long l11) {
        this.assertInitialized();
        int n11 = 160;
        if (n10 != n11) {
            n11 = 174;
            if (n10 != n11) {
                n11 = 187;
                if (n10 != n11) {
                    n11 = 19899;
                    long l12 = -1;
                    if (n10 != n11) {
                        n11 = 20533;
                        boolean bl2 = true;
                        if (n10 != n11) {
                            n11 = 21968;
                            if (n10 != n11) {
                                n11 = 408125543;
                                if (n10 != n11) {
                                    int n12 = 475249515;
                                    if (n10 != n12) {
                                        n12 = 524531317;
                                        if (n10 == n12 && (n10 = (int)(this.sentSeekMap ? 1 : 0)) == 0) {
                                            long l13;
                                            long l14;
                                            n10 = (int)(this.seekForCuesEnabled ? 1 : 0);
                                            if (n10 != 0 && (n10 = (int)((l14 = (l13 = this.cuesContentPosition) - l12) == 0L ? 0 : (l14 < 0L ? -1 : 1))) != 0) {
                                                this.seekForCues = bl2;
                                            } else {
                                                ExtractorOutput extractorOutput = this.extractorOutput;
                                                long l15 = this.durationUs;
                                                SeekMap$Unseekable seekMap$Unseekable = new SeekMap$Unseekable(l15);
                                                extractorOutput.seekMap(seekMap$Unseekable);
                                                this.sentSeekMap = bl2;
                                            }
                                        }
                                    } else {
                                        LongArray longArray;
                                        this.cueTimesUs = longArray = new LongArray();
                                        this.cueClusterPositions = longArray = new LongArray();
                                    }
                                } else {
                                    long l16 = this.segmentContentPosition;
                                    long l17 = l16 - l12;
                                    n10 = (int)(l17 == 0L ? 0 : (l17 < 0L ? -1 : 1));
                                    if (n10 != 0 && (n10 = (int)(l16 == l10 ? 0 : (l16 < l10 ? -1 : 1))) != 0) {
                                        ParserException parserException = new ParserException("Multiple Segment elements not supported");
                                        throw parserException;
                                    }
                                    this.segmentContentPosition = l10;
                                    this.segmentContentSize = l11;
                                }
                            } else {
                                MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                                matroskaExtractor$Track.hasColorInfo = bl2;
                            }
                        } else {
                            MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                            matroskaExtractor$Track.hasContentEncryption = bl2;
                        }
                    } else {
                        this.seekEntryId = n10 = -1;
                        this.seekEntryPosition = l12;
                    }
                } else {
                    this.seenClusterPositionForCurrentCuePoint = false;
                }
            } else {
                MatroskaExtractor$Track matroskaExtractor$Track;
                boolean bl3 = false;
                Object var14_17 = null;
                this.currentTrack = matroskaExtractor$Track = new MatroskaExtractor$Track(null);
            }
        } else {
            this.blockHasReferenceBlock = false;
        }
    }

    public void stringElement(int n10, String string2) {
        int n11 = 134;
        if (n10 != n11) {
            n11 = 17026;
            if (n10 != n11) {
                n11 = 21358;
                if (n10 != n11) {
                    n11 = 2274716;
                    if (n10 == n11) {
                        MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                        MatroskaExtractor$Track.access$402(matroskaExtractor$Track, string2);
                    }
                } else {
                    MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
                    matroskaExtractor$Track.name = string2;
                }
            } else {
                Object object = DOC_TYPE_WEBM;
                n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                if (n10 == 0 && (n10 = (int)(((String)(object = DOC_TYPE_MATROSKA)).equals(string2) ? 1 : 0)) == 0) {
                    n11 = String.valueOf(string2).length() + 22;
                    StringBuilder stringBuilder = new StringBuilder(n11);
                    stringBuilder.append("DocType ");
                    stringBuilder.append(string2);
                    stringBuilder.append(" not supported");
                    string2 = stringBuilder.toString();
                    object = new ParserException(string2);
                    throw object;
                }
            }
        } else {
            MatroskaExtractor$Track matroskaExtractor$Track = this.getCurrentTrack(n10);
            matroskaExtractor$Track.codecId = string2;
        }
    }
}

