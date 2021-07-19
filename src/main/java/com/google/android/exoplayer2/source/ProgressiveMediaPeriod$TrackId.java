/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

public final class ProgressiveMediaPeriod$TrackId {
    public final int id;
    public final boolean isIcyTrack;

    public ProgressiveMediaPeriod$TrackId(int n10, boolean bl2) {
        this.id = n10;
        this.isIcyTrack = bl2;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<ProgressiveMediaPeriod$TrackId> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = ProgressiveMediaPeriod$TrackId.class) == (clazz = object.getClass())) {
            int n10;
            object = (ProgressiveMediaPeriod$TrackId)object;
            int n11 = this.id;
            int n12 = ((ProgressiveMediaPeriod$TrackId)object).id;
            if (n11 != n12 || (n11 = (int)(this.isIcyTrack ? 1 : 0)) != (n10 = ((ProgressiveMediaPeriod$TrackId)object).isIcyTrack)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.id * 31;
        int n11 = this.isIcyTrack;
        return n10 + n11;
    }
}

