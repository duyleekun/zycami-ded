/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class CompositeMediaSource$ForwardingEventListener
implements MediaSourceEventListener,
DrmSessionEventListener {
    private DrmSessionEventListener$EventDispatcher drmEventDispatcher;
    private final Object id;
    private MediaSourceEventListener$EventDispatcher mediaSourceEventDispatcher;
    public final /* synthetic */ CompositeMediaSource this$0;

    public CompositeMediaSource$ForwardingEventListener(CompositeMediaSource object, Object object2) {
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher;
        this.this$0 = object;
        this.mediaSourceEventDispatcher = mediaSourceEventListener$EventDispatcher = ((BaseMediaSource)object).createEventDispatcher(null);
        this.drmEventDispatcher = object = ((BaseMediaSource)object).createDrmEventDispatcher(null);
        this.id = object2;
    }

    private boolean maybeUpdateEventDispatcher(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        boolean bl2;
        Object object;
        Object object2;
        if (mediaSource$MediaPeriodId != null) {
            object2 = this.this$0;
            object = this.id;
            if ((mediaSource$MediaPeriodId = ((CompositeMediaSource)object2).getMediaPeriodIdForChildMediaPeriodId(object, mediaSource$MediaPeriodId)) == null) {
                return false;
            }
        } else {
            mediaSource$MediaPeriodId = null;
        }
        object2 = this.this$0;
        object = this.id;
        n10 = ((CompositeMediaSource)object2).getWindowIndexForChildWindowIndex(object, n10);
        object2 = this.mediaSourceEventDispatcher;
        int n11 = ((MediaSourceEventListener$EventDispatcher)object2).windowIndex;
        if (n11 != n10 || !(bl2 = Util.areEqual(object2 = ((MediaSourceEventListener$EventDispatcher)object2).mediaPeriodId, mediaSource$MediaPeriodId))) {
            object2 = this.this$0;
            long l10 = 0L;
            this.mediaSourceEventDispatcher = object2 = ((BaseMediaSource)object2).createEventDispatcher(n10, mediaSource$MediaPeriodId, l10);
        }
        object2 = this.drmEventDispatcher;
        n11 = ((DrmSessionEventListener$EventDispatcher)object2).windowIndex;
        if (n11 != n10 || !(bl2 = Util.areEqual(object2 = ((DrmSessionEventListener$EventDispatcher)object2).mediaPeriodId, mediaSource$MediaPeriodId))) {
            DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher;
            object2 = this.this$0;
            this.drmEventDispatcher = drmSessionEventListener$EventDispatcher = ((BaseMediaSource)object2).createDrmEventDispatcher(n10, mediaSource$MediaPeriodId);
        }
        return true;
    }

    private MediaLoadData maybeUpdateMediaLoadData(MediaLoadData mediaLoadData) {
        long l10;
        Object object = this.this$0;
        Object object2 = this.id;
        long l11 = mediaLoadData.mediaStartTimeMs;
        long l12 = ((CompositeMediaSource)object).getMediaTimeForChildMediaTime(object2, l11);
        object = this.this$0;
        object2 = this.id;
        l11 = mediaLoadData.mediaEndTimeMs;
        long l13 = ((CompositeMediaSource)object).getMediaTimeForChildMediaTime(object2, l11);
        long l14 = mediaLoadData.mediaStartTimeMs;
        long l15 = l12 - l14;
        Object object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object3 == false && (object3 = (l10 = l13 - (l14 = mediaLoadData.mediaEndTimeMs)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) {
            return mediaLoadData;
        }
        int n10 = mediaLoadData.dataType;
        int n11 = mediaLoadData.trackType;
        Format format = mediaLoadData.trackFormat;
        int n12 = mediaLoadData.trackSelectionReason;
        Object object4 = mediaLoadData.trackSelectionData;
        object = new MediaLoadData(n10, n11, format, n12, object4, l12, l13);
        return object;
    }

    public void onDownstreamFormatChanged(int n10, MediaSource$MediaPeriodId object, MediaLoadData mediaLoadData) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, (MediaSource$MediaPeriodId)object) ? 1 : 0)) != 0) {
            MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.mediaSourceEventDispatcher;
            object = this.maybeUpdateMediaLoadData(mediaLoadData);
            mediaSourceEventListener$EventDispatcher.downstreamFormatChanged((MediaLoadData)object);
        }
    }

    public void onDrmKeysLoaded(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, mediaSource$MediaPeriodId) ? 1 : 0)) != 0) {
            DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.drmEventDispatcher;
            drmSessionEventListener$EventDispatcher.drmKeysLoaded();
        }
    }

    public void onDrmKeysRemoved(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, mediaSource$MediaPeriodId) ? 1 : 0)) != 0) {
            DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.drmEventDispatcher;
            drmSessionEventListener$EventDispatcher.drmKeysRemoved();
        }
    }

    public void onDrmKeysRestored(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, mediaSource$MediaPeriodId) ? 1 : 0)) != 0) {
            DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.drmEventDispatcher;
            drmSessionEventListener$EventDispatcher.drmKeysRestored();
        }
    }

    public void onDrmSessionAcquired(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, mediaSource$MediaPeriodId) ? 1 : 0)) != 0) {
            DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.drmEventDispatcher;
            drmSessionEventListener$EventDispatcher.drmSessionAcquired();
        }
    }

    public void onDrmSessionManagerError(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Exception exception) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, mediaSource$MediaPeriodId) ? 1 : 0)) != 0) {
            DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.drmEventDispatcher;
            drmSessionEventListener$EventDispatcher.drmSessionManagerError(exception);
        }
    }

    public void onDrmSessionReleased(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, mediaSource$MediaPeriodId) ? 1 : 0)) != 0) {
            DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.drmEventDispatcher;
            drmSessionEventListener$EventDispatcher.drmSessionReleased();
        }
    }

    public void onLoadCanceled(int n10, MediaSource$MediaPeriodId object, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, (MediaSource$MediaPeriodId)object) ? 1 : 0)) != 0) {
            MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.mediaSourceEventDispatcher;
            object = this.maybeUpdateMediaLoadData(mediaLoadData);
            mediaSourceEventListener$EventDispatcher.loadCanceled(loadEventInfo, (MediaLoadData)object);
        }
    }

    public void onLoadCompleted(int n10, MediaSource$MediaPeriodId object, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, (MediaSource$MediaPeriodId)object) ? 1 : 0)) != 0) {
            MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.mediaSourceEventDispatcher;
            object = this.maybeUpdateMediaLoadData(mediaLoadData);
            mediaSourceEventListener$EventDispatcher.loadCompleted(loadEventInfo, (MediaLoadData)object);
        }
    }

    public void onLoadError(int n10, MediaSource$MediaPeriodId object, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean bl2) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, (MediaSource$MediaPeriodId)object) ? 1 : 0)) != 0) {
            MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.mediaSourceEventDispatcher;
            object = this.maybeUpdateMediaLoadData(mediaLoadData);
            mediaSourceEventListener$EventDispatcher.loadError(loadEventInfo, (MediaLoadData)object, iOException, bl2);
        }
    }

    public void onLoadStarted(int n10, MediaSource$MediaPeriodId object, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, (MediaSource$MediaPeriodId)object) ? 1 : 0)) != 0) {
            MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.mediaSourceEventDispatcher;
            object = this.maybeUpdateMediaLoadData(mediaLoadData);
            mediaSourceEventListener$EventDispatcher.loadStarted(loadEventInfo, (MediaLoadData)object);
        }
    }

    public void onUpstreamDiscarded(int n10, MediaSource$MediaPeriodId object, MediaLoadData mediaLoadData) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, (MediaSource$MediaPeriodId)object) ? 1 : 0)) != 0) {
            MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.mediaSourceEventDispatcher;
            object = this.maybeUpdateMediaLoadData(mediaLoadData);
            mediaSourceEventListener$EventDispatcher.upstreamDiscarded((MediaLoadData)object);
        }
    }
}

