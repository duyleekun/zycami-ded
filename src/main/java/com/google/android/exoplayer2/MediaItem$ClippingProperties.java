/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.MediaItem$1;

public final class MediaItem$ClippingProperties {
    public final long endPositionMs;
    public final boolean relativeToDefaultPosition;
    public final boolean relativeToLiveWindow;
    public final long startPositionMs;
    public final boolean startsAtKeyFrame;

    private MediaItem$ClippingProperties(long l10, long l11, boolean bl2, boolean bl3, boolean bl4) {
        this.startPositionMs = l10;
        this.endPositionMs = l11;
        this.relativeToLiveWindow = bl2;
        this.relativeToDefaultPosition = bl3;
        this.startsAtKeyFrame = bl4;
    }

    public /* synthetic */ MediaItem$ClippingProperties(long l10, long l11, boolean bl2, boolean bl3, boolean bl4, MediaItem$1 mediaItem$1) {
        this(l10, l11, bl2, bl3, bl4);
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3;
        long l10;
        boolean bl4 = true;
        if (this == object) {
            return bl4;
        }
        Object object2 = object instanceof MediaItem$ClippingProperties;
        if (!object2) {
            return false;
        }
        object = (MediaItem$ClippingProperties)object;
        long l11 = this.startPositionMs;
        long l12 = ((MediaItem$ClippingProperties)object).startPositionMs;
        long l13 = l11 - l12;
        object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 || (object2 = (l10 = (l11 = this.endPositionMs) - (l12 = ((MediaItem$ClippingProperties)object).endPositionMs)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) || (object2 = this.relativeToLiveWindow) != (bl3 = ((MediaItem$ClippingProperties)object).relativeToLiveWindow) || (object2 = this.relativeToDefaultPosition) != (bl3 = ((MediaItem$ClippingProperties)object).relativeToDefaultPosition) || (object2 = this.startsAtKeyFrame) != (bl2 = ((MediaItem$ClippingProperties)object).startsAtKeyFrame)) {
            bl4 = false;
        }
        return bl4;
    }

    public int hashCode() {
        long l10 = this.startPositionMs;
        int n10 = 32;
        long l11 = l10 >>> n10;
        int n11 = (int)(l10 ^ l11) * 31;
        l11 = this.endPositionMs;
        int n12 = (int)(l11 >>> n10 ^ l11);
        n11 = (n11 + n12) * 31;
        n12 = (int)(this.relativeToLiveWindow ? 1 : 0);
        n11 = (n11 + n12) * 31;
        n12 = (int)(this.relativeToDefaultPosition ? 1 : 0);
        n11 = (n11 + n12) * 31;
        n12 = (int)(this.startsAtKeyFrame ? 1 : 0);
        return n11 + n12;
    }
}

