/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.ads.AdPlaybackState$AdGroup;
import com.google.android.exoplayer2.util.Util;

public final class Timeline$Period {
    private AdPlaybackState adPlaybackState;
    public long durationUs;
    public Object id;
    private long positionInWindowUs;
    public Object uid;
    public int windowIndex;

    public Timeline$Period() {
        AdPlaybackState adPlaybackState;
        this.adPlaybackState = adPlaybackState = AdPlaybackState.NONE;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        int n10;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (n10 = (object3 = Timeline$Period.class).equals(object2 = object.getClass())) != 0) {
            boolean bl3;
            long l10;
            long l11;
            long l12;
            long l13;
            int n11;
            object = (Timeline$Period)object;
            object3 = this.id;
            object2 = ((Timeline$Period)object).id;
            n10 = Util.areEqual(object3, object2);
            if (n10 == 0 || (n10 = Util.areEqual(object3 = this.uid, object2 = ((Timeline$Period)object).uid)) == 0 || (n10 = this.windowIndex) != (n11 = ((Timeline$Period)object).windowIndex) || (n10 = (int)((l13 = (l12 = this.durationUs) - (l11 = ((Timeline$Period)object).durationUs)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0 || (n10 = (int)((l10 = (l12 = this.positionInWindowUs) - (l11 = ((Timeline$Period)object).positionInWindowUs)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0 || !(bl3 = Util.areEqual(object3 = this.adPlaybackState, object = ((Timeline$Period)object).adPlaybackState))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getAdCountInAdGroup(int n10) {
        return this.adPlaybackState.adGroups[n10].count;
    }

    public long getAdDurationUs(int n10, int n11) {
        Object object;
        AdPlaybackState$AdGroup[] adPlaybackState$AdGroupArray = this.adPlaybackState.adGroups;
        Object object2 = adPlaybackState$AdGroupArray[n10];
        int n12 = ((AdPlaybackState$AdGroup)object2).count;
        int n13 = -1;
        if (n12 != n13) {
            object2 = ((AdPlaybackState$AdGroup)object2).durationsUs;
            object = object2[n11];
        } else {
            object = -9223372036854775807L;
        }
        return object;
    }

    public int getAdGroupCount() {
        return this.adPlaybackState.adGroupCount;
    }

    public int getAdGroupIndexAfterPositionUs(long l10) {
        AdPlaybackState adPlaybackState = this.adPlaybackState;
        long l11 = this.durationUs;
        return adPlaybackState.getAdGroupIndexAfterPositionUs(l10, l11);
    }

    public int getAdGroupIndexForPositionUs(long l10) {
        AdPlaybackState adPlaybackState = this.adPlaybackState;
        long l11 = this.durationUs;
        return adPlaybackState.getAdGroupIndexForPositionUs(l10, l11);
    }

    public long getAdGroupTimeUs(int n10) {
        return this.adPlaybackState.adGroupTimesUs[n10];
    }

    public long getAdResumePositionUs() {
        return this.adPlaybackState.adResumePositionUs;
    }

    public Object getAdsId() {
        return this.adPlaybackState.adsId;
    }

    public long getDurationMs() {
        return C.usToMs(this.durationUs);
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public int getFirstAdIndexToPlay(int n10) {
        return this.adPlaybackState.adGroups[n10].getFirstAdIndexToPlay();
    }

    public int getNextAdIndexToPlay(int n10, int n11) {
        return this.adPlaybackState.adGroups[n10].getNextAdIndexToPlay(n11);
    }

    public long getPositionInWindowMs() {
        return C.usToMs(this.positionInWindowUs);
    }

    public long getPositionInWindowUs() {
        return this.positionInWindowUs;
    }

    public boolean hasPlayedAdGroup(int n10) {
        return this.adPlaybackState.adGroups[n10].hasUnplayedAds() ^ true;
    }

    public int hashCode() {
        int n10;
        Object object = this.id;
        int n11 = 0;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        int n12 = (217 + n10) * 31;
        object = this.uid;
        if (object != null) {
            n11 = object.hashCode();
        }
        n12 = (n12 + n11) * 31;
        n10 = this.windowIndex;
        n12 = (n12 + n10) * 31;
        long l10 = this.durationUs;
        int n13 = 32;
        long l11 = l10 >>> n13;
        n10 = (int)(l10 ^ l11);
        n12 = (n12 + n10) * 31;
        l10 = this.positionInWindowUs;
        long l12 = l10 >>> n13;
        n10 = (int)(l10 ^ l12);
        n12 = (n12 + n10) * 31;
        n10 = this.adPlaybackState.hashCode();
        return n12 + n10;
    }

    public Timeline$Period set(Object object, Object object2, int n10, long l10, long l11) {
        AdPlaybackState adPlaybackState = AdPlaybackState.NONE;
        return this.set(object, object2, n10, l10, l11, adPlaybackState);
    }

    public Timeline$Period set(Object object, Object object2, int n10, long l10, long l11, AdPlaybackState adPlaybackState) {
        this.id = object;
        this.uid = object2;
        this.windowIndex = n10;
        this.durationUs = l10;
        this.positionInWindowUs = l11;
        this.adPlaybackState = adPlaybackState;
        return this;
    }
}

