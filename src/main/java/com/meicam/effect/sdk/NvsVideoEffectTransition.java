/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.meicam.effect.sdk;

import android.graphics.PointF;
import com.meicam.effect.sdk.NvsEffect;
import com.meicam.sdk.NvsUtils;
import com.meicam.sdk.NvsVideoResolution;

public class NvsVideoEffectTransition
extends NvsEffect {
    public static final int VIDEO_EFFECT_TRANSITION_TYPE_BUILTIN = 0;
    public static final int VIDEO_EFFECT_TRANSITION_TYPE_PACKAGE = 1;

    private native String nativeGetBuiltinVideoTransitionName(long var1);

    private native long nativeGetVideoTransitionDuration(long var1);

    private native String nativeGetVideoTransitionPackageId(long var1);

    private native int nativeGetVideoTransitionType(long var1);

    private native PointF nativeMapPointFromCanonicalToParticleSystem(long var1, NvsVideoResolution var3, PointF var4);

    private native void nativeSetVideoTransitionDuration(long var1, long var3);

    public String getBuiltinVideoTransitionName() {
        long l10 = this.m_internalObject;
        return this.nativeGetBuiltinVideoTransitionName(l10);
    }

    public long getVideoTransitionDuration() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetVideoTransitionDuration(l10);
    }

    public String getVideoTransitionPackageId() {
        long l10 = this.m_internalObject;
        return this.nativeGetVideoTransitionPackageId(l10);
    }

    public int getVideoTransitionType() {
        long l10 = this.m_internalObject;
        return this.nativeGetVideoTransitionType(l10);
    }

    public PointF mapPointFromCanonicalToParticleSystem(NvsVideoResolution nvsVideoResolution, PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeMapPointFromCanonicalToParticleSystem(l10, nvsVideoResolution, pointF);
    }

    public void setVideoTransitionDuration(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        this.nativeSetVideoTransitionDuration(l11, l10);
    }
}

