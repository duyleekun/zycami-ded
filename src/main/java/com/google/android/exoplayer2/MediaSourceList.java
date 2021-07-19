/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.exoplayer2;

import android.os.Handler;
import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.MediaSourceList$ForwardingEventListener;
import com.google.android.exoplayer2.MediaSourceList$MediaSourceAndListener;
import com.google.android.exoplayer2.MediaSourceList$MediaSourceHolder;
import com.google.android.exoplayer2.MediaSourceList$MediaSourceListInfoRefreshListener;
import com.google.android.exoplayer2.PlaylistTimeline;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MaskingMediaSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource$MediaSourceCaller;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.ShuffleOrder$DefaultShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.a0;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class MediaSourceList {
    private static final String TAG = "MediaSourceList";
    private final HashMap childSources;
    private final DrmSessionEventListener$EventDispatcher drmEventDispatcher;
    private final Set enabledMediaSourceHolders;
    private boolean isPrepared;
    private final IdentityHashMap mediaSourceByMediaPeriod;
    private final Map mediaSourceByUid;
    private final MediaSourceEventListener$EventDispatcher mediaSourceEventDispatcher;
    private final List mediaSourceHolders;
    private final MediaSourceList$MediaSourceListInfoRefreshListener mediaSourceListInfoListener;
    private TransferListener mediaTransferListener;
    private ShuffleOrder shuffleOrder;

    public MediaSourceList(MediaSourceList$MediaSourceListInfoRefreshListener object, AnalyticsCollector analyticsCollector, Handler handler) {
        Cloneable cloneable;
        DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher;
        this.mediaSourceListInfoListener = object;
        this.shuffleOrder = object = new ShuffleOrder$DefaultShuffleOrder(0);
        object = new IdentityHashMap();
        this.mediaSourceByMediaPeriod = object;
        this.mediaSourceByUid = object;
        super();
        this.mediaSourceHolders = object;
        this.mediaSourceEventDispatcher = object = new MediaSourceEventListener$EventDispatcher();
        this.drmEventDispatcher = drmSessionEventListener$EventDispatcher = new DrmSessionEventListener$EventDispatcher();
        this.childSources = cloneable = new Cloneable();
        super();
        this.enabledMediaSourceHolders = cloneable;
        if (analyticsCollector != null) {
            ((MediaSourceEventListener$EventDispatcher)object).addEventListener(handler, analyticsCollector);
            drmSessionEventListener$EventDispatcher.addEventListener(handler, analyticsCollector);
        }
    }

    private /* synthetic */ void a(MediaSource mediaSource, Timeline timeline) {
        this.mediaSourceListInfoListener.onPlaylistUpdateRequested();
    }

    public static /* synthetic */ MediaSourceEventListener$EventDispatcher access$000(MediaSourceList mediaSourceList) {
        return mediaSourceList.mediaSourceEventDispatcher;
    }

    public static /* synthetic */ DrmSessionEventListener$EventDispatcher access$100(MediaSourceList mediaSourceList) {
        return mediaSourceList.drmEventDispatcher;
    }

    public static /* synthetic */ MediaSource$MediaPeriodId access$200(MediaSourceList$MediaSourceHolder mediaSourceHolder, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        return MediaSourceList.getMediaPeriodIdForChildMediaPeriodId(mediaSourceHolder, mediaSource$MediaPeriodId);
    }

    public static /* synthetic */ int access$300(MediaSourceList$MediaSourceHolder mediaSourceHolder, int n10) {
        return MediaSourceList.getWindowIndexForChildWindowIndex(mediaSourceHolder, n10);
    }

    private void correctOffsets(int n10, int n11) {
        Object object;
        int n12;
        while (n10 < (n12 = (object = this.mediaSourceHolders).size())) {
            int n13;
            object = (MediaSourceList$MediaSourceHolder)this.mediaSourceHolders.get(n10);
            ((MediaSourceList$MediaSourceHolder)object).firstWindowIndexInChild = n13 = ((MediaSourceList$MediaSourceHolder)object).firstWindowIndexInChild + n11;
            ++n10;
        }
    }

    private void disableChildSource(MediaSourceList$MediaSourceHolder object) {
        Object object2 = this.childSources;
        if ((object = (MediaSourceList$MediaSourceAndListener)((HashMap)object2).get(object)) != null) {
            object2 = ((MediaSourceList$MediaSourceAndListener)object).mediaSource;
            object = ((MediaSourceList$MediaSourceAndListener)object).caller;
            object2.disable((MediaSource$MediaSourceCaller)object);
        }
    }

    private void disableUnusedMediaSources() {
        boolean bl2;
        Iterator iterator2 = this.enabledMediaSourceHolders.iterator();
        while (bl2 = iterator2.hasNext()) {
            MediaSourceList$MediaSourceHolder mediaSourceList$MediaSourceHolder = (MediaSourceList$MediaSourceHolder)iterator2.next();
            List list = mediaSourceList$MediaSourceHolder.activeMediaPeriodIds;
            boolean bl3 = list.isEmpty();
            if (!bl3) continue;
            this.disableChildSource(mediaSourceList$MediaSourceHolder);
            iterator2.remove();
        }
    }

    private void enableMediaSource(MediaSourceList$MediaSourceHolder object) {
        this.enabledMediaSourceHolders.add(object);
        Object object2 = this.childSources;
        object = (MediaSourceList$MediaSourceAndListener)((HashMap)object2).get(object);
        if (object != null) {
            object2 = ((MediaSourceList$MediaSourceAndListener)object).mediaSource;
            object = ((MediaSourceList$MediaSourceAndListener)object).caller;
            object2.enable((MediaSource$MediaSourceCaller)object);
        }
    }

    private static Object getChildPeriodUid(Object object) {
        return AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(object);
    }

    private static MediaSource$MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSourceList$MediaSourceHolder object, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        Object object2;
        int n10;
        Object object3 = null;
        for (int i10 = 0; i10 < (n10 = (object2 = ((MediaSourceList$MediaSourceHolder)object).activeMediaPeriodIds).size()); ++i10) {
            object2 = (MediaSource$MediaPeriodId)((MediaSourceList$MediaSourceHolder)object).activeMediaPeriodIds.get(i10);
            long l10 = ((MediaPeriodId)object2).windowSequenceNumber;
            long l11 = mediaSource$MediaPeriodId.windowSequenceNumber;
            long l12 = l10 - l11;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 != 0) continue;
            object3 = mediaSource$MediaPeriodId.periodUid;
            object = MediaSourceList.getPeriodUid((MediaSourceList$MediaSourceHolder)object, object3);
            return mediaSource$MediaPeriodId.copyWithPeriodUid(object);
        }
        return null;
    }

    private static Object getMediaSourceHolderUid(Object object) {
        return AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(object);
    }

    private static Object getPeriodUid(MediaSourceList$MediaSourceHolder mediaSourceList$MediaSourceHolder, Object object) {
        return AbstractConcatenatedTimeline.getConcatenatedUid(mediaSourceList$MediaSourceHolder.uid, object);
    }

    private static int getWindowIndexForChildWindowIndex(MediaSourceList$MediaSourceHolder mediaSourceList$MediaSourceHolder, int n10) {
        int n11 = mediaSourceList$MediaSourceHolder.firstWindowIndexInChild;
        return n10 + n11;
    }

    private void maybeReleaseChildSource(MediaSourceList$MediaSourceHolder mediaSourceList$MediaSourceHolder) {
        Object object;
        boolean bl2 = mediaSourceList$MediaSourceHolder.isRemoved;
        if (bl2 && (bl2 = (object = mediaSourceList$MediaSourceHolder.activeMediaPeriodIds).isEmpty())) {
            object = (MediaSourceList$MediaSourceAndListener)Assertions.checkNotNull((MediaSourceList$MediaSourceAndListener)this.childSources.remove(mediaSourceList$MediaSourceHolder));
            MediaSource mediaSource = ((MediaSourceList$MediaSourceAndListener)object).mediaSource;
            MediaSource$MediaSourceCaller mediaSource$MediaSourceCaller = ((MediaSourceList$MediaSourceAndListener)object).caller;
            mediaSource.releaseSource(mediaSource$MediaSourceCaller);
            mediaSource = ((MediaSourceList$MediaSourceAndListener)object).mediaSource;
            object = ((MediaSourceList$MediaSourceAndListener)object).eventListener;
            mediaSource.removeEventListener((MediaSourceEventListener)object);
            object = this.enabledMediaSourceHolders;
            object.remove(mediaSourceList$MediaSourceHolder);
        }
    }

    private void prepareChildSource(MediaSourceList$MediaSourceHolder object) {
        MaskingMediaSource maskingMediaSource = ((MediaSourceList$MediaSourceHolder)object).mediaSource;
        a0 a02 = new a0(this);
        MediaSourceList$ForwardingEventListener mediaSourceList$ForwardingEventListener = new MediaSourceList$ForwardingEventListener(this, (MediaSourceList$MediaSourceHolder)object);
        HashMap hashMap = this.childSources;
        MediaSourceList$MediaSourceAndListener mediaSourceList$MediaSourceAndListener = new MediaSourceList$MediaSourceAndListener(maskingMediaSource, a02, mediaSourceList$ForwardingEventListener);
        hashMap.put(object, mediaSourceList$MediaSourceAndListener);
        object = Util.createHandlerForCurrentOrMainLooper();
        maskingMediaSource.addEventListener((Handler)object, mediaSourceList$ForwardingEventListener);
        object = Util.createHandlerForCurrentOrMainLooper();
        maskingMediaSource.addDrmEventListener((Handler)object, mediaSourceList$ForwardingEventListener);
        object = this.mediaTransferListener;
        maskingMediaSource.prepareSource(a02, (TransferListener)object);
    }

    private void removeMediaSourcesInternal(int n10, int n11) {
        int n12 = 1;
        n11 -= n12;
        while (n11 >= n10) {
            MediaSourceList$MediaSourceHolder mediaSourceList$MediaSourceHolder = (MediaSourceList$MediaSourceHolder)this.mediaSourceHolders.remove(n11);
            Object object = this.mediaSourceByUid;
            Object object2 = mediaSourceList$MediaSourceHolder.uid;
            object.remove(object2);
            object = mediaSourceList$MediaSourceHolder.mediaSource.getTimeline();
            int n13 = -((Timeline)object).getWindowCount();
            this.correctOffsets(n11, n13);
            mediaSourceList$MediaSourceHolder.isRemoved = n12;
            n13 = (int)(this.isPrepared ? 1 : 0);
            if (n13 != 0) {
                this.maybeReleaseChildSource(mediaSourceList$MediaSourceHolder);
            }
            n11 += -1;
        }
    }

    public Timeline addMediaSources(int n10, List list, ShuffleOrder shuffleOrder) {
        int n11 = list.isEmpty();
        if (n11 == 0) {
            this.shuffleOrder = shuffleOrder;
            for (int i10 = n10; i10 < (n11 = list.size() + n10); ++i10) {
                int n12;
                Object object;
                Object object2;
                n11 = i10 - n10;
                MediaSourceList$MediaSourceHolder mediaSourceList$MediaSourceHolder = (MediaSourceList$MediaSourceHolder)list.get(n11);
                if (i10 > 0) {
                    object2 = this.mediaSourceHolders;
                    int n13 = i10 + -1;
                    object2 = (MediaSourceList$MediaSourceHolder)object2.get(n13);
                    object = ((MediaSourceList$MediaSourceHolder)object2).mediaSource.getTimeline();
                    n12 = ((MediaSourceList$MediaSourceHolder)object2).firstWindowIndexInChild;
                    n13 = ((Timeline)object).getWindowCount();
                    mediaSourceList$MediaSourceHolder.reset(n12 += n13);
                } else {
                    n12 = 0;
                    object2 = null;
                    mediaSourceList$MediaSourceHolder.reset(0);
                }
                n12 = mediaSourceList$MediaSourceHolder.mediaSource.getTimeline().getWindowCount();
                this.correctOffsets(i10, n12);
                this.mediaSourceHolders.add(i10, mediaSourceList$MediaSourceHolder);
                object2 = this.mediaSourceByUid;
                object = mediaSourceList$MediaSourceHolder.uid;
                object2.put(object, mediaSourceList$MediaSourceHolder);
                n12 = (int)(this.isPrepared ? 1 : 0);
                if (n12 == 0) continue;
                this.prepareChildSource(mediaSourceList$MediaSourceHolder);
                object2 = this.mediaSourceByMediaPeriod;
                n12 = (int)(((IdentityHashMap)object2).isEmpty() ? 1 : 0);
                if (n12 != 0) {
                    object2 = this.enabledMediaSourceHolders;
                    object2.add(mediaSourceList$MediaSourceHolder);
                    continue;
                }
                this.disableChildSource(mediaSourceList$MediaSourceHolder);
            }
        }
        return this.createTimeline();
    }

    public /* synthetic */ void b(MediaSource mediaSource, Timeline timeline) {
        this.a(mediaSource, timeline);
    }

    public Timeline clear(ShuffleOrder shuffleOrder) {
        if (shuffleOrder == null) {
            shuffleOrder = this.shuffleOrder.cloneAndClear();
        }
        this.shuffleOrder = shuffleOrder;
        int n10 = this.getSize();
        this.removeMediaSourcesInternal(0, n10);
        return this.createTimeline();
    }

    public MediaPeriod createPeriod(MediaSource$MediaPeriodId object, Allocator allocator, long l10) {
        Object object2 = MediaSourceList.getMediaSourceHolderUid(((MediaPeriodId)object).periodUid);
        Object object3 = MediaSourceList.getChildPeriodUid(((MediaPeriodId)object).periodUid);
        object = ((MediaSource$MediaPeriodId)object).copyWithPeriodUid(object3);
        object2 = (MediaSourceList$MediaSourceHolder)Assertions.checkNotNull((MediaSourceList$MediaSourceHolder)this.mediaSourceByUid.get(object2));
        this.enableMediaSource((MediaSourceList$MediaSourceHolder)object2);
        ((MediaSourceList$MediaSourceHolder)object2).activeMediaPeriodIds.add(object);
        object = ((MediaSourceList$MediaSourceHolder)object2).mediaSource.createPeriod((MediaSource$MediaPeriodId)object, allocator, l10);
        this.mediaSourceByMediaPeriod.put(object, object2);
        this.disableUnusedMediaSources();
        return object;
    }

    public Timeline createTimeline() {
        Object object;
        int n10;
        Object object2 = this.mediaSourceHolders;
        int n11 = object2.isEmpty();
        if (n11 != 0) {
            return Timeline.EMPTY;
        }
        object2 = null;
        int n12 = 0;
        List list = null;
        for (n11 = 0; n11 < (n10 = (object = this.mediaSourceHolders).size()); ++n11) {
            object = (MediaSourceList$MediaSourceHolder)this.mediaSourceHolders.get(n11);
            ((MediaSourceList$MediaSourceHolder)object).firstWindowIndexInChild = n12;
            object = ((MediaSourceList$MediaSourceHolder)object).mediaSource.getTimeline();
            n10 = ((Timeline)object).getWindowCount();
            n12 += n10;
        }
        list = this.mediaSourceHolders;
        object = this.shuffleOrder;
        object2 = new PlaylistTimeline(list, (ShuffleOrder)object);
        return object2;
    }

    public int getSize() {
        return this.mediaSourceHolders.size();
    }

    public boolean isPrepared() {
        return this.isPrepared;
    }

    public Timeline moveMediaSource(int n10, int n11, ShuffleOrder shuffleOrder) {
        int n12 = n10 + 1;
        return this.moveMediaSourceRange(n10, n12, n11, shuffleOrder);
    }

    public Timeline moveMediaSourceRange(int n10, int n11, int n12, ShuffleOrder shuffleOrder) {
        MediaSourceList$MediaSourceHolder mediaSourceList$MediaSourceHolder;
        int n13;
        int n14 = 1;
        if (n10 >= 0 && n10 <= n11 && n11 <= (n13 = this.getSize()) && n12 >= 0) {
            n13 = n14;
        } else {
            n13 = 0;
            mediaSourceList$MediaSourceHolder = null;
        }
        Assertions.checkArgument(n13 != 0);
        this.shuffleOrder = shuffleOrder;
        if (n10 != n11 && n10 != n12) {
            int n15;
            n13 = n11 - n10 + n12 - n14;
            n14 = n11 + -1;
            n14 = Math.max(n13, n14);
            mediaSourceList$MediaSourceHolder = (MediaSourceList$MediaSourceHolder)this.mediaSourceHolders.get(n15);
            n13 = mediaSourceList$MediaSourceHolder.firstWindowIndexInChild;
            List list = this.mediaSourceHolders;
            Util.moveItems(list, n10, n11, n12);
            for (n15 = Math.min(n10, n12); n15 <= n14; ++n15) {
                Object object = (MediaSourceList$MediaSourceHolder)this.mediaSourceHolders.get(n15);
                ((MediaSourceList$MediaSourceHolder)object).firstWindowIndexInChild = n13;
                object = ((MediaSourceList$MediaSourceHolder)object).mediaSource.getTimeline();
                n10 = ((Timeline)object).getWindowCount();
                n13 += n10;
            }
            return this.createTimeline();
        }
        return this.createTimeline();
    }

    public void prepare(TransferListener transferListener) {
        Object object;
        int n10 = this.isPrepared;
        int n11 = 1;
        Assertions.checkState((n10 ^= n11) != 0);
        this.mediaTransferListener = transferListener;
        transferListener = null;
        for (int i10 = 0; i10 < (n10 = (object = this.mediaSourceHolders).size()); ++i10) {
            object = (MediaSourceList$MediaSourceHolder)this.mediaSourceHolders.get(i10);
            this.prepareChildSource((MediaSourceList$MediaSourceHolder)object);
            Set set = this.enabledMediaSourceHolders;
            set.add(object);
        }
        this.isPrepared = n11;
    }

    public void release() {
        boolean bl2;
        Iterator iterator2 = this.childSources.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (MediaSourceList$MediaSourceAndListener)iterator2.next();
            MediaSource mediaSource = ((MediaSourceList$MediaSourceAndListener)object).mediaSource;
            Object object2 = ((MediaSourceList$MediaSourceAndListener)object).caller;
            try {
                mediaSource.releaseSource((MediaSource$MediaSourceCaller)object2);
            }
            catch (RuntimeException runtimeException) {
                object2 = TAG;
                String string2 = "Failed to release child source.";
                Log.e((String)object2, string2, runtimeException);
            }
            mediaSource = ((MediaSourceList$MediaSourceAndListener)object).mediaSource;
            object = ((MediaSourceList$MediaSourceAndListener)object).eventListener;
            mediaSource.removeEventListener((MediaSourceEventListener)object);
        }
        this.childSources.clear();
        this.enabledMediaSourceHolders.clear();
        this.isPrepared = false;
    }

    public void releasePeriod(MediaPeriod object) {
        MediaSourceList$MediaSourceHolder mediaSourceList$MediaSourceHolder = (MediaSourceList$MediaSourceHolder)Assertions.checkNotNull((MediaSourceList$MediaSourceHolder)this.mediaSourceByMediaPeriod.remove(object));
        mediaSourceList$MediaSourceHolder.mediaSource.releasePeriod((MediaPeriod)object);
        List list = mediaSourceList$MediaSourceHolder.activeMediaPeriodIds;
        object = ((MaskingMediaPeriod)object).id;
        list.remove(object);
        object = this.mediaSourceByMediaPeriod;
        boolean bl2 = ((IdentityHashMap)object).isEmpty();
        if (!bl2) {
            this.disableUnusedMediaSources();
        }
        this.maybeReleaseChildSource(mediaSourceList$MediaSourceHolder);
    }

    public Timeline removeMediaSourceRange(int n10, int n11, ShuffleOrder shuffleOrder) {
        int n12;
        n12 = n10 >= 0 && n10 <= n11 && n11 <= (n12 = this.getSize()) ? 1 : 0;
        Assertions.checkArgument(n12 != 0);
        this.shuffleOrder = shuffleOrder;
        this.removeMediaSourcesInternal(n10, n11);
        return this.createTimeline();
    }

    public Timeline setMediaSources(List list, ShuffleOrder shuffleOrder) {
        int n10 = this.mediaSourceHolders.size();
        this.removeMediaSourcesInternal(0, n10);
        n10 = this.mediaSourceHolders.size();
        return this.addMediaSources(n10, list, shuffleOrder);
    }

    public Timeline setShuffleOrder(ShuffleOrder shuffleOrder) {
        int n10 = this.getSize();
        int n11 = shuffleOrder.getLength();
        if (n11 != n10) {
            shuffleOrder = shuffleOrder.cloneAndClear();
            n11 = 0;
            shuffleOrder = shuffleOrder.cloneAndInsert(0, n10);
        }
        this.shuffleOrder = shuffleOrder;
        return this.createTimeline();
    }
}

