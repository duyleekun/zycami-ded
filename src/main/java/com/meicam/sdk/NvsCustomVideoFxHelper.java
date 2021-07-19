/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsCustomVideoFx$RenderHelper;
import com.meicam.sdk.NvsUtils;

public class NvsCustomVideoFxHelper
implements NvsCustomVideoFx$RenderHelper {
    private long m_internalObject;

    private native int nativeAllocateRGBATexture(long var1, int var3, int var4);

    private native void nativeReclaimTexture(long var1, int var3);

    public int allocateRGBATexture(int n10, int n11) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeAllocateRGBATexture(l10, n10, n11);
    }

    public void reclaimTexture(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeReclaimTexture(l10, n10);
    }
}

