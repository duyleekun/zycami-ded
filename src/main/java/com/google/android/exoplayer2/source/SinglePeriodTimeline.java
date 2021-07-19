/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.MediaItem$LiveConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.util.Assertions;

public final class SinglePeriodTimeline
extends Timeline {
    private static final MediaItem MEDIA_ITEM;
    private static final Object UID;
    private final long elapsedRealtimeEpochOffsetMs;
    private final boolean isDynamic;
    private final boolean isSeekable;
    private final MediaItem$LiveConfiguration liveConfiguration;
    private final Object manifest;
    private final MediaItem mediaItem;
    private final long periodDurationUs;
    private final long presentationStartTimeMs;
    private final long windowDefaultStartPositionUs;
    private final long windowDurationUs;
    private final long windowPositionInPeriodUs;
    private final long windowStartTimeMs;

    static {
        Object object;
        UID = object = new Object();
        object = new MediaItem$Builder();
        object = ((MediaItem$Builder)object).setMediaId("SinglePeriodTimeline");
        Uri uri = Uri.EMPTY;
        MEDIA_ITEM = ((MediaItem$Builder)object).setUri(uri).build();
    }

    public SinglePeriodTimeline(long l10, long l11, long l12, long l13, long l14, long l15, long l16, boolean bl2, boolean bl3, Object object, MediaItem mediaItem, MediaItem$LiveConfiguration mediaItem$LiveConfiguration) {
        this.presentationStartTimeMs = l10;
        this.windowStartTimeMs = l11;
        this.elapsedRealtimeEpochOffsetMs = l12;
        this.periodDurationUs = l13;
        this.windowDurationUs = l14;
        this.windowPositionInPeriodUs = l15;
        this.windowDefaultStartPositionUs = l16;
        this.isSeekable = bl2;
        this.isDynamic = bl3;
        Object object2 = object;
        this.manifest = object;
        this.mediaItem = object2 = (MediaItem)Assertions.checkNotNull(mediaItem);
        object2 = mediaItem$LiveConfiguration;
        this.liveConfiguration = mediaItem$LiveConfiguration;
    }

    public SinglePeriodTimeline(long l10, long l11, long l12, long l13, long l14, long l15, long l16, boolean bl2, boolean bl3, boolean bl4, Object object, Object object2) {
        Object object3 = MEDIA_ITEM;
        MediaItem$Builder mediaItem$Builder = ((MediaItem)object3).buildUpon().setTag(object2);
        MediaItem mediaItem = mediaItem$Builder.build();
        object3 = bl4 ? ((MediaItem)object3).liveConfiguration : null;
        this(l10, l11, l12, l13, l14, l15, l16, bl2, bl3, object, mediaItem, (MediaItem$LiveConfiguration)object3);
    }

    public SinglePeriodTimeline(long l10, long l11, long l12, long l13, boolean bl2, boolean bl3, boolean bl4, Object object, MediaItem mediaItem) {
        Object object2 = bl4 ? mediaItem.liveConfiguration : null;
        MediaItem$LiveConfiguration mediaItem$LiveConfiguration = object2;
        object2 = this;
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, l10, l11, l12, l13, bl2, bl3, object, mediaItem, mediaItem$LiveConfiguration);
    }

    public SinglePeriodTimeline(long l10, long l11, long l12, long l13, boolean bl2, boolean bl3, boolean bl4, Object object, Object object2) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, l10, l11, l12, l13, bl2, bl3, bl4, object, object2);
    }

    public SinglePeriodTimeline(long l10, boolean bl2, boolean bl3, boolean bl4, Object object, MediaItem mediaItem) {
        this(l10, l10, 0L, 0L, bl2, bl3, bl4, object, mediaItem);
    }

    public SinglePeriodTimeline(long l10, boolean bl2, boolean bl3, boolean bl4, Object object, Object object2) {
        this(l10, l10, 0L, 0L, bl2, bl3, bl4, object, object2);
    }

    public int getIndexOfPeriod(Object object) {
        Object object2 = UID;
        int n10 = object2.equals(object);
        if (n10 != 0) {
            n10 = 0;
            object = null;
        } else {
            n10 = -1;
        }
        return n10;
    }

    public Timeline$Period getPeriod(int n10, Timeline$Period timeline$Period, boolean bl2) {
        Object object;
        int n11 = 1;
        Assertions.checkIndex(n10, 0, n11);
        if (bl2) {
            object = UID;
        } else {
            n10 = 0;
            object = null;
        }
        long l10 = this.periodDurationUs;
        long l11 = -this.windowPositionInPeriodUs;
        return timeline$Period.set(null, object, 0, l10, l11);
    }

    public int getPeriodCount() {
        return 1;
    }

    public Object getUidOfPeriod(int n10) {
        Assertions.checkIndex(n10, 0, 1);
        return UID;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Timeline$Window getWindow(int n10, Timeline$Window timeline$Window, long l10) {
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        SinglePeriodTimeline singlePeriodTimeline = this;
        int n11 = 1;
        Assertions.checkIndex(n10, 0, n11);
        long l17 = this.windowDefaultStartPositionUs;
        boolean bl2 = this.isDynamic;
        long l18 = -9223372036854775807L;
        long l19 = bl2 && (l16 = (l15 = l10 - (l14 = 0L)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != false && ((l13 = (l12 = (l14 = this.windowDurationUs) - l18) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false || (l16 = (l11 = (l17 += l10) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) > 0) ? l18 : l17;
        Object object = Timeline$Window.SINGLE_WINDOW_UID;
        MediaItem mediaItem = singlePeriodTimeline.mediaItem;
        Object object2 = singlePeriodTimeline.manifest;
        long l20 = singlePeriodTimeline.presentationStartTimeMs;
        long l21 = singlePeriodTimeline.windowStartTimeMs;
        long l22 = singlePeriodTimeline.elapsedRealtimeEpochOffsetMs;
        boolean bl3 = singlePeriodTimeline.isSeekable;
        MediaItem$LiveConfiguration mediaItem$LiveConfiguration = singlePeriodTimeline.liveConfiguration;
        long l23 = singlePeriodTimeline.windowDurationUs;
        l17 = singlePeriodTimeline.windowPositionInPeriodUs;
        return timeline$Window.set(object, mediaItem, object2, l20, l21, l22, bl3, bl2, mediaItem$LiveConfiguration, l19, l23, 0, 0, l17);
    }

    public int getWindowCount() {
        return 1;
    }
}

