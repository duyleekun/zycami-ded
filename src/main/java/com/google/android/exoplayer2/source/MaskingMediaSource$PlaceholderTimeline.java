/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline;

public final class MaskingMediaSource$PlaceholderTimeline
extends Timeline {
    private final MediaItem mediaItem;

    public MaskingMediaSource$PlaceholderTimeline(MediaItem mediaItem) {
        this.mediaItem = mediaItem;
    }

    public int getIndexOfPeriod(Object object) {
        int n10;
        Object object2 = MaskingMediaSource$MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID;
        if (object == object2) {
            n10 = 0;
            object = null;
        } else {
            n10 = -1;
        }
        return n10;
    }

    public Timeline$Period getPeriod(int n10, Timeline$Period timeline$Period, boolean bl2) {
        Integer n11;
        Object object = null;
        Integer n12 = bl2 ? (n11 = Integer.valueOf(0)) : null;
        if (bl2) {
            object = MaskingMediaSource$MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID;
        }
        return timeline$Period.set(n12, object, 0, -9223372036854775807L, 0L);
    }

    public int getPeriodCount() {
        return 1;
    }

    public Object getUidOfPeriod(int n10) {
        return MaskingMediaSource$MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID;
    }

    public Timeline$Window getWindow(int n10, Timeline$Window timeline$Window, long l10) {
        Object object = Timeline$Window.SINGLE_WINDOW_UID;
        MediaItem mediaItem = this.mediaItem;
        long l11 = 0L;
        long l12 = -9223372036854775807L;
        timeline$Window.set(object, mediaItem, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, l11, l12, 0, 0, 0L);
        object = timeline$Window;
        timeline$Window.isPlaceholder = true;
        return timeline$Window;
    }

    public int getWindowCount() {
        return 1;
    }
}

