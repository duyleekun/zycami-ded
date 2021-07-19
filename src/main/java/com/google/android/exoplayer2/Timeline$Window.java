/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.MediaItem$LiveConfiguration;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class Timeline$Window {
    private static final MediaItem EMPTY_MEDIA_ITEM;
    public static final Object SINGLE_WINDOW_UID;
    public long defaultPositionUs;
    public long durationUs;
    public long elapsedRealtimeEpochOffsetMs;
    public int firstPeriodIndex;
    public boolean isDynamic;
    public boolean isLive;
    public boolean isPlaceholder;
    public boolean isSeekable;
    public int lastPeriodIndex;
    public MediaItem$LiveConfiguration liveConfiguration;
    public Object manifest;
    public MediaItem mediaItem;
    public long positionInFirstPeriodUs;
    public long presentationStartTimeMs;
    public Object tag;
    public Object uid;
    public long windowStartTimeMs;

    static {
        Object object;
        SINGLE_WINDOW_UID = object = new Object();
        object = new MediaItem$Builder();
        object = ((MediaItem$Builder)object).setMediaId("com.google.android.exoplayer2.Timeline");
        Uri uri = Uri.EMPTY;
        EMPTY_MEDIA_ITEM = ((MediaItem$Builder)object).setUri(uri).build();
    }

    public Timeline$Window() {
        Object object;
        this.uid = object = SINGLE_WINDOW_UID;
        this.mediaItem = object = EMPTY_MEDIA_ITEM;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        int n10;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (n10 = (object3 = Timeline$Window.class).equals(object2 = object.getClass())) != 0) {
            long l10;
            long l11;
            long l12;
            long l13;
            int n11;
            long l14;
            long l15;
            long l16;
            long l17;
            long l18;
            object = (Timeline$Window)object;
            object3 = this.uid;
            object2 = ((Timeline$Window)object).uid;
            n10 = Util.areEqual(object3, object2);
            if (n10 == 0 || (n10 = Util.areEqual(object3 = this.mediaItem, object2 = ((Timeline$Window)object).mediaItem)) == 0 || (n10 = Util.areEqual(object3 = this.manifest, object2 = ((Timeline$Window)object).manifest)) == 0 || (n10 = Util.areEqual(object3 = this.liveConfiguration, object2 = ((Timeline$Window)object).liveConfiguration)) == 0 || (n10 = (l18 = (l17 = this.presentationStartTimeMs) - (l16 = ((Timeline$Window)object).presentationStartTimeMs)) == 0L ? 0 : (l18 < 0L ? -1 : 1)) != 0 || (n10 = (l15 = (l17 = this.windowStartTimeMs) - (l16 = ((Timeline$Window)object).windowStartTimeMs)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != 0 || (n10 = (l14 = (l17 = this.elapsedRealtimeEpochOffsetMs) - (l16 = ((Timeline$Window)object).elapsedRealtimeEpochOffsetMs)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != 0 || (n10 = this.isSeekable) != (n11 = ((Timeline$Window)object).isSeekable) || (n10 = this.isDynamic) != (n11 = ((Timeline$Window)object).isDynamic) || (n10 = this.isPlaceholder) != (n11 = ((Timeline$Window)object).isPlaceholder) || (n10 = (l13 = (l17 = this.defaultPositionUs) - (l16 = ((Timeline$Window)object).defaultPositionUs)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != 0 || (n10 = (l12 = (l17 = this.durationUs) - (l16 = ((Timeline$Window)object).durationUs)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != 0 || (n10 = this.firstPeriodIndex) != (n11 = ((Timeline$Window)object).firstPeriodIndex) || (n10 = this.lastPeriodIndex) != (n11 = ((Timeline$Window)object).lastPeriodIndex) || (l11 = (l10 = (l17 = this.positionInFirstPeriodUs) - (l16 = ((Timeline$Window)object).positionInFirstPeriodUs)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getCurrentUnixTimeMs() {
        return Util.getNowUnixTimeMs(this.elapsedRealtimeEpochOffsetMs);
    }

    public long getDefaultPositionMs() {
        return C.usToMs(this.defaultPositionUs);
    }

    public long getDefaultPositionUs() {
        return this.defaultPositionUs;
    }

    public long getDurationMs() {
        return C.usToMs(this.durationUs);
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public long getPositionInFirstPeriodMs() {
        return C.usToMs(this.positionInFirstPeriodUs);
    }

    public long getPositionInFirstPeriodUs() {
        return this.positionInFirstPeriodUs;
    }

    public int hashCode() {
        int n10 = this.uid.hashCode();
        int n11 = (217 + n10) * 31;
        n10 = this.mediaItem.hashCode();
        n11 = (n11 + n10) * 31;
        Object object = this.manifest;
        int n12 = 0;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        n11 = (n11 + n10) * 31;
        object = this.liveConfiguration;
        if (object != null) {
            n12 = ((MediaItem$LiveConfiguration)object).hashCode();
        }
        n11 = (n11 + n12) * 31;
        long l10 = this.presentationStartTimeMs;
        n10 = 32;
        long l11 = l10 >>> n10;
        n12 = (int)(l10 ^ l11);
        n11 = (n11 + n12) * 31;
        l10 = this.windowStartTimeMs;
        l11 = l10 >>> n10;
        n12 = (int)(l10 ^ l11);
        n11 = (n11 + n12) * 31;
        l10 = this.elapsedRealtimeEpochOffsetMs;
        l11 = l10 >>> n10;
        n12 = (int)(l10 ^ l11);
        n11 = (n11 + n12) * 31;
        n12 = (int)(this.isSeekable ? 1 : 0);
        n11 = (n11 + n12) * 31;
        n12 = (int)(this.isDynamic ? 1 : 0);
        n11 = (n11 + n12) * 31;
        n12 = (int)(this.isPlaceholder ? 1 : 0);
        n11 = (n11 + n12) * 31;
        l10 = this.defaultPositionUs;
        l11 = l10 >>> n10;
        n12 = (int)(l10 ^ l11);
        n11 = (n11 + n12) * 31;
        l10 = this.durationUs;
        l11 = l10 >>> n10;
        n12 = (int)(l10 ^ l11);
        n11 = (n11 + n12) * 31;
        n12 = this.firstPeriodIndex;
        n11 = (n11 + n12) * 31;
        n12 = this.lastPeriodIndex;
        n11 = (n11 + n12) * 31;
        l10 = this.positionInFirstPeriodUs;
        l11 = l10 >>> n10;
        n10 = (int)(l10 ^ l11);
        return n11 + n10;
    }

    public boolean isLive() {
        MediaItem$LiveConfiguration mediaItem$LiveConfiguration;
        boolean bl2;
        boolean bl3 = this.isLive;
        MediaItem$LiveConfiguration mediaItem$LiveConfiguration2 = this.liveConfiguration;
        boolean bl4 = true;
        if (mediaItem$LiveConfiguration2 != null) {
            bl2 = bl4;
        } else {
            bl2 = false;
            mediaItem$LiveConfiguration2 = null;
        }
        if (bl3 == bl2) {
            bl3 = bl4;
        } else {
            bl3 = false;
            mediaItem$LiveConfiguration = null;
        }
        Assertions.checkState(bl3);
        mediaItem$LiveConfiguration = this.liveConfiguration;
        if (mediaItem$LiveConfiguration == null) {
            bl4 = false;
        }
        return bl4;
    }

    public Timeline$Window set(Object object, MediaItem mediaItem, Object object2, long l10, long l11, long l12, boolean bl2, boolean bl3, MediaItem$LiveConfiguration mediaItem$LiveConfiguration, long l13, long l14, int n10, int n11, long l15) {
        boolean bl4;
        Timeline$Window timeline$Window = this;
        Object object3 = mediaItem;
        MediaItem$LiveConfiguration mediaItem$LiveConfiguration2 = mediaItem$LiveConfiguration;
        Object object4 = object;
        this.uid = object;
        object4 = mediaItem != null ? mediaItem : EMPTY_MEDIA_ITEM;
        timeline$Window.mediaItem = object4;
        object3 = object3 != null && (object3 = ((MediaItem)object3).playbackProperties) != null ? ((MediaItem$PlaybackProperties)object3).tag : null;
        timeline$Window.tag = object3;
        object3 = object2;
        timeline$Window.manifest = object2;
        timeline$Window.presentationStartTimeMs = l10;
        timeline$Window.windowStartTimeMs = l11;
        timeline$Window.elapsedRealtimeEpochOffsetMs = l12;
        timeline$Window.isSeekable = bl2;
        timeline$Window.isDynamic = bl3;
        object3 = null;
        if (mediaItem$LiveConfiguration2 != null) {
            bl4 = true;
        } else {
            bl4 = false;
            object4 = null;
        }
        timeline$Window.isLive = bl4;
        timeline$Window.liveConfiguration = mediaItem$LiveConfiguration2;
        timeline$Window.defaultPositionUs = l13;
        timeline$Window.durationUs = l14;
        timeline$Window.firstPeriodIndex = n10;
        timeline$Window.lastPeriodIndex = n11;
        timeline$Window.positionInFirstPeriodUs = l15;
        timeline$Window.isPlaceholder = false;
        return timeline$Window;
    }
}

