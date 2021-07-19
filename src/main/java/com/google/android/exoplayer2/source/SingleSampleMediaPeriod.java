/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod$Callback;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SingleSampleMediaPeriod$SampleStreamImpl;
import com.google.android.exoplayer2.source.SingleSampleMediaPeriod$SourceLoadable;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader$Callback;
import com.google.android.exoplayer2.upstream.Loader$LoadErrorAction;
import com.google.android.exoplayer2.upstream.Loader$Loadable;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public final class SingleSampleMediaPeriod
implements MediaPeriod,
Loader$Callback {
    private static final int INITIAL_SAMPLE_SIZE = 1024;
    private static final String TAG = "SingleSampleMediaPeriod";
    private final DataSource$Factory dataSourceFactory;
    private final DataSpec dataSpec;
    private final long durationUs;
    private final MediaSourceEventListener$EventDispatcher eventDispatcher;
    public final Format format;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    public final Loader loader;
    public boolean loadingFinished;
    public byte[] sampleData;
    public int sampleSize;
    private final ArrayList sampleStreams;
    private final TrackGroupArray tracks;
    private final TransferListener transferListener;
    public final boolean treatLoadErrorsAsEndOfStream;

    public SingleSampleMediaPeriod(DataSpec object, DataSource$Factory formatArray, TransferListener trackGroupArray, Format format, long l10, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher, boolean bl2) {
        TrackGroup trackGroup;
        this.dataSpec = object;
        this.dataSourceFactory = formatArray;
        this.transferListener = trackGroupArray;
        this.format = format;
        this.durationUs = l10;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.eventDispatcher = mediaSourceEventListener$EventDispatcher;
        this.treatLoadErrorsAsEndOfStream = bl2;
        int n10 = 1;
        trackGroupArray = new TrackGroup[n10];
        formatArray = new Format[n10];
        formatArray[0] = format;
        trackGroupArray[0] = trackGroup = new TrackGroup(formatArray);
        this.tracks = object = new TrackGroupArray(trackGroupArray);
        object = new ArrayList();
        this.sampleStreams = object;
        this.loader = object = new Loader("Loader:SingleSampleMediaPeriod");
    }

    public static /* synthetic */ MediaSourceEventListener$EventDispatcher access$300(SingleSampleMediaPeriod singleSampleMediaPeriod) {
        return singleSampleMediaPeriod.eventDispatcher;
    }

    public boolean continueLoading(long l10) {
        Object object;
        SingleSampleMediaPeriod singleSampleMediaPeriod = this;
        boolean bl2 = this.loadingFinished;
        if (!(bl2 || (bl2 = ((Loader)(object = this.loader)).isLoading()) || (bl2 = ((Loader)(object = this.loader)).hasFatalError()))) {
            object = this.dataSourceFactory.createDataSource();
            Object object2 = this.transferListener;
            if (object2 != null) {
                object.addTransferListener((TransferListener)object2);
            }
            Object object3 = singleSampleMediaPeriod.dataSpec;
            object2 = new SingleSampleMediaPeriod$SourceLoadable((DataSpec)object3, (DataSource)object);
            object = singleSampleMediaPeriod.loader;
            object3 = singleSampleMediaPeriod.loadErrorHandlingPolicy;
            boolean bl3 = true;
            int n10 = object3.getMinimumLoadableRetryCount((int)(bl3 ? 1 : 0));
            long l11 = ((Loader)object).startLoading((Loader$Loadable)object2, singleSampleMediaPeriod, n10);
            MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = singleSampleMediaPeriod.eventDispatcher;
            long l12 = ((SingleSampleMediaPeriod$SourceLoadable)object2).loadTaskId;
            DataSpec dataSpec = singleSampleMediaPeriod.dataSpec;
            LoadEventInfo loadEventInfo = new LoadEventInfo(l12, dataSpec, l11);
            Format format = singleSampleMediaPeriod.format;
            long l13 = singleSampleMediaPeriod.durationUs;
            mediaSourceEventListener$EventDispatcher.loadStarted(loadEventInfo, 1, -1, format, 0, null, 0L, l13);
            return bl3;
        }
        return false;
    }

    public void discardBuffer(long l10, boolean bl2) {
    }

    public long getAdjustedSeekPositionUs(long l10, SeekParameters seekParameters) {
        return l10;
    }

    public long getBufferedPositionUs() {
        boolean bl2 = this.loadingFinished;
        long l10 = bl2 ? Long.MIN_VALUE : 0L;
        return l10;
    }

    public long getNextLoadPositionUs() {
        Loader loader;
        boolean bl2 = this.loadingFinished;
        long l10 = !bl2 && !(bl2 = (loader = this.loader).isLoading()) ? 0L : Long.MIN_VALUE;
        return l10;
    }

    public TrackGroupArray getTrackGroups() {
        return this.tracks;
    }

    public boolean isLoading() {
        return this.loader.isLoading();
    }

    public void maybeThrowPrepareError() {
    }

    public void onLoadCanceled(SingleSampleMediaPeriod$SourceLoadable singleSampleMediaPeriod$SourceLoadable, long l10, long l11, boolean bl2) {
        LoadEventInfo loadEventInfo;
        Object object = SingleSampleMediaPeriod$SourceLoadable.access$100(singleSampleMediaPeriod$SourceLoadable);
        long l12 = singleSampleMediaPeriod$SourceLoadable.loadTaskId;
        DataSpec dataSpec = singleSampleMediaPeriod$SourceLoadable.dataSpec;
        Uri uri = ((StatsDataSource)object).getLastOpenedUri();
        Map map = ((StatsDataSource)object).getLastResponseHeaders();
        long l13 = ((StatsDataSource)object).getBytesRead();
        Object object2 = loadEventInfo;
        loadEventInfo = new LoadEventInfo(l12, dataSpec, uri, map, l10, l11, l13);
        object = this.loadErrorHandlingPolicy;
        long l14 = singleSampleMediaPeriod$SourceLoadable.loadTaskId;
        object.onLoadTaskConcluded(l14);
        object2 = this.eventDispatcher;
        long l15 = this.durationUs;
        ((MediaSourceEventListener$EventDispatcher)object2).loadCanceled(loadEventInfo, 1, -1, null, 0, null, 0L, l15);
    }

    public void onLoadCompleted(SingleSampleMediaPeriod$SourceLoadable singleSampleMediaPeriod$SourceLoadable, long l10, long l11) {
        LoadEventInfo loadEventInfo;
        int n10;
        this.sampleSize = n10 = (int)SingleSampleMediaPeriod$SourceLoadable.access$100(singleSampleMediaPeriod$SourceLoadable).getBytesRead();
        Object object = (byte[])Assertions.checkNotNull(SingleSampleMediaPeriod$SourceLoadable.access$200(singleSampleMediaPeriod$SourceLoadable));
        this.sampleData = object;
        this.loadingFinished = true;
        object = SingleSampleMediaPeriod$SourceLoadable.access$100(singleSampleMediaPeriod$SourceLoadable);
        long l12 = singleSampleMediaPeriod$SourceLoadable.loadTaskId;
        DataSpec dataSpec = singleSampleMediaPeriod$SourceLoadable.dataSpec;
        Object object2 = ((StatsDataSource)object).getLastOpenedUri();
        Map map = ((StatsDataSource)object).getLastResponseHeaders();
        long l13 = this.sampleSize;
        Object object3 = loadEventInfo;
        loadEventInfo = new LoadEventInfo(l12, dataSpec, (Uri)object2, map, l10, l11, l13);
        object = this.loadErrorHandlingPolicy;
        long l14 = singleSampleMediaPeriod$SourceLoadable.loadTaskId;
        object.onLoadTaskConcluded(l14);
        object3 = this.eventDispatcher;
        object2 = this.format;
        long l15 = this.durationUs;
        ((MediaSourceEventListener$EventDispatcher)object3).loadCompleted(loadEventInfo, 1, -1, (Format)object2, 0, null, 0L, l15);
    }

    /*
     * Enabled aggressive block sorting
     */
    public Loader$LoadErrorAction onLoadError(SingleSampleMediaPeriod$SourceLoadable singleSampleMediaPeriod$SourceLoadable, long l10, long l11, IOException iOException, int n10) {
        Object object;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        int n11;
        SingleSampleMediaPeriod singleSampleMediaPeriod = this;
        SingleSampleMediaPeriod$SourceLoadable singleSampleMediaPeriod$SourceLoadable2 = singleSampleMediaPeriod$SourceLoadable;
        IOException iOException2 = iOException;
        int n12 = n10;
        Object object2 = SingleSampleMediaPeriod$SourceLoadable.access$100(singleSampleMediaPeriod$SourceLoadable);
        long l12 = singleSampleMediaPeriod$SourceLoadable.loadTaskId;
        Object object3 = singleSampleMediaPeriod$SourceLoadable.dataSpec;
        Uri uri = ((StatsDataSource)object2).getLastOpenedUri();
        Map map = ((StatsDataSource)object2).getLastResponseHeaders();
        long l13 = ((StatsDataSource)object2).getBytesRead();
        LoadEventInfo loadEventInfo = new LoadEventInfo(l12, (DataSpec)object3, uri, map, l10, l11, l13);
        Object object4 = this.format;
        long l14 = this.durationUs;
        long l15 = C.usToMs(l14);
        int n13 = 1;
        int n14 = -1;
        long l16 = 0L;
        object2 = new MediaLoadData(n13, n14, (Format)object4, 0, null, l16, l15);
        object4 = this.loadErrorHandlingPolicy;
        Object object5 = new LoadErrorHandlingPolicy$LoadErrorInfo(loadEventInfo, (MediaLoadData)object2, iOException, n10);
        l12 = object4.getRetryDelayMsFor((LoadErrorHandlingPolicy$LoadErrorInfo)object5);
        long l17 = -9223372036854775807L;
        long l18 = l12 == l17 ? 0 : (l12 < l17 ? -1 : 1);
        object3 = null;
        int n15 = 1;
        if (l18 != false && n10 < (n11 = (loadErrorHandlingPolicy = this.loadErrorHandlingPolicy).getMinimumLoadableRetryCount(n15))) {
            n12 = 0;
            object = null;
        } else {
            n12 = n15;
        }
        n11 = singleSampleMediaPeriod.treatLoadErrorsAsEndOfStream;
        if (n11 != 0 && n12 != 0) {
            object2 = "Loading failed, treating as end-of-stream.";
            Log.w(TAG, (String)object2, iOException2);
            singleSampleMediaPeriod.loadingFinished = n15;
            object = Loader.DONT_RETRY;
        } else {
            object = l18 != false ? Loader.createRetryAction(false, l12) : Loader.DONT_RETRY_FATAL;
        }
        Loader$LoadErrorAction loader$LoadErrorAction = object;
        n12 = (int)(((Loader$LoadErrorAction)object).isRetry() ? 1 : 0);
        boolean bl2 = n12 ^ 1;
        object = singleSampleMediaPeriod.eventDispatcher;
        int n16 = -1;
        object3 = singleSampleMediaPeriod.format;
        n11 = 0;
        loadErrorHandlingPolicy = null;
        long l19 = singleSampleMediaPeriod.durationUs;
        object2 = loadEventInfo;
        int n17 = 1;
        object5 = object3;
        object3 = null;
        n15 = 0;
        long l20 = 0L;
        iOException2 = iOException;
        ((MediaSourceEventListener$EventDispatcher)object).loadError(loadEventInfo, n17, n16, (Format)object5, 0, null, l20, l19, iOException, bl2);
        if (bl2) {
            object = singleSampleMediaPeriod.loadErrorHandlingPolicy;
            long l21 = singleSampleMediaPeriod$SourceLoadable2.loadTaskId;
            object.onLoadTaskConcluded(l21);
        }
        return loader$LoadErrorAction;
    }

    public void prepare(MediaPeriod$Callback mediaPeriod$Callback, long l10) {
        mediaPeriod$Callback.onPrepared(this);
    }

    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    public void reevaluateBuffer(long l10) {
    }

    public void release() {
        this.loader.release();
    }

    public long seekToUs(long l10) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.sampleStreams)).size()); ++i10) {
            object = (SingleSampleMediaPeriod$SampleStreamImpl)this.sampleStreams.get(i10);
            ((SingleSampleMediaPeriod$SampleStreamImpl)object).reset();
        }
        return l10;
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArray, boolean[] blArray, SampleStream[] sampleStreamArray, boolean[] blArray2, long l10) {
        int n10;
        for (int i10 = 0; i10 < (n10 = exoTrackSelectionArray.length); ++i10) {
            Object object = sampleStreamArray[i10];
            ArrayList arrayList = null;
            if (object != null && ((object = exoTrackSelectionArray[i10]) == null || (n10 = blArray[i10]) == 0)) {
                object = this.sampleStreams;
                SampleStream sampleStream = sampleStreamArray[i10];
                ((ArrayList)object).remove(sampleStream);
                sampleStreamArray[i10] = null;
            }
            if ((object = sampleStreamArray[i10]) != null || (object = exoTrackSelectionArray[i10]) == null) continue;
            object = new SingleSampleMediaPeriod$SampleStreamImpl(this, null);
            arrayList = this.sampleStreams;
            arrayList.add(object);
            sampleStreamArray[i10] = object;
            blArray2[i10] = n10 = 1;
        }
        return l10;
    }
}

