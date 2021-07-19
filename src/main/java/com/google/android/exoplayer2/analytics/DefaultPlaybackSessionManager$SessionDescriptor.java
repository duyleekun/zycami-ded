/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;

public final class DefaultPlaybackSessionManager$SessionDescriptor {
    private MediaSource$MediaPeriodId adMediaPeriodId;
    private boolean isActive;
    private boolean isCreated;
    private final String sessionId;
    public final /* synthetic */ DefaultPlaybackSessionManager this$0;
    private int windowIndex;
    private long windowSequenceNumber;

    public DefaultPlaybackSessionManager$SessionDescriptor(DefaultPlaybackSessionManager defaultPlaybackSessionManager, String string2, int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        boolean bl2;
        this.this$0 = defaultPlaybackSessionManager;
        this.sessionId = string2;
        this.windowIndex = n10;
        long l10 = mediaSource$MediaPeriodId == null ? (long)-1 : mediaSource$MediaPeriodId.windowSequenceNumber;
        this.windowSequenceNumber = l10;
        if (mediaSource$MediaPeriodId != null && (bl2 = mediaSource$MediaPeriodId.isAd())) {
            this.adMediaPeriodId = mediaSource$MediaPeriodId;
        }
    }

    public static /* synthetic */ String access$000(DefaultPlaybackSessionManager$SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor) {
        return defaultPlaybackSessionManager$SessionDescriptor.sessionId;
    }

    public static /* synthetic */ long access$100(DefaultPlaybackSessionManager$SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor) {
        return defaultPlaybackSessionManager$SessionDescriptor.windowSequenceNumber;
    }

    public static /* synthetic */ int access$200(DefaultPlaybackSessionManager$SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor) {
        return defaultPlaybackSessionManager$SessionDescriptor.windowIndex;
    }

    public static /* synthetic */ boolean access$300(DefaultPlaybackSessionManager$SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor) {
        return defaultPlaybackSessionManager$SessionDescriptor.isCreated;
    }

    public static /* synthetic */ boolean access$302(DefaultPlaybackSessionManager$SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor, boolean bl2) {
        defaultPlaybackSessionManager$SessionDescriptor.isCreated = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$400(DefaultPlaybackSessionManager$SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor) {
        return defaultPlaybackSessionManager$SessionDescriptor.isActive;
    }

    public static /* synthetic */ boolean access$402(DefaultPlaybackSessionManager$SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor, boolean bl2) {
        defaultPlaybackSessionManager$SessionDescriptor.isActive = bl2;
        return bl2;
    }

    public static /* synthetic */ MediaSource$MediaPeriodId access$500(DefaultPlaybackSessionManager$SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor) {
        return defaultPlaybackSessionManager$SessionDescriptor.adMediaPeriodId;
    }

    private int resolveWindowIndexToNewTimeline(Timeline object, Timeline timeline, int n10) {
        int n11 = ((Timeline)object).getWindowCount();
        int n12 = -1;
        if (n10 >= n11) {
            int n13 = timeline.getWindowCount();
            if (n10 >= n13) {
                n10 = n12;
            }
            return n10;
        }
        Object object2 = DefaultPlaybackSessionManager.access$600(this.this$0);
        ((Timeline)object).getWindow(n10, (Timeline$Window)object2);
        Timeline$Window timeline$Window = DefaultPlaybackSessionManager.access$600(this.this$0);
        n10 = timeline$Window.firstPeriodIndex;
        while (true) {
            object2 = DefaultPlaybackSessionManager.access$600(this.this$0);
            n11 = ((Timeline$Window)object2).lastPeriodIndex;
            if (n10 > n11) break;
            object2 = ((Timeline)object).getUidOfPeriod(n10);
            n11 = timeline.getIndexOfPeriod(object2);
            if (n11 != n12) {
                object = DefaultPlaybackSessionManager.access$700(this.this$0);
                return timeline.getPeriod((int)n11, (Timeline$Period)object).windowIndex;
            }
            ++n10;
        }
        return n12;
    }

    public boolean belongsToSession(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        int n11;
        int n12;
        boolean bl2 = true;
        if (mediaSource$MediaPeriodId == null) {
            int n13 = this.windowIndex;
            if (n10 != n13) {
                bl2 = false;
            }
            return bl2;
        }
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = this.adMediaPeriodId;
        if (mediaSource$MediaPeriodId2 == null) {
            long l10;
            long l11;
            long l12;
            n10 = (int)(mediaSource$MediaPeriodId.isAd() ? 1 : 0);
            if (n10 != 0 || (n10 = (int)((l12 = (l11 = mediaSource$MediaPeriodId.windowSequenceNumber) - (l10 = this.windowSequenceNumber)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0) {
                bl2 = false;
            }
            return bl2;
        }
        long l13 = mediaSource$MediaPeriodId.windowSequenceNumber;
        long l14 = mediaSource$MediaPeriodId2.windowSequenceNumber;
        long l15 = l13 - l14;
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object != false || (object = (Object)mediaSource$MediaPeriodId.adGroupIndex) != (n12 = mediaSource$MediaPeriodId2.adGroupIndex) || (n11 = mediaSource$MediaPeriodId.adIndexInAdGroup) != (n10 = mediaSource$MediaPeriodId2.adIndexInAdGroup)) {
            bl2 = false;
        }
        return bl2;
    }

    public boolean isFinishedAtEventTime(AnalyticsListener$EventTime object) {
        boolean bl2;
        block11: {
            boolean bl3;
            block12: {
                long l10 = this.windowSequenceNumber;
                long l11 = -1;
                long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                bl2 = false;
                if (l12 == false) {
                    return false;
                }
                Object object2 = ((AnalyticsListener$EventTime)object).mediaPeriodId;
                bl3 = true;
                if (object2 == null) {
                    int n10 = this.windowIndex;
                    int n11 = ((AnalyticsListener$EventTime)object).windowIndex;
                    if (n10 != n11) {
                        bl2 = bl3;
                    }
                    return bl2;
                }
                long l13 = ((MediaPeriodId)object2).windowSequenceNumber;
                long l14 = l13 - l10;
                Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object3 > 0) {
                    return bl3;
                }
                Object object4 = this.adMediaPeriodId;
                if (object4 == null) {
                    return false;
                }
                object4 = ((AnalyticsListener$EventTime)object).timeline;
                Object object5 = ((MediaPeriodId)object2).periodUid;
                object3 = ((Timeline)object4).getIndexOfPeriod(object5);
                object5 = ((AnalyticsListener$EventTime)object).timeline;
                object2 = this.adMediaPeriodId.periodUid;
                int n12 = ((Timeline)object5).getIndexOfPeriod(object2);
                object2 = ((AnalyticsListener$EventTime)object).mediaPeriodId;
                l13 = ((MediaPeriodId)object2).windowSequenceNumber;
                MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.adMediaPeriodId;
                long l15 = mediaSource$MediaPeriodId.windowSequenceNumber;
                long l16 = l13 - l15;
                Object object6 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object6 < 0 || object3 < n12) break block11;
                if (object3 > n12) {
                    return bl3;
                }
                object3 = ((MediaPeriodId)object2).isAd();
                if (object3 != false) {
                    object = ((AnalyticsListener$EventTime)object).mediaPeriodId;
                    object3 = ((MediaPeriodId)object).adGroupIndex;
                    int n13 = ((MediaPeriodId)object).adIndexInAdGroup;
                    object5 = this.adMediaPeriodId;
                    l12 = ((MediaPeriodId)object5).adGroupIndex;
                    if (object3 > l12 || object3 == l12 && n13 > (object3 = (Object)((MediaPeriodId)object5).adIndexInAdGroup)) {
                        bl2 = bl3;
                    }
                    return bl2;
                }
                object = ((AnalyticsListener$EventTime)object).mediaPeriodId;
                int n14 = ((MediaPeriodId)object).nextAdGroupIndex;
                object3 = -1;
                if (n14 == object3) break block12;
                object4 = this.adMediaPeriodId;
                object3 = ((MediaPeriodId)object4).adGroupIndex;
                if (n14 <= object3) break block11;
            }
            bl2 = bl3;
        }
        return bl2;
    }

    public void maybeSetWindowSequenceNumber(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        long l10 = this.windowSequenceNumber;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false && n10 == (object = (Object)this.windowIndex) && mediaSource$MediaPeriodId != null) {
            long l13;
            this.windowSequenceNumber = l13 = mediaSource$MediaPeriodId.windowSequenceNumber;
        }
    }

    public boolean tryResolvingToNewTimeline(Timeline object, Timeline timeline) {
        boolean bl2;
        int n10;
        int bl22 = this.windowIndex;
        this.windowIndex = n10 = this.resolveWindowIndexToNewTimeline((Timeline)object, timeline, bl22);
        boolean bl3 = false;
        int n11 = -1;
        if (n10 == n11) {
            return false;
        }
        object = this.adMediaPeriodId;
        boolean bl4 = true;
        if (object == null) {
            return bl4;
        }
        object = ((MediaPeriodId)object).periodUid;
        n10 = timeline.getIndexOfPeriod(object);
        if (n10 != n11) {
            bl2 = bl4;
        }
        return bl2;
    }
}

