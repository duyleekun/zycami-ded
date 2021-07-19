/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.LoopingMediaSource$InfinitelyLoopingTimeline;
import com.google.android.exoplayer2.source.LoopingMediaSource$LoopingTimeline;
import com.google.android.exoplayer2.source.MaskingMediaSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.HashMap;
import java.util.Map;

public final class LoopingMediaSource
extends CompositeMediaSource {
    private final Map childMediaPeriodIdToMediaPeriodId;
    private final int loopCount;
    private final MaskingMediaSource maskingMediaSource;
    private final Map mediaPeriodToChildMediaPeriodId;

    public LoopingMediaSource(MediaSource mediaSource) {
        this(mediaSource, -1 >>> 1);
    }

    public LoopingMediaSource(MediaSource hashMap, int n10) {
        MaskingMediaSource maskingMediaSource;
        boolean bl2;
        if (n10 > 0) {
            bl2 = true;
        } else {
            bl2 = false;
            maskingMediaSource = null;
        }
        Assertions.checkArgument(bl2);
        this.maskingMediaSource = maskingMediaSource = new MaskingMediaSource((MediaSource)((Object)hashMap), false);
        this.loopCount = n10;
        this.childMediaPeriodIdToMediaPeriodId = hashMap = new HashMap();
        this.mediaPeriodToChildMediaPeriodId = hashMap = new HashMap();
    }

    public MediaPeriod createPeriod(MediaSource$MediaPeriodId object, Allocator allocator, long l10) {
        int n10 = this.loopCount;
        int n11 = -1 >>> 1;
        if (n10 == n11) {
            return this.maskingMediaSource.createPeriod((MediaSource$MediaPeriodId)object, allocator, l10);
        }
        Object object2 = AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(((MediaPeriodId)object).periodUid);
        object2 = ((MediaSource$MediaPeriodId)object).copyWithPeriodUid(object2);
        this.childMediaPeriodIdToMediaPeriodId.put(object2, object);
        object = this.maskingMediaSource.createPeriod((MediaSource$MediaPeriodId)object2, allocator, l10);
        this.mediaPeriodToChildMediaPeriodId.put(object, object2);
        return object;
    }

    public Timeline getInitialTimeline() {
        Timeline timeline;
        int n10 = this.loopCount;
        int n11 = -1 >>> 1;
        if (n10 != n11) {
            Timeline timeline2 = this.maskingMediaSource.getTimeline();
            int n12 = this.loopCount;
            timeline = new LoopingMediaSource$LoopingTimeline(timeline2, n12);
        } else {
            Timeline timeline3 = this.maskingMediaSource.getTimeline();
            timeline = new LoopingMediaSource$InfinitelyLoopingTimeline(timeline3);
        }
        return timeline;
    }

    public MediaItem getMediaItem() {
        return this.maskingMediaSource.getMediaItem();
    }

    public MediaSource$MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Void void_, MediaSource$MediaPeriodId object) {
        int n10 = this.loopCount;
        int n11 = -1 >>> 1;
        if (n10 != n11) {
            void_ = this.childMediaPeriodIdToMediaPeriodId.get(object);
            object = void_;
            object = (MediaSource$MediaPeriodId)((Object)void_);
        }
        return object;
    }

    public Object getTag() {
        return this.maskingMediaSource.getTag();
    }

    public boolean isSingleWindow() {
        return false;
    }

    public void onChildSourceInfoRefreshed(Void object, MediaSource mediaSource, Timeline timeline) {
        int n10 = this.loopCount;
        int n11 = -1 >>> 1;
        if (n10 != n11) {
            n11 = this.loopCount;
            object = new LoopingMediaSource$LoopingTimeline(timeline, n11);
        } else {
            object = new LoopingMediaSource$InfinitelyLoopingTimeline(timeline);
        }
        this.refreshSourceInfo((Timeline)object);
    }

    public void prepareSourceInternal(TransferListener object) {
        super.prepareSourceInternal((TransferListener)object);
        object = this.maskingMediaSource;
        this.prepareChildSource(null, (MediaSource)object);
    }

    public void releasePeriod(MediaPeriod object) {
        this.maskingMediaSource.releasePeriod((MediaPeriod)object);
        Map map = this.mediaPeriodToChildMediaPeriodId;
        object = (MediaSource$MediaPeriodId)map.remove(object);
        if (object != null) {
            map = this.childMediaPeriodIdToMediaPeriodId;
            map.remove(object);
        }
    }
}

