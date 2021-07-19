/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;

public final class MaskingMediaSource
extends CompositeMediaSource {
    private boolean hasRealTimeline;
    private boolean hasStartedPreparing;
    private boolean isPrepared;
    private final MediaSource mediaSource;
    private final Timeline$Period period;
    private MaskingMediaSource$MaskingTimeline timeline;
    private MaskingMediaPeriod unpreparedMaskingMediaPeriod;
    private final boolean useLazyPreparation;
    private final Timeline$Window window;

    public MaskingMediaSource(MediaSource object, boolean bl2) {
        Object object2;
        this.mediaSource = object;
        boolean bl3 = true;
        if (bl2 && (bl2 = object.isSingleWindow())) {
            bl2 = bl3;
        } else {
            bl2 = false;
            object2 = null;
        }
        this.useLazyPreparation = bl2;
        object2 = new Timeline$Window();
        this.window = object2;
        this.period = object2 = new Timeline$Period();
        object2 = object.getInitialTimeline();
        if (object2 != null) {
            this.timeline = object = MaskingMediaSource$MaskingTimeline.createWithRealTimeline((Timeline)object2, null, null);
            this.hasRealTimeline = bl3;
        } else {
            this.timeline = object = MaskingMediaSource$MaskingTimeline.createWithPlaceholderTimeline(object.getMediaItem());
        }
    }

    private Object getExternalPeriodUid(Object object) {
        boolean bl2;
        Object object2 = MaskingMediaSource$MaskingTimeline.access$000(this.timeline);
        if (object2 != null && (bl2 = (object2 = MaskingMediaSource$MaskingTimeline.access$000(this.timeline)).equals(object))) {
            object = MaskingMediaSource$MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID;
        }
        return object;
    }

    private Object getInternalPeriodUid(Object object) {
        boolean bl2;
        Object object2 = MaskingMediaSource$MaskingTimeline.access$000(this.timeline);
        if (object2 != null && (bl2 = object.equals(object2 = MaskingMediaSource$MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID))) {
            object = MaskingMediaSource$MaskingTimeline.access$000(this.timeline);
        }
        return object;
    }

    private void setPreparePositionOverrideToUnpreparedMaskingPeriod(long l10) {
        int n10;
        MaskingMediaPeriod maskingMediaPeriod = this.unpreparedMaskingMediaPeriod;
        Object object = this.timeline;
        Object object2 = maskingMediaPeriod.id.periodUid;
        int n11 = ((MaskingMediaSource$MaskingTimeline)object).getIndexOfPeriod(object2);
        if (n11 == (n10 = -1)) {
            return;
        }
        object2 = this.timeline;
        Timeline$Period timeline$Period = this.period;
        object = ((Timeline)object2).getPeriod(n11, timeline$Period);
        long l11 = ((Timeline$Period)object).durationUs;
        long l12 = -9223372036854775807L;
        long l13 = l11 - l12;
        Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object3 != false && (object3 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) >= 0) {
            l12 = 1L;
            l10 = Math.max(0L, l11 -= l12);
        }
        maskingMediaPeriod.overridePreparePositionUs(l10);
    }

    public MaskingMediaPeriod createPeriod(MediaSource$MediaPeriodId mediaPeriodId, Allocator object, long l10) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod((MediaSource$MediaPeriodId)mediaPeriodId, (Allocator)object, l10);
        object = this.mediaSource;
        maskingMediaPeriod.setMediaSource((MediaSource)object);
        boolean bl2 = this.isPrepared;
        if (bl2) {
            object = mediaPeriodId.periodUid;
            object = this.getInternalPeriodUid(object);
            mediaPeriodId = mediaPeriodId.copyWithPeriodUid(object);
            maskingMediaPeriod.createPeriod((MediaSource$MediaPeriodId)mediaPeriodId);
        } else {
            this.unpreparedMaskingMediaPeriod = maskingMediaPeriod;
            boolean bl3 = this.hasStartedPreparing;
            if (!bl3) {
                this.hasStartedPreparing = true;
                bl3 = false;
                mediaPeriodId = null;
                object = this.mediaSource;
                this.prepareChildSource(null, (MediaSource)object);
            }
        }
        return maskingMediaPeriod;
    }

    public MediaItem getMediaItem() {
        return this.mediaSource.getMediaItem();
    }

    public MediaSource$MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Void object, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        object = mediaSource$MediaPeriodId.periodUid;
        object = this.getExternalPeriodUid(object);
        return mediaSource$MediaPeriodId.copyWithPeriodUid(object);
    }

    public Object getTag() {
        return this.mediaSource.getTag();
    }

    public Timeline getTimeline() {
        return this.timeline;
    }

    public void maybeThrowSourceInfoRefreshError() {
    }

    /*
     * Unable to fully structure code
     */
    public void onChildSourceInfoRefreshed(Void var1_1, MediaSource var2_2, Timeline var3_3) {
        block7: {
            block6: {
                var4_4 = this.isPrepared;
                if (!var4_4) break block6;
                this.timeline = var1_1 = this.timeline.cloneWithUpdatedTimeline(var3_3);
                var1_1 = this.unpreparedMaskingMediaPeriod;
                if (var1_1 != null) {
                    var5_5 = var1_1.getPreparePositionOverrideUs();
                    this.setPreparePositionOverrideToUnpreparedMaskingPeriod(var5_5);
                }
                ** GOTO lbl-1000
            }
            var4_4 = var3_3.isEmpty();
            if (!var4_4) break block7;
            var4_4 = this.hasRealTimeline;
            if (var4_4) {
                var1_1 = this.timeline.cloneWithUpdatedTimeline(var3_3);
            } else {
                var1_1 = Timeline$Window.SINGLE_WINDOW_UID;
                var2_2 = MaskingMediaSource$MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID;
                var1_1 = MaskingMediaSource$MaskingTimeline.createWithRealTimeline(var3_3, var1_1, var2_2);
            }
            this.timeline = var1_1;
            ** GOTO lbl-1000
        }
        var4_4 = false;
        var2_2 = this.window;
        var3_3.getWindow(0, (Timeline$Window)var2_2);
        var1_1 = this.window;
        var5_6 = var1_1.getDefaultPositionUs();
        var7_7 = this.unpreparedMaskingMediaPeriod;
        var13_11 = var7_7 != null && (var12_10 = (cfr_temp_0 = (var8_8 = var7_7.getPreparePositionUs()) - (var10_9 = 0L)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false ? var8_8 : var5_6;
        var15_12 = this.window;
        var1_1 = var15_12.uid;
        var16_13 = this.period;
        var2_2 = var3_3.getPeriodPosition(var15_12, var16_13, 0, var13_11);
        var7_7 = var2_2.first;
        var2_2 = (Long)var2_2.second;
        var17_14 = var2_2.longValue();
        var19_15 = this.hasRealTimeline;
        var1_1 = var19_15 != false ? this.timeline.cloneWithUpdatedTimeline(var3_3) : MaskingMediaSource$MaskingTimeline.createWithRealTimeline(var3_3, var1_1, var7_7);
        this.timeline = var1_1;
        var1_1 = this.unpreparedMaskingMediaPeriod;
        if (var1_1 != null) {
            this.setPreparePositionOverrideToUnpreparedMaskingPeriod(var17_14);
            var1_1 = var1_1.id;
            var2_2 = var1_1.periodUid;
            var2_2 = this.getInternalPeriodUid(var2_2);
            var1_1 = var1_1.copyWithPeriodUid(var2_2);
        } else lbl-1000:
        // 3 sources

        {
            var4_4 = false;
            var1_1 = null;
        }
        this.hasRealTimeline = var19_15 = true;
        this.isPrepared = var19_15;
        var2_2 = this.timeline;
        this.refreshSourceInfo((Timeline)var2_2);
        if (var1_1 != null) {
            var2_2 = (MaskingMediaPeriod)Assertions.checkNotNull(this.unpreparedMaskingMediaPeriod);
            var2_2.createPeriod((MediaSource$MediaPeriodId)var1_1);
        }
    }

    public void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        boolean bl2 = this.useLazyPreparation;
        if (!bl2) {
            this.hasStartedPreparing = true;
            bl2 = false;
            transferListener = null;
            MediaSource mediaSource = this.mediaSource;
            this.prepareChildSource(null, mediaSource);
        }
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        MediaPeriod mediaPeriod2 = mediaPeriod;
        ((MaskingMediaPeriod)mediaPeriod).releasePeriod();
        mediaPeriod2 = this.unpreparedMaskingMediaPeriod;
        if (mediaPeriod == mediaPeriod2) {
            mediaPeriod = null;
            this.unpreparedMaskingMediaPeriod = null;
        }
    }

    public void releaseSourceInternal() {
        this.isPrepared = false;
        this.hasStartedPreparing = false;
        super.releaseSourceInternal();
    }
}

