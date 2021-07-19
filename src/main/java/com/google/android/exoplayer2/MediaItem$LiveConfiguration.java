/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

public final class MediaItem$LiveConfiguration {
    public static final MediaItem$LiveConfiguration UNSET;
    public final long maxOffsetMs;
    public final float maxPlaybackSpeed;
    public final long minOffsetMs;
    public final float minPlaybackSpeed;
    public final long targetOffsetMs;

    static {
        MediaItem$LiveConfiguration mediaItem$LiveConfiguration;
        UNSET = mediaItem$LiveConfiguration = new MediaItem$LiveConfiguration(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, -3.4028235E38f, -3.4028235E38f);
    }

    public MediaItem$LiveConfiguration(long l10, long l11, long l12, float f10, float f11) {
        this.targetOffsetMs = l10;
        this.minOffsetMs = l11;
        this.maxOffsetMs = l12;
        this.minPlaybackSpeed = f10;
        this.maxPlaybackSpeed = f11;
    }

    public boolean equals(Object object) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        long l10;
        long l11;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        Object object2 = object instanceof MediaItem$LiveConfiguration;
        if (!object2) {
            return false;
        }
        object = (MediaItem$LiveConfiguration)object;
        long l12 = this.targetOffsetMs;
        long l13 = ((MediaItem$LiveConfiguration)object).targetOffsetMs;
        long l14 = l12 - l13;
        object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 || (object2 = (l11 = (l12 = this.minOffsetMs) - (l13 = ((MediaItem$LiveConfiguration)object).minOffsetMs)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) || (object2 = (l10 = (l12 = this.maxOffsetMs) - (l13 = ((MediaItem$LiveConfiguration)object).maxOffsetMs)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) || (object2 = (f15 = (f14 = this.minPlaybackSpeed) - (f13 = ((MediaItem$LiveConfiguration)object).minPlaybackSpeed)) == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1)) || (f12 = (f11 = (f14 = this.maxPlaybackSpeed) - (f10 = ((MediaItem$LiveConfiguration)object).maxPlaybackSpeed)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false) {
            bl2 = false;
        }
        return bl2;
    }

    public int hashCode() {
        long l10 = this.targetOffsetMs;
        int n10 = 32;
        long l11 = l10 >>> n10;
        int n11 = (int)(l10 ^= l11) * 31;
        l11 = this.minOffsetMs;
        long l12 = l11 >>> n10;
        int n12 = (int)(l11 ^ l12);
        n11 = (n11 + n12) * 31;
        l11 = this.maxOffsetMs;
        long l13 = l11 >>> n10 ^ l11;
        n12 = (int)l13;
        n11 = (n11 + n12) * 31;
        float f10 = this.minPlaybackSpeed;
        n10 = 0;
        float f11 = f10 - 0.0f;
        float f12 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        int n13 = 0;
        if (f12 != false) {
            n12 = Float.floatToIntBits(f10);
        } else {
            n12 = 0;
            f10 = 0.0f;
        }
        n11 = (n11 + n12) * 31;
        f10 = this.maxPlaybackSpeed;
        float f13 = f10 - 0.0f;
        n10 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
        if (n10 != 0) {
            n13 = Float.floatToIntBits(f10);
        }
        return n11 + n13;
    }
}

