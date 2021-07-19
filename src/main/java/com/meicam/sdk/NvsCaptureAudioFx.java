/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsFx;
import com.meicam.sdk.NvsUtils;

public class NvsCaptureAudioFx
extends NvsFx {
    private native String nativeGetBuiltinCaptureAudioFxName(long var1);

    private native int nativeGetIndex(long var1);

    public String getBuiltinCaptureAudioFxName() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetBuiltinCaptureAudioFxName(l10);
    }

    public int getIndex() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetIndex(l10);
    }
}

