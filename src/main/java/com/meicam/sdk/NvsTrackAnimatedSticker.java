/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsAnimatedSticker;
import com.meicam.sdk.NvsUtils;

public class NvsTrackAnimatedSticker
extends NvsAnimatedSticker {
    private native long nativeChangeTrackInPoint(long var1, long var3);

    private native long nativeChangeTrackOutPoint(long var1, long var3);

    private native boolean nativeGetTrackClipAffinityEnabled(long var1);

    private native long nativeGetTrackInPoint(long var1);

    private native long nativeGetTrackOutPoint(long var1);

    private native void nativeMoveTrackPosition(long var1, long var3);

    private native void nativeSetTrackClipAffinityEnabled(long var1, boolean var3);

    public long changeInPoint(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeChangeTrackInPoint(l11, l10);
    }

    public long changeOutPoint(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeChangeTrackOutPoint(l11, l10);
    }

    public boolean getClipAffinityEnabled() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTrackClipAffinityEnabled(l10);
    }

    public long getInPoint() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTrackInPoint(l10);
    }

    public long getOutPoint() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTrackOutPoint(l10);
    }

    public void movePosition(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        this.nativeMoveTrackPosition(l11, l10);
    }

    public void setClipAffinityEnabled(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetTrackClipAffinityEnabled(l10, bl2);
    }
}

