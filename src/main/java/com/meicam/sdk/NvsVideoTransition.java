/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsFx;
import com.meicam.sdk.NvsUtils;

public class NvsVideoTransition
extends NvsFx {
    public static final int VIDEO_TRANSITION_DURATION_MATCH_MODE_NONE = 0;
    public static final int VIDEO_TRANSITION_DURATION_MATCH_MODE_STRETCH = 1;
    public static final int VIDEO_TRANSITION_TYPE_BUILTIN = 0;
    public static final int VIDEO_TRANSITION_TYPE_CUSTOM = 2;
    public static final int VIDEO_TRANSITION_TYPE_PACKAGE = 1;

    private native void nativeEnableTimelineTransition(long var1, boolean var3);

    private native String nativeGetBuiltinVideoTransitionName(long var1);

    private native long nativeGetVideoTransitionDuration(long var1);

    private native int nativeGetVideoTransitionDurationMatchMode(long var1);

    private native float nativeGetVideoTransitionDurationScaleFactor(long var1);

    private native String nativeGetVideoTransitionPackageId(long var1);

    private native int nativeGetVideoTransitionType(long var1);

    private native boolean nativeIsTimelineTransitionEnabled(long var1);

    private native void nativeSetVideoTransitionDuration(long var1, long var3, int var5);

    private native void nativeSetVideoTransitionDurationScaleFactor(long var1, float var3);

    public void enableTimelineTransition(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeEnableTimelineTransition(l10, bl2);
    }

    public String getBuiltinVideoTransitionName() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetBuiltinVideoTransitionName(l10);
    }

    public long getVideoTransitionDuration() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetVideoTransitionDuration(l10);
    }

    public int getVideoTransitionDurationMatchMode() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetVideoTransitionDurationMatchMode(l10);
    }

    public float getVideoTransitionDurationScaleFactor() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetVideoTransitionDurationScaleFactor(l10);
    }

    public String getVideoTransitionPackageId() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetVideoTransitionPackageId(l10);
    }

    public int getVideoTransitionType() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetVideoTransitionType(l10);
    }

    public boolean isTimelineTransitionEnabled() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeIsTimelineTransitionEnabled(l10);
    }

    public void setVideoTransitionDuration(long l10, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        this.nativeSetVideoTransitionDuration(l11, l10, n10);
    }

    public void setVideoTransitionDurationScaleFactor(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetVideoTransitionDurationScaleFactor(l10, f10);
    }
}

