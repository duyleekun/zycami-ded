/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.source.MaskingMediaSource$PlaceholderTimeline;
import com.google.android.exoplayer2.util.Util;

public final class MaskingMediaSource$MaskingTimeline
extends ForwardingTimeline {
    public static final Object MASKING_EXTERNAL_PERIOD_UID;
    private final Object replacedInternalPeriodUid;
    private final Object replacedInternalWindowUid;

    static {
        Object object;
        MASKING_EXTERNAL_PERIOD_UID = object = new Object();
    }

    private MaskingMediaSource$MaskingTimeline(Timeline timeline, Object object, Object object2) {
        super(timeline);
        this.replacedInternalWindowUid = object;
        this.replacedInternalPeriodUid = object2;
    }

    public static /* synthetic */ Object access$000(MaskingMediaSource$MaskingTimeline maskingMediaSource$MaskingTimeline) {
        return maskingMediaSource$MaskingTimeline.replacedInternalPeriodUid;
    }

    public static MaskingMediaSource$MaskingTimeline createWithPlaceholderTimeline(MediaItem object) {
        MaskingMediaSource$PlaceholderTimeline maskingMediaSource$PlaceholderTimeline = new MaskingMediaSource$PlaceholderTimeline((MediaItem)object);
        object = Timeline$Window.SINGLE_WINDOW_UID;
        Object object2 = MASKING_EXTERNAL_PERIOD_UID;
        MaskingMediaSource$MaskingTimeline maskingMediaSource$MaskingTimeline = new MaskingMediaSource$MaskingTimeline(maskingMediaSource$PlaceholderTimeline, object, object2);
        return maskingMediaSource$MaskingTimeline;
    }

    public static MaskingMediaSource$MaskingTimeline createWithRealTimeline(Timeline timeline, Object object, Object object2) {
        MaskingMediaSource$MaskingTimeline maskingMediaSource$MaskingTimeline = new MaskingMediaSource$MaskingTimeline(timeline, object, object2);
        return maskingMediaSource$MaskingTimeline;
    }

    public MaskingMediaSource$MaskingTimeline cloneWithUpdatedTimeline(Timeline timeline) {
        Object object = this.replacedInternalWindowUid;
        Object object2 = this.replacedInternalPeriodUid;
        MaskingMediaSource$MaskingTimeline maskingMediaSource$MaskingTimeline = new MaskingMediaSource$MaskingTimeline(timeline, object, object2);
        return maskingMediaSource$MaskingTimeline;
    }

    public int getIndexOfPeriod(Object object) {
        Timeline timeline = this.timeline;
        Object object2 = MASKING_EXTERNAL_PERIOD_UID;
        boolean bl2 = object2.equals(object);
        if (bl2 && (object2 = this.replacedInternalPeriodUid) != null) {
            object = object2;
        }
        return timeline.getIndexOfPeriod(object);
    }

    public Timeline$Period getPeriod(int n10, Timeline$Period timeline$Period, boolean bl2) {
        this.timeline.getPeriod(n10, timeline$Period, bl2);
        Object object = timeline$Period.uid;
        Object object2 = this.replacedInternalPeriodUid;
        n10 = (int)(Util.areEqual(object, object2) ? 1 : 0);
        if (n10 != 0 && bl2) {
            timeline$Period.uid = object = MASKING_EXTERNAL_PERIOD_UID;
        }
        return timeline$Period;
    }

    public Timeline getTimeline() {
        return this.timeline;
    }

    public Object getUidOfPeriod(int n10) {
        Object object;
        Object object2 = this.timeline.getUidOfPeriod(n10);
        boolean bl2 = Util.areEqual(object2, object = this.replacedInternalPeriodUid);
        if (bl2) {
            object2 = MASKING_EXTERNAL_PERIOD_UID;
        }
        return object2;
    }

    public Timeline$Window getWindow(int n10, Timeline$Window timeline$Window, long l10) {
        Timeline timeline = this.timeline;
        timeline.getWindow(n10, timeline$Window, l10);
        Object object = timeline$Window.uid;
        Object object2 = this.replacedInternalWindowUid;
        n10 = (int)(Util.areEqual(object, object2) ? 1 : 0);
        if (n10 != 0) {
            timeline$Window.uid = object = Timeline$Window.SINGLE_WINDOW_UID;
        }
        return timeline$Window;
    }
}

