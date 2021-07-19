/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsUtils;

public class NvsParticleSystemContext {
    private long m_contextInterface;

    private native void nativeAppendPositionToEmitterPositionCurve(long var1, String var3, float var4, float var5, float var6);

    private native void nativeCleanup(long var1);

    private native void nativeSetEmitterEnabled(long var1, String var3, boolean var4);

    private native void nativeSetEmitterParticleSizeGain(long var1, String var3, float var4);

    private native void nativeSetEmitterPosition(long var1, String var3, float var4, float var5);

    private native void nativeSetEmitterRateGain(long var1, String var3, float var4);

    public void appendPositionToEmitterPositionCurve(String string2, float f10, float f11, float f12) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeAppendPositionToEmitterPositionCurve(l10, string2, f10, f11, f12);
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

    public void setEmitterEnabled(String string2, boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeSetEmitterEnabled(l10, string2, bl2);
    }

    public void setEmitterParticleSizeGain(String string2, float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeSetEmitterParticleSizeGain(l10, string2, f10);
    }

    public void setEmitterPosition(String string2, float f10, float f11) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeSetEmitterPosition(l10, string2, f10, f11);
    }

    public void setEmitterRateGain(String string2, float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        this.nativeSetEmitterRateGain(l10, string2, f10);
    }
}

