/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.hls.Aes128DataSource;
import com.google.android.exoplayer2.source.hls.HlsChunkSource$SegmentBaseHolder;
import com.google.android.exoplayer2.source.hls.HlsExtractorFactory;
import com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.source.hls.TimestampAdjusterProvider;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Part;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$SegmentBase;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSpec$Builder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class HlsMediaChunk
extends MediaChunk {
    public static final String PRIV_TIMESTAMP_FRAME_OWNER = "com.apple.streaming.transportStreamTimestamp";
    private static final AtomicInteger uidSource;
    public final int discontinuitySequenceNumber;
    private final DrmInitData drmInitData;
    private HlsMediaChunkExtractor extractor;
    private final HlsExtractorFactory extractorFactory;
    private boolean extractorInvalidated;
    private final boolean hasGapTag;
    private final Id3Decoder id3Decoder;
    private boolean initDataLoadRequired;
    private final DataSource initDataSource;
    private final DataSpec initDataSpec;
    private final boolean initSegmentEncrypted;
    private final boolean isMasterTimestampSource;
    private boolean isPublished;
    private volatile boolean loadCanceled;
    private boolean loadCompleted;
    private final boolean mediaSegmentEncrypted;
    private final List muxedCaptionFormats;
    private int nextLoadPosition;
    private HlsSampleStreamWrapper output;
    public final int partIndex;
    public final Uri playlistUrl;
    private final HlsMediaChunkExtractor previousExtractor;
    private ImmutableList sampleQueueFirstSampleIndices;
    private final ParsableByteArray scratchId3Data;
    public final boolean shouldSpliceIn;
    private final TimestampAdjuster timestampAdjuster;
    public final int uid;

    static {
        AtomicInteger atomicInteger;
        uidSource = atomicInteger = new AtomicInteger();
    }

    private HlsMediaChunk(HlsExtractorFactory hlsExtractorFactory, DataSource dataSource, DataSpec dataSpec, Format format, boolean n10, DataSource dataSource2, DataSpec dataSpec2, boolean bl2, Uri uri, List list, int n11, Object object, long l10, long l11, long l12, int n12, boolean bl3, int n13, boolean bl4, boolean bl5, TimestampAdjuster timestampAdjuster, DrmInitData drmInitData, HlsMediaChunkExtractor hlsMediaChunkExtractor, Id3Decoder id3Decoder, ParsableByteArray parsableByteArray, boolean bl6) {
        HlsMediaChunk hlsMediaChunk = this;
        Object object2 = this;
        super(dataSource, dataSpec, format, n11, object, l10, l11, l12);
        int n14 = n10;
        this.mediaSegmentEncrypted = n10;
        n14 = n12;
        this.partIndex = n12;
        n14 = (int)(bl3 ? 1 : 0);
        this.isPublished = bl3;
        n14 = n13;
        this.discontinuitySequenceNumber = n13;
        this.initDataSpec = dataSpec2;
        object2 = dataSource2;
        this.initDataSource = dataSource2;
        if (dataSpec2 != null) {
            n14 = 1;
        } else {
            n14 = 0;
            object2 = null;
        }
        hlsMediaChunk.initDataLoadRequired = n14;
        n14 = (int)(bl2 ? 1 : 0);
        hlsMediaChunk.initSegmentEncrypted = bl2;
        object2 = uri;
        hlsMediaChunk.playlistUrl = uri;
        n14 = (int)(bl5 ? 1 : 0);
        hlsMediaChunk.isMasterTimestampSource = bl5;
        object2 = timestampAdjuster;
        hlsMediaChunk.timestampAdjuster = timestampAdjuster;
        n14 = (int)(bl4 ? 1 : 0);
        hlsMediaChunk.hasGapTag = bl4;
        object2 = hlsExtractorFactory;
        hlsMediaChunk.extractorFactory = hlsExtractorFactory;
        object2 = list;
        hlsMediaChunk.muxedCaptionFormats = list;
        object2 = drmInitData;
        hlsMediaChunk.drmInitData = drmInitData;
        object2 = hlsMediaChunkExtractor;
        hlsMediaChunk.previousExtractor = hlsMediaChunkExtractor;
        object2 = id3Decoder;
        hlsMediaChunk.id3Decoder = id3Decoder;
        object2 = parsableByteArray;
        hlsMediaChunk.scratchId3Data = parsableByteArray;
        n14 = (int)(bl6 ? 1 : 0);
        hlsMediaChunk.shouldSpliceIn = bl6;
        hlsMediaChunk.sampleQueueFirstSampleIndices = object2 = ImmutableList.of();
        hlsMediaChunk.uid = n14 = uidSource.getAndIncrement();
    }

    private static DataSource buildDataSource(DataSource dataSource, byte[] byArray, byte[] byArray2) {
        if (byArray != null) {
            Assertions.checkNotNull(byArray2);
            Aes128DataSource aes128DataSource = new Aes128DataSource(dataSource, byArray, byArray2);
            return aes128DataSource;
        }
        return dataSource;
    }

    public static HlsMediaChunk createInstance(HlsExtractorFactory hlsExtractorFactory, DataSource dataSource, Format format, long l10, HlsMediaPlaylist hlsMediaPlaylist, HlsChunkSource$SegmentBaseHolder hlsChunkSource$SegmentBaseHolder, Uri uri, List list, int n10, Object object, boolean bl2, TimestampAdjusterProvider timestampAdjusterProvider, HlsMediaChunk hlsMediaChunk, byte[] byArray, byte[] byArray2) {
        Object object2;
        Object object3;
        Object object4;
        boolean bl3;
        long l11;
        int n11;
        int n12;
        long l12;
        long l13;
        boolean bl4;
        Object object5;
        float f10;
        boolean bl5;
        Object object6;
        Object object7;
        DataSource dataSource2;
        Object object8;
        float f11;
        boolean bl6;
        DataSpec dataSpec;
        HlsMediaPlaylist$SegmentBase hlsMediaPlaylist$SegmentBase;
        Object object9;
        HlsChunkSource$SegmentBaseHolder hlsChunkSource$SegmentBaseHolder2;
        Object object10;
        DataSource dataSource3;
        block16: {
            int n13;
            Object object11;
            block12: {
                boolean bl7;
                Object object12;
                block15: {
                    block14: {
                        int n14;
                        block13: {
                            long l14;
                            boolean bl8;
                            dataSource3 = dataSource;
                            object10 = hlsMediaPlaylist;
                            hlsChunkSource$SegmentBaseHolder2 = hlsChunkSource$SegmentBaseHolder;
                            object9 = hlsMediaChunk;
                            Object object13 = byArray;
                            byte[] byArray3 = byArray2;
                            hlsMediaPlaylist$SegmentBase = hlsChunkSource$SegmentBaseHolder.segmentBase;
                            object11 = new DataSpec$Builder();
                            object12 = hlsMediaPlaylist.baseUri;
                            String string2 = hlsMediaPlaylist$SegmentBase.url;
                            object12 = UriUtil.resolveToUri((String)object12, string2);
                            object11 = ((DataSpec$Builder)object11).setUri((Uri)object12);
                            long l15 = hlsMediaPlaylist$SegmentBase.byteRangeOffset;
                            object11 = ((DataSpec$Builder)object11).setPosition(l15);
                            l15 = hlsMediaPlaylist$SegmentBase.byteRangeLength;
                            object11 = ((DataSpec$Builder)object11).setLength(l15);
                            n13 = hlsChunkSource$SegmentBaseHolder.isPreload;
                            if (n13 != 0) {
                                n13 = 8;
                            } else {
                                n13 = 0;
                                object12 = null;
                            }
                            object11 = ((DataSpec$Builder)object11).setFlags(n13);
                            dataSpec = ((DataSpec$Builder)object11).build();
                            if (object13 != null) {
                                bl6 = true;
                                f11 = Float.MIN_VALUE;
                            } else {
                                bl6 = false;
                                f11 = 0.0f;
                            }
                            if (bl6) {
                                object8 = HlsMediaChunk.getEncryptionIvArray((String)Assertions.checkNotNull(hlsMediaPlaylist$SegmentBase.encryptionIV));
                            } else {
                                bl8 = false;
                                object8 = null;
                            }
                            dataSource2 = HlsMediaChunk.buildDataSource(dataSource3, object13, object8);
                            object13 = hlsMediaPlaylist$SegmentBase.initializationSegment;
                            if (object13 != null) {
                                if (byArray3 != null) {
                                    bl8 = true;
                                } else {
                                    bl8 = false;
                                    object8 = null;
                                }
                                object7 = bl8 ? HlsMediaChunk.getEncryptionIvArray((String)Assertions.checkNotNull(object13.encryptionIV)) : null;
                                object6 = ((HlsPlaylist)object10).baseUri;
                                object12 = object13.url;
                                Uri uri2 = UriUtil.resolveToUri((String)object6, (String)object12);
                                long l16 = object13.byteRangeOffset;
                                bl5 = bl6;
                                f10 = f11;
                                long l17 = object13.byteRangeLength;
                                object5 = object12;
                                object12 = new DataSpec(uri2, l16, l17);
                                dataSource3 = HlsMediaChunk.buildDataSource(dataSource3, byArray3, object7);
                                bl4 = bl8;
                            } else {
                                bl5 = bl6;
                                f10 = f11;
                                dataSource3 = null;
                                object5 = null;
                                bl4 = false;
                                Object var37_36 = null;
                            }
                            l13 = hlsMediaPlaylist$SegmentBase.relativeStartTimeUs;
                            l13 = l10 + l13;
                            l15 = hlsMediaPlaylist$SegmentBase.durationUs;
                            l12 = l13 + l15;
                            n13 = ((HlsMediaPlaylist)object10).discontinuitySequence;
                            n12 = hlsMediaPlaylist$SegmentBase.relativeDiscontinuitySequence;
                            n13 += n12;
                            if (object9 == null) break block12;
                            string2 = ((HlsMediaChunk)object9).playlistUrl;
                            n12 = (int)(uri.equals((Object)string2) ? 1 : 0);
                            if (n12 != 0 && (n12 = (int)(((HlsMediaChunk)object9).loadCompleted ? 1 : 0)) != 0) {
                                n12 = 1;
                            } else {
                                n12 = 0;
                                string2 = null;
                            }
                            object8 = ((HlsMediaChunk)object9).id3Decoder;
                            object7 = ((HlsMediaChunk)object9).scratchId3Data;
                            n11 = HlsMediaChunk.isIndependent(hlsChunkSource$SegmentBaseHolder2, (HlsMediaPlaylist)object10);
                            n14 = n13;
                            boolean bl9 = n12 != 0 || n11 != 0 && (bl7 = (l14 = l13 - (l11 = ((Chunk)object9).endTimeUs)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) >= false;
                            n11 = 1;
                            bl7 = bl9 ^ true;
                            if (n12 == 0 || (n13 = (int)(((HlsMediaChunk)object9).extractorInvalidated ? 1 : 0)) != 0) break block13;
                            n13 = ((HlsMediaChunk)object9).discontinuitySequenceNumber;
                            n12 = n14;
                            if (n13 != n14) break block14;
                            object12 = ((HlsMediaChunk)object9).extractor;
                            break block15;
                        }
                        n12 = n14;
                    }
                    n13 = 0;
                    object12 = null;
                }
                bl3 = bl7;
                object4 = object12;
                object3 = object8;
                object2 = object7;
                break block16;
            }
            n12 = n13;
            object9 = new Id3Decoder();
            n13 = 10;
            object11 = new ParsableByteArray(n13);
            object3 = object9;
            object2 = object11;
            object4 = null;
            bl3 = false;
        }
        l11 = hlsChunkSource$SegmentBaseHolder2.mediaSequence;
        int n15 = hlsChunkSource$SegmentBaseHolder2.partIndex;
        boolean bl10 = hlsChunkSource$SegmentBaseHolder2.isPreload ^ true;
        boolean bl11 = hlsMediaPlaylist$SegmentBase.hasGapTag;
        object10 = timestampAdjusterProvider;
        TimestampAdjuster timestampAdjuster = timestampAdjusterProvider.getAdjuster(n12);
        object10 = hlsMediaPlaylist$SegmentBase.drmInitData;
        object8 = object9;
        object7 = hlsExtractorFactory;
        n11 = n15;
        object6 = format;
        bl6 = bl5;
        f11 = f10;
        object9 = new HlsMediaChunk(hlsExtractorFactory, dataSource2, dataSpec, format, bl5, dataSource3, (DataSpec)object5, bl4, uri, list, n10, object, l13, l12, l11, n15, bl10, n12, bl11, bl2, timestampAdjuster, (DrmInitData)object10, (HlsMediaChunkExtractor)object4, (Id3Decoder)object3, (ParsableByteArray)object2, bl3);
        return object9;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void feedDataToExtractor(DataSource var1_1, DataSpec var2_2, boolean var3_4) {
        block19: {
            var4_5 = 0;
            var5_6 = null;
            if (var3_4 != 0) {
                var3_4 = this.nextLoadPosition;
                if (var3_4 != 0) {
                    var4_5 = var3_4 = 1;
                }
                var6_10 = var2_2;
            } else {
                var3_4 = this.nextLoadPosition;
                var7_11 = var3_4;
                var6_10 = var2_2.subrange(var7_11);
            }
            var6_10 = this.prepareExtraction(var1_1, (DataSpec)var6_10);
            if (var4_5 != 0) {
                var4_5 = this.nextLoadPosition;
                var6_10.skipFully(var4_5);
            }
            {
                catch (Throwable var2_3) {
                    throw var2_3;
                }
                try {
                    while ((var4_5 = (int)this.loadCanceled) == 0 && (var4_5 = (int)(var5_6 = this.extractor).read((ExtractorInput)var6_10)) != 0) {
                    }
                }
                catch (Throwable var5_7) {
                    ** GOTO lbl-1000
                }
                catch (EOFException var5_8) {}
                {
                    var14_17 = this.trackFormat;
                    var15_18 = var14_17.roleFlags & 16384;
                    if (var15_18 == 0) ** GOTO lbl-1000
                    var5_9 = this.extractor;
                    var5_9.onTruncatedSegmentParsed();
                }
                ** try [egrp 5[TRYBLOCK] [16 : 190->203)] { 
lbl33:
                // 1 sources

                var9_12 = var6_10.getPosition();
                var11_13 = var2_2.position;
lbl35:
                // 1 sources

                finally {
                    break block19;
                }
            }
            {
                var9_12 = var6_10.getPosition();
                var11_13 = var2_2.position;
            }
        }
        var13_15 = (int)(var9_12 -= var11_13);
        ** try [egrp 3[TRYBLOCK] [11 : 140->148)] { 
lbl42:
        // 1 sources

        this.nextLoadPosition = var13_15;
        return;
lbl-1000:
        // 1 sources

        {
            throw var5_8;
        }
lbl-1000:
        // 1 sources

        {
            var7_11 = var6_10.getPosition();
            var11_14 = var2_2.position;
        }
        var13_16 = (int)(var7_11 -= var11_14);
        {
            this.nextLoadPosition = var13_16;
            throw var5_7;
        }
lbl50:
        // 1 sources

        finally {
            Util.closeQuietly(var1_1);
        }
    }

    private static byte[] getEncryptionIvArray(String object) {
        String string2;
        Object object2 = Util.toLowerInvariant((String)object);
        boolean n10 = ((String)object2).startsWith(string2 = "0x");
        if (n10) {
            int n11 = 2;
            object = ((String)object).substring(n11);
        }
        int n12 = 16;
        object2 = new BigInteger((String)object, n12);
        object = ((BigInteger)object2).toByteArray();
        object2 = new byte[n12];
        int n13 = ((Object)object).length;
        n13 = n13 > n12 ? ((Object)object).length - n12 : 0;
        int n14 = ((Object)object).length;
        n12 = n12 - n14 + n13;
        n14 = ((Object)object).length - n13;
        System.arraycopy(object, n13, object2, n12, n14);
        return object2;
    }

    private static boolean isIndependent(HlsChunkSource$SegmentBaseHolder hlsChunkSource$SegmentBaseHolder, HlsMediaPlaylist hlsMediaPlaylist) {
        HlsMediaPlaylist$SegmentBase hlsMediaPlaylist$SegmentBase = hlsChunkSource$SegmentBaseHolder.segmentBase;
        boolean bl2 = hlsMediaPlaylist$SegmentBase instanceof HlsMediaPlaylist$Part;
        if (bl2) {
            boolean bl3;
            hlsMediaPlaylist$SegmentBase = (HlsMediaPlaylist$Part)hlsMediaPlaylist$SegmentBase;
            boolean bl4 = ((HlsMediaPlaylist$Part)hlsMediaPlaylist$SegmentBase).isIndependent;
            if (!(bl4 || !(bl3 = hlsChunkSource$SegmentBaseHolder.partIndex) && (bl3 = hlsMediaPlaylist.hasIndependentSegments))) {
                bl3 = false;
                hlsChunkSource$SegmentBaseHolder = null;
            } else {
                bl3 = true;
            }
            return bl3;
        }
        return hlsMediaPlaylist.hasIndependentSegments;
    }

    private void loadMedia() {
        Object object;
        Object object2 = this.isMasterTimestampSource;
        if (!object2) {
            try {
                object = this.timestampAdjuster;
            }
            catch (InterruptedException interruptedException) {
                object = new InterruptedIOException();
                throw object;
            }
            ((TimestampAdjuster)object).waitUntilInitialized();
        } else {
            long l10;
            object = this.timestampAdjuster;
            long l11 = ((TimestampAdjuster)object).getFirstSampleTimestampUs();
            long l12 = l11 - (l10 = Long.MAX_VALUE);
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (!object2) {
                object = this.timestampAdjuster;
                long l13 = this.startTimeUs;
                ((TimestampAdjuster)object).setFirstSampleTimestampUs(l13);
            }
        }
        object = this.dataSource;
        DataSpec dataSpec = this.dataSpec;
        boolean bl2 = this.mediaSegmentEncrypted;
        this.feedDataToExtractor((DataSource)object, dataSpec, bl2);
    }

    private void maybeLoadInitData() {
        boolean bl2 = this.initDataLoadRequired;
        if (!bl2) {
            return;
        }
        Assertions.checkNotNull(this.initDataSource);
        Assertions.checkNotNull(this.initDataSpec);
        DataSource dataSource = this.initDataSource;
        DataSpec dataSpec = this.initDataSpec;
        boolean bl3 = this.initSegmentEncrypted;
        this.feedDataToExtractor(dataSource, dataSpec, bl3);
        this.nextLoadPosition = 0;
        this.initDataLoadRequired = false;
    }

    private long peekId3PrivTimestamp(ExtractorInput object) {
        Object object2;
        Object object3;
        int n10;
        Object object4;
        int n11;
        int n12;
        long l10;
        block8: {
            int n13;
            object.resetPeekPosition();
            l10 = -9223372036854775807L;
            Object object5 = this.scratchId3Data;
            n12 = 10;
            ((ParsableByteArray)object5).reset(n12);
            object5 = this.scratchId3Data;
            object5 = ((ParsableByteArray)object5).getData();
            try {
                object.peekFully((byte[])object5, 0, n12);
                object5 = this.scratchId3Data;
                n11 = ((ParsableByteArray)object5).readUnsignedInt24();
                n13 = 0x494433;
                if (n11 != n13) {
                    return l10;
                }
                this.scratchId3Data.skipBytes(3);
                object5 = this.scratchId3Data;
                n11 = ((ParsableByteArray)object5).readSynchSafeInt();
                n13 = n11 + 10;
                object4 = this.scratchId3Data;
                n10 = ((ParsableByteArray)object4).capacity();
                if (n13 <= n10) break block8;
            }
            catch (EOFException eOFException) {}
            object4 = this.scratchId3Data.getData();
            object3 = this.scratchId3Data;
            ((ParsableByteArray)object3).reset(n13);
            object2 = this.scratchId3Data.getData();
            System.arraycopy(object4, 0, object2, 0, n12);
        }
        object2 = this.scratchId3Data.getData();
        object.peekFully((byte[])object2, n12, n11);
        object = this.id3Decoder;
        byte[] byArray = this.scratchId3Data.getData();
        object = ((Id3Decoder)object).decode(byArray, n11);
        if (object == null) {
            return l10;
        }
        n11 = ((Metadata)object).length();
        byArray = null;
        for (n12 = 0; n12 < n11; ++n12) {
            object2 = ((Metadata)object).get(n12);
            n10 = object2 instanceof PrivFrame;
            if (n10 == 0) continue;
            object2 = (PrivFrame)object2;
            object3 = PRIV_TIMESTAMP_FRAME_OWNER;
            object4 = object2.owner;
            n10 = (int)(((String)object3).equals(object4) ? 1 : 0);
            if (n10 == 0) continue;
            object = object2.privateData;
            byte[] byArray2 = this.scratchId3Data.getData();
            int n14 = 8;
            System.arraycopy(object, 0, byArray2, 0, n14);
            this.scratchId3Data.setPosition(0);
            this.scratchId3Data.setLimit(n14);
            return this.scratchId3Data.readLong() & 0x1FFFFFFFFL;
        }
        return l10;
    }

    private DefaultExtractorInput prepareExtraction(DataSource dataSource, DataSpec dataSpec) {
        DefaultExtractorInput defaultExtractorInput;
        HlsMediaChunk hlsMediaChunk = this;
        Object object = dataSpec;
        long l10 = dataSource.open(dataSpec);
        long l11 = dataSpec.position;
        Object object2 = defaultExtractorInput;
        defaultExtractorInput = new DefaultExtractorInput(dataSource, l11, l10);
        object2 = this.extractor;
        if (object2 == null) {
            long l12 = this.peekId3PrivTimestamp(defaultExtractorInput);
            defaultExtractorInput.resetPeekPosition();
            Object object3 = this.previousExtractor;
            if (object3 != null) {
                object = object3.recreate();
            } else {
                HlsExtractorFactory hlsExtractorFactory = this.extractorFactory;
                Uri uri = dataSpec.uri;
                Format format = this.trackFormat;
                List list = this.muxedCaptionFormats;
                TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
                Map map = dataSource.getResponseHeaders();
                object = hlsExtractorFactory.createExtractor(uri, format, list, timestampAdjuster, map, defaultExtractorInput);
            }
            hlsMediaChunk.extractor = object;
            boolean bl2 = object.isPackedAudioExtractor();
            if (bl2) {
                object = hlsMediaChunk.output;
                l11 = -9223372036854775807L;
                long l13 = l12 - l11;
                Object object4 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object4 != false) {
                    object3 = hlsMediaChunk.timestampAdjuster;
                    l12 = ((TimestampAdjuster)object3).adjustTsTimestamp(l12);
                } else {
                    l12 = hlsMediaChunk.startTimeUs;
                }
                ((HlsSampleStreamWrapper)object).setSampleOffsetUs(l12);
            } else {
                object = hlsMediaChunk.output;
                l12 = 0L;
                ((HlsSampleStreamWrapper)object).setSampleOffsetUs(l12);
            }
            hlsMediaChunk.output.onNewExtractor();
            object = hlsMediaChunk.extractor;
            object2 = hlsMediaChunk.output;
            object.init((ExtractorOutput)object2);
        }
        object = hlsMediaChunk.output;
        object2 = hlsMediaChunk.drmInitData;
        ((HlsSampleStreamWrapper)object).setDrmInitData((DrmInitData)object2);
        return defaultExtractorInput;
    }

    public void cancelLoad() {
        this.loadCanceled = true;
    }

    public int getFirstSampleIndex(int n10) {
        Assertions.checkState(this.shouldSpliceIn ^ true);
        ImmutableList immutableList = this.sampleQueueFirstSampleIndices;
        int n11 = immutableList.size();
        if (n10 >= n11) {
            return 0;
        }
        return (Integer)this.sampleQueueFirstSampleIndices.get(n10);
    }

    public void init(HlsSampleStreamWrapper hlsSampleStreamWrapper, ImmutableList immutableList) {
        this.output = hlsSampleStreamWrapper;
        this.sampleQueueFirstSampleIndices = immutableList;
    }

    public void invalidateExtractor() {
        this.extractorInvalidated = true;
    }

    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    public boolean isPublished() {
        return this.isPublished;
    }

    public void load() {
        boolean bl2;
        Assertions.checkNotNull(this.output);
        HlsMediaChunkExtractor hlsMediaChunkExtractor = this.extractor;
        if (hlsMediaChunkExtractor == null && (hlsMediaChunkExtractor = this.previousExtractor) != null && (bl2 = hlsMediaChunkExtractor.isReusable())) {
            this.extractor = hlsMediaChunkExtractor = this.previousExtractor;
            bl2 = false;
            hlsMediaChunkExtractor = null;
            this.initDataLoadRequired = false;
        }
        this.maybeLoadInitData();
        bl2 = this.loadCanceled;
        if (!bl2) {
            bl2 = this.hasGapTag;
            if (!bl2) {
                this.loadMedia();
            }
            this.loadCompleted = bl2 = this.loadCanceled ^ true;
        }
    }

    public void publish() {
        this.isPublished = true;
    }
}

