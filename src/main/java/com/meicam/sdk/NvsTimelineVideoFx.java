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

public class NvsTimelineVideoFx
extends NvsFx {
    public static final int TIMELINE_VIDEOFX_TYPE_BUILTIN = 0;
    public static final int TIMELINE_VIDEOFX_TYPE_CUSTOM = 2;
    public static final int TIMELINE_VIDEOFX_TYPE_PACKAGE = 1;

    private native long nativeChangeInPoint(long var1, long var3);

    private native long nativeChangeOutPoint(long var1, long var3);

    private native String nativeGetBuiltinTimelineVideoFxName(long var1);

    private native long nativeGetInPoint(long var1);

    private native long nativeGetOutPoint(long var1);

    private native String nativeGetTimelineVideoFxPackageId(long var1);

    private native int nativeGetTimelineVideoFxType(long var1);

    private native float nativeGetZValue(long var1);

    private native PointF nativeMapPointFromCanonicalToParticleSystem(long var1, PointF var3);

    private native void nativeMovePosition(long var1, long var3);

    private native void nativeSetZValue(long var1, float var3);

    public long changeInPoint(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeChangeInPoint(l11, l10);
    }

    public long changeOutPoint(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeChangeOutPoint(l11, l10);
    }

    public String getBuiltinTimelineVideoFxName() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetBuiltinTimelineVideoFxName(l10);
    }

    public long getInPoint() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetInPoint(l10);
    }

    public long getOutPoint() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetOutPoint(l10);
    }

    public String getTimelineVideoFxPackageId() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTimelineVideoFxPackageId(l10);
    }

    public int getTimelineVideoFxType() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTimelineVideoFxType(l10);
    }

    public float getZValue() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetZValue(l10);
    }

    public PointF mapPointFromCanonicalToParticleSystem(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeMapPointFromCanonicalToParticleSystem(l10, pointF);
    }

    public void movePosition(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        this.nativeMovePosition(l11, l10);
    }

    public void setZValue(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetZValue(l10, f10);
    }
}

