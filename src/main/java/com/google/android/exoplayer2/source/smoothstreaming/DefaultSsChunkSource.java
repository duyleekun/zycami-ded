/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource$StreamElementIterator;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest$ProtectionElement;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest$StreamElement;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.List;

public class DefaultSsChunkSource
implements SsChunkSource {
    private final ChunkExtractor[] chunkExtractors;
    private int currentManifestChunkOffset;
    private final DataSource dataSource;
    private IOException fatalError;
    private SsManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final int streamElementIndex;
    private ExoTrackSelection trackSelection;

    public DefaultSsChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int n10, ExoTrackSelection exoTrackSelection, DataSource dataSource) {
        Object object;
        int n11;
        DefaultSsChunkSource defaultSsChunkSource = this;
        SsManifest ssManifest2 = ssManifest;
        ExoTrackSelection exoTrackSelection2 = exoTrackSelection;
        Object object2 = loaderErrorThrower;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = ssManifest;
        this.streamElementIndex = n10;
        this.trackSelection = exoTrackSelection;
        object2 = dataSource;
        this.dataSource = dataSource;
        SsManifest$StreamElement ssManifest$StreamElement = ssManifest.streamElements[n10];
        int n12 = exoTrackSelection.length();
        object2 = new ChunkExtractor[n12];
        this.chunkExtractors = object2;
        int n13 = 0;
        ChunkExtractor[] chunkExtractorArray = null;
        while (n13 < (n11 = ((ChunkExtractor[])(object = defaultSsChunkSource.chunkExtractors)).length)) {
            Track track;
            int n14 = exoTrackSelection2.getIndexInTrackGroup(n13);
            object = ssManifest$StreamElement.formats[n14];
            Object object3 = object.drmInitData;
            Object object4 = object3 != null ? (object3 = ((SsManifest$ProtectionElement)Assertions.checkNotNull((Object)ssManifest2.protectionElement)).trackEncryptionBoxes) : null;
            int n15 = ssManifest$StreamElement.type;
            int n16 = 2;
            int n17 = n15 == n16 ? (n16 = 4) : 0;
            long l10 = ssManifest$StreamElement.timescale;
            long l11 = -9223372036854775807L;
            n10 = n13++;
            long l12 = ssManifest2.durationUs;
            object3 = track;
            track = new Track(n14, n15, l10, l11, l12, (Format)object, 0, (TrackEncryptionBox[])object4, n17, null, null);
            super(3, null, track);
            chunkExtractorArray = defaultSsChunkSource.chunkExtractors;
            n14 = ssManifest$StreamElement.type;
            super((Extractor)object2, n14, (Format)object);
            chunkExtractorArray[n13] = object3;
        }
    }

    private static MediaChunk newMediaChunk(Format format, DataSource dataSource, Uri uri, int n10, long l10, long l11, long l12, int n11, Object object, ChunkExtractor chunkExtractor) {
        ContainerMediaChunk containerMediaChunk;
        Object object2;
        DataSpec dataSpec = object2;
        object2 = new DataSpec(uri);
        object2 = containerMediaChunk;
        long l13 = n10;
        containerMediaChunk = new ContainerMediaChunk(dataSource, dataSpec, format, n11, object, l10, l11, l12, -9223372036854775807L, l13, 1, l10, chunkExtractor);
        return containerMediaChunk;
    }

    private long resolveTimeToLiveEdgeUs(long l10) {
        Object object = this.manifest;
        int n10 = ((SsManifest)object).isLive;
        if (n10 == 0) {
            return -9223372036854775807L;
        }
        object = ((SsManifest)object).streamElements;
        n10 = this.streamElementIndex;
        object = object[n10];
        n10 = ((SsManifest$StreamElement)object).chunkCount + -1;
        long l11 = ((SsManifest$StreamElement)object).getStartTimeUs(n10);
        long l12 = ((SsManifest$StreamElement)object).getChunkDurationUs(n10);
        return l11 + l12 - l10;
    }

    public long getAdjustedSeekPositionUs(long l10, SeekParameters seekParameters) {
        long l11;
        Object object = this.manifest.streamElements;
        int n10 = this.streamElementIndex;
        long l12 = ((SsManifest$StreamElement)(object = object[n10])).getStartTimeUs(n10 = ((SsManifest$StreamElement)object).getChunkIndex(l10));
        long l13 = l12 - l10;
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        long l14 = object2 < 0 && n10 < (object2 = (Object)(((SsManifest$StreamElement)object).chunkCount + -1)) ? (l11 = ((SsManifest$StreamElement)object).getStartTimeUs(++n10)) : l12;
        return seekParameters.resolveSeekPositionUs(l10, l12, l14);
    }

    public final void getNextChunk(long l10, long l11, List list, ChunkHolder chunkHolder) {
        Object object;
        long l12;
        Object object2;
        DefaultSsChunkSource defaultSsChunkSource = this;
        long l13 = l11;
        ChunkHolder chunkHolder2 = chunkHolder;
        Object object3 = this.fatalError;
        if (object3 != null) {
            return;
        }
        object3 = this.manifest;
        Object object4 = ((SsManifest)object3).streamElements;
        int n10 = this.streamElementIndex;
        object4 = object4[n10];
        n10 = ((SsManifest$StreamElement)object4).chunkCount;
        if (n10 == 0) {
            boolean bl2;
            chunkHolder.endOfStream = bl2 = ((SsManifest)object3).isLive ^ true;
            return;
        }
        int n11 = list.isEmpty();
        if (n11 != 0) {
            n11 = ((SsManifest$StreamElement)object4).getChunkIndex(l11);
            object2 = list;
        } else {
            n11 = list.size() + -1;
            object2 = list;
            object3 = (MediaChunk)list.get(n11);
            l12 = ((MediaChunk)object3).getNextChunkIndex();
            long l14 = this.currentManifestChunkOffset;
            n11 = (int)(l12 -= l14);
            if (n11 < 0) {
                BehindLiveWindowException behindLiveWindowException = new BehindLiveWindowException();
                this.fatalError = behindLiveWindowException;
                return;
            }
        }
        n10 = ((SsManifest$StreamElement)object4).chunkCount;
        if (n11 >= n10) {
            boolean bl3;
            chunkHolder2.endOfStream = bl3 = defaultSsChunkSource.manifest.isLive ^ true;
            return;
        }
        long l15 = l13 - l10;
        long l16 = this.resolveTimeToLiveEdgeUs(l10);
        ExoTrackSelection exoTrackSelection = defaultSsChunkSource.trackSelection;
        n10 = exoTrackSelection.length();
        MediaChunkIterator[] mediaChunkIteratorArray = new MediaChunkIterator[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            ExoTrackSelection exoTrackSelection2 = defaultSsChunkSource.trackSelection;
            int n12 = exoTrackSelection2.getIndexInTrackGroup(i10);
            mediaChunkIteratorArray[i10] = object = new DefaultSsChunkSource$StreamElementIterator((SsManifest$StreamElement)object4, n12, n11);
        }
        exoTrackSelection = defaultSsChunkSource.trackSelection;
        object = list;
        exoTrackSelection.updateSelectedTrack(l10, l15, l16, list, mediaChunkIteratorArray);
        long l17 = ((SsManifest$StreamElement)object4).getStartTimeUs(n11);
        l12 = ((SsManifest$StreamElement)object4).getChunkDurationUs(n11);
        long l18 = l17 + l12;
        n10 = (int)(list.isEmpty() ? 1 : 0);
        if (n10 == 0) {
            l13 = -9223372036854775807L;
        }
        int n13 = defaultSsChunkSource.currentManifestChunkOffset;
        int n14 = n11 + n13;
        n13 = defaultSsChunkSource.trackSelection.getSelectedIndex();
        ChunkExtractor chunkExtractor = defaultSsChunkSource.chunkExtractors[n13];
        n13 = defaultSsChunkSource.trackSelection.getIndexInTrackGroup(n13);
        Uri uri = ((SsManifest$StreamElement)object4).buildRequestUri(n13, n11);
        object2 = defaultSsChunkSource.trackSelection.getSelectedFormat();
        Object object5 = defaultSsChunkSource.dataSource;
        int n15 = defaultSsChunkSource.trackSelection.getSelectionReason();
        Object object6 = defaultSsChunkSource.trackSelection.getSelectionData();
        chunkHolder2.chunk = object5 = DefaultSsChunkSource.newMediaChunk((Format)object2, (DataSource)object5, uri, n14, l17, l18, l13, n15, object6, chunkExtractor);
    }

    public int getPreferredQueueSize(long l10, List list) {
        int n10;
        int n11;
        Object object = this.fatalError;
        if (object == null && (n11 = (object = this.trackSelection).length()) >= (n10 = 2)) {
            return this.trackSelection.evaluateQueueSize(l10, list);
        }
        return list.size();
    }

    public void maybeThrowError() {
        IOException iOException = this.fatalError;
        if (iOException == null) {
            this.manifestLoaderErrorThrower.maybeThrowError();
            return;
        }
        throw iOException;
    }

    public void onChunkLoadCompleted(Chunk chunk) {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean onChunkLoadError(Chunk object, boolean object2, Exception exception, long l10) {
        if (!object2) return 0 != 0;
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (!object2) return 0 != 0;
        ExoTrackSelection exoTrackSelection = this.trackSelection;
        object = ((Chunk)object).trackFormat;
        int n10 = exoTrackSelection.indexOf((Format)object);
        if ((n10 = (int)(exoTrackSelection.blacklist(n10, l10) ? 1 : 0)) == 0) return 0 != 0;
        return 1 != 0;
    }

    public void release() {
        for (ChunkExtractor chunkExtractor : this.chunkExtractors) {
            chunkExtractor.release();
        }
    }

    public boolean shouldCancelLoad(long l10, Chunk chunk, List list) {
        IOException iOException = this.fatalError;
        if (iOException != null) {
            return false;
        }
        return this.trackSelection.shouldCancelChunkLoad(l10, chunk, list);
    }

    public void updateManifest(SsManifest ssManifest) {
        int n10;
        Object object = this.manifest.streamElements;
        int n11 = this.streamElementIndex;
        object = object[n11];
        int n12 = ((SsManifest$StreamElement)object).chunkCount;
        SsManifest$StreamElement[] ssManifest$StreamElementArray = ssManifest.streamElements;
        SsManifest$StreamElement ssManifest$StreamElement = ssManifest$StreamElementArray[n11];
        if (n12 != 0 && (n10 = ssManifest$StreamElement.chunkCount) != 0) {
            n10 = n12 + -1;
            long l10 = ((SsManifest$StreamElement)object).getStartTimeUs(n10);
            long l11 = ((SsManifest$StreamElement)object).getChunkDurationUs(n10);
            l10 += l11;
            n10 = 0;
            ssManifest$StreamElementArray = null;
            l11 = ssManifest$StreamElement.getStartTimeUs(0);
            long l12 = l10 - l11;
            n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n11 <= 0) {
                int n13;
                this.currentManifestChunkOffset = n13 = this.currentManifestChunkOffset + n12;
            } else {
                n11 = this.currentManifestChunkOffset;
                int n14 = ((SsManifest$StreamElement)object).getChunkIndex(l11);
                this.currentManifestChunkOffset = n11 += n14;
            }
        } else {
            int n15;
            this.currentManifestChunkOffset = n15 = this.currentManifestChunkOffset + n12;
        }
        this.manifest = ssManifest;
    }

    public void updateTrackSelection(ExoTrackSelection exoTrackSelection) {
        this.trackSelection = exoTrackSelection;
    }
}

