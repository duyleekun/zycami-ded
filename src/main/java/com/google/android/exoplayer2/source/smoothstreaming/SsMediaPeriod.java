/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod$Callback;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.SequenceableLoader$Callback;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource$Factory;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest$StreamElement;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.util.ArrayList;
import java.util.List;

public final class SsMediaPeriod
implements MediaPeriod,
SequenceableLoader$Callback {
    private final Allocator allocator;
    private MediaPeriod$Callback callback;
    private final SsChunkSource$Factory chunkSourceFactory;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final DrmSessionEventListener$EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private SsManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final MediaSourceEventListener$EventDispatcher mediaSourceEventDispatcher;
    private ChunkSampleStream[] sampleStreams;
    private final TrackGroupArray trackGroups;
    private final TransferListener transferListener;

    public SsMediaPeriod(SsManifest object, SsChunkSource$Factory ssChunkSource$Factory, TransferListener transferListener, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher, LoaderErrorThrower loaderErrorThrower, Allocator allocator) {
        this.manifest = object;
        this.chunkSourceFactory = ssChunkSource$Factory;
        this.transferListener = transferListener;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.drmSessionManager = drmSessionManager;
        this.drmEventDispatcher = drmSessionEventListener$EventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.mediaSourceEventDispatcher = mediaSourceEventListener$EventDispatcher;
        this.allocator = allocator;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        object = SsMediaPeriod.buildTrackGroups((SsManifest)object, drmSessionManager);
        this.trackGroups = object;
        object = SsMediaPeriod.newSampleStreamArray(0);
        this.sampleStreams = object;
        this.compositeSequenceableLoader = object = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader((SequenceableLoader)object);
    }

    private ChunkSampleStream buildSampleStream(ExoTrackSelection exoTrackSelection, long l10) {
        ChunkSampleStream chunkSampleStream;
        Object object = this.trackGroups;
        TrackGroup trackGroup = exoTrackSelection.getTrackGroup();
        int n10 = ((TrackGroupArray)object).indexOf(trackGroup);
        SsChunkSource$Factory ssChunkSource$Factory = this.chunkSourceFactory;
        LoaderErrorThrower loaderErrorThrower = this.manifestLoaderErrorThrower;
        Object object2 = this.manifest;
        TransferListener transferListener = this.transferListener;
        Object object3 = exoTrackSelection;
        object2 = ssChunkSource$Factory.createChunkSource(loaderErrorThrower, (SsManifest)object2, n10, exoTrackSelection, transferListener);
        int n11 = this.manifest.streamElements[n10].type;
        object3 = this.allocator;
        DrmSessionManager drmSessionManager = this.drmSessionManager;
        DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.drmEventDispatcher;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.mediaSourceEventDispatcher;
        object = chunkSampleStream;
        chunkSampleStream = new ChunkSampleStream(n11, null, null, (ChunkSource)object2, this, (Allocator)object3, l10, drmSessionManager, drmSessionEventListener$EventDispatcher, loadErrorHandlingPolicy, mediaSourceEventListener$EventDispatcher);
        return chunkSampleStream;
    }

    private static TrackGroupArray buildTrackGroups(SsManifest object, DrmSessionManager drmSessionManager) {
        Object object2;
        int n10;
        int n11 = ((SsManifest)object).streamElements.length;
        TrackGroup[] trackGroupArray = new TrackGroup[n11];
        for (int i10 = 0; i10 < (n10 = ((SsManifest$StreamElement[])(object2 = ((SsManifest)object).streamElements)).length); ++i10) {
            int n12;
            object2 = object2[i10].formats;
            n10 = ((Object[])object2).length;
            Format[] formatArray = new Format[n10];
            for (int i11 = 0; i11 < (n12 = ((Object[])object2).length); ++i11) {
                Object object3 = object2[i11];
                Class clazz = drmSessionManager.getExoMediaCryptoType((Format)object3);
                formatArray[i11] = object3 = ((Format)object3).copyWithExoMediaCryptoType(clazz);
            }
            trackGroupArray[i10] = object2 = new TrackGroup(formatArray);
        }
        object = new TrackGroupArray(trackGroupArray);
        return object;
    }

    private static ChunkSampleStream[] newSampleStreamArray(int n10) {
        return new ChunkSampleStream[n10];
    }

    public boolean continueLoading(long l10) {
        return this.compositeSequenceableLoader.continueLoading(l10);
    }

    public void discardBuffer(long l10, boolean bl2) {
        for (ChunkSampleStream chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.discardBuffer(l10, bl2);
        }
    }

    public long getAdjustedSeekPositionUs(long l10, SeekParameters seekParameters) {
        for (ChunkSampleStream chunkSampleStream : this.sampleStreams) {
            int n10 = chunkSampleStream.primaryTrackType;
            int n11 = 2;
            if (n10 != n11) continue;
            return chunkSampleStream.getAdjustedSeekPositionUs(l10, seekParameters);
        }
        return l10;
    }

    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    public List getStreamKeys(List list) {
        int n10;
        ArrayList<StreamKey> arrayList = new ArrayList<StreamKey>();
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            int n11;
            ExoTrackSelection exoTrackSelection = (ExoTrackSelection)list.get(i10);
            TrackGroupArray trackGroupArray = this.trackGroups;
            TrackGroup trackGroup = exoTrackSelection.getTrackGroup();
            int n12 = trackGroupArray.indexOf(trackGroup);
            trackGroup = null;
            for (int i11 = 0; i11 < (n11 = exoTrackSelection.length()); ++i11) {
                int n13 = exoTrackSelection.getIndexInTrackGroup(i11);
                StreamKey streamKey = new StreamKey(n12, n13);
                arrayList.add(streamKey);
            }
        }
        return arrayList;
    }

    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    public void maybeThrowPrepareError() {
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    public void onContinueLoadingRequested(ChunkSampleStream chunkSampleStream) {
        this.callback.onContinueLoadingRequested(this);
    }

    public void prepare(MediaPeriod$Callback mediaPeriod$Callback, long l10) {
        this.callback = mediaPeriod$Callback;
        mediaPeriod$Callback.onPrepared(this);
    }

    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    public void reevaluateBuffer(long l10) {
        this.compositeSequenceableLoader.reevaluateBuffer(l10);
    }

    public void release() {
        for (ChunkSampleStream chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.release();
        }
        this.callback = null;
    }

    public long seekToUs(long l10) {
        for (ChunkSampleStream chunkSampleStream : this.sampleStreams) {
            chunkSampleStream.seekToUs(l10);
        }
        return l10;
    }

    public long selectTracks(ExoTrackSelection[] object, boolean[] objectArray, SampleStream[] sampleStreamArray, boolean[] blArray, long l10) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i10 = 0; i10 < (n10 = ((ExoTrackSelection[])object).length); ++i10) {
            Object object2 = sampleStreamArray[i10];
            if (object2 != null) {
                boolean bl2;
                object2 = (ChunkSampleStream)sampleStreamArray[i10];
                Object object3 = object[i10];
                if (object3 != null && (bl2 = objectArray[i10])) {
                    object3 = (SsChunkSource)((ChunkSampleStream)object2).getChunkSource();
                    Object object4 = object[i10];
                    object3.updateTrackSelection((ExoTrackSelection)object4);
                    arrayList.add(object2);
                } else {
                    ((ChunkSampleStream)object2).release();
                    n10 = 0;
                    object2 = null;
                    sampleStreamArray[i10] = null;
                }
            }
            if ((object2 = sampleStreamArray[i10]) != null || (object2 = object[i10]) == null) continue;
            object2 = object[i10];
            object2 = this.buildSampleStream((ExoTrackSelection)object2, l10);
            arrayList.add(object2);
            sampleStreamArray[i10] = object2;
            blArray[i10] = n10 = 1;
        }
        object = SsMediaPeriod.newSampleStreamArray(arrayList.size());
        this.sampleStreams = object;
        arrayList.toArray((T[])object);
        object = this.compositeSequenceableLoaderFactory;
        objectArray = this.sampleStreams;
        this.compositeSequenceableLoader = object = object.createCompositeSequenceableLoader((SequenceableLoader[])objectArray);
        return l10;
    }

    public void updateManifest(SsManifest ssManifest) {
        this.manifest = ssManifest;
        ChunkSampleStream[] chunkSampleStreamArray = this.sampleStreams;
        int n10 = chunkSampleStreamArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            SsChunkSource ssChunkSource = (SsChunkSource)chunkSampleStreamArray[i10].getChunkSource();
            ssChunkSource.updateManifest(ssManifest);
        }
        this.callback.onContinueLoadingRequested(this);
    }
}

