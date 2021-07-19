/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsFx;
import com.meicam.sdk.NvsUtils;

public class NvsAudioFx
extends NvsFx {
    private native String nativeGetBuiltinAudioFxName(long var1);

    private native int nativeGetIndex(long var1);

    private native boolean nativeIsCustomAudioFx(long var1);

    public String getBuiltinAudioFxName() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetBuiltinAudioFxName(l10);
    }

    public int getIndex() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetIndex(l10);
    }

    public boolean isCustomAudioFx() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeIsCustomAudioFx(l10);
    }
}

