/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.meicam.sdk;

import android.graphics.PointF;
import com.meicam.sdk.NvsFx;
import com.meicam.sdk.NvsUtils;

public class NvsVideoFx
extends NvsFx {
    public static final int VIDEOFX_TYPE_BUILTIN = 0;
    public static final int VIDEOFX_TYPE_CUSTOM = 2;
    public static final int VIDEOFX_TYPE_PACKAGE = 1;

    private native String nativeGetBuiltinVideoFxName(long var1);

    private native int nativeGetIndex(long var1);

    private native String nativeGetVideoFxPackageId(long var1);

    private native int nativeGetVideoFxType(long var1);

    private native PointF nativeMapPointFromCanonicalToParticleSystem(long var1, PointF var3);

    public String getBuiltinVideoFxName() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetBuiltinVideoFxName(l10);
    }

    public int getIndex() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetIndex(l10);
    }

    public String getVideoFxPackageId() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetVideoFxPackageId(l10);
    }

    public int getVideoFxType() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetVideoFxType(l10);
    }

    public PointF mapPointFromCanonicalToParticleSystem(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeMapPointFromCanonicalToParticleSystem(l10, pointF);
    }
}

