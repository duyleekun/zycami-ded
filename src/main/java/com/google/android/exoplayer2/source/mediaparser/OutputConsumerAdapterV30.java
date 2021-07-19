/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.DrmInitData
 *  android.media.MediaCodec$CryptoInfo
 *  android.media.MediaFormat
 *  android.media.MediaParser$InputReader
 *  android.media.MediaParser$OutputConsumer
 *  android.media.MediaParser$SeekMap
 *  android.media.MediaParser$SeekPoint
 *  android.media.MediaParser$TrackData
 *  android.util.Pair
 */
package com.google.android.exoplayer2.source.mediaparser;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaParser;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData$SchemeData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.DummyExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput$CryptoData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30$DataReaderAdapter;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30$SeekMapAdapter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.common.collect.ImmutableList;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class OutputConsumerAdapterV30
implements MediaParser.OutputConsumer {
    private static final String MEDIA_FORMAT_KEY_CHUNK_INDEX_DURATIONS = "chunk-index-long-us-durations";
    private static final String MEDIA_FORMAT_KEY_CHUNK_INDEX_OFFSETS = "chunk-index-long-offsets";
    private static final String MEDIA_FORMAT_KEY_CHUNK_INDEX_SIZES = "chunk-index-int-sizes";
    private static final String MEDIA_FORMAT_KEY_CHUNK_INDEX_TIMES = "chunk-index-long-us-times";
    private static final String MEDIA_FORMAT_KEY_TRACK_TYPE = "track-type-string";
    private static final Pattern REGEX_CRYPTO_INFO_PATTERN;
    private static final Pair SEEK_POINT_PAIR_START;
    private static final String TAG = "OutputConsumerAdapterV30";
    private String containerMimeType;
    private MediaParser.SeekMap dummySeekMap;
    private final boolean expectDummySeekMap;
    private ExtractorOutput extractorOutput;
    private ChunkIndex lastChunkIndex;
    private final ArrayList lastOutputCryptoDatas;
    private final ArrayList lastReceivedCryptoInfos;
    private MediaParser.SeekMap lastSeekMap;
    private List muxedCaptionFormats;
    private int primaryTrackIndex;
    private final Format primaryTrackManifestFormat;
    private final int primaryTrackType;
    private long sampleTimestampUpperLimitFilterUs;
    private final OutputConsumerAdapterV30$DataReaderAdapter scratchDataReaderAdapter;
    private boolean seekingDisabled;
    private TimestampAdjuster timestampAdjuster;
    private final ArrayList trackFormats;
    private final ArrayList trackOutputs;
    private boolean tracksEnded;
    private boolean tracksFoundCalled;

    static {
        MediaParser.SeekPoint seekPoint = MediaParser.SeekPoint.START;
        MediaParser.SeekPoint seekPoint2 = MediaParser.SeekPoint.START;
        SEEK_POINT_PAIR_START = Pair.create((Object)seekPoint, (Object)seekPoint2);
        REGEX_CRYPTO_INFO_PATTERN = Pattern.compile("pattern \\(encrypt: (\\d+), skip: (\\d+)\\)");
    }

    public OutputConsumerAdapterV30() {
        this(null, 7, false);
    }

    public OutputConsumerAdapterV30(Format object, int n10, boolean bl2) {
        this.expectDummySeekMap = bl2;
        this.primaryTrackManifestFormat = object;
        this.primaryTrackType = n10;
        object = new ArrayList();
        this.trackOutputs = object;
        object = new ArrayList();
        this.trackFormats = object;
        object = new ArrayList();
        this.lastReceivedCryptoInfos = object;
        object = new ArrayList();
        this.lastOutputCryptoDatas = object;
        this.scratchDataReaderAdapter = object = new OutputConsumerAdapterV30$DataReaderAdapter(null);
        this.extractorOutput = object = new DummyExtractorOutput();
        this.sampleTimestampUpperLimitFilterUs = -9223372036854775807L;
        this.muxedCaptionFormats = object = ImmutableList.of();
    }

    private void ensureSpaceForTrackIndex(int n10) {
        ArrayList arrayList = this.trackOutputs;
        for (int i10 = arrayList.size(); i10 <= n10; ++i10) {
            this.trackOutputs.add(null);
            this.trackFormats.add(null);
            this.lastReceivedCryptoInfos.add(null);
            ArrayList arrayList2 = this.lastOutputCryptoDatas;
            arrayList2.add(null);
        }
    }

    private static byte[] getArray(ByteBuffer byteBuffer) {
        byte[] byArray = new byte[byteBuffer.remaining()];
        byteBuffer.get(byArray);
        return byArray;
    }

    private static ColorInfo getColorInfo(MediaFormat mediaFormat) {
        Object object = mediaFormat.getByteBuffer("hdr-static-info");
        ColorInfo colorInfo = null;
        object = object != null ? (Object)OutputConsumerAdapterV30.getArray((ByteBuffer)object) : null;
        String string2 = "color-transfer";
        int n10 = -1;
        int n11 = mediaFormat.getInteger(string2, n10);
        String string3 = "color-range";
        int n12 = mediaFormat.getInteger(string3, n10);
        String string4 = "color-standard";
        int n13 = mediaFormat.getInteger(string4, n10);
        if (object == null && n11 == n10 && n12 == n10 && n13 == n10) {
            return null;
        }
        colorInfo = new ColorInfo(n13, n12, n11, (byte[])object);
        return colorInfo;
    }

    private static int getFlag(MediaFormat mediaFormat, String string2, int n10) {
        int n11 = mediaFormat.getInteger(string2, 0);
        if (n11 == 0) {
            n10 = 0;
        }
        return n10;
    }

    private static List getInitializationData(MediaFormat mediaFormat) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n10 = 0;
        Object object = null;
        while (true) {
            int n11 = n10 + 1;
            int n12 = 15;
            StringBuilder stringBuilder = new StringBuilder(n12);
            String string2 = "csd-";
            stringBuilder.append(string2);
            stringBuilder.append(n10);
            object = stringBuilder.toString();
            object = mediaFormat.getByteBuffer((String)object);
            if (object == null) {
                return arrayList;
            }
            object = OutputConsumerAdapterV30.getArray((ByteBuffer)object);
            arrayList.add(object);
            n10 = n11;
        }
    }

    private static String getMimeType(String string2) {
        String string3;
        Object object;
        string2.hashCode();
        int n10 = string2.hashCode();
        int n11 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 2063134683: {
                object = "android.media.mediaparser.FlvParser";
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 13;
                break;
            }
            case 1343957595: {
                object = "android.media.mediaparser.Mp3Parser";
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 12;
                break;
            }
            case 1264380477: {
                object = "android.media.mediaparser.Ac4Parser";
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 11;
                break;
            }
            case 965962719: {
                object = "android.media.mediaparser.MatroskaParser";
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 10;
                break;
            }
            case 768643067: {
                object = "android.media.mediaparser.FlacParser";
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 9;
                break;
            }
            case 703268017: {
                object = "android.media.mediaparser.AmrParser";
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 8;
                break;
            }
            case 376876796: {
                object = "android.media.mediaparser.Ac3Parser";
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 7;
                break;
            }
            case 116768877: {
                object = "android.media.mediaparser.FragmentedMp4Parser";
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 6;
                break;
            }
            case 52265814: {
                object = "android.media.mediaparser.PsParser";
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 5;
                break;
            }
            case -589864617: {
                object = "android.media.mediaparser.WavParser";
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 4;
                break;
            }
            case -900207883: {
                object = "android.media.mediaparser.AdtsParser";
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 3;
                break;
            }
            case -1566427438: {
                object = "android.media.mediaparser.TsParser";
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 2;
                break;
            }
            case -1870824006: {
                object = "android.media.mediaparser.OggParser";
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 1;
                break;
            }
            case -2063506020: {
                object = "android.media.mediaparser.Mp4Parser";
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 0;
                string3 = null;
            }
        }
        switch (n11) {
            default: {
                string3 = "Illegal parser name: ";
                string2 = String.valueOf(string2);
                int n12 = string2.length();
                string2 = n12 != 0 ? string3.concat(string2) : new String(string3);
                object = new IllegalArgumentException(string2);
                throw object;
            }
            case 13: {
                return "video/x-flv";
            }
            case 12: {
                return "audio/mpeg";
            }
            case 11: {
                return "audio/ac4";
            }
            case 10: {
                return "video/webm";
            }
            case 9: {
                return "audio/flac";
            }
            case 8: {
                return "audio/amr";
            }
            case 7: {
                return "audio/ac3";
            }
            case 5: {
                return "video/mp2p";
            }
            case 4: {
                return "audio/raw";
            }
            case 3: {
                return "audio/mp4a-latm";
            }
            case 2: {
                return "video/mp2t";
            }
            case 1: {
                return "audio/ogg";
            }
            case 0: 
            case 6: 
        }
        return "video/mp4";
    }

    private static int getSelectionFlags(MediaFormat mediaFormat) {
        int n10 = OutputConsumerAdapterV30.getFlag(mediaFormat, "is-autoselect", 4) | 0;
        int n11 = OutputConsumerAdapterV30.getFlag(mediaFormat, "is-default", 1);
        return OutputConsumerAdapterV30.getFlag(mediaFormat, "is-forced-subtitle", 2) | (n10 |= n11);
    }

    private void maybeEndTracks() {
        int n10 = this.tracksFoundCalled;
        if (n10 != 0 && (n10 = this.tracksEnded) == 0) {
            Object object = this.trackOutputs;
            n10 = ((ArrayList)object).size();
            for (int i10 = 0; i10 < n10; ++i10) {
                Object e10 = this.trackOutputs.get(i10);
                if (e10 != null) continue;
                return;
            }
            object = this.extractorOutput;
            object.endTracks();
            n10 = 1;
            this.tracksEnded = n10;
        }
    }

    private boolean maybeObtainChunkIndex(MediaFormat object) {
        Buffer buffer = object.getByteBuffer(MEDIA_FORMAT_KEY_CHUNK_INDEX_SIZES);
        if (buffer == null) {
            return false;
        }
        buffer = ((ByteBuffer)buffer).asIntBuffer();
        LongBuffer longBuffer = ((ByteBuffer)Assertions.checkNotNull(object.getByteBuffer(MEDIA_FORMAT_KEY_CHUNK_INDEX_OFFSETS))).asLongBuffer();
        LongBuffer longBuffer2 = ((ByteBuffer)Assertions.checkNotNull(object.getByteBuffer(MEDIA_FORMAT_KEY_CHUNK_INDEX_DURATIONS))).asLongBuffer();
        object = ((ByteBuffer)Assertions.checkNotNull(object.getByteBuffer(MEDIA_FORMAT_KEY_CHUNK_INDEX_TIMES))).asLongBuffer();
        int[] nArray = new int[buffer.remaining()];
        long[] lArray = new long[longBuffer.remaining()];
        long[] lArray2 = new long[longBuffer2.remaining()];
        long[] lArray3 = new long[((Buffer)object).remaining()];
        ((IntBuffer)buffer).get(nArray);
        longBuffer.get(lArray);
        longBuffer2.get(lArray2);
        ((LongBuffer)object).get(lArray3);
        this.lastChunkIndex = object = new ChunkIndex(nArray, lArray, lArray2, lArray3);
        this.extractorOutput.seekMap((SeekMap)object);
        return true;
    }

    private TrackOutput$CryptoData toExoPlayerCryptoData(int n10, MediaCodec.CryptoInfo object) {
        Object object2;
        if (object == null) {
            return null;
        }
        Object object3 = (MediaCodec.CryptoInfo)this.lastReceivedCryptoInfos.get(n10);
        if (object3 == object) {
            object = this.lastOutputCryptoDatas;
            object2 = (TrackOutput$CryptoData)Assertions.checkNotNull((TrackOutput$CryptoData)((ArrayList)object).get(n10));
        } else {
            Object object4;
            int n11;
            int n12 = 0;
            object3 = null;
            Object object5 = REGEX_CRYPTO_INFO_PATTERN;
            Object object6 = object.toString();
            object5 = ((Pattern)object5).matcher((CharSequence)object6);
            ((Matcher)object5).find();
            int n13 = 1;
            object6 = ((Matcher)object5).group(n13);
            object6 = Util.castNonNull(object6);
            object6 = (String)object6;
            n13 = Integer.parseInt((String)object6);
            int n14 = 2;
            object5 = ((Matcher)object5).group(n14);
            object5 = Util.castNonNull(object5);
            object5 = (String)object5;
            try {
                n11 = Integer.parseInt((String)object5);
                n12 = n13;
            }
            catch (RuntimeException runtimeException) {
                object6 = String.valueOf(object);
                n14 = String.valueOf(object6).length() + 43;
                object4 = new StringBuilder(n14);
                ((StringBuilder)object4).append("Unexpected error while parsing CryptoInfo: ");
                ((StringBuilder)object4).append((String)object6);
                object6 = ((StringBuilder)object4).toString();
                String string2 = TAG;
                Log.e(string2, (String)object6, runtimeException);
                n11 = 0;
                Object var6_8 = null;
            }
            n14 = ((MediaCodec.CryptoInfo)object).mode;
            object4 = ((MediaCodec.CryptoInfo)object).key;
            object6 = new TrackOutput$CryptoData(n14, (byte[])object4, n12, n11);
            object3 = this.lastReceivedCryptoInfos;
            ((ArrayList)object3).set(n10, object);
            object = this.lastOutputCryptoDatas;
            ((ArrayList)object).set(n10, object6);
            object2 = object6;
        }
        return object2;
    }

    private static DrmInitData toExoPlayerDrmInitData(String string2, android.media.DrmInitData object) {
        if (object == null) {
            return null;
        }
        int n10 = object.getSchemeInitDataCount();
        DrmInitData$SchemeData[] drmInitData$SchemeDataArray = new DrmInitData$SchemeData[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            DrmInitData$SchemeData drmInitData$SchemeData;
            Object object2 = object.getSchemeInitDataAt(i10);
            UUID uUID = object2.uuid;
            String string3 = object2.mimeType;
            object2 = object2.data;
            drmInitData$SchemeDataArray[i10] = drmInitData$SchemeData = new DrmInitData$SchemeData(uUID, string3, (byte[])object2);
        }
        object = new DrmInitData(string2, drmInitData$SchemeDataArray);
        return object;
    }

    private Format toExoPlayerFormat(MediaParser.TrackData object) {
        int n10;
        Object object2 = ((MediaParser.TrackData)object).mediaFormat;
        Object object3 = object2.getString("mime");
        String string2 = "caption-service-number";
        int n11 = -1;
        int n12 = object2.getInteger(string2, n11);
        Object object4 = new Format$Builder();
        String string3 = object2.getString("crypto-mode-fourcc");
        object = ((MediaParser.TrackData)object).drmInitData;
        object = OutputConsumerAdapterV30.toExoPlayerDrmInitData(string3, (android.media.DrmInitData)object);
        object = ((Format$Builder)object4).setDrmInitData((DrmInitData)object);
        object4 = this.containerMimeType;
        object = ((Format$Builder)object).setContainerMimeType((String)object4);
        int n13 = object2.getInteger("bitrate", n11);
        object = ((Format$Builder)object).setPeakBitrate(n13);
        n13 = object2.getInteger("channel-count", n11);
        object = ((Format$Builder)object).setChannelCount(n13);
        object4 = OutputConsumerAdapterV30.getColorInfo((MediaFormat)object2);
        object = ((Format$Builder)object).setColorInfo((ColorInfo)object4).setSampleMimeType((String)object3);
        object4 = object2.getString("codecs-string");
        object = ((Format$Builder)object).setCodecs((String)object4);
        float f10 = object2.getFloat("frame-rate", -1.0f);
        object = ((Format$Builder)object).setFrameRate(f10);
        n13 = object2.getInteger("width", n11);
        object = ((Format$Builder)object).setWidth(n13);
        n13 = object2.getInteger("height", n11);
        object = ((Format$Builder)object).setHeight(n13);
        object4 = OutputConsumerAdapterV30.getInitializationData((MediaFormat)object2);
        object = ((Format$Builder)object).setInitializationData((List)object4);
        object4 = object2.getString("language");
        object = ((Format$Builder)object).setLanguage((String)object4);
        n13 = object2.getInteger("max-input-size", n11);
        object = ((Format$Builder)object).setMaxInputSize(n13);
        n13 = object2.getInteger("exo-pcm-encoding", n11);
        object = ((Format$Builder)object).setPcmEncoding(n13);
        string3 = null;
        n13 = object2.getInteger("rotation-degrees", 0);
        object = ((Format$Builder)object).setRotationDegrees(n13);
        object4 = "sample-rate";
        n11 = object2.getInteger((String)object4, n11);
        object = ((Format$Builder)object).setSampleRate(n11);
        n11 = OutputConsumerAdapterV30.getSelectionFlags((MediaFormat)object2);
        object = ((Format$Builder)object).setSelectionFlags(n11);
        n11 = object2.getInteger("encoder-delay", 0);
        object = ((Format$Builder)object).setEncoderDelay(n11);
        n11 = object2.getInteger("encoder-padding", 0);
        object = ((Format$Builder)object).setEncoderPadding(n11);
        n13 = 1065353216;
        f10 = 1.0f;
        float f11 = object2.getFloat("pixel-width-height-ratio-float", f10);
        object = ((Format$Builder)object).setPixelWidthHeightRatio(f11);
        String string4 = "subsample-offset-us-long";
        long l10 = Long.MAX_VALUE;
        long l11 = object2.getLong(string4, l10);
        object = ((Format$Builder)object).setSubsampleOffsetUs(l11).setAccessibilityChannel(n12);
        for (int i10 = 0; i10 < (n10 = (object2 = this.muxedCaptionFormats).size()); ++i10) {
            object2 = (Format)this.muxedCaptionFormats.get(i10);
            string4 = ((Format)object2).sampleMimeType;
            n11 = (int)(Util.areEqual(string4, object3) ? 1 : 0);
            if (n11 == 0 || (n11 = ((Format)object2).accessibilityChannel) != n12) continue;
            object3 = ((Format)object2).language;
            object3 = ((Format$Builder)object).setLanguage((String)object3);
            n12 = ((Format)object2).roleFlags;
            object3 = ((Format$Builder)object3).setRoleFlags(n12);
            n12 = ((Format)object2).selectionFlags;
            object3 = ((Format$Builder)object3).setSelectionFlags(n12);
            string2 = ((Format)object2).label;
            object3 = ((Format$Builder)object3).setLabel(string2);
            object2 = ((Format)object2).metadata;
            ((Format$Builder)object3).setMetadata((Metadata)object2);
            break;
        }
        return ((Format$Builder)object).build();
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int toTrackTypeConstant(String string2) {
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        block15: {
            String string3;
            block16: {
                n14 = -1;
                if (string2 == null) {
                    return n14;
                }
                string2.hashCode();
                n13 = string2.hashCode();
                n12 = 3;
                n11 = 2;
                n10 = 1;
                switch (n13) {
                    case 112202875: {
                        String string4 = "video";
                        n13 = (int)(string2.equals(string4) ? 1 : 0);
                        if (n13 == 0) break;
                        n13 = 4;
                        break block15;
                    }
                    case 93166550: {
                        String string5 = "audio";
                        n13 = (int)(string2.equals(string5) ? 1 : 0);
                        if (n13 == 0) break;
                        n13 = n12;
                        break block15;
                    }
                    case 3556653: {
                        String string6 = "text";
                        n13 = (int)(string2.equals(string6) ? 1 : 0);
                        if (n13 == 0) break;
                        n13 = n11;
                        break block15;
                    }
                    case -284840886: {
                        String string7 = "unknown";
                        n13 = (int)(string2.equals(string7) ? 1 : 0);
                        if (n13 == 0) break;
                        n13 = n10;
                        break block15;
                    }
                    case -450004177: {
                        string3 = "metadata";
                        n13 = (int)(string2.equals(string3) ? 1 : 0);
                        if (n13 != 0) break block16;
                    }
                }
                n13 = n14;
                break block15;
            }
            n13 = 0;
            string3 = null;
        }
        switch (n13) {
            default: {
                return MimeTypes.getTrackType(string2);
            }
            case 4: {
                return n11;
            }
            case 3: {
                return n10;
            }
            case 2: {
                return n12;
            }
            case 1: {
                return n14;
            }
            case 0: 
        }
        return 5;
    }

    public void disableSeeking() {
        this.seekingDisabled = true;
    }

    public ChunkIndex getChunkIndex() {
        return this.lastChunkIndex;
    }

    public MediaParser.SeekMap getDummySeekMap() {
        return this.dummySeekMap;
    }

    public Format[] getSampleFormats() {
        Object object;
        int n10;
        int n11 = this.tracksFoundCalled;
        if (n11 == 0) {
            return null;
        }
        n11 = this.trackFormats.size();
        Format[] formatArray = new Format[n11];
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.trackFormats)).size()); ++i10) {
            formatArray[i10] = object = (Format)Assertions.checkNotNull((Format)this.trackFormats.get(i10));
        }
        return formatArray;
    }

    public Pair getSeekPoints(long l10) {
        MediaParser.SeekMap seekMap = this.lastSeekMap;
        Pair pair = seekMap != null ? seekMap.getSeekPoints(l10) : SEEK_POINT_PAIR_START;
        return pair;
    }

    public void onSampleCompleted(int n10, long l10, int n11, int n12, int n13, MediaCodec.CryptoInfo cryptoInfo) {
        Object object;
        long l11;
        long l12 = this.sampleTimestampUpperLimitFilterUs;
        long l13 = -9223372036854775807L;
        long l14 = l12 - l13;
        Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 != false && (l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) >= 0) {
            return;
        }
        Object object3 = this.timestampAdjuster;
        if (object3 != null) {
            l10 = ((TimestampAdjuster)object3).adjustSampleTimestamp(l10);
        }
        object3 = object = Assertions.checkNotNull((TrackOutput)this.trackOutputs.get(n10));
        object3 = (TrackOutput)object;
        TrackOutput$CryptoData trackOutput$CryptoData = this.toExoPlayerCryptoData(n10, cryptoInfo);
        object3.sampleMetadata(l10, n11, n12, n13, trackOutput$CryptoData);
    }

    public void onSampleDataFound(int n10, MediaParser.InputReader inputReader) {
        this.ensureSpaceForTrackIndex(n10);
        this.scratchDataReaderAdapter.input = inputReader;
        Object object = (TrackOutput)this.trackOutputs.get(n10);
        if (object == null) {
            object = this.extractorOutput;
            int n11 = -1;
            object = object.track(n10, n11);
            ArrayList arrayList = this.trackOutputs;
            arrayList.set(n10, object);
        }
        OutputConsumerAdapterV30$DataReaderAdapter outputConsumerAdapterV30$DataReaderAdapter = this.scratchDataReaderAdapter;
        int n12 = (int)inputReader.getLength();
        object.sampleData(outputConsumerAdapterV30$DataReaderAdapter, n12, true);
    }

    public void onSeekMapFound(MediaParser.SeekMap object) {
        Object object2;
        boolean bl2 = this.expectDummySeekMap;
        if (bl2 && (object2 = this.dummySeekMap) == null) {
            this.dummySeekMap = object;
        } else {
            this.lastSeekMap = object;
            long l10 = object.getDurationMicros();
            ExtractorOutput extractorOutput = this.extractorOutput;
            Object object3 = this.seekingDisabled;
            if (object3) {
                long l11 = 0x80000000L;
                long l12 = l10 - l11;
                object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (!object3) {
                    l10 = -9223372036854775807L;
                }
                object = new SeekMap$Unseekable(l10);
            } else {
                object = object2 = new OutputConsumerAdapterV30$SeekMapAdapter((MediaParser.SeekMap)object);
            }
            extractorOutput.seekMap((SeekMap)object);
        }
    }

    public void onTrackCountFound(int n10) {
        this.tracksFoundCalled = true;
        this.maybeEndTracks();
    }

    public void onTrackDataFound(int n10, MediaParser.TrackData object) {
        int n11;
        Object object2;
        Object object3 = ((MediaParser.TrackData)object).mediaFormat;
        boolean bl2 = this.maybeObtainChunkIndex((MediaFormat)object3);
        if (bl2) {
            return;
        }
        this.ensureSpaceForTrackIndex(n10);
        object3 = (TrackOutput)this.trackOutputs.get(n10);
        if (object3 == null) {
            Object object4;
            object3 = ((MediaParser.TrackData)object).mediaFormat;
            object2 = MEDIA_FORMAT_KEY_TRACK_TYPE;
            if ((object3 = object3.getString((String)object2)) != null) {
                object2 = object3;
            } else {
                object2 = ((MediaParser.TrackData)object).mediaFormat;
                object4 = "mime";
                object2 = object2.getString((String)object4);
            }
            int n12 = OutputConsumerAdapterV30.toTrackTypeConstant((String)object2);
            n11 = this.primaryTrackType;
            if (n12 == n11) {
                this.primaryTrackIndex = n10;
            }
            object2 = this.extractorOutput.track(n10, n12);
            object4 = this.trackOutputs;
            ((ArrayList)object4).set(n10, object2);
            if (object3 != null) {
                return;
            }
            object3 = object2;
        }
        object = this.toExoPlayerFormat((MediaParser.TrackData)object);
        object2 = this.primaryTrackManifestFormat;
        object2 = object2 != null && n10 == (n11 = this.primaryTrackIndex) ? ((Format)object).withManifestFormatInfo((Format)object2) : object;
        object3.format((Format)object2);
        this.trackFormats.set(n10, object);
        this.maybeEndTracks();
    }

    public void setExtractorOutput(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    public void setMuxedCaptionFormats(List list) {
        this.muxedCaptionFormats = list;
    }

    public void setSampleTimestampUpperLimitFilterUs(long l10) {
        this.sampleTimestampUpperLimitFilterUs = l10;
    }

    public void setSelectedParserName(String string2) {
        this.containerMimeType = string2 = OutputConsumerAdapterV30.getMimeType(string2);
    }

    public void setTimestampAdjuster(TimestampAdjuster timestampAdjuster) {
        this.timestampAdjuster = timestampAdjuster;
    }
}

