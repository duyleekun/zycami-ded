/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsCaption;
import com.meicam.sdk.NvsUtils;

public class NvsCaptureCaption
extends NvsCaption {
    private native long nativeCaptureChangeDuration(long var1, long var3);

    private native long nativeCaptureChangeOffsetPoint(long var1, long var3);

    private native long nativeCaptureGetDuration(long var1);

    private native long nativeCaptureGetOffsetPoint(long var1);

    private native void nativeCaptureResetStartTime(long var1);

    public long changeDuration(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeCaptureChangeDuration(l11, l10);
    }

    public long changeOffsetPoint(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeCaptureChangeOffsetPoint(l11, l10);
    }

    public long getDuration() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeCaptureGetDuration(l10);
    }

    public long getOffsetPoint() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeCaptureGetOffsetPoint(l10);
    }

    public void resetStartTime() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeCaptureResetStartTime(l10);
    }
}

