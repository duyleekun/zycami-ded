/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

public final class AdaptiveTrackSelection$AdaptationCheckpoint {
    public final long allocatedBandwidth;
    public final long totalBandwidth;

    public AdaptiveTrackSelection$AdaptationCheckpoint(long l10, long l11) {
        this.totalBandwidth = l10;
        this.allocatedBandwidth = l11;
    }

    public boolean equals(Object object) {
        long l10;
        long l11;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        Object object2 = object instanceof AdaptiveTrackSelection$AdaptationCheckpoint;
        if (!object2) {
            return false;
        }
        object = (AdaptiveTrackSelection$AdaptationCheckpoint)object;
        long l12 = this.totalBandwidth;
        long l13 = ((AdaptiveTrackSelection$AdaptationCheckpoint)object).totalBandwidth;
        long l14 = l12 - l13;
        object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 || (l11 = (l10 = (l12 = this.allocatedBandwidth) - (l13 = ((AdaptiveTrackSelection$AdaptationCheckpoint)object).allocatedBandwidth)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            bl2 = false;
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = (int)this.totalBandwidth * 31;
        int n11 = (int)this.allocatedBandwidth;
        return n10 + n11;
    }
}

