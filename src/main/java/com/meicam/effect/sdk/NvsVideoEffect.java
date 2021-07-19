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

public class NvsVideoEffect
extends NvsEffect {
    public static final int VIDEOFX_TYPE_BUILTIN = 0;
    public static final int VIDEOFX_TYPE_CUSTOM = 2;
    public static final int VIDEOFX_TYPE_PACKAGE = 1;

    private native String nativeGetBuiltinVideoFxName(long var1);

    private native String nativeGetVideoFxPackageId(long var1);

    private native int nativeGetVideoFxType(long var1);

    private native PointF nativeMapPointFromCanonicalToParticleSystem(long var1, NvsVideoResolution var3, PointF var4);

    public String getBuiltinVideoFxName() {
        long l10 = this.m_internalObject;
        return this.nativeGetBuiltinVideoFxName(l10);
    }

    public String getVideoFxPackageId() {
        long l10 = this.m_internalObject;
        return this.nativeGetVideoFxPackageId(l10);
    }

    public int getVideoFxType() {
        long l10 = this.m_internalObject;
        return this.nativeGetVideoFxType(l10);
    }

    public PointF mapPointFromCanonicalToParticleSystem(NvsVideoResolution nvsVideoResolution, PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeMapPointFromCanonicalToParticleSystem(l10, nvsVideoResolution, pointF);
    }
}

