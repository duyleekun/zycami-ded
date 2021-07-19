/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.SparseIntArray
 */
package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleQueue$UpstreamFormatChangedListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.hls.HlsChunkSource;
import com.google.android.exoplayer2.source.hls.HlsChunkSource$HlsChunkHolder;
import com.google.android.exoplayer2.source.hls.HlsMediaChunk;
import com.google.android.exoplayer2.source.hls.HlsSampleStream;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$Callback;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$EmsgUnwrappingTrackOutput;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$HlsSampleQueue;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader$Callback;
import com.google.android.exoplayer2.upstream.Loader$LoadErrorAction;
import com.google.android.exoplayer2.upstream.Loader$Loadable;
import com.google.android.exoplayer2.upstream.Loader$ReleaseCallback;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import d.h.a.a.m0.o.b;
import d.h.a.a.m0.o.c;
import d.h.a.a.m0.o.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class HlsSampleStreamWrapper
implements Loader$Callback,
Loader$ReleaseCallback,
SequenceableLoader,
ExtractorOutput,
SampleQueue$UpstreamFormatChangedListener {
    private static final Set MAPPABLE_TYPES;
    public static final int SAMPLE_QUEUE_INDEX_NO_MAPPING_FATAL = 254;
    public static final int SAMPLE_QUEUE_INDEX_NO_MAPPING_NON_FATAL = 253;
    public static final int SAMPLE_QUEUE_INDEX_PENDING = 255;
    private static final String TAG = "HlsSampleStreamWrapper";
    private final Allocator allocator;
    private final HlsSampleStreamWrapper$Callback callback;
    private final HlsChunkSource chunkSource;
    private Format downstreamTrackFormat;
    private final DrmSessionEventListener$EventDispatcher drmEventDispatcher;
    private DrmInitData drmInitData;
    private final DrmSessionManager drmSessionManager;
    private TrackOutput emsgUnwrappingTrackOutput;
    private int enabledTrackGroupCount;
    private final Handler handler;
    private boolean haveAudioVideoSampleQueues;
    private final ArrayList hlsSampleStreams;
    private long lastSeekPositionUs;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Loader loader;
    private Chunk loadingChunk;
    private boolean loadingFinished;
    private final Runnable maybeFinishPrepareRunnable;
    private final ArrayList mediaChunks;
    private final MediaSourceEventListener$EventDispatcher mediaSourceEventDispatcher;
    private final int metadataType;
    private final Format muxedAudioFormat;
    private final HlsChunkSource$HlsChunkHolder nextChunkHolder;
    private final Runnable onTracksEndedRunnable;
    private Set optionalTrackGroups;
    private final Map overridingDrmInitData;
    private long pendingResetPositionUs;
    private boolean pendingResetUpstreamFormats;
    private boolean prepared;
    private int primarySampleQueueIndex;
    private int primarySampleQueueType;
    private int primaryTrackGroupIndex;
    private final List readOnlyMediaChunks;
    private boolean released;
    private long sampleOffsetUs;
    private SparseIntArray sampleQueueIndicesByType;
    private boolean[] sampleQueueIsAudioVideoFlags;
    private Set sampleQueueMappingDoneByType;
    private int[] sampleQueueTrackIds;
    private HlsSampleStreamWrapper$HlsSampleQueue[] sampleQueues;
    private boolean sampleQueuesBuilt;
    private boolean[] sampleQueuesEnabledStates;
    private boolean seenFirstTrackSelection;
    private HlsMediaChunk sourceChunk;
    private int[] trackGroupToSampleQueueIndex;
    private TrackGroupArray trackGroups;
    private final int trackType;
    private boolean tracksEnded;
    private Format upstreamTrackFormat;

    static {
        Integer n10;
        Integer n11;
        Integer n12;
        Object object = new Integer[3];
        int n13 = 1;
        object[0] = n12 = Integer.valueOf(n13);
        int n14 = 2;
        object[n13] = n11 = Integer.valueOf(n14);
        object[n14] = n10 = Integer.valueOf(5);
        object = Arrays.asList(object);
        HashSet hashSet = new HashSet(object);
        MAPPABLE_TYPES = Collections.unmodifiableSet(hashSet);
    }

    public HlsSampleStreamWrapper(int n10, HlsSampleStreamWrapper$Callback objectArray, HlsChunkSource object, Map map, Allocator allocator, long l10, Format format, DrmSessionManager drmSessionManager, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher, int n11) {
        this.trackType = n10;
        this.callback = objectArray;
        this.chunkSource = object;
        this.overridingDrmInitData = map;
        this.allocator = allocator;
        this.muxedAudioFormat = format;
        this.drmSessionManager = drmSessionManager;
        this.drmEventDispatcher = drmSessionEventListener$EventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.mediaSourceEventDispatcher = mediaSourceEventListener$EventDispatcher;
        this.metadataType = n11;
        Object object2 = new Loader("Loader:HlsSampleStreamWrapper");
        this.loader = object2;
        this.nextChunkHolder = object2 = new HlsChunkSource$HlsChunkHolder();
        objectArray = new int[0];
        this.sampleQueueTrackIds = (int[])objectArray;
        object = MAPPABLE_TYPES;
        int n12 = object.size();
        this.sampleQueueMappingDoneByType = objectArray = new HashSet(n12);
        int n13 = object.size();
        objectArray = new SparseIntArray(n13);
        this.sampleQueueIndicesByType = objectArray;
        objectArray = new HlsSampleStreamWrapper$HlsSampleQueue[]{};
        this.sampleQueues = objectArray;
        objectArray = new boolean[0];
        this.sampleQueueIsAudioVideoFlags = (boolean[])objectArray;
        object2 = new boolean[0];
        this.sampleQueuesEnabledStates = (boolean[])object2;
        object2 = new ArrayList();
        this.mediaChunks = object2;
        object2 = Collections.unmodifiableList(object2);
        this.readOnlyMediaChunks = object2;
        object2 = new ArrayList();
        this.hlsSampleStreams = object2;
        this.maybeFinishPrepareRunnable = object2 = new c(this);
        this.onTracksEndedRunnable = object2 = new b(this);
        object2 = Util.createHandlerForCurrentLooper();
        this.handler = object2;
        this.lastSeekPositionUs = l10;
        this.pendingResetPositionUs = l10;
    }

    public static /* synthetic */ void a(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        hlsSampleStreamWrapper.onTracksEnded();
    }

    private void assertIsPrepared() {
        Assertions.checkState(this.prepared);
        Assertions.checkNotNull(this.trackGroups);
        Assertions.checkNotNull(this.optionalTrackGroups);
    }

    public static /* synthetic */ void b(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        hlsSampleStreamWrapper.maybeFinishPrepare();
    }

    private void buildTracksFromSampleStreams() {
        int n10;
        Object object;
        int n11;
        int n12;
        Object object2 = this.sampleQueues;
        int n13 = ((HlsSampleStreamWrapper$HlsSampleQueue[])object2).length;
        int n14 = 7;
        float f10 = 9.8E-45f;
        int n15 = -1;
        int n16 = 0;
        int n17 = n14;
        int n18 = n15;
        int n19 = 0;
        while (true) {
            n12 = 2;
            n11 = 1;
            float f11 = Float.MIN_VALUE;
            if (n19 >= n13) break;
            object = ((Format)Assertions.checkStateNotNull((Object)this.sampleQueues[n19].getUpstreamFormat())).sampleMimeType;
            boolean bl2 = MimeTypes.isVideo((String)object);
            if (!bl2) {
                n12 = (int)(MimeTypes.isAudio((String)object) ? 1 : 0);
                n12 = n12 != 0 ? n11 : ((n12 = (int)(MimeTypes.isText((String)object) ? 1 : 0)) != 0 ? 3 : n14);
            }
            if ((n11 = HlsSampleStreamWrapper.getTrackTypeScore(n12)) > (n10 = HlsSampleStreamWrapper.getTrackTypeScore(n17))) {
                n18 = n19;
                n17 = n12;
            } else if (n12 == n17 && n18 != n15) {
                n18 = n15;
            }
            ++n19;
        }
        TrackGroup trackGroup = this.chunkSource.getTrackGroup();
        n19 = trackGroup.length;
        this.primaryTrackGroupIndex = n15;
        Object[] objectArray = new int[n13];
        this.trackGroupToSampleQueueIndex = objectArray;
        objectArray = null;
        for (n15 = 0; n15 < n13; ++n15) {
            object = this.trackGroupToSampleQueueIndex;
            object[n15] = n15;
        }
        objectArray = new TrackGroup[n13];
        object = null;
        for (n10 = 0; n10 < n13; ++n10) {
            boolean bl3;
            Format[] formatArray;
            Object object3;
            Format[] formatArray2;
            Object object4 = (Format)Assertions.checkStateNotNull(this.sampleQueues[n10].getUpstreamFormat());
            if (n10 == n18) {
                formatArray2 = new Format[n19];
                if (n19 == n11) {
                    object3 = trackGroup.getFormat(0);
                    formatArray2[0] = object4 = object4.withManifestFormatInfo((Format)object3);
                } else {
                    object3 = null;
                    for (int i10 = 0; i10 < n19; ++i10) {
                        formatArray2[i10] = formatArray = HlsSampleStreamWrapper.deriveFormat(trackGroup.getFormat(i10), object4, n11 != 0);
                    }
                }
                object4 = new TrackGroup(formatArray2);
                objectArray[n10] = (int)object4;
                this.primaryTrackGroupIndex = n10;
                continue;
            }
            if (n17 == n12 && (bl3 = MimeTypes.isAudio((String)(formatArray2 = object4.sampleMimeType)))) {
                formatArray2 = this.muxedAudioFormat;
            } else {
                bl3 = false;
                formatArray2 = null;
            }
            formatArray = new Format[n11];
            formatArray[0] = object4 = HlsSampleStreamWrapper.deriveFormat((Format)formatArray2, object4, false);
            object3 = new TrackGroup(formatArray);
            objectArray[n10] = (int)object3;
        }
        this.trackGroups = object2 = this.createTrackGroupArrayWithDrmInfo((TrackGroup[])objectArray);
        object2 = this.optionalTrackGroups;
        if (object2 == null) {
            n16 = n11;
        }
        Assertions.checkState(n16 != 0);
        this.optionalTrackGroups = object2 = Collections.emptySet();
    }

    private boolean canDiscardUpstreamMediaChunksFromIndex(int n10) {
        HlsSampleStreamWrapper$HlsSampleQueue[] hlsSampleStreamWrapper$HlsSampleQueueArray;
        int n11;
        int n12;
        for (n12 = n10; n12 < (n11 = (hlsSampleStreamWrapper$HlsSampleQueueArray = this.mediaChunks).size()); ++n12) {
            hlsSampleStreamWrapper$HlsSampleQueueArray = (HlsMediaChunk)this.mediaChunks.get(n12);
            n11 = (int)(hlsSampleStreamWrapper$HlsSampleQueueArray.shouldSpliceIn ? 1 : 0);
            if (n11 == 0) continue;
            return false;
        }
        HlsMediaChunk hlsMediaChunk = (HlsMediaChunk)this.mediaChunks.get(n10);
        for (n12 = 0; n12 < (n11 = (hlsSampleStreamWrapper$HlsSampleQueueArray = this.sampleQueues).length); ++n12) {
            n11 = hlsMediaChunk.getFirstSampleIndex(n12);
            HlsSampleStreamWrapper$HlsSampleQueue hlsSampleStreamWrapper$HlsSampleQueue = this.sampleQueues[n12];
            int n13 = hlsSampleStreamWrapper$HlsSampleQueue.getReadIndex();
            if (n13 <= n11) continue;
            return false;
        }
        return true;
    }

    private static DummyTrackOutput createFakeTrackOutput(int n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("Unmapped track with id ");
        stringBuilder.append(n10);
        stringBuilder.append(" of type ");
        stringBuilder.append(n11);
        Object object = stringBuilder.toString();
        Log.w(TAG, (String)object);
        object = new DummyTrackOutput();
        return object;
    }

    private SampleQueue createSampleQueue(int n10, int n11) {
        HlsSampleStreamWrapper$HlsSampleQueue hlsSampleStreamWrapper$HlsSampleQueue;
        Integer n12;
        int n13;
        HlsSampleStreamWrapper$HlsSampleQueue[] hlsSampleStreamWrapper$HlsSampleQueueArray = this.sampleQueues;
        int n14 = hlsSampleStreamWrapper$HlsSampleQueueArray.length;
        int n15 = 1;
        if (n11 != n15 && n11 != (n13 = 2)) {
            n15 = 0;
            n12 = null;
        }
        Allocator allocator = this.allocator;
        Looper looper = this.handler.getLooper();
        DrmSessionManager drmSessionManager = this.drmSessionManager;
        DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.drmEventDispatcher;
        Map map = this.overridingDrmInitData;
        Object object = hlsSampleStreamWrapper$HlsSampleQueue;
        hlsSampleStreamWrapper$HlsSampleQueue = new HlsSampleStreamWrapper$HlsSampleQueue(allocator, looper, drmSessionManager, drmSessionEventListener$EventDispatcher, map, null);
        if (n15 != 0) {
            object = this.drmInitData;
            hlsSampleStreamWrapper$HlsSampleQueue.setDrmInitData((DrmInitData)object);
        }
        long l10 = this.sampleOffsetUs;
        hlsSampleStreamWrapper$HlsSampleQueue.setSampleOffsetUs(l10);
        object = this.sourceChunk;
        if (object != null) {
            hlsSampleStreamWrapper$HlsSampleQueue.setSourceChunk((HlsMediaChunk)object);
        }
        hlsSampleStreamWrapper$HlsSampleQueue.setUpstreamFormatChangeListener(this);
        object = this.sampleQueueTrackIds;
        int n16 = n14 + 1;
        object = Arrays.copyOf((int[])object, n16);
        this.sampleQueueTrackIds = (int[])object;
        object[n14] = n10;
        Object object2 = (HlsSampleStreamWrapper$HlsSampleQueue[])Util.nullSafeArrayAppend(this.sampleQueues, hlsSampleStreamWrapper$HlsSampleQueue);
        this.sampleQueues = object2;
        object2 = Arrays.copyOf(this.sampleQueueIsAudioVideoFlags, n16);
        this.sampleQueueIsAudioVideoFlags = (boolean[])object2;
        object2[n14] = (HlsSampleStreamWrapper$HlsSampleQueue)n15;
        n15 = (int)(this.haveAudioVideoSampleQueues ? 1 : 0);
        n10 = object2[n14] | n15;
        this.haveAudioVideoSampleQueues = n10;
        object2 = this.sampleQueueMappingDoneByType;
        n12 = n11;
        object2.add(n12);
        object2 = this.sampleQueueIndicesByType;
        object2.append(n11, n14);
        n10 = HlsSampleStreamWrapper.getTrackTypeScore(n11);
        n15 = HlsSampleStreamWrapper.getTrackTypeScore(this.primarySampleQueueType);
        if (n10 > n15) {
            this.primarySampleQueueIndex = n14;
            this.primarySampleQueueType = n11;
        }
        object2 = Arrays.copyOf(this.sampleQueuesEnabledStates, n16);
        this.sampleQueuesEnabledStates = (boolean[])object2;
        return hlsSampleStreamWrapper$HlsSampleQueue;
    }

    private TrackGroupArray createTrackGroupArrayWithDrmInfo(TrackGroup[] trackGroupArray) {
        int n10;
        TrackGroupArray trackGroupArray2 = null;
        for (int i10 = 0; i10 < (n10 = trackGroupArray.length); ++i10) {
            int n11;
            TrackGroup trackGroup = trackGroupArray[i10];
            int n12 = trackGroup.length;
            Format[] formatArray = new Format[n12];
            for (int i11 = 0; i11 < (n11 = trackGroup.length); ++i11) {
                Format format = trackGroup.getFormat(i11);
                Class clazz = this.drmSessionManager.getExoMediaCryptoType(format);
                formatArray[i11] = format = format.copyWithExoMediaCryptoType(clazz);
            }
            trackGroupArray[i10] = trackGroup = new TrackGroup(formatArray);
        }
        trackGroupArray2 = new TrackGroupArray(trackGroupArray);
        return trackGroupArray2;
    }

    /*
     * WARNING - void declaration
     */
    private static Format deriveFormat(Format object, Format object2, boolean bl2) {
        void var2_5;
        int n10;
        if (object == null) {
            return object2;
        }
        String string2 = ((Format)object).codecs;
        String string3 = ((Format)object2).sampleMimeType;
        int n11 = MimeTypes.getTrackType(string3);
        int n12 = Util.getCodecCountOfType(string2, n11);
        if (n12 == (n10 = 1)) {
            string3 = Util.getCodecsOfType(((Format)object).codecs, n11);
            string2 = MimeTypes.getMediaMimeType(string3);
        } else {
            string3 = ((Format)object).codecs;
            string2 = ((Format)object2).sampleMimeType;
            string3 = MimeTypes.getCodecsCorrespondingToMimeType(string3, string2);
            string2 = ((Format)object2).sampleMimeType;
        }
        Format$Builder format$Builder = ((Format)object2).buildUpon();
        String string4 = ((Format)object).id;
        format$Builder = format$Builder.setId(string4);
        string4 = ((Format)object).label;
        format$Builder = format$Builder.setLabel(string4);
        string4 = ((Format)object).language;
        format$Builder = format$Builder.setLanguage(string4);
        int n13 = ((Format)object).selectionFlags;
        format$Builder = format$Builder.setSelectionFlags(n13);
        n13 = ((Format)object).roleFlags;
        format$Builder = format$Builder.setRoleFlags(n13);
        n13 = -1;
        int n14 = bl2 ? ((Format)object).averageBitrate : n13;
        format$Builder = format$Builder.setAverageBitrate(n14);
        if (bl2) {
            int n15 = ((Format)object).peakBitrate;
        } else {
            int n16 = n13;
        }
        Format$Builder format$Builder2 = format$Builder.setPeakBitrate((int)var2_5).setCodecs(string3);
        n11 = ((Format)object).width;
        format$Builder2 = format$Builder2.setWidth(n11);
        n11 = ((Format)object).height;
        format$Builder2 = format$Builder2.setHeight(n11);
        if (string2 != null) {
            format$Builder2.setSampleMimeType(string2);
        }
        if ((n11 = ((Format)object).channelCount) != n13) {
            format$Builder2.setChannelCount(n11);
        }
        if ((object = ((Format)object).metadata) != null) {
            object2 = ((Format)object2).metadata;
            if (object2 != null) {
                object = ((Metadata)object2).copyWithAppendedEntriesFrom((Metadata)object);
            }
            format$Builder2.setMetadata((Metadata)object);
        }
        return format$Builder2.build();
    }

    private void discardUpstream(int n10) {
        int n11;
        int n12;
        Object object;
        block5: {
            object = this.loader;
            n12 = ((Loader)object).isLoading() ^ 1;
            Assertions.checkState(n12 != 0);
            while (true) {
                object = this.mediaChunks;
                n12 = ((ArrayList)object).size();
                n11 = -1;
                if (n10 >= n12) break;
                n12 = (int)(this.canDiscardUpstreamMediaChunksFromIndex(n10) ? 1 : 0);
                if (n12 == 0) {
                    ++n10;
                    continue;
                }
                break block5;
                break;
            }
            n10 = n11;
        }
        if (n10 == n11) {
            return;
        }
        long l10 = this.getLastMediaChunk().endTimeUs;
        HlsMediaChunk hlsMediaChunk = this.discardUpstreamMediaChunksFromIndex(n10);
        object = this.mediaChunks;
        n12 = (int)(((ArrayList)object).isEmpty() ? 1 : 0);
        if (n12 != 0) {
            long l11;
            this.pendingResetPositionUs = l11 = this.lastSeekPositionUs;
        } else {
            object = (HlsMediaChunk)Iterables.getLast(this.mediaChunks);
            ((HlsMediaChunk)object).invalidateExtractor();
        }
        this.loadingFinished = false;
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.mediaSourceEventDispatcher;
        int n13 = this.primarySampleQueueType;
        long l12 = hlsMediaChunk.startTimeUs;
        mediaSourceEventListener$EventDispatcher.upstreamDiscarded(n13, l12, l10);
    }

    private HlsMediaChunk discardUpstreamMediaChunksFromIndex(int n10) {
        int n11;
        HlsMediaChunk hlsMediaChunk = (HlsMediaChunk)this.mediaChunks.get(n10);
        HlsSampleStreamWrapper$HlsSampleQueue[] hlsSampleStreamWrapper$HlsSampleQueueArray = this.mediaChunks;
        int n12 = hlsSampleStreamWrapper$HlsSampleQueueArray.size();
        Util.removeRange((List)hlsSampleStreamWrapper$HlsSampleQueueArray, n10, n12);
        for (n10 = 0; n10 < (n11 = (hlsSampleStreamWrapper$HlsSampleQueueArray = this.sampleQueues).length); ++n10) {
            n11 = hlsMediaChunk.getFirstSampleIndex(n10);
            HlsSampleStreamWrapper$HlsSampleQueue hlsSampleStreamWrapper$HlsSampleQueue = this.sampleQueues[n10];
            hlsSampleStreamWrapper$HlsSampleQueue.discardUpstreamSamples(n11);
        }
        return hlsMediaChunk;
    }

    private boolean finishedReadingChunk(HlsMediaChunk hlsMediaChunk) {
        int n10 = hlsMediaChunk.uid;
        HlsSampleStreamWrapper$HlsSampleQueue[] hlsSampleStreamWrapper$HlsSampleQueueArray = this.sampleQueues;
        int n11 = hlsSampleStreamWrapper$HlsSampleQueueArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object = this.sampleQueuesEnabledStates;
            int n12 = object[i10];
            if (n12 == 0 || (n12 = (object = (Object)this.sampleQueues[i10]).peekSourceId()) != n10) continue;
            return false;
        }
        return true;
    }

    private static boolean formatsMatch(Format format, Format format2) {
        boolean bl2;
        String string2 = format.sampleMimeType;
        String string3 = format2.sampleMimeType;
        int n10 = MimeTypes.getTrackType(string2);
        boolean bl3 = true;
        int n11 = 3;
        if (n10 != n11) {
            int n12 = MimeTypes.getTrackType(string3);
            if (n10 != n12) {
                bl3 = false;
            }
            return bl3;
        }
        boolean bl4 = Util.areEqual(string2, string3);
        if (!bl4) {
            return false;
        }
        string3 = "application/cea-608";
        bl4 = string3.equals(string2);
        if (!bl4 && !(bl2 = (string3 = "application/cea-708").equals(string2))) {
            return bl3;
        }
        int n13 = format.accessibilityChannel;
        int n14 = format2.accessibilityChannel;
        if (n13 != n14) {
            bl3 = false;
        }
        return bl3;
    }

    private HlsMediaChunk getLastMediaChunk() {
        ArrayList arrayList = this.mediaChunks;
        int n10 = arrayList.size() + -1;
        return (HlsMediaChunk)arrayList.get(n10);
    }

    private TrackOutput getMappedTrackOutput(int n10, int n11) {
        Set set = MAPPABLE_TYPES;
        Object object = n11;
        Assertions.checkArgument(set.contains(object));
        set = this.sampleQueueIndicesByType;
        Object object2 = -1;
        int n12 = set.get(n11, (int)object2);
        if (n12 == object2) {
            return null;
        }
        object = this.sampleQueueMappingDoneByType;
        Integer n13 = n11;
        object2 = object.add(n13);
        if (object2 != 0) {
            object = this.sampleQueueTrackIds;
            object[n12] = n10;
        }
        TrackOutput trackOutput = (object2 = (Object)(object = (Object)this.sampleQueueTrackIds)[n12]) == n10 ? this.sampleQueues[n12] : HlsSampleStreamWrapper.createFakeTrackOutput(n10, n11);
        return trackOutput;
    }

    private static int getTrackTypeScore(int n10) {
        int n11 = 2;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 3;
            if (n10 != n11) {
                if (n10 != n13) {
                    return 0;
                }
                return n12;
            }
            return n13;
        }
        return n11;
    }

    private void initMediaChunkLoad(HlsMediaChunk hlsMediaChunk) {
        int n10;
        long l10;
        this.sourceChunk = hlsMediaChunk;
        HlsSampleStreamWrapper$HlsSampleQueue[] hlsSampleStreamWrapper$HlsSampleQueueArray = hlsMediaChunk.trackFormat;
        this.upstreamTrackFormat = hlsSampleStreamWrapper$HlsSampleQueueArray;
        this.pendingResetPositionUs = l10 = -9223372036854775807L;
        this.mediaChunks.add(hlsMediaChunk);
        hlsSampleStreamWrapper$HlsSampleQueueArray = ImmutableList.builder();
        HlsSampleStreamWrapper$HlsSampleQueue[] hlsSampleStreamWrapper$HlsSampleQueueArray2 = this.sampleQueues;
        int n11 = hlsSampleStreamWrapper$HlsSampleQueueArray2.length;
        int n12 = 0;
        for (n10 = 0; n10 < n11; ++n10) {
            int n13 = hlsSampleStreamWrapper$HlsSampleQueueArray2[n10].getWriteIndex();
            Integer n14 = n13;
            hlsSampleStreamWrapper$HlsSampleQueueArray.add(n14);
        }
        hlsSampleStreamWrapper$HlsSampleQueueArray = hlsSampleStreamWrapper$HlsSampleQueueArray.build();
        hlsMediaChunk.init(this, (ImmutableList)hlsSampleStreamWrapper$HlsSampleQueueArray);
        hlsSampleStreamWrapper$HlsSampleQueueArray = this.sampleQueues;
        int n15 = hlsSampleStreamWrapper$HlsSampleQueueArray.length;
        while (n12 < n15) {
            HlsSampleStreamWrapper$HlsSampleQueue hlsSampleStreamWrapper$HlsSampleQueue = hlsSampleStreamWrapper$HlsSampleQueueArray[n12];
            hlsSampleStreamWrapper$HlsSampleQueue.setSourceChunk(hlsMediaChunk);
            n10 = (int)(hlsMediaChunk.shouldSpliceIn ? 1 : 0);
            if (n10 != 0) {
                hlsSampleStreamWrapper$HlsSampleQueue.splice();
            }
            ++n12;
        }
    }

    private static boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof HlsMediaChunk;
    }

    private boolean isPendingReset() {
        long l10 = this.pendingResetPositionUs;
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object != false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    private void mapSampleQueuesToMatchTrackGroups() {
        Object object = this.trackGroups;
        int n10 = ((TrackGroupArray)object).length;
        Object object2 = new int[n10];
        this.trackGroupToSampleQueueIndex = object2;
        Arrays.fill((int[])object2, -1);
        boolean bl2 = false;
        object2 = null;
        block0: for (int i10 = 0; i10 < n10; ++i10) {
            Object object3;
            int n11;
            for (int i11 = 0; i11 < (n11 = ((HlsSampleStreamWrapper$HlsSampleQueue[])(object3 = this.sampleQueues)).length); ++i11) {
                Format format;
                boolean bl3 = HlsSampleStreamWrapper.formatsMatch((Format)(object3 = (Format)Assertions.checkStateNotNull(object3[i11].getUpstreamFormat())), format = this.trackGroups.get(i10).getFormat(0));
                if (!bl3) continue;
                object3 = this.trackGroupToSampleQueueIndex;
                object3[i10] = (HlsSampleStreamWrapper$HlsSampleQueue)i11;
                continue block0;
            }
        }
        object = this.hlsSampleStreams.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (HlsSampleStream)object.next();
            ((HlsSampleStream)object2).bindSampleQueue();
        }
    }

    private void maybeFinishPrepare() {
        Object object;
        boolean bl2 = this.released;
        if (!bl2 && (object = this.trackGroupToSampleQueueIndex) == null && (bl2 = this.sampleQueuesBuilt)) {
            object = this.sampleQueues;
            int n10 = ((int[])object).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                Format format = object[i10].getUpstreamFormat();
                if (format != null) continue;
                return;
            }
            object = this.trackGroups;
            if (object != null) {
                this.mapSampleQueuesToMatchTrackGroups();
            } else {
                this.buildTracksFromSampleStreams();
                this.setIsPrepared();
                object = this.callback;
                object.onPrepared();
            }
        }
    }

    private void onTracksEnded() {
        this.sampleQueuesBuilt = true;
        this.maybeFinishPrepare();
    }

    private void resetSampleQueues() {
        for (HlsSampleStreamWrapper$HlsSampleQueue hlsSampleStreamWrapper$HlsSampleQueue : this.sampleQueues) {
            boolean bl2 = this.pendingResetUpstreamFormats;
            hlsSampleStreamWrapper$HlsSampleQueue.reset(bl2);
        }
        this.pendingResetUpstreamFormats = false;
    }

    private boolean seekInsideBufferUs(long l10) {
        HlsSampleStreamWrapper$HlsSampleQueue[] hlsSampleStreamWrapper$HlsSampleQueueArray = this.sampleQueues;
        int n10 = hlsSampleStreamWrapper$HlsSampleQueueArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = this.sampleQueues[i10];
            Object object2 = ((SampleQueue)object).seekTo(l10, false);
            if (object2 || !(object2 = (object = (Object)this.sampleQueueIsAudioVideoFlags)[i10]) && (object2 = this.haveAudioVideoSampleQueues)) continue;
            return false;
        }
        return true;
    }

    private void setIsPrepared() {
        this.prepared = true;
    }

    private void updateSampleStreams(SampleStream[] sampleStreamArray) {
        ArrayList arrayList = this.hlsSampleStreams;
        arrayList.clear();
        for (SampleStream sampleStream : sampleStreamArray) {
            if (sampleStream == null) continue;
            ArrayList arrayList2 = this.hlsSampleStreams;
            sampleStream = (HlsSampleStream)sampleStream;
            arrayList2.add(sampleStream);
        }
    }

    public int bindSampleQueueToSampleStream(int n10) {
        this.assertIsPrepared();
        Assertions.checkNotNull(this.trackGroupToSampleQueueIndex);
        Object object = this.trackGroupToSampleQueueIndex;
        int n11 = object[n10];
        int n12 = -2;
        int n13 = -1;
        if (n11 == n13) {
            object = this.optionalTrackGroups;
            TrackGroupArray trackGroupArray = this.trackGroups;
            TrackGroup trackGroup = trackGroupArray.get(n10);
            if ((n10 = (int)(object.contains(trackGroup) ? 1 : 0)) != 0) {
                n12 = -3;
            }
            return n12;
        }
        boolean[] blArray = this.sampleQueuesEnabledStates;
        n13 = blArray[n11];
        if (n13 != 0) {
            return n12;
        }
        blArray[n11] = true;
        return n11;
    }

    public boolean continueLoading(long l10) {
        Object object;
        HlsSampleStreamWrapper hlsSampleStreamWrapper = this;
        boolean bl2 = this.loadingFinished;
        int n10 = 0;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = null;
        if (!(bl2 || (bl2 = ((Loader)(object = this.loader)).isLoading()) || (bl2 = ((Loader)(object = this.loader)).hasFatalError()))) {
            LoadEventInfo loadEventInfo;
            long l11;
            int n11;
            long l12;
            bl2 = this.isPendingReset();
            if (bl2) {
                object = Collections.emptyList();
                l12 = this.pendingResetPositionUs;
                for (HlsSampleStreamWrapper$HlsSampleQueue hlsSampleStreamWrapper$HlsSampleQueue : this.sampleQueues) {
                    long l13 = hlsSampleStreamWrapper.pendingResetPositionUs;
                    hlsSampleStreamWrapper$HlsSampleQueue.setStartTimeUs(l13);
                }
            } else {
                object = this.readOnlyMediaChunks;
                HlsMediaChunk hlsMediaChunk = this.getLastMediaChunk();
                n11 = hlsMediaChunk.isLoadCompleted();
                if (n11 != 0) {
                    l12 = hlsMediaChunk.endTimeUs;
                } else {
                    long l14 = this.lastSeekPositionUs;
                    l11 = hlsMediaChunk.startTimeUs;
                    l12 = Math.max(l14, l11);
                }
            }
            Object object2 = object;
            long l15 = l12;
            Object object3 = hlsSampleStreamWrapper.chunkSource;
            bl2 = hlsSampleStreamWrapper.prepared;
            boolean bl3 = true;
            boolean bl4 = !bl2 && (bl2 = object.isEmpty()) ? false : bl3;
            Object object4 = hlsSampleStreamWrapper.nextChunkHolder;
            l11 = l10;
            ((HlsChunkSource)object3).getNextChunk(l10, l15, (List)object2, bl4, (HlsChunkSource$HlsChunkHolder)object4);
            object = hlsSampleStreamWrapper.nextChunkHolder;
            n11 = ((HlsChunkSource$HlsChunkHolder)object).endOfStream;
            object3 = ((HlsChunkSource$HlsChunkHolder)object).chunk;
            Object object5 = ((HlsChunkSource$HlsChunkHolder)object).playlistUrl;
            ((HlsChunkSource$HlsChunkHolder)object).clear();
            if (n11 != 0) {
                hlsSampleStreamWrapper.pendingResetPositionUs = -9223372036854775807L;
                hlsSampleStreamWrapper.loadingFinished = bl3;
                return bl3;
            }
            if (object3 == null) {
                if (object5 != null) {
                    object = hlsSampleStreamWrapper.callback;
                    object.onPlaylistRefreshRequired((Uri)object5);
                }
                return false;
            }
            bl2 = HlsSampleStreamWrapper.isMediaChunk((Chunk)object3);
            if (bl2) {
                object = object3;
                object = (HlsMediaChunk)object3;
                hlsSampleStreamWrapper.initMediaChunkLoad((HlsMediaChunk)object);
            }
            hlsSampleStreamWrapper.loadingChunk = object3;
            object = hlsSampleStreamWrapper.loader;
            loadErrorHandlingPolicy = hlsSampleStreamWrapper.loadErrorHandlingPolicy;
            n11 = ((Chunk)object3).type;
            n10 = loadErrorHandlingPolicy.getMinimumLoadableRetryCount(n11);
            long l16 = ((Loader)object).startLoading((Loader$Loadable)object3, hlsSampleStreamWrapper, n10);
            object4 = hlsSampleStreamWrapper.mediaSourceEventDispatcher;
            long l17 = ((Chunk)object3).loadTaskId;
            DataSpec dataSpec = ((Chunk)object3).dataSpec;
            object5 = loadEventInfo;
            loadEventInfo = new LoadEventInfo(l17, dataSpec, l16);
            int n12 = ((Chunk)object3).type;
            int n13 = hlsSampleStreamWrapper.trackType;
            object = ((Chunk)object3).trackFormat;
            n10 = ((Chunk)object3).trackSelectionReason;
            Object object6 = ((Chunk)object3).trackSelectionData;
            l11 = ((Chunk)object3).startTimeUs;
            l15 = ((Chunk)object3).endTimeUs;
            ((MediaSourceEventListener$EventDispatcher)object4).loadStarted(loadEventInfo, n12, n13, (Format)object, n10, object6, l11, l15);
            return bl3;
        }
        return false;
    }

    public void continuePreparing() {
        boolean bl2 = this.prepared;
        if (!bl2) {
            long l10 = this.lastSeekPositionUs;
            this.continueLoading(l10);
        }
    }

    public void discardBuffer(long l10, boolean bl2) {
        int n10 = this.sampleQueuesBuilt;
        if (n10 != 0 && (n10 = this.isPendingReset()) == 0) {
            HlsSampleStreamWrapper$HlsSampleQueue[] hlsSampleStreamWrapper$HlsSampleQueueArray = this.sampleQueues;
            n10 = hlsSampleStreamWrapper$HlsSampleQueueArray.length;
            for (int i10 = 0; i10 < n10; ++i10) {
                HlsSampleStreamWrapper$HlsSampleQueue hlsSampleStreamWrapper$HlsSampleQueue = this.sampleQueues[i10];
                boolean[] blArray = this.sampleQueuesEnabledStates;
                boolean bl3 = blArray[i10];
                hlsSampleStreamWrapper$HlsSampleQueue.discardTo(l10, bl2, bl3);
            }
        }
    }

    public void endTracks() {
        this.tracksEnded = true;
        Handler handler = this.handler;
        Runnable runnable = this.onTracksEndedRunnable;
        handler.post(runnable);
    }

    public long getBufferedPositionUs() {
        int n10;
        boolean bl2 = this.loadingFinished;
        if (bl2) {
            return Long.MIN_VALUE;
        }
        bl2 = this.isPendingReset();
        if (bl2) {
            return this.pendingResetPositionUs;
        }
        long l10 = this.lastSeekPositionUs;
        Object object = this.getLastMediaChunk();
        boolean n11 = ((HlsMediaChunk)object).isLoadCompleted();
        if (!n11) {
            int n12;
            object = this.mediaChunks;
            n10 = ((ArrayList)object).size();
            if (n10 > (n12 = 1)) {
                object = this.mediaChunks;
                int n13 = ((ArrayList)object).size() + -2;
                object = (HlsMediaChunk)((ArrayList)object).get(n13);
            } else {
                n10 = 0;
                object = null;
            }
        }
        if (object != null) {
            long l11 = ((Chunk)object).endTimeUs;
            l10 = Math.max(l10, l11);
        }
        if ((n10 = this.sampleQueuesBuilt) != 0) {
            for (HlsSampleStreamWrapper$HlsSampleQueue hlsSampleStreamWrapper$HlsSampleQueue : this.sampleQueues) {
                long l12 = hlsSampleStreamWrapper$HlsSampleQueue.getLargestQueuedTimestampUs();
                l10 = Math.max(l10, l12);
            }
        }
        return l10;
    }

    public long getNextLoadPositionUs() {
        long l10;
        boolean bl2 = this.isPendingReset();
        if (bl2) {
            return this.pendingResetPositionUs;
        }
        bl2 = this.loadingFinished;
        if (bl2) {
            l10 = Long.MIN_VALUE;
        } else {
            HlsMediaChunk hlsMediaChunk = this.getLastMediaChunk();
            l10 = hlsMediaChunk.endTimeUs;
        }
        return l10;
    }

    public int getPrimaryTrackGroupIndex() {
        return this.primaryTrackGroupIndex;
    }

    public TrackGroupArray getTrackGroups() {
        this.assertIsPrepared();
        return this.trackGroups;
    }

    public boolean isLoading() {
        return this.loader.isLoading();
    }

    public boolean isReady(int n10) {
        HlsSampleStreamWrapper$HlsSampleQueue[] hlsSampleStreamWrapper$HlsSampleQueueArray;
        HlsSampleStreamWrapper$HlsSampleQueue hlsSampleStreamWrapper$HlsSampleQueue;
        boolean bl2 = this.isPendingReset();
        if (!bl2 && (n10 = (int)((hlsSampleStreamWrapper$HlsSampleQueue = (hlsSampleStreamWrapper$HlsSampleQueueArray = this.sampleQueues)[n10]).isReady(bl2 = this.loadingFinished) ? 1 : 0)) != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            hlsSampleStreamWrapper$HlsSampleQueue = null;
        }
        return n10 != 0;
    }

    public void maybeThrowError() {
        this.loader.maybeThrowError();
        this.chunkSource.maybeThrowError();
    }

    public void maybeThrowError(int n10) {
        this.maybeThrowError();
        this.sampleQueues[n10].maybeThrowError();
    }

    public void maybeThrowPrepareError() {
        this.maybeThrowError();
        boolean bl2 = this.loadingFinished;
        if (bl2 && !(bl2 = this.prepared)) {
            ParserException parserException = new ParserException("Loading finished before preparation is complete.");
            throw parserException;
        }
    }

    public void onLoadCanceled(Chunk chunk, long l10, long l11, boolean bl2) {
        LoadEventInfo loadEventInfo;
        HlsSampleStreamWrapper hlsSampleStreamWrapper = this;
        Object object = chunk;
        this.loadingChunk = null;
        long l12 = chunk.loadTaskId;
        DataSpec dataSpec = chunk.dataSpec;
        Object object2 = chunk.getUri();
        Map map = chunk.getResponseHeaders();
        long l13 = chunk.bytesLoaded();
        Object object3 = loadEventInfo;
        loadEventInfo = new LoadEventInfo(l12, dataSpec, (Uri)object2, map, l10, l11, l13);
        object3 = this.loadErrorHandlingPolicy;
        l12 = chunk.loadTaskId;
        object3.onLoadTaskConcluded(l12);
        object3 = this.mediaSourceEventDispatcher;
        int n10 = chunk.type;
        int n11 = this.trackType;
        object2 = chunk.trackFormat;
        int n12 = chunk.trackSelectionReason;
        Object object4 = chunk.trackSelectionData;
        long l14 = chunk.startTimeUs;
        long l15 = chunk.endTimeUs;
        ((MediaSourceEventListener$EventDispatcher)object3).loadCanceled(loadEventInfo, n10, n11, (Format)object2, n12, object4, l14, l15);
        if (!bl2) {
            int n13 = this.isPendingReset();
            if (n13 != 0 || (n13 = this.enabledTrackGroupCount) == 0) {
                this.resetSampleQueues();
            }
            if ((n13 = hlsSampleStreamWrapper.enabledTrackGroupCount) > 0) {
                object = hlsSampleStreamWrapper.callback;
                object.onContinueLoadingRequested(this);
            }
        }
    }

    public void onLoadCompleted(Chunk chunk, long l10, long l11) {
        LoadEventInfo loadEventInfo;
        Object object = chunk;
        this.loadingChunk = null;
        this.chunkSource.onChunkLoadCompleted(chunk);
        long l12 = chunk.loadTaskId;
        DataSpec dataSpec = chunk.dataSpec;
        Object object2 = chunk.getUri();
        Map map = chunk.getResponseHeaders();
        long l13 = chunk.bytesLoaded();
        Object object3 = loadEventInfo;
        loadEventInfo = new LoadEventInfo(l12, dataSpec, (Uri)object2, map, l10, l11, l13);
        object3 = this.loadErrorHandlingPolicy;
        l12 = chunk.loadTaskId;
        object3.onLoadTaskConcluded(l12);
        object3 = this.mediaSourceEventDispatcher;
        int n10 = chunk.type;
        int n11 = this.trackType;
        object2 = chunk.trackFormat;
        int n12 = chunk.trackSelectionReason;
        Object object4 = chunk.trackSelectionData;
        long l14 = chunk.startTimeUs;
        long l15 = chunk.endTimeUs;
        ((MediaSourceEventListener$EventDispatcher)object3).loadCompleted(loadEventInfo, n10, n11, (Format)object2, n12, object4, l14, l15);
        boolean bl2 = this.prepared;
        if (!bl2) {
            long l16 = this.lastSeekPositionUs;
            this.continueLoading(l16);
        } else {
            object = this.callback;
            object.onContinueLoadingRequested(this);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public Loader$LoadErrorAction onLoadError(Chunk chunk, long l10, long l11, IOException iOException, int n10) {
        Object object;
        boolean bl2;
        int n11;
        int n12;
        Object object2;
        HlsSampleStreamWrapper hlsSampleStreamWrapper = this;
        Object object3 = chunk;
        IOException iOException2 = iOException;
        boolean bl3 = HlsSampleStreamWrapper.isMediaChunk(chunk);
        if (bl3) {
            object2 = chunk;
            object2 = (HlsMediaChunk)chunk;
            n12 = ((HlsMediaChunk)object2).isPublished();
            if (n12 == 0 && (n12 = iOException instanceof HttpDataSource$InvalidResponseCodeException) != 0) {
                object2 = iOException;
                object2 = (HttpDataSource$InvalidResponseCodeException)iOException;
                n12 = ((HttpDataSource$InvalidResponseCodeException)object2).responseCode;
                n11 = 410;
                if (n12 == n11) return Loader.RETRY;
                n11 = 404;
                if (n12 == n11) {
                    return Loader.RETRY;
                }
            }
        }
        long l12 = chunk.bytesLoaded();
        long l13 = ((Chunk)object3).loadTaskId;
        Object object4 = ((Chunk)object3).dataSpec;
        Uri uri = chunk.getUri();
        Map map = chunk.getResponseHeaders();
        LoadEventInfo loadEventInfo = new LoadEventInfo(l13, (DataSpec)object4, uri, map, l10, l11, l12);
        int n13 = ((Chunk)object3).type;
        int n14 = hlsSampleStreamWrapper.trackType;
        Object object5 = ((Chunk)object3).trackFormat;
        int n15 = ((Chunk)object3).trackSelectionReason;
        Object object6 = ((Chunk)object3).trackSelectionData;
        long l14 = C.usToMs(((Chunk)object3).startTimeUs);
        long l15 = ((Chunk)object3).endTimeUs;
        long l16 = C.usToMs(l15);
        Object object7 = new MediaLoadData(n13, n14, (Format)object5, n15, object6, l14, l16);
        n14 = n10;
        Object object8 = new LoadErrorHandlingPolicy$LoadErrorInfo(loadEventInfo, (MediaLoadData)object7, iOException2, n10);
        object7 = hlsSampleStreamWrapper.loadErrorHandlingPolicy;
        long l17 = object7.getBlacklistDurationMsFor((LoadErrorHandlingPolicy$LoadErrorInfo)object8);
        long l18 = -9223372036854775807L;
        long l19 = l17 == l18 ? 0 : (l17 < l18 ? -1 : 1);
        boolean bl4 = false;
        if (l19 != false) {
            object7 = hlsSampleStreamWrapper.chunkSource;
            l19 = (long)((HlsChunkSource)object7).maybeExcludeTrack((Chunk)object3, l17);
            bl2 = l19;
        } else {
            bl2 = false;
        }
        l19 = 1;
        if (bl2) {
            long l20;
            long l21;
            if (bl3 && !(bl3 = (l21 = l12 - (l20 = 0L)) == 0L ? 0 : (l21 < 0L ? -1 : 1))) {
                object = hlsSampleStreamWrapper.mediaChunks;
                n12 = ((ArrayList)object).size() - l19;
                if ((object = (HlsMediaChunk)((ArrayList)object).remove(n12)) == object3) {
                    bl4 = l19;
                }
                Assertions.checkState(bl4);
                object = hlsSampleStreamWrapper.mediaChunks;
                bl3 = ((ArrayList)object).isEmpty();
                if (bl3) {
                    long l22;
                    hlsSampleStreamWrapper.pendingResetPositionUs = l22 = hlsSampleStreamWrapper.lastSeekPositionUs;
                } else {
                    object = (HlsMediaChunk)Iterables.getLast(hlsSampleStreamWrapper.mediaChunks);
                    ((HlsMediaChunk)object).invalidateExtractor();
                }
            }
            object = Loader.DONT_RETRY;
        } else {
            object = hlsSampleStreamWrapper.loadErrorHandlingPolicy;
            long l23 = object.getRetryDelayMsFor((LoadErrorHandlingPolicy$LoadErrorInfo)object8);
            long l24 = l23 - l18;
            n11 = (int)(l24 == 0L ? 0 : (l24 < 0L ? -1 : 1));
            object = n11 != 0 ? Loader.createRetryAction(false, l23) : Loader.DONT_RETRY_FATAL;
        }
        Object object9 = object;
        bl3 = ((Loader$LoadErrorAction)object).isRetry();
        boolean bl5 = bl3 ^ true;
        object = hlsSampleStreamWrapper.mediaSourceEventDispatcher;
        n11 = ((Chunk)object3).type;
        l19 = hlsSampleStreamWrapper.trackType;
        object8 = ((Chunk)object3).trackFormat;
        n14 = ((Chunk)object3).trackSelectionReason;
        object5 = ((Chunk)object3).trackSelectionData;
        l18 = ((Chunk)object3).startTimeUs;
        long l25 = ((Chunk)object3).endTimeUs;
        object2 = loadEventInfo;
        object7 = object8;
        n13 = n14;
        object4 = object5;
        iOException2 = iOException;
        ((MediaSourceEventListener$EventDispatcher)object).loadError(loadEventInfo, n11, (int)l19, (Format)object8, n14, object5, l18, l25, iOException, bl5);
        if (bl5) {
            bl3 = false;
            hlsSampleStreamWrapper.loadingChunk = null;
            object = hlsSampleStreamWrapper.loadErrorHandlingPolicy;
            l12 = ((Chunk)object3).loadTaskId;
            object.onLoadTaskConcluded(l12);
        }
        if (!bl2) return object9;
        boolean bl6 = hlsSampleStreamWrapper.prepared;
        if (!bl6) {
            long l26 = hlsSampleStreamWrapper.lastSeekPositionUs;
            hlsSampleStreamWrapper.continueLoading(l26);
            return object9;
        }
        object3 = hlsSampleStreamWrapper.callback;
        object3.onContinueLoadingRequested(hlsSampleStreamWrapper);
        return object9;
    }

    public void onLoaderReleased() {
        for (HlsSampleStreamWrapper$HlsSampleQueue hlsSampleStreamWrapper$HlsSampleQueue : this.sampleQueues) {
            hlsSampleStreamWrapper$HlsSampleQueue.release();
        }
    }

    public void onNewExtractor() {
        this.sampleQueueMappingDoneByType.clear();
    }

    public boolean onPlaylistError(Uri uri, long l10) {
        return this.chunkSource.onPlaylistError(uri, l10);
    }

    public void onPlaylistUpdated() {
        int n10;
        Object object = this.mediaChunks;
        boolean n11 = ((ArrayList)object).isEmpty();
        if (n11) {
            return;
        }
        HlsChunkSource hlsChunkSource = this.chunkSource;
        object = (HlsMediaChunk)Iterables.getLast(this.mediaChunks);
        int n12 = hlsChunkSource.getChunkPublicationState((HlsMediaChunk)object);
        if (n12 == (n10 = 1)) {
            ((HlsMediaChunk)object).publish();
        } else {
            boolean bl2;
            boolean bl3;
            int n13 = 2;
            if (n12 == n13 && !(bl3 = this.loadingFinished) && (bl2 = ((Loader)(object = this.loader)).isLoading())) {
                object = this.loader;
                ((Loader)object).cancelLoading();
            }
        }
    }

    public void onUpstreamFormatChanged(Format format) {
        format = this.handler;
        Runnable runnable = this.maybeFinishPrepareRunnable;
        format.post(runnable);
    }

    public void prepareWithMasterPlaylistInfo(TrackGroup[] handler, int n10, int ... object) {
        handler = this.createTrackGroupArrayWithDrmInfo((TrackGroup[])handler);
        this.trackGroups = handler;
        handler = new HashSet();
        this.optionalTrackGroups = handler;
        for (Object object2 : object) {
            Set set = this.optionalTrackGroups;
            TrackGroupArray trackGroupArray = this.trackGroups;
            TrackGroup trackGroup = trackGroupArray.get((int)object2);
            set.add(trackGroup);
        }
        this.primaryTrackGroupIndex = n10;
        handler = this.handler;
        HlsSampleStreamWrapper$Callback hlsSampleStreamWrapper$Callback = this.callback;
        Objects.requireNonNull(hlsSampleStreamWrapper$Callback);
        e e10 = new e(hlsSampleStreamWrapper$Callback);
        handler.post((Runnable)e10);
        this.setIsPrepared();
    }

    /*
     * WARNING - void declaration
     */
    public int readData(int n10, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean n11) {
        boolean bl2;
        boolean bl3;
        boolean n12 = this.isPendingReset();
        int n13 = -3;
        if (n12) {
            return n13;
        }
        Object object = this.mediaChunks;
        boolean bl4 = ((ArrayList)object).isEmpty();
        int n14 = 0;
        if (!bl4) {
            Object object2;
            int n15;
            void var5_8;
            boolean bl5 = false;
            object = null;
            while (++var5_8 < (n15 = ((ArrayList)(object2 = this.mediaChunks)).size() + -1) && (n15 = (int)(this.finishedReadingChunk((HlsMediaChunk)(object2 = (HlsMediaChunk)this.mediaChunks.get((int)var5_8))) ? 1 : 0)) != 0) {
            }
            Util.removeRange(this.mediaChunks, 0, (int)var5_8);
            object = (HlsMediaChunk)this.mediaChunks.get(0);
            Format format = ((Chunk)object).trackFormat;
            object2 = this.downstreamTrackFormat;
            n15 = (int)(format.equals(object2) ? 1 : 0);
            if (n15 == 0) {
                object2 = this.mediaSourceEventDispatcher;
                int n16 = this.trackType;
                int n17 = ((Chunk)object).trackSelectionReason;
                Object object3 = ((Chunk)object).trackSelectionData;
                long l10 = ((Chunk)object).startTimeUs;
                ((MediaSourceEventListener$EventDispatcher)object2).downstreamFormatChanged(n16, format, n17, object3, l10);
            }
            this.downstreamTrackFormat = format;
        }
        if (!(bl3 = ((ArrayList)(object = this.mediaChunks)).isEmpty()) && !(bl2 = ((HlsMediaChunk)(object = (HlsMediaChunk)this.mediaChunks.get(0))).isPublished())) {
            return n13;
        }
        object = this.sampleQueues[n10];
        boolean bl6 = this.loadingFinished;
        int n18 = ((SampleQueue)object).read(formatHolder, decoderInputBuffer, n11 != 0, bl6);
        if (n18 == (n11 = -5)) {
            Format format = (Format)Assertions.checkNotNull(formatHolder.format);
            int n19 = this.primarySampleQueueIndex;
            if (n10 == n19) {
                int n20;
                object = this.sampleQueues;
                Object object4 = object[n10];
                n10 = ((SampleQueue)object4).peekSourceId();
                while (n14 < (n20 = ((ArrayList)(object = this.mediaChunks)).size())) {
                    object = (HlsMediaChunk)this.mediaChunks.get(n14);
                    n20 = ((HlsMediaChunk)object).uid;
                    if (n20 == n10) break;
                    ++n14;
                }
                object4 = n14 < (n10 = ((ArrayList)(object4 = this.mediaChunks)).size()) ? ((HlsMediaChunk)this.mediaChunks.get((int)n14)).trackFormat : (Format)Assertions.checkNotNull(this.upstreamTrackFormat);
                format = format.withManifestFormatInfo((Format)object4);
            }
            formatHolder.format = format;
        }
        return n18;
    }

    /*
     * WARNING - void declaration
     */
    public void reevaluateBuffer(long l10) {
        boolean bl2;
        Object object = this.loader;
        boolean n10 = ((Loader)object).hasFatalError();
        if (!n10 && !(bl2 = this.isPendingReset())) {
            ArrayList arrayList;
            int n11;
            int n12;
            int n13;
            void var4_7;
            Object object2;
            object = this.loader;
            boolean bl3 = ((Loader)object).isLoading();
            if (bl3) {
                Assertions.checkNotNull(this.loadingChunk);
                object = this.chunkSource;
                Chunk chunk = this.loadingChunk;
                List list = this.readOnlyMediaChunks;
                boolean bl4 = ((HlsChunkSource)object).shouldCancelLoad(l10, chunk, list);
                if (bl4) {
                    Loader loader = this.loader;
                    loader.cancelLoading();
                }
                return;
            }
            object = this.readOnlyMediaChunks;
            int n14 = object.size();
            while ((var4_7 += -1) > 0) {
                int n15;
                object2 = this.chunkSource;
                Object object3 = this.readOnlyMediaChunks;
                void var9_15 = var4_7 + -1;
                n13 = ((HlsChunkSource)object2).getChunkPublicationState((HlsMediaChunk)(object3 = (HlsMediaChunk)object3.get((int)var9_15)));
                if (n13 == (n15 = 2)) continue;
            }
            if (var4_7 < (n13 = (object2 = this.readOnlyMediaChunks).size())) {
                this.discardUpstream((int)var4_7);
            }
            if ((n12 = ((HlsChunkSource)(object = this.chunkSource)).getPreferredQueueSize(l10, (List)(object2 = this.readOnlyMediaChunks))) < (n11 = (arrayList = this.mediaChunks).size())) {
                this.discardUpstream(n12);
            }
        }
    }

    public void release() {
        boolean bl2 = this.prepared;
        if (bl2) {
            for (HlsSampleStreamWrapper$HlsSampleQueue hlsSampleStreamWrapper$HlsSampleQueue : this.sampleQueues) {
                hlsSampleStreamWrapper$HlsSampleQueue.preRelease();
            }
        }
        this.loader.release(this);
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
        this.hlsSampleStreams.clear();
    }

    public void seekMap(SeekMap seekMap) {
    }

    public boolean seekToUs(long l10, boolean bl2) {
        this.lastSeekPositionUs = l10;
        boolean bl3 = this.isPendingReset();
        boolean bl4 = true;
        if (bl3) {
            this.pendingResetPositionUs = l10;
            return bl4;
        }
        bl3 = this.sampleQueuesBuilt;
        if (bl3 && !bl2 && (bl2 = this.seekInsideBufferUs(l10))) {
            return false;
        }
        this.pendingResetPositionUs = l10;
        this.loadingFinished = false;
        this.mediaChunks.clear();
        Object object = this.loader;
        boolean bl5 = ((Loader)object).isLoading();
        if (bl5) {
            bl5 = this.sampleQueuesBuilt;
            if (bl5) {
                for (HlsSampleStreamWrapper$HlsSampleQueue hlsSampleStreamWrapper$HlsSampleQueue : this.sampleQueues) {
                    hlsSampleStreamWrapper$HlsSampleQueue.discardToEnd();
                }
            }
            object = this.loader;
            ((Loader)object).cancelLoading();
        } else {
            object = this.loader;
            ((Loader)object).clearFatalError();
            this.resetSampleQueues();
        }
        return bl4;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean selectTracks(ExoTrackSelection[] var1_1, boolean[] var2_2, SampleStream[] var3_3, boolean[] var4_4, long var5_5, boolean var7_6) {
        block21: {
            block20: {
                var8_7 = this;
                var9_8 = var1_1;
                var10_9 = var3_3;
                var11_10 = var5_5;
                this.assertIsPrepared();
                var13_11 = this.enabledTrackGroupCount;
                var14_12 = 0;
                var15_13 = 0;
                var16_14 = null;
                while (true) {
                    var17_15 = ((ExoTrackSelection[])var9_8).length;
                    var18_16 = 1;
                    var19_17 = 1.4E-45f;
                    if (var15_13 >= var17_15) break;
                    var20_18 = (HlsSampleStream)var10_9[var15_13];
                    if (var20_18 != null && ((var21_19 = var9_8[var15_13]) == null || (var22_20 /* !! */  = var2_2[var15_13]) == 0)) {
                        var8_7.enabledTrackGroupCount = var22_20 /* !! */  = var8_7.enabledTrackGroupCount - var18_16;
                        var20_18.unbindSampleQueue();
                        var10_9[var15_13] = null;
                    }
                    ++var15_13;
                }
                if (!var7_6 && !((var15_13 = (int)var8_7.seenFirstTrackSelection) != 0 ? var13_11 == 0 : (var13_11 = (int)((cfr_temp_0 = var11_10 - (var23_21 = var8_7.lastSeekPositionUs)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) != 0)) {
                    var13_11 = 0;
                    var25_22 = null;
                } else {
                    var13_11 = var18_16;
                }
                var16_14 = var8_7.chunkSource.getTrackSelection();
                var26_23 = var13_11;
                var27_24 = var16_14;
                var25_22 = null;
                for (var13_11 = 0; var13_11 < (var17_15 = ((ExoTrackSelection[])var9_8).length); ++var13_11) {
                    var20_18 = var9_8[var13_11];
                    if (var20_18 == null) continue;
                    var21_19 = var8_7.trackGroups;
                    var28_25 = var20_18.getTrackGroup();
                    var22_20 /* !! */  = var21_19.indexOf((TrackGroup)var28_25);
                    if (var22_20 /* !! */  == (var29_26 = var8_7.primaryTrackGroupIndex)) {
                        var28_25 = var8_7.chunkSource;
                        var28_25.setTrackSelection((ExoTrackSelection)var20_18);
                        var27_24 = var20_18;
                    }
                    if ((var20_18 = var10_9[var13_11]) != null) continue;
                    var8_7.enabledTrackGroupCount = var17_15 = var8_7.enabledTrackGroupCount + var18_16;
                    var10_9[var13_11] = var20_18 = new HlsSampleStream(var8_7, var22_20 /* !! */ );
                    var4_4[var13_11] = var18_16;
                    var20_18 = var8_7.trackGroupToSampleQueueIndex;
                    if (var20_18 == null) continue;
                    var20_18 = (HlsSampleStream)var10_9[var13_11];
                    var20_18.bindSampleQueue();
                    if (var26_23 != 0) continue;
                    var20_18 = var8_7.sampleQueues;
                    var28_25 = var8_7.trackGroupToSampleQueueIndex;
                    var22_20 /* !! */  = (int)var28_25[var22_20 /* !! */ ];
                    if ((var22_20 /* !! */  = (int)(var20_18 = var20_18[var22_20 /* !! */ ]).seekTo(var11_10, (boolean)var18_16)) == 0 && (var17_15 = var20_18.getReadIndex()) != 0) {
                        var17_15 = var18_16;
                    } else {
                        var17_15 = 0;
                        var20_18 = null;
                    }
                    var26_23 = var17_15;
                }
                var30_27 = var8_7.enabledTrackGroupCount;
                if (var30_27 != 0) break block20;
                var8_7.chunkSource.reset();
                var8_7.downstreamTrackFormat = null;
                var8_7.pendingResetUpstreamFormats = var18_16;
                var8_7.mediaChunks.clear();
                var9_8 = var8_7.loader;
                var30_27 = var9_8.isLoading();
                if (var30_27 != 0) {
                    var30_27 = (int)var8_7.sampleQueuesBuilt;
                    if (var30_27 != 0) {
                        var9_8 = var8_7.sampleQueues;
                        var13_11 = ((Object)var9_8).length;
                        while (var14_12 < var13_11) {
                            var16_14 = var9_8[var14_12];
                            var16_14.discardToEnd();
                            ++var14_12;
                        }
                    }
                    var9_8 = var8_7.loader;
                    var9_8.cancelLoading();
                } else {
                    this.resetSampleQueues();
                }
                break block21;
            }
            var9_8 = var8_7.mediaChunks;
            var30_27 = (int)var9_8.isEmpty();
            if (var30_27 != 0 || (var30_27 = (int)Util.areEqual(var27_24, var16_14)) != 0) ** GOTO lbl-1000
            var30_27 = var8_7.seenFirstTrackSelection;
            if (var30_27 != 0) ** GOTO lbl-1000
            var23_21 = 0L;
            cfr_temp_1 = var11_10 - var23_21;
            var30_27 = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
            if (var30_27 < 0) {
                var23_21 = -var11_10;
            }
            var9_8 = this.getLastMediaChunk();
            var31_28 = var8_7.chunkSource.createMediaChunkIterators((HlsMediaChunk)var9_8, var11_10);
            var32_29 = -9223372036854775807L;
            var34_30 = var8_7.readOnlyMediaChunks;
            var25_22 = var27_24;
            var35_31 = var27_24;
            var27_24 = var31_28;
            var25_22.updateSelectedTrack(var5_5, var23_21, var32_29, var34_30, var31_28);
            var25_22 = var8_7.chunkSource.getTrackGroup();
            var9_8 = var9_8.trackFormat;
            var30_27 = var25_22.indexOf((Format)var9_8);
            var13_11 = var35_31.getSelectedIndexInTrackGroup();
            if (var13_11 == var30_27) {
                var30_27 = 0;
                var9_8 = null;
            } else lbl-1000:
            // 2 sources

            {
                var30_27 = var18_16;
            }
            if (var30_27 != 0) {
                var8_7.pendingResetUpstreamFormats = var18_16;
                var30_27 = var18_16;
                var26_23 = var18_16;
            } else lbl-1000:
            // 2 sources

            {
                var30_27 = (int)var7_6;
            }
            if (var26_23 != 0) {
                var8_7.seekToUs(var11_10, (boolean)var30_27);
                while (var14_12 < (var30_27 = var10_9.length)) {
                    var9_8 = var10_9[var14_12];
                    if (var9_8 != null) {
                        var4_4[var14_12] = var18_16;
                    }
                    ++var14_12;
                }
            }
        }
        var8_7.updateSampleStreams(var10_9);
        var8_7.seenFirstTrackSelection = var18_16;
        return (boolean)var26_23;
    }

    public void setDrmInitData(DrmInitData drmInitData) {
        DrmInitData drmInitData2 = this.drmInitData;
        int n10 = Util.areEqual(drmInitData2, drmInitData);
        if (n10 == 0) {
            Object object;
            int n11;
            this.drmInitData = drmInitData;
            drmInitData2 = null;
            for (n10 = 0; n10 < (n11 = ((HlsSampleStreamWrapper$HlsSampleQueue[])(object = this.sampleQueues)).length); ++n10) {
                boolean[] blArray = this.sampleQueueIsAudioVideoFlags;
                n11 = blArray[n10];
                if (n11 == 0) continue;
                object = object[n10];
                ((HlsSampleStreamWrapper$HlsSampleQueue)object).setDrmInitData(drmInitData);
            }
        }
    }

    public void setIsTimestampMaster(boolean bl2) {
        this.chunkSource.setIsTimestampMaster(bl2);
    }

    public void setSampleOffsetUs(long l10) {
        long l11 = this.sampleOffsetUs;
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.sampleOffsetUs = l10;
            for (HlsSampleStreamWrapper$HlsSampleQueue hlsSampleStreamWrapper$HlsSampleQueue : this.sampleQueues) {
                hlsSampleStreamWrapper$HlsSampleQueue.setSampleOffsetUs(l10);
            }
        }
    }

    public int skipData(int n10, long l10) {
        Object object;
        boolean bl2 = this.isPendingReset();
        if (bl2) {
            return 0;
        }
        HlsSampleStreamWrapper$HlsSampleQueue hlsSampleStreamWrapper$HlsSampleQueue = this.sampleQueues[n10];
        int n11 = this.loadingFinished;
        int n12 = hlsSampleStreamWrapper$HlsSampleQueue.getSkipCount(l10, n11 != 0);
        int n13 = hlsSampleStreamWrapper$HlsSampleQueue.getReadIndex();
        for (int i10 = 0; i10 < (n11 = ((ArrayList)(object = this.mediaChunks)).size()); ++i10) {
            object = (HlsMediaChunk)this.mediaChunks.get(i10);
            int n14 = n13 + n12;
            HlsMediaChunk hlsMediaChunk = (HlsMediaChunk)this.mediaChunks.get(i10);
            int n15 = hlsMediaChunk.getFirstSampleIndex(n10);
            if (n14 <= n15) break;
            n11 = (int)(((HlsMediaChunk)object).isPublished() ? 1 : 0);
            if (n11 != 0) continue;
            n12 = n15 - n13;
            break;
        }
        hlsSampleStreamWrapper$HlsSampleQueue.skip(n12);
        return n12;
    }

    public TrackOutput track(int n10, int n11) {
        int n12;
        Object object;
        block7: {
            object = MAPPABLE_TYPES;
            HlsSampleStreamWrapper$HlsSampleQueue[] hlsSampleStreamWrapper$HlsSampleQueueArray = Integer.valueOf(n11);
            n12 = object.contains(hlsSampleStreamWrapper$HlsSampleQueueArray);
            if (n12 != 0) {
                object = this.getMappedTrackOutput(n10, n11);
            } else {
                int n13;
                object = null;
                for (n12 = 0; n12 < (n13 = (hlsSampleStreamWrapper$HlsSampleQueueArray = this.sampleQueues).length); ++n12) {
                    int[] nArray = this.sampleQueueTrackIds;
                    n13 = nArray[n12];
                    if (n13 != n10) continue;
                    object = hlsSampleStreamWrapper$HlsSampleQueueArray[n12];
                    break block7;
                }
                n12 = 0;
                object = null;
            }
        }
        if (object == null) {
            n12 = this.tracksEnded;
            if (n12 != 0) {
                return HlsSampleStreamWrapper.createFakeTrackOutput(n10, n11);
            }
            object = this.createSampleQueue(n10, n11);
        }
        if (n11 == (n10 = 5)) {
            TrackOutput trackOutput = this.emsgUnwrappingTrackOutput;
            if (trackOutput == null) {
                n11 = this.metadataType;
                this.emsgUnwrappingTrackOutput = trackOutput = new HlsSampleStreamWrapper$EmsgUnwrappingTrackOutput((TrackOutput)object, n11);
            }
            return this.emsgUnwrappingTrackOutput;
        }
        return object;
    }

    public void unbindSampleQueue(int n10) {
        this.assertIsPrepared();
        Assertions.checkNotNull(this.trackGroupToSampleQueueIndex);
        n10 = this.trackGroupToSampleQueueIndex[n10];
        Assertions.checkState(this.sampleQueuesEnabledStates[n10]);
        this.sampleQueuesEnabledStates[n10] = false;
    }
}

