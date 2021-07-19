/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$LiveConfiguration;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.HlsExtractorFactory;
import com.google.android.exoplayer2.source.hls.HlsManifest;
import com.google.android.exoplayer2.source.hls.HlsMediaPeriod;
import com.google.android.exoplayer2.source.hls.HlsMediaSource$1;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$SegmentBase;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$ServerControl;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$PrimaryPlaylistListener;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.List;

public final class HlsMediaSource
extends BaseMediaSource
implements HlsPlaylistTracker$PrimaryPlaylistListener {
    public static final int METADATA_TYPE_EMSG = 3;
    public static final int METADATA_TYPE_ID3 = 1;
    private final boolean allowChunklessPreparation;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final HlsDataSourceFactory dataSourceFactory;
    private final DrmSessionManager drmSessionManager;
    private final long elapsedRealTimeOffsetMs;
    private final HlsExtractorFactory extractorFactory;
    private MediaItem$LiveConfiguration liveConfiguration;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final MediaItem mediaItem;
    private TransferListener mediaTransferListener;
    private final int metadataType;
    private final MediaItem$PlaybackProperties playbackProperties;
    private final HlsPlaylistTracker playlistTracker;
    private final boolean useSessionKeys;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.hls");
    }

    private HlsMediaSource(MediaItem object, HlsDataSourceFactory hlsDataSourceFactory, HlsExtractorFactory hlsExtractorFactory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistTracker hlsPlaylistTracker, long l10, boolean bl2, int n10, boolean bl3) {
        MediaItem$PlaybackProperties mediaItem$PlaybackProperties;
        this.playbackProperties = mediaItem$PlaybackProperties = (MediaItem$PlaybackProperties)Assertions.checkNotNull(((MediaItem)object).playbackProperties);
        this.mediaItem = object;
        this.liveConfiguration = object = ((MediaItem)object).liveConfiguration;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.extractorFactory = hlsExtractorFactory;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.drmSessionManager = drmSessionManager;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.playlistTracker = hlsPlaylistTracker;
        this.elapsedRealTimeOffsetMs = l10;
        this.allowChunklessPreparation = bl2;
        this.metadataType = n10;
        this.useSessionKeys = bl3;
    }

    public /* synthetic */ HlsMediaSource(MediaItem mediaItem, HlsDataSourceFactory hlsDataSourceFactory, HlsExtractorFactory hlsExtractorFactory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistTracker hlsPlaylistTracker, long l10, boolean bl2, int n10, boolean bl3, HlsMediaSource$1 hlsMediaSource$1) {
        this(mediaItem, hlsDataSourceFactory, hlsExtractorFactory, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, hlsPlaylistTracker, l10, bl2, n10, bl3);
    }

    private long getLiveEdgeOffsetUs(HlsMediaPlaylist hlsMediaPlaylist) {
        long l10;
        boolean bl2 = hlsMediaPlaylist.hasProgramDateTime;
        if (bl2) {
            l10 = C.msToUs(Util.getNowUnixTimeMs(this.elapsedRealTimeOffsetMs));
            long l11 = hlsMediaPlaylist.getEndTimeUs();
            l10 -= l11;
        } else {
            l10 = 0L;
        }
        return l10;
    }

    private static long getTargetLiveOffsetUs(HlsMediaPlaylist hlsMediaPlaylist, long l10) {
        long l11;
        long l12;
        long l13;
        long l14;
        HlsMediaPlaylist$ServerControl hlsMediaPlaylist$ServerControl = hlsMediaPlaylist.serverControl;
        long l15 = hlsMediaPlaylist$ServerControl.partHoldBackUs;
        long l16 = -9223372036854775807L;
        long l17 = l15 - l16;
        Object object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if ((object == false || (object = (l14 = (l13 = hlsMediaPlaylist.partTargetDurationUs) - l16) == 0L ? 0 : (l14 < 0L ? -1 : 1)) == false) && (l12 = (l11 = (l15 = hlsMediaPlaylist$ServerControl.holdBackUs) - l16) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false) {
            long l18 = 3;
            long l19 = hlsMediaPlaylist.targetDurationUs;
            l15 = l19 * l18;
        }
        return l15 + l10;
    }

    private long getWindowDefaultStartPosition(HlsMediaPlaylist object, long l10) {
        int n10;
        List list = ((HlsMediaPlaylist)object).segments;
        long l11 = ((HlsMediaPlaylist)object).durationUs + l10;
        object = this.liveConfiguration;
        long l12 = C.msToUs(((MediaItem$LiveConfiguration)object).targetOffsetMs);
        l11 -= l12;
        for (n10 = list.size() + -1; n10 > 0; n10 += -1) {
            object = (HlsMediaPlaylist$Segment)list.get(n10);
            l12 = ((HlsMediaPlaylist$SegmentBase)object).relativeStartTimeUs;
            long l13 = l12 - l11;
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 <= 0) break;
        }
        return ((HlsMediaPlaylist$Segment)list.get((int)n10)).relativeStartTimeUs;
    }

    private void maybeUpdateMediaItem(long l10) {
        l10 = C.usToMs(l10);
        Object object = this.liveConfiguration;
        long l11 = ((MediaItem$LiveConfiguration)object).targetOffsetMs;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            MediaItem$LiveConfiguration mediaItem$LiveConfiguration;
            object = this.mediaItem.buildUpon();
            this.liveConfiguration = mediaItem$LiveConfiguration = object.setLiveTargetOffsetMs((long)l10).build().liveConfiguration;
        }
    }

    public MediaPeriod createPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Allocator allocator, long l10) {
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.createEventDispatcher(mediaSource$MediaPeriodId);
        DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.createDrmEventDispatcher(mediaSource$MediaPeriodId);
        HlsExtractorFactory hlsExtractorFactory = this.extractorFactory;
        HlsPlaylistTracker hlsPlaylistTracker = this.playlistTracker;
        HlsDataSourceFactory hlsDataSourceFactory = this.dataSourceFactory;
        TransferListener transferListener = this.mediaTransferListener;
        DrmSessionManager drmSessionManager = this.drmSessionManager;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
        CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = this.compositeSequenceableLoaderFactory;
        boolean bl2 = this.allowChunklessPreparation;
        int n10 = this.metadataType;
        boolean bl3 = this.useSessionKeys;
        HlsMediaPeriod hlsMediaPeriod = new HlsMediaPeriod(hlsExtractorFactory, hlsPlaylistTracker, hlsDataSourceFactory, transferListener, drmSessionManager, drmSessionEventListener$EventDispatcher, loadErrorHandlingPolicy, mediaSourceEventListener$EventDispatcher, allocator, compositeSequenceableLoaderFactory, bl2, n10, bl3);
        return hlsMediaPeriod;
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    public Object getTag() {
        return this.playbackProperties.tag;
    }

    public void maybeThrowSourceInfoRefreshError() {
        this.playlistTracker.maybeThrowPrimaryPlaylistRefreshError();
    }

    public void onPrimaryPlaylistRefreshed(HlsMediaPlaylist hlsMediaPlaylist) {
        SinglePeriodTimeline singlePeriodTimeline;
        long l10;
        HlsMediaSource hlsMediaSource = this;
        Object object = hlsMediaPlaylist;
        int n10 = hlsMediaPlaylist.hasProgramDateTime;
        long l11 = -9223372036854775807L;
        long l12 = n10 != 0 ? (l10 = C.usToMs(hlsMediaPlaylist.startTimeUs)) : l11;
        n10 = ((HlsMediaPlaylist)object).playlistType;
        int n11 = 2;
        int n12 = 1;
        long l13 = n10 != n11 && n10 != n12 ? l11 : l12;
        long l14 = ((HlsMediaPlaylist)object).startOffsetUs;
        Object object2 = (HlsMasterPlaylist)Assertions.checkNotNull(hlsMediaSource.playlistTracker.getMasterPlaylist());
        HlsManifest hlsManifest = new HlsManifest((HlsMasterPlaylist)object2, (HlsMediaPlaylist)object);
        object2 = hlsMediaSource.playlistTracker;
        n11 = (int)(object2.isLive() ? 1 : 0);
        if (n11 != 0) {
            long l15;
            long l16 = this.getLiveEdgeOffsetUs(hlsMediaPlaylist);
            object2 = hlsMediaSource.liveConfiguration;
            long l17 = ((MediaItem$LiveConfiguration)object2).targetOffsetMs;
            long l18 = l17 - l11;
            n11 = (int)(l18 == 0L ? 0 : (l18 < 0L ? -1 : 1));
            l10 = n11 != 0 ? C.msToUs(l17) : HlsMediaSource.getTargetLiveOffsetUs((HlsMediaPlaylist)object, l16);
            long l19 = l10;
            long l20 = ((HlsMediaPlaylist)object).durationUs + l16;
            long l21 = l16;
            l10 = Util.constrainValue(l19, l16, l20);
            hlsMediaSource.maybeUpdateMediaItem(l10);
            l10 = ((HlsMediaPlaylist)object).startTimeUs;
            Object object3 = hlsMediaSource.playlistTracker;
            l19 = object3.getInitialStartTimeUs();
            l21 = l10 - l19;
            n11 = (int)(((HlsMediaPlaylist)object).hasEndTag ? 1 : 0);
            if (n11 != 0) {
                l10 = ((HlsMediaPlaylist)object).durationUs;
                l10 = l21 + l10;
            } else {
                l10 = l11;
            }
            object3 = ((HlsMediaPlaylist)object).segments;
            boolean bl2 = object3.isEmpty();
            l20 = !bl2 ? (l11 = hlsMediaSource.getWindowDefaultStartPosition((HlsMediaPlaylist)object, l16)) : ((l15 = l14 == l11 ? 0 : (l14 < l11 ? -1 : 1)) == false ? 0L : l14);
            l14 = -9223372036854775807L;
            l16 = ((HlsMediaPlaylist)object).durationUs;
            boolean bl3 = true;
            boolean bl4 = ((HlsMediaPlaylist)object).hasEndTag;
            boolean bl5 = bl4 ^ true;
            MediaItem mediaItem = hlsMediaSource.mediaItem;
            object = hlsMediaSource.liveConfiguration;
            object3 = singlePeriodTimeline;
            l19 = l16;
            l16 = l10;
            singlePeriodTimeline = new SinglePeriodTimeline(l13, l12, l14, l10, l19, l21, l20, bl3, bl5, hlsManifest, mediaItem, (MediaItem$LiveConfiguration)object);
        } else {
            long l22;
            Object object4 = l14 == l11 ? 0 : (l14 < l11 ? -1 : 1);
            long l23 = object4 == false ? 0L : l14;
            SinglePeriodTimeline singlePeriodTimeline2 = singlePeriodTimeline;
            l14 = -9223372036854775807L;
            long l24 = l22 = ((HlsMediaPlaylist)object).durationUs;
            long l25 = 0L;
            boolean bl6 = true;
            boolean bl7 = false;
            Object object5 = object = hlsMediaSource.mediaItem;
            singlePeriodTimeline = new SinglePeriodTimeline(l13, l12, l14, l22, l22, l25, l23, bl6, false, hlsManifest, (MediaItem)object, null);
        }
        hlsMediaSource.refreshSourceInfo(singlePeriodTimeline);
    }

    public void prepareSourceInternal(TransferListener object) {
        this.mediaTransferListener = object;
        this.drmSessionManager.prepare();
        object = this.createEventDispatcher(null);
        HlsPlaylistTracker hlsPlaylistTracker = this.playlistTracker;
        Uri uri = this.playbackProperties.uri;
        hlsPlaylistTracker.start(uri, (MediaSourceEventListener$EventDispatcher)object, this);
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((HlsMediaPeriod)mediaPeriod).release();
    }

    public void releaseSourceInternal() {
        this.playlistTracker.stop();
        this.drmSessionManager.release();
    }
}

