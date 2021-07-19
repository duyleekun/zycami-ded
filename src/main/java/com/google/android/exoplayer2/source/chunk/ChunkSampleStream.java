/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Looper
 */
package com.google.android.exoplayer2.source.chunk;

import android.net.Uri;
import android.os.Looper;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.SequenceableLoader$Callback;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunk;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor$TrackOutputProvider;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream$EmbeddedSampleStream;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream$ReleaseCallback;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader$Callback;
import com.google.android.exoplayer2.upstream.Loader$LoadErrorAction;
import com.google.android.exoplayer2.upstream.Loader$ReleaseCallback;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ChunkSampleStream
implements SampleStream,
SequenceableLoader,
Loader$Callback,
Loader$ReleaseCallback {
    private static final String TAG = "ChunkSampleStream";
    private final SequenceableLoader$Callback callback;
    private BaseMediaChunk canceledMediaChunk;
    private final BaseMediaChunkOutput chunkOutput;
    private final ChunkSource chunkSource;
    private final SampleQueue[] embeddedSampleQueues;
    private final Format[] embeddedTrackFormats;
    private final int[] embeddedTrackTypes;
    private final boolean[] embeddedTracksSelected;
    private long lastSeekPositionUs;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Loader loader;
    private Chunk loadingChunk;
    public boolean loadingFinished;
    private final ArrayList mediaChunks;
    private final MediaSourceEventListener$EventDispatcher mediaSourceEventDispatcher;
    private final ChunkHolder nextChunkHolder;
    private int nextNotifyPrimaryFormatMediaChunkIndex;
    private long pendingResetPositionUs;
    private Format primaryDownstreamTrackFormat;
    private final SampleQueue primarySampleQueue;
    public final int primaryTrackType;
    private final List readOnlyMediaChunks;
    private ChunkSampleStream$ReleaseCallback releaseCallback;

    public ChunkSampleStream(int object, int[] nArray, Format[] object2, ChunkSource object3, SequenceableLoader$Callback sampleQueueArray, Allocator allocator, long l10, DrmSessionManager drmSessionManager, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher) {
        Object object4;
        this.primaryTrackType = object;
        int n10 = 0;
        if (nArray == null) {
            nArray = new int[]{};
        }
        this.embeddedTrackTypes = nArray;
        if (object2 == null) {
            object2 = new Format[]{};
        }
        this.embeddedTrackFormats = object2;
        this.chunkSource = object3;
        this.callback = sampleQueueArray;
        this.mediaSourceEventDispatcher = mediaSourceEventListener$EventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        super("Loader:ChunkSampleStream");
        this.loader = object2;
        super();
        this.nextChunkHolder = object2;
        super();
        this.mediaChunks = object2;
        this.readOnlyMediaChunks = object2 = Collections.unmodifiableList(object2);
        int n11 = nArray.length;
        object2 = new SampleQueue[n11];
        this.embeddedSampleQueues = object2;
        object2 = new boolean[n11];
        this.embeddedTracksSelected = (boolean[])object2;
        int n12 = n11 + 1;
        object3 = new int[n12];
        object2 = new SampleQueue[n12];
        sampleQueueArray = (Looper)Assertions.checkNotNull(Looper.myLooper());
        sampleQueueArray = SampleQueue.createWithDrm(allocator, (Looper)sampleQueueArray, drmSessionManager, drmSessionEventListener$EventDispatcher);
        this.primarySampleQueue = sampleQueueArray;
        object3[0] = object;
        object2[0] = sampleQueueArray;
        while (n10 < n11) {
            object4 = SampleQueue.createWithoutDrm(allocator);
            sampleQueueArray = this.embeddedSampleQueues;
            sampleQueueArray[n10] = object4;
            int n13 = n10 + 1;
            object2[n13] = object4;
            object4 = this.embeddedTrackTypes;
            object = object4[n10];
            object3[n13] = object;
            n10 = n13;
        }
        this.chunkOutput = object4 = new BaseMediaChunkOutput((int[])object3, (SampleQueue[])object2);
        this.pendingResetPositionUs = l10;
        this.lastSeekPositionUs = l10;
    }

    public static /* synthetic */ BaseMediaChunk access$000(ChunkSampleStream chunkSampleStream) {
        return chunkSampleStream.canceledMediaChunk;
    }

    public static /* synthetic */ boolean[] access$100(ChunkSampleStream chunkSampleStream) {
        return chunkSampleStream.embeddedTracksSelected;
    }

    public static /* synthetic */ int[] access$200(ChunkSampleStream chunkSampleStream) {
        return chunkSampleStream.embeddedTrackTypes;
    }

    public static /* synthetic */ Format[] access$300(ChunkSampleStream chunkSampleStream) {
        return chunkSampleStream.embeddedTrackFormats;
    }

    public static /* synthetic */ long access$400(ChunkSampleStream chunkSampleStream) {
        return chunkSampleStream.lastSeekPositionUs;
    }

    public static /* synthetic */ MediaSourceEventListener$EventDispatcher access$500(ChunkSampleStream chunkSampleStream) {
        return chunkSampleStream.mediaSourceEventDispatcher;
    }

    private void discardDownstreamMediaChunks(int n10) {
        int n11 = 0;
        n10 = this.primarySampleIndexToMediaChunkIndex(n10, 0);
        int n12 = this.nextNotifyPrimaryFormatMediaChunkIndex;
        if ((n10 = Math.min(n10, n12)) > 0) {
            ArrayList arrayList = this.mediaChunks;
            Util.removeRange(arrayList, 0, n10);
            this.nextNotifyPrimaryFormatMediaChunkIndex = n11 = this.nextNotifyPrimaryFormatMediaChunkIndex - n10;
        }
    }

    private void discardUpstream(int n10) {
        int n11;
        int n12;
        int n13;
        ArrayList arrayList;
        block4: {
            Assertions.checkState(this.loader.isLoading() ^ true);
            arrayList = this.mediaChunks;
            n13 = arrayList.size();
            while (true) {
                n12 = -1;
                if (n10 >= n13) break;
                n11 = this.haveReadFromMediaChunk(n10);
                if (n11 != 0) {
                    ++n10;
                    continue;
                }
                break block4;
                break;
            }
            n10 = n12;
        }
        if (n10 == n12) {
            return;
        }
        long l10 = this.getLastMediaChunk().endTimeUs;
        BaseMediaChunk baseMediaChunk = this.discardUpstreamMediaChunksFromIndex(n10);
        arrayList = this.mediaChunks;
        n13 = (int)(arrayList.isEmpty() ? 1 : 0);
        if (n13 != 0) {
            long l11;
            this.pendingResetPositionUs = l11 = this.lastSeekPositionUs;
        }
        this.loadingFinished = false;
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.mediaSourceEventDispatcher;
        n11 = this.primaryTrackType;
        long l12 = baseMediaChunk.startTimeUs;
        mediaSourceEventListener$EventDispatcher.upstreamDiscarded(n11, l12, l10);
    }

    private BaseMediaChunk discardUpstreamMediaChunksFromIndex(int n10) {
        BaseMediaChunk baseMediaChunk = (BaseMediaChunk)this.mediaChunks.get(n10);
        ArrayList arrayList = this.mediaChunks;
        int n11 = arrayList.size();
        Util.removeRange(arrayList, n10, n11);
        n10 = this.nextNotifyPrimaryFormatMediaChunkIndex;
        int n12 = this.mediaChunks.size();
        this.nextNotifyPrimaryFormatMediaChunkIndex = n10 = Math.max(n10, n12);
        Object object = this.primarySampleQueue;
        n12 = 0;
        arrayList = null;
        n11 = baseMediaChunk.getFirstSampleIndex(0);
        ((SampleQueue)object).discardUpstreamSamples(n11);
        while (n12 < (n11 = ((SampleQueue[])(object = this.embeddedSampleQueues)).length)) {
            object = object[n12];
            n11 = baseMediaChunk.getFirstSampleIndex(++n12);
            ((SampleQueue)object).discardUpstreamSamples(n11);
        }
        return baseMediaChunk;
    }

    private BaseMediaChunk getLastMediaChunk() {
        ArrayList arrayList = this.mediaChunks;
        int n10 = arrayList.size() + -1;
        return (BaseMediaChunk)arrayList.get(n10);
    }

    private boolean haveReadFromMediaChunk(int n10) {
        Object object;
        int n11;
        BaseMediaChunk baseMediaChunk = (BaseMediaChunk)this.mediaChunks.get(n10);
        SampleQueue sampleQueue = this.primarySampleQueue;
        int n12 = sampleQueue.getReadIndex();
        int n13 = baseMediaChunk.getFirstSampleIndex(0);
        boolean bl2 = true;
        if (n12 > n13) {
            return bl2;
        }
        n12 = 0;
        sampleQueue = null;
        while (n12 < (n11 = ((SampleQueue[])(object = this.embeddedSampleQueues)).length)) {
            n13 = ((SampleQueue)(object = object[n12])).getReadIndex();
            if (n13 <= (n11 = baseMediaChunk.getFirstSampleIndex(++n12))) continue;
            return bl2;
        }
        return false;
    }

    private boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof BaseMediaChunk;
    }

    private void maybeNotifyPrimaryTrackFormatChanged() {
        SampleQueue sampleQueue = this.primarySampleQueue;
        int n10 = sampleQueue.getReadIndex();
        int n11 = this.nextNotifyPrimaryFormatMediaChunkIndex + -1;
        n10 = this.primarySampleIndexToMediaChunkIndex(n10, n11);
        while ((n11 = this.nextNotifyPrimaryFormatMediaChunkIndex) <= n10) {
            int n12;
            this.nextNotifyPrimaryFormatMediaChunkIndex = n12 = n11 + 1;
            this.maybeNotifyPrimaryTrackFormatChanged(n11);
        }
    }

    private void maybeNotifyPrimaryTrackFormatChanged(int n10) {
        BaseMediaChunk baseMediaChunk = (BaseMediaChunk)this.mediaChunks.get(n10);
        Format format = baseMediaChunk.trackFormat;
        Object object = this.primaryDownstreamTrackFormat;
        boolean bl2 = format.equals(object);
        if (!bl2) {
            object = this.mediaSourceEventDispatcher;
            int n11 = this.primaryTrackType;
            int n12 = baseMediaChunk.trackSelectionReason;
            Object object2 = baseMediaChunk.trackSelectionData;
            long l10 = baseMediaChunk.startTimeUs;
            ((MediaSourceEventListener$EventDispatcher)object).downstreamFormatChanged(n11, format, n12, object2, l10);
        }
        this.primaryDownstreamTrackFormat = format;
    }

    private int primarySampleIndexToMediaChunkIndex(int n10, int n11) {
        Object object;
        int n12;
        while (++n11 < (n12 = ((ArrayList)(object = this.mediaChunks)).size())) {
            object = (BaseMediaChunk)this.mediaChunks.get(n11);
            n12 = ((BaseMediaChunk)object).getFirstSampleIndex(0);
            if (n12 <= n10) continue;
            return n11 + -1;
        }
        return this.mediaChunks.size() + -1;
    }

    private void resetSampleQueues() {
        this.primarySampleQueue.reset();
        for (SampleQueue sampleQueue : this.embeddedSampleQueues) {
            sampleQueue.reset();
        }
    }

    public boolean continueLoading(long l10) {
        Object object;
        ChunkSampleStream chunkSampleStream = this;
        Object object2 = this.loadingFinished;
        int n10 = 0;
        Object object3 = null;
        if (!(object2 || (object2 = (object = this.loader).isLoading()) || (object2 = (object = this.loader).hasFatalError()))) {
            LoadEventInfo loadEventInfo;
            Object object4;
            long l11;
            long l12;
            Object object5;
            long l13;
            Object object6;
            object2 = this.isPendingReset();
            if (object2) {
                object6 = Collections.emptyList();
                l13 = this.pendingResetPositionUs;
            } else {
                object6 = this.readOnlyMediaChunks;
                object5 = this.getLastMediaChunk();
                l13 = ((Chunk)object5).endTimeUs;
            }
            Object object7 = chunkSampleStream.chunkSource;
            Object object8 = chunkSampleStream.nextChunkHolder;
            long l14 = l10;
            object7.getNextChunk(l10, l13, (List)object6, (ChunkHolder)object8);
            object6 = chunkSampleStream.nextChunkHolder;
            int n11 = ((ChunkHolder)object6).endOfStream;
            Chunk chunk = ((ChunkHolder)object6).chunk;
            ((ChunkHolder)object6).clear();
            long l15 = -9223372036854775807L;
            boolean bl2 = true;
            if (n11 != 0) {
                chunkSampleStream.pendingResetPositionUs = l15;
                chunkSampleStream.loadingFinished = bl2;
                return bl2;
            }
            if (chunk == null) {
                return false;
            }
            chunkSampleStream.loadingChunk = chunk;
            n11 = chunkSampleStream.isMediaChunk(chunk);
            if (n11 != 0) {
                object5 = chunk;
                object5 = (BaseMediaChunk)chunk;
                if (object2) {
                    l12 = ((Chunk)object5).startTimeUs;
                    l11 = chunkSampleStream.pendingResetPositionUs;
                    long l16 = l12 - l11;
                    object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                    if (object2) {
                        chunkSampleStream.primarySampleQueue.setStartTimeUs(l11);
                        object = chunkSampleStream.embeddedSampleQueues;
                        int n12 = ((SampleQueue[])object).length;
                        while (n10 < n12) {
                            object4 = object[n10];
                            l11 = chunkSampleStream.pendingResetPositionUs;
                            ((SampleQueue)object4).setStartTimeUs(l11);
                            ++n10;
                        }
                    }
                    chunkSampleStream.pendingResetPositionUs = l15;
                }
                object = chunkSampleStream.chunkOutput;
                ((BaseMediaChunk)object5).init((BaseMediaChunkOutput)object);
                object = chunkSampleStream.mediaChunks;
                object.add(object5);
            } else {
                object2 = chunk instanceof InitializationChunk;
                if (object2) {
                    object = chunk;
                    object = (InitializationChunk)chunk;
                    object3 = chunkSampleStream.chunkOutput;
                    object.init((ChunkExtractor$TrackOutputProvider)object3);
                }
            }
            object = chunkSampleStream.loader;
            object3 = chunkSampleStream.loadErrorHandlingPolicy;
            n11 = chunk.type;
            n10 = object3.getMinimumLoadableRetryCount(n11);
            l11 = object.startLoading(chunk, chunkSampleStream, n10);
            object8 = chunkSampleStream.mediaSourceEventDispatcher;
            l14 = chunk.loadTaskId;
            object4 = chunk.dataSpec;
            object7 = loadEventInfo;
            loadEventInfo = new LoadEventInfo(l14, (DataSpec)object4, l11);
            int n13 = chunk.type;
            int n14 = chunkSampleStream.primaryTrackType;
            object = chunk.trackFormat;
            n10 = chunk.trackSelectionReason;
            object5 = chunk.trackSelectionData;
            l15 = chunk.startTimeUs;
            l12 = chunk.endTimeUs;
            ((MediaSourceEventListener$EventDispatcher)object8).loadStarted(loadEventInfo, n13, n14, (Format)object, n10, object5, l15, l12);
            return bl2;
        }
        return false;
    }

    public void discardBuffer(long l10, boolean bl2) {
        int n10 = this.isPendingReset();
        if (n10 != 0) {
            return;
        }
        SampleQueue sampleQueue = this.primarySampleQueue;
        n10 = sampleQueue.getFirstIndex();
        SampleQueue sampleQueue2 = this.primarySampleQueue;
        boolean bl3 = true;
        sampleQueue2.discardTo(l10, bl2, bl3);
        SampleQueue sampleQueue3 = this.primarySampleQueue;
        int n11 = sampleQueue3.getFirstIndex();
        if (n11 > n10) {
            Object object;
            int n12;
            long l11 = this.primarySampleQueue.getFirstTimestampUs();
            for (int i10 = 0; i10 < (n12 = ((SampleQueue[])(object = this.embeddedSampleQueues)).length); ++i10) {
                object = object[i10];
                boolean[] blArray = this.embeddedTracksSelected;
                n12 = blArray[i10];
                ((SampleQueue)object).discardTo(l11, bl2, n12 != 0);
            }
        }
        this.discardDownstreamMediaChunks(n11);
    }

    public long getAdjustedSeekPositionUs(long l10, SeekParameters seekParameters) {
        return this.chunkSource.getAdjustedSeekPositionUs(l10, seekParameters);
    }

    public long getBufferedPositionUs() {
        long l10;
        boolean bl2 = this.loadingFinished;
        if (bl2) {
            return Long.MIN_VALUE;
        }
        bl2 = this.isPendingReset();
        if (bl2) {
            return this.pendingResetPositionUs;
        }
        long l11 = this.lastSeekPositionUs;
        Object object = this.getLastMediaChunk();
        boolean n10 = ((MediaChunk)object).isLoadCompleted();
        if (!n10) {
            int n11;
            object = this.mediaChunks;
            int n12 = ((ArrayList)object).size();
            if (n12 > (n11 = 1)) {
                object = this.mediaChunks;
                int n13 = ((ArrayList)object).size() + -2;
                object = (BaseMediaChunk)((ArrayList)object).get(n13);
            } else {
                n12 = 0;
                object = null;
            }
        }
        if (object != null) {
            l10 = ((Chunk)object).endTimeUs;
            l11 = Math.max(l11, l10);
        }
        l10 = this.primarySampleQueue.getLargestQueuedTimestampUs();
        return Math.max(l11, l10);
    }

    public ChunkSource getChunkSource() {
        return this.chunkSource;
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
            BaseMediaChunk baseMediaChunk = this.getLastMediaChunk();
            l10 = baseMediaChunk.endTimeUs;
        }
        return l10;
    }

    public boolean isLoading() {
        return this.loader.isLoading();
    }

    public boolean isPendingReset() {
        long l10 = this.pendingResetPositionUs;
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object != false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public boolean isReady() {
        boolean bl2;
        SampleQueue sampleQueue;
        boolean bl3 = this.isPendingReset();
        if (!bl3 && (bl3 = (sampleQueue = this.primarySampleQueue).isReady(bl2 = this.loadingFinished))) {
            bl3 = true;
        } else {
            bl3 = false;
            sampleQueue = null;
        }
        return bl3;
    }

    public void maybeThrowError() {
        this.loader.maybeThrowError();
        this.primarySampleQueue.maybeThrowError();
        Object object = this.loader;
        boolean bl2 = ((Loader)object).isLoading();
        if (!bl2) {
            object = this.chunkSource;
            object.maybeThrowError();
        }
    }

    public void onLoadCanceled(Chunk chunk, long l10, long l11, boolean bl2) {
        LoadEventInfo loadEventInfo;
        ChunkSampleStream chunkSampleStream = this;
        Object object = chunk;
        boolean bl3 = false;
        this.loadingChunk = null;
        this.canceledMediaChunk = null;
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
        int n11 = this.primaryTrackType;
        object2 = chunk.trackFormat;
        int n12 = chunk.trackSelectionReason;
        Object object4 = chunk.trackSelectionData;
        long l14 = chunk.startTimeUs;
        long l15 = chunk.endTimeUs;
        ((MediaSourceEventListener$EventDispatcher)object3).loadCanceled(loadEventInfo, n10, n11, (Format)object2, n12, object4, l14, l15);
        if (!bl2) {
            bl3 = this.isPendingReset();
            if (bl3) {
                this.resetSampleQueues();
            } else {
                int n13 = this.isMediaChunk(chunk);
                if (n13 != 0) {
                    n13 = this.mediaChunks.size() + -1;
                    this.discardUpstreamMediaChunksFromIndex(n13);
                    object = this.mediaChunks;
                    n13 = (int)(((ArrayList)object).isEmpty() ? 1 : 0);
                    if (n13 != 0) {
                        long l16;
                        this.pendingResetPositionUs = l16 = this.lastSeekPositionUs;
                    }
                }
            }
            object = chunkSampleStream.callback;
            object.onContinueLoadingRequested(this);
        }
    }

    public void onLoadCompleted(Chunk chunk, long l10, long l11) {
        LoadEventInfo loadEventInfo;
        this.loadingChunk = null;
        this.chunkSource.onChunkLoadCompleted(chunk);
        long l12 = chunk.loadTaskId;
        DataSpec dataSpec = chunk.dataSpec;
        Object object = chunk.getUri();
        Map map = chunk.getResponseHeaders();
        long l13 = chunk.bytesLoaded();
        Object object2 = loadEventInfo;
        loadEventInfo = new LoadEventInfo(l12, dataSpec, (Uri)object, map, l10, l11, l13);
        object2 = this.loadErrorHandlingPolicy;
        l12 = chunk.loadTaskId;
        object2.onLoadTaskConcluded(l12);
        object2 = this.mediaSourceEventDispatcher;
        int n10 = chunk.type;
        int n11 = this.primaryTrackType;
        object = chunk.trackFormat;
        int n12 = chunk.trackSelectionReason;
        Object object3 = chunk.trackSelectionData;
        long l14 = chunk.startTimeUs;
        long l15 = chunk.endTimeUs;
        ((MediaSourceEventListener$EventDispatcher)object2).loadCompleted(loadEventInfo, n10, n11, (Format)object, n12, object3, l14, l15);
        this.callback.onContinueLoadingRequested(this);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public Loader$LoadErrorAction onLoadError(Chunk chunk, long l10, long l11, IOException iOException, int n10) {
        long l12;
        LoadEventInfo loadEventInfo;
        Object object;
        long l13;
        long l14;
        int n11;
        Object object2;
        Object object3;
        Object object4;
        int n12;
        int n13;
        Object object5;
        Chunk chunk2;
        ChunkSampleStream chunkSampleStream;
        block12: {
            block10: {
                block11: {
                    chunkSampleStream = this;
                    chunk2 = chunk;
                    long l15 = chunk.bytesLoaded();
                    boolean bl2 = this.isMediaChunk(chunk);
                    object5 = this.mediaChunks;
                    n13 = ((ArrayList)object5).size();
                    boolean bl3 = true;
                    float f10 = Float.MIN_VALUE;
                    n12 = n13 + -1;
                    long l16 = 0L;
                    n13 = (int)(l15 == l16 ? 0 : (l15 < l16 ? -1 : 1));
                    boolean bl4 = false;
                    boolean bl5 = n13 != 0 && bl2 && (n13 = (int)(this.haveReadFromMediaChunk(n12) ? 1 : 0)) != 0 ? false : bl3;
                    long l17 = chunk2.loadTaskId;
                    object4 = chunk2.dataSpec;
                    Uri uri = chunk.getUri();
                    Map map = chunk.getResponseHeaders();
                    object2 = object3;
                    object3 = new LoadEventInfo(l17, (DataSpec)object4, uri, map, l10, l11, l15);
                    n11 = chunk2.type;
                    int n14 = chunkSampleStream.primaryTrackType;
                    object2 = chunk2.trackFormat;
                    int n15 = chunk2.trackSelectionReason;
                    Object object6 = chunk2.trackSelectionData;
                    long l18 = C.usToMs(chunk2.startTimeUs);
                    long l19 = chunk2.endTimeUs;
                    long l20 = C.usToMs(l19);
                    object5 = new MediaLoadData(n11, n14, (Format)object2, n15, object6, l18, l20);
                    n11 = n10;
                    object2 = new LoadErrorHandlingPolicy$LoadErrorInfo((LoadEventInfo)object3, (MediaLoadData)object5, iOException, n10);
                    l14 = -9223372036854775807L;
                    if (bl5) {
                        object5 = chunkSampleStream.loadErrorHandlingPolicy;
                        l13 = l16 = object5.getBlacklistDurationMsFor((LoadErrorHandlingPolicy$LoadErrorInfo)object2);
                    } else {
                        l13 = l14;
                    }
                    object5 = chunkSampleStream.chunkSource;
                    object = chunk;
                    boolean bl6 = bl5;
                    loadEventInfo = object3;
                    object3 = iOException;
                    n13 = (int)(object5.onChunkLoadError(chunk, bl5, iOException, l13) ? 1 : 0);
                    if (n13 == 0) break block10;
                    if (!bl5) break block11;
                    object5 = Loader.DONT_RETRY;
                    if (bl2) {
                        void var20_19;
                        Object object7 = chunkSampleStream.discardUpstreamMediaChunksFromIndex(n12);
                        if (object7 == chunk2) {
                            boolean bl7 = bl3;
                        } else {
                            boolean bl8 = false;
                        }
                        Assertions.checkState((boolean)var20_19);
                        object7 = chunkSampleStream.mediaChunks;
                        boolean bl9 = ((ArrayList)object7).isEmpty();
                        if (bl9) {
                            chunkSampleStream.pendingResetPositionUs = l12 = chunkSampleStream.lastSeekPositionUs;
                        }
                    }
                    break block12;
                }
                object5 = TAG;
                String string2 = "Ignoring attempt to cancel non-cancelable load.";
                Log.w((String)object5, string2);
            }
            n13 = 0;
            object5 = null;
        }
        if (object5 == null) {
            object5 = chunkSampleStream.loadErrorHandlingPolicy;
            l12 = object5.getRetryDelayMsFor((LoadErrorHandlingPolicy$LoadErrorInfo)object2);
            long l21 = l12 - l14;
            n13 = (int)(l21 == 0L ? 0 : (l21 < 0L ? -1 : 1));
            if (n13 != 0) {
                n13 = 0;
                object5 = Loader.createRetryAction(false, l12);
            } else {
                object5 = Loader.DONT_RETRY_FATAL;
            }
        }
        boolean bl10 = ((Loader$LoadErrorAction)object5).isRetry() ^ true;
        object3 = chunkSampleStream.mediaSourceEventDispatcher;
        n12 = chunk2.type;
        int n16 = chunkSampleStream.primaryTrackType;
        object2 = chunk2.trackFormat;
        int n17 = chunk2.trackSelectionReason;
        object4 = chunk2.trackSelectionData;
        l13 = chunk2.startTimeUs;
        long l22 = chunk2.endTimeUs;
        ((MediaSourceEventListener$EventDispatcher)object3).loadError(loadEventInfo, n12, n16, (Format)object2, n17, object4, l13, l22, iOException, bl10);
        if (bl10) {
            n11 = 0;
            chunkSampleStream.loadingChunk = null;
            object = chunkSampleStream.loadErrorHandlingPolicy;
            l12 = chunk2.loadTaskId;
            object.onLoadTaskConcluded(l12);
            object = chunkSampleStream.callback;
            object.onContinueLoadingRequested(chunkSampleStream);
        }
        return object5;
    }

    public void onLoaderReleased() {
        this.primarySampleQueue.release();
        for (SampleQueue sampleQueue : this.embeddedSampleQueues) {
            sampleQueue.release();
        }
        this.chunkSource.release();
        ChunkSampleStream$ReleaseCallback chunkSampleStream$ReleaseCallback = this.releaseCallback;
        if (chunkSampleStream$ReleaseCallback != null) {
            chunkSampleStream$ReleaseCallback.onSampleStreamReleased(this);
        }
    }

    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean bl2) {
        SampleQueue sampleQueue;
        int n10;
        int n11 = this.isPendingReset();
        int n12 = -3;
        if (n11 != 0) {
            return n12;
        }
        Object object = this.canceledMediaChunk;
        if (object != null && (n11 = ((BaseMediaChunk)object).getFirstSampleIndex(0)) <= (n10 = (sampleQueue = this.primarySampleQueue).getReadIndex())) {
            return n12;
        }
        this.maybeNotifyPrimaryTrackFormatChanged();
        object = this.primarySampleQueue;
        n12 = (int)(this.loadingFinished ? 1 : 0);
        return ((SampleQueue)object).read(formatHolder, decoderInputBuffer, bl2, n12 != 0);
    }

    public void reevaluateBuffer(long l10) {
        Object object = this.loader;
        boolean bl2 = ((Loader)object).hasFatalError();
        if (!bl2 && !(bl2 = this.isPendingReset())) {
            ArrayList arrayList;
            int n10;
            object = this.loader;
            bl2 = ((Loader)object).isLoading();
            if (bl2) {
                List list;
                boolean bl3;
                Object object2;
                object = (Chunk)Assertions.checkNotNull(this.loadingChunk);
                int n11 = this.isMediaChunk((Chunk)object);
                if (n11 != 0) {
                    object2 = this.mediaChunks;
                    n11 = ((ArrayList)object2).size() + -1;
                    if ((n11 = (int)(this.haveReadFromMediaChunk(n11) ? 1 : 0)) != 0) {
                        return;
                    }
                }
                if (bl3 = (object2 = this.chunkSource).shouldCancelLoad(l10, (Chunk)object, list = this.readOnlyMediaChunks)) {
                    Loader loader = this.loader;
                    loader.cancelLoading();
                    bl3 = this.isMediaChunk((Chunk)object);
                    if (bl3) {
                        this.canceledMediaChunk = object = (BaseMediaChunk)object;
                    }
                }
                return;
            }
            object = this.chunkSource;
            List list = this.readOnlyMediaChunks;
            int n12 = object.getPreferredQueueSize(l10, list);
            if (n12 < (n10 = (arrayList = this.mediaChunks).size())) {
                this.discardUpstream(n12);
            }
        }
    }

    public void release() {
        this.release(null);
    }

    public void release(ChunkSampleStream$ReleaseCallback sampleQueueArray) {
        this.releaseCallback = sampleQueueArray;
        this.primarySampleQueue.preRelease();
        for (SampleQueue sampleQueue : this.embeddedSampleQueues) {
            sampleQueue.preRelease();
        }
        this.loader.release(this);
    }

    public void seekToUs(long l10) {
        Object object;
        int n10;
        int n11;
        this.lastSeekPositionUs = l10;
        int n12 = this.isPendingReset();
        if (n12 != 0) {
            this.pendingResetPositionUs = l10;
            return;
        }
        n12 = 0;
        Object object2 = null;
        int n13 = 0;
        for (n11 = 0; n11 < (n10 = ((ArrayList)(object = this.mediaChunks)).size()); ++n11) {
            long l11;
            long l12;
            long l13;
            long l14;
            object = (BaseMediaChunk)this.mediaChunks.get(n11);
            long l15 = ((Chunk)object).startTimeUs;
            long l16 = l15 - l10;
            Object object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object3 == false && (l14 = (l13 = (l12 = ((BaseMediaChunk)object).clippedStartTimeUs) - (l11 = -9223372036854775807L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == false) {
                object2 = object;
                break;
            }
            if (object3 > 0) break;
        }
        n11 = 1;
        if (object2 != null) {
            object = this.primarySampleQueue;
            n12 = ((BaseMediaChunk)object2).getFirstSampleIndex(0);
            n12 = (int)(((SampleQueue)object).seekTo(n12) ? 1 : 0);
        } else {
            object2 = this.primarySampleQueue;
            long l17 = this.getNextLoadPositionUs();
            long l18 = l10 - l17;
            n10 = (int)(l18 == 0L ? 0 : (l18 < 0L ? -1 : 1));
            if (n10 < 0) {
                n10 = n11;
            } else {
                n10 = 0;
                object = null;
            }
            n12 = (int)(((SampleQueue)object2).seekTo(l10, n10 != 0) ? 1 : 0);
        }
        if (n12 != 0) {
            n12 = this.primarySampleQueue.getReadIndex();
            this.nextNotifyPrimaryFormatMediaChunkIndex = n12 = this.primarySampleIndexToMediaChunkIndex(n12, 0);
            object2 = this.embeddedSampleQueues;
            n10 = ((SampleQueue[])object2).length;
            while (n13 < n10) {
                SampleQueue sampleQueue = object2[n13];
                sampleQueue.seekTo(l10, n11 != 0);
                ++n13;
            }
        } else {
            this.pendingResetPositionUs = l10;
            this.loadingFinished = false;
            this.mediaChunks.clear();
            this.nextNotifyPrimaryFormatMediaChunkIndex = 0;
            Object object4 = this.loader;
            boolean bl2 = ((Loader)object4).isLoading();
            if (bl2) {
                this.primarySampleQueue.discardToEnd();
                object4 = this.embeddedSampleQueues;
                int n14 = ((SampleQueue[])object4).length;
                while (n13 < n14) {
                    object2 = object4[n13];
                    ((SampleQueue)object2).discardToEnd();
                    ++n13;
                }
                object4 = this.loader;
                ((Loader)object4).cancelLoading();
            } else {
                object4 = this.loader;
                ((Loader)object4).clearFatalError();
                this.resetSampleQueues();
            }
        }
    }

    public ChunkSampleStream$EmbeddedSampleStream selectEmbeddedTrack(long l10, int n10) {
        Object[] objectArray;
        int n11;
        for (int i10 = 0; i10 < (n11 = (objectArray = this.embeddedSampleQueues).length); ++i10) {
            objectArray = this.embeddedTrackTypes;
            n11 = (int)objectArray[i10];
            if (n11 != n10) continue;
            n10 = this.embeddedTracksSelected[i10];
            n11 = 1;
            Assertions.checkState((n10 ^ n11) != 0);
            this.embeddedTracksSelected[i10] = n11;
            this.embeddedSampleQueues[i10].seekTo(l10, n11 != 0);
            SampleQueue sampleQueue = this.embeddedSampleQueues[i10];
            ChunkSampleStream$EmbeddedSampleStream chunkSampleStream$EmbeddedSampleStream = new ChunkSampleStream$EmbeddedSampleStream(this, this, sampleQueue, i10);
            return chunkSampleStream$EmbeddedSampleStream;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    public int skipData(long l10) {
        int n10 = this.isPendingReset();
        if (n10 != 0) {
            return 0;
        }
        SampleQueue sampleQueue = this.primarySampleQueue;
        boolean bl2 = this.loadingFinished;
        int n11 = sampleQueue.getSkipCount(l10, bl2);
        BaseMediaChunk baseMediaChunk = this.canceledMediaChunk;
        if (baseMediaChunk != null) {
            int n12 = baseMediaChunk.getFirstSampleIndex(0);
            sampleQueue = this.primarySampleQueue;
            n10 = sampleQueue.getReadIndex();
            n11 = Math.min(n11, n12 -= n10);
        }
        this.primarySampleQueue.skip(n11);
        this.maybeNotifyPrimaryTrackFormatChanged();
        return n11;
    }
}

