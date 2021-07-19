/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.MediaSourceList$MediaSourceHolder;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class MediaSourceList$ForwardingEventListener
implements MediaSourceEventListener,
DrmSessionEventListener {
    private DrmSessionEventListener$EventDispatcher drmEventDispatcher;
    private final MediaSourceList$MediaSourceHolder id;
    private MediaSourceEventListener$EventDispatcher mediaSourceEventDispatcher;
    public final /* synthetic */ MediaSourceList this$0;

    public MediaSourceList$ForwardingEventListener(MediaSourceList object, MediaSourceList$MediaSourceHolder mediaSourceList$MediaSourceHolder) {
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher;
        this.this$0 = object;
        this.mediaSourceEventDispatcher = mediaSourceEventListener$EventDispatcher = MediaSourceList.access$000((MediaSourceList)object);
        this.drmEventDispatcher = object = MediaSourceList.access$100((MediaSourceList)object);
        this.id = mediaSourceList$MediaSourceHolder;
    }

    private boolean maybeUpdateEventDispatcher(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        boolean bl2;
        Object object;
        if (mediaSource$MediaPeriodId != null) {
            object = this.id;
            if ((mediaSource$MediaPeriodId = MediaSourceList.access$200((MediaSourceList$MediaSourceHolder)object, mediaSource$MediaPeriodId)) == null) {
                return false;
            }
        } else {
            mediaSource$MediaPeriodId = null;
        }
        n10 = MediaSourceList.access$300(this.id, n10);
        object = this.mediaSourceEventDispatcher;
        int n11 = ((MediaSourceEventListener$EventDispatcher)object).windowIndex;
        if (n11 != n10 || !(bl2 = Util.areEqual(object = ((MediaSourceEventListener$EventDispatcher)object).mediaPeriodId, mediaSource$MediaPeriodId))) {
            object = MediaSourceList.access$000(this.this$0);
            long l10 = 0L;
            this.mediaSourceEventDispatcher = object = ((MediaSourceEventListener$EventDispatcher)object).withParameters(n10, mediaSource$MediaPeriodId, l10);
        }
        object = this.drmEventDispatcher;
        n11 = ((DrmSessionEventListener$EventDispatcher)object).windowIndex;
        if (n11 != n10 || !(bl2 = Util.areEqual(object = ((DrmSessionEventListener$EventDispatcher)object).mediaPeriodId, mediaSource$MediaPeriodId))) {
            DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher;
            object = MediaSourceList.access$100(this.this$0);
            this.drmEventDispatcher = drmSessionEventListener$EventDispatcher = ((DrmSessionEventListener$EventDispatcher)object).withParameters(n10, mediaSource$MediaPeriodId);
        }
        return true;
    }

    public void onDownstreamFormatChanged(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, MediaLoadData mediaLoadData) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, mediaSource$MediaPeriodId) ? 1 : 0)) != 0) {
            MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.mediaSourceEventDispatcher;
            mediaSourceEventListener$EventDispatcher.downstreamFormatChanged(mediaLoadData);
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

    public void onLoadCanceled(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, mediaSource$MediaPeriodId) ? 1 : 0)) != 0) {
            MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.mediaSourceEventDispatcher;
            mediaSourceEventListener$EventDispatcher.loadCanceled(loadEventInfo, mediaLoadData);
        }
    }

    public void onLoadCompleted(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, mediaSource$MediaPeriodId) ? 1 : 0)) != 0) {
            MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.mediaSourceEventDispatcher;
            mediaSourceEventListener$EventDispatcher.loadCompleted(loadEventInfo, mediaLoadData);
        }
    }

    public void onLoadError(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean bl2) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, mediaSource$MediaPeriodId) ? 1 : 0)) != 0) {
            MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.mediaSourceEventDispatcher;
            mediaSourceEventListener$EventDispatcher.loadError(loadEventInfo, mediaLoadData, iOException, bl2);
        }
    }

    public void onLoadStarted(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, mediaSource$MediaPeriodId) ? 1 : 0)) != 0) {
            MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.mediaSourceEventDispatcher;
            mediaSourceEventListener$EventDispatcher.loadStarted(loadEventInfo, mediaLoadData);
        }
    }

    public void onUpstreamDiscarded(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, MediaLoadData mediaLoadData) {
        if ((n10 = (int)(this.maybeUpdateEventDispatcher(n10, mediaSource$MediaPeriodId) ? 1 : 0)) != 0) {
            MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.mediaSourceEventDispatcher;
            mediaSourceEventListener$EventDispatcher.upstreamDiscarded(mediaLoadData);
        }
    }
}

