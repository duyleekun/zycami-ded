/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultLivePlaybackSpeedControl;
import com.google.android.exoplayer2.util.Assertions;

public final class DefaultLivePlaybackSpeedControl$Builder {
    private float fallbackMaxPlaybackSpeed = 1.03f;
    private float fallbackMinPlaybackSpeed = 0.97f;
    private long maxLiveOffsetErrorUsForUnitSpeed;
    private float minPossibleLiveOffsetSmoothingFactor;
    private long minUpdateIntervalMs = 1000L;
    private float proportionalControlFactorUs = 1.0E-7f;
    private long targetLiveOffsetIncrementOnRebufferUs;

    public DefaultLivePlaybackSpeedControl$Builder() {
        long l10;
        this.maxLiveOffsetErrorUsForUnitSpeed = l10 = C.msToUs(20);
        this.targetLiveOffsetIncrementOnRebufferUs = l10 = C.msToUs(500L);
        this.minPossibleLiveOffsetSmoothingFactor = 0.999f;
    }

    public DefaultLivePlaybackSpeedControl build() {
        float f10 = this.fallbackMinPlaybackSpeed;
        float f11 = this.fallbackMaxPlaybackSpeed;
        long l10 = this.minUpdateIntervalMs;
        float f12 = this.proportionalControlFactorUs;
        long l11 = this.maxLiveOffsetErrorUsForUnitSpeed;
        long l12 = this.targetLiveOffsetIncrementOnRebufferUs;
        float f13 = this.minPossibleLiveOffsetSmoothingFactor;
        DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl = new DefaultLivePlaybackSpeedControl(f10, f11, l10, f12, l11, l12, f13, null);
        return defaultLivePlaybackSpeedControl;
    }

    public DefaultLivePlaybackSpeedControl$Builder setFallbackMaxPlaybackSpeed(float f10) {
        float f11 = 1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object >= 0) {
            object = true;
            f11 = Float.MIN_VALUE;
        } else {
            object = false;
            f11 = 0.0f;
        }
        Assertions.checkArgument((boolean)object);
        this.fallbackMaxPlaybackSpeed = f10;
        return this;
    }

    public DefaultLivePlaybackSpeedControl$Builder setFallbackMinPlaybackSpeed(float f10) {
        float f11;
        float f12 = 0.0f;
        float f13 = 0.0f - f10;
        Object object = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        if (object < 0 && (object = (f11 = f10 - (f12 = 1.0f)) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) <= 0) {
            object = true;
            f12 = Float.MIN_VALUE;
        } else {
            object = false;
            f12 = 0.0f;
        }
        Assertions.checkArgument((boolean)object);
        this.fallbackMinPlaybackSpeed = f10;
        return this;
    }

    public DefaultLivePlaybackSpeedControl$Builder setMaxLiveOffsetErrorMsForUnitSpeed(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        Assertions.checkArgument((boolean)object);
        this.maxLiveOffsetErrorUsForUnitSpeed = l10 = C.msToUs(l10);
        return this;
    }

    public DefaultLivePlaybackSpeedControl$Builder setMinPossibleLiveOffsetSmoothingFactor(float f10) {
        float f11;
        float f12 = 0.0f;
        float f13 = f10 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object >= 0 && (object = (f11 = f10 - (f12 = 1.0f)) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) < 0) {
            object = true;
            f12 = Float.MIN_VALUE;
        } else {
            object = false;
            f12 = 0.0f;
        }
        Assertions.checkArgument((boolean)object);
        this.minPossibleLiveOffsetSmoothingFactor = f10;
        return this;
    }

    public DefaultLivePlaybackSpeedControl$Builder setMinUpdateIntervalMs(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        Assertions.checkArgument((boolean)object);
        this.minUpdateIntervalMs = l10;
        return this;
    }

    public DefaultLivePlaybackSpeedControl$Builder setProportionalControlFactor(float f10) {
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        object = object > 0 ? (Object)true : (Object)false;
        Assertions.checkArgument((boolean)object);
        this.proportionalControlFactorUs = f10 /= 1000000.0f;
        return this;
    }

    public DefaultLivePlaybackSpeedControl$Builder setTargetLiveOffsetIncrementOnRebufferMs(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object >= 0 ? (Object)1 : (Object)0;
        Assertions.checkArgument((boolean)object);
        this.targetLiveOffsetIncrementOnRebufferUs = l10 = C.msToUs(l10);
        return this;
    }
}

