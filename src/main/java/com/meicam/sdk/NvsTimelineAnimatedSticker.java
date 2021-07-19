/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsAnimatedSticker;
import com.meicam.sdk.NvsUtils;

public class NvsTimelineAnimatedSticker
extends NvsAnimatedSticker {
    private native long nativeChangeInPoint(long var1, long var3);

    private native long nativeChangeOutPoint(long var1, long var3);

    private native boolean nativeGetClipAffinityEnabled(long var1);

    private native long nativeGetInPoint(long var1);

    private native long nativeGetOutPoint(long var1);

    private native void nativeMovePosition(long var1, long var3);

    private native void nativeSetClipAffinityEnabled(long var1, boolean var3);

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

    public boolean getClipAffinityEnabled() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetClipAffinityEnabled(l10);
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

    public void movePosition(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        this.nativeMovePosition(l11, l10);
    }

    public void setClipAffinityEnabled(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetClipAffinityEnabled(l10, bl2);
    }
}

