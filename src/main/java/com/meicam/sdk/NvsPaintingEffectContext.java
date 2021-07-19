/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsColor;
import com.meicam.sdk.NvsUtils;

public class NvsPaintingEffectContext {
    public static final int STROKE_ANALOG_TYPE_COS = 3;
    public static final int STROKE_ANALOG_TYPE_INVERT_COS = 4;
    public static final int STROKE_ANALOG_TYPE_INVERT_SIN = 1;
    public static final int STROKE_ANALOG_TYPE_POSITIVE_COS = 5;
    public static final int STROKE_ANALOG_TYPE_POSITIVE_SIN = 2;
    public static final int STROKE_ANALOG_TYPE_SIN = 0;
    public static final int STROKE_CAP_STYLE_FLAT = 0;
    public static final int STROKE_CAP_STYLE_ITALIC = 3;
    public static final int STROKE_CAP_STYLE_ROUND = 2;
    public static final int STROKE_CAP_STYLE_SQUARE = 1;
    public static final int STROKE_FILL_MODE_GRADIENT = 0;
    public static final int STROKE_FILL_MODE_TEXTURE = 1;
    public static final int STROKE_JOINT_STYLE_BEVEL = 0;
    public static final int STROKE_JOINT_STYLE_MITER = 1;
    public static final int STROKE_JOINT_STYLE_ROUND = 2;
    public static final int STROKE_TEXTURE_WARP_CLAMP = 0;
    public static final int STROKE_TEXTURE_WARP_MIRRORED_REPEAT = 2;
    public static final int STROKE_TEXTURE_WARP_REPEAT = 1;
    private long m_contextInterface;

    private native void nativeAddStroke(long var1, float[] var3);

    private native void nativeAppendStroke(long var1, float[] var3);

    private native void nativeCleanup(long var1);

    private native void nativeRemoveAllStroke(long var1);

    private native void nativeRemoveLastStroke(long var1);

    private native void nativeSetStrokeAnalogAmplitude(long var1, float var3);

    private native void nativeSetStrokeAnalogPeriod(long var1, float var3);

    private native void nativeSetStrokeAnalogType(long var1, int var3);

    private native void nativeSetStrokeAnimated(long var1, boolean var3);

    private native void nativeSetStrokeAnimationSpeed(long var1, float var3);

    private native void nativeSetStrokeCapStyle(long var1, int var3);

    private native void nativeSetStrokeFillMode(long var1, int var3);

    private native void nativeSetStrokeGradient(long var1, NvsColor var3);

    private native void nativeSetStrokeJointStyle(long var1, int var3);

    private native void nativeSetStrokeTextureFilePath(long var1, String var3);

    private native void nativeSetStrokeTextureRepeatTimes(long var1, int var3, int var4);

    private native void nativeSetStrokeTextureWarpType(long var1, int var3);

    private native void nativeSetStrokeWidth(long var1, float var3);

    public void AddStroke(float[] fArray) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeAddStroke(l10, fArray);
    }

    public void AppendStroke(float[] fArray) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeAppendStroke(l10, fArray);
    }

    public void RemoveAllStroke() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeRemoveAllStroke(l10);
    }

    public void RemoveLastStroke() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeRemoveLastStroke(l10);
    }

    public void SetStrokeAnalogAmplitude(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeSetStrokeAnalogAmplitude(l10, f10);
    }

    public void SetStrokeAnalogPeriod(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeSetStrokeAnalogPeriod(l10, f10);
    }

    public void SetStrokeAnalogType(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeSetStrokeAnalogType(l10, n10);
    }

    public void SetStrokeAnimated(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeSetStrokeAnimated(l10, bl2);
    }

    public void SetStrokeAnimationSpeed(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeSetStrokeAnimationSpeed(l10, f10);
    }

    public void SetStrokeCapStyle(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeSetStrokeCapStyle(l10, n10);
    }

    public void SetStrokeFillMode(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeSetStrokeFillMode(l10, n10);
    }

    public void SetStrokeGradient(NvsColor nvsColor) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeSetStrokeGradient(l10, nvsColor);
    }

    public void SetStrokeJointStyle(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeSetStrokeJointStyle(l10, n10);
    }

    public void SetStrokeTextureFilePath(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeSetStrokeTextureFilePath(l10, string2);
    }

    public void SetStrokeTextureRepeatTimes(int n10, int n11) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeSetStrokeTextureRepeatTimes(l10, n10, n11);
    }

    public void SetStrokeTextureWarpType(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeSetStrokeTextureWarpType(l10, n10);
    }

    public void SetStrokeWidth(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeSetStrokeWidth(l10, f10);
    }

    public void finalize() {
        long l10 = this.m_contextInterface;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.nativeCleanup(l10);
            this.m_contextInterface = l11;
        }
        super.finalize();
    }

    public void setContextInterface(long l10) {
        this.m_contextInterface = l10;
    }
}

