/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 */
package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod$Callback;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.ProgressiveMediaPeriod$ExtractingLoadable;
import com.google.android.exoplayer2.source.ProgressiveMediaPeriod$Listener;
import com.google.android.exoplayer2.source.ProgressiveMediaPeriod$SampleStreamImpl;
import com.google.android.exoplayer2.source.ProgressiveMediaPeriod$TrackId;
import com.google.android.exoplayer2.source.ProgressiveMediaPeriod$TrackState;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleQueue$UpstreamFormatChangedListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader$Callback;
import com.google.android.exoplayer2.upstream.Loader$LoadErrorAction;
import com.google.android.exoplayer2.upstream.Loader$ReleaseCallback;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.m0.j;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ProgressiveMediaPeriod
implements MediaPeriod,
ExtractorOutput,
Loader$Callback,
Loader$ReleaseCallback,
SampleQueue$UpstreamFormatChangedListener {
    private static final long DEFAULT_LAST_SAMPLE_DURATION_US = 10000L;
    private static final Format ICY_FORMAT;
    private static final Map ICY_METADATA_HEADERS;
    private final Allocator allocator;
    private MediaPeriod$Callback callback;
    private final long continueLoadingCheckIntervalBytes;
    private final String customCacheKey;
    private final DataSource dataSource;
    private int dataType;
    private final DrmSessionEventListener$EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private long durationUs;
    private int enabledTrackCount;
    private int extractedSamplesCountAtStartOfLoad;
    private final Handler handler;
    private boolean haveAudioVideoTracks;
    private IcyHeaders icyHeaders;
    private boolean isLive;
    private long lastSeekPositionUs;
    private long length;
    private final ProgressiveMediaPeriod$Listener listener;
    private final ConditionVariable loadCondition;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Loader loader;
    private boolean loadingFinished;
    private final Runnable maybeFinishPrepareRunnable;
    private final MediaSourceEventListener$EventDispatcher mediaSourceEventDispatcher;
    private boolean notifyDiscontinuity;
    private final Runnable onContinueLoadingRequestedRunnable;
    private boolean pendingDeferredRetry;
    private long pendingResetPositionUs;
    private boolean prepared;
    private final ProgressiveMediaExtractor progressiveMediaExtractor;
    private boolean released;
    private ProgressiveMediaPeriod$TrackId[] sampleQueueTrackIds;
    private SampleQueue[] sampleQueues;
    private boolean sampleQueuesBuilt;
    private SeekMap seekMap;
    private boolean seenFirstTrackSelection;
    private ProgressiveMediaPeriod$TrackState trackState;
    private final Uri uri;

    static {
        ICY_METADATA_HEADERS = ProgressiveMediaPeriod.createIcyMetadataHeaders();
        Format$Builder format$Builder = new Format$Builder();
        ICY_FORMAT = format$Builder.setId("icy").setSampleMimeType("application/x-icy").build();
    }

    public ProgressiveMediaPeriod(Uri sampleQueueArray, DataSource progressiveMediaPeriod$TrackIdArray, ExtractorsFactory extractorsFactory, DrmSessionManager drmSessionManager, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher, ProgressiveMediaPeriod$Listener progressiveMediaPeriod$Listener, Allocator allocator, String string2, int n10) {
        long l10;
        this.uri = sampleQueueArray;
        this.dataSource = progressiveMediaPeriod$TrackIdArray;
        this.drmSessionManager = drmSessionManager;
        this.drmEventDispatcher = drmSessionEventListener$EventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.mediaSourceEventDispatcher = mediaSourceEventListener$EventDispatcher;
        this.listener = progressiveMediaPeriod$Listener;
        this.allocator = allocator;
        this.customCacheKey = string2;
        this.continueLoadingCheckIntervalBytes = l10 = (long)n10;
        super("Loader:ProgressiveMediaPeriod");
        this.loader = sampleQueueArray;
        super(extractorsFactory);
        this.progressiveMediaExtractor = sampleQueueArray;
        super();
        this.loadCondition = sampleQueueArray;
        super(this);
        this.maybeFinishPrepareRunnable = sampleQueueArray;
        super(this);
        this.onContinueLoadingRequestedRunnable = sampleQueueArray;
        sampleQueueArray = Util.createHandlerForCurrentLooper();
        this.handler = sampleQueueArray;
        progressiveMediaPeriod$TrackIdArray = new ProgressiveMediaPeriod$TrackId[]{};
        this.sampleQueueTrackIds = progressiveMediaPeriod$TrackIdArray;
        sampleQueueArray = new SampleQueue[]{};
        this.sampleQueues = sampleQueueArray;
        this.pendingResetPositionUs = l10 = -9223372036854775807L;
        this.length = -1;
        this.durationUs = l10;
        this.dataType = 1;
    }

    public static /* synthetic */ void a(ProgressiveMediaPeriod progressiveMediaPeriod) {
        progressiveMediaPeriod.maybeFinishPrepare();
    }

    public static /* synthetic */ Runnable access$1000(ProgressiveMediaPeriod progressiveMediaPeriod) {
        return progressiveMediaPeriod.onContinueLoadingRequestedRunnable;
    }

    public static /* synthetic */ Handler access$1100(ProgressiveMediaPeriod progressiveMediaPeriod) {
        return progressiveMediaPeriod.handler;
    }

    public static /* synthetic */ long access$1200(ProgressiveMediaPeriod progressiveMediaPeriod) {
        return progressiveMediaPeriod.getLargestQueuedTimestampUs();
    }

    public static /* synthetic */ Map access$1300() {
        return ICY_METADATA_HEADERS;
    }

    public static /* synthetic */ String access$1400(ProgressiveMediaPeriod progressiveMediaPeriod) {
        return progressiveMediaPeriod.customCacheKey;
    }

    public static /* synthetic */ IcyHeaders access$700(ProgressiveMediaPeriod progressiveMediaPeriod) {
        return progressiveMediaPeriod.icyHeaders;
    }

    public static /* synthetic */ IcyHeaders access$702(ProgressiveMediaPeriod progressiveMediaPeriod, IcyHeaders icyHeaders) {
        progressiveMediaPeriod.icyHeaders = icyHeaders;
        return icyHeaders;
    }

    public static /* synthetic */ Format access$800() {
        return ICY_FORMAT;
    }

    public static /* synthetic */ long access$900(ProgressiveMediaPeriod progressiveMediaPeriod) {
        return progressiveMediaPeriod.continueLoadingCheckIntervalBytes;
    }

    private void assertPrepared() {
        Assertions.checkState(this.prepared);
        Assertions.checkNotNull(this.trackState);
        Assertions.checkNotNull(this.seekMap);
    }

    private /* synthetic */ void b() {
        boolean bl2 = this.released;
        if (!bl2) {
            MediaPeriod$Callback mediaPeriod$Callback = (MediaPeriod$Callback)Assertions.checkNotNull(this.callback);
            mediaPeriod$Callback.onContinueLoadingRequested(this);
        }
    }

    private boolean configureRetry(ProgressiveMediaPeriod$ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable, int n10) {
        long l10;
        long l11;
        SeekMap seekMap;
        long l12 = this.length;
        long l13 = -1;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        boolean bl2 = true;
        if (l14 == false && ((seekMap = this.seekMap) == null || (l14 = (l11 = (l13 = seekMap.getDurationUs()) - (l10 = -9223372036854775807L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false)) {
            n10 = (int)(this.prepared ? 1 : 0);
            seekMap = null;
            if (n10 != 0 && (n10 = (int)(this.suppressRead() ? 1 : 0)) == 0) {
                this.pendingDeferredRetry = bl2;
                return false;
            }
            n10 = (int)(this.prepared ? 1 : 0);
            this.notifyDiscontinuity = n10;
            this.lastSeekPositionUs = l13 = 0L;
            this.extractedSamplesCountAtStartOfLoad = 0;
            SampleQueue[] sampleQueueArray = this.sampleQueues;
            int n11 = sampleQueueArray.length;
            for (l14 = (long)0; l14 < n11; ++l14) {
                SampleQueue sampleQueue = sampleQueueArray[l14];
                sampleQueue.reset();
            }
            ProgressiveMediaPeriod$ExtractingLoadable.access$600(progressiveMediaPeriod$ExtractingLoadable, l13, l13);
            return bl2;
        }
        this.extractedSamplesCountAtStartOfLoad = n10;
        return bl2;
    }

    private void copyLengthFromLoader(ProgressiveMediaPeriod$ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable) {
        long l10 = this.length;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            this.length = l10 = ProgressiveMediaPeriod$ExtractingLoadable.access$500(progressiveMediaPeriod$ExtractingLoadable);
        }
    }

    private static Map createIcyMetadataHeaders() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(hashMap);
    }

    private /* synthetic */ void d(SeekMap seekMap) {
        this.setSeekMap(seekMap);
    }

    private int getExtractedSamplesCount() {
        SampleQueue[] sampleQueueArray = this.sampleQueues;
        int n10 = sampleQueueArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            SampleQueue sampleQueue = sampleQueueArray[i10];
            int n12 = sampleQueue.getWriteIndex();
            n11 += n12;
        }
        return n11;
    }

    private long getLargestQueuedTimestampUs() {
        SampleQueue[] sampleQueueArray = this.sampleQueues;
        int n10 = sampleQueueArray.length;
        long l10 = Long.MIN_VALUE;
        for (int i10 = 0; i10 < n10; ++i10) {
            SampleQueue sampleQueue = sampleQueueArray[i10];
            long l11 = sampleQueue.getLargestQueuedTimestampUs();
            l10 = Math.max(l10, l11);
        }
        return l10;
    }

    private boolean isPendingReset() {
        long l10 = this.pendingResetPositionUs;
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object != false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    private void maybeFinishPrepare() {
        block10: {
            int n10;
            Format format;
            Object object;
            int n11 = this.released;
            if (n11 != 0 || (n11 = this.prepared) != 0 || (n11 = this.sampleQueuesBuilt) == 0 || (object = this.seekMap) == null) break block10;
            object = this.sampleQueues;
            int n12 = ((SampleQueue[])object).length;
            TrackGroupArray trackGroupArray = null;
            boolean[] blArray = null;
            for (int i10 = 0; i10 < n12; ++i10) {
                format = object[i10].getUpstreamFormat();
                if (format != null) continue;
                return;
            }
            this.loadCondition.close();
            object = this.sampleQueues;
            n11 = ((SampleQueue[])object).length;
            TrackGroup[] trackGroupArray2 = new TrackGroup[n11];
            blArray = new boolean[n11];
            int n13 = 0;
            format = null;
            while (true) {
                Object object2;
                Object object3;
                block11: {
                    int n14;
                    int n15;
                    int n16;
                    block13: {
                        Metadata$Entry[] metadata$EntryArray;
                        Object object4;
                        block12: {
                            n10 = 1;
                            if (n13 >= n11) break;
                            object3 = (Format)Assertions.checkNotNull(this.sampleQueues[n13].getUpstreamFormat());
                            object2 = ((Format)object3).sampleMimeType;
                            n16 = MimeTypes.isAudio((String)object2);
                            if (n16 == 0 && (n15 = MimeTypes.isVideo((String)object2)) == 0) {
                                n15 = 0;
                                object2 = null;
                            } else {
                                n15 = n10;
                            }
                            blArray[n13] = n15;
                            n14 = this.haveAudioVideoTracks;
                            this.haveAudioVideoTracks = n15 |= n14;
                            object2 = this.icyHeaders;
                            if (object2 == null) break block11;
                            if (n16 != 0) break block12;
                            object4 = this.sampleQueueTrackIds[n13];
                            n14 = ((ProgressiveMediaPeriod$TrackId)object4).isIcyTrack;
                            if (n14 == 0) break block13;
                        }
                        if ((object4 = ((Format)object3).metadata) == null) {
                            metadata$EntryArray = new Metadata$Entry[n10];
                            metadata$EntryArray[0] = object2;
                            object4 = new Metadata(metadata$EntryArray);
                        } else {
                            metadata$EntryArray = new Metadata$Entry[n10];
                            metadata$EntryArray[0] = object2;
                            object4 = ((Metadata)object4).copyWithAppendedEntries(metadata$EntryArray);
                        }
                        object3 = ((Format)object3).buildUpon().setMetadata((Metadata)object4).build();
                    }
                    if (n16 != 0 && (n16 = ((Format)object3).averageBitrate) == (n14 = -1) && (n16 = ((Format)object3).peakBitrate) == n14 && (n16 = ((IcyHeaders)object2).bitrate) != n14) {
                        object3 = ((Format)object3).buildUpon();
                        n15 = ((IcyHeaders)object2).bitrate;
                        object3 = ((Format$Builder)object3).setAverageBitrate(n15).build();
                    }
                }
                object2 = this.drmSessionManager.getExoMediaCryptoType((Format)object3);
                object3 = ((Format)object3).copyWithExoMediaCryptoType((Class)object2);
                Format[] formatArray = new Format[n10];
                formatArray[0] = object3;
                trackGroupArray2[n13] = object2 = new TrackGroup(formatArray);
                ++n13;
            }
            trackGroupArray = new TrackGroupArray(trackGroupArray2);
            object = new ProgressiveMediaPeriod$TrackState(trackGroupArray, blArray);
            this.trackState = object;
            this.prepared = n10;
            object = (MediaPeriod$Callback)Assertions.checkNotNull(this.callback);
            object.onPrepared(this);
        }
    }

    private void maybeNotifyDownstreamFormat(int n10) {
        this.assertPrepared();
        Object object = this.trackState;
        boolean[] blArray = ((ProgressiveMediaPeriod$TrackState)object).trackNotifiedDownstreamFormats;
        boolean bl2 = blArray[n10];
        if (!bl2) {
            boolean bl3;
            object = ((ProgressiveMediaPeriod$TrackState)object).tracks.get(n10);
            bl2 = false;
            Format format = ((TrackGroup)object).getFormat(0);
            MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.mediaSourceEventDispatcher;
            object = format.sampleMimeType;
            int n11 = MimeTypes.getTrackType((String)object);
            long l10 = this.lastSeekPositionUs;
            mediaSourceEventListener$EventDispatcher.downstreamFormatChanged(n11, format, 0, null, l10);
            blArray[n10] = bl3 = true;
        }
    }

    private void maybeStartDeferredRetry(int n10) {
        int n11;
        this.assertPrepared();
        boolean[] blArray = this.trackState.trackIsAudioVideoFlags;
        int n12 = this.pendingDeferredRetry;
        if (n12 != 0 && (n11 = blArray[n10]) != 0) {
            Object object = this.sampleQueues[n10];
            blArray = null;
            n10 = (int)(((SampleQueue)object).isReady(false) ? 1 : 0);
            if (n10 == 0) {
                long l10;
                this.pendingResetPositionUs = l10 = 0L;
                this.pendingDeferredRetry = false;
                n10 = 1;
                this.notifyDiscontinuity = n10;
                this.lastSeekPositionUs = l10;
                this.extractedSamplesCountAtStartOfLoad = 0;
                for (SampleQueue sampleQueue : this.sampleQueues) {
                    sampleQueue.reset();
                }
                object = (MediaPeriod$Callback)Assertions.checkNotNull(this.callback);
                object.onContinueLoadingRequested(this);
            }
        }
    }

    private TrackOutput prepareTrackOutput(ProgressiveMediaPeriod$TrackId objectArray) {
        Object[] objectArray2;
        SampleQueue[] sampleQueueArray = this.sampleQueues;
        int n10 = sampleQueueArray.length;
        Object object = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            objectArray2 = this.sampleQueueTrackIds[i10];
            boolean bl2 = objectArray.equals(objectArray2);
            if (!bl2) continue;
            return this.sampleQueues[i10];
        }
        object = this.allocator;
        objectArray2 = this.handler.getLooper();
        DrmSessionManager drmSessionManager = this.drmSessionManager;
        DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.drmEventDispatcher;
        object = SampleQueue.createWithDrm((Allocator)object, (Looper)objectArray2, drmSessionManager, drmSessionEventListener$EventDispatcher);
        ((SampleQueue)object).setUpstreamFormatChangeListener(this);
        objectArray2 = this.sampleQueueTrackIds;
        int n11 = n10 + 1;
        objectArray2 = Arrays.copyOf(objectArray2, n11);
        objectArray2[n10] = objectArray;
        objectArray = (ProgressiveMediaPeriod$TrackId[])Util.castNonNullTypeArray(objectArray2);
        this.sampleQueueTrackIds = objectArray;
        objectArray = Arrays.copyOf(this.sampleQueues, n11);
        objectArray[n10] = object;
        objectArray = (SampleQueue[])Util.castNonNullTypeArray(objectArray);
        this.sampleQueues = objectArray;
        return object;
    }

    private boolean seekInsideBufferUs(boolean[] blArray, long l10) {
        SampleQueue[] sampleQueueArray = this.sampleQueues;
        int n10 = sampleQueueArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            SampleQueue sampleQueue = this.sampleQueues[i10];
            boolean bl2 = sampleQueue.seekTo(l10, false);
            if (bl2 || !(bl2 = blArray[i10]) && (bl2 = this.haveAudioVideoTracks)) continue;
            return false;
        }
        return true;
    }

    private void setSeekMap(SeekMap seekMap) {
        int n10;
        long l10;
        long l11;
        long l12;
        Object object = this.icyHeaders;
        long l13 = -9223372036854775807L;
        object = object == null ? seekMap : new SeekMap$Unseekable(l13);
        this.seekMap = object;
        this.durationUs = l12 = seekMap.getDurationUs();
        l12 = this.length;
        long l14 = -1;
        long l15 = l12 == l14 ? 0 : (l12 < l14 ? -1 : 1);
        int bl2 = 1;
        if (l15 == false && (l15 = (l11 = (l10 = seekMap.getDurationUs()) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false) {
            l15 = bl2;
        } else {
            l15 = 0;
            object = null;
        }
        this.isLive = l15;
        if (l15 != false) {
            n10 = 7;
        }
        this.dataType = n10;
        object = this.listener;
        l13 = this.durationUs;
        boolean bl3 = seekMap.isSeekable();
        boolean bl4 = this.isLive;
        object.onSourceInfoRefreshed(l13, bl3, bl4);
        bl3 = this.prepared;
        if (!bl3) {
            this.maybeFinishPrepare();
        }
    }

    private void startLoading() {
        int n10;
        long l10;
        ProgressiveMediaPeriod$ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable;
        ProgressiveMediaPeriod progressiveMediaPeriod = this;
        Uri uri = this.uri;
        DataSource dataSource = this.dataSource;
        ProgressiveMediaExtractor progressiveMediaExtractor = this.progressiveMediaExtractor;
        ConditionVariable conditionVariable = this.loadCondition;
        SampleQueue[] sampleQueueArray = progressiveMediaPeriod$ExtractingLoadable;
        Object object = this;
        Object object2 = this;
        progressiveMediaPeriod$ExtractingLoadable = new ProgressiveMediaPeriod$ExtractingLoadable(this, uri, dataSource, progressiveMediaExtractor, this, conditionVariable);
        int n11 = this.prepared;
        if (n11 != 0) {
            long l11;
            long l12;
            n11 = this.isPendingReset();
            Assertions.checkState(n11 != 0);
            l10 = this.durationUs;
            long l13 = -9223372036854775807L;
            long l14 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
            if (l14 != false && (n11 = (int)((l12 = (l11 = this.pendingResetPositionUs) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1))) > 0) {
                this.loadingFinished = true;
                this.pendingResetPositionUs = l13;
                return;
            }
            sampleQueueArray = (SeekMap)Assertions.checkNotNull(progressiveMediaPeriod.seekMap);
            l11 = progressiveMediaPeriod.pendingResetPositionUs;
            l10 = sampleQueueArray.getSeekPoints((long)l11).first.position;
            l11 = progressiveMediaPeriod.pendingResetPositionUs;
            ProgressiveMediaPeriod$ExtractingLoadable.access$600(progressiveMediaPeriod$ExtractingLoadable, l10, l11);
            sampleQueueArray = progressiveMediaPeriod.sampleQueues;
            n10 = sampleQueueArray.length;
            progressiveMediaExtractor = null;
            for (l14 = (long)0; l14 < n10; ++l14) {
                object2 = sampleQueueArray[l14];
                long l15 = progressiveMediaPeriod.pendingResetPositionUs;
                ((SampleQueue)object2).setStartTimeUs(l15);
            }
            progressiveMediaPeriod.pendingResetPositionUs = l13;
        }
        progressiveMediaPeriod.extractedSamplesCountAtStartOfLoad = n11 = this.getExtractedSamplesCount();
        sampleQueueArray = progressiveMediaPeriod.loader;
        object = progressiveMediaPeriod.loadErrorHandlingPolicy;
        int n12 = progressiveMediaPeriod.dataType;
        n10 = object.getMinimumLoadableRetryCount(n12);
        long l16 = sampleQueueArray.startLoading(progressiveMediaPeriod$ExtractingLoadable, progressiveMediaPeriod, n10);
        DataSpec dataSpec = ProgressiveMediaPeriod$ExtractingLoadable.access$300(progressiveMediaPeriod$ExtractingLoadable);
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = progressiveMediaPeriod.mediaSourceEventDispatcher;
        long l17 = ProgressiveMediaPeriod$ExtractingLoadable.access$200(progressiveMediaPeriod$ExtractingLoadable);
        LoadEventInfo loadEventInfo = new LoadEventInfo(l17, dataSpec, l16);
        long l18 = ProgressiveMediaPeriod$ExtractingLoadable.access$400(progressiveMediaPeriod$ExtractingLoadable);
        l10 = progressiveMediaPeriod.durationUs;
        mediaSourceEventListener$EventDispatcher.loadStarted(loadEventInfo, 1, -1, null, 0, null, l18, l10);
    }

    private boolean suppressRead() {
        boolean bl2 = this.notifyDiscontinuity;
        bl2 = bl2 || (bl2 = this.isPendingReset());
        return bl2;
    }

    public /* synthetic */ void c() {
        this.b();
    }

    public boolean continueLoading(long l10) {
        Object object;
        boolean bl2 = this.loadingFinished;
        if (!(bl2 || (bl2 = ((Loader)(object = this.loader)).hasFatalError()) || (bl2 = this.pendingDeferredRetry) || (bl2 = this.prepared) && !(bl2 = this.enabledTrackCount))) {
            object = this.loadCondition;
            bl2 = ((ConditionVariable)object).open();
            Loader loader = this.loader;
            boolean bl3 = loader.isLoading();
            if (!bl3) {
                this.startLoading();
                bl2 = true;
            }
            return bl2;
        }
        return false;
    }

    public void discardBuffer(long l10, boolean bl2) {
        this.assertPrepared();
        boolean bl3 = this.isPendingReset();
        if (bl3) {
            return;
        }
        boolean[] blArray = this.trackState.trackEnabledStates;
        SampleQueue[] sampleQueueArray = this.sampleQueues;
        int n10 = sampleQueueArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            SampleQueue sampleQueue = this.sampleQueues[i10];
            boolean bl4 = blArray[i10];
            sampleQueue.discardTo(l10, bl2, bl4);
        }
    }

    public /* synthetic */ void e(SeekMap seekMap) {
        this.d(seekMap);
    }

    public void endTracks() {
        this.sampleQueuesBuilt = true;
        Handler handler = this.handler;
        Runnable runnable = this.maybeFinishPrepareRunnable;
        handler.post(runnable);
    }

    public long getAdjustedSeekPositionUs(long l10, SeekParameters seekParameters) {
        this.assertPrepared();
        Object object = this.seekMap;
        boolean bl2 = object.isSeekable();
        if (!bl2) {
            return 0L;
        }
        object = this.seekMap.getSeekPoints(l10);
        long l11 = object.first.timeUs;
        long l12 = object.second.timeUs;
        return seekParameters.resolveSeekPositionUs(l10, l11, l12);
    }

    public long getBufferedPositionUs() {
        long l10;
        long l11;
        this.assertPrepared();
        boolean[] blArray = this.trackState.trackIsAudioVideoFlags;
        int n10 = this.loadingFinished;
        long l12 = Long.MIN_VALUE;
        if (n10 != 0) {
            return l12;
        }
        n10 = this.isPendingReset();
        if (n10 != 0) {
            return this.pendingResetPositionUs;
        }
        n10 = this.haveAudioVideoTracks;
        long l13 = Long.MAX_VALUE;
        if (n10 != 0) {
            SampleQueue[] sampleQueueArray = this.sampleQueues;
            n10 = sampleQueueArray.length;
            l11 = l13;
            for (int i10 = 0; i10 < n10; ++i10) {
                SampleQueue sampleQueue;
                boolean bl2 = blArray[i10];
                if (!bl2 || (bl2 = (sampleQueue = this.sampleQueues[i10]).isLastSampleQueued())) continue;
                sampleQueue = this.sampleQueues[i10];
                long l14 = sampleQueue.getLargestQueuedTimestampUs();
                l11 = Math.min(l11, l14);
            }
        } else {
            l11 = l13;
        }
        if ((l10 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1)) == false) {
            l11 = this.getLargestQueuedTimestampUs();
        }
        if ((l10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1)) == false) {
            l11 = this.lastSeekPositionUs;
        }
        return l11;
    }

    public long getNextLoadPositionUs() {
        int n10 = this.enabledTrackCount;
        long l10 = n10 == 0 ? Long.MIN_VALUE : this.getBufferedPositionUs();
        return l10;
    }

    public TrackGroupArray getTrackGroups() {
        this.assertPrepared();
        return this.trackState.tracks;
    }

    public TrackOutput icyTrack() {
        ProgressiveMediaPeriod$TrackId progressiveMediaPeriod$TrackId = new ProgressiveMediaPeriod$TrackId(0, true);
        return this.prepareTrackOutput(progressiveMediaPeriod$TrackId);
    }

    public boolean isLoading() {
        Object object = this.loader;
        boolean bl2 = ((Loader)object).isLoading();
        if (bl2 && (bl2 = ((ConditionVariable)(object = this.loadCondition)).isOpen())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean isReady(int n10) {
        SampleQueue[] sampleQueueArray;
        SampleQueue sampleQueue;
        boolean bl2 = this.suppressRead();
        if (!bl2 && (n10 = (int)((sampleQueue = (sampleQueueArray = this.sampleQueues)[n10]).isReady(bl2 = this.loadingFinished) ? 1 : 0)) != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            sampleQueue = null;
        }
        return n10 != 0;
    }

    public void maybeThrowError() {
        Loader loader = this.loader;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
        int n10 = this.dataType;
        int n11 = loadErrorHandlingPolicy.getMinimumLoadableRetryCount(n10);
        loader.maybeThrowError(n11);
    }

    public void maybeThrowError(int n10) {
        this.sampleQueues[n10].maybeThrowError();
        this.maybeThrowError();
    }

    public void maybeThrowPrepareError() {
        this.maybeThrowError();
        boolean bl2 = this.loadingFinished;
        if (bl2 && !(bl2 = this.prepared)) {
            ParserException parserException = new ParserException("Loading finished before preparation is complete.");
            throw parserException;
        }
    }

    public void onLoadCanceled(ProgressiveMediaPeriod$ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable, long l10, long l11, boolean bl2) {
        LoadEventInfo loadEventInfo;
        ProgressiveMediaPeriod progressiveMediaPeriod = this;
        Object object = ProgressiveMediaPeriod$ExtractingLoadable.access$100(progressiveMediaPeriod$ExtractingLoadable);
        long l12 = ProgressiveMediaPeriod$ExtractingLoadable.access$200(progressiveMediaPeriod$ExtractingLoadable);
        DataSpec dataSpec = ProgressiveMediaPeriod$ExtractingLoadable.access$300(progressiveMediaPeriod$ExtractingLoadable);
        Uri uri = ((StatsDataSource)object).getLastOpenedUri();
        Map map = ((StatsDataSource)object).getLastResponseHeaders();
        long l13 = ((StatsDataSource)object).getBytesRead();
        Object object2 = loadEventInfo;
        loadEventInfo = new LoadEventInfo(l12, dataSpec, uri, map, l10, l11, l13);
        object = this.loadErrorHandlingPolicy;
        long l14 = ProgressiveMediaPeriod$ExtractingLoadable.access$200(progressiveMediaPeriod$ExtractingLoadable);
        object.onLoadTaskConcluded(l14);
        object2 = this.mediaSourceEventDispatcher;
        long l15 = ProgressiveMediaPeriod$ExtractingLoadable.access$400(progressiveMediaPeriod$ExtractingLoadable);
        long l16 = this.durationUs;
        int n10 = 1;
        int n11 = -1;
        uri = null;
        map = null;
        ((MediaSourceEventListener$EventDispatcher)object2).loadCanceled(loadEventInfo, n10, n11, null, 0, null, l15, l16);
        if (!bl2) {
            this.copyLengthFromLoader(progressiveMediaPeriod$ExtractingLoadable);
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.reset();
            }
            int n12 = progressiveMediaPeriod.enabledTrackCount;
            if (n12 > 0) {
                object = (MediaPeriod$Callback)Assertions.checkNotNull(progressiveMediaPeriod.callback);
                object.onContinueLoadingRequested(this);
            }
        }
    }

    public void onLoadCompleted(ProgressiveMediaPeriod$ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable, long l10, long l11) {
        LoadEventInfo loadEventInfo;
        long l12;
        Object object;
        ProgressiveMediaPeriod progressiveMediaPeriod = this;
        long l13 = this.durationUs;
        long l14 = -9223372036854775807L;
        long l15 = l13 - l14;
        Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object2 == false && (object = this.seekMap) != null) {
            long l16;
            object2 = object.isSeekable();
            l12 = this.getLargestQueuedTimestampUs();
            long l17 = l12 - (l16 = Long.MIN_VALUE);
            Object object3 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object3 == false) {
                l12 = 0L;
            } else {
                l16 = 10000L;
                l12 += l16;
            }
            progressiveMediaPeriod.durationUs = l12;
            ProgressiveMediaPeriod$Listener progressiveMediaPeriod$Listener = progressiveMediaPeriod.listener;
            boolean bl2 = progressiveMediaPeriod.isLive;
            progressiveMediaPeriod$Listener.onSourceInfoRefreshed(l12, (boolean)object2, bl2);
        }
        object = ProgressiveMediaPeriod$ExtractingLoadable.access$100(progressiveMediaPeriod$ExtractingLoadable);
        l14 = ProgressiveMediaPeriod$ExtractingLoadable.access$200(progressiveMediaPeriod$ExtractingLoadable);
        DataSpec dataSpec = ProgressiveMediaPeriod$ExtractingLoadable.access$300(progressiveMediaPeriod$ExtractingLoadable);
        Uri uri = ((StatsDataSource)object).getLastOpenedUri();
        Map map = ((StatsDataSource)object).getLastResponseHeaders();
        long l18 = ((StatsDataSource)object).getBytesRead();
        Object object4 = loadEventInfo;
        loadEventInfo = new LoadEventInfo(l14, dataSpec, uri, map, l10, l11, l18);
        object = progressiveMediaPeriod.loadErrorHandlingPolicy;
        l12 = ProgressiveMediaPeriod$ExtractingLoadable.access$200(progressiveMediaPeriod$ExtractingLoadable);
        object.onLoadTaskConcluded(l12);
        object4 = progressiveMediaPeriod.mediaSourceEventDispatcher;
        long l19 = ProgressiveMediaPeriod$ExtractingLoadable.access$400(progressiveMediaPeriod$ExtractingLoadable);
        long l20 = progressiveMediaPeriod.durationUs;
        ((MediaSourceEventListener$EventDispatcher)object4).loadCompleted(loadEventInfo, 1, -1, null, 0, null, l19, l20);
        this.copyLengthFromLoader(progressiveMediaPeriod$ExtractingLoadable);
        progressiveMediaPeriod.loadingFinished = true;
        ((MediaPeriod$Callback)Assertions.checkNotNull(progressiveMediaPeriod.callback)).onContinueLoadingRequested(this);
    }

    public Loader$LoadErrorAction onLoadError(ProgressiveMediaPeriod$ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable, long l10, long l11, IOException iOException, int n10) {
        int n11;
        LoadEventInfo loadEventInfo;
        ProgressiveMediaPeriod progressiveMediaPeriod = this;
        this.copyLengthFromLoader(progressiveMediaPeriod$ExtractingLoadable);
        Object object = ProgressiveMediaPeriod$ExtractingLoadable.access$100(progressiveMediaPeriod$ExtractingLoadable);
        long l12 = ProgressiveMediaPeriod$ExtractingLoadable.access$200(progressiveMediaPeriod$ExtractingLoadable);
        DataSpec dataSpec = ProgressiveMediaPeriod$ExtractingLoadable.access$300(progressiveMediaPeriod$ExtractingLoadable);
        Uri uri = ((StatsDataSource)object).getLastOpenedUri();
        Map map = ((StatsDataSource)object).getLastResponseHeaders();
        long l13 = ((StatsDataSource)object).getBytesRead();
        Object object2 = loadEventInfo;
        loadEventInfo = new LoadEventInfo(l12, dataSpec, uri, map, l10, l11, l13);
        long l14 = C.usToMs(ProgressiveMediaPeriod$ExtractingLoadable.access$400(progressiveMediaPeriod$ExtractingLoadable));
        long l15 = this.durationUs;
        long l16 = C.usToMs(l15);
        boolean bl2 = true;
        int n12 = -1;
        Object object3 = object;
        object = new MediaLoadData((int)(bl2 ? 1 : 0), n12, null, 0, null, l14, l16);
        object2 = this.loadErrorHandlingPolicy;
        int n13 = n10;
        Object object4 = new LoadErrorHandlingPolicy$LoadErrorInfo(loadEventInfo, (MediaLoadData)object, iOException, n10);
        long l17 = object2.getRetryDelayMsFor((LoadErrorHandlingPolicy$LoadErrorInfo)object4);
        l12 = -9223372036854775807L;
        long l18 = l17 == l12 ? 0 : (l17 < l12 ? -1 : 1);
        n13 = 1;
        if (l18 == false) {
            object = Loader.DONT_RETRY_FATAL;
            object3 = progressiveMediaPeriod$ExtractingLoadable;
        } else {
            l18 = this.getExtractedSamplesCount();
            if (l18 > (n11 = this.extractedSamplesCountAtStartOfLoad)) {
                object3 = progressiveMediaPeriod$ExtractingLoadable;
                n11 = n13;
            } else {
                n11 = 0;
                dataSpec = null;
                object3 = progressiveMediaPeriod$ExtractingLoadable;
            }
            l18 = (long)progressiveMediaPeriod.configureRetry((ProgressiveMediaPeriod$ExtractingLoadable)object3, (int)l18);
            object = l18 != false ? Loader.createRetryAction(n11 != 0, l17) : Loader.DONT_RETRY;
        }
        boolean bl3 = ((Loader$LoadErrorAction)object).isRetry();
        bl2 = bl3 ^ true;
        object2 = progressiveMediaPeriod.mediaSourceEventDispatcher;
        n13 = 1;
        n11 = -1;
        uri = null;
        map = null;
        long l19 = ProgressiveMediaPeriod$ExtractingLoadable.access$400(progressiveMediaPeriod$ExtractingLoadable);
        long l20 = progressiveMediaPeriod.durationUs;
        object4 = loadEventInfo;
        ((MediaSourceEventListener$EventDispatcher)object2).loadError(loadEventInfo, n13, n11, null, 0, null, l19, l20, iOException, bl2);
        if (bl2) {
            object2 = progressiveMediaPeriod.loadErrorHandlingPolicy;
            l12 = ProgressiveMediaPeriod$ExtractingLoadable.access$200(progressiveMediaPeriod$ExtractingLoadable);
            object2.onLoadTaskConcluded(l12);
        }
        return object;
    }

    public void onLoaderReleased() {
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.release();
        }
        this.progressiveMediaExtractor.release();
    }

    public void onUpstreamFormatChanged(Format format) {
        format = this.handler;
        Runnable runnable = this.maybeFinishPrepareRunnable;
        format.post(runnable);
    }

    public void prepare(MediaPeriod$Callback mediaPeriod$Callback, long l10) {
        this.callback = mediaPeriod$Callback;
        this.loadCondition.open();
        this.startLoading();
    }

    public int readData(int n10, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean bl2) {
        boolean bl3 = this.suppressRead();
        int n11 = -3;
        if (bl3) {
            return n11;
        }
        this.maybeNotifyDownstreamFormat(n10);
        SampleQueue sampleQueue = this.sampleQueues[n10];
        boolean bl4 = this.loadingFinished;
        int n12 = sampleQueue.read(formatHolder, decoderInputBuffer, bl2, bl4);
        if (n12 == n11) {
            this.maybeStartDeferredRetry(n10);
        }
        return n12;
    }

    public long readDiscontinuity() {
        int n10;
        int n11 = this.notifyDiscontinuity;
        if (n11 != 0 && ((n11 = this.loadingFinished) != 0 || (n11 = this.getExtractedSamplesCount()) > (n10 = this.extractedSamplesCountAtStartOfLoad))) {
            this.notifyDiscontinuity = false;
            return this.lastSeekPositionUs;
        }
        return -9223372036854775807L;
    }

    public void reevaluateBuffer(long l10) {
    }

    public void release() {
        boolean bl2 = this.prepared;
        if (bl2) {
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.preRelease();
            }
        }
        this.loader.release(this);
        this.handler.removeCallbacksAndMessages(null);
        this.callback = null;
        this.released = true;
    }

    public void seekMap(SeekMap seekMap) {
        Handler handler = this.handler;
        j j10 = new j(this, seekMap);
        handler.post((Runnable)j10);
    }

    public long seekToUs(long l10) {
        boolean bl2;
        this.assertPrepared();
        Object object = this.trackState.trackIsAudioVideoFlags;
        SeekMap seekMap = this.seekMap;
        int n10 = seekMap.isSeekable();
        if (n10 == 0) {
            l10 = 0L;
        }
        seekMap = null;
        this.notifyDiscontinuity = false;
        this.lastSeekPositionUs = l10;
        int n11 = this.isPendingReset();
        if (n11 != 0) {
            this.pendingResetPositionUs = l10;
            return l10;
        }
        n11 = this.dataType;
        int n12 = 7;
        if (n11 != n12 && (bl2 = this.seekInsideBufferUs((boolean[])object, l10))) {
            return l10;
        }
        this.pendingDeferredRetry = false;
        this.pendingResetPositionUs = l10;
        this.loadingFinished = false;
        object = this.loader;
        bl2 = ((Loader)object).isLoading();
        if (bl2) {
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.discardToEnd();
            }
            object = this.loader;
            ((Loader)object).cancelLoading();
        } else {
            this.loader.clearFatalError();
            object = this.sampleQueues;
            n11 = ((Object)object).length;
            while (n10 < n11) {
                Object object2 = object[n10];
                ((SampleQueue)object2).reset();
                ++n10;
            }
        }
        return l10;
    }

    public long selectTracks(ExoTrackSelection[] object, boolean[] object2, SampleStream[] object3, boolean[] blArray, long l10) {
        long l11;
        long l12;
        Object object4;
        int n10;
        int n11;
        this.assertPrepared();
        Object object5 = this.trackState;
        TrackGroupArray trackGroupArray = ((ProgressiveMediaPeriod$TrackState)object5).tracks;
        object5 = ((ProgressiveMediaPeriod$TrackState)object5).trackEnabledStates;
        int n12 = this.enabledTrackCount;
        int n13 = 0;
        int n14 = 0;
        Object object6 = null;
        while (true) {
            n11 = ((ExoTrackSelection[])object).length;
            n10 = 1;
            if (n14 >= n11) break;
            object4 = object3[n14];
            if (object4 != null && ((object4 = object[n14]) == null || (n11 = object2[n14]) == 0)) {
                int n15;
                n11 = ProgressiveMediaPeriod$SampleStreamImpl.access$000((ProgressiveMediaPeriod$SampleStreamImpl)object3[n14]);
                Assertions.checkState((boolean)object5[n11]);
                this.enabledTrackCount = n15 = this.enabledTrackCount - n10;
                object5[n11] = false;
                n11 = 0;
                object4 = null;
                object3[n14] = null;
            }
            ++n14;
        }
        int n16 = (int)(this.seenFirstTrackSelection ? 1 : 0);
        if (n16 != 0 ? n12 == 0 : (n16 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != 0) {
            n16 = n10;
        } else {
            n16 = 0;
            object2 = null;
        }
        for (n12 = 0; n12 < (n14 = ((ExoTrackSelection[])object).length); ++n12) {
            object6 = object3[n12];
            if (object6 != null || (object6 = object[n12]) == null) continue;
            object6 = object[n12];
            n11 = object6.length();
            if (n11 == n10) {
                n11 = n10;
            } else {
                n11 = 0;
                object4 = null;
            }
            Assertions.checkState(n11 != 0);
            n11 = object6.getIndexInTrackGroup(0);
            if (n11 == 0) {
                n11 = n10;
            } else {
                n11 = 0;
                object4 = null;
            }
            Assertions.checkState(n11 != 0);
            object6 = object6.getTrackGroup();
            n14 = trackGroupArray.indexOf((TrackGroup)object6);
            Assertions.checkState((object5[n14] ^ n10) != 0);
            this.enabledTrackCount = n11 = this.enabledTrackCount + n10;
            object5[n14] = n10;
            object3[n12] = object4 = new ProgressiveMediaPeriod$SampleStreamImpl(this, n14);
            blArray[n12] = n10;
            if (n16 != 0) continue;
            object2 = this.sampleQueues[n14];
            if ((n14 = ((SampleQueue)object2).seekTo(l10, n10 != 0)) == 0 && (n16 = ((SampleQueue)object2).getReadIndex()) != 0) {
                n16 = n10;
                continue;
            }
            n16 = 0;
            object2 = null;
        }
        int n17 = this.enabledTrackCount;
        if (n17 == 0) {
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = false;
            object = this.loader;
            n17 = (int)(((Loader)object).isLoading() ? 1 : 0);
            if (n17 != 0) {
                object = this.sampleQueues;
                n16 = ((Object)object).length;
                while (n13 < n16) {
                    object3 = object[n13];
                    ((SampleQueue)object3).discardToEnd();
                    ++n13;
                }
                object = this.loader;
                ((Loader)object).cancelLoading();
            } else {
                object = this.sampleQueues;
                n16 = ((Object)object).length;
                while (n13 < n16) {
                    object3 = object[n13];
                    ((SampleQueue)object3).reset();
                    ++n13;
                }
            }
        } else if (n16 != 0) {
            l10 = this.seekToUs(l10);
            while (n13 < (n17 = ((SampleStream[])object3).length)) {
                object = object3[n13];
                if (object != null) {
                    blArray[n13] = n10;
                }
                ++n13;
            }
        }
        this.seenFirstTrackSelection = n10;
        return l10;
    }

    public int skipData(int n10, long l10) {
        boolean bl2 = this.suppressRead();
        if (bl2) {
            return 0;
        }
        this.maybeNotifyDownstreamFormat(n10);
        SampleQueue sampleQueue = this.sampleQueues[n10];
        boolean bl3 = this.loadingFinished;
        int n11 = sampleQueue.getSkipCount(l10, bl3);
        sampleQueue.skip(n11);
        if (n11 == 0) {
            this.maybeStartDeferredRetry(n10);
        }
        return n11;
    }

    public TrackOutput track(int n10, int n11) {
        ProgressiveMediaPeriod$TrackId progressiveMediaPeriod$TrackId = new ProgressiveMediaPeriod$TrackId(n10, false);
        return this.prepareTrackOutput(progressiveMediaPeriod$TrackId);
    }
}

