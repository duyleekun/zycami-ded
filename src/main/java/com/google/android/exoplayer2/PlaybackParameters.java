/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class PlaybackParameters {
    public static final PlaybackParameters DEFAULT;
    public final float pitch;
    private final int scaledUsPerMs;
    public final float speed;

    static {
        PlaybackParameters playbackParameters;
        DEFAULT = playbackParameters = new PlaybackParameters(1.0f);
    }

    public PlaybackParameters(float f10) {
        this(f10, 1.0f);
    }

    public PlaybackParameters(float f10, float f11) {
        int n10;
        int n11 = 0;
        float f12 = f10 - 0.0f;
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        boolean bl2 = true;
        f13 = f13 > 0 ? (float)bl2 : 0.0f;
        Assertions.checkArgument((boolean)f13);
        float f14 = f11 - 0.0f;
        n11 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (n11 <= 0) {
            bl2 = false;
        }
        Assertions.checkArgument(bl2);
        this.speed = f10;
        this.pitch = f11;
        this.scaledUsPerMs = n10 = Math.round(f10 * 1000.0f);
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<PlaybackParameters> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = PlaybackParameters.class) == (clazz = object.getClass())) {
            float f10;
            float f11;
            float f12;
            object = (PlaybackParameters)object;
            float f13 = this.speed;
            float f14 = ((PlaybackParameters)object).speed;
            float f15 = f13 - f14;
            Object object2 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
            if (object2 != false || (f12 = (f11 = (f13 = this.pitch) - (f10 = ((PlaybackParameters)object).pitch)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getMediaTimeUsForPlayoutTimeMs(long l10) {
        long l11 = this.scaledUsPerMs;
        return l10 * l11;
    }

    public int hashCode() {
        int n10 = Float.floatToRawIntBits(this.speed);
        int n11 = (527 + n10) * 31;
        n10 = Float.floatToRawIntBits(this.pitch);
        return n11 + n10;
    }

    public String toString() {
        Object[] objectArray = new Object[2];
        Float f10 = Float.valueOf(this.speed);
        objectArray[0] = f10;
        f10 = Float.valueOf(this.pitch);
        objectArray[1] = f10;
        return Util.formatInvariant("PlaybackParameters(speed=%.2f, pitch=%.2f)", objectArray);
    }

    public PlaybackParameters withSpeed(float f10) {
        float f11 = this.pitch;
        PlaybackParameters playbackParameters = new PlaybackParameters(f10, f11);
        return playbackParameters;
    }
}

