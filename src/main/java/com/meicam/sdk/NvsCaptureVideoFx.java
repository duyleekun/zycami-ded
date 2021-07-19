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

public class NvsCaptureVideoFx
extends NvsFx {
    public static final int CAPTURE_VIDEOFX_TYPE_BUILTIN = 0;
    public static final int CAPTURE_VIDEOFX_TYPE_CUSTOM = 2;
    public static final int CAPTURE_VIDEOFX_TYPE_PACKAGE = 1;

    private native String nativeGetBuiltinCaptureVideoFxName(long var1);

    private native String nativeGetCaptureVideoFxPackageId(long var1);

    private native int nativeGetCaptureVideoFxType(long var1);

    private native int nativeGetIndex(long var1);

    private native PointF nativeMapPointFromImageCoordToParticeSystemCoord(long var1, int var3, int var4, PointF var5);

    public String getBuiltinCaptureVideoFxName() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetBuiltinCaptureVideoFxName(l10);
    }

    public String getCaptureVideoFxPackageId() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCaptureVideoFxPackageId(l10);
    }

    public int getCaptureVideoFxType() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCaptureVideoFxType(l10);
    }

    public int getIndex() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetIndex(l10);
    }

    public PointF mapPointFromImageCoordToParticeSystemCoord(int n10, int n11, PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeMapPointFromImageCoordToParticeSystemCoord(l10, n10, n11, pointF);
    }
}

